package application;

public class CargoTable {

	private int CargoID;
	private String CargoStatus;
	private String SenderName;
	private String SenderSurname;
	private int SenderIdentificationNumber;
	private int SenderPhoneNumber;
	private String SenderEmail;
	private String SenderAddress;
	private String RecieverName;
	private String RecieverSurname;
	private int RecieverIdentificationNumber;
	private int RecieverPhoneNumber;
	private String RecieverEmail;
	private String RecieverAddress;

	public CargoTable() {
		this.CargoID = 0;
	}

	public CargoTable(int CargoID, String CargoStatus, String SenderName, String SenderSurname,
			int SenderIdentificationNumber, int SenderPhoneNumber, String SenderEmail, String SenderAddress,
			String RecieverName, String RecieverSurname, int RecieverIdentificationNumber, int RecieverPhoneNumber,
			String RecieverEmail, String RecieverAddress) {
		this.CargoID = CargoID;
		this.CargoStatus = CargoStatus;
		this.SenderName = SenderName;
		this.SenderSurname = SenderSurname;
		this.SenderIdentificationNumber = SenderIdentificationNumber;
		this.SenderPhoneNumber = SenderPhoneNumber;
		this.SenderEmail = SenderEmail;
		this.SenderAddress = SenderAddress;
		this.RecieverName = RecieverName;
		this.RecieverSurname = RecieverSurname;
		this.RecieverIdentificationNumber = RecieverIdentificationNumber;
		this.RecieverPhoneNumber = RecieverPhoneNumber;
		this.RecieverEmail = RecieverEmail;
		this.RecieverAddress = RecieverAddress;

	}

	public int getCargoID() {
		return CargoID;
	}

	public void setCargoID(int cargoID) {
		CargoID = cargoID;
	}

	public String getCargoStatus() {
		return CargoStatus;
	}

	public void setCargoStatus(String cargoStatus) {
		CargoStatus = cargoStatus;
	}

	public String getSenderName() {
		return SenderName;
	}

	public void setSenderName(String senderName) {
		SenderName = senderName;
	}

	public String getSenderSurname() {
		return SenderSurname;
	}

	public void setSenderSurname(String senderSurname) {
		SenderSurname = senderSurname;
	}

	public int getSenderIdentificationNumber() {
		return SenderIdentificationNumber;
	}

	public void setSenderIdentificationNumber(int senderIdentificationNumber) {
		SenderIdentificationNumber = senderIdentificationNumber;
	}

	public int getSenderPhoneNumber() {
		return SenderPhoneNumber;
	}

	public void setSenderPhoneNumber(int senderPhoneNumber) {
		SenderPhoneNumber = senderPhoneNumber;
	}

	public String getSenderEmail() {
		return SenderEmail;
	}

	public void setSenderEmail(String senderEmail) {
		SenderEmail = senderEmail;
	}

	public String getSenderAddress() {
		return SenderAddress;
	}

	public void setSenderAddress(String senderAddress) {
		SenderAddress = senderAddress;
	}

	public String getRecieverName() {
		return RecieverName;
	}

	public void setRecieverName(String recieverName) {
		RecieverName = recieverName;
	}

	public String getRecieverSurname() {
		return RecieverSurname;
	}

	public void setRecieverSurname(String recieverSurname) {
		RecieverSurname = recieverSurname;
	}

	public int getRecieverIdentificationNumber() {
		return RecieverIdentificationNumber;
	}

	public void setRecieverIdentificationNumber(int recieverIdentificationNumber) {
		RecieverIdentificationNumber = recieverIdentificationNumber;
	}

	public int getRecieverPhoneNumber() {
		return RecieverPhoneNumber;
	}

	public void setRecieverPhoneNumber(int recieverPhoneNumber) {
		RecieverPhoneNumber = recieverPhoneNumber;
	}

	public String getRecieverEmail() {
		return RecieverEmail;
	}

	public void setRecieverEmail(String recieverEmail) {
		RecieverEmail = recieverEmail;
	}

	public String getRecieverAddress() {
		return RecieverAddress;
	}

	public void setRecieverAddress(String recieverAddress) {
		RecieverAddress = recieverAddress;
	}

}
