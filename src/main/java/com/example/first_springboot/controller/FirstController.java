package com.example.first_springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FirstController {

    @GetMapping("/hi") //url의 이름을 정해줌
    public String hello(Model model){
        model.addAttribute("username" , "상민쓰");
        return "greetings"; //greetings라는 이름의 파일을 찾음
    }
    @GetMapping("/bye")
    public String bye(Model model){
        model.addAttribute("nickname", "홍길동");
        return "goodbye";
    }
}
