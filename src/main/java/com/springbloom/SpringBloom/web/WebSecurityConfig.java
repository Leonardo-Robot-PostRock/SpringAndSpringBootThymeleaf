package com.springbloom.SpringBloom.web;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;

/**
 *
 * @author mrRobot
 */
@Configuration
@EnableWebSecurity
public class WebSecurityConfig {

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

    /**
     * *
     * Crea usuarios y roles con contraseñas encriptadas
     *
     * @return
     */
    @Bean
    public InMemoryUserDetailsManager userDetailsService(PasswordEncoder encoder) {
        UserDetails user = User.withUsername("user")
                .password(encoder.encode("123"))
                .roles("USER")
                .build();

        UserDetails admin = User.withUsername("admin")
                .password(encoder.encode("123"))
                .roles("USER", "ADMIN")
                .build();

        return new InMemoryUserDetailsManager(user, admin);

    }

    @Bean
    public PasswordEncoder encoder() {
        PasswordEncoder encoder = PasswordEncoderFactories.createDelegatingPasswordEncoder();
        return encoder;
    }

}
