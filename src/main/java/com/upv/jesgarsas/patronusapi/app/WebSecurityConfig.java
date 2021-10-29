package com.upv.jesgarsas.patronusapi.app;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.upv.jesgarsas.patronusapi.app.model.dto.filter.JWTAuthorizationFilter;
import com.upv.jesgarsas.patronusapi.app.utils.RolTypes;

@Configuration
@EnableGlobalMethodSecurity(prePostEnabled = true, securedEnabled = true, jsr250Enabled = true)
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http.cors().and().csrf().disable()
				.addFilterAfter(new JWTAuthorizationFilter(), UsernamePasswordAuthenticationFilter.class)
				.authorizeRequests()
				.mvcMatchers("**/alumno/**").hasAnyAuthority(RolTypes.getAllRoles())
				.mvcMatchers("**/profesor/**").hasAnyAuthority(RolTypes.PROFESOR, RolTypes.ADMINISTRADOR)
				.mvcMatchers("**/administrador/**").hasAnyAuthority(RolTypes.ADMINISTRADOR)
				.mvcMatchers(HttpMethod.POST, "**/usuario/login").permitAll()
				.mvcMatchers(HttpMethod.GET, "**/proyecto/download/**").permitAll()
				.anyRequest()
				.authenticated();
	}

	@Bean
	public WebMvcConfigurer corsConfigurer() {
		return new WebMvcConfigurer() {
			@Override
			public void addCorsMappings(CorsRegistry registry) {
				registry.addMapping("/**").allowedMethods("*");
			}
		};
	}
}