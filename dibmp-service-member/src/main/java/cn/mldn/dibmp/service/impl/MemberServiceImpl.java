package cn.mldn.dibmp.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.IActionDAO;
import cn.mldn.dibmp.dao.IDeptDAO;
import cn.mldn.dibmp.dao.ILevelDAO;
import cn.mldn.dibmp.dao.IMemberDAO;
import cn.mldn.dibmp.dao.IRoleDAO;
import cn.mldn.dibmp.service.IMemberService;
import cn.mldn.dibmp.vo.Member;
@Service
public class MemberServiceImpl implements IMemberService {
	@Resource
	private IMemberDAO memberDAO ;
	@Resource
	private IRoleDAO roleDAO ;
	@Resource
	private IActionDAO actionDAO ;
	@Resource
	private IDeptDAO deptDAO;
	@Resource
	private ILevelDAO levelDAO;
	@Override
	public Member get(String mid) {
		return this.memberDAO.findById(mid);
	}

	@Override
	public Map<String, Set<String>> getRoleAndActionByMember(String mid) {
		Map<String, Set<String>> map = new HashMap<>() ;
		map.put("allRoles", this.roleDAO.findAllByMember(mid)) ;
		map.put("allActions", this.actionDAO.findAllByMember(mid)) ;
		return map;
	}

	@Override
	public Map<String, Object> getDeptAndLevelByMember(String mid) {
		Map<String,Object> map=new HashMap<>();
		map.put("member", this.memberDAO.findById(mid));
		map.put("dept", this.deptDAO.findById(this.memberDAO.findById(mid).getDid()));
		map.put("level",this.levelDAO.findByLid(this.memberDAO.findById(mid).getLid()));
		return map;
	}

	@Override
	public Member getName(String name) {
		// TODO Auto-generated method stub
		return null;
	}

}
