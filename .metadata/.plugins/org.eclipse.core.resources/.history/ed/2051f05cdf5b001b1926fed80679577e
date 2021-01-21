package coronaMall.goods;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor

@Entity
public class Cosmetic {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String goodsName;
	private int goodsPrice;
	private String company;
	private String imgPath;
	private String goodsDescription;
}
