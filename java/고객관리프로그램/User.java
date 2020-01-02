package STUDY1;

public class User {
     private int id = 0;
     private int point = 0;
     private int phone_number = 0;
     private String username = "null";
     private String usergender = "null";
     
    User(int key) {//»ı¼ºÀÚ.
    	id=key;
    }
	public int getId() {
		return id;
	}
	public  void setId(int id) {
		this.id = id;
	}
	public int getPoint() {
		return point;
	}
	public void setPoint(int point) {
		this.point = point;
	}
	public int getPhone_number() {
		return phone_number;
	}
	public void setPhone_number(int phone_number) {
		this.phone_number = phone_number;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getUsergender() {
		return usergender;
	}
	public void setUsergender(String usergender) {
		this.usergender = usergender;
	}
}
