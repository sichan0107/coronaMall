package coronaMall.web;

import java.io.IOException;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import coronaMall.customer.Customer;


@Controller
public class CoronaMallController {
	
	@GetMapping("findUserId")
	public String findUserId() {
		return "findUserId";
	}
	
	@GetMapping("phoneAuthorizing")
	public String phoneAuthorizing() {
		return "phoneAuthorizing";
	}
	
	@GetMapping("cart")
	public String cart() {
		return "cart";
	}

	
	@GetMapping("/login?error")
	public String loginFail() throws IOException{
		return "redirect:/loginError";
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}

//	@GetMapping("shop")
//	public String life() {
//		return "shop";
//	}
	

	@GetMapping("shop-detail")
	public String food() {
		return "shop-details";
	}

	
	
}
