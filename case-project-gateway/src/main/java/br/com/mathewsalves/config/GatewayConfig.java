package br.com.mathewsalves.config;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.BeanIds;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import br.com.mathewsalves.jwt.filter.JwtAuthenticationTokenFilter;

@Configuration
@EnableWebSecurity
@EnableGlobalMethodSecurity(prePostEnabled = true)
public class GatewayConfig extends WebSecurityConfigurerAdapter{
	
	private static final String[] PUBLIC_POST = { "/case-project-candidate/"};
	
//	private static final String[] OPERATOR = { "/hr-worker/**" };
//	
//	private static final String[] ADMIN = { "/hr-payroll/**", "/hr-user/**", "/actuator/**", "/hr-worker/actuator/**", "/hr-oauth/actuator/**" };
//	
	@Bean(name = BeanIds.AUTHENTICATION_MANAGER)
	@Override
	public AuthenticationManager authenticationManagerBean() throws Exception {
		return super.authenticationManagerBean();
	}
	
	@Autowired
	private JwtAuthenticationEntryPoint unauthorizedHandler;
	
	@Bean
	public JwtAuthenticationTokenFilter authenticationTokenFilterBean() throws Exception {
		return new JwtAuthenticationTokenFilter();
	}

	@Override
    protected void configure(HttpSecurity http) throws Exception {
		
		http
		.csrf()
		.disable()
		.exceptionHandling()
		.authenticationEntryPoint(unauthorizedHandler)
    	.and().sessionManagement()
    	.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
    	.and().authorizeRequests()
		.antMatchers(HttpMethod.POST, PUBLIC_POST).permitAll()
		.antMatchers(HttpMethod.DELETE, PUBLIC_POST).permitAll()
		.antMatchers("/case-project-auth/**").permitAll()
		.anyRequest().authenticated();
		
		http.addFilterBefore(authenticationTokenFilterBean(), UsernamePasswordAuthenticationFilter.class);
		http.headers().cacheControl();
    }
}
