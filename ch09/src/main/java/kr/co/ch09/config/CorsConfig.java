package kr.co.ch09.config;  // 패키지 선언

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration  // Spring Boot 설정 클래스임을 의미
public class CorsConfig implements WebMvcConfigurer { // WebMvcConfigurer 구현 (CORS 설정 추가 가능)

    @Override
    public void addCorsMappings(CorsRegistry registry) {

        registry.addMapping("/**")  // 모든 URL 패턴에 대해 CORS 허용
                .allowedOriginPatterns("http://127.0.0.1:5500") // 허용할 프론트엔드 도메인 지정
                .allowedMethods("GET", "POST", "PUT", "DELETE", "OPTIONS") // 허용할 HTTP 메서드 지정
                .allowedHeaders("*") // 모든 요청 헤더 허용
                .allowCredentials(true) // 인증정보(쿠키, 세션) 포함 허용
                .maxAge(3600); // 1시간(3600초) 동안 CORS 설정을 캐싱
    }
}
