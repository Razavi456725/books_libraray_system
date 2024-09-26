package com.mehtab.test1.Controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {

    @GetMapping("path")  // 
    public String getMethodName(){
        return "Get";
    }

    @PostMapping("path")
    public String postMethodName(){
        return "Post";
    }

    @PutMapping("path/{id}")
    public String putMethodName(){
        return "put";
    }

    @DeleteMapping("path/{id}")
    public String deleteMethodName(){
        return "Delete";
    }

    
}
