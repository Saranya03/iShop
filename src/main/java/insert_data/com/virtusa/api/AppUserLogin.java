package insert_data.com.virtusa.api;

import models.Person;
import randomize.GenerateRandom;
import services.UserLoginServices;

public class AppUserLogin {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int min =154770;
		int max =200000;
		int blockChainContract = 123344;
		
		for(int i=min;i<max;i++){
			System.out.println("pass : " + i);
			if(i==54 || i==2 || i==393 || i==979 || i==652){
				continue;
			}
			
			Person person = new UserLoginServices().getPerson(i);
			String email = new GenerateRandom().generateRandomEmail(person.getLoginId());
			blockChainContract++;
			if(person.getFirstName().length()!=0 && person.getLastName().length()!=0){
				new UserLoginServices().insertUserLogin(blockChainContract,email,person.getFirstName(),person.getLastName(), person.getLoginId(),person.getPartyId());
			}
		}
	}
}
