package br.com.caelum.jaxb;

import java.io.FileOutputStream;
import java.math.BigDecimal;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;

public class TestMarshal {
	
	public static void main(String[] args) throws Exception{
		
		Categoria categoria = new Categoria();
		categoria.setNome("TI");
		
		Livro livro = new Livro();
		livro.setCodigo("ARQ");
		livro.setTitulo("Arquitetura Java");
		livro.setNomeAutor("Paulo Silveira");
		livro.setValor(new BigDecimal("29.9"));
		
		livro.setCategoria(categoria);
		
		JAXBContext context = JAXBContext.newInstance(Livro.class);
		Marshaller marshaller = context.createMarshaller();
		marshaller.marshal(livro, new FileOutputStream("livro.xml"));
		
		
	}

}
