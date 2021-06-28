package com.cc.corejava;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

public class WxUtil {
    String appid="wxb089827d6c73de66";
    String secret="370715f07c78a04f4b881d51e01cbcd1";
    public String weixinToken() {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret="
                + secret;
        System.out.println("weixinToken_url:" + url);
        String res = HttpUtil.doGet(url);
        System.out.println("weixinToken_res:" + res);
        JSONObject  json = null;
        try {
            json = JSON.parseObject(res);
            System.out.println("weixinToken_access_token:" + json.getString("access_token"));
            return json.getString("access_token");
        } catch (JSONException e2) {

            e2.printStackTrace();
        }
        return null;
    }

}
