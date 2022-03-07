package service;

import java.util.List;

import exceptions.SystemException;
import pojo.TaskPojo;

public interface TaskService {

	// fetch all tasks
	List<TaskPojo> fetchAllTasks() throws SystemException;

	// get one task
	TaskPojo fetchOneTask(int taskId) throws SystemException;

	// create new task
	TaskPojo createNewTask(TaskPojo taskPojo) throws SystemException;

	// edit a task
	TaskPojo editTask(TaskPojo taskPojo) throws SystemException;

	// delete
	TaskPojo deleteTask(int taskId) throws SystemException;

}
