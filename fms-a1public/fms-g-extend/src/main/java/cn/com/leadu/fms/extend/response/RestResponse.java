/*
 * Project Name : fb-microservice-biz
 * File Name : RestResponse.java
 * Date : 17-10-30 上午10:51
 * Author : qiaohao
 * Copyright (c) 2017, Feng Bang Leasing(Shang Hai)Co.,Ltd. All Rights Re
 * served.
 */

package cn.com.leadu.fms.extend.response;

import lombok.Data;

/**
 * @ClassName: RestResponse
 * @Description: Rest统一相应数据
 * @author qiaohao
 * @date 2017/10/30
 */
@Data
public class RestResponse<T> {

    /**
     * @Fields  : 响应消息
     */
	private String message;
	/**
	 * @Fields  : 响应码
	 */
	private String code;
	/**
	 * @Fields  : 返回数据
	 */
	private T data;

	private RestResponse() {
	}

	public static <T> RestResponse<T> newInstance() {
		return new RestResponse<>();
	}

	@Override
	public String toString() {
		return "RestResponse{" + "code=" + code + ", message='" + message + '\'' + ", data=" + data + '}';
	}
}
