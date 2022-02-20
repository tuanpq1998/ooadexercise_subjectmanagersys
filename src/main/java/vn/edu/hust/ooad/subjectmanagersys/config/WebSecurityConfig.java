package vn.edu.hust.ooad.subjectmanagersys.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import vn.edu.hust.ooad.subjectmanagersys.service.UserService;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserService userSerive;
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}
	
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		DaoAuthenticationProvider provider = new DaoAuthenticationProvider();
		provider.setPasswordEncoder(passwordEncoder());
		provider.setUserDetailsService(userSerive);
		auth.authenticationProvider(provider);
	}

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
		.authorizeRequests()
//			.antMatchers("/staff/**", "/student**").authenticated()
			.antMatchers("/staff/**").hasRole("STAFF")
			.antMatchers("/student/**").hasRole("STUDENT")
			.antMatchers("/", "/css/**", "/js/**", "/img/**").permitAll()
			.and().formLogin().loginPage("/login")
			.loginProcessingUrl("/login")
			.successHandler(myCustomSuccessHandler())
			.permitAll()
			.and().logout()
				.logoutRequestMatcher(new AntPathRequestMatcher("/logout"))
				.logoutSuccessUrl("/login?out").permitAll()
			.and().exceptionHandling().accessDeniedPage("/error")
			.and()
    .csrf().disable().cors();
	}

	@Bean
	public AuthenticationSuccessHandler myCustomSuccessHandler() {
		return new CustomSuccessHandler();
	}

	
}
