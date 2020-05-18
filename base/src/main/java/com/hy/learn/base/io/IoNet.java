package com.hy.learn.base.io;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URL;

/**
 * @author Created by hy
 * @date on 2020/5/18 13:37
 */
public class IoNet {

    public static void getNetContent() {
        try {
            URL url = new URL("http://www.baidu.com");
            InputStream inputStream = url.openConnection().getInputStream();
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream,"UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                // ... do something with line
                System.out.println(line);
            }
            bufferedReader.close();
        } catch (IOException e) {
            // ... handle IO exception
        }

    }
}
