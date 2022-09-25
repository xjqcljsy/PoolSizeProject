package cn.xjqcljsy.poolsizeproject.service;

import cn.xjqcljsy.poolsizeproject.entity.User;
import cn.xjqcljsy.poolsizeproject.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService {
    @Autowired
    UserMapper userMapper;
    public User getById(String id) {
        return userMapper.selectById(id);
    }

    public Object addOne(User user) {
        userMapper.insert(user);
        return user;
    }

    public Object updateOne(User user) {
        User entity = userMapper.selectById(user.getId());
        entity.setName(user.getName());
        entity.setAddress(user.getName());
        entity.setAge(user.getAge());
        userMapper.updateById(entity);
        return entity;
    }

    public Object deleteOne(User user) {
        return userMapper.deleteById(user.getId());
    }
}
