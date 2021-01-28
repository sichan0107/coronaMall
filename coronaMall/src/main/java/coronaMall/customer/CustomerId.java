package coronaMall.customer;

import java.io.Serializable;

// �ĺ��� �����϶��� DTO���� ID�� �ΰ� ���°ͺ��� ���� Ű�� �����ϴ� Ŭ������ ���� ��
// �ٵ� ���������� id �ϳ��� ������� ������ ������ �Ⱦ�
public class CustomerId implements Serializable{
	
	private long id;
	private String username;
	
	public CustomerId() {}
	public CustomerId(long id, String username) {
		this.id = id;
		this.username = username;
	}

}
