package com.nf.controller;

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.nf.dao.TestDao;
import com.nf.domain.CreateMsgReq;
import com.nf.domain.UserInfo;
import com.nf.entity.AssetQuota;
import com.nf.entity.Result;
import com.nf.util.ResultUtil;
import com.nf.util.TokenService;

import io.jsonwebtoken.Claims;
import net.sf.json.JSONObject;

@RestController
@RequestMapping("/test")
public class TestController {
	
	

	@Autowired
	private TestDao testDao;

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public AssetQuota createMsg(@RequestBody String requestJson,HttpServletRequest request) {
 		Claims claims = (Claims) request.getAttribute("claims");
		System.out.println(claims.toString());
		JSONObject json = JSONObject.fromObject(requestJson);
		String id = json.getString("id");

		CreateMsgReq re = new CreateMsgReq();
		testDao.createMsg(re);
		return testDao.getMsgById(id);
	}
	
	/**
	 * s上传
	 * @Title: createMsg 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param file
	 * @param @param request
	 * @param @return    
	 * @return String    返回类型 
	 * @time 2018年2月7日 上午10:04:34
	 * @throws
	 */
	@RequestMapping(value = "/hello", method = RequestMethod.POST)
	public String createMsg(@RequestParam("file") MultipartFile file, HttpServletRequest request) {
		
		if (!file.isEmpty()) {  
            String saveFileName = file.getOriginalFilename();  
            saveFileName = saveFileName.substring(saveFileName.lastIndexOf("\\")+1, saveFileName.length());
            File saveFile = new File(request.getSession().getServletContext().getRealPath("/upload/") + saveFileName);  
            if (!saveFile.getParentFile().exists()) {  
                saveFile.getParentFile().mkdirs();  
            }  
            try {  
                BufferedOutputStream out = new BufferedOutputStream(new FileOutputStream(saveFile));  
                out.write(file.getBytes());  
                out.flush();  
                out.close();  
                return " 上传成功";  
            } catch (FileNotFoundException e) {  
                e.printStackTrace();  
                return "上传失败," + e.getMessage();  
            } catch (IOException e) {  
                e.printStackTrace();  
                return "上传失败," + e.getMessage();  
            }  
        } else {  
            return "上传失败，因为文件为空.";  
        }  
	}
	
	/**
	 * 下载
	 * @Title: downloadFile 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param request
	 * @param @param response
	 * @param @return    
	 * @return String    返回类型 
	 * @time 2018年2月7日 上午10:04:57
	 * @throws
	 */
	@RequestMapping("/download")
	public String downloadFile(HttpServletRequest request, HttpServletResponse response) {
//	    String fileName = "aim_test.txt";// 设置文件名，根据业务需要替换成要下载的文件名

	    String fileName = request.getParameter("loadfile");


	    if (fileName != null) {
	        //设置文件路径
	        String realPath = request.getSession().getServletContext().getRealPath("/upload/");
	        File file = new File(realPath , fileName);
	        if (file.exists()) {
	            response.setContentType("application/force-download");// 设置强制下载不打开
	            response.addHeader("Content-Disposition", "attachment;fileName=" + fileName);// 设置文件名
	            byte[] buffer = new byte[1024];
	            FileInputStream fis = null;
	            BufferedInputStream bis = null;
	            try {
	                fis = new FileInputStream(file);
	                bis = new BufferedInputStream(fis);
	                OutputStream os = response.getOutputStream();
	                int i = bis.read(buffer);
	                while (i != -1) {
	                    os.write(buffer, 0, i);
	                    i = bis.read(buffer);
	                }
	                System.out.println("success");
	            } catch (Exception e) {
	                e.printStackTrace();
	            } finally {
	                if (bis != null) {
	                    try {
	                        bis.close();
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }
	                if (fis != null) {
	                    try {
	                        fis.close();
	                    } catch (IOException e) {
	                        e.printStackTrace();
	                    }
	                }
	            }
	        }
	    }
	    return null;
	}
	public static final List<UserInfo> userlist= new ArrayList<>();
	public static final Map<String, UserInfo> map = new HashMap<>();
	static
	{
		UserInfo user= new UserInfo();
		user.setId("1234");
		user.setName("wang");
		user.setPwd("1234");
		UserInfo user1= new UserInfo();
		user1.setId("12345");
		user1.setName("wang1");
		user1.setPwd("12345");
		map.put(user.getName(), user);
		map.put(user1.getName(), user1);

	}
	
	/**
	 * 获取token
	 * @Title: login 
	 * @Description: TODO(这里用一句话描述这个方法的作用) 
	 * @param @param userInfo
	 * @param @return    
	 * @return Result    返回类型 
	 * @time 2018年2月9日 下午2:33:59
	 * @throws
	 */
	@RequestMapping(value = "/login", method=RequestMethod.POST)
	public Result login(@RequestBody UserInfo userInfo)
	{
		
		if(!map.containsKey(userInfo.getName()))
		{
			return ResultUtil.error(403, "error");
		}
		
		TokenService tokenService = new TokenService();
		
		return ResultUtil.success(tokenService.createJWT("wang", "ww", "wang", 500000));
	}
	
	
	
	
}
