package cn.mldn.dibmp.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.IGoodsDAO;
import cn.mldn.dibmp.service.IGoodsService;
import cn.mldn.dibmp.vo.Goods;
import cn.mldn.util.service.abs.AbstractService;
@Service
public class GoodsServiceImpl extends AbstractService implements IGoodsService {
	@Resource
	private IGoodsDAO goodsDAO;
	@Override
	public boolean addGoods(Goods goods) {
		if(this.goodsDAO.findByName(goods.getName())==null) {
			return this.goodsDAO.doCreate(goods);
		}
		return false;
	}
	@Override
	public Map<String, Object> getGoodsAll() {
		Map<String,Object> map=new HashMap<>();
		map.put("allGoods", this.goodsDAO.findAll());
		return map;
	}
	@Override
	public Map<String, Object> getSplit(String column, String keyWord, Long currentPage, Integer lineSize) {
		Map<String,Object> map=new HashMap<String,Object>();
		System.err.println(column+"======="+keyWord);
		map.put("allGoods", this.goodsDAO.findSpilt(super.paramToMap( column, keyWord,currentPage, lineSize)));
		System.err.println(this.goodsDAO.findGoodsCount(super.paramToMap( column, keyWord)));
		map.put("allRecorders", this.goodsDAO.findGoodsCount(super.paramToMap( column, keyWord)));
		return map;
	}
	@Override
	public Goods getGoodsByGid(Long gid) {
		return this.goodsDAO.findGoodsByGid(gid);
	}

}
