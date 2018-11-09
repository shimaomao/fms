package cn.com.leadu.fms.webclient.baseinfo.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.basfiletype.BasFileTypeVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author yanfengbo
 * @ClassName: BasFileTypeController
 * @Description: 附件类型管理表rpc
 * @date 2018-03-19
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface BasFileTypeRpc {

    /**
     * @Title:
     * @Description: 分页查询附件类型管理表信息
     * @param basFileTypeVoMap
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "api/baseinfo/bas_file_type/findBasFileTypeByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasFileTypeByPage(@RequestParam Map<String, Object> basFileTypeVoMap);

    /**
     * @Title:
     * @Description: 保存附件类型管理表
     * @param basFileTypeVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "api/baseinfo/bas_file_type/saveBasFileType",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveBasFileType(@RequestBody BasFileTypeVo basFileTypeVo);

    /**
     * @Title:
     * @Description:  修改附件类型管理表
     * @param basFileTypeVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "api/baseinfo/bas_file_type/modifyBasFileType",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyBasFileType(@RequestBody BasFileTypeVo basFileTypeVo);

    /**
     * @Title:
     * @Description:   根据fileTypeId集合删除附件类型管理表
     * @param basFileTypeVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "api/baseinfo/bas_file_type/deleteBasFileTypesByFileTypeIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteBasFileTypesByFileTypeIds(@RequestBody BasFileTypeVo basFileTypeVo);

    /**
     * @Title:
     * @Description:  根据fileTypeId获取附件类型管理表
     * @param fileTypeId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "api/baseinfo/bas_file_type/findBasFileTypeByFileTypeId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasFileTypeByFileTypeId(@RequestParam("fileTypeId") String fileTypeId);


    /**
     * @Title:
     * @Description:  查询附件类型管理树
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "api/baseinfo/bas_file_type/findBasFileTypeByTree", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasFileTypeByTree();



    /**
     * @Title:
     * @Description:  通过一个上级类型代码查询旗下所有层级节点的上级类型代码
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "api/baseinfo/bas_file_type/findAllNodesFromBasFileType", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findAllNodesFromBasFileType(@RequestParam("parentFileType") String parentFileType);


    /**
     * @Title:
     * @Description:  分页查询上级类型代码
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "api/baseinfo/bas_file_type/findParentFileTypes", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findParentFileTypes(@RequestParam Map<String, Object> basFileTypeVoMap);

    /**
     * @Title:
     * @Description:  通过上级类型代码获得下一级子节点集合
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "api/baseinfo/bas_file_type/findNextBasFileTypeVosByParentFileType", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findNextBasFileTypeVosByParentFileType(@RequestParam("parentFileType") String parentFileType);


    /**
     * @Title:
     * @Description:  根据fileTypeId获取BasFileTypeVo
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "api/baseinfo/bas_file_type/findBasFileTypeVoByFileTypeId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasFileTypeVoByFileTypeId(@RequestParam("fileTypeId") String fileTypeId);

    /**
     * @Title:
     * @Description: 根据fileType取得子集业务附件类型
     * @param fileType
     * @return PageInfoExtend<BasFileType>
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "api/baseinfo/bas_file_type/findFileTypeTree", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findFileTypeTree(@RequestParam("fileType") String fileType, @RequestParam("product") String product, @RequestParam("subType") String subType);

}
