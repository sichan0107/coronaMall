package coronaMall.customer;

import java.io.Serializable;

// 식별자 관계일때는 DTO에서 ID를 두개 쓰는것보다 따로 키를 관리하는 클래스를 만들어서 함
// 근데 최종적으로 id 하나로 만들었기 때문에 지금은 안씀
public class CustomerId implements Serializable{
	
	private long id;
	private String username;
	
	public CustomerId() {}
	public CustomerId(long id, String username) {
		this.id = id;
		this.username = username;
	}

}
