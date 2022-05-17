package com.ghinfo.dzupload;

import org.apache.commons.lang.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class MapTest {


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

    public static void main(String[] args) {
//        String fileName =fileTypeConveter("20210928135500133883_授权委托书.jpg");
//
//        System.out.println(fileName);


       String a =null;
       String s= sealTypeConveter(sealType,a);
        System.out.println(s);
    }



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
            if(SealSampleName==null){
                return sealType.get("其它");
            }
            if (StringUtils.isEmpty(SealSampleName)||StringUtils.isBlank(SealSampleName) || SealSampleName.length() < 0) {

                return sealType.get("其它");
            }

            return sealType.get(SealSampleName);


//        }
//        return null;

    }



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

}
