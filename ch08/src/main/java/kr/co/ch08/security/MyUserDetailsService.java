package kr.co.ch08.security;

import kr.co.ch08.entity.User;
import kr.co.ch08.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Slf4j
@RequiredArgsConstructor
@Service
public class MyUserDetailsService implements UserDetailsService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        log.info("username : {}", username);

        /*
           2. 사용자 조회 - 사용자가 입력한 아이디
              AuthenticationProvider는 아이디를 기반으로 UserDetailsService를 호출하여 loadUserByUsername() 메서드를 실행
         */
        Optional<User> optUser = userRepository.findById(username);

        if(optUser.isPresent()){
            /*
                3. MyUserDetails는 UserDetails 인터페이스를 구현한 사용자 인증 객체
                   Spring Security 사용자 인증객체 생성
             */
            MyUserDetails myUserDetails = MyUserDetails.builder()
                    .user(optUser.get())  //
                    .build();

            // Spring Security는 이 객체를 SecurityContextHolder에 저장하고, 이후에 인증된 사용자 정보를 필요한 곳에서 사용
            return myUserDetails;
        }

        return null;
    }
}
