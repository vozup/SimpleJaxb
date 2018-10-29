package com.vozup;

import com.sun.xml.internal.ws.client.PortInfo;
import com.vozup.service.MySoapService;

import javax.xml.namespace.QName;
import javax.xml.ws.Service;
import java.net.MalformedURLException;
import java.net.URL;

public class App {
    public static void main(String... args){
        // создаем ссылку на wsdl описание
        URL url = null;
        try {
            url = new URL("http://localhost:1986/wss/hello?wsdl");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

        // Параметры следующего конструктора смотрим в самом первом теге WSDL описания - definitions
        // 1-ый аргумент смотрим в атрибуте targetNamespace
        // 2-ой аргумент смотрим в атрибуте name
        QName qname = new QName("http://service.vozup.com/", "MySoapServiceImplService");

        // Теперь мы можем дотянуться до тега service в wsdl описании,
        Service service = Service.create(url, qname);
        WorkWithService workWithService = new WorkWithService(service);
        workWithService.downloadOnServer("E:\\JavaWorkspace\\SoapAppClient\\src\\main\\resources\\files\\file.txt");
        // а далее и до вложенного в него тега port, чтобы
        // получить ссылку на удаленный от нас объект веб-сервиса
//        MySoapService hello = service.getPort(MySoapService.class);
//
//        // Ура! Теперь можно вызывать удаленный метод
//        System.out.println(hello.getHelloString("Vozup"));
//        System.out.println(hello.getDate());
    }
}
