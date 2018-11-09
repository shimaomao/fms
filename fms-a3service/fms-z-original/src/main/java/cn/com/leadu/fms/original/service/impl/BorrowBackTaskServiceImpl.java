package cn.com.leadu.fms.original.service.impl;

import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.prebiz.repository.ContPayRepository;
import cn.com.leadu.fms.original.service.BorrowBackTaskService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.original.repository.BorrowBackTaskRepository;
import cn.com.leadu.fms.pojo.original.entity.BorrowBackTask;
import cn.com.leadu.fms.pojo.original.vo.borrowbacktask.BorrowBackTaskVo;
import cn.com.leadu.fms.original.validator.borrowbacktask.vo.BorrowBackTaskSaveVo;
import cn.com.leadu.fms.original.validator.borrowbacktask.vo.BorrowBackTaskModifyVo;
import cn.com.leadu.fms.original.validator.borrowbacktask.vo.BorrowBackTaskDeleteVo;
import cn.com.leadu.fms.original.validator.borrowbacktask.vo.BorrowBackTaskDeleteListVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author lijunjun
 * @ClassName: BorrowBackTaskService
 * @Description: 借阅归还任务信息业务实现层
 * @date 2018-06-04
 */
@Service
public class BorrowBackTaskServiceImpl implements BorrowBackTaskService {

    /**
     * @Fields  : 借阅归还任务信息repository
     */
    @Autowired
    private BorrowBackTaskRepository borrowBackTaskRepository;

    /**
     * @Fields  : 财务付款表repository
     */
    @Autowired
    private ContPayRepository contPayRepository;

    /**
     * @Title:
     * @Description: 分页查询借阅归还任务信息
     * @param borrowBackTaskVo
     * @return PageInfoExtend<BorrowBackTask>
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    public PageInfoExtend<BorrowBackTask> findBorrowBackTasksByPage(BorrowBackTaskVo borrowBackTaskVo){
        Example example = SqlUtil.newExample(BorrowBackTask.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<BorrowBackTask> pageInfo = borrowBackTaskRepository.selectListByExamplePage(example,borrowBackTaskVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存借阅归还任务信息
     * @param borrowBackTaskSaveVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    public void saveBorrowBackTask(BorrowBackTaskSaveVo borrowBackTaskSaveVo){
        borrowBackTaskRepository.insertData(borrowBackTaskSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改借阅归还任务信息
     * @param borrowBackTaskModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    public void modifyBorrowBackTask(BorrowBackTaskModifyVo borrowBackTaskModifyVo){
        borrowBackTaskRepository.updateByPrimaryKeySelectiveData(borrowBackTaskModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过borrowBackTaskId删除借阅归还任务信息
     * @param borrowBackTaskDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    public void deleteBorrowBackTask(BorrowBackTaskDeleteVo borrowBackTaskDeleteVo){
        borrowBackTaskRepository.deleteData(borrowBackTaskDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过borrowBackTaskId集合删除借阅归还任务信息
     * @param borrowBackTaskDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    public void deleteBorrowBackTasksByBorrowBackTaskIds(BorrowBackTaskDeleteListVo borrowBackTaskDeleteListVo){
        borrowBackTaskRepository.deleteDataList(borrowBackTaskDeleteListVo.getBorrowBackTaskIds(),borrowBackTaskDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据borrowBackTaskId获取借阅归还任务信息
     * @param borrowBackTaskId
     * @return BorrowBackTask
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    public BorrowBackTask findBorrowBackTaskByBorrowBackTaskId(String borrowBackTaskId){
        return borrowBackTaskRepository.selectByPrimaryKey(borrowBackTaskId);
    }

    /**
     * @Title:
     * @Description: 根据borrowBackTaskNo获取借阅归还任务信息
     * @param borrowBackTaskNo
     * @return BorrowBackTask
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @Override
    public BorrowBackTaskVo findBorrowBackTaskByBorrowBackTaskNo(String borrowBackTaskNo) {
        if (StringUtils.isTrimBlank(borrowBackTaskNo)){
            throw new FmsServiceException("归还任务号不能为空");
        }
        BorrowBackTaskVo borrowBackTaskVo = borrowBackTaskRepository.selectBorrowBackTaskByBorrowBackTaskNo(borrowBackTaskNo);
        Example example = SqlUtil.newExample(ContPay.class);
        example.createCriteria().andEqualTo("bizCode", borrowBackTaskNo)
                .andEqualTo("paymentType", BizTypeEnums.ORIG_BORROWED_BACK.getType());
        //收款信息
        ContPay contPay = contPayRepository.selectOneByExample(example);
        if(contPay != null){
            borrowBackTaskVo.setDeductFlag(YesNoFlagEnums.NO.getType());
            borrowBackTaskVo.setRecAccBank(contPay.getRecAccBank());
            borrowBackTaskVo.setRecAccBranch(contPay.getRecAccBranch());
            borrowBackTaskVo.setRecAccountName(contPay.getRecAccountName());
            borrowBackTaskVo.setRecAccountNo(contPay.getRecAccountNo());
        }else{
            borrowBackTaskVo.setDeductFlag(YesNoFlagEnums.YES.getType());
        }
        return borrowBackTaskVo;
    }

    /**
     * @param borrowBackTaskNo
     * @Description: 根据borrowBackTaskNo获取借阅归还任务实体
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/17 17:04
     */
    @Override
    public BorrowBackTask findBorrowBackEntityByBorrowBackTaskNo(String borrowBackTaskNo) {
        if (StringUtils.isTrimBlank(borrowBackTaskNo)){
            throw new FmsServiceException("归还任务号不能为空");
        }
        Example example = SqlUtil.newExample(BorrowBackTask.class);
        example.createCriteria().andEqualTo("borrowBackTaskNo", borrowBackTaskNo);
        return borrowBackTaskRepository.selectOneByExample(example);
    }

}
