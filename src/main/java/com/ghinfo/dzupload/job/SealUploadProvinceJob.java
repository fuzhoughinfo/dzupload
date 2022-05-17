package com.ghinfo.dzupload.job;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ghinfo.dzupload.dao.*;
import com.ghinfo.dzupload.entity.*;
import com.ghinfo.dzupload.service.SealFileEntityService;
import com.ghinfo.dzupload.service.SealInfoEntityService;
import com.ghinfo.dzupload.service.UploadProvinceService;
import com.ghinfo.dzupload.utils.ActiveXComponentUtils;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.DispatchProxy;
import com.jacob.com.LibraryLoader;
import com.jacob.com.Variant;
import org.apache.catalina.valves.HealthCheckValve;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import sun.misc.BASE64Encoder;
import tk.mybatis.mapper.entity.Example;

import javax.activation.FileTypeMap;
import javax.annotation.Resource;
import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Component
public class SealUploadProvinceJob {
    private static final Logger LOG = LoggerFactory.getLogger(SealUploadProvinceJob.class);

    /**
     * 正式地址
     */
    private String HeadUrl="http://222.133.1.102:8089/api/";


    private String GetSignetIDUrl= HeadUrl+"ImportSignetData/GetSignetID";

    private String AddSignetUrl=HeadUrl+"ImportSignetData/AddSignet";

    private String AddSignetFilesUrl=HeadUrl+"ImportSignetData/AddSignetFiles";

    private String UpdateMarkUrl=HeadUrl+"ImportSignetData/UpdateMark";

    private String UpdateSignetUrl=HeadUrl+"ImportSignetData/UpdateSignet";

//    private String GetSignetIDUrl="http://222.133.49.90:8092/api/ImportSignetData/GetSignetID";
//
//
//    private String AddSignetUrl="http://222.133.49.90:8092/api/ImportSignetData/AddSignet";
//
//    private String AddSignetFilesUrl="http://222.133.49.90:8092/api/ImportSignetData/AddSignetFiles";
//
//    private String UpdateMarkUrl="http://222.133.49.90:8092/api/ImportSignetData/UpdateMark";
//
//    private String UpdateSignetUrl="http://222.133.49.90:8092/api/ImportSignetData/UpdateSignet";


    static {
        String libFile = System.getProperty("os.arch").equals("amd64") ? "jacob-1.18-x64.dll" : "jacob-1.18-x86.dll";
////      String path = HistoryController.class.getClassLoader().getResource(libFile).getPath();
        String path = "F:\\jacob\\jacob-1.18-x64.dll";//本地
//    String path = "D:\\jacob\\jacob-1.18-x64.dll";//正式
        System.setProperty(LibraryLoader.JACOB_DLL_PATH, path);
        LibraryLoader.loadJacobLibrary();
    }



    @Resource
    private SealInfoEntityMapper sealInfoEntityMapper;

    @Resource
    private UploadProvinceService uploadProvinceService;

    @Resource
    private SealMKUnitEntityMapper sealMKUnitEntityMapper;

    @Resource
    private SealInfoEntityService sealInfoEntityService;

    @Resource
    private SealFileEntityService sealFileEntityService;

    @Resource
    private SealFileEntityMapper sealFileEntityMapper;

    @Resource
    private SealUnitEntityMapper sealUnitEntityMapper;

    @Resource
    private SealFileRecordEntityMapper sealFileRecordEntityMapper;



        @Scheduled(cron = "*/5 * * * * ?")
//        @Scheduled(cron = "0 13 10 * * ?")
        public void execute() {
            LOG.info("开始上传印章");
            List<SealInfoUnitEntity> jfSeallist = sealInfoEntityService.getJFSealInfo();

            List<SealMKUnitEntity> sealMKList = sealMKUnitEntityMapper.selectAll();

            //上传德州省厅
            try {
                sendSealProvince(jfSeallist,sealMKList);
            } catch (Exception e) {
                LOG.error("印章数据回推给备案系统",e);
            }
//
//            LOG.info("开始上传印章备案材料");
////            备案材料查询顺序 连表查询所有的印章，根据返回单位名称到file表中去查询相应的备案材料
////
//            List<?> jfDocSeallist= sealInfoEntityService.getSealFileRecord();
//            LOG.info("上传之前未上传备案文件印章总数:"+jfDocSeallist.size());
//            sendDocProvince(jfDocSeallist);



//            LOG.info("开始印章印模上传");
//            List<SealInfoEntity> markRecordlist =sealInfoEntityService.getMarkRecord();
//
//            LOG.info("获取到的印模个数"+markRecordlist.size());
//
//            sendMarkProvince(markRecordlist);




//            LOG.info("开始更新印章数据回推给备案系统");
//            List<SealInfoUnitEntity> updatejfSeallist = sealInfoEntityService.getJFSealInfo();
//
//            List<SealMKUnitEntity> updatesealMKList = sealMKUnitEntityMapper.selectAll();
//
//            //更新印章信息上传德州省厅
//            try {
//                sendUpdateSealProvince(updatejfSeallist,updatesealMKList);
//            } catch (Exception e) {
//                LOG.error("印章数据回推给备案系统",e);
//            }.andEqualTo("fileid","20180425181206061241").andEqualTo("fileid","20180425181206061241")

//            LOG.info("开始更新本地备案文件到数据库");
//            Example sealFileExample = new Example(SealFileEntity.class);
//            sealFileExample.createCriteria().andGreaterThanOrEqualTo("fileid","20190606171309085150").andIsNull("syncDb");
////
////            .andEqualTo("fileid","20190606171309070422").andIsNull("syncDb")
//            List<SealFileEntity> fileRecordlist =sealFileEntityMapper.selectByExample(sealFileExample);
//            try {
//                updateDocToDB(fileRecordlist);
//            } catch (Exception e) {
//                LOG.error("印章数据回推给备案系统",e);
//            }


        }


    //德州接口返回的备案文件类型(选用)
    private static Map<String,String> baFileType =new HashMap<>();
    static {
        baFileType.put("营业执照原件复印件","01");
        baFileType.put("法人登记证书原件复印件","02");
        baFileType.put("法人身份证复印件","03");
        baFileType.put("单位介绍信或委托书","04");
        baFileType.put("上级主管机构介绍信","05");
        baFileType.put("登报告示原件","06");
        baFileType.put("现场取像","07");
        baFileType.put("经办人原件复印件","08");
        baFileType.put("成立批复文件(红头文件)复印件","09");
        baFileType.put("机构代码证原件复印件","10");
        baFileType.put("其他","11");


    }




