package com.im.project.manager;

import org.springframework.stereotype.Repository;
import com.im.project.model.User;
@Repository("userDao")
/**
 * 继承basedao
 * 
 */
public interface UserMapper extends BaseDao<User, Integer> {
	public User selectByUserName(String userName);
	
}