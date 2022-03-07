package service;

import java.util.List;

import dao.TaskDao;
import dao.TaskDaoImpl;
import exceptions.SystemException;
import pojo.TaskPojo;

public class TaskServiceImpl implements TaskService {

	TaskDao taskDao;

	public TaskServiceImpl() {
		
		taskDao = new TaskDaoImpl();

	}

	@Override
	public List<TaskPojo> fetchAllTasks() throws SystemException {
		return taskDao.fetchAllTasks();
	}

	@Override
	public TaskPojo fetchOneTask(int taskId) throws SystemException {
		return taskDao.fetchOneTask(taskId);
	}

	@Override
	public TaskPojo createNewTask(TaskPojo taskPojo) throws SystemException {
		return taskDao.createNewTask(taskPojo);
	}

	@Override
	public TaskPojo editTask(TaskPojo taskPojo) throws SystemException {
		return taskDao.editTask(taskPojo);
	}

	@Override
	public TaskPojo deleteTask(int taskId) throws SystemException {
		return taskDao.deleteTask(taskId);
	}

}