    //德州开发印章规格excel

    private static Map<String,String> dezhousealSpec =new HashMap<>();
    static {

        dezhousealSpec.put("01","4030发票专用章,30x40mm");
        dezhousealSpec.put("02","40单位专用章,40mm");
        dezhousealSpec.put("03","38x38财务专用章,38mm");
        dezhousealSpec.put("04","30x30财务专用章,30mm");
        dezhousealSpec.put("05","42合同章,42mm");
        dezhousealSpec.put("06","50X35财务专用章(1),50x35mm");
        dezhousealSpec.put("07","50X35中英公章,50x35mm");
        dezhousealSpec.put("08","双圈中英文章,40mm");
        dezhousealSpec.put("09","45X45党章,45mm");
        dezhousealSpec.put("10","20三字法人章,20mm");
        dezhousealSpec.put("11","20二字法人章,20mm");
        dezhousealSpec.put("12","50X35报关专用章,35x50mm");
        dezhousealSpec.put("13","50X35出境旅游专用章,35x50mm");
        dezhousealSpec.put("14","18二字法人章,18mm");
        dezhousealSpec.put("15","18三字法人章,18mm");
        dezhousealSpec.put("16","医学证明专用章,32mm");
        dezhousealSpec.put("17","补发医学证明专用章,32mm");
        dezhousealSpec.put("18","诊断证明书专用章,38mm");
        dezhousealSpec.put("19","40合同章,40mm");
        dezhousealSpec.put("20","40出境旅游专用章,40mm");
        dezhousealSpec.put("21","32专用章,32mm");
        dezhousealSpec.put("22","铜单位公章,40mm");
        dezhousealSpec.put("23","光敏公章,40mm");
        dezhousealSpec.put("24","38公章,38mm");
        dezhousealSpec.put("25","40中英文部门专用章,40mm");
        dezhousealSpec.put("26","38合同章,38mm");
        dezhousealSpec.put("27","35x50中英文部门章,35x50mm");
        dezhousealSpec.put("28","38党徽章,38mm");
        dezhousealSpec.put("29","38部门章,38mm");
        dezhousealSpec.put("30","38园章,38mm");
        dezhousealSpec.put("31","40业务专用章,40mm");
        dezhousealSpec.put("32","42公章,42mm");
        dezhousealSpec.put("33","40双排教育支付章,40mm");
        dezhousealSpec.put("34","30专用章,30mm");
        dezhousealSpec.put("35","50X35报检专用章,35x50mm");
        dezhousealSpec.put("36","42单位专用章,42mm");
        dezhousealSpec.put("37","医院部门专用章,38mm");
        dezhousealSpec.put("38","45合同专用章,45mm");
        dezhousealSpec.put("39","42业务专用章,42mm");
        dezhousealSpec.put("40","50X35合同专用,35x50mm");
        dezhousealSpec.put("41","50x33中英文公章,50x33mm");
        dezhousealSpec.put("42","50x33中英文财务,33x50mm");
        dezhousealSpec.put("43","40x30质量检验专用章,30x40mm");
        dezhousealSpec.put("44","18四字法人章,18mm");
        dezhousealSpec.put("45","45单位专用章,45mm");
        dezhousealSpec.put("46","38中英文双圈,38mm");
        dezhousealSpec.put("47","方章,47x18mm");
        dezhousealSpec.put("48","20医学名人章,20mm");
        dezhousealSpec.put("49","45x31专用章,45x31");
        dezhousealSpec.put("50","38行政专用章,38mm");
        dezhousealSpec.put("51","40x30专用章,40x30mm");


        dezhousealSpec.put("52","44国徽专用章,44mm");
        dezhousealSpec.put("53","50X35财务专用章,35x50mm");
        dezhousealSpec.put("54","35业务专用章,35mm");
        dezhousealSpec.put("55","30专用章,30mm");
        dezhousealSpec.put("56","42党章,42mm");
        dezhousealSpec.put("57","35专用章,35mm");
        dezhousealSpec.put("58","36x24签证专用章,24x36mm");
        dezhousealSpec.put("59","青年团分校委员公章,40mm");
        dezhousealSpec.put("60","住院诊断专用章,40mm");
        dezhousealSpec.put("61","委员国徽专用章,45mm");
        dezhousealSpec.put("62","军人保障办公室章,45mm");

        dezhousealSpec.put("63","40考试专用章,40mm");
        dezhousealSpec.put("64","40双圈工会委员公章,40mm");
        dezhousealSpec.put("65","40财务专用章,40mm");

//        dezhousealSpec.put("65","40x40财务专用章,40mm");
        dezhousealSpec.put("66","40党徽章,40mm");
        dezhousealSpec.put("67","42党章,42mm");
        dezhousealSpec.put("68","50x35专用章,50x35mm");
        dezhousealSpec.put("69","38双圈工会委员公章,38x38mm");
        dezhousealSpec.put("70","40单位专用章,40mm");
        dezhousealSpec.put("71","38财务专用章,38mm");
        dezhousealSpec.put("72","42合同专用章,42mm");
        dezhousealSpec.put("73","20法人章,20mm");

        dezhousealSpec.put("74","40行政专用章,40mm");
        dezhousealSpec.put("75","42双圈工会委员公章,42mm");
        dezhousealSpec.put("76","人民解放军部队专业章,45mm");
        dezhousealSpec.put("77","中国共青团专用章,38mm");
        dezhousealSpec.put("78","45专业章,45mm");
        dezhousealSpec.put("79","25园业务专用,25mm");
        dezhousealSpec.put("80","24业务专用章,24mm");

        dezhousealSpec.put("81","4030财务专用章,30x40mm");




    }






    //德州接口返回的印章类型(选用)
    private static Map<String,String> dzsealType =new HashMap<>();
    static {
        dzsealType.put("01","单位名称章");
        dzsealType.put("02","财务专用章");
        dzsealType.put("03","发票专用章");
        dzsealType.put("04","合同专用章");
        dzsealType.put("05","法定代表人名章");
        dzsealType.put("06","钢印单位印章");
        dzsealType.put("07","光敏公章");
        dzsealType.put("08","铜章");
        dzsealType.put("09","钢印");
        dzsealType.put("99","其他");

    }




