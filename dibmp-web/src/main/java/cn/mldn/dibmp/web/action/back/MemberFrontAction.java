package cn.mldn.dibmp.web.action.back;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.mldn.dibmp.service.IDeptService;
import cn.mldn.dibmp.service.ILevelService;
import cn.mldn.dibmp.service.IMemberService;
import cn.mldn.dibmp.vo.Dept;
import cn.mldn.dibmp.vo.Level;
import cn.mldn.dibmp.vo.Member;
import cn.mldn.util.action.abs.AbstractAction;
@Controller
@RequestMapping("/pages/back/admin/member/*")
public class MemberFrontAction extends AbstractAction{
	@Resource
	private IMemberService memberService;
	@Resource
	private IDeptService deptService;
	@Resource
	private ILevelService levelService;
	@RequestMapping("get")
	@ResponseBody
	public Object getMember(String name) {
		Map<String,Object> map=new HashMap<String,Object>();
		Member member=this.memberService.getName(name);
		Level level=this.levelService.getByLid(member.getLid());
		Dept dept=this.deptService.getByDid(member.getDid());
		map.put("member", member);
		map.put("level", level);
		map.put("dept", dept);
		return map;
	}
}
