package coronaMall.customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import coronaMall.order.Order;
import lombok.AccessLevel;
import lombok.Data;
import lombok.RequiredArgsConstructor;

@Data
@Entity
//@IdClass(CustomerId.class)
// 복합키 사용 시 order와 customer를 매핑시켜주는 어노테이션
@Table(name = "customer")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	@Size(min = 8, max = 10, message = "8~12 글자를 입력해주세요.")
	private String username;

	@Column(nullable = false)
	// @Size(min=8, max=12, message="10~12 글자를 입력해주세요.")
	private String password;

	@Column(length = 5, nullable = false)
	// @Size(min=2, max=4, message="최소 두 글자 이상의 이름을 입력해주세요.")
	private String fullname;

	@Column(nullable = false)
	// @Pattern(regexp = "^01(?:0|1|[6-9])[-]?(\d{3}|\d{4})[-]?(\d{4})$" ,
	// message = "01x-xxxx-xxxx의 포맷에 맞추어 주세요.")
	private String phone;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private String email;

	// private String auth;

	@Column(nullable = false)
	private final LocalDateTime created = LocalDateTime.now();

	// 해당 사용자에게 부여된 권한을 저장한 컬렉션을 반환 (리스트로 받는다)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	// Expired가 붙은 메소드 명들은 사용자의 활성화 여부를 나타낸다
	// 계정 만료 여부
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// 계정 잠김 여부
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// 패스워드 만료 여부
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// 계정 사용 가능여부
	@Override
	public boolean isEnabled() {
		return true;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return null;
	}

	@OneToMany(mappedBy = "customer")
	// customer를 이용해 값을 보여주기만한다 수정 못함
	private List<Order> orderList = new ArrayList<>();
}