    private static Map<String,String> sealType =new HashMap<>();
    static {
        sealType.put("单位名称章","01");
        sealType.put("财务专用章","02");
        sealType.put("发票专用章","03");
        sealType.put("合同专用章","04");
        sealType.put("法定代表人名章","05");
        sealType.put("企业各类专用章","06");
        sealType.put("报关、报检专用章","07");
        sealType.put("独立法人企业下属各部门专用章","08");
        sealType.put("企业刻制项目部章","09");
        sealType.put("内资企业刻制中外文印章","10");
        sealType.put("中外合资（合作）、外商独资章","11");
        sealType.put("董事会、监事会公章","12");
        sealType.put("党组织、共产主义青年团章","13");
        sealType.put("工会章","14");
        sealType.put("驻津代表处章","15");
        sealType.put("清算组章","16");
        sealType.put("现金收讫章","17");
        sealType.put("现金付讫章","18");
        sealType.put("转讫章","19");
        sealType.put("行政许可事项决定书复印件","20");
        sealType.put("其它","99");

    }


    private static Map<String,String> sealShape =new HashMap<>();
    static {
        sealShape.put("01","圆形");
        sealShape.put("02","椭圆形");
        sealShape.put("03","长方形");
        sealShape.put("04","正方形");
        sealShape.put("05","菱形");
        sealShape.put("06","其他");

    }

    private static Map<String,String> sealState =new HashMap<>();
    static {
        sealState.put("0","已登记");
        sealState.put("1","待制作");
        sealState.put("2","已承接");
        sealState.put("3","已制作");
        sealState.put("4","已备案");
        sealState.put("5","已报废");
        sealState.put("6","已缴销");
        sealState.put("7","已挂失");

        sealState.put("8","已退回");
        sealState.put("9","已录入");
        sealState.put("C","待核验");
        sealState.put("D","已删除");
        sealState.put("R","已撤销");
    }


    private static Map<String,String> sealSpec =new HashMap<>();
    static {
        sealSpec.put("40公章","01");
        sealSpec.put("42公章","01");
        sealSpec.put("42党徽章","01");
        sealSpec.put("40党徽章","01");
        sealSpec.put("40工会章","01");
        sealSpec.put("42工会章","01");

        sealSpec.put("38单位公章","01");
        sealSpec.put("40中英文单位章","01");
        sealSpec.put("45-30中英文公章","01");
        sealSpec.put("50-35中英文公章","01");
        sealSpec.put("38无后段","01");
        sealSpec.put("38个体章","01");
        sealSpec.put("30财务章","02");
        sealSpec.put("中英文财务章","02");
        sealSpec.put("38财务章","02");
        sealSpec.put("25财务章","02");
        sealSpec.put("20X30财务章","02");
        sealSpec.put("35财务","02");
        sealSpec.put("35个体财务","02");



        sealSpec.put("40X30发票章","03");
//        sealSpec.put("40中英文单位章","03");
//        sealSpec.put("45-30中英文公章","04");
        sealSpec.put("38合同章","04");
        sealSpec.put("40合同章","04");
        sealSpec.put("50合同章","04");
        sealSpec.put("38个体合同章","04");
        sealSpec.put("38中英文","04");
        sealSpec.put("58大合同","04");
        sealSpec.put("20法人章","05");
        sealSpec.put("18法人章","05");
        sealSpec.put("40X30报检专用章","07");
//        sealSpec.put("35个体财务","07");


        sealSpec.put("30部门章","08");
        sealSpec.put("38部门章","08");
        sealSpec.put("38项目部","09");
        sealSpec.put("40中英文公章","10");
        sealSpec.put("38中英文合同章","10");
        sealSpec.put("38合同章","11");
        sealSpec.put("38中英文合同章","11");
        sealSpec.put("40中英文公章","11");
        sealSpec.put("40董事会","12");


        sealSpec.put("42董事会","12");
        sealSpec.put("40共青团章","13");
        sealSpec.put("42共青团章","13");
        sealSpec.put("40党徽章","13");
        sealSpec.put("42党徽章","13");
        sealSpec.put("40工会","14");
        sealSpec.put("42工会","14");
        sealSpec.put("40驻津代表","15");
        sealSpec.put("38清算章","16");

        sealSpec.put("38清算章","16");

    }


    private static Map<String,String> otherSpec =new HashMap<>();
    static {
        otherSpec.put("01","单位名称章");
        otherSpec.put("02","财务专用章");
        otherSpec.put("03","发票专用章");
        otherSpec.put("04","合同专用章");
        otherSpec.put("07","报关、报检专用章");
        otherSpec.put("08","独立法人企业下属各部门专用章");
        otherSpec.put("09","企业刻制项目部章");
        otherSpec.put("10","内资企业刻制中外文印章");
        otherSpec.put("11","中外合资（合作）、外商独资章");
        otherSpec.put("12","董事会、监事会公章");

        otherSpec.put("13","党组织、共产主义青年团章");
        otherSpec.put("14","工会章");
        otherSpec.put("15","驻津代表处章");
        otherSpec.put("16","清算组章");
        otherSpec.put("17","现金收讫章");
        otherSpec.put("18","现金付讫章");
        otherSpec.put("19","转讫章");

    }




    /**
     *  获取 刻章店编号返回印章编码（唯一）
     */
    private String getsignetId(){
        Long TimeStamp = System.currentTimeMillis();
        JSONObject  jsonObject = new JSONObject();
        jsonObject.put("Timestamp",TimeStamp);
        jsonObject.put("Sign", SecureUtil.md5("TJSignet"+ TimeStamp));
        jsonObject.put("areaID","371403");
        jsonObject.put("carveID","371403000003");
        jsonObject.put("VerifyUserID","fj_guanghui");
        jsonObject.put("VerifyPsd","jianguan_gh!@#$");

        String result = HttpUtil.createPost(GetSignetIDUrl)
                .header("Content-Type", "application/json;charset=UTF-8")
                .header("Cache-Control", "no-cache")
                .header("accept", "*/*")
                .header("connection", "Keep-Alive")
                .header(Header.USER_AGENT, "Hutool http")
                .header("Content-Length", jsonObject.size()+"")
                .body(jsonObject.toString()).execute().body();
        JSONObject  object = JSONUtil.parseObj(result);
        String code = object.get("data").toString();
       return code;
    }


    /**
     *  印章数据回推给备案系统（发送请求）
     */
    private JSONObject AddSignet(JSONObject json){
        String result = HttpUtil.createPost(AddSignetUrl)
                .header("Content-Type", "application/json;charset=UTF-8")
                .header("Cache-Control", "no-cache")
                .header("accept", "*/*")
                .header("connection", "Keep-Alive")
                .header(Header.USER_AGENT, "Hutool http")
                .header("Content-Length", json.size()+"")
                .body(json.toString()).execute().body();
        JSONObject  object = JSONUtil.parseObj(result);

        return object;
    }


