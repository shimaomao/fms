package cn.com.leadu.fms.cost.service.impl;

import cn.com.leadu.fms.cost.service.ContPrepayDetailService;
import cn.com.leadu.fms.cost.validator.contprepaydetail.vo.ContPrepayDetailDeleteListVo;
import cn.com.leadu.fms.cost.validator.contprepaydetail.vo.ContPrepayDetailDeleteVo;
import cn.com.leadu.fms.cost.validator.contprepaydetail.vo.ContPrepayDetailModifyVo;
import cn.com.leadu.fms.cost.validator.contprepaydetail.vo.ContPrepayDetailSaveVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.cost.repository.ContPrepayDetailRepository;
import cn.com.leadu.fms.pojo.cost.entity.ContPrepayDetail;
import cn.com.leadu.fms.pojo.cost.vo.contprepaydetail.ContPrepayDetailVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: ContPrepayDetailService
 * @Description: 提前还款明细业务实现层
 * @date 2018-05-11
 */
@Service
public class ContPrepayDetailServiceImpl implements ContPrepayDetailService {

    /**
     * @Fields  : 提前还款明细repository
     */
    @Autowired
    private ContPrepayDetailRepository contPrepayDetailRepository;

    /**
     * @Title:
     * @Description: 分页查询提前还款明细
     * @param contPrepayDetailVo
     * @return PageInfoExtend<ContPrepayDetail>
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    public PageInfoExtend<ContPrepayDetail> findContPrepayDetailsByPage(ContPrepayDetailVo contPrepayDetailVo){
        Example example = SqlUtil.newExample(ContPrepayDetail.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<ContPrepayDetail> pageInfo = contPrepayDetailRepository.selectListByExamplePage(example,contPrepayDetailVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @param contPrepaymentNo
     * @Description: 根据提前还款任务号查询提前还款明细
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/14 17:45
     */
    @Override
    public List<ContPrepayDetail> findContPrepayDetailVoByContPrepaymentNo(String contPrepaymentNo) {
        Example example = SqlUtil.newExample(ContPrepayDetail.class);

        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("contPrepaymentNo",contPrepaymentNo);
        SqlUtil.setOrderByColumnAsc(example,"order_no");
        return contPrepayDetailRepository.selectListByExample(example);
    }

    /**
     * @Title:
     * @Description: 保存提前还款明细
     * @param contPrepayDetailSaveVo
     * @return java.lang.String
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    public void saveContPrepayDetail(ContPrepayDetailSaveVo contPrepayDetailSaveVo){
        contPrepayDetailRepository.insertData(contPrepayDetailSaveVo.getEntity());
    }

    /**
     * @param contPrepayDetailList
     * @Description: 批量保存提前还款明细
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/14 19:02
     */
    @Override
    public void saveDataList(List<ContPrepayDetail> contPrepayDetailList) {
        contPrepayDetailRepository.insertDataList(contPrepayDetailList);
    }

    /**
     * @Title:
     * @Description: 修改提前还款明细
     * @param contPrepayDetailModifyVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    public void modifyContPrepayDetail(ContPrepayDetailModifyVo contPrepayDetailModifyVo){
        contPrepayDetailRepository.updateByPrimaryKeySelectiveData(contPrepayDetailModifyVo.getEntity());
    }

    /**
     * @param contPrepayDetailList
     * @Description: 批量动态修改提前还款明细
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/15 14:58
     */
    @Override
    public void modifyByPrimaryKeySelectiveDataList(List<ContPrepayDetail> contPrepayDetailList) {
        contPrepayDetailRepository.updateByPrimaryKeySelectiveDataList(contPrepayDetailList);
    }

    /**
     * @Title:
     * @Description:  通过contPrepayDetailId删除提前还款明细
     * @param contPrepayDetailDeleteVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    public void deleteContPrepayDetail(ContPrepayDetailDeleteVo contPrepayDetailDeleteVo){
        contPrepayDetailRepository.deleteData(contPrepayDetailDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过contPrepayDetailId集合删除提前还款明细
     * @param contPrepayDetailDeleteListVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    public void deleteContPrepayDetailsByContPrepayDetailIds(ContPrepayDetailDeleteListVo contPrepayDetailDeleteListVo){
        contPrepayDetailRepository.deleteDataList(contPrepayDetailDeleteListVo.getContPrepayDetailIds(),contPrepayDetailDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据contPrepayDetailId获取提前还款明细
     * @param contPrepayDetailId
     * @return ContPrepayDetail
     * @throws
     * @author yangyiquan
     * @date 2018-5-11 18:02:32
     */
    public ContPrepayDetail findContPrepayDetailByContPrepayDetailId(String contPrepayDetailId){
        return contPrepayDetailRepository.selectByPrimaryKey(contPrepayDetailId);
    }

}
