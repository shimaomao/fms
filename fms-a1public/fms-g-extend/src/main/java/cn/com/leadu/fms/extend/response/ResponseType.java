/*
 * Project Name : fb-microservice-biz
 * File Name : ResponseType.java
 * Date : 17-10-30 上午11:00
 * Author : qiaohao
 * Copyright (c) 2017, Feng Bang Leasing(Shang Hai)Co.,Ltd. All Rights Re
 * served.
 */

package cn.com.leadu.fms.extend.response;

/**
 * @ClassName: ResponseType
 * @Description: 响应类型接口
 * @author qiaohao
 * @date 2017/10/30
 */
public interface ResponseType {

    /**
     * @Title: getCode
     * @Description: 返回编码
     * @param
     * @return java.lang.String
     * @throws
     * @author qiaohao
     * @date 2017/10/30 11:11:44
     */
    String getCode();

   /**
    * @Title: getMessage
    * @Description: 返回消息
    * @param
    * @return java.lang.String
    * @throws
    * @author qiaohao
    * @date 2017/10/30 11:11:44
    */
    String getMessage();

    /**
     * @Title: getMark
     * @Description: 返回标识
     * @param
     * @return java.lang.String
     * @throws
     * @author qiaohao
     * @date 2017/10/30 11:11:44
     */
    String getMark();

}
