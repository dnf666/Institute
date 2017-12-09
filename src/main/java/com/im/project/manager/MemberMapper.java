package com.im.project.manager;

import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Repository;



import com.im.project.model.Member;
@Repository("memberDao")
public interface MemberMapper extends BaseDao<Member, Integer>{
	//查询总记录数
	public int countRecords();
	List<Member> selectAllMembers(Map<String,Object> dataMap);

    List<Member> selectAllPostGrads(Map<String,Object> dataMap);
}
