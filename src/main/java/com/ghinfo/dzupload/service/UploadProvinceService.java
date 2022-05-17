package com.ghinfo.dzupload.service;


import com.ghinfo.dzupload.dao.UploadProvinceMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service
public class UploadProvinceService {

    @Resource
    private UploadProvinceMapper UploadProvinceMapper;

    //德州测试地址
    public static String dezhouProvinceTestUrl= "http://222.133.49.90:8092/api/";

    //德州正式地址
    public static String dezhouProvinceUrl= "http://222.133.49.90:8092/api/";

    /**
     * 获取未同步印章状态的印章
     * @return
     */
    public boolean getSealInfo(){




      return true;
    }






}
