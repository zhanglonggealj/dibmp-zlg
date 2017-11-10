package cn.mldn.dibmp.service;

import java.util.List;

import cn.mldn.dibmp.vo.Witem;

public interface IWitemService {
	/**
	 * 查询所有的仓库分类信息
	 */
	public List<Witem> getWitemAll();
}
