package coronaMall.goods;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import coronaMall.data.GoodsRepository;

@Service
public class GoodsService {
	
	@Autowired
	private GoodsRepository goodsrepo;
	
	public Page<Goods> getPage(Pageable pageable){
		int page = (pageable.getPageNumber() == 0) ? 0 : (pageable.getPageNumber() - 1); //page�� indexó�� 0���� ����
		pageable = PageRequest.of(page,12); // �� �������� 12���� �����ְ� ������
		
		return goodsrepo.findAll(pageable);
	}
	
	public Optional<Goods> findById(Long id){
		Optional<Goods> goods = goodsrepo.findById(id);
		return goods;
	}

}
