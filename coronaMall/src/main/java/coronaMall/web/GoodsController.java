package coronaMall.web;

import java.util.Arrays;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import coronaMall.goods.Goods;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
//경로를 정확히 지정할 때, 클래스 단위의 RequestMapping을 쓴다. (/goods/methods)
@RequestMapping("/goods")
public class GoodsController {
	
	//localhost:8080/goods로 접속하면 showGoods가 실행된다.
	@GetMapping
	public String showGoods(Model model) {
		List<Goods> goods = Arrays.asList();
		//model은 컨트롤러와 뷰 사이의 데이터를 운반하는 객체로, model에 있는 데이터는
		//서블릿 요청 속성들로 복사된다.
		return "showGoods";
	}
	
//	private List<Goods> filterByType(List<Goods> goodsList, GoodsType goodsType){
//		return goodsList
//				.stream()
//				.filter(x -> x.getGoodsType().equals(goodsType))
//				.collect(Collectors.toList());
//	}
		
		
		
		
		
}
