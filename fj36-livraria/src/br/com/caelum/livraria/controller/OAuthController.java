package br.com.caelum.livraria.controller;

import javax.annotation.PostConstruct;

import org.scribe.builder.ServiceBuilder;
import org.scribe.model.OAuthRequest;
import org.scribe.model.Response;
import org.scribe.model.Token;
import org.scribe.model.Verb;
import org.scribe.model.Verifier;
import org.scribe.oauth.OAuthService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import br.com.caelum.oauth.GithubApi;

//Docu: https://github.com/fernandezpablo85/scribe-java

@Controller
@RequestMapping("/oauth")
public class OAuthController {
	private final Token EMPTY_TOKEN = null;
	private OAuthService service;
	@PostConstruct
	public void prepareOAuthService() {
		this.service = new ServiceBuilder()
		.provider(GithubApi.class)
		.apiKey("e8f8fcff4f0d365f7ba5")
		.apiSecret("209c5c78298bf2ba32b0db7f72383ad1d069dcb7")
		.callback("http://localhost:8088/fj36-livraria/oauth/callback")
		.build();
	}
	@RequestMapping("/index")
	public String oauthIndex() {
		return "oauth-index";
	}
	@RequestMapping("/login-github")
	public String redirectToGithub() {
		String authorizationUrl = service.getAuthorizationUrl(EMPTY_TOKEN);
		return "redirect:" + authorizationUrl;
	}
	@RequestMapping("/callback")
	public String callback(@RequestParam("code") String autenticationToken, Model model) {
		Verifier verifier = new Verifier(autenticationToken);
		//request para pegar o access token
		Token accessToken = service.getAccessToken(EMPTY_TOKEN, verifier);
		String token = accessToken.getToken();
		//System.out.println("RAW_RESPONSE: " + accessToken.getRawResponse());
		model.addAttribute("accessToken", token);
		model.addAttribute("autenticationToken", autenticationToken);
		return "oauth-logado";
	}
	@RequestMapping("/githubRequest")
	public String githubRequest(@RequestParam("accessToken") String token, RedirectAttributes redirectAttributes) {
		token = token.trim();
		OAuthRequest request = new OAuthRequest(Verb.GET, "https://api.github.com/user/emails");
		request.addBodyParameter("access_token", token);

		service.signRequest(new Token(token, ""), request);
		Response response = request.send();
		String body = response.getBody();
		redirectAttributes.addFlashAttribute("responseBody", body);
		return "redirect:logado";
	}
	@RequestMapping("/logado")
	public String logado() {
		return "oauth-logado";
	}
} 