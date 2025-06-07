# Spring

### 1️⃣ Spring 개요 및 개발환경 구축 실습

#### IntelliJ 기본 설정
1. New UI 설정
File > Settings > Appearance > Compact mode / Show main menu

2. 대소문자 구분 비활성화
File > Settings > Editor > Code Completion > Match case 해제

3. 메서드 접힘 비활성화
File > Settings > Editor > Code Folding > One-line methods 해제

4. 마우스 휠 줌 활성화
File > Settings > Editor > Mouse Control > Change font size with... 체크

---

### 2️⃣ Spring IoC / DI 실습

Spring의 IoC (제어의 역전) 및 DI (의존성 주입) 개념 실습

| 어노테이션            | 설명                                                  |
| ---------------- | --------------------------------------------------- |
| `@Configuration` | 빈 설정용 클래스 지정                                        |
| `@Bean`          | 수동 등록: 컨테이너에 객체(빈) 등록                               |
| `@ComponentScan` | 자동 스캔: `@Component`, `@Service`, `@Repository` 등 탐지 |
| `@Autowired`     | 의존성 자동 주입 (필드, 생성자, 세터)                             |
| `@Component`     | 일반 컴포넌트 등록                                          |
| `@Service`       | 서비스 계층 의미 부여                                        |
| `@Repository`    | DAO/저장소 계층 의미 부여                                    |

1. 수동 Bean 등록 (@Bean)
* Hello, Welcome, Greeting 클래스 수동 등록 후 사용

2. 자동 Bean 등록 (@ComponentScan)
* Computer 클래스가 Cpu, Ram, Hdd를 자동으로 주입받음
* 다양한 방식의 DI 사용 (필드 주입, 생성자 주입, 세터 주입)

---

### 3️⃣ Spring AOP 실습

### 주요 개념
**JoinPoint (조인포인트)**
→ AOP가 적용될 수 있는 모든 메서드 지점 (예: 서비스 메서드 실행 지점)

**PointCut (포인트컷)**
→ 어떤 메서드에 AOP를 적용할지 지정하는 조건 (ex. 메서드명, 패키지 등)

**Advice (어드바이스)**
→ 실제 실행되는 부가기능 코드 (ex. 로그 출력, 트랜잭션 처리 등)

**Aspect (애스펙트)**
→ PointCut과 Advice를 하나로 묶은 AOP 단위 모듈

**Weaving (위빙)**
→ 핵심 기능 실행 지점에 부가기능을 결합하는 과정 (실행 시점에 삽입됨)

### 어드바이스 종류
* @Before : 핵심 기능 실행 전 부가기능 수행
* @After : 핵심 기능 실행 후 항상 수행
* @AfterReturning : 핵심 기능이 정상적으로 끝난 뒤 수행
* @AfterThrowing : 핵심 기능에서 예외 발생 시 수행
* @Around : 핵심 기능을 전후로 감싸서 실행 제어 (가장 강력)

---

### 4️⃣ Spring MVC 실습

Spring MVC 구조를 이해하고, DispatcherServlet 기반의 CRUD 기능 구현 실습을 통해 웹 애플리케이션의 흐름을 실습합니다.

* Spring MVC 기반 CRUD 웹 애플리케이션 설계 및 구현
* Java Config 기반 설정 사용 (XML 설정 없이 구성)

### 주요 기능
* Spring MVC 설정 (AppConfig, WebAppInitializer)
* JDBC + DBCP2 + MySQL 연동 (JdbcTemplate)
* 사용자 CRUD (User1Controller, User1Service, User1DAO)
* View 구성: list.jsp, register.jsp, modify.jsp

---

### 5️⃣ Spring AOP 실습

### 주요 기능
* 사용자 목록 조회
* 사용자 등록
* 사용자 수정
* 사용자 삭제

### Config
* AppConfig: Spring MVC 설정, 뷰 리졸버 & 정적 리소스 등록
* JdbcConfig: DataSource 및 JdbcTemplate 설정
* MybatisConfig: MyBatis SQLSession 설정
* MyWebAppInitializer: WebApplicationInitializer로 DispatcherServlet 등록

### Controller & Service
* User1Controller: 사용자 관련 요청 처리 (GET/POST)
* User1Service: 비즈니스 로직 처리
* User1Mapper: MyBatis Mapper 인터페이스
* mapper/User1Mapper.xml: SQL 정의

---

### 6️⃣ Spring Boot + MyBatis

* application.properties에서 DB 및 서버 포트 설정
* MyBatis 매퍼 XML 파일 사용

