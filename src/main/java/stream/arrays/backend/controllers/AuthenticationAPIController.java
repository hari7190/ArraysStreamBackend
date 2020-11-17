package stream.arrays.backend.controllers;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stream.arrays.backend.security.AuthenticationRequest;
import stream.arrays.backend.security.AuthenticationResponse;
import stream.arrays.backend.security.MyUserDetailsService;
import stream.arrays.backend.security.util.JwtTokenUtil;

import java.security.Key;

@RestController
@RequestMapping("/authenticate")
public class AuthenticationAPIController {

    @Autowired
    private JwtTokenUtil jwtTokenUtil;

    @Autowired
    private MyUserDetailsService myUserDetailsService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @PostMapping
    public AuthenticationResponse createNewJWT(@RequestBody AuthenticationRequest authenticationRequest) throws Exception {
        String jws;
        try {
            Authentication authentication = new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword());
            jws = jwtTokenUtil.generateToken(myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername()));
        } catch (BadCredentialsException e){
            throw new Exception("Invalid Credentials", e);
        }

        return new AuthenticationResponse(jws);
    }

}
