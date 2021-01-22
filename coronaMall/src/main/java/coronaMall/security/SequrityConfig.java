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

	// HTTP ���� ���� �޼���
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests()
				.antMatchers("/login", "/order").authenticated()
				.antMatchers("/", "/**").access("permitAll")
			.and()
				.httpBasic();

	}

	// JDBC ����� ����� ����� ä��
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
	 * �Ѹ� �̻��� ����� ������ ���� ������ �� �ִ� ��� 1. �θ޸� ����� ����� 2. JDBC ��� ����� ����� 3. LDAP ���
	 * ����� ����� 4. Ŀ���� ����� �� ����
	 * 
	 * �̰͵� �� � ���� ����ϴ� AuthenticationManagerBuilder ���� �����Ѵ�.
	 */
	// AuthenticationManagerBuilder : ����� ���� ������ �����ϴ� �޼���
	// �� configure �޼��忡���� ������ �ϱ� ���� ����ڸ� ã�� ����� �����ϴ� �ڵ带 �ۼ��Ѵ�. �̶�
	// AuthenticationManagerBuilder�� �̿��Ѵ�.
	// ������ �θ޸� ����̴�. �θ޸� ����� �׽�Ʈ �����̳� ������ ���ø����̼ǿ��� ���ϴ�. �׷��� ������� ���� �߰��� ������ ��ƴ�.

//	@Override
//	public void configure(AuthenticationManagerBuilder auth) throws Exception{
//		auth.inMemoryAuthentication()		// ���� ���� ��ü�� ����� ������ ���� ������ �� �ִ�. 
//			.withUser("user1")				// withUser()�� ȣ���ϸ� ����� ������ ���۵Ǹ�, �̶� ����� �̸� username�� ���ڷ� �����Ѵ�.
//			.password("{noop}password1")	// Spring 5���ʹ� �н������ ������ ��ȣȭ �ؾ��Ѵ�. �ȱ׷��� ���ٰź� HTTP403 �Ǵ� 500�� �߻��Ѵ�. ���⼭�� noop�� ������ ��ȣȭ ���ߴ�.
//			.authorities("ROLE_USER")		// �ο������̴�. ���� ��Ī�� �����ڰ� �����̵� ���� �� �ִ�.
//			.and()							// ����ؼ� ���� ����ڸ� ������ �� �ִ�.
//			.withUser("user2")
//			.password("{noop}password2")
//			.authorities("ROLE_USER");
//
//	}
}
