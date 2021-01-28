package coronaMall.delivery;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "deliveries")
@Data
// 아직 안건듬
public class Delivery {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int deliveries_id;
	
	@Embeddable
	public enum DeliveryStatus {
		READY_STATUS, SHIPPING_STATUS, COMPLETE_STATUS
	}
	
	@Enumerated(value = EnumType.STRING)
	//string으로 해야 중간에 추가되어도 문제 안생김
    private DeliveryStatus status;
	
	
	//@OneToOne
	@JoinColumn(name = "order_order_id")
	private int order_id;
	
	//@OneToOne
	@JoinColumn(name = "order_customer_customer_id")
	private String customer_id;
	
}
