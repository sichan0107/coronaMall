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
	// Long�� ����ϴ� ���� : ��ƼƼ�� �����ϰ�, JPA�� ���� DB�� �����ϴ� ������ �Ǿ�� ���� �����Ǳ� ����
	// �׷��� null�� ������ �� �ִ� ���°� �ʿ�
	
	private LocalDateTime created_date;
	
	private int total_price;
	
	// order�� customer �� ����
	// ����Ű �϶�
//	@ManyToOne(optional = false)
//	@JoinColumns({@JoinColumn(name = "customer_id", insertable = false, updatable = false),
//		@JoinColumn(name = "customer_username", insertable = false, updatable = false)})
	// insertable : ��ƼƼ ����� �� �ʵ嵵 ���� �����Ѵ�,  false�� ��� ���� ���ϰ� �б� ����
	// updateable : ��ƼƼ ������ �� �ʵ嵵 ���� �����Ѵ�, false�� ��� ���� ���ϰ� �б� ����
	//private Customer customer;
	
	//id �ϳ��� ����
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "customer_id")
	private Customer customer;
	
	@OneToMany(mappedBy = "order", targetEntity = Basket.class, cascade = CascadeType.ALL)
	private List<Basket> basketlist = new ArrayList<>();

}
