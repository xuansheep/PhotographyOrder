package com.xuanss.pgo.admin.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.jms.core.JmsMessagingTemplate;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author xuhang
 * @package com.yuexiang.controller
 * @data 2018-9-21 10:36
 */
@RestController
@RequestMapping(value = "message")
public class QueueMessage {

    @Autowired
    private JmsMessagingTemplate jmsMessagingTemplate;

    private String resultCode;

    @RequestMapping(value = "send")
    public boolean sendMessage(String mobile){
        Map<String,String> dataMap = new HashMap<String, String>();

        dataMap.put("mobile", mobile);
        dataMap.put("signName", "Corgier");
        dataMap.put("templateCode", "SMS_145593462");
        dataMap.put("param", "{'code':"+""+(int)(Math.random()*10000)+"}");

        jmsMessagingTemplate.convertAndSend("sms_pgo", dataMap);

        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        while (true){
            if (resultCode!=null){
                break;
            }
        }
        if (resultCode.equals("OK")){
            return true;
        }
        return false;
    }

    @JmsListener(destination = "sms_result")
    public void readMessage(Map<String,String> resultMap){
        String code = resultMap.get("Code");
        resultCode = code;
    }
}
