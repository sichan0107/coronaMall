package coronaMall.goods;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Data
public class Food {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	private String goodsName;
	private int goodsPrice;
	private String company;
	private String imgPath;
	private String goodsDescription;
}
