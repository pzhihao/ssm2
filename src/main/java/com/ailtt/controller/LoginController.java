package com.ailtt.controller;

import com.ailtt.model.User;
import com.ailtt.service.IUserService;
import com.ailtt.utils.EncodingTool;
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
    @RequestMapping("/create")
    public ModelAndView login(@RequestParam("username")String username, @RequestParam("age")int age){
        System.out.print("请求的值"+username+"/"+age);

        ModelAndView modelAndView=null;
        User user=new User();

        if (null!=username&&""!=username){
            // tomcat默认IO8859-1,改为UTF-8
            user.setName(EncodingTool.encodeStr(username));
            user.setAge(age);
            iUserService.insert(user);

            modelAndView=new ModelAndView("redirect:/hello");
            modelAndView.addObject("msg",username);//${msg}
        }else {
            System.out.print("进入无zhi");
            modelAndView=new ModelAndView("redirect:/login.jsp");
        }

        return modelAndView;
    }
}
