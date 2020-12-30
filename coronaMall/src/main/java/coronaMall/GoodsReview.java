package coronaMall;

import java.util.List;

import lombok.Data;

@Data
public class GoodsReview {
	private final String reviewWriter;
	private String reviewContents;
	private String reviewWrittenTime;
	private List<String> reviewReply; // ���߿� ���� DTO�� �ϳ� ������ �ҵ�?
	private int hitCount;
	
}
