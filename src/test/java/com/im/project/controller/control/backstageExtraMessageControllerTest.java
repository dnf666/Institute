package com.im.project.controller.control;

import com.im.project.model.ExtraMessage;
import com.im.project.service.ExtraMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import java.util.List;

import static org.junit.Assert.*;

/**
 * Created by demo on 2017/5/12.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class backstageExtraMessageControllerTest {
    @Resource
    private ExtraMessageService extraMessageService;
    @Test
    public void addExtraMessage() throws Exception {
        ExtraMessage extraMessage=new ExtraMessage();
        extraMessage.setPersonId(1);
        extraMessage.setPhone("12313142");
        extraMessage.setEmail("12321342");
        extraMessageService.modifyExtraMessage(extraMessage);
    }

    @Test
    public void selectAllExtraMessage() throws Exception {
        List<ExtraMessage> extraMessageList=extraMessageService.findExtraMessageList();
        for(ExtraMessage extraMessage:extraMessageList)
        {
            //System.out.println(extraMessage.getName());
            //System.out.println(extraMessage.getEmail());
            //System.out.println(extraMessage.getPhone());
        }

    }

}