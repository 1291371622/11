package com.xuyan.controller;

import com.xuyan.utils.ResultEntity;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.io.IOUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;


/**
 * @author xu yan
 * @version V1.0.0
 * @projectName SSM_OA
 * @package com.xuyan.controller
 * @description
 * @date 2020/12/15 19:23
 */
@Controller
@RequestMapping(value = "/commonController")
@Slf4j
public class CommonController {

        @ResponseBody
        @RequestMapping(value = "/uploadFile")
        public ResultEntity uploadFile(MultipartFile file, HttpServletRequest request){

            //获取文件上传路径
            String uploadPath = request.getServletContext().getRealPath("upload");

            FileOutputStream ops = null;
            InputStream ips = null;
            try {
                File newFile = new File(uploadPath + File.separator + file.getOriginalFilename());
                //2.指定文件输出路径
                ops = new FileOutputStream(newFile);
                //3.获取用户上传文件的流
                ips = file.getInputStream();
                //4.IO流拷贝
                IOUtils.copy(ips,ops);

                return ResultEntity.success(newFile.getAbsolutePath());//返回文件的绝对路径
            } catch (IOException e) {
                log.error("文件上传出现异常",e);
                return ResultEntity.faild("文件上传失败");
            }finally {
                if(ips != null){
                    try {
                        ips.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
                if(ops != null){
                    try {
                        ops.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

        @RequestMapping(value = "/showPng")
        @ResponseBody
        public void showPng(String pngPath, HttpServletResponse response){

            FileInputStream ips = null;

            try {
                ips = new FileInputStream(pngPath);

                IOUtils.copy(ips,response.getOutputStream());
            } catch (FileNotFoundException e) {
                response.setStatus(404);
                log.error("文件找不到",e);
            } catch (IOException e) {
                e.printStackTrace();
            }finally {
                if(ips != null){
                    try {
                        ips.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
        }

}
