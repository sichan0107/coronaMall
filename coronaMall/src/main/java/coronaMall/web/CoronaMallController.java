package coronaMall.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Controller
public class CoronaMallController {
	@GetMapping("/")
	public String home() {
		return "home";
	}
	
	@GetMapping("/userLogin")
	public String userLogin() {
		return "userLogin";
	}
	
	@GetMapping("userSignUp")
	public String userSignUp() {
		return "userSignUp";
	}
	
	@GetMapping("findUserId")
	public String findUserId() {
		return "findUserId";
	}
}
