package pojo;

public class UserPojo {
	
	private int userId;
	private String email;
	private String password;
	private String created_on;
	
	public UserPojo() {
		super();

	}

	public UserPojo(int userId, String email, String password, String created_on) {
		super();
		this.userId = userId;
		this.email = email;
		this.password = password;
		this.created_on = created_on;
	}

	public int getUserId() {
		return userId;
	}

	public void setUserId(int userId) {
		this.userId = userId;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getCreated_on() {
		return created_on;
	}

	public void setCreated_on(String created_on) {
		this.created_on = created_on;
	}

	@Override
	public String toString() {
		return "UserPojo [userId=" + userId + ", email=" + email + ", password=" + password + ", created_on="
				+ created_on + "]";
	}
	
	
	
	

}
