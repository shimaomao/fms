package cn.com.leadu.fms.system.service.impl;

import cn.com.leadu.fms.business.service.CommonCodeService;
import cn.com.leadu.fms.business.service.RedisService;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.enums.CommonCodeRedisKeyEnums;
import cn.com.leadu.fms.common.constant.enums.CommonStatusEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.vo.CommonCodeVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.system.repository.SysCodeRepository;
import cn.com.leadu.fms.pojo.system.entity.SysCode;
import cn.com.leadu.fms.pojo.system.vo.syscode.SysCodeVo;
import cn.com.leadu.fms.system.service.SysCodeService;
import cn.com.leadu.fms.system.validator.syscode.vo.SysCodeDeleteListVo;
import cn.com.leadu.fms.system.validator.syscode.vo.SysCodeDeleteVo;
import cn.com.leadu.fms.system.validator.syscode.vo.SysCodeModifyVo;
import cn.com.leadu.fms.system.validator.syscode.vo.SysCodeSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author huchenghao
 * @ClassName: SysCodeService
 * @Description: 字典数数值业务实现层
 * @date 2018-03-09
 */
@Service
public class SysCodeServiceImpl implements SysCodeService , CommonCodeService {

    @Autowired
    private SysCodeRepository sysCodeRepository;

    @Autowired
    private RedisService redisService;

    /**
     * @Title:
     * @Description: 保存字典数数值
     * @param sysCodeSaveVo
     * @return java.lang.String
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    public Map<String,Object> saveSysCode(SysCodeSaveVo sysCodeSaveVo){
        SysCode sysCode=findSysCodeByCodeValue(EntityUtils.getEntity(sysCodeSaveVo,new SysCodeVo()));
        if(sysCode!= null){
            throw new FmsServiceException("数据字典数值已存在，请勿重复添加！");
        }
        sysCodeRepository.insertData(sysCodeSaveVo.getEntity());
        return initCommonCodeValue();
    }

    /**
     * @Title:
     * @Description: 修改字典数数值
     * @param sysCodeModifyVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    public Map<String,Object> modifySysCode(SysCodeModifyVo sysCodeModifyVo){
        sysCodeRepository.updateByPrimaryKeySelectiveData(sysCodeModifyVo.getEntity());
        return initCommonCodeValue();
    }

    /**
     * @Title:
     * @Description:  通过codeValueId删除字典数数值
     * @param sysCodeDeleteVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    public Map<String,Object> deleteSysCode(SysCodeDeleteVo sysCodeDeleteVo){
        sysCodeRepository.deleteData(sysCodeDeleteVo.getEntity());
        return initCommonCodeValue();
    }

    /**
     * @Title:
     * @Description:  通过codeValueId集合删除字典数数值
     * @param sysCodeDeleteListVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    public Map<String,Object> deleteSysCodeByCodeValueIds(SysCodeDeleteListVo sysCodeDeleteListVo){
        sysCodeRepository.deleteDataList(sysCodeDeleteListVo.getCodeValueIds(),sysCodeDeleteListVo.getEntity());
        return initCommonCodeValue();
    }

    /**
     * @Title:
     * @Description:  根据codeValueId获取字典数数值
     * @param codeValueId
     * @return SysCode
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    public SysCodeVo findSysCodeByCodeValueId(String codeValueId){

        return sysCodeRepository.selectSysCodeVoById(codeValueId);
    }

    /**
     * @Title:
     * @Description:  根据codeValue和codeType查询
     * @param sysCodeVo
     * @return SysCode
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    public SysCode findSysCodeByCodeValue(SysCodeVo sysCodeVo){
        Example example=SqlUtil.newExample(SysCode.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotTrimBlank(sysCodeVo.getCodeType()))
            criteria.andEqualTo("codeType",sysCodeVo.getCodeType());
        if(StringUtils.isNotTrimBlank(sysCodeVo.getCodeValue()))
            criteria.andEqualTo("codeValue",sysCodeVo.getCodeValue());
        SqlUtil.setOrderByCreateTimeDesc(example);
        return sysCodeRepository.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description: 分页查询字典数数值
     * @param sysCodeVo
     * @return PageInfoExtend<SysCode>
     * @throws
     * @author huchenghao
     * @date 2018-3-9 13:46:54
     */
    public PageInfoExtend<SysCode> findSysCodesByPage(SysCodeVo sysCodeVo){
        Example example = SqlUtil.newExample(SysCode.class);
        Example.Criteria criteria = example.createCriteria();

        if(StringUtils.isNotTrimBlank(sysCodeVo.getCodeType()))
            criteria.andLike("codeType",SqlUtil.likePattern(sysCodeVo.getCodeType()));
        if(StringUtils.isNotTrimBlank(sysCodeVo.getCodeValueName()))
            criteria.andLike("codeValueName",SqlUtil.likePattern(sysCodeVo.getCodeValueName()));

        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<SysCode> pageInfo = sysCodeRepository.selectListByExamplePage(example,sysCodeVo.getPageQuery());
        return pageInfo;
    }
    
