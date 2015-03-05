package br.com.caelum.estoque.rmi;

import java.rmi.Naming;

public class ClientRmi {
	
	public static void main(String[] args) throws Exception{
		
		EstoqueRmi estoqueRmi = (EstoqueRmi) Naming.lookup("rmi://192.168.0.212:1099/estoque");
		System.out.println(estoqueRmi.toString());
		
		ItemEstoque item = estoqueRmi.getItemEstoque("SOA");
		System.out.println(String.format("Item: '%s'. Quantidade disponivel: %d ",item.getCodigo(),item.getQuantidade()));
		
	}

}
