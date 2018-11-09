package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.common.constant.enums.sql.DeleteFlags;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.prebiz.service.CstmPersMateService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.CstmPersMateRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmPersMate;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmpersmate.CstmPersMateVo;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.prebiz.validator.cstmpersmate.vo.CstmPersMateSaveVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersmate.vo.CstmPersMateModifyVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersmate.vo.CstmPersMateDeleteVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersmate.vo.CstmPersMateDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author ningyangyang
 * @ClassName: CstmPersMateService
 * @Description: 客户个人配偶信息业务实现层
 * @date 2018-03-26
 */
@Service
public class CstmPersMateServiceImpl implements CstmPersMateService {

    /**
     * @Fields  : 客户个人配偶信息repository
     */
    @Autowired
    private CstmPersMateRepository cstmPersMateRepository;
    /**
     * 枚举类
     */
    @Autowired
    private NumGenerateService numGenerateService;
    /**
     * @Title:
     * @Description: 分页查询客户个人配偶信息
     * @param cstmPersMateVo
     * @return PageInfoExtend<CstmPersMate>
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    public PageInfoExtend<CstmPersMate> findCstmPersMatesByPage(CstmPersMateVo cstmPersMateVo){
        Example example = SqlUtil.newExample(CstmPersMate.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<CstmPersMate> pageInfo = cstmPersMateRepository.selectListByExamplePage(example,cstmPersMateVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存客户个人配偶信息
     * @param cstmPersMateSaveVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    public void saveCstmPersMate(CstmPersMateSaveVo cstmPersMateSaveVo,String applyNo){
        //获取订单编号
       // String contractNo =  numGenerateService.getNumGenerateByNumType(CONTRACT_NUM_TYPE.getType());
        CstmPersMate cstmPersMate = cstmPersMateSaveVo.getEntity();
        cstmPersMate.setApplyNo(applyNo);
        cstmPersMateRepository.insertData(cstmPersMate);
    }

    /**
     * @Title:
     * @Description: 修改客户个人配偶信息
     * @param cstmPersMateModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    public void modifyCstmPersMate(CstmPersMateModifyVo cstmPersMateModifyVo){
        cstmPersMateRepository.updateByPrimaryKeySelectiveData(cstmPersMateModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过persMateId删除客户个人配偶信息
     * @param cstmPersMateDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    public void deleteCstmPersMate(CstmPersMateDeleteVo cstmPersMateDeleteVo){
        cstmPersMateRepository.deleteData(cstmPersMateDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过persMateId集合删除客户个人配偶信息
     * @param cstmPersMateDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    public void deleteCstmPersMatesByPersMateIds(CstmPersMateDeleteListVo cstmPersMateDeleteListVo){
        cstmPersMateRepository.deleteDataList(cstmPersMateDeleteListVo.getPersMateIds(),cstmPersMateDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据persMateId获取客户个人配偶信息
     * @param persMateId
     * @return CstmPersMate
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    public CstmPersMate findCstmPersMateByPersMateId(String persMateId){
        return cstmPersMateRepository.selectByPrimaryKey(persMateId);
    }

    /**
     * 根据订单编号获取配偶信息
     * @param applyNo
     * @return
     */
    public CstmPersMate findCstmPersMateByApplyNo(String applyNo){
        Example example = SqlUtil.newExample(CstmPersMate.class);
        example.createCriteria().andEqualTo("applyNo",applyNo);
        return cstmPersMateRepository.selectOneByExample(example);
    }
    /**
     * @Title:
     * @Description:  根据applyNo更新客户个人配偶信息
     * @param cstmPersMate
     * @return CstmPersMate
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 20:22:15
     */
    @Override
    public void updateCstmPersMateByapplyNo(CstmPersMate cstmPersMate,String applyNo) {
        if(StringUtils.isNotTrimBlank(applyNo)){
            Example example = SqlUtil.newExample(CstmPersMate.class);
            example.createCriteria().andEqualTo("applyNo",applyNo);
            CstmPersMate oldCstmPersMate = cstmPersMateRepository.selectOneByExample(example);
            cstmPersMate.setApplyNo(applyNo);
            cstmPersMate.setDelFlag(DeleteFlags.EXIST.getFlag());
            if(oldCstmPersMate != null){
                cstmPersMate.setCreateTime(oldCstmPersMate.getCreateTime());
                cstmPersMate.setCreator(oldCstmPersMate.getCreator());
            }
            cstmPersMateRepository.updateByExampleData(cstmPersMate,example);
        }
    }
}
