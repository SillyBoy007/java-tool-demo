package com.example.excel.controller;

import com.alibaba.fastjson.JSONObject;
import com.example.excel.domain.FollowBaseVO;
import com.example.excel.domain.UserDTO;
import com.example.excel.utils.ExcelUtil;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ExcelController {
    @RequestMapping("/user/export")
    public void exportExcel(HttpServletResponse response){
        ExcelUtil<FollowBaseVO> excelUtil = new ExcelUtil<>(FollowBaseVO.class);

        String string = ResolveJsonFileToString("friend.json");
        List<FollowBaseVO> list = JSONObject.parseArray(string,FollowBaseVO.class);
        excelUtil.exportExcelToWeb(list,"用户信息表",response);
    }

    /**
     *  通过文件名获取获取json格式字符串，
     * @param filename 文件存放路径与配置文件路径规范一致
     * @return ResolveJsonFileToString
     * @throws
     */
    public static String ResolveJsonFileToString(String filename){

        BufferedReader br = null;
        String result = null;
        try {

//            br = new BufferedReader(new InputStreamReader(getInputStream(path)));
            br = new BufferedReader(new InputStreamReader(getResFileStream(filename),"UTF-8"));
            StringBuffer message=new StringBuffer();
            String line = null;
            while((line = br.readLine()) != null) {
                message.append(line);
            }
            if (br != null) {
                br.close();
            }
            String defaultString=message.toString();
            result=defaultString.replace("\r\n", "").replaceAll(" +", "");
          //  log.info("result={}",result);

        } catch (IOException e) {
            try {
                ClassLoader classloader = Thread.currentThread().getContextClassLoader();
                InputStream in = classloader.getResourceAsStream(filename);
                br = new BufferedReader(new InputStreamReader(in,"UTF-8"));
                StringBuffer message=new StringBuffer();
                String line = null;
                while((line = br.readLine()) != null) {
                    message.append(line);
                }
                if (br != null) {
                    br.close();
                }
                if (in != null){
                    in.close();
                }
                String defaultString=message.toString();
                result=defaultString.replace("\r\n", "").replaceAll(" +", "");
               // log.debug("for jar result={}",result);
            }catch (Exception e1){
                e1.printStackTrace();
            }

        }

        return result;
    }


    /**
     *  通过文件名获取classpath路径下的文件流
     * @param
     * @return
     * @throws
     */
    private static FileInputStream getResFileStream(String filename) throws FileNotFoundException {
        FileInputStream fin = null;
        File file = getResFile(filename);
        fin = new FileInputStream(file);
        return fin;
    }


    private static File getResFile(String filename) throws FileNotFoundException {
        File file = new File(filename);
        if (!file.exists()) { // 如果同级目录没有，则去config下面找
            file = new File("config/"+filename);
        }
        Resource resource = new FileSystemResource(file);
        if (!resource.exists()) { //config目录下还是找不到，那就直接用classpath下的
            file = ResourceUtils.getFile("classpath:"+filename);
        }
        return file;
    }

    @RequestMapping("/user/import")
    public void importExcel(@RequestParam("file") MultipartFile file){
        try {
            InputStream inputStream = file.getInputStream();
            ExcelUtil<UserDTO> excelUtil = new ExcelUtil<>(UserDTO.class);
            List<UserDTO> userDtos = excelUtil.importExcel(null, inputStream);
            System.out.println(userDtos.size());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
