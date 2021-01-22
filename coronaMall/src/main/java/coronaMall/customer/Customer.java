package coronaMall.customer;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "customer")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer implements UserDetails{
	
	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@NotBlank
	@Size(min=8, max=12, message="8~12 글자를 입력해주세요.")
	private final String username;
	
	@NotBlank
	@Size(min=10, max=12, message="10~12 글자를 입력해주세요.")
	private final String password;
	
	@NotBlank
	@Size(min=2, max=4, message="최소 두 글자 이상의 이름을 입력해주세요.")
	private final String fullname;
	
	@NotBlank
	@Pattern(regexp = "^01(?:0|1|[6-9])[-]?(\\d{3}|\\d{4})[-]?(\\d{4})$" ,
			 message = "01x-xxxx-xxxx의 포맷에 맞추어 주세요.")
	private final String phone_num;
	
	@NotBlank
	private final String address;
	
	@Email
	private final String email;
	
	
	@NotNull
	private final LocalDateTime createdDate = LocalDateTime.now();
	
	private LocalDateTime deletedDate;

	// 해당 사용자에게 부여된 권한을 저장한 컬렉션을 반환 (리스트로 받는다)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("USER"));
	}

	// Expired가 붙은 메소드 명들은 사용자의 활성화 여부를 나타낸다
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
	
}