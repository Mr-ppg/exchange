package com.nowcoder.community.service;

import com.nowcoder.community.dao.AlphaDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

@Service
public class AlphaService {


    public AlphaService(){
        System.out.println("实例化 AlphaService");
    }


    @PostConstruct //初始化在构造实例化化之后被调用
    public void init(){
        System.out.println("初始化 AlphaService");
    }

    @PreDestroy
    public void destory(){
        System.out.println("销毁 AlphaService");
    }

    @Autowired
    private AlphaDao alphaDao;

    public String find(){
       return alphaDao.select();
    }
}
