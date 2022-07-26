package com.springboot.api.controller;

import com.springboot.api.dto.MemberDto;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.logging.Logger;

@RestController
@RequestMapping("/api/v1/get-api")
public class GetController {

    private final Logger LOGGER = LoggerFactory.getLogger(GetController.class);

    //http://localhost:8080/api/v1/get-api/hello
    @RequestMapping(value="/hello", method = RequestMethod.GET)
    public String getHello() {
        LOGGER.info("getHello 메서드가 호출되었습니다.");
        return "Hello World";
    }

    //매개변수가 없는 GET 구현
    //http://localhost:8080/api/v1/get-api/name
    @GetMapping("/name")
    public String getName() {
        LOGGER.info("getName 메서드가 호출되었습니다.");
        return "Flature";
    }

    //매개변수 있는 GET 구현
    //http://localhost:8080/api/v1/get-api/variable/test
    @GetMapping("/variable1/{variable}")
    public String getVariable1(@PathVariable String variable) {
        return variable;
    }
    //http://localhost:8080/api/v1/get-api/variable2/test2
    @GetMapping("/variable2/{variable}")
    public String getVariable2(@PathVariable("variable") String var) {
        return var;
    }

    //@RequestParam을 활용한 GET 메서드 구현(쿼리형식으로 값전달)
    //http://localhost:8080/api/v1/get-api/request1?name=value1&email=value2&organization=value3
    @GetMapping(value="/request1")
    public String getRequestParam1(
            @RequestParam String name,
            @RequestParam String email,
            @RequestParam String organization) {
        return name + " " + email + " " + organization;
    }

    //쿼리스트링에 어떤 값 올지 모른다면 Map 사용(갯수나 key명이 정해지지 않았을 때)
    //http://localhost:8080/api/v1/get-api/request2?key1=value&key2=value2&key3=value3
    @GetMapping(value="/request2")
    public String getRequestParam2(@RequestParam Map<String, String> param) {
        StringBuilder sb = new StringBuilder();

        param.entrySet().forEach(map -> {
            sb.append(map.getKey() + " : " + map.getValue() + "\n");
        });
        return sb.toString();
    }

    //DTO 객체를 활용한 GET 메서드 구현
    //http://localhost:8080/api/v1/get-api/request3?name=value1&email=value2&organization=value3
    @GetMapping(value="/request3")
    public String getRequestParam3(MemberDto memberDto) {
        //return memberDto.getName() + " " + memberDto.getEmail() + " " + memberDto.getOrganization();
        return memberDto.toString();
    }


}


