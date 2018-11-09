package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.BizFilesVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author huchenghao
 * @ClassName: BizFilesController
 * @Description: 附件信息rpc
 * @date 2018-04-09
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface BizFilesRpc {

    /**
     * @Title:
     * @Description: 分页查询附件信息信息
     * @param bizFilesVoMap
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @RequestMapping(value = "api/prebiz/biz_files/findBizFilessByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBizFilessByPage(@RequestParam Map<String, Object> bizFilesVoMap);

    /**
     * @Title:
     * @Description: 根据bizCode和bizCodeType获取附件信息
     * @param bizFilesVoMap
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @RequestMapping(value = "api/prebiz/biz_files/findBizFilesByBizInfo" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBizFilesByBizInfo(@RequestParam Map<String, Object> bizFilesVoMap);

    /**
     * @Title:
     * @Description: 保存附件信息
     * @param bizFilesVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @RequestMapping(value = "api/prebiz/biz_files/saveBizFiles",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveBizFiles(@RequestBody BizFilesVo bizFilesVo);

    /**
     * @Title:
     * @Description:  修改附件信息
     * @param bizFilesVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @RequestMapping(value = "api/prebiz/biz_files/modifyBizFiles",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyBizFiles(@RequestBody BizFilesVo bizFilesVo);

    /**
     * @Title:
     * @Description:   根据fileId集合删除附件信息
     * @param bizFilesVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @RequestMapping(value = "api/system/biz_files/deleteBizFilessByFileIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteBizFilessByFileIds(@RequestBody BizFilesVo bizFilesVo);

    /**
     * @Title:
     * @Description:  根据fileId获取附件信息
     * @param fileId
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @RequestMapping(value = "api/prebiz/biz_files/findBizFilesByFileId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBizFilesByFileId(@RequestParam("fileId") String fileId);

    /**
     * @Title:
     * @Description: 根据业务编码和业务类型返回文件list
     * @param: bizCode     业务编码
     * @param: bizCodeType 业务类型
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/14 0014 9:54
     */
    @RequestMapping(value = "api/prebiz/biz_files/findBizFilesList", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBizFilesList(@RequestParam("bizCode") String bizCode, @RequestParam("bizCodeType") String bizCodeType);

}
