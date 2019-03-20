package com.example.wxlogindemo.utils;

import com.alibaba.fastjson.JSONObject;
import com.example.wxlogindemo.entity.UserInfo;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

import java.io.IOException;
import java.util.Map;

/**
 * @author wxy
 */
public class WechatUtil {
    public static final String APPID = "wxd477edab60670232";
    public static final String SECRET = "wxy";
    private static final String ACCESSTOKEN = "https://api.weixin.qq.com/sns/oauth2/access_token";
    private static final String WECHATUSERINFO = "https://api.weixin.qq.com/sns/userinfo";

    public static Map<String,Object> getAccessToken(String code){
        String url = new StringBuilder(ACCESSTOKEN)
                .append("?grant_type=authorization_code&appid=")
                .append(APPID).append("&secret=")
                .append(SECRET).append("&code=")
                .append(code).toString();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            String resultJson = response.body().string();
            /** 正确返回示例
             * "access_token":"ACCESS_TOKEN",
             * "expires_in":7200,
             * "refresh_token":"REFRESH_TOKEN",
             * "openid":"OPENID",
             * "scope":"SCOPE",
             * "unionid":"o6_bmasdasdsad6_2sgVt7hMZOPfL"
             */

            Map<String,Object> parseObject = JSONObject.parseObject(resultJson, JSONObject.class);
            String accessToken = (String)parseObject.get("access_token");
            //有token说明请求正确，返回Map信息
            if (accessToken != null){
                return parseObject;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }
    public static UserInfo getUserInfo(String openId, String accessToken){
        String url = new StringBuilder(WECHATUSERINFO).append("?openid=").append(openId)
                .append("&access_token=").append(accessToken).toString();
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
            String resultJson = response.body().string();
            /**正确的返回信息
             * {
             * "openid":"OPENID",
             * "nickname":"NICKNAME",
             * "sex":1,
             * "province":"PROVINCE",
             * "city":"CITY",
             * "country":"COUNTRY",
             * "headimgurl": "http://wx.qlogo.cn/mmopen/g3MonUZtNHkdmzicIlibx6iaFqAc56vxLSUfpb6n5WKSYVY0ChQKkiaJSgQ1dZuTOgvLLrhJbERQQ4eMsv84eavHiaiceqxibJxCfHe/0",
             * "privilege":[
             * "PRIVILEGE1",
             * "PRIVILEGE2"
             * ],
             * "unionid": " o6_bmasdasdsad6_2sgVt7hMZOPfL"
             * }
             */
            JSONObject parseObject = JSONObject.parseObject(resultJson, JSONObject.class);
            String id = (String)parseObject.get("openid");
            //成功获取用户信息
            if (id != null){
                String nickname = (String)parseObject.get("nickname");
                Integer sex = (Integer)parseObject.get("sex");
                String province = (String)parseObject.get("province");
                String city = (String)parseObject.get("city");
                String headimgurl = (String)parseObject.get("headimgurl");
                UserInfo user = new UserInfo();
                user.setNikeName(nickname);
                user.setOpenId(openId);
                user.setUserImg(headimgurl);
                //这里只选了三个字段，根据自己的业务选择更多的字段
                return user;
            }
        }catch (Exception e){
            e.printStackTrace();
        }
        return null;
    }


}
