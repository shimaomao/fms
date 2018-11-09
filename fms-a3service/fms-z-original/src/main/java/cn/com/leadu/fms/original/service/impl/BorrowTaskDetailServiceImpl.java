package cn.com.leadu.fms.original.service.impl;

import cn.com.leadu.fms.original.service.BorrowTaskDetailService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.original.repository.BorrowTaskDetailRepository;
import cn.com.leadu.fms.pojo.original.entity.BorrowTaskDetail;
import cn.com.leadu.fms.pojo.original.vo.borrowtaskdetail.BorrowTaskDetailVo;
import cn.com.leadu.fms.original.validator.borrowtaskdetail.vo.BorrowTaskDetailSaveVo;
import cn.com.leadu.fms.original.validator.borrowtaskdetail.vo.BorrowTaskDetailModifyVo;
import cn.com.leadu.fms.original.validator.borrowtaskdetail.vo.BorrowTaskDetailDeleteVo;
import cn.com.leadu.fms.original.validator.borrowtaskdetail.vo.BorrowTaskDetailDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author yebangqiang
 * @ClassName: BorrowTaskDetailService
 * @Description: 借阅任务明细业务实现层
 * @date 2018-07-16
 */
@Service
public class BorrowTaskDetailServiceImpl implements BorrowTaskDetailService {

    /**
     * @Fields  : 借阅任务明细repository
     */
    @Autowired
    private BorrowTaskDetailRepository borrowTaskDetailRepository;

    /**
     * @Title:
     * @Description: 分页查询借阅任务明细
     * @param borrowTaskDetailVo
     * @return PageInfoExtend<BorrowTaskDetail>
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    public PageInfoExtend<BorrowTaskDetail> findBorrowTaskDetailsByPage(BorrowTaskDetailVo borrowTaskDetailVo){
        Example example = SqlUtil.newExample(BorrowTaskDetail.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<BorrowTaskDetail> pageInfo = borrowTaskDetailRepository.selectListByExamplePage(example,borrowTaskDetailVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存借阅任务明细
     * @param borrowTaskDetailSaveVo
     * @return java.lang.String
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    public void saveBorrowTaskDetail(BorrowTaskDetailSaveVo borrowTaskDetailSaveVo){
        borrowTaskDetailRepository.insertData(borrowTaskDetailSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改借阅任务明细
     * @param borrowTaskDetailModifyVo
     * @return
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    public void modifyBorrowTaskDetail(BorrowTaskDetailModifyVo borrowTaskDetailModifyVo){
        borrowTaskDetailRepository.updateByPrimaryKeySelectiveData(borrowTaskDetailModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过borrowTaskDetailId删除借阅任务明细
     * @param borrowTaskDetailDeleteVo
     * @return
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    public void deleteBorrowTaskDetail(BorrowTaskDetailDeleteVo borrowTaskDetailDeleteVo){
        borrowTaskDetailRepository.deleteData(borrowTaskDetailDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过borrowTaskDetailId集合删除借阅任务明细
     * @param borrowTaskDetailDeleteListVo
     * @return
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    public void deleteBorrowTaskDetailsByBorrowTaskDetailIds(BorrowTaskDetailDeleteListVo borrowTaskDetailDeleteListVo){
        borrowTaskDetailRepository.deleteDataList(borrowTaskDetailDeleteListVo.getBorrowTaskDetailIds(),borrowTaskDetailDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据borrowTaskDetailId获取借阅任务明细
     * @param borrowTaskDetailId
     * @return BorrowTaskDetail
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:54
     */
    public BorrowTaskDetail findBorrowTaskDetailByBorrowTaskDetailId(String borrowTaskDetailId){
        return borrowTaskDetailRepository.selectByPrimaryKey(borrowTaskDetailId);
    }

}
