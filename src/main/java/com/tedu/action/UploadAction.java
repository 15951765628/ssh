package com.tedu.action;


import javax.annotation.Resource;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import com.tedu.service.AccountService;
import com.tedu.service.UserService;

import java.io.File;
import org.apache.struts2.ServletActionContext;
import com.tedu.tools.FileUtil;

@Controller
@Scope("prototype")
public class UploadAction {

	@Resource
	private AccountService accountService;
	
	
	/**
     * 接收拦截器传入的临时文件
     */
    private File some;
    
    @Resource
	private UserService userService;
    
    private int userId;
    
    /**
     * 接收拦截器注入的原始文件名
     */
    private String someFileName;
    
    public String upload() {
        if (some == null)
            return "error";
        // 将文件放于项目部署路径下的upload文件夹下
        String path = "WEB-INF/upload/" + someFileName;
        // 根据相对部署路径计算完整路径
        path = ServletActionContext.getServletContext().getRealPath(path);
        // 将临时文件复制到上述路径下
        FileUtil.copy(some, new File(path));
        
        userService.updateUser(userId, null, null, null, null, null, null, null, someFileName);
        return "success";
    }
    
    
    
    
    public File getSome() {
        return some;
    }
    public int getUserId() {
        return userId;
    }
    
    public void setUserId(int userId) {
        this.userId = userId;
    }
    
    public void setSome(File some) {
        this.some = some;
    }
    public String getSomeFileName() {
        return someFileName;
    }
    public void setSomeFileName(String someFileName) {
        this.someFileName = someFileName;
    }
}
