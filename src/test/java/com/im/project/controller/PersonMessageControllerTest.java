package com.im.project.controller;

import com.im.project.model.ExtraMessage;
import com.im.project.model.Grad;
import com.im.project.model.Leader;
import com.im.project.model.Member;
import com.im.project.service.*;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.*;

import static org.junit.Assert.*;

/**
 * Created by demo on 2017/5/10.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class PersonMessageControllerTest {
    private final static Integer LEADER=1;
    private final static Integer MEMBER=2;
    private final static Integer GRAD=3;
    private ExtraMessage extraMessage;
    @Resource
    private LeaderService leaderService;
    @Resource
    private MemberService memberService;
    @Resource
    private GradService gradService;
    @Resource
    private ExtraMessageService extraMessageService;
    @Resource
    private ArticleService articleService;
    @Test
    public void personShow() throws Exception {
        Integer i=19;
        String userName="戴林甫";
        Map<String,Object> map=null;
        extraMessage=extraMessageService.findExtraMessage(i);
        Integer type=leaderService.findType(i);
        List<String> title=articleService.findTitleByUserName(userName);
        //System.out.println(type);
        if(type.equals(LEADER))
        {
            map=findLeader(i);
        }
        if(type.equals(MEMBER))
        {
            map=findMember(i);
        }
        if(type.equals(GRAD))
        {
            map=findGrad(i);
        }

        //System.out.println(map.get("leader"));
        //System.out.println(map.get("phoneAndEmail"));
    }
    private Map<String,Object> findGrad(Integer personId)throws Exception {
        Map<String,Object> map=null;
        Grad grad=gradService.findGrad(personId);
        map=sendMessageToHtml(grad,extraMessage);
        //System.out.println(sendMessageToHtml(grad,extraMessage));
        return map;
    }

    private Map<String,Object> findMember(Integer personId)throws Exception {
        Map<String,Object> map=null;
        Member member=memberService.findMember(personId);
        map=sendMessageToHtml(member,extraMessage);
        //System.out.println(sendMessageToHtml(member,extraMessage));
        return map;
    }

    private Map<String,Object> findLeader(Integer personId) throws Exception{
        Map<String,Object> map;
        Leader leader=leaderService.findLeader(personId);
        map=sendMessageToHtml(leader,extraMessage);
        //System.out.println(sendMessageToHtml(leader,extraMessage));
        return map;

    }
    private Map<String,Object> sendMessageToHtml(Object b, ExtraMessage extraMessage) {
        Map<String,Object> map=new HashMap<String, Object>();
        map.put(b.getClass().getSimpleName(),b);
        map.put("phoneAndEmail",extraMessage);
        //System.out.println(b.getClass().getSimpleName());
        return map;
    }
}