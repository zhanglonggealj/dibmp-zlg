package cn.mldn.dibmp.dao;

import java.util.List;
import java.util.Map;

import cn.mldn.dibmp.vo.Warehouse;

public interface IWarehouseDAO {
	/**
	 * 增加新仓库
	 * @param warehouse 需要增加的仓库信息
	 * @return	增加成功返回true，否则返回false
	 */
	public boolean doCreate(Warehouse warehouse);
	/**
	 * 通过仓库名称name查询仓库信息
	 * @param name 仓库name
	 * @return 返回查询出来的仓库信息
	 */
	public Warehouse findByName(String name);
	/**
	 * 通过仓库编号Wid查询仓库信息
	 * @param wid 仓库编号wid
	 * @return 返回查询出来的仓库信息
	 */
	public Warehouse findByWid(Long wid);
	/**
	 * 统计仓库的总数
	 */
	public Long findCount(Map<String,Object> map);
	/**
	 * 模糊分页查询仓库信息
	 * @param map 查询条件
	 * @return	返回查询结果，以List形式返回
	 */
	public List<Warehouse> findSplit(Map<String,Object> map);
}
