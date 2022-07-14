package com.nowcoder.community;


import com.nowcoder.community.dao.DiscussPostMapper;
import com.nowcoder.community.dao.UserMapper;
import com.nowcoder.community.entity.DiscussPost;
import com.nowcoder.community.entity.User;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.Scope;
import org.springframework.test.context.ContextConfiguration;

import java.util.Date;
import java.util.List;

@SpringBootTest
@Scope("prototype")
@ContextConfiguration(classes = CommunityApplication.class) //启用配置类

public class MapperTests  {

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private DiscussPostMapper discussPostMapper;

    @Test
    public void testSelectUser(){
        User user = userMapper.selectById(101);
        System.out.println(user);

        User liubei = userMapper.selectByName("liubei");
        System.out.println(liubei);

        User user1 = userMapper.selectByEmail(liubei.getEmail());
        System.out.println(user1);
    }

    @Test
    public void testInsertUser(){
        User user = new User();
        user.setEmail("23118498868@qq.com");
        user.setPassword("pipigao");
        user.setSalt("abc");
        user.setUsername("pipi");
//        user.setId(66666);
        user.setHeaderUrl("http://www.nowcoder.com/101.png");
        user.setCreateTime(new Date());

        int rows = userMapper.insertUser(user);
        System.out.println(rows);
        System.out.println(user.getId());


    }

    @Test
    public void updateUser(){
        int rows = userMapper.updateStatus(150, 1);
        System.out.println(rows);

        rows = userMapper.updateHeader(150, "http://www.nowcoder.com/102.png");
        System.out.println(rows);

        rows = userMapper.updatePassword(150, "hello");
        System.out.println(rows);
    }

    @Test
    public void testSelectPost(){
//        List<DiscussPost> list = discussPostMapper.selectDiscussPosts(0, 0, 10);
//        for (DiscussPost discussPost : list) {
//            System.out.println(discussPost);
//
//        }

        int rows = discussPostMapper.selectDiscussPostRows(0);
        System.out.println(rows);


    }



}
