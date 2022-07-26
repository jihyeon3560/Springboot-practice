package com.springboot.api.controller;


import com.springboot.api.dto.MemberDto;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
@RequestMapping("/api/v1/post-api")
public class PostController {

    //RequestMapping으로 구현
    @RequestMapping(value="/domain", method = RequestMethod.POST)
    public String postExample() {
        return "Hello Post API";
    }

    //Requestbody 활용
    //http://localhost:8080/api/v1/post-api/member
    @PostMapping(value="/member")
    public String postMember(@RequestBody Map<String, Object> postData){
        StringBuilder sb = new StringBuilder();

        postData.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");

        });

        return sb.toString();
    }

    //DTO 활용
    @PostMapping(value="/member2")
    public String postMemberDto(@RequestBody MemberDto memberDto) {
        return memberDto.toString();
    }

}
