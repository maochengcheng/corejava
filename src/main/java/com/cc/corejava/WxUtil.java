package com.cc.corejava;

import com.alibaba.fastjson.JSONException;
import com.alibaba.fastjson.JSONObject;

import java.io.IOException;

public class WxUtil {
    public String weixinToken() throws IOException {
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appid + "&secret="
                + secret;
        System.out.println("weixinToken_url:" + url);
        String res = NetUtils.getNetData(url, "GET", "");
        System.out.println("weixinToken_res:" + res);
        JSONObject json = null;
        try {
            json = new JSONObject(res);
            System.out.println("weixinToken_access_token:" + json.getString("access_token"));
            return json.getString("access_token");
        } catch (JSONException e2) {







            e2.printStackTrace();
        }
        return null;
    }

}
