package coronaMall.security;

import org.springframework.security.crypto.password.PasswordEncoder;

import coronaMall.customer.Authority;
import coronaMall.customer.Customer;
import lombok.Data;

@Data
public class RegistrationForm {
	private String username;
	private String password;
	private String fullname;
	private String address;
	private String phone;
	private String email;
	private Authority authority;

	public Customer toCustomer(PasswordEncoder passwordEncoder) {
		return new Customer(
				username, passwordEncoder.encode(password),
				fullname, phone, address, email, authority);
	}
}
