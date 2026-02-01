package authservice.controller;

import authservice.dto.AuthRequestDto;
import authservice.dto.AuthResponseDto;
import authservice.dto.UserDto;
import lombok.AllArgsConstructor;
import org.jspecify.annotations.NonNull;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import authservice.service.JwtUtils;

@RestController
@AllArgsConstructor
public class AuthController {
    private final JwtUtils jwtUtils;
    private final AuthenticationManager authenticationManager;

    @PostMapping("/login")
    public ResponseEntity<@NonNull AuthResponseDto> login(@RequestBody @NonNull AuthRequestDto authRequestDto) {
        String username = authRequestDto.getUsername();
        String password = authRequestDto.getPassword();

        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password)
        );
        AuthResponseDto response = new AuthResponseDto();
        response.setToken(jwtUtils.generateToken(username));

        return ResponseEntity.ok(response);
    }
}