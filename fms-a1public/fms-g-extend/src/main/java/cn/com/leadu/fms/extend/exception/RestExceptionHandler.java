/*
 * Project Name : fb-microservice-biz
 * File Name : RestExceptionHandler.java
 * Date : 17-10-29 下午10:49
 * Author : qiao
 * Copyright (c) 2017, Feng Bang Leasing(Shang Hai)Co.,Ltd. All Rights Re
 * served.
 */

package cn.com.leadu.fms.extend.exception;

import cn.com.leadu.fms.common.exception.FmsRedisKeyNotFoundException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.RandomUtils;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.ResponseFailEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;
import java.util.List;
import java.util.Set;

/**
 * @author qiaohao
 * @ClassName: RestExceptionHandler
 * @Description: Rest异常处理
 * @date 2017/10/30
 */
@RefreshScope
@ControllerAdvice(annotations = RestController.class)
public class RestExceptionHandler {

	@Value("${syserror.showcode}")
	private String SHOWCODE;

	private static final Logger LOGGER = LoggerFactory.getLogger(RestExceptionHandler.class);

	@ExceptionHandler
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	private ResponseEntity<RestResponse> runtimeExceptionHandler(Exception e) {
		String code = get4RandomCode();
		LOGGER.error(">>>>>>>>>>>Exception[{}]<<<<<<<<<<<<:{}", code, e.getMessage(), e);
		return new ResponseEntity<>(
				RestResponseGenerator.genFailResponse(ResponseEnums.FAILURE, e.getMessage(), getMessage("请求失败", code)),
				HttpStatus.OK);
	}


	@ExceptionHandler(FmsServiceException.class)
	@ResponseStatus(HttpStatus.OK)
	@ResponseBody
	private ResponseEntity<RestResponse> serviceExceptionHandler(FmsServiceException e) {
		String code = get4RandomCode();
		LOGGER.error(">>>>>>>>>>>FmsServiceException[{}]<<<<<<<<<<<<:{}", code, e.getMessage(), e);
		return new ResponseEntity<>(RestResponseGenerator.genFailResponse(ResponseFailEnums.BIZ_CHECK_ERROR,
				getMessage(e.getMessage(), code)), HttpStatus.OK);
	}

	@ExceptionHandler(MethodArgumentNotValidException.class)
	@ResponseBody
	private ResponseEntity<RestResponse> illegalPostParamsExceptionHandler(MethodArgumentNotValidException e) {
		String code = get4RandomCode();
		List<FieldError> errors = e.getBindingResult().getFieldErrors();
		StringBuffer sb = new StringBuffer();
		errors.forEach(item -> sb.append(item.getDefaultMessage()).append(","));
		LOGGER.error(">>>>>>>>>>>MethodArgumentNotValidException[{}]<<<<<<<<<<<<:{}", code,
				sb.substring(0, sb.length() - 1), e);
		return new ResponseEntity<>(RestResponseGenerator.genFailResponse(ResponseFailEnums.PARAM_CHECK_ERROR,
				getMessage(sb.substring(0, sb.length() - 1), code)), HttpStatus.OK);
	}

	@ExceptionHandler(ConstraintViolationException.class)
	@ResponseBody
	private ResponseEntity<RestResponse> illegalGetParamsExceptionHandler(ConstraintViolationException e) {
		String code = get4RandomCode();
		Set<ConstraintViolation<?>> set = e.getConstraintViolations();
		StringBuffer sb = new StringBuffer();
		set.forEach(item -> sb.append(item.getMessageTemplate()).append(","));
		LOGGER.error(">>>>>>>>>>>ConstraintViolationException[{}]<<<<<<<<<<<<:{}", code,
				sb.substring(0, sb.length() - 1), e);
		return new ResponseEntity<>(RestResponseGenerator.genFailResponse(ResponseFailEnums.PARAM_CHECK_ERROR,
				getMessage(sb.substring(0, sb.length() - 1), code)), HttpStatus.OK);
	}

	@ExceptionHandler(FmsRedisKeyNotFoundException.class)
	@ResponseBody
	private ResponseEntity<RestResponse> verifyCodeSendExceptionHandler(FmsRedisKeyNotFoundException e) {
		String code = get4RandomCode();
		LOGGER.error(">>>>>>>>>>>FmsRedisKeyNotFoundException{}]<<<<<<<<<<<<:-{}-{}", code, e.getMessage(),
				e.getRedisKey());
		return new ResponseEntity<>(RestResponseGenerator.genFailResponse(ResponseFailEnums.BIZ_CHECK_ERROR,
				e.getMessage(), getMessage("请求失败", code)), HttpStatus.OK);
	}


    private String get4RandomCode() {
        // 产生一个4位随机数
        return String.valueOf(RandomUtils.getRandNum(1000, 9999));
    }

    private String getMessage(String msg, String code) {
        if ("Y".equals(SHOWCODE)) {
            return "(" + code + ")" + msg;
        } else {
            return msg;
        }
    }

}
