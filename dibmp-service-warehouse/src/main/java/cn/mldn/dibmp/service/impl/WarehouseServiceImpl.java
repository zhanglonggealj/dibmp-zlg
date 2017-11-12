package cn.mldn.dibmp.service.impl;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.IWarehouseDAO;
import cn.mldn.dibmp.service.IWarehouseService;
import cn.mldn.dibmp.vo.Warehouse;
import cn.mldn.util.service.abs.AbstractService;
@Service
public class WarehouseServiceImpl extends AbstractService implements IWarehouseService {
	@Resource
	private IWarehouseDAO warehouseDAO;
	@Override
	public boolean add(Warehouse warehouse) {
		if(this.warehouseDAO.findByName(warehouse.getName())==null) {
			return this.warehouseDAO.doCreate(warehouse);
		}
		return false;
	}

	@Override
	public Warehouse getByWid(Long wid) {
		return this.warehouseDAO.findByWid(wid);
	}

	@Override
	public Map<String, Object> getSplit(String column, String keyWord, Long currentPage, Integer lineSize) {
		Map<String,Object> map=new HashMap<>();
		map.put("allWarehouse", this.warehouseDAO.findSplit(super.paramToMap(column, keyWord, currentPage, lineSize)));
		map.put("allRecorders", this.warehouseDAO.findCount(super.paramToMap(column, keyWord)));
		return map;
	}

}
