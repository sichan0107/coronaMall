package coronaMall.order;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.*;

import coronaMall.basket.Basket;
import coronaMall.customer.Customer;
import lombok.Data;

@Entity
@Table(name = "orders")
@Data
public class Order {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	// Long를 사용하는 이유 : 엔티티를 생성하고, JPA를 통해 DB에 저장하는 시점이 되어야 값이 설정되기 때문
	// 그래서 null을 유지할 수 있는 상태가 필요
	
	private LocalDateTime created_date;
	
	private int total_price;
	
	// order와 customer 를 연결
	// 복합키 일때
//	@ManyToOne(optional = false)
//	@JoinColumns({@JoinColumn(name = "customer_id", insertable = false, updatable = false),
//		@JoinColumn(name = "customer_username", insertable = false, updatable = false)})
	// insertable : 엔티티 저장시 이 필드도 같이 저장한다,  false일 경우 저장 안하고 읽기 전용
	// updateable : 엔티티 수정시 이 필드도 같이 저장한다, false일 경우 저장 안하고 읽기 전용
	//private Customer customer;
	
	//id 하나로 설정
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy = "order", targetEntity = Basket.class, cascade = CascadeType.ALL)
	private List<Basket> basketlist = new ArrayList<>();

}
