package coronaMall.goods;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import lombok.Data;

@Data
@Entity
@Table(name="goods")
public class Goods {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long goods_id;
	
	//notnull, notempty, notblank 
	// "", " "
	@NotNull
	private int goods_price;
	@NotBlank
	private String goods_name;
	@NotBlank
	private String goods_company;
	@NotBlank
	private String goods_img; // 대표 이미지 경로
	@NotBlank
	private String goods_description; // 상세 설명 이미지 경로 
}
//	private int goods_stock;
//	
//	private int goods_hitcnt;
//	
//	@NotNull
//	private Type type;
//	
//	public static enum Type {
//		COSMETIC, LIFE
//	}
//	
//	//private LocalDateTime createdDateTime = LocalDateTime.now();
//	private List<GoodsReview> goods_reviews;
//}
