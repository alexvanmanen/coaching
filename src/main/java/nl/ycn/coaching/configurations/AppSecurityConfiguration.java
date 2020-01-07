package nl.ycn.coaching.configurations;

import nl.ycn.coaching.database.AppUserService;
import nl.ycn.coaching.database.TraineeRepository;
import nl.ycn.coaching.model.users.Trainee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

@EnableWebSecurity
@Configuration
public class AppSecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Override
    public void configure(WebSecurity webSecurity) {
        webSecurity
            .ignoring()
            .antMatchers("/resources/**");
    }

    @Override
    public void configure(HttpSecurity httpSecurity) throws Exception {
        httpSecurity
            .authorizeRequests()
            .antMatchers(
                "/",
                "/login",
                "/register",
                "/console",
                "/open/**").permitAll()
            .antMatchers(
                "/user/**").hasRole("USER")
            .antMatchers(
                "/admin/**").hasRole("ADMIN")
            .antMatchers(
                "/trainee/**").hasRole("TRAINEE")
            .antMatchers(
                "/talentmanager/**").hasRole("TALENTMANAGER")
            .antMatchers(
                "/hremployee/**").hasRole("HREMPLOYEE")
            .antMatchers(
                "/manager/**").hasRole("MANAGER")


                .and()
            .csrf().ignoringAntMatchers("/**")

            .and()
            .headers().frameOptions().sameOrigin()

            .and()
            .formLogin()
            .loginPage("/login")
                .defaultSuccessUrl("/redirectLogin")
                .failureUrl("/login")
            .and()
                .logout()
                .logoutSuccessUrl("/logout")
                .logoutUrl("/logout")
                .invalidateHttpSession(true);

    }


    @Autowired
    public DataSource dataSource;

    @Autowired
    public AppUserService appUserService;

    @Autowired
    public TraineeRepository traineeRepository;
    
    @Autowired
    public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception{

        BCryptPasswordEncoder encoder = new BCryptPasswordEncoder();

        auth
           .userDetailsService(appUserService)
           .passwordEncoder(encoder)

           .and()
           .jdbcAuthentication()
           .dataSource(dataSource)
           .passwordEncoder(encoder);

        appUserService.registerUser("luuk","Luuk", "Wempe", "luukwempe@hotmail.com", encoder.encode("hallo"), "ADMIN", true, false);
        appUserService.registerUser("alex","Alex", "van Manen", "alex@vanmanenit.nl", encoder.encode("hallo"), "TRAINEE", true, false);
        appUserService.registerUser("vuong","Vuong", "Ngo", "vuong.anime@gmail.com", encoder.encode("hallo"), "MANAGER", true, true);
        appUserService.registerUser("simone","Simone", "Meijers", "scm15-8@live.nl", encoder.encode("hallo"), "TALENTMANAGER", true, false);
        appUserService.registerUser("wouter","Wouter", "Abels", "wouterabels@hotmail.com", encoder.encode("hallo"), "HREMPLOYEE", true, false);

    }

}
