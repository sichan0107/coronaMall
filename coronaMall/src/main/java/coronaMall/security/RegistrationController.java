package coronaMall.security;

import java.util.logging.Logger;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import coronaMall.data.CustomerRepository;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private CustomerRepositoryCustomerDetailService customerService;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping
	public String registerForm() {
		return "join";
	}
	
	@PostMapping
	@Transactional
	public String processRegistration(RegistrationForm form) throws Exception{
		customerRepo.save(form.toCustomer(passwordEncoder));
		return "redirect:/login";
	}
	
	@PostMapping("/idCheck")
	@ResponseBody
	public int idCheck(@RequestParam(value = "username") String username) throws Exception{
		return customerService.idCheckService(username);
		
	}
}
