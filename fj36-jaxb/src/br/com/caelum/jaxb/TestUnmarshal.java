package br.com.caelum.jaxb;

import java.io.FileInputStream;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.Unmarshaller;

public class TestUnmarshal {
	
	public static void main(String[] args) throws Exception{
		
		JAXBContext context = JAXBContext.newInstance(Livro.class);
		Unmarshaller unmarshaller = context.createUnmarshaller();
		Livro livro = (Livro)unmarshaller.unmarshal(new FileInputStream("livro.xml"));
		System.out.println(livro);
		
	}

}
