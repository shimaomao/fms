package cn.com.leadu.fms.webclient.oauth2.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.sysuser.SysUserLoginVo;
import cn.com.leadu.fms.webclient.config.WebClientProperties;
import cn.com.leadu.fms.webclient.oauth2.rpc.Oauth2Rpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.UnsupportedEncodingException;

/**
 * @author qiaomengnan
 * @ClassName: Oauth2Controller
 * @Description: 获取token结构
 * @date 2018/1/9
 */
@RestController
@RequestMapping("oauth2")
public class Oauth2Controller {

    /**
     * @Fields : 鉴权rpc
     */
    @Autowired
    private Oauth2Rpc oauth2Rpc;

    /**
     * @Fields : 项目文件配置
     */
    @Autowired
    private WebClientProperties webClientProperties;

    /**
     * @Title:
     * @Description:  用户通过账户密码登录获取token
     * @param sysUserLoginVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/09 12:12:02
     */
    @RequestMapping(value = "get_token" , method = RequestMethod.POST)
    public ResponseEntity<RestResponse> getToken(@RequestBody SysUserLoginVo sysUserLoginVo) throws UnsupportedEncodingException{
        return oauth2Rpc.oauthToken(webClientProperties.getGrantType(),
                sysUserLoginVo.getUser(),
                sysUserLoginVo.getUserPassword(),
                sysUserLoginVo.getCode(),
                sysUserLoginVo.getTimeStamp(),
                webClientProperties.getBasic());

    }

    /**
     * @Title:
     * @Description:  根据时间戳获取登录验证码，
     * @param timeStamp 时间戳
     * @return
     * @throws
     * @author wangxue
     * @date 2018/03/19 09:47:25
     */
    @RequestMapping(value = "findCodeByTimeStamp", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCodeByTimeStamp(String timeStamp){
        return oauth2Rpc.findCodeByTimeStamp(timeStamp);
    }

}
