package coronaMall.delivery;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "deliveries")
@Data
// ���� �Ȱǵ�
public class Delivery {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int deliveries_id;
	
	@Embeddable
	public enum DeliveryStatus {
		READY_STATUS, SHIPPING_STATUS, COMPLETE_STATUS
	}
	
	@Enumerated(value = EnumType.STRING)
	//string���� �ؾ� �߰��� �߰��Ǿ ���� �Ȼ���
    private DeliveryStatus status;
	
	
	//@OneToOne
	@JoinColumn(name = "order_order_id")
	private int order_id;
	
	//@OneToOne
	@JoinColumn(name = "order_customer_customer_id")
	private String customer_id;
	
}
