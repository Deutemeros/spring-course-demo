package com.memoria.fastmath.configuration;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;;

@Configuration
@EnableWebSecurity
public class SpringSecurityConfig {

	@Autowired
	private CustomUserDetailsService customUserDetailsService;

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http.authorizeHttpRequests((auth) -> {
			auth.requestMatchers(HttpMethod.GET, "/api/field").hasAuthority("field:read");
			auth.requestMatchers(HttpMethod.GET, "/api/field/*").hasAuthority("field:read");
			auth.requestMatchers(HttpMethod.POST, "/api/field").hasAuthority("field:save");
			auth.requestMatchers(HttpMethod.POST, "/api/field/*").hasAuthority("field:save");
			auth.requestMatchers(HttpMethod.DELETE, "/api/field/*").hasAuthority("field:delete");
			auth.requestMatchers(HttpMethod.GET, "/api/figure").hasAuthority("figure:read");
			auth.requestMatchers(HttpMethod.GET, "/api/figure/*").hasAuthority("figure:read");
			auth.requestMatchers(HttpMethod.POST, "/api/figure").hasAuthority("figure:save");
			auth.requestMatchers(HttpMethod.POST, "/api/figure/*").hasAuthority("figure:save");
			auth.requestMatchers(HttpMethod.DELETE, "/api/figure/*").hasAuthority("figure:delete");
			auth.anyRequest().permitAll();
		}).formLogin(Customizer.withDefaults()).build();
	}

	@Bean
	public AuthenticationManager authenticationManager(HttpSecurity http, BCryptPasswordEncoder bCryptPasswordEncoder)
			throws Exception {
		AuthenticationManagerBuilder authenticationManagerBuilder = http
				.getSharedObject(AuthenticationManagerBuilder.class);
		authenticationManagerBuilder.userDetailsService(customUserDetailsService)
				.passwordEncoder(bCryptPasswordEncoder);
		return authenticationManagerBuilder.build();
	}
	
	@Bean
	public BCryptPasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

}