    /** 
    * @Description:  分页查询字典值（关联字典类型表）
    * @Param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/4/27 14:23
    */ 
    @Override
    public PageInfoExtend<SysCodeVo> findSysCodesWithTypeNameByPage(SysCodeVo sysCodeVo) {

            if (StringUtils.isTrimBlank(sysCodeVo.getCodeType()))
                sysCodeVo.setCodeType(null);
            else
                sysCodeVo.setCodeType(SqlUtil.likePattern(sysCodeVo.getCodeType()));

            if (StringUtils.isTrimBlank(sysCodeVo.getCodeValueName()))
                sysCodeVo.setCodeValueName(null);
            else
                sysCodeVo.setCodeValueName(SqlUtil.likePattern(sysCodeVo.getCodeValueName()));

            if(StringUtils.isTrimBlank(sysCodeVo.getCodeValue()))
                sysCodeVo.setCodeValue(null);
            else
                sysCodeVo.setCodeValue(SqlUtil.likePattern(sysCodeVo.getCodeValue()));

            PageInfoExtend<SysCodeVo> pageInfo = sysCodeRepository.selectListVoByPage("selectSysCodesWithTypeNameByPage", sysCodeVo, sysCodeVo.getPageQuery());
            return pageInfo;

    }

    /**
     * @Title:
     * @Description: 查询所有数据字典与值,并按照顺序排序
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/27 02:09:55
     */
    public List<SysCode> findSysCodesByAll(){
        Example example = SqlUtil.newExample(SysCode.class);
        example.createCriteria().andEqualTo("enableFlag", CommonStatusEnums.ENABLE.getType());
        SqlUtil.setOrderByColumnAsc(example,"order_no");
        return sysCodeRepository.selectListByExample(example);
    }

    /**
     * @Title:
     * @Description: 通过数据字典类型查询对应数据字典集合
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/27 02:09:55
     */
    public List<SysCode> findSysCodesByCodeType(String codeType){
        Example example = SqlUtil.newExample(SysCode.class);
        example.createCriteria().andEqualTo("enableFlag", CommonStatusEnums.ENABLE.getType())
        .andEqualTo("codeType",codeType);
        return sysCodeRepository.selectListByExample(example);
    }

    /**
     * @Title:
     * @Description:   根据codeTypes删除数据字典
     * @param codeTypes
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/04/03 01:26:07
     */
    public int deleteSysCodesByCodeTypes(List<String> codeTypes){
        Example example =  SqlUtil.newExample(SysCode.class);
        example.createCriteria().andIn("codeType",codeTypes);
        return sysCodeRepository.deleteExampleData(example,new SysCode());
    }


    /**
     * @Title:
     * @Description:   初始化字典值
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/27 01:36:30
     */
    public Map<String,Object> initCommonCodeValue() {
        List<SysCode> sysCodes = findSysCodesByAll();
        return initCommonCodeValue(sysCodes);
    }

