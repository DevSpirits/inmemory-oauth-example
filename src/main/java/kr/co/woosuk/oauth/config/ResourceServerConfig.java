package kr.co.woosuk.oauth.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.oauth2.config.annotation.web.configuration.EnableResourceServer;
import org.springframework.security.oauth2.config.annotation.web.configuration.ResourceServerConfigurerAdapter;
import org.springframework.security.oauth2.config.annotation.web.configurers.ResourceServerSecurityConfigurer;
import org.springframework.security.oauth2.provider.error.OAuth2AccessDeniedHandler;

@Configuration
@EnableResourceServer
public class ResourceServerConfig extends ResourceServerConfigurerAdapter{
	
	@Override
	public void configure(ResourceServerSecurityConfigurer resources) {
		resources.resourceId("resource_id").stateless(false);
	}
	
	/**
	 *  인증 설정
	 */
	@Override
	public void configure(HttpSecurity http) throws Exception{
		
		http.anonymous().disable()
			.authorizeRequests()
			.antMatchers("/users/**").authenticated()
			.and()
			.exceptionHandling()
			.accessDeniedHandler(new OAuth2AccessDeniedHandler());
			
	}
}
