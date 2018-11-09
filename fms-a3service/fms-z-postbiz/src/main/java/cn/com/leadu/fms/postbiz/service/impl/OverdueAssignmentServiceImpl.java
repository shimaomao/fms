package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.common.constant.enums.postbiz.AssignmentStsEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.OverdueCstmSaveVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.OverdueAssignmentService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.OverdueAssignmentRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueAssignment;
import cn.com.leadu.fms.pojo.postbiz.vo.overdueassignment.OverdueAssignmentVo;
import cn.com.leadu.fms.postbiz.validator.overdueassignment.vo.OverdueAssignmentSaveVo;
import cn.com.leadu.fms.postbiz.validator.overdueassignment.vo.OverdueAssignmentModifyVo;
import cn.com.leadu.fms.postbiz.validator.overdueassignment.vo.OverdueAssignmentDeleteVo;
import cn.com.leadu.fms.postbiz.validator.overdueassignment.vo.OverdueAssignmentDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.Date;

/**
 * @author lijunjun
 * @ClassName: OverdueAssignmentService
 * @Description: 当日逾期任务信息业务实现层
 * @date 2018-05-16
 */
@Service
public class OverdueAssignmentServiceImpl implements OverdueAssignmentService {

    /**
     * @Fields  : 当日逾期任务信息repository
     */
    @Autowired
    private OverdueAssignmentRepository overdueAssignmentRepository;

    /**
     * @Title:
     * @Description: 分页查询当日逾期任务信息
     * @param overdueAssignmentVo
     * @return PageInfoExtend<OverdueAssignment>
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    public PageInfoExtend<OverdueAssignment> findOverdueAssignmentsByPage(OverdueAssignmentVo overdueAssignmentVo){
        Example example = SqlUtil.newExample(OverdueAssignment.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<OverdueAssignment> pageInfo = overdueAssignmentRepository.selectListByExamplePage(example,overdueAssignmentVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存当日逾期任务信息
     * @param overdueAssignmentSaveVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    public void saveOverdueAssignment(OverdueAssignmentSaveVo overdueAssignmentSaveVo){
        overdueAssignmentRepository.insertData(overdueAssignmentSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 催收任务分配，更新当日逾期任务信息
     * @param overdueCstmSaveVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    public void saveAssignment(OverdueCstmSaveVo overdueCstmSaveVo){
        String cstmId = overdueCstmSaveVo.getOverdueCstmId(); //获取客户ID
        String assignmentType=overdueCstmSaveVo.getAssignmentType(); // 获取催收类型
        String assignUser=overdueCstmSaveVo.getAssignUser(); //获取催收账号
        Date date=new Date();
        //根据客户ID查询当日逾期信息
        Example example = SqlUtil.newExample(OverdueAssignment.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("overdueCstmId", cstmId);
        SqlUtil.setOrderByUpdateTimeDesc(example);
        OverdueAssignment overdueAssignment = overdueAssignmentRepository.selectOneByExample(example);
        if(overdueAssignment==null) {
            throw new FmsServiceException("该逾期对象不存在!");
        }
        if(AssignmentStsEnums.CANCEL.getType().equals(overdueAssignment.getAssignmentSts()))  {
            throw new FmsServiceException("该对象已还款，无需再分配!");
        }
        overdueAssignment.setAssignmentType(assignmentType); //更新催收类型
        overdueAssignment.setAssignUser(assignUser); //更新催收账号
        overdueAssignment.setAssignDate(date); //更新分配时间
        overdueAssignment.setAssignmentSts(AssignmentStsEnums.PROCESSED.getType()); //更新催收任务状态
        overdueAssignmentRepository.updateByPrimaryKeySelectiveData(overdueAssignment);
    }


    /**
     * @Title:
     * @Description: 修改当日逾期任务信息
     * @param overdueAssignmentModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    public void modifyOverdueAssignment(OverdueAssignmentModifyVo overdueAssignmentModifyVo){
        overdueAssignmentRepository.updateByPrimaryKeySelectiveData(overdueAssignmentModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过overdueAssignmentId删除当日逾期任务信息
     * @param overdueAssignmentDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    public void deleteOverdueAssignment(OverdueAssignmentDeleteVo overdueAssignmentDeleteVo){
        overdueAssignmentRepository.deleteData(overdueAssignmentDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过overdueAssignmentId集合删除当日逾期任务信息
     * @param overdueAssignmentDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    public void deleteOverdueAssignmentsByOverdueAssignmentIds(OverdueAssignmentDeleteListVo overdueAssignmentDeleteListVo){
        overdueAssignmentRepository.deleteDataList(overdueAssignmentDeleteListVo.getOverdueAssignmentIds(),overdueAssignmentDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据overdueAssignmentId获取当日逾期任务信息
     * @param overdueAssignmentId
     * @return OverdueAssignment
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    public OverdueAssignment findOverdueAssignmentByOverdueAssignmentId(String overdueAssignmentId){
        return overdueAssignmentRepository.selectByPrimaryKey(overdueAssignmentId);
    }

}
