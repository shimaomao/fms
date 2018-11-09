package cn.com.leadu.fms.webclient.system.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.syswidget.SysWidgetVo;
import cn.com.leadu.fms.webclient.system.rpc.SysWidgetRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.Map;

/**
 * @author wangxue
 * @ClassName: SysWidgetController
 * @Description: 画面控件管理controller
 * @date 2018-03-09
 */
@RestController
@RequestMapping("sys_widget")
public class SysWidgetController {

    /**
     * @Fields  : 画面控件管理rpc
     */
    @Autowired
    private SysWidgetRpc sysWidgetRpc;

    /**
     * @Title:
     * @Description: 分页查询画面控件管理信息
     * @param sysWidgetVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 16:31:25
     */
    @RequestMapping(value = "findSysWidgetsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysWidgetsByPage(SysWidgetVo sysWidgetVo){
        Map sysWidgetVoMap = sysWidgetVo == null?null:(Map) JSON.toJSON(sysWidgetVo);
        return sysWidgetRpc.findSysWidgetsByPage(sysWidgetVoMap);
    }

}
