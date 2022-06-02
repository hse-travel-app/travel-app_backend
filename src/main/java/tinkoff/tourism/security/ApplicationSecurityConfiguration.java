package tinkoff.tourism.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.factory.PasswordEncoderFactories;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class ApplicationSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${user.username:user}")
    String userName;
    @Value("${user.password:user}")
    String userPassword;
    @Value("${admin.username:admin}")
    String adminName;
    @Value("${admin.password:admin}")
    String adminPassword;

    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.httpBasic().and()
            .authorizeRequests()
            .antMatchers("/swagger-ui/**", "/v3/api-docs/**", "/swagger/**", "/swagger*").permitAll()
            .antMatchers(HttpMethod.GET).hasAnyRole("ADMIN", "USER")
            .antMatchers(HttpMethod.POST).hasRole("ADMIN")
            .antMatchers(HttpMethod.PUT).hasRole("ADMIN")
            .antMatchers(HttpMethod.DELETE).hasRole("ADMIN")
            .and().authorizeRequests().anyRequest().authenticated()
            .and().csrf().disable();
    }

    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder authentication)
            throws Exception
    {
        PasswordEncoder encoder =
                PasswordEncoderFactories.createDelegatingPasswordEncoder();

        authentication.inMemoryAuthentication()
                .withUser(userName)
                    .password(encoder.encode(userPassword))
                    .authorities("ROLE_USER")
                .and()
                .withUser(adminName)
                    .password(encoder.encode(adminPassword))
                    .authorities("ROLE_ADMIN");
    }
}
