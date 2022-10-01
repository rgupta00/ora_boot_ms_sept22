package com.productapp.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
@Component
@EnableWebSecurity//(debug = true)
public class SecConfig extends WebSecurityConfigurerAdapter{
	
	@Autowired
	private UserDetailsService userDetailsService;
	
	//used to do authentication 401
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth.userDetailsService(userDetailsService);
	}
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
		
		//return NoOpPasswordEncoder.getInstance();
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		web.ignoring()
		.antMatchers("/h2/**");
	}

	//used to do autherization 403
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.csrf().disable()
		.authorizeRequests()
		.antMatchers("/products/**").hasAnyRole("ADMIN","MGR")
		.antMatchers("/home/**").permitAll()
		.and()
		.httpBasic()
		.and()
		.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
		
	}

	
	
}







//auth.inMemoryAuthentication()
//.withUser("raj").password("raj123").roles("ADMIN")
//.and()
//.withUser("ekta").password("ekta123").roles("MGR");



//.antMatchers(HttpMethod.GET,"/products/**").hasAnyRole("MGR")
//.antMatchers(HttpMethod.POST,"/products/**").hasAnyRole("ADMIN")
//.antMatchers(HttpMethod.GET,"/products/**").hasAnyRole("ADMIN")
//.antMatchers(HttpMethod.PUT,"/products/**").hasAnyRole("ADMIN")
//.antMatchers(HttpMethod.DELETE,"/products/**").hasAnyRole("ADMIN")


//.antMatchers("/products/**").hasAnyRole("ADMIN","MGR")

//.antMatchers("/accounts/**").hasAnyRole("ADMIN")
//.antMatchers("/transaction/**").hasAnyRole("ADMIN","MGR")
//.antMatchers("/home/**").permitAll()




