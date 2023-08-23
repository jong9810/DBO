//package com.hero.DBOLeague;
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;
//
//@Configuration
//@EnableWebSecurity
//public class SecurityConfig extends WebSecurityConfigurerAdapter {
//
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        http.authorizeRequests()
//            .antMatchers("/join").permitAll() // 등록 페이지에 접근 허용
//            .antMatchers("/login").permitAll() // 로그인 페이지에 접근 허용
//            .anyRequest().authenticated() // 다른 페이지에는 인증이 필요함
//            .and()
//            .formLogin()
//            .loginPage("/login") // 사용자 정의 로그인 페이지 지정
//            .defaultSuccessUrl("/main") // 로그인 성공 후 리다이렉트
//            .successHandler(savedRequestAwareAuthenticationSuccessHandler()) // 이전 페이지로 리디렉션
//            .and()
//            .logout()
//            .logoutUrl("/logout")
//            .logoutSuccessUrl("/login")
//            .and()
//            .csrf().disable(); // 단순화를 위해 CSRF 비활성화
//    }
//
//    @Bean
//    public SavedRequestAwareAuthenticationSuccessHandler savedRequestAwareAuthenticationSuccessHandler() {
//        SavedRequestAwareAuthenticationSuccessHandler handler = new SavedRequestAwareAuthenticationSuccessHandler();
//        handler.setDefaultTargetUrl("/main"); // 이전 페이지 정보가 없을 경우의 기본 리디렉션 페이지
//        return handler;
//    }
//}
//
