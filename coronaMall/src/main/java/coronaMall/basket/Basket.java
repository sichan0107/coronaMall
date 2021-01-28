package coronaMall.basket;

import javax.persistence.*;


import coronaMall.goods.Goods;
import coronaMall.order.Order;
import lombok.Data;

@Entity
//@IdClass(BasketId.class) //�ĺ� �����϶� ���
@Data
public class Basket {
	
	//��ǰ�� �ֹ� PK�θ� �ϸ� ���߿� ��������, ���������� ������ ���� ���� PK�� ���� ����
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
	// erd������ ����Ű���� �⺻ Ű �ϳ�(��ĺ� ����)�� �ϴ°� �´°� ���Ƽ� ��ȯ
	private Order order;
	
}
