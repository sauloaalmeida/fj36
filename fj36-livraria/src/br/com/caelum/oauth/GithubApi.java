package br.com.caelum.oauth;
 
import org.scribe.builder.api.DefaultApi20;
import org.scribe.model.OAuthConfig;
 
//classe de configuracao
public class GithubApi extends DefaultApi20 {
 
@Override
public String getAccessTokenEndpoint() {
//É utilizado pelo método getAccessToken() da classe OAuthService
return "https://github.com/login/oauth/access_token";
}
 
@Override
public String getAuthorizationUrl(OAuthConfig config) {
//URL do primeiro request para GitHub enviando Client_ID e scope (permissões)
//Client secret é opcional e Redirect URI está cadastrado no cadastro do GitHub
return String.format("https://github.com/login/oauth/authorize?scope=user:email&client_id=%s", config.getApiKey());
}
} 