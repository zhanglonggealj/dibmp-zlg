package cn.mldn.dibmp.web.action.back;

import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.shiro.SecurityUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.ContextLoader;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;

import cn.mldn.dibmp.service.IGoodsService;
import cn.mldn.dibmp.service.IMemberService;
import cn.mldn.dibmp.service.ISubtypeService;
import cn.mldn.dibmp.service.IWitemService;
import cn.mldn.dibmp.vo.Goods;
import cn.mldn.dibmp.vo.Subtype;
import cn.mldn.dibmp.vo.Witem;
import cn.mldn.util.action.abs.AbstractAction;
import cn.mldn.util.web.SplitPageUtil;

@Controller
@RequestMapping("/pages/back/admin/goods/*")
public class GoodsActionBack extends AbstractAction {
	@Resource
	private IGoodsService goodsService;
	@Resource
	private IWitemService witemService;
	@Resource
	private IMemberService memberService;
	@Resource
	private ISubtypeService subtypeService;
	private static final String TITLE = "商品" ;
	@RequestMapping("add_pre")
	public ModelAndView addPre() {	
		ModelAndView mav = new ModelAndView(super.getPage("goods.add.page"));
		return mav;
	} 
	@ResponseBody
	@RequestMapping("add")
	public ModelAndView add(Goods goods,MultipartFile pic) {
		
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		if(pic==null || pic.isEmpty()) {//判断图片信息是否存在
			System.err.println("没有图片上传");
		}else {//此时有图片信息上传
			System.err.println("【文件大小】："+pic.getSize());
			System.err.println("【文件MIME】:"+pic.getContentType());
			System.err.println("【稳健院士名字】："+pic.getOriginalFilename());
			String fileName=pic.getOriginalFilename().substring(pic.getOriginalFilename().lastIndexOf("."));
			//System.out.println("====="+fileName);
			String filePath=ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/WEB-INF/upload/")+UUID.randomUUID()+fileName;
			System.err.println(filePath);
			try {
				pic.transferTo(new File(filePath));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		goods.setPhoto(pic.getOriginalFilename());
		goods.setLastin(new Date());
		goods.setStornum(0);
		goods.setRecorder((String)SecurityUtils.getSubject().getSession().getAttribute("name"));
		goods.setDelflag(0);
		if(this.goodsService.addGoods(goods)) {
			super.setMsgAndUrl(mav, "goods.add.action", "vo.add.success", TITLE);
		}else {
			super.setMsgAndUrl(mav, "goods.add.action", "vo.add.failure", TITLE);
		}
		return mav;
	} 
	@RequestMapping("show")
	public ModelAndView show(Long gid) { 
		ModelAndView mav = new ModelAndView(super.getPage("goods.show.page"));
		Goods goods=this.goodsService.getGoodsByGid(gid);
		Witem witem= this.witemService.getByWiid(goods.getWiid());
		List<Subtype> subtype=this.subtypeService.getSubtypeByWiid(witem.getWiid());
		Map<String,Object> map=new HashMap<>();
		map.put("witem",witem);
		map.put("subtype", subtype);
		System.err.println(witem);
		map.put("goods", goods);
		mav.addAllObjects(map);
		return mav;
	}
	@RequestMapping("edit_pre")
	public ModelAndView editPre(Long gid) { 
		ModelAndView mav = new ModelAndView(super.getPage("goods.edit.page"));
		Goods good=this.goodsService.getGoodsByGid(gid);
		System.err.println(good);
		Map<String,Object> map=new HashMap<>();
		map.put("goods", good);;
		mav.addAllObjects(map);
		return mav;
	} 
	@RequestMapping("edit")
	public ModelAndView edit(Goods goods,MultipartFile pic) {
		ModelAndView mav = new ModelAndView(super.getPage("forward.page"));
		if(pic==null || pic.isEmpty()) {//判断图片信息是否存在
			System.err.println("没有图片上传");
		}else {//此时有图片信息上传
			System.err.println("【文件大小】："+pic.getSize());
			System.err.println("【文件MIME】:"+pic.getContentType());
			System.err.println("【稳健院士名字】："+pic.getOriginalFilename());
			String fileName=pic.getOriginalFilename().substring(pic.getOriginalFilename().lastIndexOf("."));
			//System.out.println("====="+fileName);
			String filePath=ContextLoader.getCurrentWebApplicationContext().getServletContext().getRealPath("/WEB-INF/upload/")+UUID.randomUUID()+fileName;
			System.err.println(filePath);
			try {
				pic.transferTo(new File(filePath));
			} catch (IllegalStateException | IOException e) {
				e.printStackTrace();
			}
		}
		goods.setPhoto(pic.getOriginalFilename());
		goods.setLastin(new Date());
		
		System.err.println("=============="+goods);
		if(this.goodsService.editGood(goods)) {
			super.setMsgAndUrl(mav, "goods.list.action", "vo.edit.success", TITLE);
		}else {
			super.setMsgAndUrl(mav, "goods.list.action", "vo.edit.failure", TITLE);
		}
		return mav;
	}
	@RequestMapping("list") 
	public ModelAndView list() {
		SplitPageUtil spu = new SplitPageUtil("商品编号:gid|商品名称:name", super.getPage("goods.list.action")) ;
		ModelAndView mav = new ModelAndView(super.getPage("goods.list.page"));
		Map<String,Object> map=this.goodsService.getSplit(spu.getColumn(), spu.getKeyWord(), spu.getCurrentPage(), spu.getLineSize());
		Map<String,Object> maps=new HashMap<>();
		@SuppressWarnings("unchecked")
		List<Goods> allGoods=(List<Goods>)map.get("allGoods");
		Iterator<Goods> iter=allGoods.iterator();
		while(iter.hasNext()) {
			Goods vo=iter.next();
			maps.put(vo.getRecorder(), this.memberService.getName(vo.getRecorder()));
		}
		System.err.println(maps);
 		map.put("allMember", maps);
		mav.addAllObjects(map);
		return mav;
	}
	@ResponseBody
	@RequestMapping("allwitem")
	public Object allwitem() {
		List<Witem> allWitem=this.witemService.getWitemAll();
		//System.err.println(allWitem);
		Iterator<Witem> w=allWitem.iterator();
		while(w.hasNext()) {
			Witem ww=w.next();
			System.err.println(ww);
		}
		return allWitem;
	} 
	@ResponseBody
	@RequestMapping("allsubtype")
	public Object listSubtype(Long wiid,HttpServletRequest request,HttpServletResponse response) {
		response.setCharacterEncoding("UTF-8");
		List<Subtype> allSubtype=this.subtypeService.getSubtypeByWiid(wiid);
		return allSubtype;
	} 
}
