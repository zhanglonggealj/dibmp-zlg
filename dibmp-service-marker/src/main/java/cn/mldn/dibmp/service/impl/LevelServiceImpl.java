package cn.mldn.dibmp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.ILevelDAO;
import cn.mldn.dibmp.service.ILevelService;
import cn.mldn.dibmp.vo.Level;
@Service
public class LevelServiceImpl implements ILevelService {
	@Resource
	private ILevelDAO levelDAO;
	@Override
	public Level getByLid(Long lid) {
		System.err.println(lid);
		return this.levelDAO.findByLid(lid);
	}

}
