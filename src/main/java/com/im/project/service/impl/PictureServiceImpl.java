
package com.im.project.service.impl;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.web.multipart.commons.CommonsMultipartFile;

import com.im.project.manager.PictureMapper;
import com.im.project.model.Picture;
import com.im.project.service.PictureService;

@Service("pictureService")
public class PictureServiceImpl implements PictureService {
	@Resource
	private PictureMapper pictureDao;
	
	public boolean addPicture(CommonsMultipartFile picture,Map<String,Object> map,String realPath,String id,String type,int status) throws Exception {
		// TODO Auto-generated method stub
		if(!picture.isEmpty()){ 
			File localFile=null;
      	  Long number=new Date().getTime();
      	  //设置存储名字
            String fileName=number.toString()+"upload";
            String realName=picture.getOriginalFilename();
            String fileType = "jpg,png,ico,bmp,jpeg";
      		String suffix = realName.substring(realName.lastIndexOf(".") + 1, realName.length());
      		if (!fileType.contains(suffix.trim().toLowerCase())) {
      			map.put("msg", "图片类型出错(jpg|png|ico|bmp|jpeg)");
      			return false;
      		}
          try {  
              //拿到输出流，同时重命名上传的文件  
        	//传入真实路径
          	File file=new File(realPath);
          	if(!file.isDirectory())
          		file.mkdir();
               localFile=new File(realPath+fileName);
              picture.transferTo(localFile);
          } catch (Exception e) {  
              e.printStackTrace();  
              map.put("msg", "上传出错");
              return false;
          }  
          //把附件存到数据库里
          String date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date());
          Picture pictureNew=new Picture();
          pictureNew.setLink(fileName);
          pictureNew.setType(type);
          pictureNew.setId(id);
          pictureNew.setRealPath(realPath);
          if(status==1){
          pictureNew.setDate(date);
          try{
         pictureDao.insert(pictureNew);
          }
          catch(Exception e){
          	e.printStackTrace();
          	map.put("msg", "插入出错");
          	localFile.delete();
          	return false;
          }
          }
          if(status==2){
        	  try{
        	         pictureDao.updateByPrimaryKey(pictureNew);
        	          }
        	          catch(Exception e){
        	          	e.printStackTrace();
        	          	map.put("msg", "failed");
        	          	localFile.delete();
        	          	return false;
        	          }  
          }
          map.put("msg", "success");
          return true;
      }
		map.put("msg", "文件为空");
		return false;
	}

	public Picture findPicture(String id) throws Exception {
		// TODO Auto-generated method stub
		Picture pic = new Picture();
		if (id !=null) {
			pic = pictureDao.selectByPrimaryKey(id);
		}
		return pic;
	}

	public boolean delPicture(String id) throws Exception {
		// TODO Auto-generated method stub
		boolean boo = false;
		if (id !=null && id!="") {
			Picture pic= pictureDao.selectByPrimaryKey(id);
			File file=new File(pic.getRealPath()+pic.getLink());
			if(file!=null){
			file.delete();
			}
			int i = pictureDao.deleteByPrimaryKey(id);
			if (i == 1) {
				boo = true;
			}
		}
		return boo;
	}

	public boolean modifyPicture(Picture pic) throws Exception {
		// TODO Auto-generated method stub
		boolean boo = false;
		if (pic != null) {
			int i = pictureDao.updateByPrimaryKey(pic);
			if (i == 1) {
				boo = true;
			}
		}
		return boo;
	}

	public List<String> loadBigPic() throws Exception {
		// TODO Auto-generated method stub
		List<String> logoList = pictureDao.getLogosUrl();
		return logoList;
	}

	public List<Picture> findPicByPage(Map<String, Object> picMap) throws Exception {
		// TODO Auto-generated method stub
		List<Picture> picList = new ArrayList<Picture>();
		if (picMap != null) {
			picList = pictureDao.findAll(picMap);
		}
		return picList;
	}

	public Map<String, Object> loadIndex() {
		// TODO Auto-generated method stub
		Map<String,Object> map=new HashMap<String,Object>();
		List<Picture> listLogos=pictureDao.getLogos();
		List<Picture> listPapers=pictureDao.getPapers();
		map.put("listLogos", listLogos);
		map.put("listPapers", listPapers);
		return map;
	}

	public List<String> loadPaperPic() throws Exception {
		List<String> paperList = pictureDao.getPapersUrl();
		return paperList;
		
	}

	public boolean cleanPicture() {
		// TODO Auto-generated method stub
		String path=pictureDao.selectByPrimaryKey("1").getRealPath();
		File f=new File(path);
		if(f.exists()){
		File[] files=f.listFiles();
		if(files.length!=0){
			for(File file:files){
				if(file.getName().contains("old")){
					file.delete();
					//System.out.println("清理一个磁盘文件"+new Date());
				}
			}
			return true;
		}
		}
		return false;
	}

	
	
	
}
