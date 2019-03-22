package com.example.dna.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: dna
 * @description:
 * @author: XL
 * @create: 2019-03-22 14:29
 **/

@Controller
public class test {
    @RequestMapping("/index1")
    public String t1(){
        return "index";
    }

    @RequestMapping("/index2")
    public String t2(){
        return "index_backup";
    }

}
