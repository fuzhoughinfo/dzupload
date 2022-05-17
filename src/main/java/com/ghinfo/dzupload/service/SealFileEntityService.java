package com.ghinfo.dzupload.service;


import com.ghinfo.dzupload.dao.SealFileEntityMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SealFileEntityService {


    @Resource
    private SealFileEntityMapper sealFileEntityMapper;

    public List<?>getSealinfoFile(){
        return sealFileEntityMapper.getSealinfoFile();
    };



}
