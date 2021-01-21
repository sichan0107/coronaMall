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
//��θ� ��Ȯ�� ������ ��, Ŭ���� ������ RequestMapping�� ����. (/goods/methods)
@RequestMapping("/goods")
public class GoodsController {
	
	//localhost:8080/goods�� �����ϸ� showGoods�� ����ȴ�.
	@GetMapping
	public String showGoods(Model model) {
		List<Goods> goods = Arrays.asList();
		//model�� ��Ʈ�ѷ��� �� ������ �����͸� ����ϴ� ��ü��, model�� �ִ� �����ʹ�
		//���� ��û �Ӽ���� ����ȴ�.
		return "showGoods";
	}
	
//	private List<Goods> filterByType(List<Goods> goodsList, GoodsType goodsType){
//		return goodsList
//				.stream()
//				.filter(x -> x.getGoodsType().equals(goodsType))
//				.collect(Collectors.toList());
//	}
		
		
		
		
		
}