    /**
     *  上传印章备案材料（发送请求）
     */
    private JSONObject AddSignetFiles(JSONObject json){
        String result = HttpUtil.createPost(AddSignetFilesUrl)
                .header("Content-Type", "application/json;charset=UTF-8")
                .header("Cache-Control", "no-cache")
                .header("accept", "*/*")
                .header("connection", "Keep-Alive")
                .header(Header.USER_AGENT, "Hutool http")
                .header("Content-Length", json.size()+"")
                .body(json.toString()).execute().body();
        JSONObject  object = JSONUtil.parseObj(result);

        return object;
    }


    /**
     *  更新印章数据回推给备案系统（发送请求）
     */
    private JSONObject UpdateSignet(JSONObject json){
        String result = HttpUtil.createPost(UpdateSignetUrl)
                .header("Content-Type", "application/json;charset=UTF-8")
                .header("Cache-Control", "no-cache")
                .header("accept", "*/*")
                .header("connection", "Keep-Alive")
                .header(Header.USER_AGENT, "Hutool http")
                .header("Content-Length", json.size()+"")
                .body(json.toString()).execute().body();
        JSONObject  object = JSONUtil.parseObj(result);

        return object;
    }


    /**
     * 生成印章信息并发送省厅
     */

    private void sendSealProvince(List<SealInfoUnitEntity> jfSeallist, List<SealMKUnitEntity> sealMKList) {

        if (jfSeallist == null || jfSeallist.size() < 0) {
            LOG.info("获取的已交付印章为空");
            return;
        }

//        JSONArray jfSealArray = JSONUtil.parseArray(jfSeallist);

//        for (int i = 0; i < 1; i++) {
//        for (int i = 0; i < jfSealArray.size(); i++) {
          for(SealInfoUnitEntity sealInfoUnit: jfSeallist){
            JSONObject sendObject = new JSONObject();
            JSONObject corporationInfo = new JSONObject();
            JSONObject signetInfo = new JSONObject();
            Long TimeStamp = System.currentTimeMillis();
//            JSONObject sealObj = jfSealArray.getJSONObject(i);

//            String getsignetId =sealObj.get("SignetId").toString();
//            if (getsignetId != null && getsignetId.length() > 0) {
//                LOG.info("该印章已经上传,印章编号:"+sealObj.get("SealId").toString());
//                continue;
//            }
            if(sealInfoUnit.getOtherfileid() ==null||StringUtils.isBlank(sealInfoUnit.getOtherfileid())||StringUtils.isEmpty(sealInfoUnit.getOtherfileid())){
                LOG.info("社会信用代码为空,印章编号:"+sealInfoUnit.getSealid());
                continue;
            }

            if(sealInfoUnit.getSealimagedata() ==null||StringUtils.isBlank(sealInfoUnit.getSealimagedata().toString())||StringUtils.isEmpty(sealInfoUnit.getSealimagedata().toString())){
                LOG.info("印章图像信息为空,印章编号:"+sealInfoUnit.getSealid());
                continue;
            }
            if(sealInfoUnit.getLegalry() ==null||StringUtils.isBlank(sealInfoUnit.getLegalry())||StringUtils.isEmpty(sealInfoUnit.getLegalry())){
                LOG.info("法人姓名信息为空,印章编号:"+sealInfoUnit.getSealid());
                continue;
            }
            if(sealInfoUnit.getLegalryid() ==null||StringUtils.isBlank(sealInfoUnit.getLegalryid())||StringUtils.isEmpty(sealInfoUnit.getLegalryid())){
                LOG.info("法人证件号为空,印章编号:"+sealInfoUnit.getSealid());
                continue;
            }
            //得到印章图像信息
            byte[] data = sealInfoUnit.getSealimagedata();
            //转换为Base64字符串
            String sData = Base64.encode(data);

            int sDataSize=sData.length();
            //印章bmp数据
            ActiveXComponent activex = ActiveXComponentUtils.getInstance();
            Dispatch sControl = activex.getObject();
            DispatchProxy sCon = new DispatchProxy(sControl);
            Dispatch sc = sCon.toDispatch();
            Variant variant =null;
            try {
                variant = callActiveX(sData,sDataSize,"ImageBase64String2BMPBase64String",sControl);
                LOG.info("反射成bmp的字符串:"+variant.toString());
                if(variant.toString().length()<0){
//                    SealInfoEntity sealnorecord = sealInfoEntityMapper.selectByPrimaryKey(sealMark.getSealid());
//                    sealnorecord.setSyncimagedata("1");
////                sealrecord.setSignetId(signetId);
//                    sealInfoEntityMapper.updateByPrimaryKey(sealnorecord);
                    continue;
                }
//                   result =callActiveX("ImageBase64String2BMPBase64String", sData,sDataSize);
            } catch (Exception e) {
                e.printStackTrace();
            }

//            String sData = data.toString();

            sendObject.put("Sign",SecureUtil.md5("TJSignet"+ TimeStamp));
            sendObject.put("Timestamp", TimeStamp);
            sendObject.put("DataFrom", 0);
            sendObject.put("VerifyUserID","fj_guanghui");
            sendObject.put("VerifyPsd","jianguan_gh!@#$");

            corporationInfo.put("name", sealInfoUnit.getUnitname());
            corporationInfo.put("taxNo", sealInfoUnit.getOtherfileid());
            corporationInfo.put("bossName", sealInfoUnit.getLegalry());
            corporationInfo.put("bossIdcard", sealInfoUnit.getLegalryid());

//            signetInfo.put("cac_corp_id", sealMKList.get(0).getSealmkunitid());
            //单位编码传的是对方给的编码,众金的是371403000003

              signetInfo.put("cac_corp_id", "371403000003");

            signetInfo.put("cac_corp_name", sealMKList.get(0).getMkunitname());
            signetInfo.put("content", sealInfoUnit.getSealname());


              String Sealsamplename = sealInfoUnit.getSealsamplename().toString();
              if (Sealsamplename == null || "".equals(Sealsamplename) || StringUtils.isBlank(Sealsamplename) || StringUtils.isEmpty(Sealsamplename)) {


                  signetInfo.put("signetType", sealTypeConveter(sealType, sealInfoUnit.getSealsamplename().toString()));
                  signetInfo.put("specification", "其他");

              } else {
                  signetInfo.put("signetType", sealTypeConveter(sealType, sealInfoUnit.getSealsamplename().toString()));
                  signetInfo.put("specification", convertTypeNameMap(dezhousealSpec, sealInfoUnit.getSealsize(), sealInfoUnit.getSealsamplename()));

              }





            signetInfo.put("shell", sealShape.get(sealInfoUnit.getSealshape()));
            signetInfo.put("applicantName", sealMKList.get(0).getMklegalry());
            signetInfo.put("applicantLinkway", sealMKList.get(0).getMkunittel());
            signetInfo.put("applicantIdcard", sealMKList.get(0).getMklegalryid());



            signetInfo.put("markBase64Str", variant.toString());


            //刻章编码唯一，需要单独获取
            String SealNo = getsignetId();
            signetInfo.put("signetId", SealNo);

            signetInfo.put("sealCode", sealInfoUnit.getSealid());
            sendObject.put("corporationInfo", corporationInfo);
            sendObject.put("signetInfo", signetInfo);

            //打印发送请求json字符串
            String requests = JSONUtil.toJsonStr(sendObject);
            System.out.println("请求印章字符串:"+requests);

            JSONObject result = AddSignet(sendObject);
//            //
//
            JSONObject resultmsg = JSONUtil.parseObj(result);
//
            String resultCode = resultmsg.get("code").toString();

            if ("0".equals(resultCode)) {
                JSONObject resultData = resultmsg.getJSONObject("data");
//                JSONObject markResult = resultData.getJSONObject("markResult");
//                boolean IsSuccess = markResult.getBool("IsSuccess");
//                if (!IsSuccess) {
//                    LOG.info("德州印章发送失败,印章编号为: " + sealObj.get("SealId"));
//                    continue;
//                }
                SealInfoEntity sealrecord = sealInfoEntityMapper.selectByPrimaryKey(sealInfoUnit.getSealid());
                sealrecord.setSyncProvince("2");
                sealrecord.setSignetId(SealNo);
                sealInfoEntityMapper.updateByPrimaryKey(sealrecord);
                LOG.info("备案文件发送成功,印章编号为:" + sealInfoUnit.getSealid()+"当前未上传备案印章总数为 :"+jfSeallist.size());

            } else {

                LOG.info("德州印章发送失败,返回code码为1,印章编号为: " + sealInfoUnit.getSealid());
                SealInfoEntity sealerrrecord = sealInfoEntityMapper.selectByPrimaryKey(sealInfoUnit.getSealid());
                sealerrrecord.setSyncProvince("1");
                sealInfoEntityMapper.updateByPrimaryKey(sealerrrecord);
                continue;
            }


        }





    }

