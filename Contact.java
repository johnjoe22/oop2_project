import java.io.*;
public class Contact implements Serializable{
	
	String forename;
	String surname;
	String email;
		
	public void Contact(){
		forename = "";
		surname = "";
		email = "";
	}
	
	public void Contact(String forename,String surname, String email){
		this.setForename(forename);
		this.setSurname(surname);
		this.setEmail(email);
	}
	
	
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
		return this.forename+"\n";
	}
	public String getSurname(){
		return this.surname+"\n";
	}
	public String getEmail(){
		return this.email+"\n";
	}
}