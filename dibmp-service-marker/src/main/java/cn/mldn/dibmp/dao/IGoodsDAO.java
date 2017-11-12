package cn.mldn.dibmp.dao;

import java.util.List;
import java.util.Map;

import cn.mldn.dibmp.vo.Goods;

public interface IGoodsDAO {
	/**
	 * 修改商品信息
	 * @param goods 需要修改的商品信息
	 * @return 修改成功返回true，失败返回false
	 */
	public boolean editGoods(Goods goods);
	/**
	 * 增加商品信息
	 * @param goods 需要增加的商品信息
	 * @return 增加成功返回true，失败返回false
	 */
	public boolean doCreate(Goods goods);
	/**
	 * 查询商品是否存在
	 * @param name 需要判断是商品名称
	 * @return 商品已存在返回
	 */
	public Goods findByName(String name);
	/**
	 * 查询所有的商品信息
	 * @return	返回查询出来的商品信息
	 */
	public List<Goods> findAll();
	/**
	 * 查询数据行数
	 * @param map 查询条件
	 * @return	返回数据行数
	 */
	public Long findGoodsCount(Map<String,Object> map);
	/**
	 * 模糊分页查询数据
	 * @param map 查询条件及参数
	 * @return	返回查询结果
	 */
	public List<Goods> findSpilt(Map<String,Object> map);
	/**
	 * 通过商品Gid获取商品 的信息
	 */
	public Goods findGoodsByGid(Long gid);
}
