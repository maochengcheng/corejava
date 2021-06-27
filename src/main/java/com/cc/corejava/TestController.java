package com.cc.corejava;

import com.alibaba.fastjson.JSONObject;
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

    @RequestMapping("test")
    public JSONObject test(HttpServletRequest request, HttpSession session){

        JSONObject jb = new JSONObject();
        jb.put("name","maochengcheng");
        return  jb;
    }
}
