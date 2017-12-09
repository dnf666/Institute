package com.im.project.service;

import static java.lang.Integer.MAX_VALUE;
import static java.lang.Integer.MIN_VALUE;
import static org.junit.Assert.*;

import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.im.project.model.Picture;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = { "classpath*:spring-mybatis.xml" })
public class PictureServiceTest {
	@Resource
	PictureService pictureService;
	
	/*@Test
	public void testAddPicture() throws Exception {
		Picture pic=new Picture();
		pic.setLink("123ggggg添加");
		pic.setDate("2012-7-12");
		pic.setType(5);
		boolean boo=pictureService.addPicture(pic);
		assertEquals(boo, true);
		//fail("Not yet implemented");
	}
*/
	/*@Test
	public void testFindPicture() throws Exception {
		//fail("Not yet implemented");
		Picture pic=pictureService.findPicture(11);
		
		//System.out.println(pic.getId());
		int i=pic.getId();
		assertEquals(i,11);
	}
*/@Test
	public void test()throws Exception{
		try { // 防止文件建立或读取失败，用catch捕捉错误并打印，也可以throw

                /* 读入TXT文件 */
			//String pathname = "D:\\twitter\\13_9_6\\dataset\\en\\input.txt"; // 绝对路径或相对路径都可以，这里是绝对路径，写入文件时演示相对路径
			String pathname="D:\\迅雷下载\\1.txt";
			File filename = new File(pathname); // 要读取以上路径的input。txt文件
			InputStreamReader reader = new InputStreamReader(
					new FileInputStream(filename)); // 建立一个输入流对象reader
			BufferedReader br = new BufferedReader(reader); // 建立一个对象，它把文件内容转成计算机能读懂的语言
			String line = "";
			line = br.readLine();
			while (line != null) {
				//System.out.println(line);
				line = br.readLine();
				// 一次读入一行数据
			}

                /* 写入Txt文件 */
			//File writename = new File(".\\result\\en\\output.txt"); // 相对路径，如果没有则要建立一个新的output。txt文件
			File writename=new File("test1.txt");
			writename.createNewFile(); // 创建新文件
			BufferedWriter out = new BufferedWriter(new FileWriter(writename));
			out.write("我会写入文件啦\r\n"); // \r\n即为换行
			out.flush(); // 把缓存区内容压入文件
			out.close(); // 最后记得关闭文件

		} catch (Exception e) {
			e.printStackTrace();
		}

}

	@Test
	public void testDelPicture() throws Exception {
		//fail("Not yet implemented");
		boolean boo=pictureService.delPicture("s6");
		assertEquals(boo,true);
	}

	@Test
	public void testModifyPicture() throws Exception {
		//fail("Not yet implemented");
		Picture pic=new Picture();
		pic.setLink("123ggggg");
		pic.setDate("2012-7-12");
		pic.setType("2");
		pic.setId("3");
		boolean boo=pictureService.modifyPicture(pic);
		assertEquals(boo, true);
	}

	@Test
	public void testLoadBigPic() throws Exception {
		//fail("Not yet implemented");
		List<String> picList=pictureService.loadBigPic();
		//picList.size();
		assertEquals(picList.size(), 3);
		
	}

	@Test
	public void testFindPicByPage() throws Exception {
//
//		//fail("Not yet implemented");
//		Map<String,Object> map=new HashMap<String,Object>();
//		map.put("pageNow", 2);
//		map.put("pageSize",3 );
//
//		List<Picture> list=pictureService.findPicByPage(map);
//		//System.out.println(list.size());
//		for(Picture pic:list){
//			//System.out.println(pic.getId());
//		}
//		//assertEquals(list.size(), 3);
		String s = "1 2";
		//System.out.println(s);
	}
	@Test
	public void test2(){

				String str = "     +004500";
		//System.out.println(myAtoi(str));
	}
	public int myAtoi(String str) {
		String str1 = str.trim();
//判断是否为空格或者全是空格
		//System.out.println("str1:"+str1);
		if (str1.isEmpty()) {
			return 0;
		}

		// 如果字符串以空格开始
		int start = 0; //从开始找第一个不是空格的数
		boolean positive = true; // 是否为正数默认为true

//         if (str.charAt(start) == ' ') {
//             while (str.charAt(start) == ' ') {
//                 start++;
//                 if (start >= str.length()) { // 输入的全是空格
// //                    throw new NumberFormatException("Invalid input string: " + str);
//                     return 0;
//                 }
//             }
//         }

		if (str1.charAt(start) == '-') { // 第一个非空白字符中-
			positive = false;
			start++;
		} else if (str1.charAt(start) == '+') {// 第一个非空白字符是+
			start++;
		} else if (str1.charAt(start) >= '0' && str1.charAt(start) <= '9') { // 第一个非空白字符是数字
			return cal(str1, start, true);
		} else { // 其它情况就抛出异常
//            throw new NumberFormatException("Invalid input string: " + str);
			return 0;
		}


		if (start >= str1.length()) { // 第一个非空白字符是+或者-但也是最后一个字符
//            throw new NumberFormatException("Invalid input string: " + str);
			return 0;
		}

		if (str1.charAt(start) > '9' || str1.charAt(start) < '0') { // +或者-后面接的不是数字
//            throw new NumberFormatException("Invalid input string: " + str);
			return 0;
		} else {
			return cal(str1, start, positive);
		}
	}

	private int cal(String str, int start, boolean positive) {

		long result = 0;
		while (start < str.length() && str.charAt(start) >= '0' && str.charAt(start) <= '9') {
			result = result * 10 + (str.charAt(start) - '0');

			if (positive) { // 如果是正数
				if (result > Integer.MAX_VALUE) {
//                    throw new NumberFormatException("Invalid input string: " + str);
					return Integer.MAX_VALUE;
				}

			} else {
				if (-result < Integer.MIN_VALUE) {
//                    throw new NumberFormatException("Invalid input string: " + str);
					return Integer.MIN_VALUE;
				}
			}

			start++;
		}

		if (positive) {
			return (int) result;
		} else {
			return (int) -result;
		}
	}

	}

