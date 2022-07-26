package com.springboot.api.controller;

import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value="/api/v1/delete-api")
public class DeleteController {

    //@PathVariable 활용
    @DeleteMapping(value="/{variable}")
    public String Deletevarialbe(@PathVariable String variable) {
        return variable;
    }

    //@RequestParam
    @DeleteMapping(value="/request1")
    public String getRequestParam1(@RequestParam String email){
        return "e-mail : " + email;

    }


}
