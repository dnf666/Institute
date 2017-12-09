package com.im.project.controller.control;

import com.im.project.model.ExtraMessage;
import com.im.project.service.ExtraMessageService;
import com.im.project.service.LeaderService;
import com.im.project.utils.JSONUtils;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by demo on 2017/5/8.
 */
@Controller("backstageExtraMessage")
@RequestMapping("/control/extraMessage")
public class backstageExtraMessageController {
    @Resource
    private ExtraMessageService extraMessageService;

    /**
     * 添加和修改都调用该方法
     * @param extraMessage
     * @param request
     * @param response
     * @return
     * @throws Exception
     */
    @RequestMapping("/addExtraMessage.do")
    public ModelAndView addExtraMessage(ExtraMessage extraMessage, HttpServletRequest request, HttpServletResponse response)throws Exception{
        ModelAndView modelAndView=new ModelAndView("control/extramessage");
        Map<String,Object> map=new HashMap<String, Object>();
        //System.out.println(extraMessage.getPersonId());
        //System.out.println(extraMessage.getPhone());
        //System.out.println(extraMessage.getEmail());
        //System.out.println(extraMessage.getName());
        if (extraMessageService.modifyExtraMessage(extraMessage)){
            map.put("msg","success");
        }
        else{
            map.put("msg","false");
        }
        JSONUtils.toJSON(map, response);
        return modelAndView;

    }
    @RequestMapping("/getMessage.do")
    public ModelAndView selectAllExtraMessage (HttpServletRequest request,
                                      HttpServletResponse response)throws Exception{
        List<ExtraMessage> list=null;
        list=extraMessageService.findExtraMessageList();
        ModelAndView modelAndView = new ModelAndView("control/extramessage");
        try{
            modelAndView.addObject("list", list);
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return modelAndView;
    }


}
