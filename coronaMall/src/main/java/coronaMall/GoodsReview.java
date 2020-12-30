package coronaMall;

import java.util.List;

import lombok.Data;

@Data
public class GoodsReview {
	private final String reviewWriter;
	private String reviewContents;
	private String reviewWrittenTime;
	private List<String> reviewReply; // 나중에 대댓글 DTO를 하나 만들어야 할듯?
	private int hitCount;
	
}
