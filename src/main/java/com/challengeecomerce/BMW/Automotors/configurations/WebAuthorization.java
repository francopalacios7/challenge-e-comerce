package com.challengeecomerce.BMW.Automotors.configurations;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.WebAttributes;
import org.springframework.security.web.authentication.logout.HttpStatusReturningLogoutSuccessHandler;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@EnableWebSecurity
@Configuration
class WebAuthorization {

    @Bean
    public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

        http.authorizeRequests()
//               .antMatchers(HttpMethod.POST, ).hasAuthority("CLIENT")
//               .antMatchers(HttpMethod.POST,  ).hasAuthority("ADMIN")
                .antMatchers(HttpMethod.POST,"/api/clients").permitAll()
                .antMatchers(HttpMethod.POST,"/api/admin/cars").permitAll()
                .antMatchers(HttpMethod.POST,"/api/admin/addMods").permitAll()
                .antMatchers(HttpMethod.POST,"/api/admin/duesPlan").permitAll()
                .antMatchers(HttpMethod.GET, "/api/clients").permitAll()
                .antMatchers(HttpMethod.GET, "/api/duesPlan").permitAll()
                .antMatchers(HttpMethod.GET, "/api/car", "/h2-console").permitAll()
                .antMatchers(HttpMethod.POST,"/api/email").permitAll()
                .antMatchers(HttpMethod.GET, "/api/car/color").permitAll()
                .antMatchers(HttpMethod.GET, "/api/mods").permitAll()
                .antMatchers(HttpMethod.GET, "/api/modstype").permitAll()
                .antMatchers(HttpMethod.PATCH,"/api/admin/car/delete/{id}").permitAll()
//              .antMatchers(HttpMethod.PATCH, "/api/clients/current/cards/{id}", "/api/clients/current/accounts/{id}").hasAuthority("CLIENT")
                .antMatchers("/api/login", "/web/htmlPages/index.html", "/web/JsPages/**", "/web/stylePages/**", "/web/resources/**", "/web/htmlPages/login.html", "/api/logout").permitAll()
                .antMatchers("/web/htmlPages/", "/rest/**", "/web/htmlPages/manager.html","/api/clients","/web/htmlPages/adminLoans.html" ).hasAuthority("ADMIN")
                .antMatchers("/web/htmlPages/**", "/api/clients/current","/api/accounts/**").hasAuthority("CLIENT");
                /*.anyRequest().denyAll();*/
                /*.and()
                .exceptionHandling()
                .accessDeniedPage("/error/404");*/

        http.formLogin()
                .usernameParameter("email")
                .passwordParameter("password")
                .loginPage("/api/login");

        http.logout().logoutUrl("/api/logout").deleteCookies("JSESSIONID");

        http.cors();

        // turn off checking for CSRF tokens
        http.csrf().disable();

        //disabling frameOptions so h2-console can be accessed
        http.headers().frameOptions().disable();

        // if user is not authenticated, just send an authentication failure response
        http.exceptionHandling().authenticationEntryPoint((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED));

        // if login is successful, just clear the flags asking for authentication
        http.formLogin().successHandler((req, res, auth) -> clearAuthenticationAttributes(req));

        // if login fails, just send an authentication failure response
        http.formLogin().failureHandler((req, res, exc) -> res.sendError(HttpServletResponse.SC_UNAUTHORIZED));

        // if logout is successful, just send a success response
        http.logout().logoutSuccessHandler(new HttpStatusReturningLogoutSuccessHandler());

        return http.build();
    }

    private void clearAuthenticationAttributes(HttpServletRequest request) {

        HttpSession session = request.getSession(false);

        if (session != null) {

            session.removeAttribute(WebAttributes.AUTHENTICATION_EXCEPTION);

        }

    }
}