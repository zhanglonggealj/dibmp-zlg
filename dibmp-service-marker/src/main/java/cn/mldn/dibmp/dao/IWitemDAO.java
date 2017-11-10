package cn.mldn.dibmp.dao;

import java.util.List;

import cn.mldn.dibmp.vo.Witem;

public interface IWitemDAO {
	/**
	 * 查询所有的仓库分类信息
	 */
	public List<Witem> findAll();
}
