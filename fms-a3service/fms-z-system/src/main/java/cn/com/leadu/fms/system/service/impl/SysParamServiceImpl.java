package cn.com.leadu.fms.system.service.impl;

import cn.com.leadu.fms.business.service.CommonParamService;
import cn.com.leadu.fms.business.service.RedisService;
import cn.com.leadu.fms.common.constant.CommonParamConstants;
import cn.com.leadu.fms.common.constant.enums.system.CommonParamRedisKeyEnums;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.vo.CommonParamVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.system.repository.SysParamRepository;
import cn.com.leadu.fms.pojo.system.entity.SysParam;
import cn.com.leadu.fms.pojo.system.vo.sysparam.SysParamVo;
import cn.com.leadu.fms.system.service.SysParamService;
import cn.com.leadu.fms.system.validator.sysparam.vo.SysParamDeleteListVo;
import cn.com.leadu.fms.system.validator.sysparam.vo.SysParamDeleteVo;
import cn.com.leadu.fms.system.validator.sysparam.vo.SysParamModifyVo;
import cn.com.leadu.fms.system.validator.sysparam.vo.SysParamSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author yanfengbo
 * @ClassName: SysParamService
 * @Description: 系统常量表业务实现层
 * @date 2018-03-09
 */
@Service
public class SysParamServiceImpl implements SysParamService , CommonParamService {

    @Autowired
    private SysParamRepository sysParamRepository;

    @Autowired
    private RedisService redisService;

