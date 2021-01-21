package coronaMall.goods;

import java.time.LocalDateTime;

import lombok.Data;

@Data
public class GoodsReview {
	private long goods_id;
	private String review_contents;
	private String review_img;
	private LocalDateTime writtenAt = LocalDateTime.now();
	private boolean deleted_yn = false;
}
