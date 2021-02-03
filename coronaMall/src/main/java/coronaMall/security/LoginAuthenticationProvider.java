package coronaMall.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import coronaMall.customer.Customer;

public class LoginAuthenticationProvider implements AuthenticationProvider {
	@Autowired
	CustomerRepositoryCustomerDetailService customerService;
	
	@Autowired
	BCryptPasswordEncoder encode;
	
	@Override
	public Authentication authenticate(Authentication authentication) throws AuthenticationException {
		String username = authentication.getName();
		String password = (String)authentication.getCredentials();
		Customer customer = (Customer) customerService.loadUserByUsername(username);
		if(customer == null || !username.equals(customer.getUsername()) || !encode.matches(password, customer.getPassword())) {
			throw new BadCredentialsException(username);
		}
		//customer.setPassword(null); //이거 해줘야함.
		Authentication newAuth = new UsernamePasswordAuthenticationToken(customer, null, customer.getAuthorities());
		return newAuth;
	}

	@Override
	public boolean supports(Class<?> authentication) {
		return authentication.equals(UsernamePasswordAuthenticationToken.class);
	}

}
