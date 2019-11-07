package security;

import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {

    public String generateToken(Authentication auth){
        var userDetails = (UserAuthDetails) auth.getPrincipal();
    }

}
