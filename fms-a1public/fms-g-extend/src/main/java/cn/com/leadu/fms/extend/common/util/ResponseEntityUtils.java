package cn.com.leadu.fms.extend.common.util;

import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.ResponseFailEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * Created by qiaohao on 2017/10/23.
 */
public class ResponseEntityUtils {

	private static final Logger LOGGER = LoggerFactory.getLogger(ResponseEntityUtils.class);


	/**
	 * @Title: getRestResponseData
	 * @Description:调用微服务获取返回对象
	 * @param responseEntity
	 * @return T
	 * @throws FmsRpcException
	 *             微服务调用异常
	 *
	 * @author qiaohao
	 * @date 2017/11/13 10:27:14
	 */
	public static <T> T getRestResponseData(ResponseEntity<RestResponse<T>> responseEntity) throws FmsRpcException {
		if (responseEntity == null) {
			throw new FmsRpcException("RPC调用异常,未获取响应对象");
		}
		if (responseEntity.getStatusCode() != HttpStatus.OK) {
			throw new FmsRpcException(responseEntity.getStatusCode(), "RPC调用HTTP状态码异常");
		}
		if (!StringUtils.equals(responseEntity.getBody().getCode(), ResponseEnums.SUCCESS.getCode())) {
			String errorMsg = responseEntity.getBody().getMessage();
			if(StringUtils.equals(responseEntity.getBody().getCode(), ResponseFailEnums.BIZ_CHECK_ERROR.getCode())){
				throw new FmsServiceException(errorMsg);
			}
			if (StringUtils.isNotBlank(errorMsg)) {
				LOGGER.error("the rpc error is {}", errorMsg);
				throw new FmsRpcException(errorMsg, responseEntity.getBody().getCode());
			}
			throw new FmsRpcException("RPC调用状态异常", responseEntity.getBody().getCode());
		}
		return responseEntity.getBody().getData();
	}

}
