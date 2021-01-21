package coronaMall.data;

import org.springframework.data.repository.CrudRepository;

import coronaMall.goods.Goods;

public interface GoodsRepository extends CrudRepository<Goods, Long>{

}
