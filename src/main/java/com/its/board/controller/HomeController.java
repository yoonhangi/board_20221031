package com.its.board.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;

@Controller
public class HomeController {
    @GetMapping("/")
    public String index(){
        return "index";
    }

    @GetMapping("/login")
    public String login(HttpSession session) {
        session.setAttribute("loginEmail", "member1@member.com");
        return "redirect:/board/paging";
    }

    @GetMapping("/logout")
    public String logout( HttpSession session){
        session.invalidate();
        return "redirect:/board/paging";
    }


}
