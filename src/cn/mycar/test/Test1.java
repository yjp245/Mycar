package cn.mycar.test;

import cn.mycar.util.AliyunSms;
import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import com.aliyuncs.exceptions.ClientException;

/**
 * @author JP
 * @title: Test1
 * @projectName Mycar
 * @description:
 * @date 2019/4/16 0016
 */

public class Test1 {

    public static void main(String[] args) throws ClientException {
//13675027292
        AliyunSms .sendSmsMsg("13675027292","铁头生气啦，就是一颗要死的小白菜");
    }
}
