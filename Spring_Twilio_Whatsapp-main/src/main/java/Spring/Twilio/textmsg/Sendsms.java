package Spring.Twilio.textmsg;

import com.twilio.Twilio; 
import com.twilio.rest.api.v2010.account.Message; 
 
 
public class Sendsms { 
    // Find your Account Sid and Token at twilio.com/console 
    public static final String ACCOUNT_SID = "AC11daec51cb1fbbae5d6cef8f25cc5702"; 
    public static final String AUTH_TOKEN = "c2f8831533c869c5b16d98bf9c530d74"; 
 
    public static void main(String[] args) { 
        Twilio.init(ACCOUNT_SID, AUTH_TOKEN); 
        Message message = Message.creator( 
                new com.twilio.type.PhoneNumber("+919998766927"),  
                "MGb65d5d6ce4c4602554b3a5a041f75b55", 
                "Your Yummy Cupcakes Company order of 1 dozen frosted cupcakes has shipped and should be delivered on July 10, 2022. Details: http://www.yummycupcakes.com/")      
            .create(); 
 
        System.out.println(message.getSid()); 
    } 
}