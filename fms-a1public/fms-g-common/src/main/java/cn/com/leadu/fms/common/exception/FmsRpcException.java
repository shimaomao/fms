package cn.com.leadu.fms.common.exception;

import org.springframework.http.HttpStatus;

/**
 * @author qiaomengnan
 * @ClassName: FmsRpcException
 * @Description: Rpc微服务调用异常
 * @date 2018/1/7
 */

public class FmsRpcException extends FmsException {

	private HttpStatus httpStatus;

	/**
	 * @Fields 自定义的响应码类型 :
	 */
	private String responseCode;

	public FmsRpcException(String msg) {
		super(msg);
	}

	public FmsRpcException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public FmsRpcException(String msg, String responseCode) {
		this(HttpStatus.OK,msg);
		this.responseCode = responseCode;
	}

	public FmsRpcException(String msg, String responseCode, Throwable cause) {
		super(msg, cause);
		this.responseCode = responseCode;
	}

	public FmsRpcException(HttpStatus httpStatus, String msg) {
		super(msg);
		this.httpStatus = httpStatus;
	}

	public FmsRpcException(HttpStatus httpStatus, String msg, Throwable cause) {
		super(msg, cause);
		this.httpStatus = httpStatus;
	}

	public HttpStatus getHttpStatus() {
		return httpStatus;
	}

	public String getResponseCode() {
		return responseCode;
	}
}
