package com.ecart.customer.security;

//@Configuration
public class OAuth2SecurityConfiguration {
/*
	public SecurityFilterChain filterChain(HttpSecurity httpSecurity) throws Exception {
		httpSecurity
			//enable for all requests
			//.authorizeHttpRequests().anyRequest().authenticated().and().oauth2Login();
			.authorizeHttpRequests(a -> a.requestMatchers("/persons-svc").permitAll().anyRequest().authenticated())
			.authorizeHttpRequests(a -> a.requestMatchers("/persons-svc/actuator/**").permitAll().anyRequest().authenticated())
			.authorizeHttpRequests(a -> a.requestMatchers("/persons-svc/swagger-ui/**").permitAll().anyRequest().authenticated())
			.authorizeHttpRequests(a -> a.requestMatchers("/persons-svc/v3/api-docs/**").permitAll().anyRequest().authenticated())
			//.exceptionHandling(e -> e.authenticationEntryPoint(new HttpStatusEntryPoint(HttpStatus.UNAUTHORIZED)))
			.oauth2Login();
		
		return httpSecurity.build();
	}*/
}