    /**
     * @Title:
     * @Description:   将数据字典字段值初始化到内存map中
     * @param sysCodes
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/27 03:18:18
     */
    public Map<String,Object> initCommonCodeValue(List<SysCode> sysCodes){
        Map<String,Object> results = new HashMap<>();
        if(ArrayUtils.isNotNullAndLengthNotZero(sysCodes)){
            Map<String,CommonCodeVo> commonCodeValues = new HashMap<>();
            Map<String,List<CommonCodeVo>> commonCodeValuesTree = new HashMap<>();
            //将字典中的值以codeType_codeValue拼接,保存
            for(SysCode sysCode : sysCodes){
                //转换对象
                CommonCodeVo commonCodeVo =  EntityUtils.getEntity(sysCode,new CommonCodeVo());
                //以map形式保存
                commonCodeValues.put(StringUtils.joinDelimiter(StringUtils.LINE,sysCode.getCodeType(),sysCode.getCodeValue()),commonCodeVo);
                //以子节点形式保存
                if(commonCodeValuesTree.get(commonCodeVo.getCodeType()) == null){
                    List<CommonCodeVo> commonCodeVos = new ArrayList<>();
                    commonCodeVos.add(commonCodeVo);
                    commonCodeValuesTree.put(commonCodeVo.getCodeType(),commonCodeVos);
                }else{
                    commonCodeValuesTree.get(commonCodeVo.getCodeType()).add(commonCodeVo);
                }
            }
            //保存到redis中
            redisService.save(CommonCodeRedisKeyEnums.FMS_COMMON_CODE_VALUES.getPrefix(),commonCodeValues);
            redisService.save(CommonCodeRedisKeyEnums.FMS_COMMON_CODE_VALUES_TREE.getPrefix(),commonCodeValuesTree);
            //设置字典版本值
            Integer version = (Integer) redisService.get(CommonCodeRedisKeyEnums.FMS_COMMON_CODE_VALUES_VERSION.getPrefix());
            if(version == null)
                version = 0;
            else
                version += 1;
            redisService.save(CommonCodeRedisKeyEnums.FMS_COMMON_CODE_VALUES_VERSION.getPrefix(),version);
            results.put(CommonCodeTypeConstants.COMMON_CODE_VALUES,commonCodeValues);
            results.put(CommonCodeTypeConstants.COMMON_CODE_VALUES_TREE,commonCodeValuesTree);
            results.put(CommonCodeTypeConstants.COMMON_CODE_VALUE_VERSION,version);
        }
        return results;
    }

    /**
     * @Title:
     * @Description:   获取所有的数据字典,key以codeType_codeValue拼接
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/27 03:52:54
     */
    public Map<String,CommonCodeVo> getCommonCodeValues(){
        Object commonCodeValues = redisService.get(CommonCodeRedisKeyEnums.FMS_COMMON_CODE_VALUES.getPrefix());
        if(commonCodeValues != null)
            return (Map<String,CommonCodeVo>)commonCodeValues;
        return null;
    }

    /**
     * @Title:
     * @Description:   获取所有的数据字典,key为codeType,值为该codeType下的集合
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/27 03:53:30
     */
    public Map<String,List<CommonCodeVo>> getCommonCodeValuesTree(){
        Object commonCodeValuesTree = redisService.get(CommonCodeRedisKeyEnums.FMS_COMMON_CODE_VALUES_TREE.getPrefix());
        if(commonCodeValuesTree != null)
            return (Map<String,List<CommonCodeVo>>)commonCodeValuesTree;
        return null;
    }

    /**
     * @Title:
     * @Description:   获取所有的值
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/27 04:13:52
     */
    public Map<String,Object> getCommonCodeValuesAll(){
        Map<String,Object> results = new HashMap<>();
        Map<String,CommonCodeVo> commonCodeValues = getCommonCodeValues();
        Map<String,List<CommonCodeVo>> commonCodeValuesTree = getCommonCodeValuesTree();
        Integer commonCodeValueVersion = getCommonCodeValueVersion();
        //如果从缓存中获取的值为空，需要刷新缓存，重新放入缓存值
        if(commonCodeValues == null || commonCodeValuesTree == null || commonCodeValueVersion == null){
            return initCommonCodeValue();
        }else {
            results.put(CommonCodeTypeConstants.COMMON_CODE_VALUES, commonCodeValues);
            results.put(CommonCodeTypeConstants.COMMON_CODE_VALUES_TREE, commonCodeValuesTree);
            results.put(CommonCodeTypeConstants.COMMON_CODE_VALUE_VERSION, commonCodeValueVersion);
        }
        return results;
    }

    /**
     * @Title:
     * @Description:   获取code版本
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/27 04:09:38
     */
    public Integer getCommonCodeValueVersion(){
        Integer version = (Integer) redisService.get(CommonCodeRedisKeyEnums.FMS_COMMON_CODE_VALUES_VERSION.getPrefix());
        if(version == null)
            version = 0;
        return version;
    }

}
