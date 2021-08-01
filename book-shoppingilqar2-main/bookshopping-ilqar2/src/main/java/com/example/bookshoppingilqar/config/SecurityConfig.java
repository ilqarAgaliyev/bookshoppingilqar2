package com.example.bookshoppingilqar.config;

////
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.http.SessionCreationPolicy;
@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {
	


    @Override
    protected void configure(HttpSecurity http) throws Exception {
    	http.sessionManagement()
        .sessionCreationPolicy(SessionCreationPolicy.ALWAYS);
		http.authorizeRequests().antMatchers("/**/*.css").permitAll()
		
		.antMatchers("/book-shopping").permitAll()
		
		.and().formLogin().loginPage("/book-shopping/customLogin")
		.and().logout().permitAll();

    }

}
