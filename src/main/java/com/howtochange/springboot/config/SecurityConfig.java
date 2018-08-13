package com.howtochange.springboot.config;


import com.howtochange.springboot.service.impl.UserServiceImpl;
import com.howtochange.springboot.util.MD5Util;
import org.springframework.context.annotation.Bean;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

@EnableWebSecurity
public class SecurityConfig extends WebSecurityConfigurerAdapter {


    @Bean
    UserDetailsService customUserService(){
        return new UserServiceImpl();
    }

    //权限规则
    @Override
    protected void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests().antMatchers("/").hasRole("root")//首页，全部
                .antMatchers("/links/search/**").permitAll()//查找链接，全部
                .antMatchers("/links/add/**").hasRole("user")//添加，登录
                .antMatchers("/links/update/**").hasRole("user")//更新，登录
                .antMatchers("/links/delete/**").hasRole("user")//删除，登录
                .antMatchers("/user/**").hasRole("user")
                .antMatchers("/root/**").hasRole("root");//root权限
        http.formLogin()
                .usernameParameter("phone")
                .passwordParameter("password")
                .loginPage("/login");
    }

    @Override
    protected void configure(AuthenticationManagerBuilder auth) throws Exception {
        auth.userDetailsService(customUserService()).passwordEncoder(new PasswordEncoder(){

            @Override
            public String encode(CharSequence rawPassword) {
                return MD5Util.encode((String)rawPassword);
            }

            @Override
            public boolean matches(CharSequence rawPassword, String encodedPassword) {
                return encodedPassword.equals(MD5Util.encode((String)rawPassword));
            }});
    }

//    @Override
//    protected AuthenticationManager authenticationManager() throws Exception {
//        return super.authenticationManager();
//    }

}
