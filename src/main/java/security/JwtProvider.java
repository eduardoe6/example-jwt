package security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {

    private static final String TOKEN_KEY = "%$#--abc666-66**#%%@";

    public String generateToken(Authentication auth) {
        var userDetails = (UserAuthDetails) auth.getPrincipal();

        var creationTime = new Date();
        var expirationTime = new Date(creationTime.getTime() + (1000 * 60 * 60 * 24 * 100));

        return Jwts.builder()
                .setSubject(userDetails.getUsername())
                .setIssuedAt(creationTime)
                .setExpiration(expirationTime)
                .signWith(SignatureAlgorithm.HS512, TOKEN_KEY)
                .compact();
    }

    public String getUserFromToken(String token) {
        return Jwts.parser() // Gets the token conversion object
                .setSigningKey(TOKEN_KEY) // Defines the key used to decrypt the token
                .parseClaimsJws(token) // Converts the token
                .getBody() // Gets the token payload
                .getSubject(); // Gets the username from the token

    }

    public boolean isTokenValid(String token) {

        // Tries to convert the token, if it gets an exception,
        // it means the token is not valid
        try {
            Jwts.parser().setSigningKey(TOKEN_KEY).parseClaimsJws(token);
        } catch (Exception e) {
            return false;
        }

        return true;
    }
}
