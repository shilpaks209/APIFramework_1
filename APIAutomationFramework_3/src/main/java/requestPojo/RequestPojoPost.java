package requestPojo;

public class RequestPojoPost {
	 public String name;
	 public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String job;
public String toString() {
	
	
	
	return "{\r\n"
			+ "    \"name\":\""+this.name+"\",\r\n"
			+ "    \"job\":\""+this.job+"\"\r\n"
			+ "}";
}
}
	

