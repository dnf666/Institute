package com.im.project.service;

import com.im.project.manager.BaseDao;
import com.im.project.model.ExtraMessage;

import java.util.List;
import java.util.Map;

/**
 * Created by demo on 2017/5/8.
 */
public interface ExtraMessageService {
    public ExtraMessage findExtraMessage(Integer id)throws Exception;
    public boolean delExtraMessage(Integer id)throws Exception;
    public boolean modifyExtraMessage(ExtraMessage extraMessage)throws Exception;
    public int findRecords()throws Exception;
    public List<ExtraMessage> findExtraMessageByPage(Map<String ,Object> map)throws Exception;
    List<ExtraMessage> findExtraMessageList()throws Exception;

}
