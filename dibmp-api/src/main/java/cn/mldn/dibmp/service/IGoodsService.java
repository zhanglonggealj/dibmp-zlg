package cn.mldn.dibmp.service;

import java.util.Map;

import cn.mldn.dibmp.vo.Goods;

public interface IGoodsService {
	/**
	 * 增加商品信息
	 * @param goods 需要增加的商品信息
	 * @return 增加成功返回true，失败返回false
	 */
	public boolean editGood(Goods goods);
	/**
	 * 增加商品信息
	 * @param goods 需要增加的商品信息
	 * @return 增加成功返回true，失败返回false
	 */
	public boolean addGoods(Goods goods);
	/**
	 * 查询所有的商品信息
	 * @return	返回查询出来的商品信息
	 */
	public Map<String,Object> getGoodsAll();
	/**
	 * 模糊分页查询
	 * @param column 查询列
	 * @param keyWord 关键字
	 * @param currentPage 本页
	 * @param lineSize 每页条数
	 * @return
	 */
	public Map<String,Object> getSplit(String column,String keyWord,Long currentPage,Integer lineSize);
	/**
	 * 通过商品Gid获取商品 的信息
	 */
	public Goods getGoodsByGid(Long gid);
}
