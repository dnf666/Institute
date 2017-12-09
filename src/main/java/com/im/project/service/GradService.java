package com.im.project.service;

import java.util.List;
import java.util.Map;

import com.im.project.model.Grad;

public interface GradService {
	public Grad findGrad(Integer id)throws Exception;
	public boolean delGrad(Integer id,String pictureId)throws Exception;
	public boolean addGrad(Grad grad)throws Exception;
	public boolean modifyGrad(Grad grad)throws Exception;
	/**
	 * 分页查找
	 * @param map
	 * @return
	 */
	public List<Grad> findGradByPage(Map<String ,Object> map)throws Exception;
	/**
	 * 查询总共有多少条记录
	 * @return
	 */
	public Integer findRecords()throws Exception;

	boolean addPostGrad(Grad g);

	boolean delPostGrad(int id, String pictureId);

	boolean modifyPostGrad(Grad g);
}
