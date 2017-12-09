package com.im.project.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.im.project.manager.UserMapper;
import com.im.project.model.User;
import com.im.project.service.UserService;

@Service("userService")
public class UserServiceImpl implements UserService {
	@Resource
	private UserMapper userDao;
	
    public boolean login(User u){
    	User user=new User();
    	user=userDao.selectByUserName(u.getUserName());
    	if(user!=null&&user.getPassword().equals(u.getPassword())){
    		return true;
    	}
    	return false;
    }
	
	public User findUser(Integer id) throws Exception {
		// TODO Auto-generated method stub
		User user = new User();
		if (id > 0 && id < Integer.MAX_VALUE) {
			user = userDao.selectByPrimaryKey(id);
		}
		return user;
	}

	public boolean addUser(User user) throws Exception {
		// TODO Auto-generated method stub
		boolean boo = false;
		if (user != null) {
			int i = userDao.insert(user);
			if (i == 1) {
				boo = true;
			}
		}
		return boo;
	}

}
