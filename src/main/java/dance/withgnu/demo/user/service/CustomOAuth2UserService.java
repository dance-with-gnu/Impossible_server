package dance.withgnu.demo.user.service;

import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import dance.withgnu.demo.util.AppleJwtUtil;
import org.springframework.security.oauth2.client.userinfo.DefaultOAuth2UserService;
import org.springframework.security.oauth2.client.userinfo.OAuth2UserRequest;
import org.springframework.security.oauth2.core.user.DefaultOAuth2User;
import org.springframework.security.oauth2.core.user.OAuth2User;
import org.springframework.security.oauth2.core.OAuth2AuthenticationException;
import org.springframework.stereotype.Service;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Collections;
import java.util.Map;
import java.util.HashMap;

@Service
public class CustomOAuth2UserService extends DefaultOAuth2UserService {

    @Override
    public OAuth2User loadUser(OAuth2UserRequest userRequest) throws OAuth2AuthenticationException {
        OAuth2User oAuth2User = super.loadUser(userRequest);
        String registrationId = userRequest.getClientRegistration().getRegistrationId();
        Map<String, Object> attributes = oAuth2User.getAttributes();
        System.out.println("TEST");
        if ("apple".equals(registrationId)) {
            // Apple OAuth2 사용자 정보 처리
            String teamId = "6332BXK582";
            String clientId = "com.dancewithgnu.impossible";
            String keyId = "85NJ8FGM3D";
            String privateKeyPem = "";

            try {
                // resources 디렉토리의 AuthKey.p8 파일을 읽어옵니다.
                privateKeyPem = new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("AuthKey.p8").toURI())));
            } catch (Exception e) {
                throw new RuntimeException("Error reading private key file", e);
            }

            // JWT 토큰 생성
            String clientSecret = AppleJwtUtil.createJwtToken(teamId, clientId, keyId, privateKeyPem);
            System.out.println("Generated JWT Token: " + clientSecret);

            // 생성된 JWT 토큰을 client-secret으로 사용
            userRequest.getAdditionalParameters().put("client_secret", clientSecret);

            Map<String, Object> appleAttributes = new HashMap<>();

            // JWT에서 사용자 정보를 파싱합니다.
            String idToken = userRequest.getAdditionalParameters().get("id_token").toString();
            DecodedJWT decodedJWT = JWT.decode(idToken);

            appleAttributes.put("sub", decodedJWT.getSubject());
            appleAttributes.put("email", decodedJWT.getClaim("email").asString());
            appleAttributes.put("name", decodedJWT.getClaim("name").asString());

            attributes = appleAttributes;
        }

        // 'name' 속성이 없으면 'nickname'을 사용하거나 기본값 설정
        String nameAttributeKey = userRequest.getClientRegistration().getProviderDetails().getUserInfoEndpoint().getUserNameAttributeName();

        if (!attributes.containsKey(nameAttributeKey)) {
            if (attributes.containsKey("nickname")) {
                nameAttributeKey = "nickname";
            } else {
                attributes.put("name", "Unknown");
                nameAttributeKey = "name";
            }
        }

        return new DefaultOAuth2User(
                Collections.singleton(new SimpleGrantedAuthority("ROLE_USER")),
                attributes,
                nameAttributeKey
        );
    }
}
