package br.com.caelum.estoque.ws;

import javax.xml.ws.WebFault;

@WebFault(name="AutorizacaoFault")
public class AutorizacaoException extends RuntimeException {

	public AutorizacaoException() {
		super();
		// TODO Auto-generated constructor stub
	}

	public AutorizacaoException(String message) {
		super(message);
		// TODO Auto-generated constructor stub
	}
	
	

}
