package kr.co.ch08.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

@EnableMethodSecurity(prePostEnabled = true)
@Configuration
public class SecurityConfig {

    @Bean
    public SecurityFilterChain configure(HttpSecurity http) throws Exception {

        // 로그인 설정
        /*
            1. formLogin() 메서드를 호출하면 Spring Security는 내부적으로 UsernamePasswordAuthenticationFilter를 자동으로 추가
                이 필터는 로그인 폼에서 제출된 아이디와 비밀번호를 Authentication 객체로 변환한 후 AuthenticationManager에게 전달
                AuthenticationManager는 해당 아이디와 비밀번호가 맞는지 검증하기 위해 AuthenticationProvider를 사용
         */
        http.formLogin(login -> login
                .loginPage("/user/login")   // [1] 커스텀 로그인 페이지 설정
                .defaultSuccessUrl("/")     // [2] 로그인 성공 시 이동할 URL, 원래 가려던 곳으로 이동
                .failureUrl("/user/login?code=100")  // [3] 로그인 실패 시 이동할 URL
                .usernameParameter("uid")       // [4] 로그인 아이디 파라미터 설정
                .passwordParameter("pass"));    // [5] 로그인 비밀번호 파라미터 설정

        // 로그아웃 설정
        http.logout(logout -> logout
                .logoutUrl("/user/logout")  // 로그아웃 URL
                .invalidateHttpSession(true)    // 세션 무효화
                .logoutSuccessUrl("/user/login?code=101")); // 로그아웃 성공 후 리다이렉트할 URL

        /*
            인가 설정
            - MyUserDetails 권한 목록 생성하는 메서드(getAuthorities)에서 접두어로 ROLE_입력해야 hasRole, hasAnyRole 권한 처리됨
            - Spring Security는 기본적으로 인가 페이지에 대해 login 페이지로 redirect
         */
        http.authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/").permitAll() // "/" 경로는 모든 사용자에게 허용
                .requestMatchers("/admin/**").hasRole("ADMIN") // ADMIN ROLE을 가지고 있는 사용자에게 admin 접근 모두 허용
                .requestMatchers("/manager/**").hasAnyRole("ADMIN", "MANAGER") // ADMIN, MANAGER ROLE을 가지고 있는 사용자에게
                .requestMatchers("/staff/**").hasAnyRole("ADMIN", "MANAGER", "STAFF") // ADMIN, MANAGER, STAFF ROLE
                .anyRequest().permitAll()); // 나머지 모든 요청도 허용

        // 기타 보안 설정
        http.csrf(AbstractHttpConfigurer::disable);

        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        // Security 암호화 인코더 설정
        return new BCryptPasswordEncoder();
    }



}
