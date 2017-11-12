package cn.mldn.dibmp.service.test;

import java.util.Date;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.dibmp.service.IGoodsService;
import cn.mldn.dibmp.service.ISubtypeService;
import cn.mldn.dibmp.vo.Goods;
import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSubtypeService extends TestCase {
	@Resource
	private ISubtypeService subtypeService;
	@Resource
	private IGoodsService goodsService;
	@Test
	public void testSubTypeByWiid() {
		System.err.println(this.subtypeService.getSubtypeByWiid(1L));
	}
	@Test
	public void testEdit() {
		Goods good=new Goods();
		good.setGid(36L);
		good.setName("哈哈");
		good.setWiid(2L);
		good.setStid(2L);
		good.setPrice(123.0);
		good.setWeight(123.0);
		good.setNote("是的发达阿发");
		good.setLastin(new Date());
		System.err.println(good);
		System.err.println(this.goodsService.editGood(good));
	}
}
