package com.vozup;

import com.sun.istack.internal.NotNull;
import com.vozup.service.MySoapService;

import javax.xml.ws.Service;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

public class WorkWithService {
    Service service;
    MySoapService mySoapService;

    WorkWithService(@NotNull Service service){
        this.service = service;
        this.mySoapService = service.getPort(MySoapService.class);
    }

    public void downloadOnServer(String filePath){
        System.out.println("Client");
        int fileSize;
        try {
            FileInputStream file =
                    new FileInputStream(filePath);
            fileSize = file.available();

            System.out.printf("File size: %d bytes \n", fileSize);

            byte[] buf = new byte[256];
            int c;
            while((c = file.read(buf))>0){
                mySoapService.downloadOnServer("hello.txt", fileSize, buf, 256);
                if(c < 256){
                    buf = Arrays.copyOf(buf, c);
                }
                System.out.println(buf.length);

            }


        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e){
            e.printStackTrace();
        }
    }


}
