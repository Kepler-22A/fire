package com.kepler.controller;

import com.kepler.service.FireService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;

@Controller
@RequestMapping("/FireController")
public class FireController {
    @Resource
    private FireService service;

    
}
