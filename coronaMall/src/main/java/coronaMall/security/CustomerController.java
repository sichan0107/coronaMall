package coronaMall.security;


import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import coronaMall.customer.Customer;
import coronaMall.data.CustomerRepository;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	CustomerRepositoryCustomerDetailService customerService;
	CustomerRepository customerRepo;
	
	@GetMapping
	public String mypage(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Customer customer = (Customer)auth.getPrincipal();
		
		
		//String username = auth.getName();
		model.addAttribute("customer", customer);
		return "mypage";
	}
	

}
