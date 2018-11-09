package cn.com.leadu.fms.activiti.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.activiti.vo.actremodel.ActReModelVo;
import org.activiti.engine.repository.Model;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

/**
 * @author qiaomengnan
 * @ClassName: ModelService
 * @Description: 工作流模型service
 * @date 2018/3/12
 */
public interface ActReModelService {

    /**
     * @Title:
     * @Description:   分页查询工作流模型
     * @param actReModelVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/12 10:45:59
     */
    PageInfoExtend<ActReModelVo> findActReModelsByPage(ActReModelVo actReModelVo);

    /**
     * @Title:
     * @Description:   添加模型
     * @param actReModelVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/12 10:53:47
     */
    Model saveActReModel(ActReModelVo actReModelVo) throws UnsupportedEncodingException;

    /**
     * @Title:
     * @Description:   根据模型id部署流程
     * @param modelId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/12 11:23:54
     */
    void deployActReModel(String modelId) throws IOException;

    /**
     * @Title:
     * @Description:   根据modelId删除模型
     * @param modelId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/14 11:25:58
     */
    void deleteActReModelByModelId(String modelId);

    /**
     * @Title:
     * @Description:  根据modelId获取模型xml
     * @param modelId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/15 11:55:24
     */
    String findActReModelXmlByModelId(String modelId) throws IOException;

}
