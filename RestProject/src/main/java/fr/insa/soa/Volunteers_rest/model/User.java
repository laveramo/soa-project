package fr.insa.soa.Volunteers_rest;

import jakarta.ws.rs.FormParam;

public class User {
	private int userID;
	
	@FormParam("FirstName")
    private String FirstName;
	
	@FormParam("LastName")
    private String LastName;
	
	@FormParam("Email")
    private String Email;
	
	@FormParam("PhoneNumber")
    private String PhoneNumber;
	
    private String Password;
    
    //this default instructor is needed if we use  appliction_json format or APPLICATION_FORM_URLENCODED on signup
    public User() {
    }

    public User(String firstName, String lastName, String email, String phoneNumber) {
        FirstName = firstName;
        LastName = lastName;
        Email = email;
        PhoneNumber = phoneNumber;
    }
    
 

        public User(String firstName, String lastName, String email, String phoneNumber, String password) {
            FirstName = firstName;
            LastName = lastName;
            Email = email;
            PhoneNumber = phoneNumber;
            setPassword(password);
        }
    
    public int getUserID() {
        return userID;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public String getEmail() {
        return Email;
    }

    public String getPhoneNumber() {
        return PhoneNumber;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public void setEmail(String email) {
        Email = email;
    }

    public void setPhoneNumber(String phoneNumber) {
        PhoneNumber = phoneNumber;
    }



	public String getPassword() {
		return Password;
	}



	public void setPassword(String password) {
		Password = password;
	}
}
