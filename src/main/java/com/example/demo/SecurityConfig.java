package com.example.demo;

import com.example.demo.entity.Account;
import com.example.demo.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationTrustResolver;
import org.springframework.security.config.annotation.ObjectPostProcessor;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.accept.ContentNegotiationStrategy;

import java.util.NoSuchElementException;
import java.util.stream.Collectors;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Autowired
    private AccountService service;
//    @Autowired
//    private BCryptPasswordEncoder pe;

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(username -> {
            try {
                Account user = service.findById(username);
//                String password = pe.encode(user.getPassword());
                String password = user.getPassword();
                String[] role = user.getAuthorities().stream().map(er -> er.getRole().getId()).collect(Collectors.toList()).toArray(new String[0]);
                return User.withUsername(username).password(password).roles(role).build();
            }catch (NoSuchElementException e){
                throw new UsernameNotFoundException(username + " Not found!");
            }
        });
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.csrf().disable();
        http.authorizeHttpRequests()
                .antMatchers("/order/**").authenticated()
                .antMatchers("/admin/**").hasAnyRole("STAF", "DIRE")
                .antMatchers("/api/rest/authorities").hasRole("DIRE")
                .anyRequest().permitAll();
        http.formLogin()
                .loginPage("/security/login/form")
                .loginProcessingUrl("/security/login")
                .defaultSuccessUrl("/security/login/success", false)
                .failureUrl("/security/login/error");
        http.rememberMe()
                .tokenValiditySeconds(86400);
        http.exceptionHandling()
                .accessDeniedPage("/security/unauthoried");
    }
    protected SecurityConfig() {
        super();
    }

    protected SecurityConfig(boolean disableDefaults) {
        super(disableDefaults);
    }

    @Override
    public AuthenticationManager authenticationManagerBean() throws Exception {
        return super.authenticationManagerBean();
    }

    @Override
    protected AuthenticationManager authenticationManager() throws Exception {
        return super.authenticationManager();
    }

    @Override
    public UserDetailsService userDetailsServiceBean() throws Exception {
        return super.userDetailsServiceBean();
    }

    @Override
    protected UserDetailsService userDetailsService() {
        return super.userDetailsService();
    }
}