  /**
   * 将本地备案材料转换成base64更新到数据库
   */
    private void updateDocToDB(List<SealFileEntity> filelist){
       //家里电脑的路径
//        String path = "E:\\workspace\\.metadata\\.me_tcat7\\file_storage\\";
        //公司电脑德州的本地路径
//        String path = "G:\\workspace\\.metadata\\.me_tcat7\\file_storage\\";
        //公司电脑乐陵的本地路径
        String path = "F:\\workspace\\.metadata\\.me_tcat7\\file_storage\\";
        if (filelist == null || filelist.size() < 0) {
            LOG.info("获取的备案材料为空");
            return;
        }

        for(SealFileEntity file:filelist){
         try{

          String filepath =file.getFilepath().replaceAll("\\\\","&");
             String[] str =filepath.split("&");
             StringBuffer buffer = new StringBuffer();
             for (int i = 0; i < str.length; i++) {
                 buffer.append(str[i].trim().replaceAll("  +","")).append("&");
             }

             buffer.deleteCharAt(buffer.length()-1);
             String filePathNew =path+buffer.toString().replaceAll("&","\\\\");
             LOG.info("文件路径外： "+filePathNew);
             File files = new File(filePathNew);
             if (files==null||!files.exists()){
                 LOG.info("文件为空 跳过！");
                 continue;

             }
             String imageStr = fileToStr64(files);
             String filepathinfo =path+file.getFilepath();
             filepathinfo =filepathinfo.replaceAll("\\\\","&");
            String[] strs =filepathinfo.split("&");
//            String unitName = strs[strs.length-3];
             //乐陵市获取单位名称在后4位
             String unitName = strs[strs.length-4];

            Example unitExample = new Example(SealUnitEntity.class);
            unitExample.createCriteria().andEqualTo("unitname",unitName);
            SealUnitEntity unit = sealUnitEntityMapper.selectOneByExample(unitExample);

            SealFileRecordEntity fileRecord = new SealFileRecordEntity();
             fileRecord.setFileBase(imageStr);
             fileRecord.setFileId(file.getFileid());
             fileRecord.setFilePath(file.getFilepath());
             fileRecord.setFileName(file.getFilename());
             fileRecord.setSealUnitId(unit.getSealunitid());
             fileRecord.setSealUnitName(unit.getUnitname());
             sealFileRecordEntityMapper.saveSealFileRecord(fileRecord);
//             sealFileRecordEntityMapper.insertSelective(fileRecord);




             SealFileEntity updateFile = sealFileEntityMapper.selectByPrimaryKey(file.getFileid());
             updateFile.setSyncDb("2");
             sealFileEntityMapper.updateByPrimaryKey(updateFile);

        } catch (Exception e) {
            e.printStackTrace();
            LOG.info("备案文件到数据库fail:备案文件编号为:" + file.getFileid()+";"+e);
//                SealInfoEntity failrecord = sealInfoEntityMapper.selectByPrimaryKey(jfdoc.get("SealId").toString());
//                failrecord.setSyncFile("1");
//                sealInfoEntityMapper.updateByPrimaryKey(failrecord);
        }

        }

    }




