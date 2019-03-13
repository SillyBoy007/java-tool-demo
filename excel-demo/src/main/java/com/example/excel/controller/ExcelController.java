package com.example.excel.controller;

import com.example.excel.domain.UserDTO;
import com.example.excel.utils.ExcelUtil;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletResponse;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

@Controller
public class ExcelController {
    @RequestMapping("/user/export")
    public void exportExcel(HttpServletResponse response){
        ExcelUtil<UserDTO> excelUtil = new ExcelUtil<>(UserDTO.class);
        List<UserDTO> userDtos = new ArrayList<>();
        UserDTO userDto1 = new UserDTO();
        userDto1.setId("aa");
        userDto1.setPassword("wang");
        userDto1.setUsername("xia");
        userDtos.add(userDto1);
        excelUtil.exportExcelToWeb(userDtos,"用户信息表",response);
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
