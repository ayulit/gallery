package app.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.password.NoOpPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

@Configuration
@EnableWebSecurity
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    // да, можно инжектить в метод! o_O
    @Autowired
    public void configurationGlobal(AuthenticationManagerBuilder auth) throws Exception {
        // опять юзаем паттерн билдер
        // in-memory provider service - в реальном мире это не будем юзать,
        // т.к. как только система рестартанет, все пароли слетят к херам!
        auth
                .inMemoryAuthentication()
                // нужно предоставить password encoder
                .passwordEncoder(passwordEncoder())
                // далее заводим юзеров в in-memory store
                .withUser("user").password("password").roles("USER");
    }

    public PasswordEncoder passwordEncoder() {
        // ничего страшного, что он deprecated - не для прода мы!
        // это in-memory plain text encoder
        // в реальном мире юзают BCryptPasswordEncoder
        return NoOpPasswordEncoder.getInstance();
    }

    @Override
    protected void configure(HttpSecurity httpSecurity) throws Exception {
        // далее будет работать паттерн билдер, т.о. нам надо добавить пару вещей в HttpSecurity
        httpSecurity
                .authorizeRequests()
                .antMatchers("/", "/api/*") // специфицирует некторые URL
                .permitAll() // рассекьюрить специфицированные URL
                // Spring Security работает слоями: т.е. типа каждый слой за пределами слоя выше
                .anyRequest().authenticated() // любой запрос окромя будет требовать аутентификации
                .and()
                .formLogin() // заюзаем form login based security
                .loginPage("/login") // судя будет редиректится любой запрос кроме запермиченных
                .permitAll() // нужно дать доступ всем к страничке 'login'
                .and()
                .logout() // специфицируем страничку 'logout', если ее нет, надо просто перезапустить браузер
                // https://www.baeldung.com/spring-security-logout
                // https://stackoverflow.com/questions/22557741/logout-link-with-spring-and-thymeleaf
                .logoutUrl("/logout")
                .logoutSuccessUrl("/")
                .invalidateHttpSession(true)
                .deleteCookies("JSESSIONID")
                .permitAll(); // и дадим доступ всем к страничке 'logout'
    }

}