    /**
     * 生成备案材料上传省厅
     */
    private void sendDocProvince(List<?> jfDocSeallist) {


        JSONArray jfDocSealArray = JSONUtil.parseArray(jfDocSeallist);
        //德州备案材料地址
//        String path = "D:\\workspace\\.metadata\\.me_tcat7\\file_storage\\";


        //192.168.1.206本地测试备案材料地址
        String path = "G:\\workspace\\.metadata\\.me_tcat7\\file_storage\\";

        for (int i = 0; i < jfDocSealArray.size(); i++) {
            JSONObject jfdoc = jfDocSealArray.getJSONObject(i);
            try {
                JSONObject sendDocObject = new JSONObject();
                Long TimeStamp = System.currentTimeMillis();
                JSONArray files = new JSONArray();

//                String getSyncFile =jfdoc.get("SyncFile").toString();
//                if (getSyncFile != null && getSyncFile.length() > 0) {
//                    LOG.info("该印章已经上传,印章编号:"+jfdoc.get("SealId").toString());
//                    continue;
//                }


//                Example sealFileExample = new Example(SealFileEntity.class);
//                String unitName = "%" + jfdoc.get("UnitName").toString() + "%";
//                sealFileExample.createCriteria().andLike("filepath", unitName);
//                List<SealFileEntity> sealfileList = sealFileEntityMapper.selectByExample(sealFileExample);

                Example sealFileRecordExample = new Example(SealFileRecordEntity.class);
                String unitName =  jfdoc.get("UnitName").toString();
                sealFileRecordExample.createCriteria().andEqualTo("sealUnitName", unitName);
                List<SealFileRecordEntity> sealfileList = sealFileRecordEntityMapper.selectByExample(sealFileRecordExample);


                if (StringUtils.isBlank(jfdoc.get("SignetId").toString())||StringUtils.isEmpty(jfdoc.get("SignetId").toString())||jfdoc.get("SignetId").toString() == null || jfdoc.get("SignetId").toString().length() < 0) {
                    LOG.info("未查询到省厅返回的唯一ID,印章编号为:" + jfdoc.get("SealId").toString());
                    continue;
                }
                if (sealfileList == null || sealfileList.size() < 0) {
                    LOG.info("获取的备案文件为空,跳过,印章编号为:"+ jfdoc.get("SealId").toString());
                    continue;
                }
                sendDocObject.put("Timestamp", TimeStamp);
                sendDocObject.put("Sign", SecureUtil.md5("TJSignet" + TimeStamp));
                sendDocObject.put("signetId", jfdoc.get("SignetId").toString());
                sendDocObject.put("VerifyUserID","fj_guanghui");
                sendDocObject.put("VerifyPsd","jianguan_gh!@#$");
                for (SealFileRecordEntity sealfilerecord : sealfileList) {
//                System.out.println(sealfile.getFilename());

                    JSONObject fileItem = new JSONObject();


//                    fileItem.put("fileType", 11);
                    //文件类型做转换
                    fileItem.put("fileType",fileTypeConveter(sealfilerecord.getFileName()));

                    fileItem.put("fileName", sealfilerecord.getFileName());

//                    String AddDocPath = path + sealfilerecord.getFilePath();
//                    byte[] data = image2Bytes(AddDocPath);//印章图像信息
//                    if (data == null || data.length < 0) {
//                        LOG.info("备案文件加密Base64为空:印章编号为:" + jfdoc.get("SealId").toString());
//                        continue;
//                    }
//                    String sData = Base64.encode(data);//得到base64编码的string字符串
                    fileItem.put("data", sealfilerecord.getFileBase());
                    fileItem.put("memo", " ");
                    fileItem.put("imageType", sealfilerecord.getFileName().substring(sealfilerecord.getFileName().length() - 3));
                    files.add(fileItem);

                }
                sendDocObject.put("files", files);

                JSONObject result = AddSignetFiles(sendDocObject);

                System.out.println("上传备案文件的参数 :"+sendDocObject.toString());

                JSONObject resultmsg = JSONUtil.parseObj(result);
                String resultCode = resultmsg.get("code").toString();




                if ("0".equals(resultCode)) {
                    LOG.info("上传备案文件成功:印章编号为:" + jfdoc.get("SealId").toString()+";");
                    SealInfoEntity sealrecord = sealInfoEntityMapper.selectByPrimaryKey(jfdoc.get("SealId").toString());
                    sealrecord.setSyncFile("2");
                    sealInfoEntityMapper.updateByPrimaryKey(sealrecord);

                }

            } catch (Exception e) {
                e.printStackTrace();
                LOG.info("上传备案文件fail:印章编号为:" + jfdoc.get("SealId").toString()+";"+e);
//                SealInfoEntity failrecord = sealInfoEntityMapper.selectByPrimaryKey(jfdoc.get("SealId").toString());
//                failrecord.setSyncFile("1");
//                sealInfoEntityMapper.updateByPrimaryKey(failrecord);
            }


        }


    }


