package kr.co.ch08.security;

import kr.co.ch08.entity.User;
import lombok.Builder;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

@Data
@Builder
public class MyUserDetails implements UserDetails {

    private User user;
    /*
        3. MyUserDetails는 UserDetails 인터페이스를 구현한 사용자 인증 객체
         해당 사용자가 가진 권한을 반환. UserDetails 객체는 사용자 정보를 저장하는 객체인데,
         이 getAuthorities() 메서드는 사용자의 권한 정보를 반환
     */
    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // 권한 목록 생성
        List<GrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + user.getRole())); // 계정 권한 앞에 접두어 ROLE_ 붙여야 됨
        return authorities;
    }

    @Override
    public String getPassword() {
        return user.getPass();
    }

    @Override
    public String getUsername() {
        return user.getUid();
    }

    @Override
    public boolean isAccountNonExpired() {
        // 계정 만료 여부(true : 만료안됨, false : 만료됨)
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        // 계정 잠김 여부
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // 비밀번호 만료 여부
        return true;
    }

    @Override
    public boolean isEnabled() {
        // 계정 활성화 여부
        return true;
    }
}