    /**
     * @Title:
     * @Description: 保存系统常量表
     * @param sysParamSaveVo
     * @return java.lang.String
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    public Map<String,Object> saveSysParam(SysParamSaveVo sysParamSaveVo){
        sysParamRepository.insertData(sysParamSaveVo.getEntity());
        return initSysParamsValue();
    }

    /**
     * @Title:
     * @Description: 修改系统常量表
     * @param sysParamModifyVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    public Map<String,Object> modifySysParam(SysParamModifyVo sysParamModifyVo){
        /*sysParamModifyVo.setUpdateTime(null);
        sysParamModifyVo.setUpdater(null);*/
        sysParamRepository.updateByPrimaryKeySelectiveData(sysParamModifyVo.getEntity());
        return initSysParamsValue();
    }

    /**
     * @Title:
     * @Description:  通过paramKeyId删除系统常量表
     * @param sysParamDeleteVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    public Map<String,Object> deleteSysParam(SysParamDeleteVo sysParamDeleteVo){
        sysParamRepository.deleteData(sysParamDeleteVo.getEntity());
        return initSysParamsValue();
    }

    /**
     * @Title:
     * @Description:  通过paramKeyId集合删除系统常量表
     * @param sysParamDeleteListVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    public Map<String,Object> deleteSysParamByParamKeyIds(SysParamDeleteListVo sysParamDeleteListVo){
        sysParamRepository.deleteDataList(sysParamDeleteListVo.getParamKeyIds(),sysParamDeleteListVo.getEntity());
        return initSysParamsValue();
    }

    /**
     * @Title:
     * @Description:  根据paramKeyId获取系统常量表
     * @param paramKeyId
     * @return SysParam
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    public SysParam findSysParamByParamKeyId(String paramKeyId){
        return sysParamRepository.selectByPrimaryKey(paramKeyId);
    }

    /**
     * @Title:
     * @Description: 分页查询系统常量表
     * @param sysParamVo
     * @return PageInfoExtend<SysParam>
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    public PageInfoExtend<SysParam> findSysParamByPage(SysParamVo sysParamVo){
        Example example = SqlUtil.newExample(SysParam.class);
        Example.Criteria criteria = example.createCriteria();
        //设置查询条件
        if(StringUtils.isNotTrimBlank(sysParamVo.getParamName())){
            criteria.andLike("paramName",SqlUtil.likePattern(sysParamVo.getParamName()));
        }
        if(StringUtils.isNotTrimBlank(sysParamVo.getParamKey())){
            criteria.andLike("paramKey",SqlUtil.likePattern(sysParamVo.getParamKey()));
        }
        //分页查询列表按更新时间排序
        SqlUtil.setOrderByUpdateTimeDesc(example);
        PageInfoExtend<SysParam> pageInfo = sysParamRepository.selectListByExamplePage(example,sysParamVo.getPageQuery());
        return pageInfo;
    }


    /**
     * @Title:
     * @Description:  根据paramKey获取系统常量表
     * @param paramKey
     * @return SysParam
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    public SysParam findSysParamByParamKey(String paramKey) {
            Example example = SqlUtil.newExample(SysParam.class);
            example.createCriteria().andEqualTo("paramKey", paramKey);
            return sysParamRepository.selectOneByExample(example);
    }


    /**
     * @Title:
     * @Description:  根据paramKey获取系统常量表
     * @param paramKey
     * @return SysParam
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    public String findParamValueByParamKey(String paramKey) {
        Example example = SqlUtil.newExample(SysParam.class);
        example.createCriteria().andEqualTo("paramKey", paramKey);
        SysParam sysParam = sysParamRepository.selectOneByExample(example);
        if(StringUtils.isTrimBlank(sysParam)){
            return "";
        }
        return sysParam.getParamValue();
    }

    /**
     * @Title:
     * @Description:   初始化系统常量值到redis中
     * @return
     * @throws 
     * @author qiaomengnan 
     * @date 2018/06/20 09:19:43
     */
    public Map<String,Object> initSysParamsValue(){
        List<CommonParamVo> commonParamVos = sysParamRepository.selectSysParams();
        if(ArrayUtils.isNotNullAndLengthNotZero(commonParamVos)){
            Map<String,Object> results = new HashMap<>();
            Map<String,CommonParamVo> commonParamVoMap = new HashMap<>();
            for(CommonParamVo commonParamVo : commonParamVos){
                commonParamVoMap.put(commonParamVo.getParamKey(),commonParamVo);
            }
            //设置常量版本值
            Integer version = (Integer) redisService.get(CommonParamRedisKeyEnums.FMS_COMMON_PARAM_VALUES_VERSION.getPrefix());
            if(version == null)
                version = 0;
            else
                version += 1;
            redisService.save(CommonParamRedisKeyEnums.FMS_COMMON_PARAM_VALUES_VERSION.getPrefix(),version);
            redisService.save(CommonParamRedisKeyEnums.FMS_COMMON_PARAM_VALUES.getPrefix(),commonParamVoMap);
            results.put(CommonParamConstants.COMMON_PARAM_VALUE_VERSION,version);
            results.put(CommonParamConstants.COMMON_PARAM_VALUES,commonParamVoMap);
            return results;
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   获取系统常量
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 09:31:03
     */
    public Map<String,Object> findSysParamsValue(){
        Object result = redisService.get(CommonParamRedisKeyEnums.FMS_COMMON_PARAM_VALUES.getPrefix());
        if(result == null)
            return initSysParamsValue();
        else{
            Map<String,Object> results = new HashMap<>();
            Integer version = (Integer) redisService.get(CommonParamRedisKeyEnums.FMS_COMMON_PARAM_VALUES_VERSION.getPrefix());
            if(version == null)
                version = 0;
            results.put(CommonParamConstants.COMMON_PARAM_VALUE_VERSION,version);
            results.put(CommonParamConstants.COMMON_PARAM_VALUES,(Map<String,SysParam>)result);
            return results;
        }
    }

    /**
     * @Title:
     * @Description:   返回常量版本值
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 09:49:12
     */
    public Integer findSysParamsValueVersion(){
        //设置常量版本值
        Integer version = (Integer) redisService.get(CommonParamRedisKeyEnums.FMS_COMMON_PARAM_VALUES_VERSION.getPrefix());
        if(version == null)
            version = 0;
        return version;
    }

}
