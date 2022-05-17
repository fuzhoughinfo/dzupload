package com.ghinfo.dzupload.service;

import com.ghinfo.dzupload.dao.SealFileRecordEntityMapper;
import com.ghinfo.dzupload.entity.SealInfoEntity;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class SealFileRecordEntityService {
    @Resource
    private SealFileRecordEntityMapper sealFileRecordEntityMapper;


}
