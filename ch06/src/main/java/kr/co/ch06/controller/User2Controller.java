package kr.co.ch06.controller;

import kr.co.ch06.dto.User1DTO;
import kr.co.ch06.dto.User2DTO;
import kr.co.ch06.service.User2Service;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.List;

@Slf4j
@Controller
@AllArgsConstructor
public class User2Controller {

    private final User2Service user2Service;

    @GetMapping("/user2/list")
    public String list(Model model){
        List<User2DTO> user2List = user2Service.selectAllUser2();
        model.addAttribute("user2List", user2List);
        return "/user2/list";
    }

    @GetMapping("/user2/register")
    public String register(){
        return "/user2/register";
    }

    @PostMapping("/user2/register")
    public String registerUser2(User2DTO user2DTO) {
        user2Service.insertUser2(user2DTO);
        return "redirect:/user2/list";
    }

    @GetMapping("/user2/modify")
    public String modify(String uid, Model model){
        User2DTO user2DTO = user2Service.selectUser2(uid);
        model.addAttribute("user2DTO", user2DTO);
        return "/user2/modify";
    }

    @PostMapping("/user2/modify")
    public String modify(User2DTO user2DTO) {
        user2Service.updateUser2(user2DTO);
        return "redirect:/user2/list";
    }

    @GetMapping("/user2/delete")
    public String delete(String uid) {
        user2Service.deleteUser2(uid);
        return "redirect:/user2/list";
    }



}
