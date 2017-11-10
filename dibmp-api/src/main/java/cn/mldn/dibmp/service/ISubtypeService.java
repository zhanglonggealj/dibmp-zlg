package cn.mldn.dibmp.service;

import java.util.List;

import cn.mldn.dibmp.vo.Subtype;

public interface ISubtypeService {
	/**
	 * 通过商品分类ID获得商品子分类的信息
	 * @param wiid 商品分类ID
	 * @return 用List返回商品子分类ID信息
	 */
	public List<Subtype> getSubtypeByWiid(Long wiid);
}
