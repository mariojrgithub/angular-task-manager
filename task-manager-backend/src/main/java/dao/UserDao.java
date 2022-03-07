package dao;

import java.util.List;

import exceptions.SystemException;
import pojo.TaskPojo;
import pojo.UserPojo;

public interface UserDao {

	// fetch one user
	UserPojo fetchOneUser(String email) throws SystemException;

	// fetch one by ID user
	UserPojo fetchOneUser(int userId) throws SystemException;

	// login
	UserPojo loginUser(String email, String password) throws SystemException;

}
