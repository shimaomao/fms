package cn.com.leadu.fms.webclient.baseinfo.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.basfiletype.BasFileTypeVo;
import cn.com.leadu.fms.webclient.baseinfo.rpc.BasFileTypeRpc;
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
 * @ClassName: BasFileTypeController
 * @Description: 附件类型管理表controller
 * @date 2018-03-19
 */
@RestController
@RequestMapping("bas_file_type")
public class BasFileTypeController {

    /**
     * @Fields  : 附件类型管理表rpc
     */
    @Autowired
    private BasFileTypeRpc basFileTypeRpc;

    /**
     * @Title:
     * @Description: 分页查询附件类型管理表信息
     * @param basFileTypeVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "findBasFileTypeByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasFileTypeByPage(BasFileTypeVo basFileTypeVo){
        Map basFileTypeVoMap = basFileTypeVo == null?null:(Map) JSON.toJSON(basFileTypeVo);
        return basFileTypeRpc.findBasFileTypeByPage(basFileTypeVoMap);
    }

    /**
     * @Title:
     * @Description: 保存附件类型管理表
     * @param basFileTypeVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "saveBasFileType",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBasFileType(@RequestBody BasFileTypeVo basFileTypeVo){
        return basFileTypeRpc.saveBasFileType(basFileTypeVo);
    }

    /**
     * @Title:
     * @Description:  修改附件类型管理表
     * @param basFileTypeVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "modifyBasFileType",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyBasFileType(@RequestBody BasFileTypeVo basFileTypeVo){
        return basFileTypeRpc.modifyBasFileType(basFileTypeVo);
    }

    /**
     * @Title:
     * @Description:   根据fileTypeId集合删除附件类型管理表
     * @param fileTypeIds
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "deleteBasFileTypesByFileTypeIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasFileTypesByFileTypeIds(@RequestBody List<String> fileTypeIds){
        BasFileTypeVo basFileTypeVo = new BasFileTypeVo();
        basFileTypeVo.setFileTypeIds(fileTypeIds);
        return basFileTypeRpc.deleteBasFileTypesByFileTypeIds(basFileTypeVo);
    }

    /**
     * @Title:
     * @Description:  根据fileTypeId获取附件类型管理表
     * @param fileTypeId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "findBasFileTypeByFileTypeId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasFileTypeByFileTypeId(String fileTypeId){
        return basFileTypeRpc.findBasFileTypeByFileTypeId(fileTypeId);
    }

    /**
     * @Title:
     * @Description:  查询附件类型管理树
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value="findBasFileTypeByTree",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasFileTypeByTree(){
        return  basFileTypeRpc.findBasFileTypeByTree();
    }

    /**
     * @Title:
     * @Description:  通过一个上级类型代码查询旗下所有层级节点的上级类型代码
     * @param parentFileType
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value="findAllNodesFromBasFileType",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findAllNodesFromBasFileType(String parentFileType){
        return  basFileTypeRpc.findAllNodesFromBasFileType(parentFileType);
    }

    /**
     * @Title:
     * @Description:  分页查询上级类型代码
     * @param basFileTypeVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value="findParentFileTypes",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findParentFileTypes(BasFileTypeVo basFileTypeVo){
        Map basFileTypeVoMap = basFileTypeVo == null?null:(Map) JSON.toJSON(basFileTypeVo);
        return  basFileTypeRpc.findParentFileTypes(basFileTypeVoMap);
    }

    /**
     * @Title:
     * @Description:  通过上级类型代码获得下一级子节点集合
     * @param parentFileType
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value="findNextBasFileTypeVosByParentFileType",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findNextBasFileTypeVosByParentFileType(String parentFileType){
        return  basFileTypeRpc.findNextBasFileTypeVosByParentFileType(parentFileType);
    }

    /**
     * @Title:
     * @Description:  根据fileTypeId获取BasFileTypeVo
     * @param fileTypeId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "findBasFileTypeVoByFileTypeId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasFileTypeVoByFileTypeId(String fileTypeId){
        return basFileTypeRpc.findBasFileTypeVoByFileTypeId(fileTypeId);
    }

    /**
     * @Title:
     * @Description: 根据fileType取得子集业务附件类型
     * @param fileType
     * @return PageInfoExtend<BasFileType>
     * @throws
     * @author yanfengbo
     * @date 2018-3-19 12:02:58
     */
    @RequestMapping(value = "findFileTypeTree", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFileTypeTree(String fileType, String product, String subType) {
        return basFileTypeRpc.findFileTypeTree(fileType, product, subType);
    }

}
