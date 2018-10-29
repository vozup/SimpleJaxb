package com.vozup.service;

import javax.jws.WebService;

@WebService
public interface MySoapService {
    String getHelloString(String name);
    String getDate();
    boolean downloadOnServer(String fileName, int fileSize, byte[] bytes, int bufSize);
    boolean uploadFromServer(String fileName);
}
