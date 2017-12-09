package com.im.project.service.impl;

import com.im.project.model.ExtraMessage;
import com.im.project.service.ExtraMessageService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import javax.annotation.Resource;

import static org.junit.Assert.*;

/**
 * Created by demo on 2017/5/8.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:spring-mybatis.xml")
public class ExtraMessageServiceImplTest {
    @Resource
    private ExtraMessageService extraMessageService;
    @Test
    public void modifyExtraMessage() throws Exception {
        ExtraMessage extraMessage=new ExtraMessage();
        extraMessage.setPersonId(2);
        extraMessage.setPhone("1234");
        extraMessage.setEmail("123");
        extraMessageService.modifyExtraMessage(extraMessage);
    }

}