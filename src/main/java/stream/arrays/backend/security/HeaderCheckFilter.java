package stream.arrays.backend.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.WebAuthenticationDetailsSource;
import org.springframework.stereotype.Component;
import org.springframework.web.filter.OncePerRequestFilter;
import stream.arrays.backend.security.util.JwtTokenUtil;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@Component
public class HeaderCheckFilter extends OncePerRequestFilter {
    private String SECRET_KEY = "C463EF8C148328F7635295D23DCECC463EF8C148328F7635295D23DCEC";

    @Autowired
    JwtTokenUtil jwtTokenUtil;

    @Autowired
    MyUserDetailsService myUserDetailsService;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {
        String authHeader = request.getHeader("Authorization");
        if (SecurityContextHolder.getContext().getAuthentication() == null && authHeader != null && authHeader.startsWith("ASTREAM ")){
            String jwts = authHeader.split(" ")[1];
            System.out.println(jwts);
            String username = jwtTokenUtil.extractUsername(jwts);
            UserDetails userDetails = myUserDetailsService.loadUserByUsername(username);

            if(jwtTokenUtil.validateToken(jwts, userDetails)) {
                UsernamePasswordAuthenticationToken usernamePasswordAuthenticationToken = new UsernamePasswordAuthenticationToken(userDetails.getUsername(), userDetails.getPassword());
                usernamePasswordAuthenticationToken.setDetails(new WebAuthenticationDetailsSource().buildDetails(request));
                SecurityContextHolder.getContext().setAuthentication(usernamePasswordAuthenticationToken);
            }
        }
        filterChain.doFilter(request, response);
    }
}
