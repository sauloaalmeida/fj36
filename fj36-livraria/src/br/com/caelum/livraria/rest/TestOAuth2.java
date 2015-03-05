package br.com.caelum.livraria.rest;

import java.net.URI;
import java.net.URISyntaxException;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import org.apache.oltu.oauth2.client.OAuthClient;
import org.apache.oltu.oauth2.client.URLConnectionClient;
import org.apache.oltu.oauth2.client.request.OAuthClientRequest;
import org.apache.oltu.oauth2.client.response.OAuthAccessTokenResponse;
import org.apache.oltu.oauth2.common.exception.OAuthProblemException;
import org.apache.oltu.oauth2.common.exception.OAuthSystemException;
import org.apache.oltu.oauth2.common.message.types.GrantType;


public class TestOAuth2 {
	
	public static void main(String[] args) throws OAuthSystemException, OAuthProblemException, URISyntaxException {
		String tokenEndPoint = "http://fj36webservicerest-oauthserver.herokuapp.com/oauth/token";	
		
		OAuthClientRequest request = OAuthClientRequest.tokenLocation(tokenEndPoint)
					.setGrantType(GrantType.PASSWORD)
					.setClientId("oauth2_client_id")
					.setClientSecret("oauth2_client_secret")
					.setUsername("fake_user")
					.setPassword("passwd")
					.buildBodyMessage();
		
		OAuthClient oAuthClient = new OAuthClient(new URLConnectionClient());
		OAuthAccessTokenResponse oauthRespose = oAuthClient.accessToken(request);
		
		System.out.println("Access Token = " + oauthRespose.getAccessToken());
		System.out.println("Expira em = " + oauthRespose.getExpiresIn());
		
		Client client = ClientBuilder.newClient();
		WebTarget target = client.target(new URI("http://fj36webservicerest-seguro.herokuapp.com/v1/pagamento/1"));
		
		String entity = target.request(MediaType.APPLICATION_XML_TYPE)
				.header("Authorization", "Bearer " + oauthRespose.getAccessToken()).get(String.class);
		
		System.out.println("Resposta: " + entity);
		
	}

}
