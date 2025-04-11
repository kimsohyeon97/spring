package kr.co.ch10.controller;

import kr.co.ch10.dto.UserDTO;
import kr.co.ch10.entity.User;
import kr.co.ch10.jwt.JwtProvider;
import kr.co.ch10.security.MyUserDetails;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@Slf4j
@RequiredArgsConstructor
@RestController
public class UserController {

    private final AuthenticationManager authenticationManager;
    private final JwtProvider jwtProvider;

    // 처음 로그인 후, 토큰 발행되고 postman으로 토큰만 인증 -> jwtAuthenticaitonFilter 통과
    @GetMapping("/user")
    public ResponseEntity<User> user(Authentication authentication) {

        log.info("authentication : {}", authentication);

        User user = (User) authentication.getPrincipal();
        log.info("user : {}", user);

        return ResponseEntity.ok().body(user);
    }

    // 처음 로그인 할때 -> jwtPorvider로 토큰 생성 받음
    @PostMapping("/user/login")
    public ResponseEntity login(@RequestBody UserDTO userDTO){

        try {
            // 1️⃣ security 인증 토큰 생성 (사용자가 입력한 ID, 비밀번호 기반)
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(userDTO.getUid(), userDTO.getPass());

            // 2️⃣ Security의 AuthenticationManager를 이용하여 인증 처리(아이디와 비밀번호를 가지고 실질적인 사용자 DB조회)
            Authentication authentication = authenticationManager.authenticate(authToken);
            log.info("authentication : {}", authentication);

            // 3️⃣ 인증된 사용자 정보 가져오기
            MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
            User user = myUserDetails.getUser();
            log.info("user : {}", user);

            // 4️⃣ JWT 토큰 생성 (Access 1일, Refresh 7일)
            String accessToken = jwtProvider.createToken(user, 1); // 1일
            String refreshToken = jwtProvider.createToken(user, 7); // 7일
            log.info("access token : {}", accessToken);
            log.info("refresh token : {}", refreshToken);

            // Refresh DB 저장(생략)

            // 5️⃣ 클라이언트에게 토큰 반환
            Map<String, Object> tokenMap = new HashMap<>();
            tokenMap.put("access_token", accessToken);
            tokenMap.put("refresh_token", refreshToken);

            return ResponseEntity
                    .ok()
                    .body(tokenMap);

        }catch(Exception e){
            // 인증 실패 ( 로그인 실패)
            log.error(e.getMessage());
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body("user not found");
        }
    }
}
