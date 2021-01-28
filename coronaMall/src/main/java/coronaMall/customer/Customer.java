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
// ����Ű ��� �� order�� customer�� ���ν����ִ� ������̼�
@Table(name = "customer")
@RequiredArgsConstructor(access = AccessLevel.PROTECTED)
public class Customer implements UserDetails {
	
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;

	@Column(unique = true, nullable = false)
	@Size(min = 8, max = 10, message = "8~12 ���ڸ� �Է����ּ���.")
	private String username;

	@Column(nullable = false)
	// @Size(min=8, max=12, message="10~12 ���ڸ� �Է����ּ���.")
	private String password;

	@Column(length = 5, nullable = false)
	// @Size(min=2, max=4, message="�ּ� �� ���� �̻��� �̸��� �Է����ּ���.")
	private String fullname;

	@Column(nullable = false)
	// @Pattern(regexp = "^01(?:0|1|[6-9])[-]?(\d{3}|\d{4})[-]?(\d{4})$" ,
	// message = "01x-xxxx-xxxx�� ���˿� ���߾� �ּ���.")
	private String phone;

	@Column(nullable = false)
	private String address;

	@Column(nullable = false)
	private String email;

	// private String auth;

	@Column(nullable = false)
	private final LocalDateTime created = LocalDateTime.now();

	// �ش� ����ڿ��� �ο��� ������ ������ �÷����� ��ȯ (����Ʈ�� �޴´�)
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return Arrays.asList(new SimpleGrantedAuthority("ROLE_USER"));
	}

	// Expired�� ���� �޼ҵ� ����� ������� Ȱ��ȭ ���θ� ��Ÿ����
	// ���� ���� ����
	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	// ���� ��� ����
	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	// �н����� ���� ����
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	// ���� ��� ���ɿ���
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
	// customer�� �̿��� ���� �����ֱ⸸�Ѵ� ���� ����
	private List<Order> orderList = new ArrayList<>();
}