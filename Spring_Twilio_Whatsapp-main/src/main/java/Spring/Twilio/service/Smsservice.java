package Spring.Twilio.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.twilio.rest.api.v2010.account.Message;
import com.twilio.rest.verify.v2.service.Verification;
import com.twilio.rest.verify.v2.service.VerificationCreator;
import com.twilio.sdk.Twilio;
import com.twilio.type.PhoneNumber;

import Spring.Twilio.Smsrequest;

@Service
public class Smsservice {

	@Autowired
	private final Twilioproperties twilioproperties;

	public Smsservice(Twilioproperties twilioproperties) {
		this.twilioproperties = twilioproperties;
	}

	public String sendsms(Smsrequest smsrequest) {
		// note: 1. if you want to send normal text sms remove string ("whatsapp:") in
		// below message creator
		// 2. if you want to send whatsapp message "whatsapp:" string to be added before
		// the numbers

		System.err.println("whatsapp TO: " + smsrequest.getNumber());
		System.err.println("whatsapp From :" + twilioproperties.getFromNumber());
		System.err.println("message: " + smsrequest.getMessage());
		System.err.println("getAccountSid :" + twilioproperties.getAccountSid());
		System.err.println("whatsapp From :" + twilioproperties.getAuthToken());

		// Twilio.init(twilioproperties.getAccountSid(),
		// twilioproperties.getAuthToken());
		Message message = Message
				.creator(new PhoneNumber("whatsapp:" + smsrequest.getNumber()),
						new PhoneNumber("whatsapp:" + twilioproperties.getFromNumber()), smsrequest.getMessage())
				.create();
		return message.getStatus().toString();

	}

//	public String sendotp(Smsrequest smsrequest)
//	{
//        //note: 1. if you want to send normal text sms remove string ("whatsapp:") in below message creator
//		//      2. if you want to send whatsapp message "whatsapp:" string to be added before the numbers
//		
//		System.err.println("whatsapp: "+smsrequest.getNumber());
//		System.err.println("whatsapp From :"+twilioproperties.getFromNumber());
//		System.err.println("message: "+smsrequest.getMessage());
//		
//		
//		System.err.println("getAccountSid :"+twilioproperties.getAccountSid());
//		System.err.println("whatsapp From :"+twilioproperties.getAuthToken());
//		
//		//Twilio.init(twilioproperties.getAccountSid(), twilioproperties.getAuthToken());
//		Verification verification = Verification.creator(
//				twilioproperties.getAccountSid(),
//				smsrequest.getNumber(),
//	            "whatsapp")
//	        .create();
//        return verification.getStatus().toString();
//        
//	
//	}
}
