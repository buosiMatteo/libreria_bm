package it.euris.libreriabm.config.security;

import it.euris.libreriabm.enums.UserRole;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;

@Configuration
public class SecurityConf {

  private final WhiteListConfiguration whiteList;

  public SecurityConf(WhiteListConfiguration whiteList) {
    this.whiteList = whiteList;
  }

  @Bean
  public static PasswordEncoder passwordEncoder() {
    return new BCryptPasswordEncoder();
  }

  @Bean
  public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

    http
        .csrf(AbstractHttpConfigurer::disable)
        .authorizeHttpRequests((authorize) -> authorize
            .requestMatchers(whiteList.getUrls()).permitAll()
            .requestMatchers(HttpMethod.GET,"/case-editrici/**").permitAll()
            .requestMatchers(HttpMethod.GET,"/autori/**").permitAll()
            .requestMatchers(HttpMethod.GET,"/libri/**").permitAll()
            .requestMatchers("/case-editrici/**").hasRole(UserRole.ADMIN.toString())
            .requestMatchers("/autori/**").hasRole(UserRole.ADMIN.toString())
            .requestMatchers("/libri/**").hasRole(UserRole.ADMIN.toString())
            .anyRequest().authenticated()
        )
        .httpBasic(Customizer.withDefaults());

    return http.build();
  }

  @Bean
  public UserDetailsService userDetailsService(){

    UserDetails user = User.builder()
        .username("user")
        .password(passwordEncoder().encode("user"))
        .roles(UserRole.USER.toString())
        .build();

    UserDetails admin = User.builder()
        .username("admin")
        .password(passwordEncoder().encode("admin"))
        .roles(UserRole.ADMIN.toString())
        .build();

    UserDetails visitor = User.builder()
        .username("visitor")
        .password(passwordEncoder().encode("visitor"))
        .roles(UserRole.VISITOR.toString())
        .build();

    return new InMemoryUserDetailsManager(user, admin, visitor);
  }
}
