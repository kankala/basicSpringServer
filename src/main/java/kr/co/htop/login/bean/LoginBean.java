package kr.co.htop.login.bean;



import javax.validation.constraints.Size;




public class LoginBean {
	

	@Size(min=1, max=20)
	private String id;
	
	@Size(min=1, max=20)
	private String password;
	/**
	 * 
	 */
	private String message;
	
	
	public String getId() {
		return id;
	}
	
	public void setId(String id) {
		this.id = id;
	}
	/**
	 * 
	 */
	public String getPassword() {
		return password;
	}

	/**
	 *
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public String toString() {
		return "LoginBean [id=" + id + ", password=" + password + "]";
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
}
