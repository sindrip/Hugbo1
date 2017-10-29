package is.hi.hirslan.security;


        import io.jsonwebtoken.Claims;
        import io.jsonwebtoken.Jwts;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
        import org.springframework.security.core.GrantedAuthority;
        import org.springframework.security.core.authority.SimpleGrantedAuthority;
        import org.springframework.security.core.context.SecurityContextHolder;
        import org.springframework.security.core.userdetails.User;
        import org.springframework.security.web.authentication.www.BasicAuthenticationFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
        import javax.servlet.http.Cookie;
        import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
        import java.util.Arrays;
        import java.util.Collection;
        import java.util.List;
        import java.util.stream.Collectors;

        import static is.hi.hirslan.security.SecurityConstants.*;

public class JWTAuthorizationFilter extends BasicAuthenticationFilter {

    public JWTAuthorizationFilter(AuthenticationManager authManager) {
        super(authManager);
    }

    @Override
    protected void doFilterInternal(HttpServletRequest req, HttpServletResponse res, FilterChain chain)
            throws IOException, ServletException {
        String token;
        try {
            token = Arrays.stream(req.getCookies())
                    .filter(c -> c.getName().equals(HEADER_STRING))
                    .findFirst()
                    .map(Cookie::getValue)
                    .orElse(null);
         } catch (Exception e) {
            chain.doFilter(req, res);
            return;
        }

        if (token == null || !token.startsWith(TOKEN_PREFIX)) {
            chain.doFilter(req, res);
            return;
        }

        UsernamePasswordAuthenticationToken authentication = getAuthentication(req);

        SecurityContextHolder.getContext().setAuthentication(authentication);
        chain.doFilter(req, res);
    }

    private UsernamePasswordAuthenticationToken getAuthentication(HttpServletRequest req) {
        String token = Arrays.stream(req.getCookies())
                .filter(c -> c.getName().equals(HEADER_STRING))
                .findFirst()
                .map(Cookie::getValue)
                .orElse(null);

        if (token != null) {
            // parse the token.
            String username;
            Collection<? extends SimpleGrantedAuthority> grantedAuths;
            try {
                Claims claims = Jwts.parser()
                        .setSigningKey(SECRET.getBytes())
                        .parseClaimsJws(token.replace(TOKEN_PREFIX, ""))
                        .getBody();

                grantedAuths = Arrays.asList(claims.get(AUTHORITIES_KEY)
                        .toString().split(",")).stream()
                        .map(authority -> new SimpleGrantedAuthority(authority
                                .replace("[", "")
                                .replace("]", ""))
                        )
                        .collect(Collectors.toList());

                username = claims.getSubject();

            } catch (Exception e) {
                return null;
            }

            if (username != null) {
                return new UsernamePasswordAuthenticationToken(username, null, grantedAuths);
            }
            return null;
        }
        return null;
    }
}