package cn.mldn.dibmp.service;

import cn.mldn.dibmp.vo.Level;

public interface ILevelService {
	/**
	 * 通过职位LID获取职位信息
	 */
	public Level getByLid(Long lid);
}
