package cn.com.leadu.fms.original.service.impl;

import cn.com.leadu.fms.common.constant.enums.original.OrigFileBizCodeTypeEnum;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.original.repository.BorrowTaskRepository;
import cn.com.leadu.fms.data.original.repository.OrigFileRepository;
import cn.com.leadu.fms.original.service.BorrowTaskService;
import cn.com.leadu.fms.original.validator.borrowtask.vo.BorrowTaskDeleteListVo;
import cn.com.leadu.fms.original.validator.borrowtask.vo.BorrowTaskDeleteVo;
import cn.com.leadu.fms.original.validator.borrowtask.vo.BorrowTaskModifyVo;
import cn.com.leadu.fms.original.validator.borrowtask.vo.BorrowTaskSaveVo;
import cn.com.leadu.fms.pojo.original.entity.BorrowTask;
import cn.com.leadu.fms.pojo.original.vo.borrowtask.BorrowTaskVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileStatusVo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author lijunjun
 * @ClassName: BorrowTaskService
 * @Description: 借阅任务信息业务实现层
 * @date 2018-05-30
 */
@Service
public class BorrowTaskServiceImpl implements BorrowTaskService {

    /**
     * @Fields  : 借阅任务信息repository
     */
    @Autowired
    private BorrowTaskRepository borrowTaskRepository;
    @Autowired
    private OrigFileRepository origFileRepository;

    /**
     * @Title:
     * @Description: 分页查询借阅任务信息
     * @param borrowTaskVo
     * @return PageInfoExtend<BorrowTask>
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 16:21:19
     */
    public PageInfoExtend<BorrowTaskVo> findBorrowTasksByPage(BorrowTaskVo borrowTaskVo){

        if(StringUtils.isNotTrimBlank(borrowTaskVo.getCstmName())){
            borrowTaskVo.setCstmName(SqlUtil.likePattern(borrowTaskVo.getCstmName()));
        }else
            borrowTaskVo.setCstmName(null);
        if(StringUtils.isNotTrimBlank(borrowTaskVo.getVinNo())){
            borrowTaskVo.setVinNo(SqlUtil.likePattern(borrowTaskVo.getVinNo()));
        }else
            borrowTaskVo.setVinNo(null);
        // 任务状态查询处理
        if (StringUtils.isTrimBlank(borrowTaskVo.getBorrowTaskStatus()))
            borrowTaskVo.setBorrowTaskStatus(null);
        // 借阅用途查询处理
        if (StringUtils.isTrimBlank(borrowTaskVo.getBorrowPurpose()))
            borrowTaskVo.setBorrowPurpose(null);
        // 领取方式查询处理
        if (StringUtils.isTrimBlank(borrowTaskVo.getBorrowGetWay()))
            borrowTaskVo.setBorrowGetWay(null);
        // 借阅资料查询处理
        if (StringUtils.isNotTrimBlank(borrowTaskVo.getOrigFileDetailNames()))
            borrowTaskVo.setOrigFileDetailNames(SqlUtil.likePattern(borrowTaskVo.getOrigFileDetailNames()));
        else
            borrowTaskVo.setOrigFileDetailNames(null);
        //不是续保业务类的数据
        borrowTaskVo.setBizCodeType(OrigFileBizCodeTypeEnum.INSURANCE_TYPE.getType());
        PageInfoExtend<BorrowTaskVo> pageInfo = borrowTaskRepository.selectListVoByPage("selectBorrowTaskVosByOrigFileStatus",borrowTaskVo,borrowTaskVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存借阅任务信息
     * @param borrowTaskSaveVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-5-30 16:21:19
     */
    public void saveBorrowTask(BorrowTaskSaveVo borrowTaskSaveVo){
        borrowTaskRepository.insertData(borrowTaskSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改借阅任务信息
     * @param borrowTaskModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-30 16:21:19
     */
    public void modifyBorrowTask(BorrowTaskModifyVo borrowTaskModifyVo){
        borrowTaskRepository.updateByPrimaryKeySelectiveData(borrowTaskModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过borrowTaskId删除借阅任务信息
     * @param borrowTaskDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-30 16:21:19
     */
    public void deleteBorrowTask(BorrowTaskDeleteVo borrowTaskDeleteVo){
        borrowTaskRepository.deleteData(borrowTaskDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过borrowTaskId集合删除借阅任务信息
     * @param borrowTaskDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-30 16:21:19
     */
    public void deleteBorrowTasksByBorrowTaskIds(BorrowTaskDeleteListVo borrowTaskDeleteListVo){
        borrowTaskRepository.deleteDataList(borrowTaskDeleteListVo.getBorrowTaskIds(),borrowTaskDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据borrowTaskId获取借阅任务信息
     * @param borrowTaskId
     * @return BorrowTask
     * @throws
     * @author lijunjun
     * @date 2018-5-30 16:21:19
     */
    public BorrowTask findBorrowTaskByBorrowTaskId(String borrowTaskId){
        return borrowTaskRepository.selectByPrimaryKey(borrowTaskId);
    }

    /**
     * @param borrowTaskNo
     * @return BorrowTask
     * @throws
     * @Title:
     * @Description: 根据borrowTaskNo获取借阅任务信息
     * @author lijunjun
     * @date 2018-5-30 16:21:19
     */
    @Override
    public BorrowTaskVo findBorrowTaskByBorrowTaskNo(String borrowTaskNo) {
        if (StringUtils.isTrimBlank(borrowTaskNo)){
            throw new FmsServiceException("借阅任务号不能为空");
        }
        Example example = SqlUtil.newExample(BorrowTask.class);
        example.createCriteria().andEqualTo("borrowTaskNo", borrowTaskNo);
        BorrowTask borrowTask = borrowTaskRepository.selectOneByExample(example);
        BorrowTaskVo borrowTaskVo = new BorrowTaskVo();
        BeanUtils.copyProperties(borrowTask, borrowTaskVo);// 数据转化
        // 获取合同号
        String contNo = borrowTaskRepository.selectBizCodeByBorrowTaskNo(borrowTaskNo);
        // 获取过户状态和合同的结清状态
        OrigFileStatusVo origFileStatusVo = origFileRepository.selectOrigFileStatusVoByContNo(contNo);
        if (origFileStatusVo != null){
            borrowTaskVo.setPaymentSts(origFileStatusVo.getPaymentSts());// 还款状态
            borrowTaskVo.setTransferSts(origFileStatusVo.getTransferSts());// 过户状态
        }
        return borrowTaskVo;
    }

}
