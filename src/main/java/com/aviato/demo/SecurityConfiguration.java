package com.aviato.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;


// @Configuration annotation indicates that this class provides bean definitions that will be used to configure the application context. //
@Configuration

// @EnableWebSecurity annotation enables Spring Security's web security support and provides a base configuration for web security. //
@EnableWebSecurity

// SecurityConfiguration class takes a UserDetailsLoader object as a constructor argument. UserDetailsLoader object is used to load user details from the database.//
public class SecurityConfiguration {

//    private UserDetailsLoader usersLoader;
//
//    public SecurityConfiguration(UserDetailsLoader usersLoader) {
//        this.usersLoader = usersLoader;
//    }

    // @Bean annotation is used to declare a bean for password encoding using BCryptPasswordEncoder. This bean is used to encode passwords for storage and comparison. //
//    @Bean
//    public PasswordEncoder passwordEncoder() {
//        return new BCryptPasswordEncoder();
//    }

    // AuthenticationManager() method is declared as a bean, which provides an instance of the AuthenticationManager class. This is used to authenticate users based on their credentials. //
    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration authenticationConfiguration) throws Exception {
        return authenticationConfiguration.getAuthenticationManager();
    }

// The filterChain() method is declared as a bean that configures the HttpSecurity object. It sets up the login and logout configurations, the pages that can be viewed without logging in, and the pages that require authentication. //
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
        http
                /* Login configuration */
                .formLogin()
                .loginPage("/login")
                .defaultSuccessUrl("/ads") // user's home page, it can be any URL
                .permitAll() // Anyone can go to the login page
                /* Logout configuration */
                .and()
                .logout()
                .logoutSuccessUrl("/")
                /* Pages that can be viewed without having to log in */
                .and()
                .authorizeHttpRequests()
                .requestMatchers("/", "/booking", "/home", "/login", "/profile", "/register", "/results", "/css/**", "/js/**", "/img/**") // anyone can see the home and the ads pages
                .permitAll()
                /* Pages that require authentication */
                .and()
                .authorizeHttpRequests()
                .requestMatchers(
                        "/posts/**", // only authenticated users can create ads
                        "/ads/**" // only authenticated users can edit ads

                )
                .authenticated()
        ;
        return http.build();
    }
}
