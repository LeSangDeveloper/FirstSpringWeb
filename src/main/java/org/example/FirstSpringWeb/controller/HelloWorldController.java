package org.example.FirstSpringWeb.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HelloWorldController {

    @RequestMapping("/hello")
    public String hello(Model model){
        model.addAttribute("greeting" , "Hello Spring MVC");

        return "helloworld";
    }

    @RequestMapping(value = "/redirect", method = RequestMethod.GET)
    public String authorInfo(Model model) {
        return "redirect:/hello";
    }

    @RequestMapping("/user")
    public String userInfo(Model model, @RequestParam(value = "name", defaultValue = "Guest") String name)
    {

        model.addAttribute("name", name);

        if ("admin".equals(name)) {
            model.addAttribute("email", "admin@example.com");
        } else
        {
            model.addAttribute("email", "Not set");
        }

        return "userinfo";
    }

}
