package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.BizFilesVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.BizFilesRpc;
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
 * @author huchenghao
 * @ClassName: BizFilesController
 * @Description: 附件信息controller
 * @date 2018-04-09
 */
@RestController
@RequestMapping("biz_files")
public class BizFilesController {

    /**
     * @Fields  : 附件信息rpc
     */
    @Autowired
    private BizFilesRpc bizFilesRpc;

    /**
     * @Title:
     * @Description: 分页查询附件信息信息
     * @param bizFilesVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @RequestMapping(value = "findBizFilessByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBizFilessByPage(BizFilesVo bizFilesVo){
        Map bizFilesVoMap = bizFilesVo == null?null:(Map) JSON.toJSON(bizFilesVo);
        return bizFilesRpc.findBizFilessByPage(bizFilesVoMap);
    }

    /**
     * @Title:
     * @Description:  根据bizCode和bizCodeType获取附件信息
     * @param bizFilesVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @RequestMapping(value = "findBizFilesByBizInfo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBizFilesByBizInfo(BizFilesVo bizFilesVo){
        Map bizFilesVoMap = bizFilesVo == null?null:(Map) JSON.toJSON(bizFilesVo);
        return bizFilesRpc.findBizFilesByBizInfo(bizFilesVoMap);
    }

    /**
     * @Title:
     * @Description: 保存附件信息
     * @param bizFilesVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @RequestMapping(value = "saveBizFiles",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBizFiles(@RequestBody BizFilesVo bizFilesVo){
        return bizFilesRpc.saveBizFiles(bizFilesVo);
    }

    /**
     * @Title:
     * @Description:  修改附件信息
     * @param bizFilesVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @RequestMapping(value = "modifyBizFiles",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyBizFiles(@RequestBody BizFilesVo bizFilesVo){
        return bizFilesRpc.modifyBizFiles(bizFilesVo);
    }

    /**
     * @Title:
     * @Description:   根据fileId集合删除附件信息
     * @param fileIds
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @RequestMapping(value = "deleteBizFilessByFileIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBizFilessByFileIds(@RequestBody List<String> fileIds){
        BizFilesVo bizFilesVo = new BizFilesVo();
        bizFilesVo.setFileIds(fileIds);
        return bizFilesRpc.deleteBizFilessByFileIds(bizFilesVo);
    }

    /**
     * @Title:
     * @Description:  根据fileId获取附件信息
     * @param fileId
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-9 14:55:49
     */
    @RequestMapping(value = "findBizFilesByFileId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBizFilesByFileId(String fileId){
        return bizFilesRpc.findBizFilesByFileId(fileId);
    }

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
    @RequestMapping(value = "findBizFilesList", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBizFilesList(String bizCode, String bizCodeType){
        return bizFilesRpc.findBizFilesList(bizCode,bizCodeType);
    }

}
