package com.im.project.controller;

import com.im.project.model.*;
import com.im.project.service.*;
import com.im.project.utils.JSONUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by demo on 2017/5/9.
 * 获取个人信息
 */
@Controller
@RequestMapping("static/personshow")
public class PersonMessageController {
    private final static Integer LEADER = 1;
    private final static Integer MEMBER = 2;
    private final static Integer GRAD = 3;
    private final static Integer POSTGRAD =4;
    private ExtraMessage extraMessage;
    private List<String> title;
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

    @RequestMapping("/personShow.do")
    public Map<String, Object> personShow(String id, String name, HttpServletResponse response, HttpServletRequest request) throws Exception {
        Integer personId = Integer.valueOf(id);
        Map<String, Object> map = null;
        title = articleService.findTitleByUserName(name);
        extraMessage = extraMessageService.findExtraMessage(personId);
        //通过id查询登陆者的类型
        Integer type = leaderService.findType(personId);
        if (type.equals(LEADER)) {
            map = findLeader(personId);
        }
        if (type.equals(MEMBER)) {
            map = findMember(personId);
        }
        if (type.equals(GRAD)||type.equals(POSTGRAD)) {
            map = findGrad(personId);
        }

        return map;
    }



    private Map<String, Object> findGrad(Integer personId) throws Exception {
        Map<String, Object> map = null;
        Grad grad = gradService.findGrad(personId);
        map = sendMessageToHtml(grad, extraMessage, title);
        //System.out.println(sendMessageToHtml(grad, extraMessage, title));
        return map;
    }

    private Map<String, Object> findMember(Integer personId) throws Exception {
        Map<String, Object> map = null;
        Member member = memberService.findMember(personId);
        map = sendMessageToHtml(member, extraMessage, title);
        //System.out.println(sendMessageToHtml(member, extraMessage, title));
        return map;
    }

    private Map<String, Object> findLeader(Integer personId) throws Exception {
        Map<String, Object> map;
        Leader leader = leaderService.findLeader(personId);
        map = sendMessageToHtml(leader, extraMessage, title);
        //System.out.println(sendMessageToHtml(leader, extraMessage, title));
        return map;

    }

    private Map<String, Object> sendMessageToHtml(Object b, ExtraMessage extraMessage, List<String> title) {
        Map<String, Object> map = new HashMap<String, Object>();
        map.put("Member", b);
        map.put("phoneAndEmail", extraMessage);
        map.put("titleList", title);
        //System.out.println(b.getClass().getSimpleName());
        return map;
    }

}
