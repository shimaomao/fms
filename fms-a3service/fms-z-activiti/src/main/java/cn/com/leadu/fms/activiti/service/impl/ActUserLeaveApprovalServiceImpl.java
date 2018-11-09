package cn.com.leadu.fms.activiti.service.impl;

import cn.com.leadu.fms.activiti.service.ActUserLeaveApprovalService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.activiti.repository.ActUserLeaveApprovalRepository;
import cn.com.leadu.fms.pojo.activiti.entity.ActUserLeaveApproval;
import cn.com.leadu.fms.pojo.activiti.vo.actuserleaveapproval.ActUserLeaveApprovalVo;
import cn.com.leadu.fms.activiti.validator.actuserleaveapproval.vo.ActUserLeaveApprovalSaveVo;
import cn.com.leadu.fms.activiti.validator.actuserleaveapproval.vo.ActUserLeaveApprovalModifyVo;
import cn.com.leadu.fms.activiti.validator.actuserleaveapproval.vo.ActUserLeaveApprovalDeleteVo;
import cn.com.leadu.fms.activiti.validator.actuserleaveapproval.vo.ActUserLeaveApprovalDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author qiaomengnan
 * @ClassName: ActUserLeaveApprovalService
 * @Description: 用户请假审批业务实现层
 * @date 2018-03-20
 */
@Service
public class ActUserLeaveApprovalServiceImpl implements ActUserLeaveApprovalService {

    /**
     * @Fields  : 用户请假审批repository
     */
    @Autowired
    private ActUserLeaveApprovalRepository actUserLeaveApprovalRepository;

    /**
     * @Title:
     * @Description: 分页查询用户请假审批
     * @param actUserLeaveApprovalVo
     * @return PageInfoExtend<ActUserLeaveApproval>
     * @throws
     * @author qiaomengnan
     * @date 2018-3-20 14:42:25
     */
    public PageInfoExtend<ActUserLeaveApproval> findActUserLeaveApprovalsByPage(ActUserLeaveApprovalVo actUserLeaveApprovalVo){
        Example example = SqlUtil.newExample(ActUserLeaveApproval.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<ActUserLeaveApproval> pageInfo = actUserLeaveApprovalRepository.selectListByExamplePage(example,actUserLeaveApprovalVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存用户请假审批
     * @param actUserLeaveApprovalSaveVo
     * @return java.lang.String
     * @throws
     * @author qiaomengnan
     * @date 2018-3-20 14:42:25
     */
    public void saveActUserLeaveApproval(ActUserLeaveApprovalSaveVo actUserLeaveApprovalSaveVo){
        actUserLeaveApprovalRepository.insertData(actUserLeaveApprovalSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改用户请假审批
     * @param actUserLeaveApprovalModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-20 14:42:25
     */
    public void modifyActUserLeaveApproval(ActUserLeaveApprovalModifyVo actUserLeaveApprovalModifyVo){
        actUserLeaveApprovalRepository.updateByPrimaryKeySelectiveData(actUserLeaveApprovalModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过approvalId删除用户请假审批
     * @param actUserLeaveApprovalDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-20 14:42:25
     */
    public void deleteActUserLeaveApproval(ActUserLeaveApprovalDeleteVo actUserLeaveApprovalDeleteVo){
        actUserLeaveApprovalRepository.deleteData(actUserLeaveApprovalDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过approvalId集合删除用户请假审批
     * @param actUserLeaveApprovalDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-20 14:42:25
     */
    public void deleteActUserLeaveApprovalsByApprovalIds(ActUserLeaveApprovalDeleteListVo actUserLeaveApprovalDeleteListVo){
        actUserLeaveApprovalRepository.deleteDataList(actUserLeaveApprovalDeleteListVo.getApprovalIds(),actUserLeaveApprovalDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据approvalId获取用户请假审批
     * @param approvalId
     * @return ActUserLeaveApproval
     * @throws
     * @author qiaomengnan
     * @date 2018-3-20 14:42:25
     */
    public ActUserLeaveApproval findActUserLeaveApprovalByApprovalId(String approvalId){
        return actUserLeaveApprovalRepository.selectByPrimaryKey(approvalId);
    }

}
