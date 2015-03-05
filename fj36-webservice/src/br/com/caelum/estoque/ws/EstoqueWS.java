package br.com.caelum.estoque.ws;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebResult;
import javax.jws.WebService;

@WebService(targetNamespace="http://ws.estoque.caelum.com.br/estoquews/v2")
public class EstoqueWS {
	
	private Map<String, ItemEstoque> repositorio = new HashMap<String, ItemEstoque>();

	public EstoqueWS(){
		repositorio.put( "SOA", new ItemEstoque("SOA" , 5));
		repositorio.put( "TDD", new ItemEstoque("TDD" , 1));
		repositorio.put( "RES", new ItemEstoque("RES" , 2));
		repositorio.put( "LOG", new ItemEstoque("LOG" , 4));
		repositorio.put( "WEB", new ItemEstoque("WEB" , 1));
		repositorio.put( "ARQ", new ItemEstoque("ARQ" , 2));
	}
	
	@WebMethod(operationName="ItensPeloCodigo")
	@WebResult(name="ItemEstoque")
	public List<ItemEstoque> getQuantidade(@WebParam(name="codigo") List<String> codigos,
										@WebParam(name="token",header=true) String token) {
		List<ItemEstoque> listaRetorno = new ArrayList<ItemEstoque>();
		
		if(!"TOKEN123".equals(token)){
			throw new AutorizacaoException("Nao autorizado");
		}
		
		if(codigos == null || codigos.isEmpty()){
			return listaRetorno;
		}
		
		System.out.println("verificando estoque produto no ws: " + codigos);
		
		
		
		for (String codigo : codigos) {
			if(repositorio.containsKey(codigo)){
				listaRetorno.add(repositorio.get(codigo));
			}
		}
		
		return listaRetorno;
	}

}
