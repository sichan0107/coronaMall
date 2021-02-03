package coronaMall.customer;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.IdClass;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import coronaMall.order.Order;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Data
@Entity
@Table(name = "customer")
@NoArgsConstructor(access = AccessLevel.PRIVATE, force=true)
@RequiredArgsConstructor
public class Customer implements UserDetails{
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@Column(unique = true, nullable = false)
	@Size(min=8, max=10, message="8~12 글자를 입력해주세요.")
	private final String username;
	
	@Column(nullable = false)
	//@Size(min=8, max=12, message="10~12 글자를 입력해주세요.")
	private final String password;
	
	@Column(length = 5, nullable = false)
	//@Size(min=2, max=4, message="최소 두 글자 이상의 이름을 입력해주세요.")
	private final String fullname;
	
	@Column(nullable = false)
	//@Pattern(regexp = "^01(?:0|1|[6-9])[-]?(\\d{3}|\\d{4})[-]?(\\d{4})$" ,
	//		 message = "01x-xxxx-xxxx의 포맷에 맞추어 주세요.")
	private final String phone;
	
	@Column(nullable = false)
	private final String address;
	
	@Column(nullable = false)
	private final String email;
	
    @Column(nullable = false)
    private final String auth;
    
	
	@Column(nullable = false)
	private final LocalDateTime created = LocalDateTime.now();


	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		Set<GrantedAuthority> roles = new HashSet<GrantedAuthority>();
		for(String role : auth.split(",")) {
			roles.add(new SimpleGrantedAuthority(role));
		}
		return roles;
	}

	// Expired가 붙은 메소드 명들은 사용자의 활성화 여부를 나타낸다
	// 계정 만료 여부
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

	@Override
	public String getPassword() {
		return password;
	}

	@Override
	public String getUsername() {
		return username;
	}

	@OneToMany(mappedBy = "customer")
	// customer를 이용해 값을 보여주기만한다 수정 못함
	private List<Order> orderList = new ArrayList<>();
}