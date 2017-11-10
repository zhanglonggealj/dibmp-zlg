package cn.mldn.dibmp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.IDeptDAO;
import cn.mldn.dibmp.service.IDeptService;
import cn.mldn.dibmp.vo.Dept;
@Service
public class DeptServiceImpl implements IDeptService {
	@Resource
	private IDeptDAO deptDAO;
	@Override
	public Dept getByDid(Long did) {
		System.err.println(did);
		return this.deptDAO.findById(did);
	}

}
