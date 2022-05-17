package com.ghinfo.dzupload;

import cn.hutool.core.codec.Base64;
import cn.hutool.json.JSONObject;
import cn.hutool.json.JSONUtil;

public class ImageTest {

    public static void main(String[] args) {

//        String g= "RQAblo3LRRQAblpu5aKKAHblpu5f71FFABuWjctFFAB8tG5aKKADdRuWiigA3LQzLRRQAbqN1FFAArUbloooANy0bqKKADdTd1FFADt1G6iigA3LRuoooAN1G6iigAo3UUUAG6jdRRQAbqN1FFABupu6iigAp1FFAB8tN3UUUAFOoooAbup26iigBtDUUUAf/9k=";
//        String deco = Base64.decodeStr(g);
//        System.out.println(deco.getBytes());
//        String libFile = System.getProperty("os.arch");
//
//        System.out.println(libFile);
//        String s= "350430000000".substring(0,"350430000000".indexOf("000000"));
//        if(s.length()<6){
//            s=s+"0";
//        }
//        System.out.println(s);
         //"http://220.162.192.121:7777/web/receiveSeal/receive"



        String content ="ArLcurHsbGyZhSc9qy558CDI8WQCITRD3rbUUWleKaZ2UBIzlNGgFesMZgU0QmQql1dqO7pgWgkej8w7qfeestXIt8hbEh2cVaNvADr6X1j2FBKW0FeVlC6W9KcwxOtF/YCFkLTX6zEp1VLUEc8QskAIjYT3wvmrx7ds+3JP6APvLJ1Be8aVUmxxcn0pNoQr0o4CLtilbzI=";
        String deco =  ThreeDesUtil.decode3Des(ThreeDesUtil.DES_KEY, content);

        System.out.println(deco);

        JSONObject jsonObject = JSONUtil.parseObj(deco);

        jsonObject.put("url","http://175.44.138.8:7777/web/receiveSeal/receive");
        System.out.println(jsonObject.toString());
        System.out.println(jsonObject.get("url"));

        String encript = ThreeDesUtil.encode3Des(ThreeDesUtil.DES_KEY, jsonObject.toString());

        System.out.println("加密后的串:"+encript);
        String decoo =  ThreeDesUtil.decode3Des(ThreeDesUtil.DES_KEY, encript);
        System.out.println("解密后的串:"+decoo);






    }
}
