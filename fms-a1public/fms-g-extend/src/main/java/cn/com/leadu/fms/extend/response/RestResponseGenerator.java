/*
 * Project Name : fb-microservice-biz
 * File Name : RestResultGenerator.java
 * Date : 17-10-30 上午10:51
 * Author : qiaohao
 * Copyright (c) 2017, Feng Bang Leasing(Shang Hai)Co.,Ltd. All Rights Re
 * served.
 */

package cn.com.leadu.fms.extend.response;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * @ClassName: RestResponseGenerator
 * @Description: Rest响应生成器
 * @author qiaohao
 * @date 2017/10/30
 */
public class RestResponseGenerator {

    private static final Logger LOGGER = LoggerFactory.getLogger(RestResponseGenerator.class);

    /**
     * @Title: genResponse
     * @Description:
     * @param responseType
     * @param data
     * @param message
     * @return cn.net.leadu.fb.microservice.extend.common.response.RestResponse<T>
     * @throws
     *
     * @author qiaohao
     * @date 2017/10/30 03:35:53
     */
    public static <T> RestResponse<T> genResponse(ResponseType responseType, T data, String message) {
        RestResponse<T> result = RestResponse.newInstance();
        result.setCode(responseType.getCode());
        result.setData(data);
        result.setMessage(message);
        if (LOGGER.isDebugEnabled()) {
            LOGGER.debug("generate rest result:{}", result);
        }
        return result;
    }

    /**
     * @Title: genSuccessResponse
     * @Description: 返回成功响应(有数据返回)
     * @param data
     * @return cn.net.leadu.fb.microservice.extend.common.response.RestResponse<T>
     * @throws
     *
     * @author qiaohao
     * @date 2017/10/30 01:04:16
     */
    public static <T> RestResponse<T> genSuccessResponse(T data) {
        return genResponse(ResponseEnums.SUCCESS, data, ResponseEnums.SUCCESS.getMessage());
    }

    /**
     * @Title: genSuccessResponse
     * @Description: 返回成功响应（无数据返回））
     * @param
     * @return cn.net.leadu.fb.microservice.extend.common.response.RestResponse
     * @throws
     *
     * @author qiaohao
     * @date 2017/10/30 01:04:43
     */
    public static RestResponse genSuccessResponse() {
        return genSuccessResponse(null);
    }

    /**
     * @Title: genFailResponse
     * @Description: 返回失败响应(不知道具体原因,带自定义message)
     * @param message
     * @return cn.net.leadu.fb.microservice.extend.common.response.RestResponse<T>
     * @throws
     *
     * @author qiaohao
     * @date 2017/10/30 02:30:53
     */
    public static <T> RestResponse<T> genFailResponse(String message) {
        return genResponse(ResponseEnums.FAILURE, null, message);
    }

    /**
     * @Title: genFailResponse
     * @Description: 返回失败响应(知道具体原因)
     * @param responseType
     * @return cn.net.leadu.fb.microservice.extend.common.response.RestResponse<T>
     * @throws
     *
     * @author qiaohao
     * @date 2017/10/30 03:33:06
     */
    public static <T> RestResponse<T> genFailResponse(ResponseType responseType) {
        return genResponse(responseType,null,responseType.getMessage());
    }

    /**
     * @Title: genFailResponse
     * @Description: 返回失败响应(知道具体原因,带自定义message)
     * @param responseType
     * @param message
     * @return cn.net.leadu.fb.microservice.extend.common.response.RestResponse<T>
     * @throws
     *
     * @author qiaohao
     * @date 2017/10/30 03:33:17
     */
    public static <T> RestResponse<T> genFailResponse(ResponseType responseType,String message) {
        return genResponse(responseType,null,message);
    }

    /**
     * @Title: genFailResponse
     * @Description: 返回失败响应(知道具体原因,带自定义message)
     * @param responseType
     * @param data
     * @param message
     * @return cn.net.leadu.fb.microservice.extend.common.response.RestResponse<T>
     * @throws
     *
     * @author qiaohao
     * @date 2017/10/30 03:33:17
     */
    public static <T> RestResponse<T> genFailResponse(ResponseType responseType,T data,String message) {
        return genResponse(responseType,data,message);
    }


}
