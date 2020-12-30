package coronaMall;

import java.util.List;

import lombok.Data;

@Data
public class Goods {
	private final String goodsCode;
	private final String goodsName;
	private int goodsPrice;
	private List<GoodsReview> goodsReview;
	private final GoodsType goodsType;
	
	
	public static enum GoodsType{
		LIFE, FOOD, DRINKS, EASYWEAR, COSMETICS 
	}
}
