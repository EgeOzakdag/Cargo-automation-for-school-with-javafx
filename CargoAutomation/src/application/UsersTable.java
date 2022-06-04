package application;

public class UsersTable {

	private int UserID ;
	private String UserName;
	private String Password;
	private String Name;
	private String Surname;
	private String Email;
	private String Address;
	private int Identification ;
	private int PhoneNumber ;
	
	public UsersTable() {
		this.UserID=0;
	}
	
	public UsersTable(int UserID,String UserName,String Password,String
			Name,String Surname,String Email,String Address,
			int Identification,int PhoneNumber) {
		this.UserID=UserID;
		this.UserName=UserName;
		this.Password=Password;
		this.Name=Name;
		this.Surname=Surname;
		this.Email=Email;
		this.Address=Address;
		this.Identification=Identification;
		this.PhoneNumber=PhoneNumber;
	}

	public int getUserID() {
		return UserID;
	}

	public void setUserID(int userID) {
		UserID = userID;
	}

	public String getUserName() {
		return UserName;
	}

	public void setUserName(String userName) {
		UserName = userName;
	}

	public String getPassword() {
		return Password;
	}

	public void setPassword(String password) {
		Password = password;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public String getSurname() {
		return Surname;
	}

	public void setSurname(String surname) {
		Surname = surname;
	}

	public String getEmail() {
		return Email;
	}

	public void setEmail(String email) {
		Email = email;
	}

	public String getAddress() {
		return Address;
	}

	public void setAddress(String address) {
		Address = address;
	}

	public int getIdentification() {
		return Identification;
	}

	public void setIdentification(int identification) {
		Identification = identification;
	}

	public int getPhoneNumber() {
		return PhoneNumber;
	}

	public void setPhoneNumber(int phoneNumber) {
		PhoneNumber = phoneNumber;
	}
	
	
	
}
