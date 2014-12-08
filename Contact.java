//Contact.java
// johnjoe landers - t00174319
import java.io.*;
public class Contact implements Serializable{
	
	private String forename;
	private String surname;
	private String email;
	
	
	
	// SET
	public void setForename(String forename){
		this.forename = forename;
		
	}
	
	public void setSurname(String surname){
		this.surname = surname;
	}
	
	public void setEmail(String email){
		this.email = email;
	}
	
	// GET
	public String getForename(){
		return this.forename;
	}
	public String getSurname(){
		return this.surname;
	}
	public String getEmail(){
		return this.email;
	}	
		
	
}
