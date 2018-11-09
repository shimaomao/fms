package cn.com.leadu.fms.system.service.impl;

import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.system.repository.SysCodeTypeRepository;
import cn.com.leadu.fms.pojo.system.entity.SysCodeType;
import cn.com.leadu.fms.pojo.system.vo.syscodetype.SysCodeTypeVo;
import cn.com.leadu.fms.system.service.SysCodeService;
import cn.com.leadu.fms.system.service.SysCodeTypeService;
import cn.com.leadu.fms.system.validator.syscodetype.vo.SysCodeTypeDeleteListVo;
import cn.com.leadu.fms.system.validator.syscodetype.vo.SysCodeTypeDeleteVo;
import cn.com.leadu.fms.system.validator.syscodetype.vo.SysCodeTypeModifyVo;
import cn.com.leadu.fms.system.validator.syscodetype.vo.SysCodeTypeSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.Map;

/**
 * @author huchenghao
 * @ClassName: SysCodeTypeService
 * @Description: 字典数据类型业务实现层
 * @date 2018-03-08
 */
@Service
public class SysCodeTypeServiceImpl implements SysCodeTypeService {

    @Autowired
    private SysCodeTypeRepository sysCodeTypeRepository;
    @Autowired
    private SysCodeService sysCodeService;

    /**
     * @Title:
     * @Description: 保存字典数据类型
     * @param sysCodeTypeSaveVo
     * @return java.lang.String
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    public void saveSysCodeType(SysCodeTypeSaveVo sysCodeTypeSaveVo){
        sysCodeTypeRepository.insertData(sysCodeTypeSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改字典数据类型
     * @param sysCodeTypeModifyVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    public void modifySysCodeType(SysCodeTypeModifyVo sysCodeTypeModifyVo){
        sysCodeTypeRepository.updateByPrimaryKeySelectiveData(sysCodeTypeModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过id删除字典数据类型
     * @param sysCodeTypeDeleteVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    public void deleteSysCodeType(SysCodeTypeDeleteVo sysCodeTypeDeleteVo){
        sysCodeTypeRepository.deleteData(sysCodeTypeDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过id集合删除字典数据类型
     * @param sysCodeTypeDeleteListVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    @Transactional
    public Map<String,Object> deleteSysCodeTypeByIds(SysCodeTypeDeleteListVo sysCodeTypeDeleteListVo){
        Example example = SqlUtil.newExample(SysCodeType.class);
        example.createCriteria().andIn("codeType",sysCodeTypeDeleteListVo.getCodeTypeIds());
        //sysCodeService.deleteExampleData(sysCodeTypeDeleteListVo.getCodeTypeIds());
        sysCodeService.deleteSysCodesByCodeTypes(sysCodeTypeDeleteListVo.getCodeTypeIds());
        sysCodeTypeRepository.deleteExampleData(example,new SysCodeType());
        return sysCodeService.initCommonCodeValue();
    }

    /**
     * @Title:
     * @Description:  根据id字典数据类型
     * @param codeTypeId
     * @return SysCodeType
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    public SysCodeType findSysCodeTypeById(String codeTypeId){
        return sysCodeTypeRepository.selectByPrimaryKey(codeTypeId);
    }

    /**
     * @Title:
     * @Description:  根据codeType字典数据类型
     * @param codeType
     * @return SysCodeType
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    public SysCodeType findSysCodeTypeByCodeType(String codeType){
        Example example = SqlUtil.newExample(SysCodeType.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotTrimBlank(codeType))
            criteria.andEqualTo("codeType",codeType);
        SqlUtil.setOrderByCreateTimeDesc(example);
        return sysCodeTypeRepository.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description: 分页查询字典数据类型
     * @param sysCodeTypeVo
     * @return PageInfoExtend<SysCodeType>
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:57
     */
    public PageInfoExtend<SysCodeType> findSysCodeTypesByPage(SysCodeTypeVo sysCodeTypeVo){
        Example example = SqlUtil.newExample(SysCodeType.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotTrimBlank(sysCodeTypeVo.getCodeType()))
            criteria.andLike("codeType", SqlUtil.likePattern(sysCodeTypeVo.getCodeType()));

        if(StringUtils.isNotTrimBlank(sysCodeTypeVo.getCodeTypeName()))
            criteria.andLike("codeTypeName",SqlUtil.likePattern(sysCodeTypeVo.getCodeTypeName()));

        if(StringUtils.isNotTrimBlank(sysCodeTypeVo.getEnableFlag()))
            criteria.andLike("enableFlag",SqlUtil.likePattern(sysCodeTypeVo.getEnableFlag()));

        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<SysCodeType> pageInfo = sysCodeTypeRepository.selectListByExamplePage(example,sysCodeTypeVo.getPageQuery());
        return pageInfo;
    }

}
