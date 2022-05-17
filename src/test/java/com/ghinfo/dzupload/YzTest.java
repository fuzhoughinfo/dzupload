package com.ghinfo.dzupload;

import cn.hutool.core.codec.Base64;
import cn.hutool.crypto.SecureUtil;
import cn.hutool.http.Header;
import cn.hutool.http.HttpUtil;
import cn.hutool.json.JSONArray;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;
import com.ghinfo.dzupload.utils.ActiveXComponentUtils;
import com.jacob.activeX.ActiveXComponent;
import com.jacob.com.Dispatch;
import com.jacob.com.DispatchProxy;
import com.jacob.com.LibraryLoader;
import com.jacob.com.Variant;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import org.junit.jupiter.api.Test;
import org.junit.platform.commons.util.StringUtils;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class YzTest {

//    private static Map<String,String> dezhousealSpec =new HashMap<>();
//    static {
//
//        dezhousealSpec.put("01","4030发票专用章,30x40mm");
//        dezhousealSpec.put("02","40单位专用章,40mm");
//        dezhousealSpec.put("03","38x38财务专用章,38mm");
//        dezhousealSpec.put("04","30x30财务专用章,30mm");
//        dezhousealSpec.put("05","42合同章,42mm");
//        dezhousealSpec.put("06","50X35财务专用章(1),50x35mm");
//        dezhousealSpec.put("07","50X35中英公章,50x35mm");
//        dezhousealSpec.put("08","双圈中英文章,40mm");
//        dezhousealSpec.put("09","45X45党章,45mm");
//        dezhousealSpec.put("10","20三字法人章,20mm");
//        dezhousealSpec.put("11","20二字法人章,20mm");
//        dezhousealSpec.put("12","50X35报关专用章,35x50mm");
//        dezhousealSpec.put("13","50X35出境旅游专用章,35x50mm");
//        dezhousealSpec.put("14","18二字法人章,18mm");
//        dezhousealSpec.put("15","18三字法人章,18mm");
//        dezhousealSpec.put("16","医学证明专用章,32mm");
//        dezhousealSpec.put("17","补发医学证明专用章,32mm");
//        dezhousealSpec.put("18","诊断证明书专用章,38mm");
//        dezhousealSpec.put("19","40合同章,40mm");
//        dezhousealSpec.put("20","40出境旅游专用章,40mm");
//        dezhousealSpec.put("21","32专用章,32mm");
//        dezhousealSpec.put("22","铜单位公章,40mm");
//        dezhousealSpec.put("23","光敏公章,40mm");
//        dezhousealSpec.put("24","38公章,38mm");
//        dezhousealSpec.put("25","40中英文部门专用章,40mm");
//        dezhousealSpec.put("26","38合同章,38mm");
//        dezhousealSpec.put("27","35x50中英文部门章,35x50mm");
//        dezhousealSpec.put("28","38党徽章,38mm");
//        dezhousealSpec.put("29","38部门章,38mm");
//        dezhousealSpec.put("30","38园章,38mm");
//        dezhousealSpec.put("31","40业务专用章,40mm");
//        dezhousealSpec.put("32","42公章,42mm");
//        dezhousealSpec.put("33","40双排教育支付章,40mm");
//        dezhousealSpec.put("34","30专用章,30mm");
//        dezhousealSpec.put("35","50X35报检专用章,35x50mm");
//        dezhousealSpec.put("36","42单位专用章,42mm");
//        dezhousealSpec.put("37","医院部门专用章,38mm");
//        dezhousealSpec.put("38","45合同专用章,45mm");
//        dezhousealSpec.put("39","42业务专用章,42mm");
//        dezhousealSpec.put("40","50X35合同专用,35x50mm");
//        dezhousealSpec.put("41","50x33中英文公章,50x33mm");
//        dezhousealSpec.put("42","50x33中英文财务,33x50mm");
//        dezhousealSpec.put("43","40x30质量检验专用章,30x40mm");
//        dezhousealSpec.put("44","18四字法人章,18mm");
//        dezhousealSpec.put("45","45单位专用章,45mm");
//        dezhousealSpec.put("46","38中英文双圈,38mm");
//        dezhousealSpec.put("47","方章,47x18mm");
//        dezhousealSpec.put("48","20医学名人章,20mm");
//        dezhousealSpec.put("49","45x31专用章,45x31");
//        dezhousealSpec.put("50","38行政专用章,38mm");
//        dezhousealSpec.put("51","40x30专用章,40x30mm");
//
//
//        dezhousealSpec.put("52","44国徽专用章,44mm");
//        dezhousealSpec.put("53","50X35财务专用章,35x50mm");
//        dezhousealSpec.put("54","35业务专用章,35mm");
//        dezhousealSpec.put("55","30专用章,30mm");
//        dezhousealSpec.put("56","42党章,42mm");
//        dezhousealSpec.put("57","35专用章,35mm");
//        dezhousealSpec.put("58","36x24签证专用章,24x36mm");
//        dezhousealSpec.put("59","青年团分校委员公章,40mm");
//        dezhousealSpec.put("60","住院诊断专用章,40mm");
//        dezhousealSpec.put("61","委员国徽专用章,45mm");
//        dezhousealSpec.put("62","军人保障办公室章,45mm");
//
//        dezhousealSpec.put("63","40考试专用章,40mm");
//        dezhousealSpec.put("64","40双圈工会委员公章,40mm");
//        dezhousealSpec.put("65","40财务专用章,40mm");
//
////        dezhousealSpec.put("65","40x40财务专用章,40mm");
//        dezhousealSpec.put("66","40党徽章,40mm");
//        dezhousealSpec.put("67","42党章,42mm");
//        dezhousealSpec.put("68","50x35专用章,50x35mm");
//        dezhousealSpec.put("69","38双圈工会委员公章,38x38mm");
//        dezhousealSpec.put("70","40单位专用章,40mm");
//        dezhousealSpec.put("71","38财务专用章,38mm");
//        dezhousealSpec.put("72","42合同专用章,42mm");
//        dezhousealSpec.put("73","20法人章,20mm");
//
//        dezhousealSpec.put("74","40行政专用章,40mm");
//        dezhousealSpec.put("75","42双圈工会委员公章,42mm");
//        dezhousealSpec.put("76","人民解放军部队专业章,45mm");
//        dezhousealSpec.put("77","中国共青团专用章,38mm");
//        dezhousealSpec.put("78","45专业章,45mm");
//        dezhousealSpec.put("79","25园业务专用,25mm");
//        dezhousealSpec.put("80","24业务专用章,24mm");
//
//        dezhousealSpec.put("81","4030财务专用章,30x40mm");
//
//
//
//
//    }
//    //JSONObject json,
//
//
//    public static String  convertTypeMap(Map<String,String> map,String sealSize,String SealSampleName){
//
//
//
//        for (Map.Entry<String,String> entry : map.entrySet()) {
//
//          String []sealTypeName =entry.getValue().split(",");
////            System.out.println(sealTypeName[0]+" :"+sealTypeName[1]);
//           if(sealSize.equals(sealTypeName[1])){
//               String Size=sealSize.substring(0,sealSize.length() - 2);
//               String typeName =Size+SealSampleName;
//
//               if(StringUtils.isBlank(SealSampleName) ||SealSampleName.length()<0){
//                   return "其他";
//               }
//               if("30x40发票专用章".equals(typeName)){
//                   return "4030发票专用章";
//               }
//               if("18人名印章".equals(typeName)){
//                   return "18三字法人章";
//               }
//               if("20人名印章".equals(typeName)){
//                   return "20法人章";
//               }
//
//               if("42单位党章".equals(typeName)){
//                   return "42党章";
//               }
//               if("30x40财务专用章".equals(typeName)){
//                   return "4030财务专用章";
//               }
//
//               if(typeName.equals(sealTypeName[0])){
//                   return sealTypeName[0];
//               }
//           }
//
//        }
//
//
//        return null;
//    }




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


    private static String sealTypeConveter(Map<String, String> map, String SealSampleName) {

        for (Map.Entry<String, String> entry : map.entrySet()) {

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
            return sealType.get(entry.getKey());

        }
        return null;

    }
    public  void init() {
        String libFile = System.getProperty("os.arch").equals("amd64") ? "jacob-1.18-x64.dll" : "jacob-1.18-x86.dll";
        File tempFile =new File("E:\\workspace_zhong\\smis_workspace\\smis\\web\\src\\main\\resources\\jacob-1.18-x64.dll");
//		String path = "E:\\workspace_zhong\\smis_workspace\\smis\\web\\src\\main\\resources\\jacob-1.18-x64.dll";
        String path ="H:\\test\\jacob-1.18-x64.dll";
        String testPath ="E:\\workspace_zhong\\smis_workspace\\smis1\\sdata\\jacob-1.18-x64.dll";
        System.setProperty(LibraryLoader.JACOB_DLL_PATH, testPath);
        LibraryLoader.loadJacobLibrary();
    }
    public  Dispatch createActiveXDispatch() {
//		ActiveXComponent activex = new ActiveXComponent("CLSID:38EB2860-D8BB-489A-BD58-001EEF85F337");	//SMISServices.ocx
        ActiveXComponent activex = new ActiveXComponent("CLSID:1037E3F8-F546-4DC1-A03B-393BE550AE0D");	//SMISImageHelper.ocx

        Dispatch dispath = activex.getObject();
        return dispath;
    }
//    public  Variant callActiveX(String method, Object... attributes) throws Exception {
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

   @Test
   public void yxzt (){
       init();

      byte[]Sdata ="0x333731343033343030303031323637322036373220315343A002A002210273570100B223000000000000FE00141A6AB1BC6D2DC3E4F6E00CE7B4238E9E87BFD6015E26B21C7FE8F8C9A1B37A35641C5278D5AA25317F3BCC9E1D80105EF281F400CE01D8CF53A006731ABE92DC00D01B74F8151AACA3DAE2F25D99661ECA0B10A9CEAB31A9E2B44ED4643ED02E4EF0866717C3114A11B8E01376F794A05E964EC4FDB4A8847C563F9E5FF6D545BFEE2E63307045FA54D5758234EDC8CA2A0DE060F28B8A891AB8C5BB2C5E6225A14AF282FB3C25D31733257ABD45105E61710564F4170279746C21153800723FB15BCB02B519F77CFAF9D4824A3D3C96C1629FCA3CE876855F75C59EEFCFD066236705055419DC8A4F3B799499D0D822E58F615422B743009A6EFA322BDF3C49A5862783D26B6A85CE89375690724FD0590DC217969505A265052BB10D6422E87F7ABB9263206A41B592093FACE8E14DB95159CD402DE480145727119E948FF8CCE75641E5A5E8264E7242DDD87BC345CE2C142CBBA7313F521527E013412D058416AE9AC6282B7510A6A5D8E629D7FED118B38508EC9A05341679548FA047511DD6F60DA013EAC041053C1204121AC67A3E8CC043E272C5D7E9A49EEB5E6DBC052CDA07311037A2B8A5C47317D801CF6C5222E1D698F410653294BD93CA3F9619EE0F40E789163821E7B5825F24239407481D2DEAE7BF169C0CF723CB8D3600350BC3F9D7310BF153DF03416623A568ED918F69E597C6E0385216083E80F3B899253358F58F2FAE0F02FBA4D282A3FBC053C38289FB407AEDACCA53CA82C5448BF417AF7ADBC93E4B5D17E027FEA6B87F0C9E8285872B6DD184F1574D8AD811FF93F318EA939223C4C3F8FAC4FDF4F89E8120959A428CAEAC76C5C8930EA761FC6A22F636AC6751F7B7E0FDCB9C21B28C47F97D06A76306EEC0087CFF301B5F6E9A8DCEC7717CEFBE05CDF7C4AA016EE8DFCC23AAA1719F26A33E8FA5C73308E8AF440B711E800F2BD05E645CE2A22B70AE7ACB0B746A80C772068D7E55B44B26B0ECF4D83E822B1C1D92C9FA6A52F57C2FB9B17194660C66289917FEA82ED3ED73031BCDB1732DA5C53BFA29A73FE48EED327602D23389A8A398BC8389AD7031AC52BCF2D13E73ED4BF8941753FCE1FE1A5586E8FE78576CB572C51113FA03CA1EE612F0E696FB7F05530CE8C08E52B1E13996E56E1AE6CEF2EEEE9EC988E62AB8726067DD93EA98C188EF5856A83C02292E6FE2D201C3F52613557456EDEE1C7846525B0E5F19CB841555149E92873862D05E3952E86EFA0ADD115FFEA527597AC502FD407D1FB1762C1DC0ABAE920B02AB8511AB5A215F9BB0A355B3990317EB0150106F711C55B8EFEC2CCC66B9FF9E7EDD102B289137C3E0BA4E21FD3BA341F368201D2FE9A6392BB4EA44FD538958040FFD2CCB2DD40F178B2403B835B29673D2F7A612D450B76F0B98D9F71386953392AF988E1C99E2BE791628FCCCF4D586CE4D6E632616B8D14352AB57330CD51CFA75AC878D55AF5F6AD4F1B953A9E52AC86941628A91EADB07CD611A11A1CCE4B7248EE141C602D3CE7FBB29AD6F2C31A7972730473B9B2BA7B9B4FCBD79DC4528BE43435765756B13F16CF19C99E201E2AE8AB35BF9339E1AC04C15D6734519FD42A4A72C6C611DD1BCF10EDFD699DC23E85E71A51436FB57FC6DEEBA73D86A6ECBE27B37C79907946774D0C08C542B5B1C1DC1789B5BF2F7E356009D370DAC9E32987EC5ECFED783E97E0F0BE3E1E0A21A42FA5EBDF00FF71BB1FF494202D6A4B6C55510D2F769CB521B235A47EBFE2276D5FE1F4DB003266D2EB6F3281D75900847D3DC5B4532BB79B836EEE29A3B93646D6A18232587B0219F22BAE0A1359328D35DA344AD78A6F913235E3729A5E1854F9B01EDCA1069DA7035A9B343FCA6B3D21F6AFA34F14E1482A1AFA17F9DF5A3ED41AE225B7BEFDB690A808F8D75347F032C6E213CA83B81E6E94B3F4132365AA1FDFCE27BAD8208115D4F2A6035A145BB96AEAEC5A9FB6D56855C6AB79AC188E7790404E24B8EE27F810069B3FC9E8B5BEA030BF0C213EF4A6BCCF628E1481D81DEEE38E947D92400B299FBAD368FE4604B5508D46B29719F4573D74F68CA3BB491F3AADA2F75285D51781D7BB7BDA999F481C9B7E2B04D9EA7486C814D20ECEB0BB1EF0F5F9174B4FC6E682DA897153C00AED2FF95A783C073E1A90CE63125966991351D4C11FB7EB9609809CBA1F1DC4BD67738325EE7AD2301CF76EF62745529D52FA027616D190D8035BC4DF5DA4FED41B670B9A18DED166F279CF334BA652BF137BD795573124678108B5EFEE57DB7A2397A4C864C2FA37DE6BD3952E67C5B47D7C02C5C3DB7F507B920A09F6BB343B34B731EA021540142B299294477EA03994692018C658D4726D1DAE4AC958559E693E0B12207A1C74EE232B2DF86A97517BFE66BF41372415D4FCCF4F1DA9CF729BE86204D474EA64C2D3C0D65DFD281468C41FE8C546CE15DE38554574DAE7D6B47288778C1AC826BE26F088FC14523B8873E32DBE98341F760380A9D05798F1EB120BC9B94CA58454279B513DCB0EA5FDA509F9651E658C380D1D3A38D21E3BC4DEA999F00EDA78374847B0912EC84C907A409E9A7BC1E94641F47B8DB0E09A0B9B63699A84E011142F07DFAF2236CD3D8B5D3219DE74DE2B6277DE8D0A009C626F0733BDDC5F6DD991377006EDC8FB3A564B5D69C26D615FDE2724F2333633F1F27392691F1480B2C424F1A55853BC948C581D2173583D685543B58072496D982A752CC859F850D88CA9D25264B3D3E22A60D755CADB8A6EC29E094D927D4CB85C46732F4AD114B0ED41B7A8BCBA98033D9B7E50394C23A8A2F9A53013F248DAE6D5EA6BA339C42C1E822F90942550065B428330723B0F8ACCC8F440BC4C58F787636127C7ACA4F1ED40006FD373F33D1CDCD5E48CDCC554FDCF3A73CCDB3791418F1AA4CFA92758CF0A276749A64F939A96DCA50D34E52E28E32D7BA513F2AF30C7A2E33329CAA7C16BE099057527F09FBB05B665CBBB0CBAB8967F725C38D42F0AAD344F62A75BA80E29EE81B61326735F14BD1CD4DDD968765B4F63483EB0D947520985E6928FE9758EEB18286EF823ACAA6515A2E735F27F241B47F5CF6B8D620D46948B8AB2E5580D0EFC05E147099C4A2FAFE81E1A97103215276979F89EC9E39034FB48DA6CD25F22FE17371D487ED23EACF228C9B9BFD0935D006E8135C8D725CF4E558C47E2A7506BCEB4A33E8D4AD1CE802811732A2A60BE4519234FEED86F2910BE9EFB99572922E159C7E8DE4E28ED9B3D9697E8595004E81D8E1C2FCF302D76883A1CD0D128D61494C2A3D0474BD0F9271659DCFFBDA4B10E50994128EF80915DC436A34F67821ED3EE6B026B2D72A6CA067DD61FBB514F0B58780D63AE8EFB6E18516B31D543508A353B7719D9964662FE19F02995D569C84A5B6A99B5134E27218927907FA84F375263E29ACF7EB625005C6EEF6A4876DE7AC107EA28FC9594852185F0B2309991E5CBB88A706D1198EDA2252C820820C2EEC64A42C2F43E38D2D6904108019653AB41401EF8A9CA0D05F764CFC49DCC6223B896A637BBFD67898AFE2B9324CF524114C4A4EB3EEB4C743DC6B5AF2553DB59A33E71E95B5F3472EDAEC4DF611A5B13E82552006A41C10D4F26351637D49EFC4FE2E84FED7875CA4C138901036DD27DA24453DB778D019C3493A88E4ACD4717AABCBB9E5FDDCA6F0D6DBBAEFE14B73D800DFCE26CE3611C5470FACB742CB990F1C80462DBBFC53DD61AA5752FA417CF2E9BEC022DC7B89B06BE96FEA464CAB3A51A62DF7125DE42E3B2110267081F2C65454A23EC99AC09AB4F36602F8AA6A7507DF91B1A0929FFFAD57B13DE8106ACE689DCDB03EB465589B24D44D8C84E50721A60EBD67404C54D199A1880ECE47084C2F74A412E8E46614DEB8AFC7745FA9D04A834FB0AB6A6B732652CBA76FD389C15AB5C9CF00C36DF4BA5A2776DE1D454BEA2643AA40C9E08C2EC27BD55FA3C1344B6F8FCD3A316BE81574F46D08FA12EFA07947B49746397515A9C97FFD519D71214ADB685EBA21780FCADB5CA56D209C3E2810BB1D2D487E12F967BF3B4277F153DCC66796A984A6348F992AB1DA8C17BDA16C41FBF7D872D5235A07CA82C23C6FC3D8FC4CF8975FE5596020ED6C8441A05AFEE217961B7A625C482CBC390D4135F494B070A5001705DE0B400C8A41C9C72931E6039ACA2EAAE366A29F2E85AE2B2CCF49FB181440760B0C3DEBBBC1489B8AB13FB9CDD159319E458F6F9F03D169BBFAD950A70C08595CE660710F80F5D28BA0A190B9A66AECB163F0F27114E6D8D08714B8D521D7BC6DE460B03C4FDB8776D140D01A80DF8B9BEE2407A9BC6CA8BDBF861CB101E90BA3B8F9DAC274F659FA71B47252F9C86201D2EF7927BF1CFA5111AC3BE03A7FFD7F3742FCB93E1E1226C280271AD3203C94E694DE0BDA701843B5759F81C15B023BA48259F25542255ACE06104D132030CDA16EE7A7EC3B134DBDE3779327F75E4FCFB9972BACF7B052EEC6E0A3B974E2983EF26A0ED46867539C82BC2B162D0193AECA0578B51331356A392090040CD3A2E0CA4D3E9D380C95E844A1D553187CFDEDE76E92A0C99D1902397D657B79D20B18676ED85E307E494FFA11BCCDBBF4DDA2AA5BAFF5CC1BF5969D1DD8C27650AEA33CA2845D7C6742C1C64B1F19BDCEFFE2D18848E835B2CE994F35677EA57982A916DBB70AFB0D6C0561C53F19256929D54ACA1F075DA00D5B62B822B81A626596E3857461CB2F1C7CB2081BF8BC6F7EF7405AE8B008F695F0E22C38C5C857D1403D3407C221EF3FDBC4591BBFDE97A48084584F20821313D10338292CF38B4CE35C8E645A351D5BCD5F33ADFD22D7B882E973DE3EF87BCFEE5D66E54E16D0811104FCA69917F4432C424D13168B6645D0F6B754DE0CBACDB505B34624DE3000B196C74C0C6AC3FAF7A266FA581304FF186A26130D313AD74DBF35DB4B1BA53C263DF2FE140D0B9CD0EDEC0F3A698993E44B5B4FE5FA98E5799C649FFF50F0C787693332F6E484E36462EE2BD7918D8D572BBFB8F1C20EC00EEFC15B2660412C19390AD13E068E633B95B708D760E5E67C53B74CDDCCC6FE1E79D3B6D1B7265546FBE9FE9C045779AABDC2AAB1F7C3D27731CB99816D7A6339FCC6A79BFCFFEA86E649C71AE1B44B26865E08606DA9CBDFEB46FF911EBFC8BD0BC985230BFA89F88AAD7F71531DB544DD3E0BE9399969CB0558CDFF3AA46700FC92F96221FF0FF5CB2CBBBF4C8E4073C079466A4C231A92568F34053054BE61E1BD5C85851091C2FE2937DDB9898E5AA96520BED91DDAD9D80AEE292A972ED94E2CD61D23D84C3428B80B0108E7EB8D33DEBB323BEDB0E7A1DBD9D285DAC23E5DB7ABFFF573754EA79EE62F638D10D8C4CC303F867C40FD698EB674186CDEB43C284098458572AEF1FA0A165CEC35F425F1A0ABCEA5BBAC0DFBE63868507DD74D0AD2F8C815FC989051D0EB512066C3F8D73A868CCC6F72B00778293CE5F589E0EAED68A53018828E7B2E9E1D1FF946FD486E030D445233BAA79B23E0F4F80965158BA8C6DA0AEAB18B9D751DCD3BCF93752E58D3EB28EBB69751C8C70B0BDBA011853A4F514B34C73BF6B06B0FAB13DA8CC65342B5B7F48EF10F650B44984E804B25B6F24D46AA4B2ED27A03B986031BC859C21EE56824BA1A3EEE4A331CB3255B54BE7B8A44DB38A008183CDDAF8BE7275B105F8752BDA949ABD22C9799A8D8BE680B6FB410F05637CD7C86B59A86010A11692F27412345839A869D425359F575844D2387998D60F6C690219B5ABA0E317C79628A0EDF410ABA5F7A9E9DE14688FBD7FEA5309BD30267BA47EAC65A1180336103FB5D8A3C7E4940EFAA15B8B5155B8AE593D83D7068D80892B2F8B44646F62C1EBCBA59143FE444417E93B66BD669923B4FD4BBED38B0A493E46A6E7B91264A41EC1AE178F128F0C9AF4533FA328AD3C335A0F77BE51DE03F9DE5BFFABC7DA9BACB0F6EECFBD5EEB05C8D86CE5B6468E66DD85152CF6733180AF01DAD66AF572ABBFDD66A32E88AA3F54DA9883C32B1128D4643EDE6A5904A6E70717A51A792F9C13BD6637764902A8F74F49EDABB1703583FE77979F01B61ED60919275D34A8D79F52189C94A013D798FF65436FF3A1279AC6152512022173C40C09BC15D6EE3E647273526D71F77E96418C5F54899511EC7C5C5286A06A2B790A66A033D60063F88322CA055A0445F04B4F2DD79CDA8B1074D6C63D94789093D3D44262D01937224A4FBB4A81AE3D4C20FE017914AD7465A9F8006F6284F11B483F8D6EC41D066533FC17A68E038F00E828C9BE427ADE5A420739936571A1F807F243FC8E0FA5BA02063BF48DA7BBAD641CB08A7FB4DEB7E429909C8108672EE307CE96A83710A743441D71C53B15D18ACA04E18562822988D65ECADEB0F02ED2E00269B18408ACAF5BC8E026D5F9A926A7D8DA68B695AADD6635670C13BE08EB10849641CFAFC594B098752640B2D95AB6C14DD8566EA30F3B33BA88C3CE6EC78C12359EE69412F7D77AFB28448205B8F9639C830596266AD0C7042E98C23C92DFC509D1046590D3E81FFD6E9505605341457405E919474DB9ABFCF2A0869BB4A4028EB4AF91C64C12A12D74401CB151F038DB7911ED27441AA99503141A39B9D5A73E6DFF916D3338448DC69C657265F36E905010E935274F04C8169897D3B85ED6EE4CFEF38637F54886DE0A82561D46EF5AD99181DCB0653ACE0DA2C70D9E910847401B8EF80B8075DEDE059E6E9EA817F8C1B70E14A618BB039B7E3C22043967348387B363B7CB2791BA1735DE8B9C0C21452A1A6258D24701799A0DB9C217352D1DA54ACC8829A21B1214F3DA62D40E5F66DC383700388F5FFA399AB127A246C062163733780847C82F8937C8B7E992A717A66FC5114868360BDCE089F87AF98609AF349D725230C1E277D69DDDC13CAEE92FEB2B93CA2599655748F81C9D811C38FA09D97352D66698DAF9404CA174D08022BF3287820F29B86BBE5387816BF8E019DAD0A9978031505FB65AC920C6EA6E01BCB8092A91F94775CD4795E1DFA9984FA0A2CF43BF4FEB5225D2C0A057433595800F53C4639C4F732CD7CA1AA640A86763E9002401D916C6D6488AFEEBE814FCB07668011B4931AF44DCC846276493E816667E8970119FCA4A693C987F94AA530D50A41FA4A206B8045D84565E689C00DC31D07D4E16715B801824677FC406147ACD51F063C100F004C79F3E36215E8391BC9006A7753049BB8AE228E0DAACDDC8FEC46EF01CC3093ADF244F4000E9BF7118F706E914696FB09738956006D5DBBE807B4E76FCC07D6BDDC5EFD37F03ED10F8D607F70EE35FC24246F540B603F852534AF2622D86A77747F313A9C0FE9ACFCC09929134F8CE15481F77114D3F142D042F402ACA50562059DC1B0D3AE4C8CD0A4E47A1F76145E214AD0D481A9615B4B2ACD1A5E7F458D10603321E7EB5077ACD555403B4A6B07A4043E8291287B603A49E76EDFD9E5D9A62F7A4A030D54C986B4450A0C36BC4724A6D3E7D7216C987985A339FA0BBCCD5AE34BD6D09ACCFFE87C27D241B25D4878CDC7AB9BB5ED8A907E21FCD4E8928D72119539EC737B74D8D6307F00D8CC7F03D70D9C1AEDE026BDBF6A8437F5AB795AFBD4F3DABFB33DE210FB0643E3B34BB6578F08347E23786F7B27241C7BA564BBECC9CF42C91C7A4C553FA2BB5DD36C68B3E5D0EDCA8FFB3EC6B03A83DCE790AC938DB2CDCD509AAB4B456F723B6D2FB5D69F1E8C8F5BEF3AB15C03EFE2431F710EFAC2EF688E3EF27428826DE390CB2A49AB3ECE68B3CE3A23F7FD4083B3265B574CBC55695C3EE6732D1FBBB9B18D65F668CECFF0095DD3E54CA22EB0BA6E107FE6984E045FBBE8430C09463B69FFE4E431AB2B75D5680FE09C8C2EF2D063EDE82B71993FDF2F368C3EF98B7BA0F4C320A57033C5DE8332F4A1F0E5DF43A15797F0765F2D5725C6D9426457D6D31FF4BC7D3BFA6C1EA16493B301B751BE8926F4C2C48CC7C407D89E6ACB5E20C2CC4892C7F3B9AE5096E69A489EE75301405E11C5DD0A03DC55121CADB71026F9850D6611A982C7464871A83A4BA30297F733BDFBA8FFD168983EF6B846646E2359A191A73A5E5E8342A58F0DAAD89E680985B37BFC0BC22FC946FE0CD8E1ECE9B82CA306482E85B4901E2A064BFD2EA762EE106F54B82AD1B4A7FEA3C1BF2EAB5C3A62C6ED371C4AAFCB2CBE5BF0EF632BF19B978729DCB564BAA2A19C901F709C2E01948D638524F707F977C61E63E5E56408EE2E47D8C28E4F2079D431B4496F80758E604C7D047991A4C306F4CC8578C1B6D4FF831C38C60A4150E91210BC237F0AEF3538F97B95AA0BF996C88F8ED9688A97B42AF4254FA1CFB05121B562B10FDD9C0D4DDC3F515061A5C73CA6D3C4040609E0D78D8A036EBBDEAC5AE2443097DC48A8C98C1E8F07CCC0ABFEF566585B428821A30A9F58FDC512BD4DC47E4C63CA2AE75A5A4D493330158AEA9DFA1AC18309B44992C5CBE0F543544E1CE024F0633B0ABB4E0069E94620A28C497CBB9694E70E3D6B89B4C1B795E664712410E9F527549891132C5649A24EAEC9A855816E43F208077C6CA9ACAE1402EB59C59C0C7C34307567B469E8F8A13139C561A49253CE08FD70BBEA81C83618CE98321FD991ABEE99DAD2E035AF28F6C440EE12B81C60DFC6E33D72D49B6528B5AB58045CB047E53594281E2F1C7F95AAA3E15ACDDD1AD7262099FFEBFE289B2F18FDB847F085BBA36610176FFE751FC3A9E6A87F777FC58303B96997560B09FF0CBC8FEFA47DE1567B61ECC56DCF9AA2FE2256FCFFD4464004B9A4C7DB3C4801D8EB635246E635353DED30CD3D6D7699C47E768C093CBBF0EB57C204E2321F7E63041DC31AC30BDCB9D28AC29EE2253ECCD70AD5D3B59F4C0757D31ED560BB6B08AF13DAEBB2BB80572A0F0F1E98EF93A8AB71469F47064280F6B5397FBC38DDC5BB27F45961E03B2B6A658911D639B5E0779F78EAAC3FE3ADBA0D6C2BD18E06CED2B1A1327395010C1F80330D788B91C12AD94C83AF746962193E7143DE3FB5AAF359C17DE247E7FDBCF590971CA5D45D7D4F106A0CEBC4A691D80440BE01605B6F3B6059C2E5866E190420754E0E5385A8DDF54F4234EF233008E5C0871E577639DAD9E6983CF6A4BEBF59E0F7D78F0B0893334B9B3EDC58250BB26D38C7B03ECC3BD1617C8245140A8F5D9E4B1A0078ED3032AE4C1E6005892B910B84F69CF90B2B42F0F50911DE32855DA87F621080F1FDA0AB45C0C059851602486ECF3EDBB244F026FCE78E81BF75186E97344E8E30F1D7661A683E954C2CE74ABA2FF612694D807EB53D7A976BB7AEBC353E55E1B8B9F84ED75E16129F98BE7150D2ECC28E52D7781E066F0FD7BD99B6FF2DAA540B13ABABFE01283A1325DD826750458576C0BE177D6A743E8838DE656BBE1F6A803116AA1733C38735AAEC0B054CBA15D3CBEECCCE93300B6522243D3E5BB927C34BBF568B7BE32489A6DA447E2C616AE69347E4C8104976C49A2A09FD2503A106D8EA5AF058DF4DD5D267154CA44D949E610CB9269E84C58D0658678D9E0B134A57F4FEEDC6E551A664BEDB8F3BD67C02F130259BD0CEF9E078DAA1C4C8CC9A03BC689BA0E59DD883F130B15A6582331BB0CDA6A6FBD64E9278A0381890E8BC7A9232824CD379ED79F5C3C30F1CCA79799B1C4E432034127DC50D187913D2BCDDBECE259DE11F820C947AC1E745B213190B8B20626F6F6C8BB905E082D9A66EBBB20C79536928E64155277C8306676AA134DA30FF8F801B655031A3F624E412E8F6F00035B9FAB9F7C0AA1A48163DB72EEBD823D6553567D661243F6325DA83D9BCCA8AACC0DD8F18FE8A033E0883BDDF7E335C8A4758A4C561D3BA287BC098759BDD3AB03CFC0C006EBA2ABBE78ED177D39F670634E1613B3DE3E8FA4A1B879CC3848C8873CC953E60B174D6C409F8F9AEA65917663C4CB3EB7A2485FBF299BFCC5AF2C7DFD71E1046439BF0583D7F94A2A8AF4C1F80171E40F7BB7A425803F9A2548E880909DDCD36C202E3D6ECD42936ADE52BC5F6A4C568A6F5EECF8E8C75FD41CA60427E7728FB886EB6B597EA1A16E2863556D69B8F012AB96F6E4CD2C4422F92042CE5A95667E52F5D73B86F15E7E019BFBF039DB687DEFD16183F57DEFE2ED12A0E83B4C7D50966141DD4BE4CDC59BA9D2FF10C2AEE6EDBF5A996030A48CB24D85351CDC6AE2B949E6527AE700BF4898ABDFEF27835847A07766E901E219257781D74FBBC69C963F6BD36FFABB197BA7CB7E24915592ABEBD0216668A2A761414006572C7C044959A0ED9B09301325AEEB3BA06183A14933C1E04C541C803C203D6D7DFDEE9DBED69EC71129DF76D6950A0000672418784E868674B28FCAE1137C967E2CACD9168030B99D103FE575C809BE210907AC8137ABF21D3B2EA4A1B24AACD44CA72CF3C686CFFF101478EFB0BAD985C9AC78B1314FD5902D352CCDFEA0E7BDE6E6AE265E54AFDF3B6879DF99008EFD88B18F6A47560766E4D897BC6DFF9F20723D7D12E640CAABB64BF2E5491B2074D83CFB34188C29FC625679E03872568239058082CA2AA4E0C99CC07D8CC030A6A03E3E4DEC5C73747E5BA7C38F9D2D2E95342336A3C8C786AD3EE538D86458706F2A174ED4FC4DDAD3EBB527144986881C987905DF0A606DC19EAABA82C2787647445C518ABE9F70A7CAB64D471C37AC916BDC51ECB0E12BCF1321B562489F290B68F23D415A3D341438AD01755FDD44443B753D1B1211552D2B61CC25D536128BCBFF7D67BC35A45BA3EA7D467913D6ACD6CFA1B931F5DF9AFE5CF2918FC1DB2707D10286C4E80B399536EB40A740FED0B18BBA215411A525218F480191CC5A84CD7D1582665A867D1137D4AA5717565007D81636E0C0B56E16E0B0F3AB119E235C90C141489CE3FDDB47B8691F071B1CA8B42441066DDE8AB9F0C8792820F9143EACB2C0A0FED64109254DF5083EE3E58EC303EF414037DCBEEFC8381D4760FFA1CCA8A68149F5740D03FA9F63583E1DC558ACDF48CB60B7085D6A61243E16949CC7C132E8031A78218D9D248D67D93FC992E5333F5A7A2591265AB8A8804924C97A16B0011ECF15B0C60F31820AECD9531CA3CEA8BCC5FCB9EB55A2EF044B169E5A471605F5DEF1C9CBD8B82F5D1E3B9A625A43FF340EC7C6192AFF9CCD78772E344CEA7AB617A1D2C11A82ECB5EA0CAA5F58CF0EDC824742531F2D14AAF4EE367313B72F2D727FC59AFBC6D10B95E03B3EB4EC04BA0EEBC74F360A6AD7490EA479CD072C612DA1510DB7A6D5ACF98E05AF1661D86280C5C938A7E9113E9D586AACD108A6BEEAE3FA029EA4076F0A462D541F8CECE8BCA656DB6A8894654BEA68B24B67F696C7E52A5C6BC097E9AB2C423664F787C1125096B1CEF23E82D0CA3950A7A7F281591BEBBFBD45864A0449BAD1049B6199D32A7DF797190A2254367F55049D162342B14E647C47624252A66A2B292597D16743959FB7F7BC152EEB1373BC538798753BA59CFB4063D54D115A9D5C7EAE887685DEAC567589002DD2F8C109F55363D099276DAAB23775C7C43C1D3DD608C150882D9C8B148E477387F1522CCE1325B3AB96D2498870F999FDEF7C60419BB1B1BD30AB19FC50961937643DF9062B451875B44AA127F5C2C1D51670B42B0BE47147A2541440ACBF284E397E8D86728B743F6F1F3653EEA693B446612AA281C13AB1E75335448F3B58F8F25E0F1EE49004925658560102C9694E2C59C81DABF535004789DC613F932845D0A66D3609CDACE07BAFF2C895ECB94ABDFC653884363C09211283103B1B5F4FEE7A134CAB479EC36E24C59E53656E3AA0785CE143CFD6174557D84FC59A6806107381E93049C8B8255FB339B6BA2473E3F79B0AEA3B433E102241E5F54CA2DF27D0A5F6CC9EEC84EB70E9495FE7AFC2BC13665648F1DE40857EFD05E10C20FC27571DBBCB77BF1A88BC94616D5B11AF394D85EA4038B19DDCC9D02C96C54D39210061D33AC7C378BCDF0FD66CAE20487D75F2A2ACDE475F07EBD1EDEC93480E43826285554E1A1E60EB8C0CCD4EA60B41091CDEB3ADBE848C8AC96C0EC64DBEF8EF6842A585A76EF1CBEB43F9B7090F275CCAC8307BEDCB0F9ACDC9D9B2D82DD59C94863BA80578264282CF9786B6F3BAB06EDE47CB8EAF2BE1FFF426E952D13D3619238C3CA6458F485D455F38E885D85A8DAB87088CCD88705A677A8BD6C589D2C31790A7E30CA19AA878E692E9F5DAC58C41765CA895E67621FE24D4F1C49497C1EA85A1B5E35D8311E8CC1FDF4B0CC3B19E3AD77CB5CFF495DF49E060A2AB0D8025FDA49573649BD9CE4489AA27ACECF501C8B99BE6782222C1BDE8BFB6412341A6B5223E686FF73B3E7D4E721C1EC72FA6A5A24230AEAB3A20330E46FA562074DBC2D29FC28774B9C865C228FC717B0F02021B7A506122ACA4DAEFA2CAEDDD1D77C73C7D81A14CE09E556C25A301447E3AA03F40CDF2CA56D918EA4C59C3A6B48333899351C9D99CC6833326B6983F9A26590B67C44165176C83D953F56503CB23E3B5E0D92CCBB40F6F93D2F9780C74BA8F178C54E430D80F66E628322478CA0D5F61759188BA1D028E0ED5A824B32CF8A56E8A841377EC5AFEB12B8B93DAB90374B2E143438925CF5CB8D4E925DCCC80D9459B42296F180453ECE58CD5DFA6F1B68B5DAF66C02CDBF147334D67B9FFC21488AD7AD1551848D809475EBDED288579196B545CA610D0FD243B3F28BB9ED5886EA89320BF11C1DAD6D49B1F32597A85932A60341535CEE68C33A65FD68E2D6AED1C5B270AC8F7DA20ACA59EE6DB5F70083131F764AAEA3F414FEA73F157AF0D74C8A7E5F1B34CA1D88C26DB9C0A0AD811E3034B417580000".getBytes();
       String Sbase = Base64.encode(Sdata);
       int size = Sbase.length();


       Variant result = null;
       try {
//           result = callActiveX("ImageBase64String2BMPBase64String", Sbase,size);
           ActiveXComponent activex = ActiveXComponentUtils.getInstance();
           Dispatch sControl = activex.getObject();
           DispatchProxy sCon = new DispatchProxy(sControl);
           Dispatch sc = sCon.toDispatch();

            result = callActiveX(Sbase,size,"ImageBase64String2BMPBase64String",sc);

            byte[] SbaseCode = Base64.decode(result.toString());
           System.out.println(SbaseCode.length);
       } catch (Exception e) {
           e.printStackTrace();
       }

   }


    public static void main(String[] args) throws Exception {





//        Variant result = callActiveX("ImageBase64String2BMPBase64String", Sbase,size);
//        System.out.println(result.toString());

        //        Long TimeStamp = System.currentTimeMillis();
//
//        JSONObject  jsonObject = new JSONObject();
//
//        jsonObject.put("Timestamp",TimeStamp);
//
//        jsonObject.put("Sign",SecureUtil.md5("TJSignet"+ TimeStamp));
//
//        jsonObject.put("areaID","371400");
//
//        jsonObject.put("carveID","371402000000");
//
//        String result = HttpUtil.createPost("http://222.133.49.90:8092/api/ImportSignetData/GetSignetID")
//                .header("Content-Type", "application/json;charset=UTF-8")
//                .header("Cache-Control", "no-cache")
//                .header("accept", "*/*")
//                .header("connection", "Keep-Alive")
//                .header(Header.USER_AGENT, "Hutool http")
//                .header("Content-Length", jsonObject.size()+"")
//                .body(jsonObject.toString()).execute().body();
//        JSONObject  object = JSONUtil.parseObj(result);
//
//        System.out.println(object.get("data"));



        Long TimeStamp = System.currentTimeMillis();

        JSONObject  jsonObject = new JSONObject();

        jsonObject.put("Timestamp",TimeStamp);

        jsonObject.put("VerifyUserID","fj_guanghui");

        jsonObject.put("VerifyPsd","jianguan_gh!@#$");

        jsonObject.put("Sign",SecureUtil.md5("TJSignet"+ TimeStamp));
//        jsonObject.put("areaID","371403");
//        jsonObject.put("carveID","371403000003");
        jsonObject.put("condition","CF");

        String result = HttpUtil.createPost("http://222.133.1.102:8089/api/ImportSignetData/GetSignetID")
                .header("Content-Type", "application/json;charset=UTF-8")
                .header("Cache-Control", "no-cache")
                .header("accept", "*/*")
                .header("connection", "Keep-Alive")
                .header(Header.USER_AGENT, "Hutool http")
                .header("Content-Length", jsonObject.size()+"")
                .body(jsonObject.toString()).execute().body();
        JSONObject  object = JSONUtil.parseObj(result);

        System.out.println(object.toString());





//       String s = "20210923173127866942_法定代表人身份证正面.jpg";
//
//        System.out.println(s.substring(s.length()-3));





//    String result =convertTypeMap(dezhousealSpec,"30x40mm","");
//        System.out.println("返回的结果:"+result);


//        sealTypeConveter(sealType,"");








    }
}
