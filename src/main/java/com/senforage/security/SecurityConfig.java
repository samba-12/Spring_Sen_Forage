package com.senforage.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter{
	
	//@Autowired
	//BCryptPasswordEncoder bCryptPasswordEncoder;
	
	@Autowired
	private DataSource dataSource;
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		
		/*
		 * BCryptPasswordEncoder bcpe = getBCPE();
		 * System.out.println(bcpe.encode("samba"));
		 * System.out.println(bcpe.encode("dame"));
		 */

		/*
		auth.inMemoryAuthentication().withUser("admin").password(bcpe.encode("passer")).roles("ADMIN", "USER");
		auth.inMemoryAuthentication().withUser("user").password(bcpe.encode("passer")).roles("USER");
		auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder());
		*/

		auth.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select username as principal, password as credentials, active from users where username=?")
			.authoritiesByUsernameQuery("select username as principal, roles as roles from users_roles where username=?")
			.rolePrefix("ROLE_");
	}
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.formLogin().loginPage("/login");
		http.authorizeRequests().antMatchers("/admin/**").hasRole("ADMIN");
		http.authorizeRequests().antMatchers("/user/**").hasRole("USER");
		http.exceptionHandling().accessDeniedPage("/403");
	}

	@Bean
    public PasswordEncoder passwordEncoder(){
        PasswordEncoder encoder = new BCryptPasswordEncoder();
        return encoder;
    }
	/*
	 * @Bean BCryptPasswordEncoder getBCPE() { return new BCryptPasswordEncoder();
	 * 
	 * }
	 */
}




