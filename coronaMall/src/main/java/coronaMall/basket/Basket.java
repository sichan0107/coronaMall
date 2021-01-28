package coronaMall.basket;

import javax.persistence.*;


import coronaMall.goods.Goods;
import coronaMall.order.Order;
import lombok.Data;

@Entity
//@IdClass(BasketId.class) //식별 관계일때 사용
@Data
public class Basket {
	
	//상품과 주문 PK로만 하면 나중에 유지보수, 수정사항이 있을때 힘들어서 따로 PK를 만들어서 해줌
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "goods_id")
	private Goods goods;
	
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumns({@JoinColumn(name = "orders_id")})
//		@JoinColumn(name = "order_customer_id"),
//		@JoinColumn(name = "order_customer_username")})
	// erd에서는 복합키지만 기본 키 하나(비식별 관계)로 하는게 맞는거 같아서 전환
	private Order order;
	
}
