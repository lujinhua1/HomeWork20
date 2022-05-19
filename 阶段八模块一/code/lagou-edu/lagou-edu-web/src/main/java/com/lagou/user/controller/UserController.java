package com.lagou.user.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.lagou.entity.*;
import com.lagou.user.UserService;
import org.csource.common.NameValuePair;
import org.csource.fastdfs.*;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import javax.servlet.http.HttpServletRequest;
import java.io.*;
import java.util.UUID;

/**
 * @BelongsProject:com.lagou.user.controller
 * @Author: JinHua
 * @CreateTime:2022/5/11
 * @Description:
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Reference
    private UserService userService;

    @RequestMapping("/login")
    public UserVo<User> login(String phone, String password){
        UserVo<User> vo = new UserVo<>();
        System.out.println("phone:"+phone);
        System.out.println("password:"+password);
        Integer isPhoneExist = userService.checkPhone(phone);
        User user = new User();
        if(isPhoneExist==0){
            userService.register(phone, password);
            vo.setMessage("登陆手机尚未注册，系统自动已完成注册！");
            user = userService.login(phone, password);
        }else {
            user = userService.login(phone, password);
            if(user!=null){
                vo.setState(200);
                vo.setMessage("登陆成功!");
            }else {
                vo.setState(300);
                vo.setMessage("登陆失败!");
            }
        }
        vo.setContent(user);
        return vo;
    }

    @RequestMapping("updateUserInfo")
    public ResponseVo updateUserInfo(Integer userid,MultipartHttpServletRequest request,String name) throws Exception {
        MultipartFile portrait = request.getFile("portrait");
        /* 1. 下载到服务器图片目录 */
        String oldFileName = portrait.getOriginalFilename();
        String hz = oldFileName.substring(oldFileName.lastIndexOf(".") + 1);
        String newFileName = UUID.randomUUID().toString()+"."+hz;
        File toSaveFile = new File("D:/upload/"+newFileName);
        portrait.transferTo(toSaveFile);
        String newFilePath = toSaveFile.getAbsolutePath();
        /* 2. 上传到服务器  */
        ClientGlobal.initByProperties("config/fastdfs-client.properties");
        TrackerClient trackerClient = new TrackerClient();
        TrackerServer trackerServer = trackerClient.getConnection();
        StorageClient1 client1 = new StorageClient1(trackerServer, null);
        NameValuePair[] list = new NameValuePair[1];
        list[0] = new NameValuePair("fileName",oldFileName);
        String fileId = client1.upload_appender_file1(newFilePath, hz, list);
        trackerServer.close();
        System.out.println(userid+"/."+fileId+"/."+name);
        Integer i = userService.updateUserInfo(userid, fileId, name);
        if (i != 0) {
            return new ResponseVo(true,200,"修改成功");
        }else {
            return new ResponseVo(false,300,"修改失败");
        }
    }

    @RequestMapping("/updatePassword")
    public ResponseVo updatePassword(@RequestBody GetUser getUser){
        Integer userid = getUser.getUserid();
        String password= getUser.getPassword();
        System.out.println(userid+" "+password);
        Integer i = userService.updatePassword(userid, password);
        if(i != 0){
            return new ResponseVo(true,200,"修改成功");
        }else {
            return new ResponseVo(false,300,"修改失败");
        }

    }
}
