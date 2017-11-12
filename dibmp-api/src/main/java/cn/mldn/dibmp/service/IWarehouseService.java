package cn.mldn.dibmp.service;

import java.util.List;
import java.util.Map;

import cn.mldn.dibmp.vo.Warehouse;

public interface IWarehouseService {
	/**
	 * 增加新仓库
	 * @param warehouse 需要增加的仓库信息
	 * @return	增加成功返回true，否则返回false
	 */
	public boolean add(Warehouse warehouse);
	/**
	 * 通过仓库编号Wid查询仓库信息
	 * @param wid 仓库编号wid
	 * @return 返回查询出来的仓库信息
	 */
	public Warehouse getByWid(Long wid);
	/**
	 * 获取仓库信息
	 * @param column 查询列
	 * @param keyWord 关键字
	 * @param currentPage 当前所在页
	 * @param lineSize	每页数据量
	 * @return
	 */
	public Map<String,Object> getSplit(String column,String keyWord,Long currentPage,Integer lineSize);
}
