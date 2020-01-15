package com.ecommerce.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/testController")
public class TestController {

    @GetMapping(value = "/")
    public @ResponseBody
    String test() {
        return "CONTROLLER REACHED SUCCESSFULLY";
    }

}
