package com.ghinfo.dzupload;

import cn.hutool.cache.Cache;
import cn.hutool.cache.CacheUtil;

public class CacheTest {

    public static void main(String[] args) {

        Cache<String,String> fifoCache = CacheUtil.newFIFOCache(3);
        fifoCache.put("token","dhsauihasuihfsayuhfsayugfsyaugfyusagyufgsayug");

        System.out.println(fifoCache.get("token"));
    }
}
