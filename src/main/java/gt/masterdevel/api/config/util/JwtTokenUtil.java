package gt.masterdevel.api.config.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;

public class JwtTokenUtil {
    private static final String SHARED_SECRET = "p@s5w0R$";

    public String signToken(String parameters) {
        return Jwts.builder().setSubject(parameters)
                .signWith(SignatureAlgorithm.HS256, SHARED_SECRET).compact();
    }

    public Boolean validateToken(String token1, String token2) {
        return token1.equals(token2);
    }

}
