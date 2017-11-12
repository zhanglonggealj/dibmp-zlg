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
public class TestGoodsService extends TestCase {
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
	public void testgetDept() {
		System.err.println(this.deptService.getByDid(2L));
	}
	
	@Test
	public void testWitemAll() {
		System.err.println(this.witemService.getWitemAll());
	}
	
	@Test
	public void testAddGoods() {
		Goods vo=new Goods();
		vo.setName("piqwe德uo");
		vo.setWiid(1L);
		vo.setStid(1L);
		vo.setPrice(1000.0);
		vo.setWeight(1200.2);
		vo.setNote("张龙奥菲姐姐稍等奥维姐姐");
		vo.setDelflag(0);
		System.err.println(vo);
		boolean fal = this.goodsService.addGoods(vo);
		
		if(fal) {
			System.err.println("增加成功");
		}
		
		TestCase.assertTrue(fal);
	}
/*	@Test
	public void testFindAll() {
		System.err.println("ttt"+this.goodsService.getAllGoods());
	}*/
	@Test
	public void testGetGoods() {
		System.err.println(this.goodsService.getSplit("","",0L,0));
		
	}
}
