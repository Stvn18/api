package gt.masterdevel.api.config.security;

import org.springframework.security.authentication.AbstractAuthenticationToken;
import org.springframework.security.core.userdetails.User;

import java.util.Collections;

public class CustomAuthenticationToken extends AbstractAuthenticationToken {

    private static final long serialVersionUID = -1949976839306453197L;
    private User authenticatedUser;
    private String signal;

    public CustomAuthenticationToken(String signal){
        super(Collections.emptyList());
        this.signal = signal;
    }

    @Override
    public Object getCredentials() {
        return authenticatedUser.getPassword();
    }

    @Override
    public Object getPrincipal() {
        return authenticatedUser;
    }

}
