package com.cc.corejava.util;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import org.apache.commons.lang3.StringUtils;

public class WxUtil {

    public JSONObject weixinAccessToken(String appId, String secret) {
        JSONObject jbResult = new JSONObject();
        String url = "https://api.weixin.qq.com/cgi-bin/token?grant_type=client_credential&appid=" + appId + "&secret="
                + secret;
        String res = HttpUtil.doGet(url);
        if (res != null || res != "") {
            JSONObject json = JSON.parseObject(res);
            if (!json.isEmpty()) {
                String access_token = json.getString("access_token");
                if (!StringUtils.isEmpty(access_token)) {
                    jbResult.put("errcode", 0);
                    jbResult.put("access_token", access_token);
                    jbResult.put("expires_in", json.getString("expires_in"));
                } else {
                    jbResult.put("errcode", json.getInteger("errcode"));
                    jbResult.put("errmsg", json.getString("errmsg"));
                }
            }
        } else {
            jbResult.put("errcode", 500);
            jbResult.put("errmsg", "返回值为空");
        }
        return jbResult;
    }


}
