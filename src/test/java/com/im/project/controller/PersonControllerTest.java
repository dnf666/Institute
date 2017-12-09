package com.im.project.controller;

import com.im.project.model.Member;
import com.im.project.service.MemberService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.*;

/**
 * Created by demo on 2017/5/13.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class PersonControllerTest {
    @Resource
    private MemberService memberService;
    @Test
    public void listAllMembers() throws Exception {
        Map<String,Object> map = new HashMap<String,Object>();
        List<Member> list=memberService.findAllMembers(map);
        Iterator iterator=list.iterator();
        while(iterator.hasNext())
        {
            Member member= (Member) iterator.next();
            //System.out.println(member.toString());
        }
    }

}