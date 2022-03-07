package dao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import exceptions.SystemException;
import pojo.UserPojo;
import pojo.TaskPojo;

public class TaskDaoImpl implements TaskDao {

	public static final Logger LOG = LogManager.getLogger(TaskDaoImpl.class);

	@Override
	public List<TaskPojo> fetchAllTasks() throws SystemException {
		LOG.info("Entered fetchAllTasks() in DAO");

		// collection of tasks
		List<TaskPojo> allTasks = new ArrayList<>();

		Connection conn = DBUtil.obtainConnection();

		try {
			Statement stmt = conn.createStatement();

			String query = "SELECT * FROM tasks";

			ResultSet rs = stmt.executeQuery(query);

			// iterate through result set
			while (rs.next()) {
				// copy each record into a TasksPojo object
				TaskPojo taskPojo = new TaskPojo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4),
						rs.getString(5), rs.getString(6));

				// add TaskPojo to ArrayList
				allTasks.add(taskPojo);
			}

		} catch (SQLException e) {
			throw new SystemException();
		}

		LOG.info("Exited fetchAllTasks() in DAO");
		return allTasks;
	}

	@Override
	public TaskPojo fetchOneTask(int taskId) throws SystemException {
		LOG.info("Entered fetchOneTask() in DAO");

		TaskPojo taskPojo = null;

		Connection conn = DBUtil.obtainConnection();

		try {
			Statement stmt = conn.createStatement();

			String query = "SELECT * FROM tasks " + "WHERE task_id=" + taskId;

			ResultSet rs = stmt.executeQuery(query);

			if (rs.next()) {
				taskPojo = new TaskPojo(rs.getInt(1), rs.getString(2), rs.getInt(3), rs.getString(4), rs.getString(5),
						rs.getString(6));
			}

		} catch (SQLException e) {
			throw new SystemException();
		}

		LOG.info("Exited fetchOneTask() in DAO");
		return taskPojo;
	}

	@Override
	public TaskPojo createNewTask(TaskPojo taskPojo) throws SystemException {

		LOG.info("Entered createNewTask() in DAO");

		Connection conn = DBUtil.obtainConnection();

		try {
			Statement stmt = conn.createStatement();

			String query = "INSERT INTO tasks(task_name, created_by, completed) VALUES(" + "'"
					+ taskPojo.getTaskName() + "', " + taskPojo.getCreated_by() + ", " + taskPojo.getCompleted() + ")";

			int rows = stmt.executeUpdate(query);

		} catch (SQLException e) {
			throw new SystemException();
		}

		LOG.info("Exited createNewTask() in DAO");
		return taskPojo;
	}

	@Override
	public TaskPojo editTask(TaskPojo taskPojo) throws SystemException {

		Connection conn = DBUtil.obtainConnection();

		try {
			Statement stmt = conn.createStatement();

			String query = "UPDATE tasks SET task_name='" + taskPojo.getTaskName() + "', completed='" + taskPojo.getCompleted() + "', updated_on=NOW() WHERE task_id="
					+ taskPojo.getTaskId();

			int rows = stmt.executeUpdate(query);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SystemException();
		}

		return taskPojo;
	}

	@Override
	public TaskPojo deleteTask(int taskId) throws SystemException {
		
		TaskPojo taskPojo = null;
		Connection conn = DBUtil.obtainConnection();
		
		try {
			Statement stmt = conn.createStatement();
			
			// get task
			taskPojo = fetchOneTask(taskId);
			// delete book
			String query = "DELETE FROM tasks WHERE task_id=" + taskId;
			
			int rows = stmt.executeUpdate(query);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			throw new SystemException();
		}
		
		return taskPojo;
	}

}
