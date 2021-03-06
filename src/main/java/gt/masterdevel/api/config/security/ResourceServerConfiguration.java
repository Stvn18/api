package gt.masterdevel.api.config.security;

import gt.masterdevel.api.config.filters.CustomAuthenticationFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.context.request.async.WebAsyncManagerIntegrationFilter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Configuration
@EnableResourceServer
public class ResourceServerConfiguration extends ResourceServerConfigurerAdapter {

    @Bean
    public AuthenticationEntryPoint unauthorizedAccess() {
        return (HttpServletRequest request, HttpServletResponse response, AuthenticationException authException)
                -> response.sendError(HttpServletResponse.SC_UNAUTHORIZED);
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
                .authorizeRequests()
                .antMatchers(HttpMethod.PUT, "/credential").permitAll();

        httpSecurity
                .addFilterBefore(new CustomAuthenticationFilter(), WebAsyncManagerIntegrationFilter.class);

    }

}
