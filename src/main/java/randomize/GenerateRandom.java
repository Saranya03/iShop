package randomize;

import java.util.Random;
import org.joda.time.LocalDateTime;

public class GenerateRandom {
	private int day=24;
	private int month=2;
	private int year=2015;
	
		public String generateRandomDate(){
		Random random = new Random();
        LocalDateTime randomTime = new LocalDateTime(random.nextLong());
        LocalDateTime randomDate = randomTime.withDayOfMonth(day).withMonthOfYear(month).withYear(year);
        return randomDate.toString()+"Z";
	}
	
	public String generateRandomCreatedDate(){
		Random random = new Random();		
        LocalDateTime randomTime = new LocalDateTime(random.nextLong());
        LocalDateTime randomDate = randomTime.withDayOfMonth(day).withMonthOfYear(month-1).withYear(year);
        return randomDate.toString()+"Z";
	}
	
	public String generateRandomChequeNumber(){
		String characters[] = {"-","#","%","$"};
		int randomIndex = new Random().nextInt(characters.length);
        String randChequeNo = String.valueOf((new Random()).nextInt(900) + 100);
        return characters[randomIndex] + randChequeNo;
	}
	
	public String generateRandomRoutingNumber(){
		String characters[] = {".",",","\\","="};
		int randomIndex = new Random().nextInt(characters.length);
        String randChequeNo = String.valueOf((new Random()).nextInt(900000000) + 100000000);
        return characters[randomIndex] + randChequeNo;
	}
	
	public String generateRandomBank(){
		String banks[] = {"Citi","HSBC","Chase","Capital One"};
		Random generator = new Random();
		int randomIndex = generator.nextInt(banks.length);
		return banks[randomIndex];
	}
	
	
	//----------for user login
	public String generateRandomRole(){
		String roles[] = {"user","administrator","super_user","super_administrator","operator"};
		Random generator = new Random();
		int randomIndex = generator.nextInt(roles.length);
		return roles[randomIndex];
	}
	
	public String generateRandomEmail(String loginId){
		String domain[] = {"gmail.com","yahoo.com","hotmail.com"};
		Random generator = new Random();
		int randomIndex = generator.nextInt(domain.length);
		return loginId + "@" + domain[randomIndex];
	}
	
	
	
	
}
