package service;

import exceptions.SystemException;
import pojo.UserPojo;

public interface UserService {

	// fetch one user
	UserPojo fetchOneUser(String email) throws SystemException;

	// fetch one by ID user
	UserPojo fetchOneUser(int userId) throws SystemException;

	// login
	UserPojo loginUser(String email, String password) throws SystemException;

}
