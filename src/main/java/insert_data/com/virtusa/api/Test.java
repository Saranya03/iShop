package insert_data.com.virtusa.api;

import models.Person;
import randomize.GenerateRandom;
import services.UserLoginServices;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		for(int i=0;i<10;i++){
			
			if(i==2 || i==3){
				continue;
			}
			System.out.println("pass : " + i);
	Person p=new UserLoginServices().getPerson(i);
	System.out.println(p.getFirstName());
	System.out.println(p.getLastName());
	System.out.println(p.getLoginId());
	System.out.println(new GenerateRandom().generateRandomEmail(p.getLoginId()));
		}
	}

}
