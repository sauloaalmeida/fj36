package br.com.caelum.jms;

import javax.jms.ConnectionFactory;
import javax.jms.JMSContext;
import javax.jms.JMSProducer;
import javax.jms.Topic;
import javax.naming.InitialContext;
import javax.naming.NamingException;

public class EnviaMensagensParaOTopico {
	
public static void main(String[] args) throws NamingException{
		
		InitialContext ic = new InitialContext();
		ConnectionFactory factory = (ConnectionFactory) ic.lookup("jms/RemoteConnectionFactory");
		Topic topico = (Topic)ic.lookup("jms/TOPICO.LIVRARIA");
		try(JMSContext context = factory.createContext("jms","jms2")){
			JMSProducer producerEbook = context.createProducer();
			producerEbook.setProperty("formato", "ebook");
		
			JMSProducer producerImpresso = context.createProducer();
			
			
			for (int i = 0; i < 1000; i++) {
				String msg =  "Mensagem Topico " + i;
				System.out.println(msg);
				
				if(i%2==0){
					producerEbook.send(topico, msg + " ebook");
				}else{
					producerImpresso.send(topico, msg);
				}
			}
			
			/*Scanner scanner =  new Scanner(System.in);
			while(scanner.hasNextLine()){
				String line = scanner.nextLine();
				producer.send(queue, line);
			}*/
		}
	}
	
	
}
