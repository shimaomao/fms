package cn.com.leadu.fms.oauth2.common.constant;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Component;

@Component
@RefreshScope
@Getter
public class TokenConstants {

	@Value("${send.message.flag:N}")
	private String sendMsgFlag;

	//token.time.seconds.access:1 1是一分钟
	@Value("${token.time.seconds.access:1}")
	private Integer tokenTimeSecondsAccess;

	@Value("${token.time.seconds.refresh:2}")
	private Integer tokenTimeSecondsRefresh;

}
