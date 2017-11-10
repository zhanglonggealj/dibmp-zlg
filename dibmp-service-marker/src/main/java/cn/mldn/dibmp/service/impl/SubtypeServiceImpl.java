package cn.mldn.dibmp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.ISubtypeDAO;
import cn.mldn.dibmp.service.ISubtypeService;
import cn.mldn.dibmp.vo.Subtype;
@Service
public class SubtypeServiceImpl implements ISubtypeService {
	@Resource
	private ISubtypeDAO subtypeDAO;
	@Override
	public List<Subtype> getSubtypeByWiid(Long wiid) {
		return this.subtypeDAO.findByWiid(wiid);
	}

}
