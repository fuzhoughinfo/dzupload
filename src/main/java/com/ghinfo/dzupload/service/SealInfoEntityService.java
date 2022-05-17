package com.ghinfo.dzupload.service;


import com.ghinfo.dzupload.dao.SealInfoEntityMapper;
import com.ghinfo.dzupload.entity.SealInfoEntity;
import com.ghinfo.dzupload.entity.SealInfoUnitEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;
import java.util.Map;

@Service
public class SealInfoEntityService {

    @Resource
    private SealInfoEntityMapper sealInfoEntityMapper;

//    public List<?> getJFSealInfo() {
//        return sealInfoEntityMapper.getJFSealInfo();
//    }

    public  List<SealInfoUnitEntity> getJFSealInfo() {
        return sealInfoEntityMapper.getJFSealInfo();
    }

    public List<SealInfoEntity>selectSealInfo(){
        return sealInfoEntityMapper.selectSealInfo();
    }
//    public int isinsert(SealInfoEntity sealInfoEntity){
//        return sealInfoEntityMapper.insertSelective(sealInfoEntity);
//    }

    public List<?>getSealFileRecord(){
        return sealInfoEntityMapper.getSealFileRecord();
    }

    public  List<SealInfoEntity> getMarkRecord(){
        return sealInfoEntityMapper.getMarkRecord();
    };
}
