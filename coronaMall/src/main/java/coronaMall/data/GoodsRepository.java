package coronaMall.data;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import coronaMall.goods.Goods;

public interface GoodsRepository extends CrudRepository<Goods, Long>{
	public List<Goods> findByname(String name);
}
