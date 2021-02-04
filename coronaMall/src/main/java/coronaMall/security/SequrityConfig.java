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
	
    // ������ ��ť��Ƽ�� ���� ������ �����ϱ� ���� �������̵��̴�.
    // ���ܰ� ������ URL�� �����Ѵ�.
	@Override
	public void configure(WebSecurity web) { 
	   web.ignoring().antMatchers("/css/**", "/js/**", "/img/**");
	   web.ignoring().antMatchers("/favicon.ico");
	 }	
	
	
	// HTTP ���� ���� �޼���
	// ���ͼ��ͷ� ��û�� �����ϰ� ��ȣ�ϴ� ����� �����ϱ� ���� �������̵��̴�.
	@Override
	protected void configure(HttpSecurity http) throws Exception {
		http
			.authorizeRequests() //url ��� Ȥ�� ������ �Է��ؼ� �� ����� ���� �䱸������ �����ϰ� ��.
				.antMatchers("/customer", "/purchase", "/order") //���� ���� �ο��� �ʿ��� ��ΰ� ���;��Ѵ�. permitAll ��ΰ� ���� ���͹����� ��������.
				.access("hasRole('ROLE_USER')") //��� ���� ó�� �޼ҵ� ��뺸�� access�� SpEL ǥ������ ���°� �ξ� �������̴�.
				.antMatchers("/", "/**").access("permitAll")
			
			.and() //�޼��� ���� ������ ������ �߰� ������ �����Ų�ٴ� ǥ��
				.formLogin()
				.loginPage("/login")
				//.loginProcessingUrl("/customer/processLogin")// view form�� action�� �¾ƾ���
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
	// JDBC ����� ����� ����� ä��
	// ����� ���� ���񽺸� �����ϱ� ���� �������̵��̴�.
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
