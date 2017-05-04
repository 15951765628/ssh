package com.tedu.action;


import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.opensymphony.xwork2.ActionSupport;
import com.tedu.tools.FileUtil;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Controller
@Scope("prototype")
public class UploadAction extends ActionSupport { 

    //如有多个文件上传可以使用数组接收
    private File file;  
    private String fileFileName;  
    private String fileContentType;

    private List<String> u;
    
    //(要接收的表单参数) .... 
        private String type;

    public void  upload() {
        // to do something
    	 // 将文件放于项目部署路径下的upload文件夹下
        String path = "img/" + fileFileName;
        // 根据相对部署路径计算完整路径
        path = ServletActionContext.getServletContext().getRealPath(path);
        // 将临时文件复制到上述路径下
        FileUtil.copy(file, new File(path));
    }
    
    public String find(){
    
    	File file = new File( ServletActionContext.getServletContext().getRealPath("img/skin"));
    	String[] fileList=file.list();
    	u=new ArrayList<String>();
    	for(int i=0;i<fileList.length;i++){
    		File readFile=new File(ServletActionContext.getServletContext().getRealPath("img/skin"+"\\"+fileList[i]));
    		String s="ssh/img/skin/"+readFile.getName();
    		u.add(s);
    	}
    	
    	return "success";
    }


    
    
    //setter getter
    public File getFile() {
        return file;
    }


    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getFileFileName() {
        return fileFileName;
    }

    public String getFileContentType() {
        return fileContentType;
    }

    public void setFile(File file) {
        this.file = file;
    }

    public void setFileFileName(String fileFileName) {
        this.fileFileName = fileFileName;
    }

    public void setFileContentType(String fileContentType) {
        this.fileContentType = fileContentType;
    }

	public List<String> getU() {
		return u;
	}

	public void setU(List<String> u) {
		this.u = u;
	}


}