package cn.com.leadu.fms.thirdinterface.controller;

import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee.KingDeeCusVo;
import cn.com.leadu.fms.pojo.thirdinterface.vo.kingdee.KingDeeVchVo;
import cn.com.leadu.fms.thirdinterface.service.KingDeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: KingDeeController
 * @Description: 金蝶对接接口
 * @date 2018/7/17 0017
 */
@Validated
@RestController
@RequestMapping("king_dee")
public class KingDeeController {

    /**
     * @Fields  : 金蝶接口service
     * @author qiaomengnan
     */
    @Autowired
    private KingDeeService kingDeeService;

    /**
     * @Title:
     * @Description:   金蝶客户同步
     * @param kingDeeCusVos 客户信息
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/18 01:23:51
     */
    @RequestMapping(value = "kingDeeCus" ,method = RequestMethod.POST)
    public ResponseEntity<RestResponse> kingDeeCus(@Valid @RequestBody List<KingDeeCusVo> kingDeeCusVos){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(
                        kingDeeService.kingDeeCus(kingDeeCusVos)
                ),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   金蝶财务核算代码同步
     * @param kingDeeVchVos 核算代码信息
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/18 01:24:49
     */
    @RequestMapping(value = "kingDeeVoucher" ,method = RequestMethod.POST)
    public ResponseEntity<RestResponse> kingDeeVoucher(@Valid @RequestBody List<KingDeeVchVo> kingDeeVchVos){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(
                        kingDeeService.kingDeeVoucher(kingDeeVchVos)
                ),
                HttpStatus.OK);
    }

}
