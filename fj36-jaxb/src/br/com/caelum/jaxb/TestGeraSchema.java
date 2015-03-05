package br.com.caelum.jaxb;

import java.io.File;
import java.io.IOException;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.SchemaOutputResolver;
import javax.xml.transform.Result;
import javax.xml.transform.stream.StreamResult;

public class TestGeraSchema {
	
	public static void main(String[] args) throws Exception{
		
		
		JAXBContext context = JAXBContext.newInstance(Livro.class);
		context.generateSchema(new SchemaOutputResolver() {
			
			@Override
			public Result createOutput(String namespaceUri, String suggestedFileName)
					throws IOException {
				// TODO Auto-generated method stub
				return new StreamResult(new File("schema.xsd"));
			}
		});
		
		
		
	}

}
