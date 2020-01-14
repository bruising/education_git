package com.example.demoswg.service;

import org.springframework.stereotype.Component;

import javax.websocket.*;
import javax.websocket.server.ServerEndpoint;
import java.util.concurrent.CopyOnWriteArrayList;

/**
 * @author 李陈
 * @version V1.0
 * @Project: demoswg
 * @Package com.example.demoswg.service
 * @date 2020/1/10 10:49 星期五
 */
@ServerEndpoint("/lc")
@Component//泛指组件，当组件不好归类的时候，我们可以使用这个注解进行标注。
public class WebSocket {
    private Session session;
    private  static CopyOnWriteArrayList<WebSocket> webSockets=new CopyOnWriteArrayList<>();
    @OnOpen
    public void onOpen(Session session){
        this.session=session;
        webSockets.add(this);
        System.out.println("连上一个，现在总共有:"+webSockets.size()+"个连接");

    }
    @OnClose
    public  void onClose(){
       webSockets.remove(this);
       System.out.println("关闭了一个，现在总共有："+ webSockets.size()+"个连接");
    }
    @OnMessage
    public void onMessage(String message){
        for (WebSocket webSocket:webSockets){
            try{
                webSocket.session.getBasicRemote().sendText(message);
            }catch (Exception e){
                e.printStackTrace();
            }
        }
    }
    @OnError
    public  void onError(Throwable throwable){
        System.out.println("error");
    }
}
