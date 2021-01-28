package coronaMall.customer;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

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
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import lombok.AccessLevel;
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
	@Size(min=8, max=10, message="8~12 ���ڸ� �Է����ּ���.")
	private final String username;
	
	@Column(nullable = false)
	//@Size(min=8, max=12, message="10~12 ���ڸ� �Է����ּ���.")
	private final String password;
	
	@Column(length = 5, nullable = false)
	//@Size(min=2, max=4, message="�ּ� �� ���� �̻��� �̸��� �Է����ּ���.")
	private final String fullname;
	
	@Column(nullable = false)
	//@Pattern(regexp = "^01(?:0|1|[6-9])[-]?(\\d{3}|\\d{4})[-]?(\\d{4})$" ,
	//		 message = "01x-xxxx-xxxx�� ���˿� ���߾� �ּ���.")
	private final String phone;
	
	@Column(nullable = false)
	private final String address;
	
	@Column(nullable = false)
	private final String email;
	
    @OneToOne
    @JoinColumn(name="authorities_id")
    private final Authority authority;
	
	
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
	//�н����� ���� ����
	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}
	//���� ��� ���ɿ���
	@Override
	public boolean isEnabled() {
		return true;
	}
	
	
	
}