import javax.swing.Icon;

public class Contact {

	// FIELDS
	private int code;
	private String name;
	private String number;
	private String email;
	private String address;
	private String postalCode;
	private String gender;
	private Icon picture;

	// CONSTRUCTOR
	public Contact(int code, String name, String number, String gender, String email, String address, String postalCode,
			Icon picture) {

		this.code = code;
		this.name = name;
		this.number = number;
		this.email = email;
		this.address = address;
		this.postalCode = postalCode;
		this.gender = gender;
		this.picture = picture;

	}

	// SECOND CONSTRUCTOR
	public Contact() {
		this.code = -1;
		this.name = null;
		this.number = null;
		this.email = null;
		this.address = null;
		this.postalCode = null;
		this.gender = null;
		this.picture = null;
	}

	// GETTERS METHOD
	int getCode() {
		return code;
	}

	String getName() {
		return name;
	}

	String getNumber() {
		return number;
	}

	String getEmail() {
		return email;
	}

	String getAddress() {
		return address;
	}

	String getPostalCode() {
		return postalCode;
	}

	String getGender() {
		return gender;
	}

	Icon getPicture() {
		return picture;
	}

	String getInfo() {
		return getName() + " - " + getNumber() + " - " + getEmail() + " - " + getAddress() + " - " + getPostalCode()
				+ " - " + getGender() + " - " + getPicture().toString();
	}
}
