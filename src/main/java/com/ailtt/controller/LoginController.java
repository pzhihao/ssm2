package com.ailtt.controller;

import com.ailtt.model.User;
import com.ailtt.service.IUserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * Created by pengzhihao on 2017/5/29.
 */
@Controller
public class LoginController {

    @Resource
    IUserService iUserService;

    @RequestMapping("/hello")
    public ModelAndView hello(){
        List<User> allUser = iUserService.getAllUser();
        for (int i = 0; i <allUser.size() ; i++) {
            System.out.println("哈哈"+allUser.get(i).getName());
        }

        ModelAndView modelAndView=new ModelAndView("success");
        modelAndView.addObject("list",allUser);

        return modelAndView;
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
