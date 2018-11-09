package cn.com.leadu.fms.webclient.baseinfo.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.basbankinfo.BasBankInfoVo;
import cn.com.leadu.fms.webclient.baseinfo.rpc.BasBankInfoRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * @author yanfengbo
 * @ClassName: BasBankInfoController
 * @Description: 银行账号维护controller
 * @date 2018-03-26
 */
@RestController
@RequestMapping("bas_bank_info")
public class BasBankInfoController {

    /**
     * @Fields  : 银行账号维护rpc
     */
    @Autowired
    private BasBankInfoRpc basBankInfoRpc;

    /**
     * @Title:
     * @Description: 分页查询银行账号维护信息
     * @param basBankInfoVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "findBasBankInfosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasBankInfosByPage(BasBankInfoVo basBankInfoVo){
        Map basBankInfoVoMap = basBankInfoVo == null?null:(Map) JSON.toJSON(basBankInfoVo);
        return basBankInfoRpc.findBasBankInfosByPage(basBankInfoVoMap);
    }

    /**
     * @Title:
     * @Description: 保存银行账号维护
     * @param basBankInfoVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "saveBasBankInfo",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBasBankInfo(@RequestBody BasBankInfoVo basBankInfoVo){
        return basBankInfoRpc.saveBasBankInfo(basBankInfoVo);
    }

    /**
     * @Title:
     * @Description:  修改银行账号维护
     * @param basBankInfoVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "modifyBasBankInfo",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyBasBankInfo(@RequestBody BasBankInfoVo basBankInfoVo){
        return basBankInfoRpc.modifyBasBankInfo(basBankInfoVo);
    }

    /**
     * @Title:
     * @Description:   根据bankId集合删除银行账号维护
     * @param bankIds
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "deleteBasBankInfosByBankIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasBankInfosByBankIds(@RequestBody List<String> bankIds){
        BasBankInfoVo basBankInfoVo = new BasBankInfoVo();
        basBankInfoVo.setBankIds(bankIds);
        return basBankInfoRpc.deleteBasBankInfosByBankIds(basBankInfoVo);
    }

    /**
     * @Title:
     * @Description:  根据bankId获取银行账号维护
     * @param bankId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "findBasBankInfoByBankId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasBankInfoByBankId(String bankId,String serviceId){
        return basBankInfoRpc.findBasBankInfoByBankId(bankId,serviceId);
    }

    /**
     * @Title:
     * @Description: 银行账号维护审核通过
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "approval",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> approval(@RequestBody BasBankInfoVo basBankInfoVo){
        return basBankInfoRpc.approval(basBankInfoVo);
    }

    /**
     * @Title:
     * @Description: 银行账号维护审核退回
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "sendBack",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> sendBack(@RequestBody BasBankInfoVo basBankInfoVo){
        return basBankInfoRpc.sendBack(basBankInfoVo);
    }

}
