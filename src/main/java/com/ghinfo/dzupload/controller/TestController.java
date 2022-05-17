package com.ghinfo.dzupload.controller;




import cn.hutool.core.codec.Base64;
import com.ghinfo.dzupload.entity.SealCenterImageEntity;
import com.ghinfo.dzupload.entity.SealInfoEntity;
import com.ghinfo.dzupload.service.SealCenterImageService;
import com.ghinfo.dzupload.service.SealInfoEntityService;
import com.ghinfo.dzupload.utils.ActiveXComponentUtils;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.DispatchProxy;
import com.jacob.com.LibraryLoader;
import com.jacob.com.Variant;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import javax.imageio.stream.FileImageInputStream;
import javax.imageio.stream.FileImageOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.List;

@RestController
public class TestController {

    @Resource
    private SealCenterImageService SealCenterImageService;


    @Resource
    private SealInfoEntityService sealInfoEntityService;


    @RequestMapping("/hello")
    public List<SealCenterImageEntity> hello() {
        return SealCenterImageService.getCenterImage();
    }


    //测试用
    @RequestMapping("/testinsert")
    public String testinsert() {
        try {
            String path = "F:\\jacob\\jacob-1.18-x64.dll";//本地
//    String path = "D:\\jacob\\jacob-1.18-x64.dll";//正式
            System.setProperty(LibraryLoader.JACOB_DLL_PATH, path);
            LibraryLoader.loadJacobLibrary();
            List<SealInfoEntity> markRecordlist = sealInfoEntityService.getMarkRecord();

            for (SealInfoEntity record : markRecordlist) {
                //得到印章图像信息
                byte[] data = record.getSealimagedata();
                //转换为Base64字符串
                String sData = Base64.encode(data);
//                String sData = Base64.encodeBase64String(data);
                int sDataSize = sData.length();
                ActiveXComponent activex = ActiveXComponentUtils.getInstance();
                Dispatch sControl = activex.getObject();
                DispatchProxy sCon = new DispatchProxy(sControl);
                Dispatch sc = sCon.toDispatch();
                Variant result = callActiveX(sData, sDataSize, "ImageBase64String2BMPBase64String", sControl);
                System.out.println("result:"+result);


            }
        } catch (Exception e) {
            e.printStackTrace();
        }
//        	String sealId = "3201020000000" ;
//			SealInfoEntity sealInfoEntity = new SealInfoEntity();
//			sealInfoEntity.setSealid(sealId);
//            int s=sealInfoEntityService.isinsert(sealInfoEntity);
//            if(s==1){
//                return "添加成功";
//            }else{
//                return "添加失败";
//            }

//        List<?> list = sealInfoEntityService.getJFSealInfo();
//        List<SealInfoEntity> list = sealInfoEntityService.selectSealInfo();
////        for (Object o :list){
////
////            System.out.println(o);
////        }
//        for (SealInfoEntity seal:list){
//            System.out.println(seal.getSealid());
//        }

        return null;

    }



    private byte[] image2byte(String path){
        byte[] data = null;
        FileImageInputStream input = null;
        try {
            input = new FileImageInputStream(new File(path));
            ByteArrayOutputStream output = new ByteArrayOutputStream();
            byte[] buf = new byte[1024];
            int numBytesRead = 0;
            while ((numBytesRead = input.read(buf)) != -1) {
                output.write(buf, 0, numBytesRead);
            }
            data = output.toByteArray();
            output.close();
            input.close();
        }
        catch (FileNotFoundException ex1) {
            ex1.printStackTrace();
        }
        catch (IOException ex1) {
            ex1.printStackTrace();
        }
        return data;
    }


    private void byte2image(byte[] data,String path){
        if(data.length<3||path.equals("")) return;
        try{
            FileImageOutputStream imageOutput = new FileImageOutputStream(new File(path));
            imageOutput.write(data, 0, data.length);
            imageOutput.close();
            System.out.println("Make Picture success,Please find image in " + path);
        } catch(Exception ex) {
            System.out.println("Exception: " + ex);
            ex.printStackTrace();
        }
    }





//    private Variant callActiveX(String method, Object... attributes) throws Exception {
//        Dispatch dispatch = createActiveXDispatch();
//        try {
//            Variant variant = Dispatch.call(dispatch, method, attributes);
//            return variant;
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            dispatch.safeRelease();
//        }
//    }
  private Variant callActiveX(String sData, int size, String method, Dispatch dispatch) throws Exception {
    Variant vData = null;
    Variant vSize = null;
    try {
        vData = new Variant(sData);
        vSize = new Variant(size);
        Variant variant = Dispatch.call(dispatch, method, vData,vSize);
        return variant;
    } catch (Exception e) {
        throw e;
    } finally {
        if(vData != null) vData.safeRelease();
        if(vSize != null) vSize.safeRelease();
    }
  }

    private Dispatch createActiveXDispatch() {
//		ActiveXComponent activex = new ActiveXComponent("CLSID:38EB2860-D8BB-489A-BD58-001EEF85F337");	//SMISServices.ocx
        ActiveXComponent activex = new ActiveXComponent("CLSID:1037E3F8-F546-4DC1-A03B-393BE550AE0D");	//SMISImageHelper.ocx

        Dispatch dispath = activex.getObject();
        return dispath;
    }



    //    private Variant callActiveX(String method, Object... attributes) throws Exception {
//        Dispatch dispatch = createActiveXDispatch();
//        try {
//            Variant variant = Dispatch.call(dispatch, method, attributes);
//            return variant;
//        } catch (Exception e) {
//            throw e;
//        } finally {
//            dispatch.safeRelease();
//        }
//    }
//    private Dispatch createActiveXDispatch() {
////		ActiveXComponent activex = new ActiveXComponent("CLSID:38EB2860-D8BB-489A-BD58-001EEF85F337");	//SMISServices.ocx
//        ActiveXComponent activex = ActiveXComponentUtils.getInstance();
//        Dispatch dispath = activex.getObject();
//        return dispath;
//    }
}
