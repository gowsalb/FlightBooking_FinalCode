package com.javatpoint.LoginAndRegistrationPage;

import java.net.PasswordAuthentication;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import com.javatpoint.LoginAndRegistrationPage.AdminLogin.CustomAuthenticationSuccessHandler;
 
@Configuration
public class WebSecurityConfig   {
     
	@Bean
    UserDetailsService userDetailsService() {
        return new CustomUserDetailsService();
    }
 
    @Bean
    PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
     
    
    @Bean
    public DaoAuthenticationProvider authenticationProvider() {
        DaoAuthenticationProvider authProvider = new DaoAuthenticationProvider();
        authProvider.setUserDetailsService(userDetailsService());
        authProvider.setPasswordEncoder(passwordEncoder());
         
        return authProvider;
    }
 
    @Bean
    SecurityFilterChain configure(HttpSecurity http) throws Exception {
         
        http.authenticationProvider(authenticationProvider());
         
        http.authorizeHttpRequests(auth ->
            auth.requestMatchers("/admin/**").hasAuthority("ADMIN")
            .requestMatchers("/users").hasAuthority("USER")
            .anyRequest().permitAll()
            )
            .formLogin(login ->
                login.usernameParameter("email")
                .successHandler(customSuccessHandler())
                .permitAll()
            )
            .logout(logout -> logout.logoutSuccessUrl("/").permitAll()
        );
        
        return http.build();
    }
    
    
//    @Bean
//    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
//        http.authorizeRequests().requestMatchers("/admin/**").hasRole("ADMIN")
//                .requestMatchers("/users")
//                .authenticated()
//                .and()
//                .formLogin()
//                .loginPage("/login")
//                .successHandler(customSuccessHandler())
//                .permitAll()
//                .and()
//                .logout()
//                .permitAll();
//        return http.build();
//    }
    
    @Bean
    public AuthenticationSuccessHandler customSuccessHandler() {
        return new CustomAuthenticationSuccessHandler();
    }
}
