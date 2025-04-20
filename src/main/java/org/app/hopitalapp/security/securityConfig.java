package org.app.hopitalapp.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
@EnableWebSecurity
@EnableMethodSecurity(prePostEnabled = true)
public class securityConfig {

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }


    @Bean
    public InMemoryUserDetailsManager inMemoryUserDetailsManager(PasswordEncoder encoder) {
        UserDetails user1 = User.withUsername("user1").password(encoder.encode("1234")).roles("USER").build();
        UserDetails user2 = User.withUsername("user2").password(encoder.encode("1234")).roles("USER").build();
        UserDetails admin = User.withUsername("admin").password(encoder.encode("1234")).roles("USER", "ADMIN").build();

        return new InMemoryUserDetailsManager(user1, user2, admin);
    }


    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/webjars/**", "/h2-console/**").permitAll()
                        //.requestMatchers("/user/**").hasRole("USER")
                        //.requestMatchers("/admin/**").hasRole("ADMIN")
                        .anyRequest().authenticated()
                )
                .formLogin(form -> form
                        .defaultSuccessUrl("/user/index", true)
                        .permitAll()
                )
                .rememberMe(remember -> remember
                        .key("uniqueAndSecret") // tu peux mettre une clé secrète ici
                        .tokenValiditySeconds(7 * 24 * 60 * 60) // 7 jours de validité
                )
                .logout(logout -> logout.permitAll())
                .exceptionHandling(exception -> exception.accessDeniedPage("/notAuthorized"));

        http.csrf(csrf -> csrf.disable());
        http.headers(headers -> headers.frameOptions(frame -> frame.disable()));

        return http.build();
    }

}








