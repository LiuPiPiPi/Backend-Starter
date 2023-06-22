package com.lpxz.cmsauth.service;

import cn.hutool.core.util.RandomUtil;
import com.aliyuncs.CommonRequest;
import com.aliyuncs.CommonResponse;
import com.aliyuncs.DefaultAcsClient;
import com.aliyuncs.IAcsClient;
import com.aliyuncs.exceptions.ClientException;
import com.aliyuncs.http.MethodType;
import com.aliyuncs.profile.DefaultProfile;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @author LPxz
 * @date 2023/6/14
 */
@Service
public class AuthService {

    private final static String REDIS_PREFIX_TOKEN_USERINFO = "green:auth:token:info:";
    private final static long expire = 60 * 60 * 2;

    private final static String REDIS_PREFIX_PHONE_CODE_AUTH = "green:auth:phone:code:";
    private final static long phone_expire = 60 * 5;

    @Value("${aliyun.accessKeyId}")
    private String accessKeyId;

    @Value("${aliyun.accessKeySecret}")
    private String accessKeySecret;

    @Autowired
    private RedisService redisService;

    /**
     * 根据手机号发送验证码
     *
     * @param phone
     */
    public void sendCode(String phone) {
        String code = RandomUtil.randomNumbers(4);
        registerCode(code, phone);
        send(code, phone);
    }

    private void send(String code, String phone) {
        System.out.println(accessKeyId);
        DefaultProfile profile = DefaultProfile.getProfile("cn-hangzhou", accessKeyId, accessKeySecret);
        IAcsClient client = new DefaultAcsClient(profile);

        CommonRequest request = new CommonRequest();
        request.setSysMethod(MethodType.POST);
        request.setSysDomain("dysmsapi.aliyuncs.com");
        request.setSysVersion("2017-05-25");
        request.setSysAction("SendSms");
        request.putQueryParameter("RegionId", "cn-hangzhou");
        request.putQueryParameter("PhoneNumbers", phone);
        request.putQueryParameter("SignName", "碳排放计算系统");
        request.putQueryParameter("TemplateCode", "SMS_280085766");
        request.putQueryParameter("TemplateParam", "{\"code\":\"" + code + "\"}");
        try {
            CommonResponse response = client.getCommonResponse(request);
            System.out.println(response.getData());
        } catch (ClientException e) {
            e.printStackTrace();
        }
    }

    /**
     * 注册手机号和对应的验证码
     *
     * @param code
     * @param phone
     */
    private void registerCode(String code, String phone) {
        String key = REDIS_PREFIX_PHONE_CODE_AUTH + phone;
        redisService.set(key, code, phone_expire);
    }

    /**
     * @param code  用户自己输入的code
     * @param phone 手机号
     * @return true false 是否匹配 5min
     */
    public boolean verifyCode(String code, String phone) {
        String key = REDIS_PREFIX_PHONE_CODE_AUTH + phone;
        Object v = redisService.get(key);
        return v != null && v.equals(code);
    }
}
