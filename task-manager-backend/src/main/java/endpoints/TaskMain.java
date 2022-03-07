package endpoints;

import java.util.List;

import io.javalin.Javalin;
import pojo.TaskPojo;
import service.TaskService;
import service.TaskServiceImpl;
import service.UserService;
import service.UserServiceImpl;

public class TaskMain {

	public static void main(String[] args) {

		TaskService taskService = new TaskServiceImpl();
		UserService userService = new UserServiceImpl();

		// create and start a server
		Javalin myServer = Javalin.create(config -> config.enableCorsForAllOrigins()).start(4040);
		System.out.println("Service listening on port " + myServer.port());

		// endpoint to fetch all tasks
		myServer.get("/api/v1/tasks", ctx -> {
			List<TaskPojo> allTasks = taskService.fetchAllTasks();
			ctx.json(allTasks);
		});

		// endpoint to fetch one task
		myServer.get("/api/v1/tasks/{id}", ctx -> {
			String id = ctx.pathParam("id");
			TaskPojo task = taskService.fetchOneTask(Integer.parseInt(id));
			ctx.json(task);
		});

		// endpoint to delete one task
		myServer.delete("/api/v1/tasks/{id}", ctx -> {
			String id = ctx.pathParam("id");
			TaskPojo task = taskService.deleteTask(Integer.parseInt(id));
			ctx.json(task);
		});

		// endpoint to add a task
		myServer.post("/api/v1/tasks", ctx -> {
			TaskPojo newTask = ctx.bodyAsClass(TaskPojo.class);
			TaskPojo returnedTask = taskService.createNewTask(newTask);

			ctx.json(returnedTask);

		});

		// endpoint to update a task
		myServer.put("/api/v1/tasks", ctx -> {
			TaskPojo updateTask = ctx.bodyAsClass(TaskPojo.class);
			TaskPojo returnedTask = taskService.editTask(updateTask);

			ctx.json(returnedTask);

		});

	}

}
