package cn.com.leadu.fms.activiti.service.impl;

import cn.com.leadu.fms.activiti.service.ActReModelService;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.PageInfoExtendUtils;
import cn.com.leadu.fms.pojo.activiti.vo.actremodel.ActReModelVo;
import com.alibaba.fastjson.JSON;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.activiti.bpmn.converter.BpmnXMLConverter;
import org.activiti.bpmn.model.BpmnModel;
import org.activiti.editor.constants.ModelDataJsonConstants;
import org.activiti.editor.language.json.converter.BpmnJsonConverter;
import org.activiti.engine.RepositoryService;
import org.activiti.engine.repository.Deployment;
import org.activiti.engine.repository.Model;
import org.activiti.engine.repository.ModelQuery;
import org.activiti.engine.repository.ProcessDefinition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: ModelServiceImpl
 * @Description: 工作流模型service实现类
 * @date 2018/3/12
 */
@Service
public class ActReModelServiceImpl implements ActReModelService {

    @Autowired
    private RepositoryService repositoryService;

    /**
     * @Title:
     * @Description:   分页查询工作流模型
     * @param actReModelVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/12 10:45:59
     */
    public PageInfoExtend<ActReModelVo> findActReModelsByPage(ActReModelVo actReModelVo) {
        ModelQuery modelQuery = repositoryService.createModelQuery()
                .latestVersion().orderByLastUpdateTime().desc();
        List<Model> models = modelQuery.listPage(actReModelVo.getStart(), actReModelVo.getPageSize());
        List<ActReModelVo> actReModelVos = new ArrayList<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(models)){
            for(Model model : models){
                ActReModelVo actReModelVoTmp = (EntityUtils.getEntity(model,new ActReModelVo()));
                actReModelVos.add(actReModelVoTmp);
            }
        }
        return PageInfoExtendUtils.getPageInfoExtend(actReModelVos,modelQuery.count(), actReModelVo.getPageQuery());
    }

    /**
     * @Title:
     * @Description:   添加模型
     * @param actReModelVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/12 10:53:47
     */
    @Transactional
    public Model saveActReModel(ActReModelVo actReModelVo) throws UnsupportedEncodingException {

        Map<String,Object> editorMap = new HashMap<>();
        editorMap.put("id","canvas");
        editorMap.put("resourceId","canvas");
        Map<String,Object> propertiesMap = new HashMap<>();
        propertiesMap.put("process_author","leadu");
        editorMap.put("properties",propertiesMap);
        Map<String,Object> stencilsetMap = new HashMap<>();
        stencilsetMap.put("namespace","http://b3mn.org/stencilset/bpmn2.0#");
        editorMap.put("stencilset",stencilsetMap);


        Model model = repositoryService.newModel();
        model.setKey(StringUtils.defaultString(actReModelVo.getKey()));
        model.setName(actReModelVo.getName());
        model.setCategory(actReModelVo.getCategory());
        model.setVersion(Integer.parseInt(String.valueOf(repositoryService.createModelQuery().modelKey(model.getKey()).count()+1)));


        Map<String,Object> metaInfoMap = new HashMap<>();
        metaInfoMap.put(ModelDataJsonConstants.MODEL_NAME, actReModelVo.getName());
        metaInfoMap.put(ModelDataJsonConstants.MODEL_REVISION, model.getVersion());
        metaInfoMap.put(ModelDataJsonConstants.MODEL_DESCRIPTION, StringUtils.defaultString(actReModelVo.getDescription()));
        model.setMetaInfo(JSON.toJSONString(metaInfoMap));


        repositoryService.saveModel(model);
        repositoryService.addModelEditorSource(model.getId(), JSON.toJSONString(editorMap).getBytes("utf-8"));
        return model;
    }


    /**
     * @Title:
     * @Description:   根据模型modelId部署流程
     * @param modelId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/12 11:23:54
     */
    @Transactional
    public void deployActReModel(String modelId) throws IOException {
        //获取模型
        Model modelData = repositoryService.getModel(modelId);
        byte[] bytes = repositoryService.getModelEditorSource(modelData.getId());

        if (bytes == null) {
            throw new FmsServiceException("模型数据为空,请先设计流程并成功保存,再进行发布");
        }

        JsonNode modelNode = new ObjectMapper().readTree(bytes);

        BpmnModel model = new BpmnJsonConverter().convertToBpmnModel(modelNode);
        if(model.getProcesses().size()==0){
            throw new FmsServiceException("数据模型不符要求,请至少设计一条主线流程");
        }
        byte[] bpmnBytes = new BpmnXMLConverter().convertToXML(model);
        String xml = new String(bpmnBytes);
        System.out.println(xml);
        //发布流程
        String processName = modelData.getName() + ".bpmn20.xml";
        Deployment deployment = repositoryService.createDeployment()
                .name(modelData.getName())
                .addString(processName, new String(bpmnBytes, "UTF-8"))
                .deploy();
        modelData.setDeploymentId(deployment.getId());
        ProcessDefinition pef = null;
        repositoryService.saveModel(modelData);
    }

    /**
     * @Title:
     * @Description:   根据modelId删除模型
     * @param modelId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/14 11:25:58
     */
    @Transactional
    public void deleteActReModelByModelId(String modelId){
        if(StringUtils.isNotTrimBlank(modelId)){
            repositoryService.deleteModel(modelId);
        }
    }

    /**
     * @Title:
     * @Description:  根据modelId获取模型xml
     * @param modelId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/15 11:55:24
     */
    public String findActReModelXmlByModelId(String modelId) throws IOException {
        String modelXml = null;
        Model model = repositoryService.createModelQuery().modelId(modelId).singleResult();
        if(model != null){
            byte[] bytes = repositoryService.getModelEditorSource(model.getId());
            if(bytes != null) {
                JsonNode modelNode = new ObjectMapper().readTree(bytes);
                BpmnModel bpmnModel = new BpmnJsonConverter().convertToBpmnModel(modelNode);
                byte[] bpmnBytes = new BpmnXMLConverter().convertToXML(bpmnModel);
                modelXml = new String(bpmnBytes);
            }
        }
        return modelXml;
    }

}
