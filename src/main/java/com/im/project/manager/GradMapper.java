package com.im.project.manager;

import org.springframework.stereotype.Repository;

import com.im.project.model.Grad;

import java.util.List;

@Repository("gradDao")
public interface GradMapper extends BaseDao<Grad, Integer> {
    //查询总记录数
    int countRecords();

    List<Grad> selectAllPostGrads();

    int insertPostGrad(Grad g);

    int deletePostGradByPrimaryKey(int id);

    int updatePostGradByPrimaryKey(Grad g);
}
