package cn.com.leadu.fms.business.service;

import java.util.Map;

/**
 * @program: fms
 * @description: 地址共同service
 * @author: yangyiquan
 * @create: 2018-06-12 19:40
 **/
public interface BasAreaNameService {
    /** 
    * @Description: 查询所有地址编码和名字
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/12 19:44
    */ 
     Map<String,String> getBasAreaCodeAndName();
}
