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


//       String a =null;
//       String s= sealTypeConveter(sealType,a);
//        System.out.println(s);
        String a =convertTypeNameMap(dezhousealSpec,"40mm","合同专用章");

        System.out.println(a);
    }



    //转换印章名称
    public static String  convertTypeNameMap(Map<String,String> map,String sealSize,String SealSampleName){



        for (Map.Entry<String,String> entry : map.entrySet()) {

            String []sealTypeName =entry.getValue().split(",");
//            System.out.println(sealTypeName[0]+" :"+sealTypeName[1]);
            if(sealSize.equals(sealTypeName[1])){
                String Size=sealSize.substring(0,sealSize.length() - 2);
                String typeName =Size+SealSampleName;
//                System.out.println(typeName);
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
                if("40合同专用章".equals(typeName)){
                    return "40合同专用章";
                }

                if(typeName.equals(sealTypeName[0])){
                    return sealTypeName[0];
                }
            }

        }


        return null;
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
