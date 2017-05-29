package com.ailtt.controller;

import com.ailtt.bean.Person;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by pengzhihao on 2017/5/29.
 */
@Controller
@RequestMapping("/api/json")
public class JSONController {

    //返回单个对象
    @RequestMapping(value = "{name}",method = RequestMethod.GET)
    public @ResponseBody Person getPerson(@PathVariable String name){
        System.out.print("请求json");
        Person person=new Person();
        person.setName(name);
        person.setAge(12);
        return person;
    }
    //返回list
    @RequestMapping(value = "/list",method = RequestMethod.GET)
    public @ResponseBody List<Person> getPersons(){
        List<Person> list=new ArrayList<Person>();
        Person p1=new Person();
        p1.setName("1");
        p1.setAge(12);
        Person p2=new Person();
        p2.setName("2");
        p2.setAge(23);
        list.add(p1);
        list.add(p2);
        return list;
    }
    //返回对象集合
    @RequestMapping(value = "/map",method = RequestMethod.GET)
    public @ResponseBody Map<String,Object> getPersonsMap(){
        List<Person> list=new ArrayList<Person>();
        Person p1=new Person();
        p1.setName("1");
        p1.setAge(12);
        Person p2=new Person();
        p2.setName("2");
        p2.setAge(23);
        list.add(p1);
        list.add(p2);

        Map<String,Object> map=new HashMap<String, Object>();
        map.put("data",list);
        map.put("state",0);
        return map;
    }

}
