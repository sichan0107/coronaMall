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
	
	
	// loadUserByUserName���� �ݵ�� null�� ��ȯ���� �ʴ´ٴ� ��Ģ�� �ִ�.
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		Customer customer = customerRepo.findByUsername(username); //username���� ���� ã�´�
		if(customer != null) {
			return customer;
		}
		throw new UsernameNotFoundException(username + "not founded");
	} 
}
