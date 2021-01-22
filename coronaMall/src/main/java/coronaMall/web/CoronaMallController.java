package coronaMall.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;


@Controller
public class CoronaMallController {
	@GetMapping("/")
	public String home() {
		return "index";
	}
	
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
	
	@GetMapping("join")
	public String join() {
		return "join";
	}
	
	@GetMapping("login")
	public String login() {
		return "login";
	}
	

	
	
	
	
	
}
