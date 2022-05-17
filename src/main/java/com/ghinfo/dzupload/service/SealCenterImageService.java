package com.ghinfo.dzupload.service;


import com.ghinfo.dzupload.dao.SealCenterImageMapper;
import com.ghinfo.dzupload.entity.SealCenterImageEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SealCenterImageService {


    @Resource
    private SealCenterImageMapper SealCenterImageMapper;


    public List<SealCenterImageEntity> getCenterImage(){

        return SealCenterImageMapper.getCenterImage();
    }


}
