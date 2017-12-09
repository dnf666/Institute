package com.im.project.service.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.im.project.manager.GradMapper;
import com.im.project.model.Grad;
import com.im.project.service.GradService;

@Service("gradService")
public class GradServiceImpl implements GradService {
	@Resource
	private GradMapper gradDao;

	public Grad findGrad(Integer id) throws Exception {
		// TODO Auto-generated method stub
		Grad grad = new Grad();
		if (id > 0 && id < Integer.MAX_VALUE) {
			grad = gradDao.selectByPrimaryKey(id);
		}
		return grad;
	}

	public boolean delGrad(Integer id,String pictureId) throws Exception {
		// TODO Auto-generated method stub
		boolean boo = false;
		if (id > 0 && id < Integer.MAX_VALUE) {
			int i = gradDao.deleteByPrimaryKey(id);
			if (i == 1) {
				boo = true;
			}
		}
		return boo;
	}

	public boolean addGrad(Grad grad) throws Exception {
		// TODO Auto-generated method stub
		boolean boo = false;
		if (grad != null) {
			int i = gradDao.insert(grad);
			if (i == 1) {
				boo = true;
			}
		}
		return boo;
	}

	public boolean modifyGrad(Grad grad) throws Exception {
		// TODO Auto-generated method stub
		boolean boo = false;
		if (grad != null) {
			int i = gradDao.updateByPrimaryKey(grad);
			if (i == 1) {
				boo = true;
			}
		}
		return boo;
	}

	public List<Grad> findGradByPage(Map<String, Object> map) throws Exception {
		// TODO Auto-generated method stub
		List<Grad> gradList = new ArrayList<Grad>();
		if (map != null) {
			gradList = gradDao.findAll(map);
		}
		return gradList;
	}

	public Integer findRecords() throws Exception {
		// TODO Auto-generated method stub
		Integer i = 0;
		i = gradDao.countRecords();
		return i;
	}

	@Override
	public boolean addPostGrad(Grad g) {
		boolean boo = false;
		if (g != null) {
			int i = gradDao.insertPostGrad(g);
			if (i == 1) {
				boo = true;
			}
		}
		return boo;
	}

	@Override
	public boolean delPostGrad(int id, String pictureId) {
		boolean boo = false;
		if (id > 0 && id < Integer.MAX_VALUE) {
			int i = gradDao.deletePostGradByPrimaryKey(id);
			if (i == 1) {
				boo = true;
			}
		}
		return boo;
	}

	@Override
	public boolean modifyPostGrad(Grad g) {
		boolean boo = false;
		if (g != null) {
			int i = gradDao.updatePostGradByPrimaryKey(g);
			if (i == 1) {
				boo = true;
			}
		}
		return boo;
	}
}
