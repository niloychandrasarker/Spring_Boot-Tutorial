package com.api.Controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class bookController {

    
    @GetMapping("/books")
    public String getBook(){
        return "this testing book first";
    }
}
