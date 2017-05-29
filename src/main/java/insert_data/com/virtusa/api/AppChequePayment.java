package insert_data.com.virtusa.api;

import java.util.Random;

import models.Account;
import services.ChequePaymentService;
import randomize.GenerateRandom;

public class AppChequePayment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		int min = 0;
		int max = 1000;
		int maxOfPass = 2;
		double maxAccountBalance = 13.0;
		int minTransferAmount = 8;
		GenerateRandom randomObject = new GenerateRandom();

		for (int i = min; i < max; i++) {
			String dateOfTrnasfer = randomObject.generateRandomDate();
			//System.out.println("date : " + dateOfTrnasfer);
			String dateCreated = randomObject.generateRandomCreatedDate();
			//System.out.println("date created : " + dateCreated);
			String chequeNo = randomObject.generateRandomChequeNumber();
			//System.out.println("cheque number : " + chequeNo);
			String bank = randomObject.generateRandomBank();
			//System.out.println("bank : " + bank);
			System.out.println("pass: " + i + "================");

			Account account = new ChequePaymentService().getAccounts(i);
			if (account.getAccountId() == 0) {
				System.out.println("Account numbers cannot be zero");
				continue;
			}
			if (account.getBalance() > maxAccountBalance) {
				int newPageNumber = new Random().nextInt(max - min + 1) + min;
				if (newPageNumber != i) {
					Account _account = new ChequePaymentService().getAccounts(newPageNumber);
					if (_account.getAccountId() == 0) {
						System.out.println("Account number cannot be zero");
						continue;
					}
					double amount = (double) (new Random().nextInt((int) account.getBalance() - minTransferAmount + 1)
							+ minTransferAmount);

					// now call the endpoint
					new ChequePaymentService().makeChequePayment(amount, account.getPartyId(), account.getBankId(),
							account.getAccountId(), _account.getPartyId(), _account.getBankId(),
							_account.getAccountId(), dateOfTrnasfer, dateCreated, chequeNo, bank);

				}
			}
		}
	}
}