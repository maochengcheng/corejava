package com.cc.corejava;

import com.alibaba.fastjson.JSONObject;


public class PushUtil {
    /**
     * 发送公众号模板消息推送
     *
     * @param access_token
     * @param appid
     */
    private void sendTemplate(String access_token, String appid) throws Exception {
        // TODO Auto-generated method stub
        String url = "https://api.weixin.qq.com/cgi-bin/message/template/send?access_token=" + access_token;
        System.out.println("url:" + url);

        JSONObject json = new JSONObject();
        json.put("touser", appid);
        json.put("template_id", "模版id");
        json.put("url", "http://weixin.qq.com/download");
        json.put("topcolor", "#FF0000");

        // 具体的模版数据，根据模版来传
        JSONObject dataJson = new JSONObject();
        dataJson.put("first", getValue("奥捷迅科技"));
        dataJson.put("keyword1", "");
        dataJson.put("keyword2", getValue("深圳市宝安区奥捷迅科技"));
        dataJson.put("keyword3", getValue("NB烟感"));
        dataJson.put("keyword4", getValue("NB烟感烟雾报警"));
        dataJson.put("keyword5", getValue("玉念聿辉"));
        dataJson.put("remark", getValue("贵司存在严重电气火灾安全隐患，为避免造成不可挽救后果，请及时处理！谢谢！"));
        json.put("data", dataJson);

        System.out.println("json:" + json);
      //  String res = NetUtils.getNetData(url, "POST", json.toString());
        String res = HttpUtil.doPost(url,json.toString());
        System.out.println("res:"+res);
      //  System.out.println("res:" + res);
    }

    private JSONObject getValue(String value) {
        // TODO Auto-generated method stub
        JSONObject json = new JSONObject();
        json.put("value", value);
        json.put("color", "#173177");
        return json;
    }

}
