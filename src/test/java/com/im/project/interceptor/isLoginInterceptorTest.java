package com.im.project.interceptor;


import com.im.project.manager.ExtraMessageMapper;
import com.im.project.manager.LeaderMapper;
import com.im.project.model.ExtraMessage;
import com.im.project.model.Leader;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by demo on 2017/5/7.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class isLoginInterceptorTest {
    @Resource
    private ExtraMessageMapper extraMessageMapper;
    @Resource
    private LeaderMapper leaderMapper;
    @Test
    public void test(){
        ExtraMessage extraMesage=new ExtraMessage();
        extraMesage.setEmail("12");
        extraMesage.setPhone("123");
        extraMessageMapper.insert(extraMesage);
        //System.out.println("123");
    }
    @Test
    public void test1(){
        ExtraMessage extraMesage=new ExtraMessage();
        extraMesage.setPersonId(1);
        extraMesage.setEmail("12");
        extraMesage.setPhone("123");
        extraMessageMapper.updateByPrimaryKey(extraMesage);
    }
    @Test
    public void test2(){
        Leader leader=new Leader();
        leader.setId(1);
        leader.setName("1");
        leader.setJianjie("1");
        leaderMapper.updateByPrimaryKey(leader);
    }
    @Test
    public void test3(){
        isLoginInterceptorTest isLoginIntercepto=new isLoginInterceptorTest();
        //System.out.println(isLoginIntercepto.getClass().getSimpleName());
        //System.out.println(isLoginIntercepto.getClass().getCanonicalName());
        //System.out.println(this.getClass().getSimpleName());
    }

}