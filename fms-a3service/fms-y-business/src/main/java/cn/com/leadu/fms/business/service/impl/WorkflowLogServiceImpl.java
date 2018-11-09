package cn.com.leadu.fms.business.service.impl;

import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.WorkflowLogRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.prebiz.vo.workflowlog.WorkflowLogVo;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: WorkflowLogService
 * @Description: 审批日志业务实现层
 * @date 2018-03-24
 */
@Service
public class WorkflowLogServiceImpl implements WorkflowLogService {

    /**
     * @Fields  : 审批日志repository
     */
    @Autowired
    private WorkflowLogRepository workflowLogRepository;

    /**
     * @Title:
     * @Description: 分页查询审批日志
     * @param workflowLogVo
     * @return PageInfoExtend<WorkflowLog>
     * @throws
     * @author liujinge
     * @date 2018-3-24 11:31:24
     */
    public PageInfoExtend<WorkflowLog> findWorkflowLogsByPage(WorkflowLogVo workflowLogVo){
        Example example = SqlUtil.newExample(WorkflowLog.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<WorkflowLog> pageInfo = workflowLogRepository.selectListByExamplePage(example,workflowLogVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description:  根据wfLogId获取审批日志
     * @param wfLogId
     * @return WorkflowLog
     * @throws
     * @author liujinge
     * @date 2018-3-24 11:31:24
     */
    public WorkflowLog findWorkflowLogByWfLogId(String wfLogId){
        return workflowLogRepository.selectByPrimaryKey(wfLogId);
    }

    /**
     * @Title:
     * @Description:  插入审批日志
     * @param workflowLog
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-24 11:31:24
     */
    public int insertWorkFlowLog(WorkflowLog workflowLog){
        return workflowLogRepository.insertData(workflowLog);
    }

    /**
     * @Title:
     * @Description:  取得订单日志信息
     * @param applyNo
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-24 11:31:24
     */
    public List<WorkflowLogVo> findWorkflowLogs(String wfLogType, String applyNo, String contNo){
        if(StringUtils.isNotExits(applyNo)){
            applyNo = null;
        }
        if(StringUtils.isNotExits(contNo)){
            contNo = null;
        }
        if(StringUtils.isNotExits(wfLogType)){
            wfLogType = null;
        }
        if (StringUtils.isContainTrimBlank(wfLogType,applyNo)){
            return new ArrayList<>();
        } else {
            return workflowLogRepository.selectWorkFlowLogs(wfLogType, applyNo , contNo);
        }
    }



}
