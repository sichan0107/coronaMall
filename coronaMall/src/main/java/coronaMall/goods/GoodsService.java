package coronaMall.goods;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import coronaMall.data.GoodsRepository;

@Service
public class GoodsService {
	
	@Autowired
	private GoodsRepository goodsrepo;
	
	public List<Goods> findAll(){
		List<Goods> goods = new ArrayList();
		goodsrepo.findAll().forEach(e -> goods.add(e));
		return goods;
	}
	
	public Optional<Goods> findById(Long id){
		Optional<Goods> goods = goodsrepo.findById(id);
		return goods;
	}

}
