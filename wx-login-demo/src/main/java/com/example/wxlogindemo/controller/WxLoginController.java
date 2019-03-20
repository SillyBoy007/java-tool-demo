package com.example.wxlogindemo.controller;

import com.example.wxlogindemo.entity.UserInfo;
import com.example.wxlogindemo.service.UserService;
import com.example.wxlogindemo.utils.WechatUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author wxy
 */
@RestController
public class WxLoginController {
    @Autowired
    UserService userService;

    @RequestMapping("/wx/login")
    public  Map<String,Object> wxLogin(String code){
        Map<String,Object> result = new HashMap<>(16);
        //得到accesstoken和openId
        Map accessToken = WechatUtil.getAccessToken(code);
        //请求失败,空就说明刚刚的请求没有发送成功
        if (accessToken==null)
        {
            result.put("code",-1);
            result.put("msg","第三方登录失败");
            return result;
        }
        //请求成功，获取openId,access_token
        String accessTokenStr = (String)accessToken.get("access_token");
        String openIdStr = (String)accessToken.get("openid");
        /**
         *通过openId查找数据库，如果查得到用户说明这个微信号
         *登陆过，直接返回这个用户的信息即可，否则就继续调用
         *另一个http请求获得用户的信息，然后将这个信息插入的自己的数据库
         */
        UserInfo user = this.userService.getItemByOpenId(openIdStr);
        //没有微信登陆过，发送请求获取微信信息，再添加入库
        if (user == null) {
            UserInfo userInfo = WechatUtil.getUserInfo(openIdStr, accessTokenStr);
            //将上方的该用户插入到你的数据库且返回到前端
        }else {//user!=null用微信登陆过，直接将user放入返回即可
            //返回user信息给前端app
        }
        return result;
    }
}
