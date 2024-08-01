package com.springbloom.SpringBloom.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.springbloom.SpringBloom.encoder.BCPasswordEncoder;

/**
 *
 * @author mrRobot
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

    @Autowired
    private UserDetailsService userDetailsService;

    @Autowired
    private BCPasswordEncoder bcPasswordEncoder;

    @Bean
    public BCryptPasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    /**
     * *
     * Cadena de métodos que permite administrar políticas de acceso por
     * niveles. Los administradores pueden acceder a las páginas / editar,
     * /agregar y /eliminar.
     *
     * usuarios básicos solo pueden acceder a la lista, que está en la raíz "/"
     *
     * también permite el manejo de la página de login y errores (en este caso
     * el error 403)
     *
     * @param http
     * @param authenticationManager
     * @return
     * @throws Exception
     */
    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http
                .authorizeHttpRequests(authorize -> authorize
                .requestMatchers("/webjars/**").permitAll()
                .requestMatchers("/css/**", "/js/**", "/images/**").permitAll()
                .requestMatchers("/edit/**", "/add/**", "/delete")
                .hasRole("ADMIN")
                .requestMatchers("/").hasAnyRole("ADMIN", "USER")
                .anyRequest().authenticated()
                )
                .formLogin((form) -> form
                .loginPage("/login").permitAll())
                .logout((logout) -> logout.permitAll())
                .exceptionHandling(ex -> ex.accessDeniedPage("/errors/403"));

        return http.build();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder build) throws Exception {
        build.userDetailsService(userDetailsService).passwordEncoder(bcPasswordEncoder.passwordEncoder());
    }
}
