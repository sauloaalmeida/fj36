package br.com.caelum.jms;

import java.util.Scanner;

import javax.jms.ConnectionFactory;
import javax.jms.JMSConsumer;
import javax.jms.JMSContext;
import javax.jms.Topic;
import javax.naming.InitialContext;

public class RegistraFinanceiroNoTopico {
	
	public static void main(String[] args) throws Exception{
		
		InitialContext ic = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) ic.lookup("jms/RemoteConnectionFactory");
		Topic topic = (Topic)ic.lookup("jms/TOPICO.LIVRARIA");
		try(JMSContext context = factory.createContext("jms","jms2")){
			context.setClientID("Financeiro");
			JMSConsumer consumer = context.createDurableConsumer(topic,"AssinaturasNotas");
			consumer.setMessageListener(new TratadorDeMensagem());
			context.start();
			
			Scanner teclado = new Scanner(System.in);
			System.out.println("Financeiro esperando mensagem do topico ");
			
			teclado.nextLine();
			
			teclado.close();
			context.stop();
			context.close();
					
		}
		
	}
	

}
