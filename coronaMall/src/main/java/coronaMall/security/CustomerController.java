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
		System.out.println("이름 : " + form.getFullname());
		System.out.println("비번: " + form.getPassword());
		System.out.println("아이디 : " + form.getUsername());
		System.out.println("주소 : " + form.getAddress());
		System.out.println("바뀐 번호 : " + form.getPhone());
		System.out.println("권한: " + form.getAuth());
		Customer customer = customerService.updateCustomer(form);
		// 만약 사용자의 상세 정보가 바뀌지 않는다면, auth의 detail을 통해 바꿔야하나?
		model.addAttribute("customer", customer);
		return "redirect:/";
		
	}
	
//	@PostMapping("processLogin")
//	public String processLogin(Model model, ) {
//		
//	}
	

}
