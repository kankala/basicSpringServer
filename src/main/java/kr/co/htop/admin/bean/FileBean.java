package kr.co.htop.admin.bean;




public class FileBean {
	
	private int idx;
	
	private String path;
	

	private String originalName;
	/**
	 * 
	 */
	public String getPath() {
		return path;
	}
	
	public void setPath(String path) {
		this.path = path;
	}
	/**
	 * 
	 */
	public String getOriginalName() {
		return originalName;
	}

	/**
	 *
	 */
	public void setOriginalName(String originalName) {
		this.originalName = originalName;
	}

	@Override
	public String toString() {
		return "FileBean [path=" + path + ", originalName=" + originalName +", originalName=" + originalName + "]";
	}

	public int getIdx() {
		return idx;
	}

	public void setIdx(int idx) {
		this.idx = idx;
	}
	
}
