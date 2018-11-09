package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.common.constant.enums.sql.DeleteFlags;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.CstmPersJobRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmPersJob;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmpersjob.CstmPersJobVo;
import cn.com.leadu.fms.prebiz.service.CstmPersJobService;
import cn.com.leadu.fms.prebiz.validator.cstmpersjob.vo.CstmPersJobDeleteListVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersjob.vo.CstmPersJobDeleteVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersjob.vo.CstmPersJobModifyVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersjob.vo.CstmPersJobSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author ningyangyang
 * @ClassName: CstmPersJobService
 * @Description: 客户个人职业信息业务实现层
 * @date 2018-03-26
 */
@Service
public class CstmPersJobServiceImpl implements CstmPersJobService {

    /**
     * @Fields  : 客户个人职业信息repository
     */
    @Autowired
    private CstmPersJobRepository cstmPersJobRepository;
    /**
     * 枚举类
     */
    @Autowired
    private NumGenerateService numGenerateService;
    /**
     * @Title:
     * @Description: 分页查询客户个人职业信息
     * @param cstmPersJobVo
     * @return PageInfoExtend<CstmPersJob>
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:48
     */
    public PageInfoExtend<CstmPersJob> findCstmPersJobsByPage(CstmPersJobVo cstmPersJobVo){
        Example example = SqlUtil.newExample(CstmPersJob.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<CstmPersJob> pageInfo = cstmPersJobRepository.selectListByExamplePage(example,cstmPersJobVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存客户个人职业信息
     * @param cstmPersJobSaveVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:48
     */
    public void saveCstmPersJob(CstmPersJobSaveVo cstmPersJobSaveVo,String applyNo){
        //获取订单编号
       // String contractNo =  numGenerateService.getNumGenerateByNumType(CONTRACT_NUM_TYPE.getType());
        CstmPersJob cstmPersJob = cstmPersJobSaveVo.getEntity();
        cstmPersJob.setApplyNo(applyNo);
        cstmPersJobRepository.insertData(cstmPersJob);
    }

    /**
     * @Title:
     * @Description: 修改客户个人职业信息
     * @param cstmPersJobModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:48
     */
    public void modifyCstmPersJob(CstmPersJobModifyVo cstmPersJobModifyVo){
        cstmPersJobRepository.updateByPrimaryKeySelectiveData(cstmPersJobModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过persJobId删除客户个人职业信息
     * @param cstmPersJobDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:48
     */
    public void deleteCstmPersJob(CstmPersJobDeleteVo cstmPersJobDeleteVo){
        cstmPersJobRepository.deleteData(cstmPersJobDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过persJobId集合删除客户个人职业信息
     * @param cstmPersJobDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:48
     */
    public void deleteCstmPersJobsByPersJobIds(CstmPersJobDeleteListVo cstmPersJobDeleteListVo){
        cstmPersJobRepository.deleteDataList(cstmPersJobDeleteListVo.getPersJobIds(),cstmPersJobDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据persJobId获取客户个人职业信息
     * @param persJobId
     * @return CstmPersJob
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:48
     */
    public CstmPersJob findCstmPersJobByPersJobId(String persJobId){
        return cstmPersJobRepository.selectByPrimaryKey(persJobId);
    }

    /**
     * 根据订单编号获取职业信息
     * @param applyNo
     * @return
     */
    public CstmPersJob findCstmPersJobByApplyNo(String applyNo){
        Example example = SqlUtil.newExample(CstmPersJob.class);
        example.createCriteria().andEqualTo("applyNo",applyNo);
        return cstmPersJobRepository.selectOneByExample(example);
    }
    /**
     * @Title:
     * @Description:  根据applyNo更新客户个人职业信息
     * @param cstmPersJob
     * @return CstmPersJob
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 16:16:48
     */
    @Override
    public void updateCstmPersJobByApplyNo(CstmPersJob cstmPersJob,String applyNo) {
        if(StringUtils.isNotTrimBlank(applyNo)){
            Example example = SqlUtil.newExample(CstmPersJob.class);
            example.createCriteria().andEqualTo("applyNo",applyNo);
            CstmPersJob oldCstmPersJob = cstmPersJobRepository.selectOneByExample(example);
            cstmPersJob.setApplyNo(applyNo);
            cstmPersJob.setDelFlag(DeleteFlags.EXIST.getFlag());
            if(oldCstmPersJob != null){
                cstmPersJob.setCreateTime(oldCstmPersJob.getCreateTime());
                cstmPersJob.setCreator(oldCstmPersJob.getCreator());
            }
            cstmPersJobRepository.updateByExampleData(cstmPersJob,example);
        }
    }
}
