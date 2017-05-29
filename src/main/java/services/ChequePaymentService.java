package services;

import java.io.IOException;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import models.Account;
import okhttp3.MediaType;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.RequestBody;
import okhttp3.Response;

public class ChequePaymentService {

	public Account getAccounts(int page) {
		OkHttpClient client = new OkHttpClient();

		// http://52.14.112.17:8098/api-services-prod
		Request request = new Request.Builder()
				.url("http://52.14.112.17:8098/api-services-prodv2/account?page=" + page + "&size=1").get()
				.addHeader("accept", "*/*").addHeader("cache-control", "no-cache")
				.addHeader("postman-token", "b82408de-a10f-7b47-6f0e-51078c9923e5").build();

		try {
			Response response = client.newCall(request).execute();
			String jsonData = response.body().string();
			JSONObject jsonObject = new JSONObject(jsonData);

			JSONArray accounts = jsonObject.getJSONArray("content");
			JSONObject account = accounts.getJSONObject(0);

			// get accountId, partyId, bankId
			int accountId = account.getInt("accountId");//
			Double balance = account.getDouble("balance");//
			int bankId = account.getInt("bankId");//

			System.out.println("acc Id :" + accountId);
			JSONArray accountOwners = account.getJSONArray("accountOwners");
			JSONObject accountOwner = accountOwners.getJSONObject(0);
			JSONObject party = accountOwner.getJSONObject("party");

			int partyId = party.getInt("partyId");//
/*
			System.out.println(accountId);
			System.out.println(balance);
			System.out.println(partyId);*/

			return new Account(accountId, partyId, balance, bankId);

		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (JSONException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return new Account(0, 0, 0.0, 0);
	}

	public void makeChequePayment(double amount, int fromPartyId, int bankId, int accountId, int toPartyId,
			int toBankId, int toAccountId, String Date, String createdDate, String chequeNo, String bank) {

		OkHttpClient client = new OkHttpClient();

		MediaType mediaType = MediaType.parse("application/json");
		RequestBody body = RequestBody.create(mediaType,
				"{\n  \"checkPaymentInfo\": {\n    \"alterDate\": \"" + Date + "\",\n    \"bank\": \"" + bank
						+ "\",\n    \"chequeDate\": \"" + Date + "\",\n    \"chequeNumber\": \"" + chequeNo
						+ "\",\n    \"created\": \"" + createdDate
						+ "\"\n  },\n  \"paymentInfo\": {\n    \"alterDate\": \"" + Date + "\",\n    \"amount\": "
						+ amount + ",\n    \"created\": \"" + Date + "\",\n    \"fromPartyId\":" + fromPartyId
						+ ",\n    \"paymentNotes\": \"\",\n    \"paymentPeriod\": 0,\n    \"paymentStatus\": \"Approved\",\n    \"toPartyId\":"
						+ toPartyId + ",\n    \"tradeId\": 0,\n    \"transactionDate\": \"" + Date
						+ "\",\n    \"valueDate\": \"" + Date + "\"\n  },\n  \"transactionInfo\": {\n    \"acctId\":"
						+ accountId + ",\n    \"bankId\": " + bankId
						+ ",\n    \"bankLocation\": \"\",\n    \"counterpartyAcctId\": " + toAccountId
						+ ",\n    \"counterpartyBankId\": " + toBankId
						+ ",\n    \"counterpartyBankLocation\": \"\",\n    \"purpose\": \"\",\n    \"status\": \"\",\n    \"swiftCode\": 0,\n    \"swiftCodeTrace\": \"\",\n    \"transTime\": \""
						+ Date + "\",\n    \"transactionAmt\": " + amount + ",\n    \"transactionDate\": \"" + Date
						+ "\"\n  }\n}");
		Request request = new Request.Builder()
				.url("http://52.14.112.17:8098/api-services-prodv2/payment/insertCheckPayment").post(body)
				.addHeader("content-type", "application/json").addHeader("accept", "*/*")
				.addHeader("cache-control", "no-cache")
				.addHeader("postman-token", "59faa396-14f0-ffd8-4d09-392fd5d81739").build();

		try {
			Response response = client.newCall(request).execute();
			System.out.println("=================");
			System.out.println(response.body().string());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
