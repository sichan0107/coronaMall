package coronaMall.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import coronaMall.customer.Customer;
import coronaMall.data.CustomerRepository;

@Service
public class CustomerRepositoryCustomerDetailService implements UserDetailsService{
	private CustomerRepository customerRepo;
	
	@Autowired
	public CustomerRepositoryCustomerDetailService(CustomerRepository customerRepo) {
		this.customerRepo = customerRepo;
	}
	
	
	// loadUserByUserName에는 반드시 null을 반환하지 않는다는 규칙이 있다.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer = customerRepo.findByUsername(username); //username으로 고객을 찾는다
		if(customer != null) {
			return customer;
		}
		throw new UsernameNotFoundException(username + "not founded");
	} 
}
