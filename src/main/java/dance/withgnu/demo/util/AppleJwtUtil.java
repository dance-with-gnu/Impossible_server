package dance.withgnu.demo.util;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

import java.io.StringReader;
import java.security.KeyFactory;
import java.security.PrivateKey;
import java.security.Security;
import java.security.interfaces.ECPrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.util.Date;

import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.bouncycastle.util.io.pem.PemObject;
import org.bouncycastle.util.io.pem.PemReader;

public class AppleJwtUtil {

    static {
        Security.addProvider(new BouncyCastleProvider());
    }

    public static String createJwtToken(String teamId, String clientId, String keyId, String privateKeyPem) {
        try {
            ECPrivateKey privateKey = getPrivateKeyFromPem(privateKeyPem);
            Algorithm algorithm = Algorithm.ECDSA256(null, privateKey);

            String jwtToken = JWT.create()
                    .withIssuer(teamId)
                    .withIssuedAt(new Date())
                    .withExpiresAt(new Date(System.currentTimeMillis() + 3600000)) // 1 hour
                    .withAudience("https://appleid.apple.com")
                    .withSubject(clientId)
                    .withKeyId(keyId)
                    .sign(algorithm);

            // JWT 토큰 출력
            System.out.println("Generated JWT Token: " + jwtToken);

            return jwtToken;
        } catch (Exception e) {
            throw new RuntimeException("Error creating JWT", e);
        }
    }

    private static ECPrivateKey getPrivateKeyFromPem(String pem) throws Exception {
        PemReader pemReader = new PemReader(new StringReader(pem));
        PemObject pemObject = pemReader.readPemObject();
        byte[] pemContent = pemObject.getContent();
        KeyFactory keyFactory = KeyFactory.getInstance("EC", "BC");
        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(pemContent);
        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
        return (ECPrivateKey) privateKey;
    }
}
