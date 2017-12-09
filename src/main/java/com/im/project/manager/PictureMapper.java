package com.im.project.manager;

import java.util.List;

import org.springframework.stereotype.Repository;

import com.im.project.model.Picture;

@Repository("pictureDao")
public interface PictureMapper extends BaseDao<Picture, String> {
	/**
	 * 查询LOGO的链接
	 * @return 结果集
	 */
	public List<String> getLogosUrl();

	/**
	 * 后台查询LOGO图片对象
	 * 
	 */
	public List<Picture> getLogos();
	
	
	/**
	 * 查询首页四张论文图片链接
	 * 
	 */
	public List<String> getPapersUrl();
	
	
	/**
	 * 后台查询首页四张图片对象
	 * 
	 * 
	 */
	public List<Picture> getPapers();
}
