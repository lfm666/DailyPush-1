package com.daily.daily_push.utils;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;

import java.io.IOException;

@Slf4j
public class OtherApi {

    /**
     * 必应每日一图
     */
    public static String getImgUrl() {
        String url = "https://api.no0a.cn/api/bing/0";
        String imgUrl = "";
        try {
            JSONObject jsonObject = JSONObject.parseObject(HttpUtil.getUrl(url));
            if (jsonObject.getIntValue("status") == 1) {
                //转换返回json数据
                imgUrl = jsonObject.getJSONObject("bing").getString("url");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return imgUrl;
    }

    /**
     * 获取毒鸡汤
     *
     * @return
     */
    public static String getDu() {
        try {
            String url = "https://api.shadiao.pro/du";
            JSONObject jsonObject = JSONObject.parseObject(HttpUtil.getUrl(url));
            return jsonObject.getJSONObject("data").getString("text");
        } catch (Exception e) {
            log.error("获取毒鸡汤失败", e);
            return "加油！你是最胖的！！！";
        }
    }
}
