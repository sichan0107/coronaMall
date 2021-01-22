package coronaMall.order;

import java.time.LocalDateTime;
import java.util.Date;

import javax.persistence.*;

import lombok.Data;

@Entity
@Table(name = "goods_order")
@Data
public class Order {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int order_id;
	
	private LocalDateTime order_date = LocalDateTime.now();
	
	private int order_total;
	
//	@OneToMany
//	@JoinColumn(name = "customer_id")
	private String customer_id;
	
}
