package edu.scau.mis;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MisBootApplication {
    public static void main(String[] args) {
        // 启动Swing界面,OOAD课程演示使用, 需启用SaleFrame的Component注解

        /** SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
            }
        });
         */

         SpringApplication.run(MisBootApplication.class, args);

    }
}