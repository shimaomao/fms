/*
 * Project Name : fb-microservice-biz
 * File Name : ExceptionController.java
 * Date : 17-12-22 下午11:26
 * Author : luxin
 * Copyright (c) 2017, Feng Bang Leasing(Shang Hai)Co.,Ltd. All Rights Re
 * served.
 */

package cn.com.leadu.fms.agent.controller;

import cn.com.leadu.fms.common.util.RandomUtils;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.ResponseFailEnums;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.web.ErrorAttributes;
import org.springframework.boot.autoconfigure.web.ErrorController;
import org.springframework.boot.autoconfigure.web.ErrorProperties;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.Assert;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.context.request.RequestAttributes;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@RefreshScope
@Controller
@RequestMapping(value = "error")
//@EnableConfigurationProperties({ ServerProperties.class })
public class ExceptionController implements ErrorController {

	private static final Logger LOGGER = LoggerFactory.getLogger(ExceptionController.class);

	private ErrorAttributes errorAttributes;

	@Autowired
	private ServerProperties serverProperties;

	@Value("${syserror.showcode}")
	private String SHOWCODE;

	/**
	 * 初始化ExceptionController
	 * 
	 * @param errorAttributes
	 */
	@Autowired
	public ExceptionController(ErrorAttributes errorAttributes) {
		Assert.notNull(errorAttributes, "ErrorAttributes must not be null");
		this.errorAttributes = errorAttributes;
	}

	// /**
	// * 定义404的ModelAndView
	// * @param request
	// * @param response
	// * @return
	// */
	// @RequestMapping(produces = "text/html",value = "404")
	// public ModelAndView errorHtml404(HttpServletRequest request,
	// HttpServletResponse response) {
	// response.setStatus(getStatus(request).value());
	// Map<String, Object> model = getErrorAttributes(request,
	// isIncludeStackTrace(request, MediaType.TEXT_HTML));
	// return new ModelAndView("error/404", model);
	// }

	/**
	 * 定义400的JSON数据
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "400")
	@ResponseBody
	public ResponseEntity error400(HttpServletRequest request) {
		Map<String, Object> body = getErrorAttributes(request,
				isIncludeStackTrace(request, MediaType.APPLICATION_JSON));
		String code = get4RandomCode();
		return new ResponseEntity<>(
				RestResponseGenerator.genFailResponse(ResponseFailEnums.RESOURCE_ACCESS_ERROR,body, getMessage("请求参数错误", code)), HttpStatus.OK);

	}

	/**
	 * 定义401的JSON数据
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "401")
	@ResponseBody
	public ResponseEntity error401(HttpServletRequest request) {
		Map<String, Object> body = getErrorAttributes(request,
				isIncludeStackTrace(request, MediaType.APPLICATION_JSON));
		String code = get4RandomCode();
		return new ResponseEntity<>(
				RestResponseGenerator.genFailResponse(ResponseFailEnums.OAUTH2_ERROR,body,getMessage("权限异常", code)), HttpStatus.OK);
	}

	/**
	 * 定义404的JSON数据
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "404")
	@ResponseBody
	public ResponseEntity error404(HttpServletRequest request) {
		Map<String, Object> body = getErrorAttributes(request,
				isIncludeStackTrace(request, MediaType.APPLICATION_JSON));
		String code = get4RandomCode();
		return new ResponseEntity<>(
				RestResponseGenerator.genFailResponse(ResponseFailEnums.RESOURCE_ACCESS_ERROR,body,getMessage("资源未找到", code)), HttpStatus.OK);
	}

	/**
	 * 定义405的JSON数据
	 *
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "405")
	@ResponseBody
	public ResponseEntity error405(HttpServletRequest request) {
		Map<String, Object> body = getErrorAttributes(request,
				isIncludeStackTrace(request, MediaType.APPLICATION_JSON));
		String code = get4RandomCode();
		return new ResponseEntity<>(
				RestResponseGenerator.genFailResponse(ResponseFailEnums.RESOURCE_ACCESS_ERROR,body,getMessage("请求类型错误", code)), HttpStatus.OK);
	}


	/**
	 * 定义500的错误JSON信息
	 * 
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "500")
	@ResponseBody
	public ResponseEntity error500(HttpServletRequest request) {
		Map<String, Object> body = getErrorAttributes(request, isIncludeStackTrace(request, MediaType.APPLICATION_JSON));
		String code = get4RandomCode();
		if(body.containsKey("message") && body.containsKey("exception")){
			if(body.get("message").toString().equals("400 ")||
					body.get("message").toString().equals("500 ")){
				return new ResponseEntity<>(
						RestResponseGenerator.genFailResponse(ResponseFailEnums.TOKEN_INVALID, body,getMessage("无效token", code)), HttpStatus.OK);
			}
			if(body.get("message").toString().equals("GENERAL")){
				return new ResponseEntity<>(
						RestResponseGenerator.genFailResponse(ResponseFailEnums.RESOURCE_ACCESS_ERROR, body,getMessage("服务状态异常", code)), HttpStatus.OK);
			}
		}
		return new ResponseEntity<>(
				RestResponseGenerator.genFailResponse(ResponseEnums.FAILURE,body,getMessage("请求失败", code)), HttpStatus.OK);

	}

	/**
	 * Determine if the stacktrace attribute should be included.
	 * 
	 * @param request
	 *            the source request
	 * @param produces
	 *            the media type produced (or {@code MediaType.ALL})
	 * @return if the stacktrace attribute should be included
	 */
	protected boolean isIncludeStackTrace(HttpServletRequest request, MediaType produces) {
		ErrorProperties.IncludeStacktrace include = this.serverProperties.getError().getIncludeStacktrace();
		if (include == ErrorProperties.IncludeStacktrace.ALWAYS) {
			return true;
		}
		if (include == ErrorProperties.IncludeStacktrace.ON_TRACE_PARAM) {
			return getTraceParameter(request);
		}
		return false;
	}

	/**
	 * 获取错误的信息
	 * 
	 * @param request
	 * @param includeStackTrace
	 * @return
	 */
	private Map<String, Object> getErrorAttributes(HttpServletRequest request, boolean includeStackTrace) {
		RequestAttributes requestAttributes = new ServletRequestAttributes(request);
		return this.errorAttributes.getErrorAttributes(requestAttributes, includeStackTrace);
	}

	/**
	 * 是否包含trace
	 * 
	 * @param request
	 * @return
	 */
	private boolean getTraceParameter(HttpServletRequest request) {
		String parameter = request.getParameter("trace");
		if (parameter == null) {
			return false;
		}
		return !"false".equals(parameter.toLowerCase());
	}

	/**
	 * 获取错误编码
	 * 
	 * @param request
	 * @return
	 */
	private HttpStatus getStatus(HttpServletRequest request) {
		Integer statusCode = (Integer) request.getAttribute("javax.servlet.error.status_code");
		if (statusCode == null) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
		try {
			return HttpStatus.valueOf(statusCode);
		} catch (Exception ex) {
			return HttpStatus.INTERNAL_SERVER_ERROR;
		}
	}

	/**
	 * 实现错误路径,暂时无用
	 * 
	 * @return
	 */
	@Override
	public String getErrorPath() {
		return "";
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