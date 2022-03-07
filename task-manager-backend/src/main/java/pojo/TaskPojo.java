package pojo;

public class TaskPojo {
	
	private int taskId;
	private String taskName;
	private int created_by;
	private String completed;
	private String createdOn;
	private String updatedOn;
	
	public TaskPojo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public TaskPojo(int taskId, String taskName, int created_by, String completed, String createdOn,
			String updatedOn) {
		super();
		this.taskId = taskId;
		this.taskName = taskName;
		this.created_by = created_by;
		this.completed = completed;
		this.createdOn = createdOn;
		this.updatedOn = updatedOn;
	}

	public int getTaskId() {
		return taskId;
	}

	public void setTaskId(int taskId) {
		this.taskId = taskId;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public int getCreated_by() {
		return created_by;
	}

	public void setCreated_by(int created_by) {
		this.created_by = created_by;
	}

	public String getCompleted() {
		return completed;
	}

	public void setCompleted(String completed) {
		this.completed = completed;
	}

	public String getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(String createdOn) {
		this.createdOn = createdOn;
	}

	public String getUpdatedOn() {
		return updatedOn;
	}

	public void setUpdatedOn(String updatedOn) {
		this.updatedOn = updatedOn;
	}

	@Override
	public String toString() {
		return "TaskPojo [taskId=" + taskId + ", taskName=" + taskName + ", created_by=" + created_by + ", completed="
				+ completed + ", createdOn=" + createdOn + ", updatedOn=" + updatedOn + "]";
	}

	
	
	

}
