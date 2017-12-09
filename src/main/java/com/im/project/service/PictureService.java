package com.im.project.service;

import java.util.List;
import java.util.Map;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.im.project.model.Picture;

public interface PictureService {
	/**
	 * 加载首页的logo和论文
	 */
	public Map<String,Object> loadIndex();
	/**
	 * 添加图片
	 * @param pic 图片实体
	 * @return 成功与否
	 */
	public boolean addPicture(CommonsMultipartFile picture,Map<String,Object> map,String realPath,String id,String type,int status)throws Exception;
	/**
	 * 根据主键查找图片
	 * @param id 图片id
	 * @return 结果集
	 */
	public Picture findPicture(String id)throws Exception;
	/**
	 * 根据主键删除图片
	 * @param id 图片id
	 * @return 成功与否
	 */
	public boolean delPicture(String id)throws Exception;
	/**
	 * 修改图片
	 * @param pic 图片实体
	 * @return 成功与否
	 */
	public boolean modifyPicture(Picture pic)throws Exception;
	/**
	 * 加载首页三张大图
	 * @return 结果集
	 */
	public List<String> loadBigPic() throws Exception;
	/**
	 * 加载paper四张大图
	 * @return 结果集
	 */
	public List<String> loadPaperPic() throws Exception;
	/**
	 * 分页查找图片
	 * @param picMap 要查找的页数信息
	 * @return 结果集
	 */
	public List<Picture> findPicByPage(Map<String, Object> picMap)throws Exception;
	/**
	 * 清理修改过的图片
	 */
	public boolean cleanPicture();
}
