package com.xuanss.pgo.admin.message;

import com.aliyuncs.dysmsapi.model.v20170525.SendSmsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuhang
 * @package com.yuexiang.message
 * @data 2018-9-21 11:04
 */
@Component
public class MessageListener {

    @Autowired
    private MessageSender messageSender;
    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    @JmsListener(destination = "sms_pgo")
    public void readMessage(Map<String,String> dataMap) throws Exception {
        //取出消息队列订阅数据
        String mobile = dataMap.get("mobile");
        String signName = dataMap.get("signName");
        String templateCode = dataMap.get("templateCode");
        String param = dataMap.get("param");

        SendSmsResponse response = messageSender.sendSms(mobile, signName, templateCode, param);

        System.out.println("短信接口返回的数据----------------");
        System.out.println("Code=" + response.getCode());
        System.out.println("Message=" + response.getMessage());
        System.out.println("RequestId=" + response.getRequestId());
        System.out.println("BizId=" + response.getBizId());

        //发送短信接口返回数据到消息队列
        Map<String,String> Map = new HashMap<String, String>();

        dataMap.put("Code", response.getCode());
        dataMap.put("Message",response.getMessage());
        dataMap.put("RequestId", response.getRequestId());
        dataMap.put("BizId", response.getBizId());

        jmsMessagingTemplate.convertAndSend("sms_result", dataMap);
    }
}
