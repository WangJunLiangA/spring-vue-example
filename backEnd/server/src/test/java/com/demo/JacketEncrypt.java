package com.demo;

import org.jasypt.encryption.StringEncryptor;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

/**
 * @Description properties文件数据库信息加密
 * @Author WangJunLiang
 * @Date 2022/1/13 15:13
 **/
@SpringBootTest
public class JacketEncrypt {

    @Autowired
    StringEncryptor encryptor;

    @Test
    public void jacketEncrypt(){
        //加密
        String url=encryptor.encrypt("jdbc:mysql://localhost:3306/example?useUnicode=true&characterEncoding=UTF-8&serverTimezone=UTC");
        String name = encryptor.encrypt("root");
        String password = encryptor.encrypt("12345678");
        System.out.println("name 密文: " + name);
        System.out.println("password 密文: " + password);
        System.out.println("url 密文: " + url);

        //解密
        String decrypt1 = encryptor.decrypt(name);
        String decrypt2 = encryptor.decrypt(password);
        System.out.println(decrypt1 + "------------" + decrypt2);
    }
}