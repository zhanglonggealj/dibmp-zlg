package cn.mldn.dibmp.service.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.dibmp.service.IDeptService;
import cn.mldn.dibmp.service.IGoodsService;
import cn.mldn.dibmp.service.ILevelService;
import cn.mldn.dibmp.service.IWitemService;
import cn.mldn.dibmp.vo.Goods;
import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestWitemService extends TestCase {
	@Resource
	private IWitemService witemService;
	@Resource
	private IGoodsService goodsService;
	@Resource
	private IDeptService deptService;
	@Resource
	private ILevelService levelService;
	@Test
	public void testWitemfindBywiid() {
		System.err.println(this.witemService.getByWiid(3L));
	}
}
