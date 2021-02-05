package coronaMall.web;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import coronaMall.goods.Goods;
import coronaMall.goods.GoodsService;

@Controller
public class OrderController {
	
	@Autowired
	GoodsService goodsservice;
	
	@GetMapping(value = "cart/{id}")
	public String addCart(@PathVariable("id") Long id, Model model) {
		Optional<Goods> goods = goodsservice.findById(id);
		Goods product = goods.get();
		model.addAttribute("product", product);
		System.out.println(product);
		return "shopping-cart";
	}

}
