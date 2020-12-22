package com.blog.web;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

@Controller
public class EditorController {
    @RequestMapping(value = "/uploadImg",method = RequestMethod.POST)
    public @ResponseBody Object uploadImg(@RequestParam("myFileName")MultipartFile myFileName,HttpSession session,HttpServletRequest request) throws IllegalStateException, IOException{
        String realName = "";
        if (myFileName != null) {
            String fileName = myFileName.getOriginalFilename();
            String fileNameExtension = fileName.substring(fileName.indexOf("."));

            realName = UUID.randomUUID().toString() + fileNameExtension;
            String realPath = session.getServletContext().getRealPath("/upload");
            File uploadFile = new File(realPath, realName);
            myFileName.transferTo(uploadFile);
        }

        Map<String, Object> resultMap = new HashMap<>();
        resultMap.put("url", request.getContextPath() + "/upload/" + realName);
        System.out.println(resultMap);
        return resultMap;
    }
}
