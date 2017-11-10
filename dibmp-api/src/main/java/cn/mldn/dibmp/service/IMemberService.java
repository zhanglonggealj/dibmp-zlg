package cn.mldn.dibmp.service ;

import java.util.Map;
import java.util.Set;

import cn.mldn.dibmp.vo.Member;


public interface IMemberService {
	/**
	 * 根据用户ID获得一个用户的完整对象信息，包含有密码和锁定状态
	 * @param mid 要查询的用户ID
	 * @return 用户对象，如果用户不存在返回null
	 */
	public Member get(String mid) ;
	public Member getName(String name) ;
	/**
	 * 根据指定的用户编号获得其对应的所有授权信息（角色、权限）
	 * @param mid 用户ID
	 * @return 返回的信息里面包含有两类数据：
	 * 1、key = allRoles、value = 该用户具备的所有角色；
	 * 2、key = allActions、value = 该用户具备的所有权限
	 */
	public Map<String,Set<String>> getRoleAndActionByMember(String mid) ;
	/**
	 * 根据指定的用户编号获得其对应的用户信息、部门信息及职位信息
	 * @param mid 用户ID
	 * @return 返回的信息里面包含有三类数据：
	 * 1、key = member , value = 该用户的基本信息
	 * 2、key = dept , value = 该用户所在部门的信息
	 * 3、key = level , value = 该用户的职位信息
	 */
	public Map<String,Object> getDeptAndLevelByMember(String mid);
}
