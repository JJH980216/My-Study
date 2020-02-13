import java.io.Serializable;

public class Customer implements Serializable {
    // serialVersionUID�� ����ϴ� �ڹ� �ý��۰� �����ؾ� �մϴ�.
    private static final long serialVersionUID = 1L;
    int mode;
   
	int ID;
	String passward;
	String userpoint;
	String username;
	String usergender;
	Boolean login;


	void print() {
		System.out.println("���̸�:"+username+"��ID:"+ID);
	}

	/*GETTER & SETTER*/
	public Boolean getLogin() {
		return login;
	}

	public void setLogin(Boolean login) {
		this.login = login;
	}
	public int getMode() {
			return mode;}
	public void setMode(int mode) {
			this.mode = mode;}
	public int getID() {
		return ID;
	}
	public void setID(int iD) {
		ID = iD;
	}
	public String getPassward() {
		return passward;
	}
	public void setPassward(String passward) {
		this.passward = passward;
	}
	public String getUserpoint() {
		return userpoint;
	}
	public void setUserpoint(String userpoint) {
		this.userpoint = userpoint;
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
	/*GETTER & SETTER*/

}
