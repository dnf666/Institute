package com.im.project.service;

import com.im.project.model.User;

public interface UserService {
	public User findUser (Integer id)throws Exception;
	public boolean addUser(User user)throws Exception;
	public boolean login(User u);

}
