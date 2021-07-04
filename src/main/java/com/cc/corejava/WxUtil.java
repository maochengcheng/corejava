package com.cc.corejava;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;

public class WxUtil {
    @Autowired
    private MyConfig myConfig;

    public String weixinToken() {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + myConfig.getAppid() + "&secret="
                + myConfig.getSecret();
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
