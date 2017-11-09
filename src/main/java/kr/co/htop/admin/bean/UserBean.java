package kr.co.htop.admin.bean;



import java.sql.Timestamp;
import java.util.Date;



public class UserBean {
	
	private int server;
	
	private Integer changeMode;
	
	private Integer pageNum; 
	
	private Integer total;
	

	private int idx;
	
	private String id;
	
	private int level;
	
	private String name;

	private String password;
	
	private String ip;
	
	private Date date = new Date();
	
	/**
	 * 
	 */
	
	


	public Integer getChangeMode() {
		return changeMode;
	}


	public void setChangeMode(Integer changeMode) {
		this.changeMode = changeMode;
	}


	public Integer getPageNum() {
		return pageNum;
	}


	public void setPageNum(Integer pageNum) {
		this.pageNum = pageNum;
	}


	public Integer getTotal() {
		return total;
	}


	public void setTotal(Integer total) {
		this.total = total;
	}


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
		return "LoginBean [idx="+idx+", id=" + id + ", level="+level+", password=" + password + "]";
	}

	public int getLevel() {
		return level;
	}

	public void setLevel(int level) {
		this.level = level;
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}

	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getIp() {
		return ip;
	}

	public void setIp(String ip) {
		this.ip = ip;
	}


	public Date getDate() {
		return date;
	}


	public void setDate(Date date) {
		this.date = date;
	}


	public int getServer() {
		return server;
	}


	public void setServer(int server) {
		this.server = server;
	}
	
	
}
