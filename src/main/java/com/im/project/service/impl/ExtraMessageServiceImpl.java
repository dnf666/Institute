package com.im.project.service.impl;

import com.im.project.manager.ExtraMessageMapper;
import com.im.project.model.ExtraMessage;
import com.im.project.service.ExtraMessageService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

/**
 * Created by demo on 2017/5/8.
 */
@Service
public class ExtraMessageServiceImpl  implements ExtraMessageService {
    @Resource
    private ExtraMessageMapper extraMessageMapper;

    public ExtraMessage findExtraMessage(Integer id) throws Exception {
        ExtraMessage extraMessage=extraMessageMapper.selectByPrimaryKey(id);
        //System.out.println("查询成功");
        return extraMessage;
    }



    public boolean delExtraMessage(Integer id) throws Exception {
        if(extraMessageMapper.deleteByPrimaryKey(id)==1) {
            //System.out.println("删除成功");
            return true;
        }else {
            //System.out.println("删除失败");
            return false;
        }
    }

    public boolean modifyExtraMessage(ExtraMessage extraMessage) throws Exception {
        int i=extraMessageMapper.updateByPrimaryKey(extraMessage);
        //System.out.println("添加成功");
        //System.out.println(i);
        if(i==0)
        return false;
        else
            return true;
    }

    public int findRecords() throws Exception {
        return 0;
    }

    public List<ExtraMessage> findExtraMessageByPage(Map<String, Object> map) throws Exception {
        return null;
    }

    public List<ExtraMessage> findExtraMessageList() throws Exception {
        return extraMessageMapper.selectExtraList();
    }
}
