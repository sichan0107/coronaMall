package coronaMall;

import lombok.Data;

@Data
public class Customer {
	private final String name;
	private final String id;
	private String password;
	private String phone_num;
	private String address;
	private String email;
	
}
