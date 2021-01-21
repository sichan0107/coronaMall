package coronaMall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
// �ڹ� 8�� ��¥ API�� Mysql�� ���� ȣȯ�� �ȵǾ� ������ ���� ��� -> �Ʒ� ������̼� �� ���� �ذ�
@EnableJpaAuditing
@EntityScan(basePackageClasses = {Jsr310JpaConverters.class}, basePackages = {"coronaMall"})
@SpringBootApplication
public class CoronaMallApplication {

	public static void main(String[] args) {
		// param : ���ø����̼� Ŭ����, ����� args
		SpringApplication.run(CoronaMallApplication.class, args);
	}

}
