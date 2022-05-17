package com.ghinfo.dzupload.dao;


import com.ghinfo.dzupload.entity.SealFileEntity;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface SealFileEntityMapper extends Mapper<SealFileEntity> {


   List<?> getSealinfoFile();
}