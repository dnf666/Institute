package com.im.project.manager;


import com.im.project.model.ExtraMessage;
import org.springframework.stereotype.Repository;

import java.util.List;

/**
 * Created by demo on 2017/5/7.
 */
@Repository
public interface ExtraMessageMapper extends BaseDao<ExtraMessage,Integer> {
        List<ExtraMessage> selectExtraList();
}
