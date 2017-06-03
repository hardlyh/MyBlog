package com.lyh.blog.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.io.FilenameUtils;

import com.google.gson.Gson;
import com.qiniu.common.QiniuException;
import com.qiniu.common.Zone;
import com.qiniu.http.Response;
import com.qiniu.storage.Configuration;
import com.qiniu.storage.UploadManager;
import com.qiniu.storage.model.DefaultPutRet;
import com.qiniu.util.Auth;

public class Upload {
	
	public static String upload(FileItem item,String number) {
		InputStream in;
		
		//Configuration cfg = new Configuration(Zone.zone1());
		Configuration cfg = new Configuration(Zone.zone0());
		//...其他参数参考类注释
		UploadManager uploadManager = new UploadManager(cfg);
		//...生成上传凭证，然后准备上传
		String key = FilenameUtils.getName(number+item.getName());
		String accessKey = "mIIKJO9gxKLSKEiUEiIRZHuU_oXPkYpZOhotSIYN";
		String secretKey = "r9yHYzYX77jr1yoF7mv7jZCaL2xNgXNdPmE4N9U0";
		//String bucket = "frist";
		String bucket = "two2";
		Auth auth = Auth.create(accessKey, secretKey);
		String upToken = auth.uploadToken(bucket);
			try {
				System.out.println("upload");
				in = item.getInputStream();
				Response response2= uploadManager.put(in,key,upToken,null, null);
				DefaultPutRet putRet = new Gson().fromJson(response2.bodyString(), DefaultPutRet.class);
				
		        return key;
			} catch (QiniuException e) {
		          Response r = e.response;
		          // 请求失败时打印的异常的信息
		          System.out.println(r.toString());
		          try {
		              //响应的文本信息
		            System.out.println(r.bodyString());
		          } catch (QiniuException e1) {
		              //ignore
		          }
		      }   catch (IOException e1) {
	              e1.printStackTrace();
	          }
			
			
			return null;
			
	}

}
