package com.ghinfo.dzupload.dao;


import com.ghinfo.dzupload.entity.SealFileRecordEntity;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
@org.apache.ibatis.annotations.Mapper
public interface SealFileRecordEntityMapper extends Mapper<SealFileRecordEntity> {

     public  void saveSealFileRecord(SealFileRecordEntity sealFileRecordEntity);
}
