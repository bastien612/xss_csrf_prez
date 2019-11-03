//package com.laboratoire.checklist.controller.security;
//
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.beans.factory.annotation.Value;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.authentication.AuthenticationManager;
//import org.springframework.security.crypto.password.PasswordEncoder;
//import org.springframework.security.oauth2.config.annotation.configurers.ClientDetailsServiceConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configuration.AuthorizationServerConfigurerAdapter;
//import org.springframework.security.oauth2.config.annotation.web.configuration.EnableAuthorizationServer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerEndpointsConfigurer;
//import org.springframework.security.oauth2.config.annotation.web.configurers.AuthorizationServerSecurityConfigurer;
//import org.springframework.security.oauth2.provider.token.TokenStore;
//
//
//@Configuration
////@EnableAuthorizationServer
//public class AuthorizationServerConfiguration extends AuthorizationServerConfigurerAdapter {
//
//    private final String GRANT_TYPE_PASSWORD = "password";
//    private final String GRANT_TYPE_REFRESH_TOKEN = "refresh_token";
//    private final String SCOPE_READ = "read";
//    private final String SCOPE_WRITE = "write";
//    private final String SCOPE_TRUST = "trust";
//
//    @Value("security.client-id")
//    private String clientId;
//
//    @Value("security.client-secret")
//    private String clientSecret;
//
//    @Value("${security.access-token-validity}")
//    private String accessTokenValidity;
//
//    @Value("${security.refresh-token-validity}")
//    private String refreshTokenValidity;
//
//    @Autowired
//    @Qualifier("authenticationManagerBean")
//    private AuthenticationManager authenticationManager;
//
//    @Autowired
//    private PasswordEncoder encoder;
//
//    @Autowired
//    private TokenStore tokenStore;
//
//
//    @Override
//    public void configure(AuthorizationServerSecurityConfigurer security) throws Exception {
//        security.tokenKeyAccess("permitAll()");
////                .checkTokenAccess("isAuthenticated()");
//    }
//
//    @Override
//    public void configure(ClientDetailsServiceConfigurer clients) throws Exception {
//        clients.inMemory()
//                .withClient("check1")
//                .secret(encoder.encode("check1"))
//                .authorizedGrantTypes(GRANT_TYPE_PASSWORD, GRANT_TYPE_REFRESH_TOKEN)
//                .scopes(SCOPE_READ, SCOPE_WRITE, SCOPE_TRUST)
//                .accessTokenValiditySeconds(Integer.parseInt(accessTokenValidity))
//                .refreshTokenValiditySeconds(Integer.parseInt(refreshTokenValidity));
//    }
//
//    @Override
//    public void configure(AuthorizationServerEndpointsConfigurer endpoints) throws Exception {
//        endpoints.tokenStore(this.tokenStore)
//                .authenticationManager(authenticationManager);
//    }
//}
