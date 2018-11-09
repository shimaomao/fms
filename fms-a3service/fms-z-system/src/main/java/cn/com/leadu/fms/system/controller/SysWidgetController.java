package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.vo.syswidget.SysWidgetVo;
import cn.com.leadu.fms.system.service.SysWidgetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxue
 * @ClassName: SysWidgetController
 * @Description: 画面控件管理相关接口
 * @date 2018-03-09
 */
@RestController
@RequestMapping("sys_widget")
public class SysWidgetController {

    /**
     * @Fields  : 画面控件管理service
     */
    @Autowired
    private SysWidgetService sysWidgetService;

    /**
     * @Title:
     * @Description: 分页查询画面控件管理信息
     * @param sysWidgetVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 16:31:24
     */
    @RequestMapping(value = "findSysWidgetsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysWidgetsByPage(SysWidgetVo sysWidgetVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(sysWidgetService.findSysWidgetsByPage(sysWidgetVo)),
                HttpStatus.OK);
    }

}
