package objects;

public class User {
	String email;
	String password;
	//
	public User(String email, String password) {
		this.email = email;
		this.password = password;
	}
	//
	String address;
	public User(String email, String password, String address) {
		this(email, password); //learn about this
		this.address = address;
	}
}
