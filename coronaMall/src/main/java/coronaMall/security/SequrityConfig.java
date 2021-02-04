package coronaMall.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.thymeleaf.extras.springsecurity5.dialect.SpringSecurityDialect;

@Configuration
@EnableWebSecurity
public class SequrityConfig extends WebSecurityConfigurerAdapter {

	@Autowired
	private UserDetailsService userDetailsService;
	
    @Bean
    public SpringSecurityDialect springSecurityDialect(){
        return new SpringSecurityDialect();
    }
	
    // 스프링 시큐리티의 필터 연결을 설정하기 위한 오버라이딩이다.
    // 예외가 웹접근 URL를 설정한다.
	@Override
	public void configure(WebSecurity web) { 
	   web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
	   web.ignoring().antMatchers("/favicon.ico");
	 }	
	
	
	// HTTP 보안 구성 메서드
	// 인터셉터로 요청을 안전하게 보호하는 방법을 설정하기 위한 오버라이딩이다.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests() //url 경로 혹은 패턴을 입력해서 그 경로의 보안 요구사항을 구성하게 함.
				.antMatchers("/customer", "/purchase", "/order") //먼저 권한 부여가 필요한 경로가 나와야한다. permitAll 경로가 먼저 나와버리면 무용지물.
				.access("hasRole('ROLE_USER')") //경로 보안 처리 메소드 사용보다 access랑 SpEL 표현식을 쓰는게 훨씬 범용적이다.
				.antMatchers("/", "/**").access("permitAll")
			
			.and() //메서드 인증 구성이 끝나서 추가 구성을 적용시킨다는 표현
				.formLogin()
				.loginPage("/login")
				//.loginProcessingUrl("/customer/processLogin")// view form의 action과 맞아야함
				.defaultSuccessUrl("/", true)
				.failureUrl("/error")
				.usernameParameter("username")
				.passwordParameter("password")
			.and()
				.logout()
					.logoutSuccessUrl("/")
					.invalidateHttpSession(true)
			.and()
				.csrf();
		System.out.println(http);

	}
	// JDBC 사용자 스토어 방식을 채택
	// 사용자 세부 서비스를 설정하기 위한 오버라이딩이다.
	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.userDetailsService(userDetailsService)
			.passwordEncoder(encoder());
		
//			.jdbcAuthentication()
//			.dataSource(dataSource)
//			.usersByUsernameQuery("select username, password, enabled from customer where username=?")
//			.authoritiesByUsernameQuery("select username, authority from authorities where username=?")
//			.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Bean
	public PasswordEncoder encoder() {
		return new BCryptPasswordEncoder();
	}

	
	/*
	 * 한명 이상의 사용자 정보를 유지 관리할 수 있는 방법 1. 인메모리 사용자 스토어 2. JDBC 기반 사용자 스토어 3. LDAP 기반
	 * 사용자 스토어 4. 커스텀 사용자 명세 서비스
	 * 
	 * 이것들 중 어떤 것을 사용하던 AuthenticationManagerBuilder 에서 구성한다.
	 */
	// AuthenticationManagerBuilder : 사용자 인증 정보를 구성하는 메서드
	// 이 configure 메서드에서는 인증을 하기 위해 사용자를 찾는 방법을 지정하는 코드를 작성한다. 이때
	// AuthenticationManagerBuilder를 이용한다.
	// 다음은 인메모리 방식이다. 인메모리 방식은 테스트 목적이나 간단한 애플리케이션에는 편리하다. 그러나 사용자의 정보 추가나 변경이 어렵다.

//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication()		// 보안 구성 자체에 사용자 정보를 직접 지정할 수 있다. 
//			.withUser("user1")				// withUser()를 호출하면 사용자 구성이 시작되며, 이때 사용자 이름 username을 인자로 전달한다.
//			.password("{noop}password1")	// Spring 5부터는 패스워드는 무조건 암호화 해야한다. 안그러면 접근거부 HTTP403 또는 500이 발생한다. 여기서는 noop을 지정해 암호화 안했다.
//			.authorities("ROLE_USER")		// 부여권한이다. 권한 명칭은 개발자가 무엇이든 지을 수 있다.
//			.and()							// 계속해서 다음 사용자를 지정할 수 있다.
//			.withUser("user2")
//			.password("{noop}password2")
//			.authorities("ROLE_USER");
//
//	}
}
