package br.com.caelum.jms;

import javax.ejb.ActivationConfigProperty;
import javax.ejb.MessageDriven;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

@MessageDriven(activationConfig={
		@ActivationConfigProperty(propertyName="destinationLookup",propertyValue="jms/TOPICO.LIVRARIA"),
		@ActivationConfigProperty(propertyName="destinationType",propertyValue="javax.jms.Topic"),
		@ActivationConfigProperty(propertyName="acknowledgeMode",propertyValue="Auto-acknowledge"),
		@ActivationConfigProperty(propertyName="subscriptionDurability",propertyValue="Durable"),
		@ActivationConfigProperty(propertyName="subscriptionName",propertyValue="AssinaturaFinanceiro"),
		@ActivationConfigProperty(propertyName="clientId",propertyValue="Financeiro")
})
public class FinanceiroMDB implements MessageListener {

	@Override
	public void onMessage(Message msg) {
		
		TextMessage textMessage = (TextMessage) msg;
		
		try {
			System.out.println("Gerando notas para topico do Financeiro: " + textMessage.getText());
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

}
