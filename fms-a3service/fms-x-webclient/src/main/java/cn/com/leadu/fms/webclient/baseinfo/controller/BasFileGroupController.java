package cn.com.leadu.fms.webclient.baseinfo.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.basfilegroup.BasFileGroupVo;
import cn.com.leadu.fms.webclient.baseinfo.rpc.BasFileGroupRpc;
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
 * @author ningyangyang
 * @ClassName: BasFileGroupController
 * @Description: 附件组controller
 */
@RestController
@RequestMapping("bas_file_group")
public class BasFileGroupController {

    /**
     * @Fields  : 附件组rpc
     */
    @Autowired
    private BasFileGroupRpc basFileGroupRpc;

    /**
     * @Title:
     * @Description: 分页查询附件组信息
     * @param basFileGroupVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @RequestMapping(value = "findBasFileGroupsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasFileGroupsByPage(BasFileGroupVo basFileGroupVo){
        Map basFileGroupVoMap = basFileGroupVo == null?null:(Map) JSON.toJSON(basFileGroupVo);
        return basFileGroupRpc.findBasFileGroupsByPage(basFileGroupVoMap);
    }

    /**
     * @Title:
     * @Description: 保存附件组
     * @param basFileGroupVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @RequestMapping(value = "saveBasFileGroup",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBasFileGroup(@RequestBody BasFileGroupVo basFileGroupVo){
        return basFileGroupRpc.saveBasFileGroup(basFileGroupVo);
    }

    /**
     * @Title:
     * @Description:  修改附件组
     * @param basFileGroupVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @RequestMapping(value = "modifyBasFileGroup",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyBasFileGroup(@RequestBody BasFileGroupVo basFileGroupVo){
        return basFileGroupRpc.modifyBasFileGroup(basFileGroupVo);
    }

    /**
     * @Title:
     * @Description:   根据basFileGroupId集合删除附件组
     * @param basFileGroupIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @RequestMapping(value = "deleteBasFileGroupsByBasFileGroupIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasFileGroupsByBasFileGroupIds(@RequestBody List<String> basFileGroupIds){
        BasFileGroupVo basFileGroupVo = new BasFileGroupVo();
        basFileGroupVo.setBasFileGroupIds(basFileGroupIds);
        return basFileGroupRpc.deleteBasFileGroupsByBasFileGroupIds(basFileGroupVo);
    }

    /**
     * @Title:
     * @Description:  根据basFileGroupId获取附件组
     * @param basFileGroupId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-10-29 10:03:27
     */
    @RequestMapping(value = "findBasFileGroupByBasFileGroupId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasFileGroupByBasFileGroupId(String basFileGroupId){
        return basFileGroupRpc.findBasFileGroupByBasFileGroupId(basFileGroupId);
    }

}
