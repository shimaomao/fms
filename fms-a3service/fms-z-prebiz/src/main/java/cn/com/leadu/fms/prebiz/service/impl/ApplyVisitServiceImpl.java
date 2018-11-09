package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.common.constant.enums.BizCodeTypeEnums;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.ApplyVisitRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyVisit;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.vo.applyvisit.ApplyVisitVo;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import cn.com.leadu.fms.prebiz.service.ApplyVisitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ApplyVisitService
 * @Description: 贷前家访业务实现层
 * @date 2018-06-04
 */
@Service
public class ApplyVisitServiceImpl implements ApplyVisitService {

    /**
     * @Fields  : 贷前家访repository
     */
    @Autowired
    private ApplyVisitRepository applyVisitRepository;

    @Autowired
    private BizFilesService bizFilesService;

    /**
     * @Title:
     * @Description: 分页查询贷前家访
     * @param applyVisitVo
     * @return PageInfoExtend<ApplyVisit>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:00:52
     */
    public PageInfoExtend<ApplyVisit> findApplyVisitsByPage(ApplyVisitVo applyVisitVo){
        Example example = SqlUtil.newExample(ApplyVisit.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<ApplyVisit> pageInfo = applyVisitRepository.selectListByExamplePage(example,applyVisitVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description:  根据applyVisitId获取贷前家访
     * @param applyVisitId
     * @return ApplyVisit
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:00:52
     */
    public ApplyVisit findApplyVisitByApplyVisitId(String applyVisitId){
        return applyVisitRepository.selectByPrimaryKey(applyVisitId);
    }

    /**
     * @Title:
     * @Description:  根据applyNo获取贷前家访
     * @param applyNo
     * @return ApplyVisit
     * @throws
     * @author ningyangyang
     * @date 2018-6-4 15:00:52
     */
   public ApplyVisitVo findApplyVisitByApplyNo(String applyNo){
       Example example = SqlUtil.newExample(ApplyVisit.class);
       example.createCriteria().andEqualTo("applyNo",applyNo);
       ApplyVisit applyVisit = applyVisitRepository.selectOneByExample(example);
       if(applyVisit == null){
           return new ApplyVisitVo();
       }
       List<BizFiles> BizFilesList =  bizFilesService.findBizFilesList(applyNo, BizCodeTypeEnums.APPLY_VISIT.getCodeType());
       ApplyVisitVo applyVisitVo = EntityUtils.getEntity(applyVisit,new ApplyVisitVo());
       applyVisitVo.setBizFiles(BizFilesList);
       return applyVisitVo;
   }
}
