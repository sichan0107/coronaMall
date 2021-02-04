package coronaMall.web;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import coronaMall.goods.Goods;
import coronaMall.goods.GoodsService;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
//경로를 정확히 지정할 때, 클래스 단위의 RequestMapping을 쓴다. (/goods/methods)
public class GoodsController {
	
	//localhost:8080/goods로 접속하면 showGoods가 실행된다.
	@Autowired
	GoodsService goodsservice;
	
	@GetMapping(value = "shop")
	public String getGoods(@PageableDefault Pageable pageable, Model model) {
		Page<Goods> goods = goodsservice.getPage(pageable);
		model.addAttribute("goods", goods);
		System.out.printf("총 element 수 : %d, 전체 page 수 : %d, 페이지에 표시할 element 수 : %d, 현재 페이지 index : %d, 현재 페이지의 element 수 : %d%n",
				goods.getTotalElements(), goods.getTotalPages(), goods.getSize(),
				goods.getNumber(), goods.getNumberOfElements());
		return "shop";
	}

	@GetMapping(value = "{id}")
	public String getIdGoods(@PathVariable("id") Long id, Model model){
		Optional<Goods> goods = goodsservice.findById(id);
		Goods product = goods.get();
		model.addAttribute("product", product);
		return "shop-details";
	}

}
