package coronaMall.customer;

import java.sql.Date;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.Data;

@Data
public class Customer {
	
	@NotNull
	@Size(min=2, max=4, message="최소 두 글자 이상의 이름을 입력해주세요.")
	private final String name;
	
	@NotNull
	@Size(min=8, max=12, message="8~12 글자를 입력해주세요.")
	private final String id;
	
	@NotNull
	@Size(min=10, max=12, message="10~12 글자를 입력해주세요.")
	private String password;
	
	@NotNull
	@Pattern(regexp = "^01(?:0|1|[6-9])[-]?(\\d{3}|\\d{4})[-]?(\\d{4})$" ,
			 message = "01x-xxxx-xxxx의 포맷에 맞추어 주세요.")
	private String phone_num;
	
	@NotBlank
	private String address;
	
	@NotBlank
	private String email;
	
	@NotNull
	private Date createdDate;
	
	private Date deletedDate;
	
	
	
}