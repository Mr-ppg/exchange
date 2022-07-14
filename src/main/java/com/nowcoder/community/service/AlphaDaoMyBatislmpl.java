package com.nowcoder.community.service;


import com.nowcoder.community.dao.AlphaDao;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Repository;

@Repository
@Primary //会被优先考虑
public class AlphaDaoMyBatislmpl implements AlphaDao {

    @Override
    public String select() {
       return "MyBatisl";
    }
}
