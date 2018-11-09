package cn.com.leadu.fms.system.service.impl;

import cn.com.leadu.fms.business.service.RedisService;
import cn.com.leadu.fms.common.constant.enums.system.SystemRedisKeyEnums;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.system.repository.SysWidgetAttributeRepository;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.entity.SysWidgetAttribute;
import cn.com.leadu.fms.pojo.system.vo.syswidgetattribute.SysWidgetAttributeTreeVo;
import cn.com.leadu.fms.pojo.system.vo.syswidgetattribute.SysWidgetAttributeVo;
import cn.com.leadu.fms.system.service.SysWidgetAttributeService;
import cn.com.leadu.fms.system.service.SysWidgetService;
import cn.com.leadu.fms.system.validator.syswidgetattribute.vo.SysWidgetAttributeDeleteListVo;
import cn.com.leadu.fms.system.validator.syswidgetattribute.vo.SysWidgetAttributeModifyVo;
import cn.com.leadu.fms.system.validator.syswidgetattribute.vo.SysWidgetAttributeSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/**
 * @author wangxue
 * @ClassName: SysWidgetAttributeService
 * @Description: 项目权限管理业务实现层
 * @date 2018-03-09
 */
@Service
public class SysWidgetAttributeServiceImpl implements SysWidgetAttributeService {

    @Autowired
    private SysWidgetAttributeRepository sysWidgetAttributeRepository;

    @Autowired
    private RedisService redisService;

    @Autowired
    private SysWidgetService sysWidgetService;

