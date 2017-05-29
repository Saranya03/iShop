package models;

public class Person {

	private String firstName;
	private String lastName;
	private String loginId;
	private int partyId;
	
	public Person(String fName,String lNAme, int partyId){
		this.firstName = fName;
		this.lastName = lNAme;
		if(firstName.length()!=0 && lastName.length()!=0){
		this.loginId = lastName.toLowerCase().charAt(0) + firstName.toLowerCase();
		}
		this.partyId = partyId;
	}
	
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}
	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}
	public int getPartyId() {
		return partyId;
	}
	public void setPartyId(int partyId) {
		this.partyId = partyId;
	}
	public String getLoginId() {
		return loginId;
	}
	public void setLoginId(String loginId) {
		this.loginId = loginId;
	}
	
	
}
