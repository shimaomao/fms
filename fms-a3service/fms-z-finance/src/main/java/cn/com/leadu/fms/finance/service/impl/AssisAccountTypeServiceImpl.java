package cn.com.leadu.fms.finance.service.impl;

import cn.com.leadu.fms.business.service.CommonAssisAccountTypeService;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.finance.service.AssisAccountTypeService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.AssisAccountTypeRepository;
import cn.com.leadu.fms.pojo.finance.entity.AssisAccountType;
import cn.com.leadu.fms.pojo.finance.entity.SubjectAssisAccount;
import cn.com.leadu.fms.pojo.finance.vo.assisaccounttype.AssisAccountTypeVo;
import cn.com.leadu.fms.finance.validator.assisaccounttype.vo.AssisAccountTypeSaveVo;
import cn.com.leadu.fms.finance.validator.assisaccounttype.vo.AssisAccountTypeModifyVo;
import cn.com.leadu.fms.finance.validator.assisaccounttype.vo.AssisAccountTypeDeleteVo;
import cn.com.leadu.fms.finance.validator.assisaccounttype.vo.AssisAccountTypeDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import tk.mybatis.mapper.util.StringUtil;

import java.util.ArrayList;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: AssisAccountTypeService
 * @Description: 辅助核算类型管理业务实现层
 * @date 2018-06-23
 */
@Service
public class AssisAccountTypeServiceImpl implements AssisAccountTypeService , CommonAssisAccountTypeService {

    /**
     * @Fields  : 辅助核算类型管理repository
     */
    @Autowired
    private AssisAccountTypeRepository assisAccountTypeRepository;

    /**
     * @Title:
     * @Description: 分页查询辅助核算类型管理
     * @param assisAccountTypeVo
     * @return PageInfoExtend<AssisAccountType>
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    public PageInfoExtend<AssisAccountType> findAssisAccountTypesByPage(AssisAccountTypeVo assisAccountTypeVo){
        Example example = SqlUtil.newExample(AssisAccountType.class);
        if(StringUtil.isNotEmpty(assisAccountTypeVo.getAssisAccountType())){
            example.createCriteria().andEqualTo("assisAccountType",assisAccountTypeVo.getAssisAccountType());
        }
        if(StringUtil.isNotEmpty(assisAccountTypeVo.getAssisAccountTypeName())){
            example.createCriteria().andLike("assisAccountTypeName",SqlUtil.likePattern(assisAccountTypeVo.getAssisAccountTypeName()));
        }
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<AssisAccountType> pageInfo = assisAccountTypeRepository.selectListByExamplePage(example,assisAccountTypeVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存辅助核算类型管理
     * @param assisAccountTypeSaveVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    public void saveAssisAccountType(AssisAccountTypeSaveVo assisAccountTypeSaveVo){
        Example example = SqlUtil.newExample(AssisAccountType.class);
        example.createCriteria().andEqualTo("assisAccountType",assisAccountTypeSaveVo.getAssisAccountType());
        AssisAccountType assisAccountType = assisAccountTypeRepository.selectOneByExample(example);
        if(assisAccountType != null){
            throw new FmsServiceException("该类型已经存在!");
        }
        assisAccountTypeRepository.insertData(assisAccountTypeSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改辅助核算类型管理
     * @param assisAccountTypeModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    public void modifyAssisAccountType(AssisAccountTypeModifyVo assisAccountTypeModifyVo){
        assisAccountTypeRepository.updateByPrimaryKeySelectiveData(assisAccountTypeModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过assisAccountTypeId删除辅助核算类型管理
     * @param assisAccountTypeDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    public void deleteAssisAccountType(AssisAccountTypeDeleteVo assisAccountTypeDeleteVo){
        assisAccountTypeRepository.deleteData(assisAccountTypeDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过assisAccountTypeId集合删除辅助核算类型管理
     * @param assisAccountTypeDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    public void deleteAssisAccountTypesByAssisAccountTypeIds(AssisAccountTypeDeleteListVo assisAccountTypeDeleteListVo){
        assisAccountTypeRepository.deleteDataList(assisAccountTypeDeleteListVo.getAssisAccountTypeIds(),assisAccountTypeDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据assisAccountTypeId获取辅助核算类型管理
     * @param assisAccountTypeId
     * @return AssisAccountType
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:17
     */
    public AssisAccountType findAssisAccountTypeByAssisAccountTypeId(String assisAccountTypeId){
        return assisAccountTypeRepository.selectByPrimaryKey(assisAccountTypeId);
    }

    /**
     * @Title:
     * @Description:   根据types集合获取辅助核算类型管理
     * @param assisAccountTypes
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/26 10:49:32
     */
    public List<AssisAccountType> findAssisAccountTypesByAccTypes(List<String> assisAccountTypes){
        Example example = SqlUtil.newExample(AssisAccountType.class);
        example.createCriteria().andIn("assisAccountType",assisAccountTypes);
        return assisAccountTypeRepository.selectListByExample(example);
    }

    /**
     * @Title:
     * @Description: 分页查询辅助核算类型管理弹出框
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public PageInfoExtend<AssisAccountTypeVo> findAssisAccountTypesByPage2(AssisAccountTypeVo assisAccountTypeVo){
        return assisAccountTypeRepository.selectListVoByPage("selectAssisAccountTypesByPage2",assisAccountTypeVo,assisAccountTypeVo.getPageQuery());
    }

}
