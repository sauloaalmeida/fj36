package br.com.caelum.jms;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

public class TratadorDeMensagem implements MessageListener{

	@Override
	public void onMessage(Message msg) {
		TextMessage textMessage = (TextMessage) msg;
		
		try {
			System.out.println("Tratador recebeu a messagem: " + textMessage.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
		
	}
	
	

}
