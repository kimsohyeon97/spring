package kr.co.ch08.controller;

import kr.co.ch08.dto.UserDTO;
import kr.co.ch08.entity.User;
import kr.co.ch08.repository.UserRepository;
import kr.co.ch08.security.MyUserDetails;
import kr.co.ch08.service.UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Slf4j
@RequiredArgsConstructor
@Controller
public class UserController {

    private final UserService service;

    @GetMapping("/user/login")
    public String login(){
        return "/user/login";
    }

    @GetMapping("/user/register")
    public String register(){
        return "/user/register";
    }

    @PostMapping("/user/register")
    public String register(UserDTO userDTO){

        log.info("userDTO : {} ", userDTO);

        service.register(userDTO);
        return "redirect:/user/login";
    }


    // 인가 처리 어노테이션, getAuthorities()를 통해 ROLE_붙은 후 요청
    @GetMapping("/user/info")
    public String info(Model model){

        // 현재 인증된 사용자 정보를 가져오는 코드
        // Spring Security가 현재 인증 정보를 저장하고 있는 SecurityContextHolder 클래스에서 getContext()를 호출하면
        // SecurityContext를 가져오고, 그 안의 Authentication 객체를 통해 현재 인증된 사용자의 정보를 알 수 있음
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        log.info("authentication : {}", authentication);

        // getPrincipal()은 현재 인증된 사용자의 주체(Principal)를 반환.
        // Authentication 객체는 사용자의 인증 정보(아이디, 권한 등)를 포함.
        // 이 객체에서 getPrincipal()을 호출하면, 현재 인증된 사용자의 실제 정보를 담고 있는 객체가 반환.
        // 이때, 인증된 사용자 정보가 MyUserDetails 객체로 설정되어 있다고 가정
        MyUserDetails myUserDetails = (MyUserDetails) authentication.getPrincipal();
        User user = myUserDetails.getUser();
        log.info("user : {}", user);

        model.addAttribute(user);

        return "/user/info";
    }

}
