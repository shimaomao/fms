package cn.com.leadu.fms.asset.service.impl;

import cn.com.leadu.fms.asset.service.EquMorRepayDetailService;
import cn.com.leadu.fms.common.constant.enums.asset.EquMorRepayDetailEnums;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.asset.repository.EquMorRepayDetailRepository;
import cn.com.leadu.fms.pojo.asset.entity.EquMorRepayDetail;
import cn.com.leadu.fms.pojo.asset.vo.equmorrepaydetail.EquMorRepayDetailVo;
import cn.com.leadu.fms.asset.validator.equmorrepaydetail.vo.EquMorRepayDetailSaveVo;
import cn.com.leadu.fms.asset.validator.equmorrepaydetail.vo.EquMorRepayDetailModifyVo;
import cn.com.leadu.fms.asset.validator.equmorrepaydetail.vo.EquMorRepayDetailDeleteVo;
import cn.com.leadu.fms.asset.validator.equmorrepaydetail.vo.EquMorRepayDetailDeleteListVo;
import cn.com.leadu.fms.pojo.postbiz.vo.annualinspection.AnnualInspectionVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author qinmuqiao
 * @ClassName: EquMorRepayDetailService
 * @Description: 资方抵押还款计划业务实现层
 */
@Service
public class EquMorRepayDetailServiceImpl implements EquMorRepayDetailService {

    /**
     * @Fields  : 资方抵押还款计划repository
     */
    @Autowired
    private EquMorRepayDetailRepository equMorRepayDetailRepository;

    /**
     * @Title:
     * @Description: 分页查询资方抵押还款计划
     * @param equMorRepayDetailVo
     * @return PageInfoExtend<EquMorRepayDetail>
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    public PageInfoExtend<EquMorRepayDetailVo> selectEquMorRepayDetailVosByPage(EquMorRepayDetailVo equMorRepayDetailVo){

        if (StringUtils.isNotTrimBlank(equMorRepayDetailVo.getClientContNo())){
            equMorRepayDetailVo.setClientContNo(SqlUtil.likePattern(equMorRepayDetailVo.getClientContNo()));
        }else{
            equMorRepayDetailVo.setClientContNo(null);
        }

        if (StringUtils.isNotTrimBlank(equMorRepayDetailVo.getTenantUser())){
            equMorRepayDetailVo.setTenantUser(SqlUtil.likePattern(equMorRepayDetailVo.getTenantUser()));
        }else{
            equMorRepayDetailVo.setTenantUser(null);
        }

        if (StringUtils.isNotTrimBlank(equMorRepayDetailVo.getVinNo())){
            equMorRepayDetailVo.setVinNo(SqlUtil.likePattern(equMorRepayDetailVo.getVinNo()));
        }else{
            equMorRepayDetailVo.setVinNo(null);
        }

        if (StringUtils.isNotTrimBlank(equMorRepayDetailVo.getManagement())){
            equMorRepayDetailVo.setManagement(SqlUtil.likePattern(equMorRepayDetailVo.getManagement()));
        }else{
            equMorRepayDetailVo.setManagement(null);
        }

        //起始时间
        if(StringUtils.isTrimBlank(equMorRepayDetailVo.getRepaySatrtStr()))
            equMorRepayDetailVo.setRepaySatrtStr(null);
        else
            equMorRepayDetailVo.setRepaySatrtStr(equMorRepayDetailVo.getRepaySatrtStr());

        //结束时间
        if(StringUtils.isTrimBlank(equMorRepayDetailVo.getRepayEndStr()))
            equMorRepayDetailVo.setRepayEndStr(null);
        else
            equMorRepayDetailVo.setRepayEndStr(equMorRepayDetailVo.getRepayEndStr());

        //还款状态
        if (StringUtils.isNotTrimBlank(equMorRepayDetailVo.getEquRepayStatus())){
            equMorRepayDetailVo.setEquRepayStatus(SqlUtil.likePattern(equMorRepayDetailVo.getClientContNo()));
        }else{
            equMorRepayDetailVo.setEquRepayStatus(null);
        }


        PageInfoExtend<EquMorRepayDetailVo> pageInfo = equMorRepayDetailRepository.selectListVoByPage("selectEquMorRepayDetailVosByPage",equMorRepayDetailVo,equMorRepayDetailVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存资方抵押还款计划
     * @param equMorRepayDetailSaveVo
     * @return java.lang.String
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    public void saveEquMorRepayDetail(EquMorRepayDetailSaveVo equMorRepayDetailSaveVo){
        equMorRepayDetailRepository.insertData(equMorRepayDetailSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改资方抵押还款计划
     * @param equMorRepayDetailModifyVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    public void modifyEquMorRepayDetail(EquMorRepayDetailModifyVo equMorRepayDetailModifyVo){
        equMorRepayDetailRepository.updateByPrimaryKeySelectiveData(equMorRepayDetailModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过equMorRepayDetailId删除资方抵押还款计划
     * @param equMorRepayDetailDeleteVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    public void deleteEquMorRepayDetail(EquMorRepayDetailDeleteVo equMorRepayDetailDeleteVo){
        equMorRepayDetailRepository.deleteData(equMorRepayDetailDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过equMorRepayDetailId集合删除资方抵押还款计划
     * @param equMorRepayDetailDeleteListVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    public void deleteEquMorRepayDetailsByEquMorRepayDetailIds(EquMorRepayDetailDeleteListVo equMorRepayDetailDeleteListVo){
        equMorRepayDetailRepository.deleteDataList(equMorRepayDetailDeleteListVo.getEquMorRepayDetailIds(),equMorRepayDetailDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据equMorRepayDetailId获取资方抵押还款计划
     * @param equMorRepayDetailId
     * @return EquMorRepayDetail
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    public EquMorRepayDetail findEquMorRepayDetailByEquMorRepayDetailId(String equMorRepayDetailId){
        return equMorRepayDetailRepository.selectByPrimaryKey(equMorRepayDetailId);
    }

    /**
     * @Title:
     * @Description:  更新还款状态
     * @param equMorRepayDetails
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-10-26 14:06:47
     */
    public void updateEquMorRepayDetailPayStatus(List<EquMorRepayDetail> equMorRepayDetails) {
        for (EquMorRepayDetail repayDetail:equMorRepayDetails) {
            if (repayDetail.getPayUpdateDate() != null){
                repayDetail.setEquRepayStatus(EquMorRepayDetailEnums.ALREADY_PAY.getType());
            }
        }
        equMorRepayDetailRepository.updateByPrimaryKeySelectiveDataList(equMorRepayDetails);
    }

}
