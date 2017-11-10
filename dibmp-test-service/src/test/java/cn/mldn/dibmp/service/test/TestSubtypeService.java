package cn.mldn.dibmp.service.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.dibmp.service.ISubtypeService;
import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestSubtypeService extends TestCase {
	@Resource
	private ISubtypeService subtypeService;
	@Test
	public void testSubTypeByWiid() {
		System.err.println(this.subtypeService.getSubtypeByWiid(1L));
	}

}
