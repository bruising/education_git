package com.example.demoswg.controller;

import com.example.demoswg.service.WebSocket;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author 李陈
 * @version V1.0
 * @Project: demoswg
 * @Package com.example.demoswg.controller
 * @date 2020/1/10 11:05 星期五
 */
@Controller
public class testController {
    @Autowired
    private WebSocket webSocket;

    @RequestMapping("/ws")
    @ResponseBody
    public void  ws(){
        webSocket.onMessage("aaaaaaaaaaaaaaa");
    }
}
