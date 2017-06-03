package com.lyh.blog.qiniuyun;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;

import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import com.lyh.blog.util.Upload;


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
		String fileanme="";
		DiskFileItemFactory factory = new DiskFileItemFactory();//产生FileItem的工厂
		ServletFileUpload sfu = new ServletFileUpload(factory);
		List<FileItem> items = new ArrayList<FileItem>();
		ServletContext sc=super.getServletConfig().getServletContext();
		number= (String) sc.getAttribute("number");
		Part part = request.getPart("myFileName");
		System.out.println("[part : "+part);
		System.out.println("size : "+items.size());
		if(number==null){
			number="1";
		}
	
		try {
			items = sfu.parseRequest(request);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		for(FileItem item:items){
			Upload u=new Upload();
			fileanme=u.upload(item, number);
			sc.setAttribute("number", String.valueOf(Integer.parseInt(number)+1));
		}
		
		response.getWriter().write("http://oelty6wgj.bkt.clouddn.com/"+fileanme);
		
	}
	

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
