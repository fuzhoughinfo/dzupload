package com.ghinfo.dzupload.dao;


import com.ghinfo.dzupload.entity.SealOrderEntity;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.common.Mapper;

@Repository
@org.apache.ibatis.annotations.Mapper
public interface SealOrderEntityMapper extends Mapper<SealOrderEntity> {
}