package cn.mldn.dibmp.service.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.dibmp.service.IDeptService;
import cn.mldn.dibmp.service.IGoodsService;
import cn.mldn.dibmp.service.ILevelService;
import cn.mldn.dibmp.service.IMemberService;
import cn.mldn.dibmp.service.IWitemService;
import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)

public class TestMemberService extends TestCase {
	@Resource
	private IMemberService memberService;
	@Resource
	private IWitemService witemService;
	@Resource
	private IGoodsService goodsService;
	@Resource
	private IDeptService deptService;
	@Resource
	private ILevelService levelService;
	@Test
	public void testgetLevel() {
		System.err.println(this.levelService.getByLid(2L));
	}

	@Test
	public void testMembetGet() {
		System.err.println(this.memberService.get("mldn-warehouse"));
	}

	@Test
	public void testMembetRoleAndAction() {
		System.err.println(this.memberService.getRoleAndActionByMember("mldn-warehouse"));
	}
	@Test
	public void testMembetDeptAndLevel() {
		System.err.println(this.memberService.getRoleAndActionByMember("mldn-warehouse"));
	}
	
}
