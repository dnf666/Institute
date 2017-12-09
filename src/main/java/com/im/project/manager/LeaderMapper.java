package com.im.project.manager;

import java.util.ArrayList;
import java.util.Map;
import org.springframework.stereotype.Repository;
import com.im.project.model.Leader;
@Repository("leaderDao")
public interface LeaderMapper  extends BaseDao<Leader, Integer>{
	//查询总记录数
	public int countRecords();
}
