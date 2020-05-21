package gt.masterdevel.api.config.filters;

import gt.masterdevel.api.config.security.CustomAuthenticationToken;
import gt.masterdevel.api.config.util.JwtTokenUtil;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.*;

public class CustomAuthenticationFilter extends OncePerRequestFilter {

    @Override
    protected void doFilterInternal(HttpServletRequest httpServletRequest,
                                    HttpServletResponse httpServletResponse,
                                    FilterChain filterChain
    ) throws ServletException, IOException {
        if (!validateAuthentication(httpServletRequest)) {
            httpServletResponse.setStatus(HttpServletResponse.SC_FORBIDDEN);
        } else {
            SecurityContextHolder.getContext().setAuthentication(
                    new CustomAuthenticationToken(httpServletRequest.getHeader("X-Signature")));
            filterChain.doFilter(httpServletRequest, httpServletResponse);
        }
    }

    private boolean validateAuthentication(HttpServletRequest httpServletRequest) {
        String xKey = httpServletRequest.getHeader("X-Key");
        String xRoute = httpServletRequest.getHeader("X-Route");
        String xSignature = httpServletRequest.getHeader("X-Signature");

        if ("/credential".equals(httpServletRequest.getRequestURI())
                && "PUT".compareToIgnoreCase(httpServletRequest.getMethod()) == 0
        ) {
            return true;
        }

        if (xKey == null || xRoute == null || xSignature == null) {
            return false;
        }

        if (!xRoute.contentEquals(httpServletRequest.getRequestURL())) {
            return false;
        }

        Map<String, Object> map = new HashMap<>();
        map.put("X-Route", xRoute);

        httpServletRequest.getParameterMap().keySet().forEach(key -> map.put(key, httpServletRequest.getParameterMap().get(key)));
        Map<String, Object> treeMap = new TreeMap<>(map);
        StringBuilder stringBuilder = new StringBuilder();

        treeMap.keySet().forEach(k -> stringBuilder.append(k).append(";").append(treeMap.get(k)));

        final JwtTokenUtil jwtTokenUtil = new JwtTokenUtil();
        return jwtTokenUtil.validateToken(jwtTokenUtil.signToken(stringBuilder.toString()), xSignature);
    }
}
