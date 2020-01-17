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

        //Trainees
        appUserService.registerUser("luuk","Luuk", "Wempe", "luukwempe@mail.com", encoder.encode("hallo"), "TRAINEE", true, false, Date.valueOf("1996-01-01"),"1632BT", "Klaverstraat", "15", "Sassenheim", "Netherlands", "06324543", "devops-02-19");
        appUserService.registerUser("vuong","Vuong", "Ngo", "vuongngo@gmail.com", encoder.encode("hallo"), "TRAINEE" , true, false, Date.valueOf("1995-10-15"),"1628WR", "Han Hoekstrahof", "1", "Hoorn", "Netherlands", "0229123456", "devops-02-19");
        appUserService.registerUser("simone","Simone", "Meijers", "scmeijers@mail.com", encoder.encode("hallo"), "TRAINEE", true, false, Date.valueOf("1995-07-09"),"1420BP", "Steenstraat", "21", "Deventer", "Netherlands", "061123213","devops-02-19");
        appUserService.registerUser("wouter","Wouter", "Abels", "walterdeman@hotmail.com", encoder.encode("hallo"), "TRAINEE",  true, false,Date.valueOf("1995-02-07") ,"6043JK", "Vlamhof", "34", "Nieuwegein", "Netherlands", "06232312", "devops-02-19");
        appUserService.registerUser("alex","Alex", "van Manen", "alexvanmanen@mail.com", encoder.encode("hallo"), "TRAINEE", true, false, Date.valueOf("1985-05-23") ,"1641PP", "Grashof", "134", "Zwolle", "Italy", "112", "devops-02-19");

        //Admin
        appUserService.registerUser("admin","Bob", "Jenkins", "bobjenkins@mail.com", encoder.encode("hallo"), "ADMIN", true, true, Date.valueOf("1996-01-01"),"2000PP", "Bobhof", "1", "Bobdam", "Netherlands", "911", "");

        //HRemployee
        appUserService.registerUser("hremployee","Jurre", "Wempe", "jurrewempe@mail.com", encoder.encode("hallo"), "HREMPLOYEE", true, true, Date.valueOf("2000-01-01") ,"3000PP", "Lansiershof", "6", "Sassenheim", "Netherlands", "+316-52498741", "");

        //Manager
        appUserService.registerUser("manager","Jeanine", "van Dongen", "jeanine@mail.com", encoder.encode("hallo"), "MANAGER", true, false, Date.valueOf("1997-01-01") ,"2216TL", "Ter Beek", "4", "Lisse", "Netherlands", "+316-45389142", "");

        //Talentmanager
        appUserService.registerUser("talentmanager","Joke", "Gaarsen", "jokegaarsen@mail.com", encoder.encode("hallo"), "TALENTMANAGER", true, false, Date.valueOf("1997-01-01") ,"2216TL", "Ter Beek", "4", "Lisse", "Netherlands", "+316-45389142", "");
    }

}
