package br.com.caelum.estoque.rmi;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

public class RegistraERodaService {
	
	public static void main(String[] args) throws Exception{
		
		LocateRegistry.createRegistry(1099);
		Naming.rebind("/estoque", new EstoqueService());
		System.out.println("------------_RMI REGISTRADO E RODANDO NA 1099 ----------------");
		
	}

}
