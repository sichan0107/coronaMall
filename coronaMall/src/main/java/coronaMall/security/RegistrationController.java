package coronaMall.security;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import coronaMall.data.CustomerRepository;

@Controller
@RequestMapping("/register")
public class RegistrationController {
	
	@Autowired
	private CustomerRepository customerRepo;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@GetMapping
	public String registerForm() {
		return "join";
	}
	
	@PostMapping
	@Transactional
	public String processRegistration(RegistrationForm form) {
		customerRepo.save(form.toCustomer(passwordEncoder));
		return "redirect:/login";
	}
	
}
