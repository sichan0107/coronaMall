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
//��θ� ��Ȯ�� ������ ��, Ŭ���� ������ RequestMapping�� ����. (/goods/methods)
public class GoodsController {
	
	//localhost:8080/goods�� �����ϸ� showGoods�� ����ȴ�.
	@Autowired
	GoodsService goodsservice;
	
	@GetMapping(value = "shop")
	public String getGoods(@PageableDefault Pageable pageable, Model model) {
		Page<Goods> goods = goodsservice.getPage(pageable);
		model.addAttribute("goods", goods);
		System.out.printf("�� element �� : %d, ��ü page �� : %d, �������� ǥ���� element �� : %d, ���� ������ index : %d, ���� �������� element �� : %d%n",
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
