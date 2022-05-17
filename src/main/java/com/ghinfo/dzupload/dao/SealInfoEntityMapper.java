package com.ghinfo.dzupload.dao;


import com.ghinfo.dzupload.entity.SealInfoEntity;
import com.ghinfo.dzupload.entity.SealInfoUnitEntity;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;
import java.util.Map;

@Repository
@org.apache.ibatis.annotations.Mapper
public interface SealInfoEntityMapper extends Mapper<SealInfoEntity> {
  //extends Mapper<SealInfoEntity>
//    List<?> getJFSealInfo();
     List<SealInfoUnitEntity> getJFSealInfo();

    List<SealInfoEntity>selectSealInfo();

    List<?>getSealFileRecord();

//    List<?>getMarkRecord();
    List<SealInfoEntity> getMarkRecord();

}