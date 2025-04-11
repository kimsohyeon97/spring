package kr.co.ch05.controller;

import kr.co.ch05.dto.User1DTO;
import kr.co.ch05.dto.User2DTO;
import kr.co.ch05.service.User1Service;
import kr.co.ch05.service.User2Service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class User2Controller {

    private final User2Service user2Service;
    private final User1Service user1Service;

    @Autowired
    public User2Controller(User2Service user2Service, User1Service user1Service) {
        this.user2Service = user2Service;
        this.user1Service = user1Service;
    }

    @GetMapping("/user2/list")
    public String list(Model model){
        List<User2DTO> user2DTOs = user2Service.findAll();
        model.addAttribute("user2DTOs", user2DTOs);
        return "user2/list";
    }

    @GetMapping("/user2/register")
    public String register(){
        return "user2/register";
    }

    @PostMapping("/user2/register")
    public String register(User2DTO user2DTO){
        user2Service.register(user2DTO);
        return "redirect:/user2/list";
    }

    @GetMapping("/user2/modify")
    public String modify(@RequestParam("uid") String uid, Model model){
        User2DTO user2DTO = user2Service.findById(uid);
        model.addAttribute(user2DTO);
        return "user2/modify";
    }

    @PostMapping("/user2/modify")
    public String modify(User2DTO user2DTO){
        user2Service.modify(user2DTO);
        return "redirect:user2/modify";
    }

    @GetMapping("/user2/delete")
    public String remove(@RequestParam("uid") String uid){
        user2Service.delete(uid);
        return "redirect:/user2/list";
    }

}