### 주요기능
* /sub1/* : 정적 페이지 매핑 (hello, welcome, greeting)
* /sub2/thymeleaf : Thymeleaf를 이용한 데이터 바인딩 및 화면 출력
* User CRUD 기능 (MyBatis 매퍼와 서비스 레이어 포함)

---

### 7️⃣ QueryDSL 실습

Spring Boot, Spring Data JPA, Thymeleaf, QueryDSL을 사용하여 사용자 정보를 관리하는 CRUD 애플리케이션

### QueryDSL 설정 개요
- QueryDSLConfig 클래스에서 EntityManager를 주입받고 JPAQueryFactory를 Bean으로 등록
- 이 설정을 통해 서비스 계층이나 커스텀 레포지토리 구현에서 QueryDSL의 Q타입을 사용해 동적 SQL 작성이 가능

### 주요기능
#### 사용자 등록(Register)
- /user1/register 경로를 통해 사용자 정보를 입력받아 DB에 저장

#### 사용자 목록 조회(List)
- /user1/list 경로를 통해 전체 사용자 정보를 조회하고, HTML 테이블로 표시

#### 사용자 정보 수정(Modify)
- /user1/modify?uid=사용자ID 경로로 기존 데이터를 불러와 수정

#### 사용자 삭제(Delete)
- /user1/delete?uid=사용자ID 요청을 통해 해당 사용자를 삭제

#### QueryDSL 설정 (Q타입 자동 생성 및 사용 기반 준비)
- QueryDSLConfig.java 파일을 통해 JPAQueryFactory를 Bean으로 등록함으로써 QueryDSL 기반의 동적 쿼리 사용을 준비
- 이 설정을 통해 추후 조건 기반 검색, 복잡한 Join 조건 작성 등이 용이해짐

---

### 8️⃣ Spring Security 실습
Spring Security를 활용하여 사용자 인증(Authentication)과 권한 인가(Authorization)를 구현한 웹 애플리케이션 실습입니다.

#### 보안 설정 (SecurityConfig)
- @EnableMethodSecurity(prePostEnabled = true)를 통해 메서드 단위 권한 제어 활성화
- 사용자 인증 및 권한 인가 설정을 SecurityFilterChain에서 구성
- 로그인 페이지 커스터마이징 (/user/login)
- 로그인 성공/실패 리다이렉트 설정
- 로그아웃 시 세션 무효화 및 리다이렉션
- 각 URL에 대한 역할 기반 접근 제어 설정
- CSRF 비활성화 (http.csrf().disable())
- 비밀번호는 BCryptPasswordEncoder를 이용한 안전한 해시 방식으로 저장

#### 사용자 인증 (UserDetailsService)
- 사용자 인증을 위해 MyUserDetailsService 클래스에서 UserDetailsService를 구현
- 로그인 시 사용자의 ID를 기반으로 DB에서 사용자 조회 후 MyUserDetails 객체 반환
- MyUserDetails는 Spring Security가 내부적으로 사용하는 사용자 인증 객체로, 권한 및 계정 상태 정보를 포함

#### 사용자 권한 인가 (MyUserDetails)
- 사용자 권한 정보는 ROLE_ 접두어를 붙여 GrantedAuthority로 설정
- 예: user.getRole()이 "ADMIN"이면, "ROLE_ADMIN"으로 등록
- hasRole() 또는 hasAnyRole() 방식으로 접근 제어 가능

#### 회원가입 및 로그인
- /user/register: 사용자 등록 폼
- /user/login: 커스텀 로그인 페이지
- 회원가입 시 비밀번호는 암호화되어 저장되고, 로그인 시 인증 객체에 사용자 정보가 담김
- 로그인 후 /user/info에서 인증된 사용자 정보를 확인 가능

#### 핵심 보안 포인트
- 인증 객체(Authentication)는 SecurityContextHolder에 저장되며, 전역에서 접근 가능
- 인증된 사용자의 정보를 조회하려면 authentication.getPrincipal() 사용
- 모든 권한 체크는 메서드 레벨(@PreAuthorize) 또는 URL 패턴으로 이중 확인

---

### 9️⃣ CORS 실습
- CORS (Cross-Origin Resource Sharing): 다른 출처(origin) 간 자원 공유를 허용하는 보안 정책
- Spring에서 CORS 허용을 위해 WebMvcConfigurer 인터페이스의 addCorsMappings() 메서드를 재정의
- 주요 설정:
  - addMapping("/**"): 모든 URL 경로 허용
  - allowedOrigins("http://127.0.0.1:5500"): 해당 도메인에서 오는 요청만 허용
  - allowedMethods(...): 허용할 HTTP 메서드 지정 (GET, POST 등)
  - allowedHeaders("*"): 모든 요청 헤더 허용
  - allowCredentials(true): 쿠키/인증 정보 허용
  - maxAge(3600): Pre-flight 요청 캐시 시간 설정 (1시간)

---

### 🔟 JWT 기반 Spring Security 로그인 기능 실습

#### 주요기능 흐름
#### 1. 로그인 요청 (POST /user/login)
- 사용자가 uid, pass를 JSON 형식으로 전송
- AuthenticationManager를 통해 사용자 인증 진행
- 인증 성공 시 access_token, refresh_token을 발급 및 응답으로 전달

#### 2. JWT 토큰 발급
- JwtProvider.createToken()에서 JWT 생성
- 토큰에 username, role, issuedAt, expiration 정보 포함

#### 3. 요청 시 토큰 검사 (필터 작동)
- 모든 요청마다 JwtAuthenticationFilter가 실행되어 Authorization 헤더에서 토큰 추출
- JwtProvider.validateToken()에서 유효성 검사
- 유효하면 Authentication 객체를 만들어 SecurityContext에 저장

#### 4. 인증된 사용자 정보 확인 (GET /user)
- 인증된 사용자의 User 정보를 반환

