package nl.ycn.coaching.configurations;

import nl.ycn.coaching.database.BootcampRepository;
import nl.ycn.coaching.services.AppUserService;
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

import java.sql.Date;
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
    private BootcampRepository bootcampRepository;

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

        appUserService.registerUser("luuk","Luuk", "Wempe", "soepsoep123@hotmail.com", encoder.encode("hallo"), "ADMIN", true, true, Date.valueOf("1996-01-01"),"2000PP", "Bobhof", "1", "Bobdam", "Bobland", "06324543", "");
        appUserService.registerUser("alex","Alex", "van Manen", "superalex3@hotmail.nl", encoder.encode("hallo"), "TRAINEE", true, true, Date.valueOf("1997-01-01") ,"3000PP", "Bobhof", "1", "Bobdam", "Italy", "112", "devops-02-19");
        appUserService.registerUser("jurre","Jurre", "Wempe", "firedragon@hotmail.com", encoder.encode("hallo"), "TRAINEE", true, false, Date.valueOf("2000-01-01") ,"3000PP", "Lansiershof", "6", "Sassenheim", "The Netherlands", "+316-52498741", "java-03-19");
        appUserService.registerUser("jeanine","Jeanine", "van Dongen", "darkdeathxxx@gmail.com", encoder.encode("hallo"), "TRAINEE", true, false, Date.valueOf("1997-01-01") ,"2216TL", "Ter Beek", "4", "Lisse", "The Netherlands", "+316-45389142", "devops-02-19");
        appUserService.registerUser("vuong","Vuong", "Ngo", "vongbong@gmail.com", encoder.encode("hallo"), "MANAGER" , true, true, Date.valueOf("1994-01-01"),"4000PP", "Bobhof", "1", "Bobdam", "Bobland", "112", "");
        appUserService.registerUser("simone","Simone", "Meijers", "simeunedeune@live.nl", encoder.encode("hallo"), "TALENTMANAGER", true, true, Date.valueOf("1993-01-01"),"5000PP", "Bobhof", "1", "Bobdam", "Bobland", "112","");
        appUserService.registerUser("wouter","Wouter", "Abels", "walterdeman@hotmail.com", encoder.encode("hallo"), "HREMPLOYEE",  true, true,Date.valueOf("1995-01-01") ,"6000PP", "Bobhof", "1", "Bobdam", "Bobland", "112", "");
        appUserService.registerUser("wouter2","Wouter", "Abels", "walterdeman@hotmail.com", encoder.encode("hallo"), "HREMPLOYEE",  true, false,Date.valueOf("1995-01-01") ,"6000PP", "Bobhof", "1", "Bobdam", "Bobland", "112", "");
    }

}
