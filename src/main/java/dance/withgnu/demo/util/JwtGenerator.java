package dance.withgnu.demo.util;

public class JwtGenerator {
    public static String generateClientSecret(String teamId, String clientId, String keyId, String privateKeyPem) {
        return AppleJwtUtil.createJwtToken(teamId, clientId, keyId, privateKeyPem);
    }
}
