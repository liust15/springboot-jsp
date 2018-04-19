package com.liust.demo;

import com.liust.demo.bean.Person;
import com.liust.demo.dao.Dao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Controller
public class IndexController {
    @RequestMapping(value = "/employees", method = RequestMethod.GET)
    @ResponseBody
    private Object getPerson() {
        Dao dao = new Dao();
        List<Person> list = dao.arrToList(dao.getData());
        return list;
    }

    @RequestMapping("/index")
    public String welcome(Map<String, Object> map) {
        Dao dao = new Dao();
        List<Person> list = dao.arrToList(dao.getData());
        map.put("table",list);
        return "index";
    }

    @RequestMapping("/name")
    public String name(Map<String, Object> map) {
        map.put("name", "Clark");
        System.out.println("============================================");
        return "hello";
    }

}

