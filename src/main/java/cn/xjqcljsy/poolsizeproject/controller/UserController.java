package cn.xjqcljsy.poolsizeproject.controller;

import cn.xjqcljsy.poolsizeproject.entity.User;
import cn.xjqcljsy.poolsizeproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;
    @RequestMapping("/getOne")
    @ResponseBody public Object getById(@RequestBody Map request){
        return userService.getById((String)request.get("id"));
    }
    @RequestMapping("/addOne")
    @ResponseBody public Object addOne(@RequestBody Map request){
        User user =  new User();
        user.setAddress((String)request.get("address"));
        user.setName((String)request.get("name"));
        user.setAge((Integer)request.get("age"));
        return userService.addOne(user);
    }
    @RequestMapping("/updateOne")
    @ResponseBody public Object updateOne(@RequestBody Map request){
        User user =  new User();
        user.setId((String)request.get("id"));
        user.setAddress((String)request.get("address"));
        user.setName((String)request.get("name"));
        user.setAge((Integer)request.get("age"));
        return userService.updateOne(user);
    }
    @RequestMapping("/deleteOne")
    @ResponseBody public Object deleteOne(@RequestBody Map request){
        User user =  new User();
        user.setId((String)request.get("id"));
        return userService.deleteOne(user);
    }
}
