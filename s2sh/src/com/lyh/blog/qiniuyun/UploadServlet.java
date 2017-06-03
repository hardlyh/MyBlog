package com.lyh.blog.qiniuyun;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.UUID;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;


/**
 * Servlet implementation class UploadServlet
 */
@WebServlet(name="UploadServlet",value="/admin/UploadServlet.servlet")
public class UploadServlet extends HttpServlet {
	
	
	private static final long serialVersionUID = 1L;
    private String number;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public UploadServlet() {
        super();
        // TODO Auto-generated constructor stub
    }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
//		String fileanme="";
//		DiskFileItemFactory factory = new DiskFileItemFactory();//产生FileItem的工厂
//		ServletFileUpload sfu = new ServletFileUpload(factory);
//		List<FileItem> items = new ArrayList<FileItem>();
//		ServletContext sc=super.getServletConfig().getServletContext();
//		number= (String) sc.getAttribute("number");
//		Part part = request.getPart("myFileName");
//		System.out.println("[part : "+part);
//		System.out.println("size : "+items.size());
//		if(number==null){
//			number="1";
//		}
//	
//		try {
//			items = sfu.parseRequest(request);
//		} catch (FileUploadException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		for(FileItem item:items){
//			Upload u=new Upload();
//			fileanme=u.upload(item, number);
//			sc.setAttribute("number", String.valueOf(Integer.parseInt(number)+1));
//		}
//		
//		response.getWriter().write("http://oelty6wgj.bkt.clouddn.com/"+fileanme);
		request=(HttpServletRequest)request;
		 String path = request.getRealPath("/image");
	        File file = new File(path);
	        if (!file.exists())
	            file.mkdirs();
	        String fileName = "";// 文件名称


	        /**上传文件处理内容**/
	        DiskFileItemFactory factory = new DiskFileItemFactory();
	        ServletFileUpload sfu = new ServletFileUpload(factory);
	        sfu.setHeaderEncoding("UTF-8"); // 处理中文问题
	        sfu.setSizeMax(1024 * 1024); // 限制文件大小
	        try {
	            List<FileItem> fileItems = sfu.parseRequest(request); // 解码请求
	            System.out.println("fi"+request);
	            System.out.println("fi"+fileItems.size());
	            for (FileItem fi : fileItems) {
	                fileName = UUID.randomUUID()+fi.getName().substring(fi.getName().lastIndexOf("."),fi.getName().length());
	                fi.write(new File(path, fileName));
	              
	            }
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
	        /**********************/

	        //获取图片url地址
	       String imgUrl = "http://localhost:8080/wang_editor_demo/image/" + fileName;
	     
        response.setContentType("text/text;charset=utf-8");
        PrintWriter out = response.getWriter();
        out.print(imgUrl);  //返回url地址
        out.flush();
        out.close();
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
