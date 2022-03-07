package service;

import dao.UserDao;
import dao.UserDaoImpl;
import exceptions.SystemException;
import pojo.UserPojo;

public class UserServiceImpl implements UserService {
	
	UserDao userDao;

	public UserServiceImpl() {
		
		userDao = new UserDaoImpl();

	}

	@Override
	public UserPojo fetchOneUser(String email) throws SystemException {
		return userDao.fetchOneUser(email);
	}

	@Override
	public UserPojo fetchOneUser(int userId) throws SystemException {
		return userDao.fetchOneUser(userId);
	}

	@Override
	public UserPojo loginUser(String email, String password) throws SystemException {
		return userDao.loginUser(email, password);
	}

}
