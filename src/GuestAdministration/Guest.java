package GuestAdministration;

public class Guest {
	
	@Override
	public String toString() {
		return ".Nume: " + this.lastName + " " + this.firstName + ", Email: " + this.email 
				+ ", Telefon: " + this.phoneNumber;
	}
	
	private String lastName;
	private String firstName;
	private String email;
	private String phoneNumber;
	
	public Guest(String lastName, String firstName, String email, String phoneNumber) {
		
		this.lastName = lastName;
		this.firstName = firstName;
		this.email = email;
		this.phoneNumber = phoneNumber;
		
	}
	
	
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}


	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public void setPhoneNumber(String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}


	public boolean containsLastName(String lastName) {

		return this.lastName.equals(lastName);
	}
	
	public boolean containsFirstName(String firstName) {
			
		return this.firstName.equals(firstName);
	}
	
	public boolean containsFullName(String str) {
		
		String[] fullName = str.split(" ");
		String lastName = fullName[0];
		String firstName = fullName[1];
		
		return (containsFirstName(firstName) && containsLastName(lastName));
	}
	
	public boolean containsPhone(String phoneNumber) {
			
		return this.phoneNumber.equals(phoneNumber);
	}
	
	public boolean containsEmail(String email) {
			
		return this.email.equals(email);
	}
	
	
}