    /**
     *
     * 补传印模
     *
     */
    private void sendMarkProvince(List<SealInfoEntity> markRecordlist){
        if (markRecordlist == null || markRecordlist.size() < 0) {
            LOG.info("获取的已上传印模为空");
            return;
        }
        LOG.info("开始获取印模"+markRecordlist.size());
//        String path = "H:\\test\\jacob-1.18-x64.dll";//本地
////    String path = "D:\\jacob\\jacob-1.18-x64.dll";//正式
//        System.setProperty(LibraryLoader.JACOB_DLL_PATH, path);
//        LibraryLoader.loadJacobLibrary();
//        JSONArray SealMarkArray = JSONUtil.parseArray(markRecordlist);

//        for (int i = 0; i < 1; i++) {
        for (SealInfoEntity sealMark :markRecordlist) {
//            JSONObject SealMarkobj = SealMarkArray.getJSONObject(i);
//            SealInfoEntity sealMark =markRecordlist.get(0);
            //刻章编码唯一，需要单独获取
//            String signetId = getsignetId();

            SealMarkEntity markObj =new SealMarkEntity();
//            JSONObject sendMarkObject = new JSONObject();
            Long TimeStamp = System.currentTimeMillis();
            LOG.info("sealMark："+sealMark);
               markObj.setTimestamp(TimeStamp);
               markObj.setSign(SecureUtil.md5("TJSignet" + TimeStamp));

            if (sealMark.getSignetId() == null || sealMark.getSignetId().length() < 0) {
                LOG.info("未查询到省厅返回的唯一ID,印章编号为:" + sealMark.getSealid().toString());
                continue;
            }

               markObj.setSignetId(sealMark.getSignetId());
               markObj.setVerifyUserID("fj_guanghui");
               markObj.setVerifyPsd("jianguan_gh!@#$");
//            sendMarkObject.put("Timestamp", TimeStamp);
//            sendMarkObject.put("Sign", SecureUtil.md5("TJSignet" + TimeStamp));
//            sendMarkObject.put("signetId", signetId);
            LOG.info("signetId："+sealMark.getSignetId());

            //得到印章图像信息
//            byte[] data =  SealMarkobj.get("SealImageData").toString().getBytes();
            byte[] data =sealMark.getSealimagedata();
            //转换为Base64字符串
//            String sData = Base64.encode(data);
            String sData = org.apache.commons.codec.binary.Base64.encodeBase64String(data);
            LOG.info("加密前的base字符串:"+sData);
            int sDataSize =sData.length();
            ActiveXComponent activex = ActiveXComponentUtils.getInstance();
            Dispatch sControl = activex.getObject();
            DispatchProxy sCon = new DispatchProxy(sControl);
            Dispatch sc = sCon.toDispatch();
            Variant variant =null;
            try {
                variant = callActiveX(sData,sDataSize,"ImageBase64String2BMPBase64String",sControl);
                LOG.info("反射成bmp的字符串:"+variant.toString());
                if(variant.toString().length()<0){
                    SealInfoEntity sealnorecord = sealInfoEntityMapper.selectByPrimaryKey(sealMark.getSealid());
                    sealnorecord.setSyncimagedata("1");
//                sealrecord.setSignetId(signetId);
                    sealInfoEntityMapper.updateByPrimaryKey(sealnorecord);
                    continue;
                }
//                   result =callActiveX("ImageBase64String2BMPBase64String", sData,sDataSize);
            } catch (Exception e) {
                e.printStackTrace();
            }
              markObj.setMarkBase64Str(variant.toString());
//            sendMarkObject.put("markBase64Str", variant);

//
            String retire =JSONUtil.toJsonStr(markObj);
//            System.out.println("准备发送印模的数据:"+retire);
//
            LOG.info("准备发送印模的数据:"+retire);
            String result = HttpUtil.createPost(UpdateMarkUrl)
                    .header("Content-Type", "application/json;charset=UTF-8")
                    .header("Cache-Control", "no-cache")
                    .header("accept", "*/*")
                    .header("connection", "Keep-Alive")
                    .header(Header.USER_AGENT, "Hutool http")
                    .header("Content-Length", retire.length()+ "")
                    .body(retire).execute().body();

            JSONObject resultmsg = JSONUtil.parseObj(result);


            String resultCode = resultmsg.get("code").toString();
            LOG.info("返回的结果码:"+resultCode);
//
//
            if ("0".equals(resultCode)) {
                SealInfoEntity sealrecord = sealInfoEntityMapper.selectByPrimaryKey(sealMark.getSealid());
                sealrecord.setSyncimagedata("2");
//                sealrecord.setSignetId(signetId);
                sealInfoEntityMapper.updateByPrimaryKey(sealrecord);

            }

        }

    }



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


    /**
     * 生成更新印章信息并发送省厅
     */

    private void sendUpdateSealProvince(List<SealInfoUnitEntity> jfSeallist, List<SealMKUnitEntity> sealMKList) {

        if (jfSeallist == null || jfSeallist.size() < 0) {
            LOG.info("获取的已交付印章为空");
            return;
        }

//        JSONArray jfSealArray = JSONUtil.parseArray(jfSeallist);

//        for (int i = 0; i < 1; i++) {
//        for (int i = 0; i < jfSealArray.size(); i++) {
        for(SealInfoUnitEntity sealInfoUnit: jfSeallist){
            JSONObject sendObject = new JSONObject();
            JSONObject corporationInfo = new JSONObject();
            JSONObject signetInfo = new JSONObject();
            Long TimeStamp = System.currentTimeMillis();
//            JSONObject sealObj = jfSealArray.getJSONObject(i);

//            String getsignetId =sealObj.get("SignetId").toString();
//            if (getsignetId != null && getsignetId.length() > 0) {
//                LOG.info("该印章已经上传,印章编号:"+sealObj.get("SealId").toString());
//                continue;
//            }
            if(sealInfoUnit.getOtherfileid() ==null||StringUtils.isBlank(sealInfoUnit.getOtherfileid())||StringUtils.isEmpty(sealInfoUnit.getOtherfileid())){
                LOG.info("社会信用代码为空,印章编号:"+sealInfoUnit.getSealid());
                return;
            }

            if(sealInfoUnit.getSealimagedata() ==null||StringUtils.isBlank(sealInfoUnit.getSealimagedata().toString())||StringUtils.isEmpty(sealInfoUnit.getSealimagedata().toString())){
                LOG.info("印章图像信息为空,印章编号:"+sealInfoUnit.getSealid());
                return;
            }
            if(sealInfoUnit.getLegalry() ==null||StringUtils.isBlank(sealInfoUnit.getLegalry())||StringUtils.isEmpty(sealInfoUnit.getLegalry())){
                LOG.info("法人姓名信息为空,印章编号:"+sealInfoUnit.getSealid());
                return;
            }
            if(sealInfoUnit.getLegalryid() ==null||StringUtils.isBlank(sealInfoUnit.getLegalryid())||StringUtils.isEmpty(sealInfoUnit.getLegalryid())){
                LOG.info("法人证件号为空,印章编号:"+sealInfoUnit.getSealid());
                return;
            }
            //得到印章图像信息
            byte[] data = sealInfoUnit.getSealimagedata();
            //转换为Base64字符串
            String sData = Base64.encode(data);

            int sDataSize=sData.length();
            //印章bmp数据
            ActiveXComponent activex = ActiveXComponentUtils.getInstance();
            Dispatch sControl = activex.getObject();
            DispatchProxy sCon = new DispatchProxy(sControl);
            Dispatch sc = sCon.toDispatch();
            Variant variant =null;
            try {
                variant = callActiveX(sData,sDataSize,"ImageBase64String2BMPBase64String",sControl);
                LOG.info("反射成bmp的字符串:"+variant.toString());
                if(variant.toString().length()<0){
//                    SealInfoEntity sealnorecord = sealInfoEntityMapper.selectByPrimaryKey(sealMark.getSealid());
//                    sealnorecord.setSyncimagedata("1");
////                sealrecord.setSignetId(signetId);
//                    sealInfoEntityMapper.updateByPrimaryKey(sealnorecord);
                    continue;
                }
//                   result =callActiveX("ImageBase64String2BMPBase64String", sData,sDataSize);
            } catch (Exception e) {
                e.printStackTrace();
            }

//            String sData = data.toString();

            sendObject.put("Sign",SecureUtil.md5("TJSignet"+ TimeStamp));
            sendObject.put("Timestamp", TimeStamp);
            sendObject.put("DataFrom", 0);
            sendObject.put("VerifyUserID","fj_guanghui");
            sendObject.put("VerifyPsd","jianguan_gh!@#$");

            corporationInfo.put("name", sealInfoUnit.getUnitname());
            corporationInfo.put("taxNo", sealInfoUnit.getOtherfileid());
            corporationInfo.put("bossName", sealInfoUnit.getLegalry());
            corporationInfo.put("bossIdcard", sealInfoUnit.getLegalryid());

            signetInfo.put("cac_corp_id", sealMKList.get(0).getSealmkunitid());
            signetInfo.put("cac_corp_name", sealMKList.get(0).getMkunitname());
            signetInfo.put("content", sealInfoUnit.getSealname());

//            signetInfo.put("signetType", sealType.get(sealObj.get("SealSampleName")));
            signetInfo.put("signetType", sealTypeConveter(sealType,sealInfoUnit.getSealsamplename()));


//            signetInfo.put("specification", sealObj.get("SealSize"));
            signetInfo.put("specification", convertTypeNameMap(dezhousealSpec,sealInfoUnit.getSealsize(),sealInfoUnit.getSealsamplename()));



            signetInfo.put("shell", sealShape.get(sealInfoUnit.getSealshape()));
            signetInfo.put("applicantName", sealMKList.get(0).getMklegalry());
            signetInfo.put("applicantLinkway", sealMKList.get(0).getMkunittel());
            signetInfo.put("applicantIdcard", sealMKList.get(0).getMklegalryid());



            signetInfo.put("markBase64Str", variant.toString());


            //刻章编码唯一，需要单独获取
            String SealNo = getsignetId();
            signetInfo.put("signetId", SealNo);


            sendObject.put("corporationInfo", corporationInfo);
            sendObject.put("signetInfo", signetInfo);

            //打印发送请求json字符串
            String requests = JSONUtil.toJsonStr(sendObject);
            System.out.println("请求印章字符串:"+requests);

            JSONObject result = UpdateSignet(sendObject);
//            //
//
            JSONObject resultmsg = JSONUtil.parseObj(result);
//
            String resultCode = resultmsg.get("code").toString();

            if ("0".equals(resultCode)) {
                JSONObject resultData = resultmsg.getJSONObject("data");
//                JSONObject markResult = resultData.getJSONObject("markResult");
//                boolean IsSuccess = markResult.getBool("IsSuccess");
//                if (!IsSuccess) {
//                    LOG.info("德州印章发送失败,印章编号为: " + sealObj.get("SealId"));
//                    continue;
//                }
                SealInfoEntity sealrecord = sealInfoEntityMapper.selectByPrimaryKey(sealInfoUnit.getSealid());
                sealrecord.setSyncProvince("2");
                sealrecord.setSignetId(SealNo);
                sealInfoEntityMapper.updateByPrimaryKey(sealrecord);

            } else {

                LOG.info("更新德州印章发送失败,返回code码为1,印章编号为: " + sealInfoUnit.getSealid());
                continue;
            }


        }




    }





