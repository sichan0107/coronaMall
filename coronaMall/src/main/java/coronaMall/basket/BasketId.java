package coronaMall.basket;

import java.io.Serializable;

import coronaMall.order.Order;

//�̰͵� ���������� �ĺ� ���踦 �Ⱦ����� ������
public class BasketId implements Serializable{
	
	private int goods;
	private int order;
//	private int order;
//	private int order_customer;
//	private int order_customer_username;
//	
	public BasketId() {}
	public BasketId(int goods, int order) {
		this.goods = goods;
		this.order = order;
	}
//	public BasketId(int goods, int order, int order_customer, int order_customer_username) {
//		this.goods = goods;
//		this.order = order;
//		this.order_customer = order_customer;
//		this.order_customer_username = order_customer_username;
//	}

}
