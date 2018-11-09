package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.annualinspection.AnnualInspectionVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.AnnualInspectionRpc;
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
 * @author qinmuqiao
 * @ClassName: AnnualInspectionController
 * @Description: 年检提醒controller
 */
@RestController
@RequestMapping("annual_inspection")
public class AnnualInspectionController {

    /**
     * @Fields  : 年检提醒rpc
     */
    @Autowired
    private AnnualInspectionRpc annualInspectionRpc;

    /**
     * @Title:
     * @Description: 分页查询年检提醒信息
     * @param annualInspectionVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @RequestMapping(value = "findAnnualInspectionVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findAnnualInspectionVosByPage(AnnualInspectionVo annualInspectionVo){
        Map annualInspectionVoMap = annualInspectionVo == null?null:(Map) JSON.toJSON(annualInspectionVo);
        return annualInspectionRpc.findAnnualInspectionVosByPage(annualInspectionVoMap);
    }


    /**
     * @Title:
     * @Description:  修改年检提醒
     * @param annualInspectionVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @RequestMapping(value = "modifyAnnualInspection",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyAnnualInspection(@RequestBody AnnualInspectionVo annualInspectionVo){
        return annualInspectionRpc.modifyAnnualInspection(annualInspectionVo);
    }

    /**
     * @Title:
     * @Description:  根据annualInspectionId获取年检提醒
     * @param annualInspectionId
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @RequestMapping(value = "findAnnualInspectionVoByAnnualInspectionId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findAnnualInspectionVoByAnnualInspectionId(String annualInspectionId){
        return annualInspectionRpc.findAnnualInspectionVoByAnnualInspectionId(annualInspectionId);
    }


}
