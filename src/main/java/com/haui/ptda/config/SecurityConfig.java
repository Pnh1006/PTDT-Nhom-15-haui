package com.haui.ptda.config;

import org.springframework.context.annotation.Bean;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public UserDetailsService userDetailsService(){
        var manager = new InMemoryUserDetailsManager();
        var user1 = User.withUsername("admin").password(passwordEncoder().encode("abc123")).roles("ADMIN").build();
        manager.createUser(user1);
        return manager;
    }

    @Bean
    public PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeHttpRequests()
                .mvcMatchers("/home").permitAll()
                .mvcMatchers("/shop*").permitAll()
                .mvcMatchers("/shop-page/**").permitAll()
                .mvcMatchers("/product*").permitAll()
                .mvcMatchers("/").permitAll()
                .mvcMatchers("/login").permitAll()
                .mvcMatchers("/login-error").permitAll()
                .mvcMatchers("/perform_login").permitAll()
                .anyRequest().authenticated()
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/perform_login")
                .failureUrl("/login-error")
                .defaultSuccessUrl("/manage?page=0", true)
                .and()
                .logout()
                .logoutSuccessUrl("/home?logout=true")
                .logoutRequestMatcher(new AntPathRequestMatcher("/perform_logout", "GET"))
                .invalidateHttpSession(true)
                .permitAll();;
    }
}
