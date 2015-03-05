package br.com.caelum.estoque.rmi;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.HashMap;
import java.util.Map;

public class EstoqueService extends UnicastRemoteObject implements EstoqueRmi{
	
	private Map<String, ItemEstoque> repositorio = new HashMap<String, ItemEstoque>();

	public EstoqueService() throws RemoteException{
		repositorio.put( "SOA", new ItemEstoque("SOA" , 2));
		repositorio.put( "TDD", new ItemEstoque("TDD" , 3));
		repositorio.put( "RES", new ItemEstoque("RES" , 4));
		repositorio.put( "LOG", new ItemEstoque("LOG" , 3));
		repositorio.put( "WEB", new ItemEstoque("WEB" , 4));
		repositorio.put( "ARQ", new ItemEstoque("ARQ" , 5));
	}
	
	public ItemEstoque getItemEstoque(String codProduto) throws RemoteException{
		System.out.println("verificando estoque produto: " + codProduto);
		return this.repositorio.get(codProduto);
	}
	
	

}
