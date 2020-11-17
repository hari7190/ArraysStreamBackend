package stream.arrays.backend.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import stream.arrays.backend.security.AuthenticationRequest;
import stream.arrays.backend.security.AuthenticationResponse;
import stream.arrays.backend.security.MyUserDetailsService;
import stream.arrays.backend.security.util.JwtTokenUtil;

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
            jws = jwtTokenUtil.generateToken(myUserDetailsService.loadUserByUsername(authenticationRequest.getUsername()));
        } catch (BadCredentialsException e){
            throw new Exception("Invalid Credentials", e);
        }

        return new AuthenticationResponse(jws);
    }

}
