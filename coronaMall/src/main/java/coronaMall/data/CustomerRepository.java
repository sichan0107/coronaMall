package coronaMall.data;

import org.springframework.data.repository.CrudRepository;

import coronaMall.customer.Customer;

public interface CustomerRepository extends CrudRepository<Customer, Long>{
	Customer findByUsername(String username);
	int countByUsername(String username);
}
