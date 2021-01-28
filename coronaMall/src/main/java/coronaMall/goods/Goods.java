package coronaMall.goods;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import coronaMall.basket.Basket;
import lombok.Data;

@Data
@Entity
@Table(name="goods")
public class Goods {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private int price;
	private String name;
	private String company;
	private String main_img;
	
	@Column(name = "description_img")
	private String des_img;
	private String content;
	private int stock;
	private int hitcnt;
	
	//단방향으로 안해도 됨
//	@OneToMany(mappedBy = "goods")
//	private List<Basket> basketlist = new ArrayList<>();

}

