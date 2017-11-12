package cn.mldn.dibmp.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.IWitemDAO;
import cn.mldn.dibmp.service.IWitemService;
import cn.mldn.dibmp.vo.Witem;
@Service
public class WitemServiceImpl implements IWitemService {
	@Resource
	private IWitemDAO witemDAO;
	@Override
	public List<Witem> getWitemAll() {
		return this.witemDAO.findAll();
	}
	@Override
	public Witem getByWiid(Long wiid) {
		return this.witemDAO.findByWiid(wiid);
	}
	
	

}
