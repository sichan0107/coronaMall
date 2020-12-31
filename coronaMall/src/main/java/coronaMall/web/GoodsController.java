package coronaMall.web;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import coronaMall.Goods;
import coronaMall.Goods.GoodsType;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
//��θ� ��Ȯ�� ������ ��, Ŭ���� ������ RequestMapping�� ����. (/goods/methods)
@RequestMapping("/goods")
public class GoodsController {
	
	//localhost:8080/goods�� �����ϸ� showGoods�� ����ȴ�.
	@GetMapping
	public String showGoods(Model model) {
		List<Goods> goods = Arrays.asList(
				new Goods("KF94 ����ũ 50��", 30000, GoodsType.LIFE),
				new Goods("KF80 ����ũ 50��", 25000, GoodsType.LIFE),
				new Goods("��Ż ����ũ 50��", 22000, GoodsType.LIFE),
				new Goods("�Ŷ�� 5����", 3500, GoodsType.FOOD),
				new Goods("��ټ� 2.0L 6��", 4000, GoodsType.FOOD),
				new Goods("�ĸ��� ��� ��Ʈ", 10000, GoodsType.EASYWEAR),
				new Goods("��ī ��", 30000, GoodsType.COSMETICS)
				);
		GoodsType[] types = Goods.GoodsType.values();
		//model�� ��Ʈ�ѷ��� �� ������ �����͸� ����ϴ� ��ü��, model�� �ִ� �����ʹ�
		//���� ��û �Ӽ���� ����ȴ�.
		for(GoodsType goodsType : types) {
			model.addAttribute(goodsType.toString(), filterByType(goods, goodsType));
		}
		
		return "showGoods";
	}
	
	private List<Goods> filterByType(List<Goods> goodsList, GoodsType goodsType){
		return goodsList
				.stream()
				.filter(x -> x.getGoodsType().equals(goodsType))
				.collect(Collectors.toList());
	}
		
		
		
		
		
}
