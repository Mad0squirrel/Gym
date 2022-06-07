package com.company.work;


import com.company.work.domain.Usr;
import com.company.work.repos.UsrRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;

import java.util.ArrayList;
import java.util.List;

@Configuration
@EnableWebSecurity
public class WebSecurityConfig extends WebSecurityConfigurerAdapter {
    @Autowired
    private UsrRepo usrRepo;
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .authorizeRequests()
                .antMatchers("/", "/home","final","purchase","/register", "/thx", "/css/**", "/fonts/**",
                        "/images/**").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .permitAll()
                .and()
                .logout()
                .permitAll();
    }
    @Override
    public void configure(WebSecurity web) throws Exception {
        web.ignoring().antMatchers("/css/**","/js/**","/img/**","/fonts/**");
    }
    @Bean
    @Override
    public UserDetailsService userDetailsService() {
        Iterable<Usr> usrs = usrRepo.findAll();
        List<UserDetails> users = new ArrayList<>();
        for (Usr i: usrs)
        {
            UserDetails user =
                    User.withDefaultPasswordEncoder()
                            .username(i.getUsername())
                            .password(i.getPassword())
                            .roles("USER")
                            .build();
            users.add(user);
        }
        return new InMemoryUserDetailsManager(users);
    }

}
