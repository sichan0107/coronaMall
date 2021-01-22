package coronaMall.security;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

@Configuration
@EnableWebSecurity
public class SequrityConfig extends WebSecurityConfigurerAdapter {

	// HTTP 보안 구성 메서드
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/login", "/order").authenticated()
				.antMatchers("/", "/**").access("permitAll")
			.and()
				.httpBasic();

	}

	// JDBC 사용자 스토어 방식을 채택
	@Autowired
	DataSource dataSource;

	@Override
	protected void configure(AuthenticationManagerBuilder auth) throws Exception {
		auth
			.jdbcAuthentication()
			.dataSource(dataSource)
			.usersByUsernameQuery("select username, password, enabled from customer where username=?")
			.authoritiesByUsernameQuery("select username, authority from authorities where username=?")
			.passwordEncoder(new BCryptPasswordEncoder());
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
