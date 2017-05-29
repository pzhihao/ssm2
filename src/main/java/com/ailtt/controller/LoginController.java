package com.ailtt.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;


/**
 * Created by pengzhihao on 2017/5/29.
 */
@Controller
public class LoginController {
    @RequestMapping("/hello")
    public String hello(){
        return "success";
    }
    @RequestMapping("/login")
    public ModelAndView login(@RequestParam("username")String username, @RequestParam("password")String password){
        System.out.print("请求的值"+username+"/"+password);

        ModelAndView modelAndView=null;

        if (null!=username&&""!=username){
            modelAndView=new ModelAndView("success");
            modelAndView.addObject("msg",username);//${msg}
        }else {
            System.out.print("进入无zhi");
            modelAndView=new ModelAndView("redirect:/login.jsp");
        }

        return modelAndView;
    }
}
