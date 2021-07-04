package com.cc.corejava;

import com.alibaba.fastjson.JSONObject;
import com.cc.corejava.common.MyConfig;
import com.cc.corejava.util.WxUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

/**
 * @author maochengcheng
 * @date 2021/6/26 0026
 */
@RestController
public class TestController {

    @Autowired
    private MyConfig myConfig;

    @RequestMapping("test")
    public JSONObject test(HttpServletRequest request, HttpSession session){

        JSONObject jb = new JSONObject();
        jb.put("name","maochengcheng");
        WxUtil wxUtil = new WxUtil();
        JSONObject access_token_json = wxUtil.weixinAccessToken(myConfig.getAppId(),myConfig.getSecret());
        jb.put("access_token",access_token_json);
        return  jb;
    }
}
