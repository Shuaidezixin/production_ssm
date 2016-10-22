package org.hqu.production_ms.service.impl;

import java.util.List;

import org.hqu.production_ms.domain.CustomResult;
import org.hqu.production_ms.domain.EUDataGridResult;
import org.hqu.production_ms.domain.authority.SysRole;
import org.hqu.production_ms.domain.authority.SysRoleExample;
import org.hqu.production_ms.domain.po.RolePO;
import org.hqu.production_ms.mapper.authority.SysRoleMapper;
import org.hqu.production_ms.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;

@Service
public class RoleServiceImpl implements RoleService{

	@Autowired
	SysRoleMapper sysRoleMapper;
	
	@Override
	public EUDataGridResult getList(int page, int rows, SysRole sysRole) {
		//查询列表
		SysRoleExample example = new SysRoleExample();
		//分页处理
		PageHelper.startPage(page, rows);
		List<SysRole> list = sysRoleMapper.selectByExample(example);
		//创建一个返回值对象
		EUDataGridResult result = new EUDataGridResult();
		result.setRows(list);
		//取记录总条数
		PageInfo<SysRole> pageInfo = new PageInfo<>(list);
		result.setTotal(pageInfo.getTotal());
		return result;
	}

	@Override
	public SysRole get(String string) {
		
		return sysRoleMapper.selectByPrimaryKey(string);
	}

	@Override
	public CustomResult delete(String string) {
		int i = sysRoleMapper.deleteByPrimaryKey(string);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult deleteBatch(String[] ids) {
		int i = sysRoleMapper.deleteBatch(ids);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult insert(RolePO role) {
		int i = sysRoleMapper.insert(role);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult update(RolePO role) {
		int i = sysRoleMapper.updateByPrimaryKeySelective(role);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public CustomResult updateAll(RolePO role) {
		int i = sysRoleMapper.updateByPrimaryKey(role);
		if(i>=0){
			return CustomResult.ok();
		}else{
			return null;
		}
	}

	@Override
	public List<SysRole> find() {
		SysRoleExample example = new SysRoleExample();
		return sysRoleMapper.selectByExample(example);
	}
}
