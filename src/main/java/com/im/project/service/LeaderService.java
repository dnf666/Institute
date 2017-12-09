package com.im.project.service;

import java.util.List;
import java.util.Map;

import com.im.project.model.Leader;

public interface LeaderService {
	public Leader findLeader(Integer id)throws Exception;
	public boolean addLeader(Leader leader)throws Exception;
	public boolean delLeader(Integer id,String pictureId)throws Exception;
	public boolean modifyLeader(Leader leader)throws Exception;
	/**
	 * 分页查找
	 * @param map
	 * @return
	 */
	public List<Leader> findLeaderByPage(Map<String ,Object> map)throws Exception;
	/**
	 * 查询所有的记录条数
	 * @return
	 */
	public int  findrecords()throws Exception;
	int  findType(Integer id)throws Exception;
}
