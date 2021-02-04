package coronaMall.data;

import java.util.HashMap;
import java.util.HashSet;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import coronaMall.goods.Goods;

public interface GoodsRepository extends JpaRepository<Goods, Long>{
}