    /**
     * @Title:
     * @Description: 保存项目权限管理
     * @param sysWidgetAttributeSaveVo
     * @return java.lang.String
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    public ResponseEntity<RestResponse> saveSysWidgetAttribute(SysWidgetAttributeSaveVo sysWidgetAttributeSaveVo){
        Example example = SqlUtil.newExample(SysWidgetAttribute.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("frmWidgetId", sysWidgetAttributeSaveVo.getFrmWidgetId());
        criteria.andEqualTo("eleWidgetId", sysWidgetAttributeSaveVo.getEleWidgetId());
        SqlUtil.setOrderByCreateTimeDesc(example);
        SysWidgetAttribute sysWidgetAttribute = sysWidgetAttributeRepository.selectOneByExample(example);
        if (sysWidgetAttribute != null) {
            return new ResponseEntity<RestResponse>(RestResponseGenerator.genFailResponse("画面已经添加该项目，不可重复添加"), HttpStatus.OK);
        } else {
            sysWidgetAttributeRepository.insertData(sysWidgetAttributeSaveVo.getEntity());
            return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
        }
    }

    /**
     * @Title:
     * @Description: 修改项目权限管理
     * @param sysWidgetAttributeModifyVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    public void modifySysWidgetAttribute(SysWidgetAttributeModifyVo sysWidgetAttributeModifyVo){
        sysWidgetAttributeRepository.updateByPrimaryKeySelectiveData(sysWidgetAttributeModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过widgetConId集合删除项目权限管理
     * @param sysWidgetAttributeDeleteListVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    public void deleteSysWidgetAttributeByWidgetConIds(SysWidgetAttributeDeleteListVo sysWidgetAttributeDeleteListVo){
        sysWidgetAttributeRepository.deleteDataList(sysWidgetAttributeDeleteListVo.getWidgetConIds(),sysWidgetAttributeDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据widgetConId获取项目权限管理
     * @param widgetConId
     * @return SysWidgetAttribute
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    public SysWidgetAttribute findSysWidgetAttributeByWidgetConId(String widgetConId){
        return sysWidgetAttributeRepository.selectByPrimaryKey(widgetConId);
    }

    /**
     * @Title:
     * @Description: 根据画面标识ID，分页查询项目权限vo
     * @param sysWidgetAttributeVo
     * @return PageInfoExtend<SysWidgetAttribute>
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:18
     */
    public PageInfoExtend<SysWidgetAttributeVo> findSysWidgetAttributeVoByPage(SysWidgetAttributeVo sysWidgetAttributeVo){
        // 项目ID
        if (StringUtils.isNotTrimBlank(sysWidgetAttributeVo.getEleWidgetId())) {
            sysWidgetAttributeVo.setEleWidgetId(SqlUtil.likePattern(sysWidgetAttributeVo.getEleWidgetId()));
        } else {
            sysWidgetAttributeVo.setEleWidgetId(null);
        }
        // 项目名称
        if (StringUtils.isNotTrimBlank(sysWidgetAttributeVo.getEleWidgetName())) {
            sysWidgetAttributeVo.setEleWidgetName(SqlUtil.likePattern(sysWidgetAttributeVo.getEleWidgetName()));
        } else {
            sysWidgetAttributeVo.setEleWidgetName(null);
        }
        PageInfoExtend<SysWidgetAttributeVo> pageInfo = sysWidgetAttributeRepository.selectListVoByPage("selectSysWidgetAttributeVoByPages", sysWidgetAttributeVo, sysWidgetAttributeVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description:   查出所有项目权限数据并以树的形式返回
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:17
     */
    public Map<String, SysWidgetAttributeTreeVo> findSysWidgetAttributeVoByTree() {
        Object sysWidgetAttributeVos = redisService.get(SystemRedisKeyEnums.FMS_SYSTEM_SYS_WIDGET_ATTRIBUTE_TREE.getPrefix());
        if(sysWidgetAttributeVos != null)
            return (Map<String,SysWidgetAttributeTreeVo>) sysWidgetAttributeVos;
        else {
            Map<String,SysWidgetAttributeTreeVo> sysWidgetAttributeTreeVoMap = getSysWidgetAttributeVoByTree();
            saveSysWidgetAttributeVoByTreeToRedis(sysWidgetAttributeTreeVoMap);
            return sysWidgetAttributeTreeVoMap;
        }
    }

    /**
     * @Title:
     * @Description:   查出所有项目权限数据并以树的形式返回
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:17
     */
    private Map<String, SysWidgetAttributeTreeVo> getSysWidgetAttributeVoByTree() {
        Map<String,SysWidgetAttributeTreeVo> resultMap = new LinkedHashMap<>();
        Example example = SqlUtil.newExample(SysWidgetAttribute.class);
        SqlUtil.andEqualToDeleteExist(example.createCriteria());
        SqlUtil.setOrderByColumnAsc(example,"frm_widget_id");
        List<SysWidgetAttribute> sysWidgetAttributeList = sysWidgetAttributeRepository.selectListByExample(example);
        // 取得全部画面名称
        Map<String, String> sysWidgetMap = sysWidgetService.findSysWidgetByTree();
        Map<String, SysWidgetAttribute> tempMap = null;
        SysWidgetAttributeTreeVo sysWidgetAttributeTreeVo = null;
        if (sysWidgetAttributeList != null && sysWidgetAttributeList.size() > 0) {
            for (SysWidgetAttribute sysWidgetAttribute : sysWidgetAttributeList) {
                if (sysWidgetAttributeTreeVo == null || !sysWidgetAttributeTreeVo.getFrmWidgetId().equals(sysWidgetAttribute.getFrmWidgetId())) {
                    if (sysWidgetAttributeTreeVo != null) {
                        sysWidgetAttributeTreeVo.setEleWidgetMap(tempMap);
                        resultMap.put(sysWidgetAttributeTreeVo.getFrmWidgetId(), sysWidgetAttributeTreeVo);
                    }
                    sysWidgetAttributeTreeVo = new SysWidgetAttributeTreeVo();
                    sysWidgetAttributeTreeVo.setFrmWidgetId(sysWidgetAttribute.getFrmWidgetId());
                    // 设置画面项目名称
                    sysWidgetAttributeTreeVo.setFrmWidgetName(sysWidgetMap.get(sysWidgetAttributeTreeVo.getFrmWidgetId()));
                    tempMap = new LinkedHashMap<>();
                    tempMap.put(sysWidgetAttribute.getEleWidgetId(), sysWidgetAttribute);
                } else {
                    tempMap.put(sysWidgetAttribute.getEleWidgetId(), sysWidgetAttribute);
                }
            }
            if (sysWidgetAttributeTreeVo != null) {
                sysWidgetAttributeTreeVo.setEleWidgetMap(tempMap);
                resultMap.put(sysWidgetAttributeTreeVo.getFrmWidgetId(), sysWidgetAttributeTreeVo);
            }
        }
        return resultMap;
    }

    /**
     * @Title:
     * @Description:   保存数组字典进redis
     * @param sysWidgetAttributeTreeVoMap
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-9 11:07:17
     */
    private void saveSysWidgetAttributeVoByTreeToRedis(Map<String,SysWidgetAttributeTreeVo> sysWidgetAttributeTreeVoMap){
        redisService.save(SystemRedisKeyEnums.FMS_SYSTEM_SYS_WIDGET_ATTRIBUTE_TREE.getPrefix(),sysWidgetAttributeTreeVoMap);
    }

    /**
     * @Title:
     * @Description:  重置redis中保存的画面项目权限
     * @param
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 13:37:18
     */
    @Override
    public Map<String, SysWidgetAttributeTreeVo> resetSysWidgetAttributeVoByTreeToRedis() {
        Map<String,SysWidgetAttributeTreeVo> sysWidgetAttributeTreeVoMap = getSysWidgetAttributeVoByTree();
        saveSysWidgetAttributeVoByTreeToRedis(sysWidgetAttributeTreeVoMap);
        return sysWidgetAttributeTreeVoMap;
    }
}
