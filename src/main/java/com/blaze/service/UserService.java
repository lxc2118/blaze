package com.blaze.service;

import com.blaze.biz.User;
import com.blaze.dao.IUserDao;

//@Service("userService")
public class UserService {

//	@Resource
	private IUserDao userDao;

	public User findById(int id) {
		return this.userDao.findById(id);
	}

}
