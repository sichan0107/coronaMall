package coronaMall.customer;

import java.time.LocalDateTime;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@Table(name = "customer")
public class Customer {
	@Id
	@Size(min=8, max=12, message="8~12 ���ڸ� �Է����ּ���.")
	private String id;
	
	@NotBlank
	@Size(min=10, max=12, message="10~12 ���ڸ� �Է����ּ���.")
	private String password;
	
	@NotBlank
	@Size(min=2, max=4, message="�ּ� �� ���� �̻��� �̸��� �Է����ּ���.")
	private  String name;
	
	@NotBlank
	@Pattern(regexp = "^01(?:0|1|[6-9])[-]?(\\d{3}|\\d{4})[-]?(\\d{4})$" ,
			 message = "01x-xxxx-xxxx�� ���˿� ���߾� �ּ���.")
	private String phone_num;
	
	@NotBlank
	private String address;
	
	@Email
	private String email;
	
	
	@NotNull
	private LocalDateTime createdDate;
	
	private LocalDateTime deletedDate;
	
	
	
}