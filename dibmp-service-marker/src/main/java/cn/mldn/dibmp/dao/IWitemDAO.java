package cn.mldn.dibmp.dao;

import java.util.List;

import cn.mldn.dibmp.vo.Witem;

public interface IWitemDAO {
	/**
	 * 查询所有的仓库分类信息
	 */
	public List<Witem> findAll();
	/**
	 * 通过商品分类wiid获取商品的类型 
	 */
	public Witem findByWiid(Long wiid);
}
