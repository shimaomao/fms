package cn.com.leadu.fms.webclient.baseinfo.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.basfilegroup.BasFileGroupVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: BasFileGroupController
 * @Description: 附件组rpc
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface BasFileGroupRpc {

    /**
     * @Title:
     * @Description: 分页查询附件组信息
     * @param basFileGroupVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @RequestMapping(value = "api/baseinfo/bas_file_group/findBasFileGroupsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasFileGroupsByPage(@RequestParam Map<String, Object> basFileGroupVoMap);

    /**
     * @Title:
     * @Description: 保存附件组
     * @param basFileGroupVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @RequestMapping(value = "api/baseinfo/bas_file_group/saveBasFileGroup",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveBasFileGroup(@RequestBody BasFileGroupVo basFileGroupVo);

    /**
     * @Title:
     * @Description:  修改附件组
     * @param basFileGroupVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @RequestMapping(value = "api/baseinfo/bas_file_group/modifyBasFileGroup",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyBasFileGroup(@RequestBody BasFileGroupVo basFileGroupVo);

    /**
     * @Title:
     * @Description:   根据basFileGroupId集合删除附件组
     * @param basFileGroupVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @RequestMapping(value = "api/baseinfo/bas_file_group/deleteBasFileGroupsByBasFileGroupIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteBasFileGroupsByBasFileGroupIds(@RequestBody BasFileGroupVo basFileGroupVo);

    /**
     * @Title:
     * @Description:  根据basFileGroupId获取附件组
     * @param basFileGroupId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @RequestMapping(value = "api/baseinfo/bas_file_group/findBasFileGroupByBasFileGroupId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasFileGroupByBasFileGroupId(@RequestParam("basFileGroupId") String basFileGroupId);

}
