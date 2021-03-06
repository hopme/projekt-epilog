package pl.epilog.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import javax.sql.DataSource;

@Configuration
@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    @Bean
    public DataSource dataSource() {
        DriverManagerDataSource dataSource = new DriverManagerDataSource();
        dataSource.setDriverClassName("com.mysql.cj.jdbc.Driver");
        dataSource.setUrl("jdbc:mysql://localhost:3306/epilog?serverTimezone=UTC");
        dataSource.setUsername("root");
        dataSource.setPassword("coderslab");
        return dataSource;
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.jdbcAuthentication()
                .passwordEncoder(passwordEncoder())
                .dataSource(dataSource())
                .usersByUsernameQuery("SELECT email, password, true FROM users WHERE email = ?")
                .authoritiesByUsernameQuery("SELECT email, 'ROLE_USER' FROM users WHERE email = ?");
    }

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http
                .formLogin()
                // Konfiguracja dedykowanej obsługi formularza logowania
                .loginPage("/")    // Ustalenie ścieżki do obsługi wyświetlania formularza
                .usernameParameter("email") // Ustalenie nazwy parametru określającego login użytkownika
                .defaultSuccessUrl("/cockpit", false) // Określenie, że domyślną stroną na którą przenosi formularz logowania jest strona główna, chyba, że użytkownik chciał wejść na jakąś inną (bez wymuszania)
                .and()
                // Konfiguracja wylogowywania, aby przenosiło na stronę logowania
                .logout()
                .logoutSuccessUrl("/?logout")
                .and()
                .csrf().disable()
                .authorizeRequests()
                .antMatchers("/register").permitAll()
                .antMatchers("/login").permitAll()
                .antMatchers("/").permitAll()
                .antMatchers("/assets/**").permitAll()
                .antMatchers("/admin/**").hasRole("ADMIN")
                .anyRequest().authenticated();


    }
}