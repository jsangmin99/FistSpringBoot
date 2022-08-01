package com.example.first_springboot.api;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //레스트 컨트롤러 Json반환
public class FIrstApiController {
    @GetMapping("/api/hello")
    public String hello(){
        return "Hello World!";
    }
}
