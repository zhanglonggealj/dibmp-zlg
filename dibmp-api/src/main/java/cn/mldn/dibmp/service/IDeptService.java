package cn.mldn.dibmp.service;

import cn.mldn.dibmp.vo.Dept;

public interface IDeptService {
	/**
	 * 通过部门did查询部门信息
	 */
	public Dept getByDid(Long did);
}
