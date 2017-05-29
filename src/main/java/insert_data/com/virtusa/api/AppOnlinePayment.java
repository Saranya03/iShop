package insert_data.com.virtusa.api;

import java.util.Random;

import models.Account;
import randomize.GenerateRandom;
import services.OnlinePaymentService;

/**
 * Hello world!
 *
 */
public class AppOnlinePayment {
	public static void main(String[] args) {
		int min = 55677;
		int max = 65000;
		double maxAccountBalance = 50.0;
		int minTransferAmount = 8;
		GenerateRandom randomObject = new GenerateRandom();

		for (int i = min; i < max; i++) {
			System.out.println("Pass : " + i + " =============================");
			String dateOfTrnasfer = new GenerateRandom().generateRandomDate();

			Account account = new OnlinePaymentService().getAccounts(i);
			if (account.getAccountId() == 0) {
				System.out.println("Account numbers cannot be zero");
				continue;
			}
			if (account.getBalance() > maxAccountBalance) {
				int newPageNumber = new Random().nextInt(max - min + 1) + min;
				if (newPageNumber != i) {
					Account _account = new OnlinePaymentService().getAccounts(newPageNumber);
					if (_account.getAccountId() == 0) {
						System.out.println("Account numbers cannot be zero");
						continue;
					}
					double amount = (double) (new Random().nextInt((int) account.getBalance() - minTransferAmount + 1)
							+ minTransferAmount);

					// now call the endpoint
					new OnlinePaymentService().makePayment(amount, account.getPartyId(), account.getBankId(),
							account.getAccountId(), _account.getPartyId(), _account.getBankId(),
							_account.getAccountId(), dateOfTrnasfer);
				}
			}
		}
	}
}
