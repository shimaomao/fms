package cn.com.leadu.fms.finance.service.impl;

import cn.com.leadu.fms.finance.service.FinBackfillDetailService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.FinBackfillDetailRepository;
import cn.com.leadu.fms.pojo.finance.entity.FinBackfillDetail;
import cn.com.leadu.fms.pojo.finance.vo.finbackfilldetail.FinBackfillDetailVo;
import cn.com.leadu.fms.finance.validator.finbackfilldetail.vo.FinBackfillDetailSaveVo;
import cn.com.leadu.fms.finance.validator.finbackfilldetail.vo.FinBackfillDetailModifyVo;
import cn.com.leadu.fms.finance.validator.finbackfilldetail.vo.FinBackfillDetailDeleteVo;
import cn.com.leadu.fms.finance.validator.finbackfilldetail.vo.FinBackfillDetailDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author lijunjun
 * @ClassName: FinBackfillDetailService
 * @Description: 融资回填明细业务实现层
 * @date 2018-05-12
 */
@Service
public class FinBackfillDetailServiceImpl implements FinBackfillDetailService {

    /**
     * @Fields  : 融资回填明细repository
     */
    @Autowired
    private FinBackfillDetailRepository finBackfillDetailRepository;

    /**
     * @Title:
     * @Description: 分页查询融资回填明细
     * @param finBackfillDetailVo
     * @return PageInfoExtend<FinBackfillDetail>
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    public PageInfoExtend<FinBackfillDetail> findFinBackfillDetailsByPage(FinBackfillDetailVo finBackfillDetailVo){
        Example example = SqlUtil.newExample(FinBackfillDetail.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<FinBackfillDetail> pageInfo = finBackfillDetailRepository.selectListByExamplePage(example,finBackfillDetailVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存融资回填明细
     * @param finBackfillDetailSaveVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    public void saveFinBackfillDetail(FinBackfillDetailSaveVo finBackfillDetailSaveVo){
        finBackfillDetailRepository.insertData(finBackfillDetailSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改融资回填明细
     * @param finBackfillDetailModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    public void modifyFinBackfillDetail(FinBackfillDetailModifyVo finBackfillDetailModifyVo){
        finBackfillDetailRepository.updateByPrimaryKeySelectiveData(finBackfillDetailModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过finBackfillDetailId删除融资回填明细
     * @param finBackfillDetailDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    public void deleteFinBackfillDetail(FinBackfillDetailDeleteVo finBackfillDetailDeleteVo){
        finBackfillDetailRepository.deleteData(finBackfillDetailDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过finBackfillDetailId集合删除融资回填明细
     * @param finBackfillDetailDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    public void deleteFinBackfillDetailsByFinBackfillDetailIds(FinBackfillDetailDeleteListVo finBackfillDetailDeleteListVo){
        finBackfillDetailRepository.deleteDataList(finBackfillDetailDeleteListVo.getFinBackfillDetailIds(),finBackfillDetailDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据finBackfillDetailId获取融资回填明细
     * @param finBackfillDetailId
     * @return FinBackfillDetail
     * @throws
     * @author lijunjun
     * @date 2018-5-12 13:44:42
     */
    public FinBackfillDetail findFinBackfillDetailByFinBackfillDetailId(String finBackfillDetailId){
        return finBackfillDetailRepository.selectByPrimaryKey(finBackfillDetailId);
    }

}
