package cn.com.leadu.fms.baseinfo.rpc.prebiz;

import cn.com.leadu.fms.baseinfo.validator.baspartner.vo.BasPartnerSaveVo;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.baspartner.BasPartnerVo;
import cn.com.leadu.fms.pojo.baseinfo.vo.bassales.BasSalesVo;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import cn.com.leadu.fms.pojo.system.vo.sysgroup.SysGroupVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author huchenghao
 * @ClassName: SysGroupController
 * @Description: 用户组管理rpc
 * @date 2018-03-10
 */
@FeignClient("${fms.feigns.serverNames.fmsPreBiz}")
public interface BizFilesRpc {

    /** @Description: 保存附件信息
     * @param basPartnerVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-29 17:39:58
     */
    @RequestMapping(value = "biz_files/saveBizFilesBasPartner",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveBizFilesBasPartner(@RequestBody BasPartnerVo basPartnerVo);

    /** @Description: 保存实际销售方附件信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "biz_files/saveSalesBizFilesBasSales",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveSalesBizFilesBasSales(@RequestBody BasSalesVo basSalesVo);

    /** @Description: 修改附件信息
     * @param basPartnerVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-29 17:39:58
     */
    @RequestMapping(value = "biz_files/updateBizFilesBasPartner",method = RequestMethod.POST)
    ResponseEntity<RestResponse> updateBizFilesBasPartner(@RequestBody BasPartnerVo basPartnerVo);

    /** @Description: 修改实际销售方附件信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "biz_files/updateSalesBizFilesBasSales",method = RequestMethod.POST)
    ResponseEntity<RestResponse> updateSalesBizFilesBasSales(@RequestBody BasSalesVo basSalesVo);

    /** @Description: 取得附件信息
     * @param bizCode
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-29 17:39:58
     */
    @RequestMapping(value = "biz_files/findBizFilesByBizCode",method = RequestMethod.GET)
    ResponseEntity<RestResponse<CommonBizFilesVo>> findBizFilesByBizCode(@RequestParam("bizCode") String bizCode);

    /** @Description: 取得实际销售方附件信息
     * @param bizCode
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-29 17:39:58
     */
    @RequestMapping(value = "biz_files/findSalesBizFilesByBizCode",method = RequestMethod.GET)
    ResponseEntity<RestResponse<CommonBizFilesVo>> findSalesBizFilesByBizCode(@RequestParam("bizCode") String bizCode);
}
