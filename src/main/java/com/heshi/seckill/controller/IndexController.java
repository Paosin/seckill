package com.heshi.seckill.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author Paosin
 * @version 1.0
 * @className IndexController
 * @date 2018/3/29 23:09
 */
@Controller
public class IndexController {
    @GetMapping("/")
    public String index() {
        return "index";
    }
}
