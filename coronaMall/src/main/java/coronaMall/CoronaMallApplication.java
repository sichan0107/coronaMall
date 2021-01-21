package coronaMall;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.convert.threeten.Jsr310JpaConverters;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
// 자바 8의 날짜 API와 Mysql의 버전 호환이 안되어 에러가 생길 경우 -> 아래 어노테이션 두 개로 해결
@EnableJpaAuditing
@EntityScan(basePackageClasses = {Jsr310JpaConverters.class}, basePackages = {"coronaMall"})
@SpringBootApplication
public class CoronaMallApplication {

	public static void main(String[] args) {
		// param : 애플리케이션 클래스, 명령행 args
		SpringApplication.run(CoronaMallApplication.class, args);
	}

}
