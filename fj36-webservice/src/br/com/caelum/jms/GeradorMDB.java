package br.com.caelum.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig={
		@ActivationConfigProperty(propertyName="destinationLookup",propertyValue="jms/FILA.GERADOR"),
		@ActivationConfigProperty(propertyName="destinationType",propertyValue="javax.jms.Queue"),
		@ActivationConfigProperty(propertyName="clientId",propertyValue="GeradorEbook"),
		@ActivationConfigProperty(propertyName="messageSelector",propertyValue="formato='ebook'")
})
public class GeradorMDB implements MessageListener {

	@Override
	public void onMessage(Message msg) {
		
		TextMessage textMessage = (TextMessage) msg;
		
		try {
			System.out.println("Gerando notas Fila gerador: " + textMessage.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
