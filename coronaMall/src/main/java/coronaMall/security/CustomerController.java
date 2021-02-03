package coronaMall.security;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import coronaMall.customer.Customer;
import coronaMall.data.CustomerRepository;

@Controller
@RequestMapping("/customer")
public class CustomerController {
	CustomerRepositoryCustomerDetailService customerService;
	

	
	@GetMapping
	public String mypage(Model model) {
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();
		Customer customer = (Customer)auth.getPrincipal();
		
		model.addAttribute("customer", customer);
		return "mypage";
	}
	
	@PostMapping("/updateCustomerInfo")
	public String updateCustomerInfo(Model model, RegistrationForm form) {
		System.out.println("�̸� : " + form.getFullname());
		System.out.println("���: " + form.getPassword());
		System.out.println("���̵� : " + form.getUsername());
		System.out.println("�ּ� : " + form.getAddress());
		System.out.println("�ٲ� ��ȣ : " + form.getPhone());
		System.out.println("����: " + form.getAuth());
		Customer customer = customerService.updateCustomer(form);
		// ���� ������� �� ������ �ٲ��� �ʴ´ٸ�, auth�� detail�� ���� �ٲ���ϳ�?
		model.addAttribute("customer", customer);
		return "redirect:/";
		
	}
	
//	@PostMapping("processLogin")
//	public String processLogin(Model model, ) {
//		
//	}
	

}
