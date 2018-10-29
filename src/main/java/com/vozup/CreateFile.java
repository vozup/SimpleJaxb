package com.vozup;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CreateFile {
    public void create(String fileName) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 500; i++) {
            list.add(i + "\n");
        }

        String full = "";

        for (String s :
                list) {
            full += s;
        }

        System.out.println(full);
    }

}
