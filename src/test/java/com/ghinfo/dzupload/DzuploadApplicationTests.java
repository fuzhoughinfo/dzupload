package com.ghinfo.dzupload;

import cn.hutool.json.JSONObject;
import com.ghinfo.dzupload.entity.SealFileEntity;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import tk.mybatis.mapper.entity.Example;

@SpringBootTest
class DzuploadApplicationTests {

    @Test
    void contextLoads() {
    }






//      for (int i = 0; i < jfDocSealArray.size(); i++) {
//        try {
//            //
//            JSONObject sealObj = jfDocSeallist.get(i);
//            Example sealFileExample = new Example(SealFileEntity.class);
//            sealFileExample.createCriteria().andLike("FilePath",);
//
//            String AddDocPath = path + sealfile.getFilepath();
////                byte[] data = image2Bytes(AddDocPath);//印章图像信息
////                if (data != null && data.length > 0) {
////                    String sData = Base64.encode(data);//得到base64编码的string字符串
//            AddDocPath =AddDocPath.replaceAll("\\\\","&");
//            String[] str =AddDocPath.split("&");
//            String unitName = str[str.length-3];
//            System.out.println("从SealFile获取到的unitName:"+unitName);
//
////                  Example sealFileExample = new Example(SealFileEntity.class);
////                  sealFileExample.createCriteria().orGreaterThan("fileid","20180316190109975291");
//
//
////                }
//
//
//        } catch (Exception e) {
//            e.printStackTrace();
////                LOG.info("上传附件fail:fileID: "+yzxx.getFileid()+";"+e);
////                SealFileEntity sealFileEntity = fileEntityMapper.selectByPrimaryKey(yzxx.getFileid());
////                sealFileEntity.setSyncProvince("5");
////
////                fileEntityMapper.updateByPrimaryKey(sealFileEntity);
//        }
//
//    }
}
