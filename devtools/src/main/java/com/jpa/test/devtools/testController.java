package com.jpa.test.devtools;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class testController {

    @RequestMapping("/test")
    @ResponseBody
    public String test(){
        int a =45;
        int b=65;
        int c=100;
        return "this just testing /t sum of a and b is "+ (a+b+c);
    }
}

