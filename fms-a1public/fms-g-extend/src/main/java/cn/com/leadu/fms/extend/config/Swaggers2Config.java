package cn.com.leadu.fms.extend.config;

import org.springframework.context.annotation.Bean;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;

/**
 * @author qiaomengnan
 * @ClassName: Swaggers2Config
 * @Description: 开启rest api接口文档
 * @date 2018/1/7
 */

//@Configuration
//@EnableSwagger2
public class Swaggers2Config {

	@Bean
	public Docket createRestApi() {
		return new Docket(DocumentationType.SWAGGER_2).apiInfo(apiInfo()).select()
				.apis(RequestHandlerSelectors.basePackage("cn.com.leadu")).paths(PathSelectors.any())
				.build();
	}

	private ApiInfo apiInfo() {
		return new ApiInfoBuilder().title("业务核心API接口")
				.description("业务核心API接口描述")
				.termsOfServiceUrl("http://www.leadu.com.cn/")
				.contact("leadu")
				.version("1.0")
				.build();
	}

	/*
	* controller 中使用
	@ApiOperation(value = "XXXX功能", notes = "功能描述")
	@ApiImplicitParams({
			@ApiImplicitParam(paramType = "query", name = "currentPage", value = "当前页数", required = true, dataType = "Integer")
	})

	@RequestMapping(value = "/list", method = RequestMethod.POST)
	public ResponseEntity<RestResponse<PageInfo>> getActsalUserList(@AuthUserInfo UserInfo userInfo,@Valid @RequestBody ActsalUserListVO actsalUserListVO) {
		PageInfo actsalUserVOS = actsalUserBusiness.getActsalUserList(userInfo.getAccountId(),actsalUserListVO,null);
		return new ResponseEntity<>(RestResponseGenerator.genSuccessResponse(actsalUserVOS), HttpStatus.OK);
	}

	*
	* */

}