    public  byte[] image2Bytes(String imgSrc) throws Exception {
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        try {
            BufferedImage bi;
            bi = ImageIO.read(new File(imgSrc));
            ImageIO.write(bi, "jpg", baos);
            byte[] bytes = baos.toByteArray();
            return bytes;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            baos.close();
        }
        return null;
    }

    //转换印章名称
    public static String  convertTypeNameMap(Map<String,String> map,String sealSize,String SealSampleName){



        for (Map.Entry<String,String> entry : map.entrySet()) {

            String []sealTypeName =entry.getValue().split(",");
//            System.out.println(sealTypeName[0]+" :"+sealTypeName[1]);
            if(sealSize.equals(sealTypeName[1])){
                String Size=sealSize.substring(0,sealSize.length() - 2);
                String typeName =Size+SealSampleName;

                if(StringUtils.isBlank(SealSampleName) ||SealSampleName.length()<0){
                    return "其他";
                }
                if("30x40发票专用章".equals(typeName)){
                    return "4030发票专用章";
                }
                if("18人名印章".equals(typeName)){
                    return "18三字法人章";
                }
                if("20人名印章".equals(typeName)){
                    return "20法人章";
                }

                if("42单位党章".equals(typeName)){
                    return "42党章";
                }
                if("30x40财务专用章".equals(typeName)){
                    return "4030财务专用章";
                }

                if(typeName.equals(sealTypeName[0])){
                    return sealTypeName[0];
                }
            }

        }


        return null;
    }


   //转换印章类型(数字)

    private static String sealTypeConveter(Map<String, String> map, String SealSampleName) {

//        for (Map.Entry<String, String> entry : map.entrySet()) {

//            System.out.println("key = " + entry.getKey() + ", value = " + entry.getValue());
            if (SealSampleName.equals("单位专用章")) {
                return sealType.get("单位名称章");
            }
            if (SealSampleName.equals("人名印章")) {
                return sealType.get("法定代表人名章");
            }
            if (SealSampleName.equals("单位党章")) {
                return sealType.get("其它");
            }

            if (StringUtils.isBlank(SealSampleName) || SealSampleName.length() < 0) {

                return sealType.get("其它");
            }
            return sealType.get(SealSampleName);

//        }
//        return null;

    }



    //转换印章类型(数字)

    private static String fileTypeConveter(String FileName) {
        if (FileName.contains("营业执照")) {
            return baFileType.get("营业执照原件复印件");
        }
        if (FileName.contains("经办人")) {
            return baFileType.get("经办人原件复印件");
        }
        if (FileName.contains("法定代表人身份证")) {
            return baFileType.get("法人身份证复印件");
        }



        if (StringUtils.isBlank(FileName) || FileName.length() < 0) {

            return baFileType.get("其他");
        }
        return baFileType.get("其他");

    }

    /**
     * 文件转换成base64字符串
     * @param file
     * @return
     */
    private  String fileToStr64(File file){
        LOG.info("开始文件转换base64！");
        InputStream in = null;
        byte [] data =null;
        try {
            in=new FileInputStream(file);
            data = new byte[in.available()];
            in.read(data);
            in.close();
        } catch (Exception e) {
            LOG.info("文件转换异常： "+e);
            return null;
        } finally {
            try {
                if (in!=null){
                    in.close();
                }

            } catch (IOException e) {
                LOG.info("文件转换关闭异常： "+e);
                return null;
            }
        }
        if (data==null){
            LOG.info("文件转换base64 为空！");
            return null;
        }
        LOG.info("文件转换base64 结束！");
        BASE64Encoder encoder = new BASE64Encoder();
        return encoder.encode(data);
    }
}
