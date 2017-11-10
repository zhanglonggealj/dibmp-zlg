package cn.mldn.util.service.abs;

import java.util.HashMap;
import java.util.Map;

/**
 * 业务层继承的公共父类
 * @author YOOTK
 */
public abstract class AbstractService {
	/**
	 * 分页模糊查询参数数量类型转换
	 * @param currentPage 当前页
	 * @param lineSize 每页显示的行数
	 * @param column 查询列
	 * @param keyWord 关键字
	 * @return 返回需要查询的参数个数
	 */
	public Map<String,Object> paramToMap(String column, String keyWord, Long currentPage, Integer lineSize){
		Map<String,Object> map=new HashMap<String,Object>();
		map.put("start", (currentPage-1)*lineSize);
		map.put("lineSize", lineSize);
		if("".equals(column)) {
			map.put("column", null);
		}else {
			map.put("column", column);
		}
		if("".equals(keyWord)) {
			map.put("keyWord", null);
		}else {
			map.put("keyWord", "%"+keyWord+"%");
		}
		return map;
	}
	/**
	 * 用于查询模糊数据的条数
	 * @param column 查询列
	 * @param keyWord 关键字
	 * @return 返回Map值
	 */
	public Map<String,Object> paramToMap(String column,String keyWord){
		Map<String,Object> map=new HashMap<String,Object>();
		if("".equals(column)) {
			map.put("column", null);
		}else {
			map.put("column", column);
		}
		if("".equals(keyWord)) {
			map.put("keyWord", null);
		}else {
			map.put("keyWord", "%"+keyWord+"%");
		}
		return map;
	}
}
