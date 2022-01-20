package com.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Description 公共返回对象
 * @Author WangJunLiang
 * @Date 2022/1/19 11:05
 **/
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ResponseBean {
    private long code;
    private String message;
    private Object obj;

    /**
     * 成功返回结果
     * @param message
     * @return
     */
    public static ResponseBean success(String message){
        return new ResponseBean(200,message,null);
    }

    /**
     * 成功返回结果
     * @param message
     * @param obj
     * @return
     */
    public static ResponseBean success(String message,Object obj){
        return new ResponseBean(200,message,obj);
    }


    /**
     * 失败返回结果
     * @param message
     * @return
     */
    public static ResponseBean error(String message){
        return new ResponseBean(500,message,null);
    }

    /**
     * 失败返回结果
     * @param message
     * @param obj
     * @return
     */
    public static ResponseBean error(String message,Object obj){
        return new ResponseBean(500,message,obj);
    }
}