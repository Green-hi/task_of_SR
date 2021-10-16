package com.chumbok.pos.conf;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.security.SecurityProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.sql.DataSource;

/*
* Spring Security(Spring安全框架)是一个功能强大且高度可定制的 身份验证和访问控制 框架。它是用于保护基于Spring的应用程序的实际标准。
  致力于为Java应用程序提供身份验证和授权。与所有Spring项目一样，Spring Security的真正强大之处在于可以轻松扩展以满足自定义要求
   特性：
  全面和可扩展的身份验证和授权支持
  防止会话固定、点击劫持、跨网站请求伪造等攻击
  Servlet API集成
  与Spring Web MVC的可选集成
* */

@Configuration
@EnableWebSecurity
@Order(SecurityProperties.ACCESS_OVERRIDE_ORDER)
public class SecurityConfiguration extends WebSecurityConfigurerAdapter {

    @Value("${spring.queries.users-query}")
    private String usersQuery;
    @Value("${spring.queries.roles-query}")
    private String rolesQuery;
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;
    @Autowired
    private RESTAuthenticationEntryPoint authenticationEntryPoint;
    @Autowired
    private RESTAuthenticationSuccessHandler authenticationSuccessHandler;
    @Autowired
    private RESTAuthenticationFailureHandler authenticationFailureHandler;


    @Override
    protected void configure(AuthenticationManagerBuilder auth)
            throws Exception {
        auth.
                jdbcAuthentication()
                .usersByUsernameQuery(usersQuery)
                .authoritiesByUsernameQuery(rolesQuery)
                .dataSource(dataSource)
                .passwordEncoder(bCryptPasswordEncoder);
    }

    /*@Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.inMemoryAuthentication().withUser("user").password("user").roles("USER").and().withUser("admin")
                .password("admin").roles("ADMIN");
    }*/

    @Override
    protected void configure(HttpSecurity http) throws Exception {

        http
//            .anonymous().disable()
            .authorizeRequests()
                .antMatchers("/login").permitAll()
                .antMatchers("/").permitAll()
//                .antMatchers("/**").authenticated()
                .anyRequest().authenticated()
                .and()
//            .httpBasic();
            .formLogin()
//                .loginPage("/securityLogin")
                .successHandler(authenticationSuccessHandler)
                .failureHandler(authenticationFailureHandler);
        http.csrf().disable();
        http.exceptionHandling().authenticationEntryPoint(authenticationEntryPoint);
    }

    @Override
    public void configure(WebSecurity web) throws Exception {
//        web.debug(true);

//        web.ignoring().antMatchers("/");

        web
            .ignoring()
            .antMatchers("/resources/**", "/static/**", "/css/**"
                    , "/webjars/**","/js/**", "/images/**", "/registration"
                    , "/favicon.ico", "home");
    }
}