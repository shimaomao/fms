package cn.com.leadu.fms.data.postbiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.pojo.finance.vo.finrepaysked.FinRepaySkedVo;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstm;
import cn.com.leadu.fms.pojo.postbiz.vo.collectiontask.CollectionTaskVo;
import cn.com.leadu.fms.pojo.postbiz.vo.lawsuittask.LawsuitTaskVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.*;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstmtel.OverdueCstmTelVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduetelregister.OverdueTelRegisterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.retrievecarstask.RetrieveCarsTaskVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmDao
 * @Description: 逾期客户信息dao层
 * @date 2018-05-16
 */
public interface OverdueCstmDao extends BaseDao<OverdueCstm> {

    /**
     * @Description: 分页查询逾期客户信息
     * @param: overdueCstmVo
     * @return: List<OverdueCstmVo>
     * @Author: lijunjun
     * @Date: 2018/5/10 19:42
     */
    List<OverduePostVo> selectOverdueCstmsByPage(@Param("overdueCstmVo") OverdueCstmVo overdueCstmVo);

    /**
     * @Description: 根据逾期客户ID获取信息
     * @param: overdueCstmId
     * @return: OverdueCstmVo
     * @Author: lijunjun
     * @Date: 2018/5/10 19:42
     */
    OverdueCstmVo selectOverdueCstmByOverdueCstmId(@Param("overdueCstmId") String overdueCstmId);

    /**
     * @Description: 根据逾期客户ID获取信息
     * @param: overdueCstmId
     * @return: OverdueCstmVo
     * @Author: lijunjun
     * @Date: 2018/5/10 19:42
     */
    OverdueCstmVo selectOverdueCstmVoByOverdueCstmId(@Param("overdueCstmId") String overdueCstmId);

    /**
     * @Description: 根据逾期客户ID获取合同编号List
     * @param: overdueCstmId
     * @return: List<String>
     * @Author: lijunjun
     * @Date: 2018/5/10 19:42
     */
    List<String> selectContNoListByOverdueCstmId(String overdueCstmId);

    /**
     * @Description: 分页查询还款信息和逾期信息
     * @param: overdueCstmVo
     * @return: List<ContRepaySkedOverdueTotalVo>
     * @Author: lijunjun
     * @Date: 2018/5/10 19:42
     */
    List<ContRepaySkedOverdueTotalVo> selectContRepaySkedAndOverduByoverdueCstmId(@Param("overdueCstmVo") OverdueCstmVo overdueCstmVo);

    /**
     * @Description: 当前销售未还剩余本金 -->打开 合同还款计划表
     * @param: overdueCstmVo
     * @return: List<OverdueCstmVo>
     * @Author: lijunjun
     * @Date: 2018/5/10 19:42
     */
    List<ContRepaySkedVo> selectContRepaySkedVoByContNo(@Param("overdueCstmVo") OverdueCstmVo overdueCstmVo);

    /**
     * @Description: 当前财务未还剩余本金 -->打开【财务还款计划表】*关联合同还款计划表取得扣款状态
     * @param: overdueCstmVo
     * @return: List<OverdueCstmVo>
     * @Author: lijunjun
     * @Date: 2018/5/10 19:42
     */
    List<FinRepaySkedVo> selectContOverdueVoByContNo(@Param("overdueCstmVo") OverdueCstmVo overdueCstmVo);

    /**
     * @Description: 获取电话催收登记信息
     * @return: List<OverdueTelRegisterVo>
     * @Param overdueCstmId
     * @Author: lijunjun
     * @Date: 2018/5/10 19:42
     */
    List<OverdueTelRegisterVo> selectOverdueTelRegister(@Param("overdueCstmId") String overdueCstmId);

    /**
     * @Description: 根据逾期客户电话信息ID获取逾期客户电话信息
     * @return: OverdueCstmTelVo
     * @Param overdueCstmTelId
     * @Author: lijunjun
     * @Date: 2018/5/10 19:42
     */
    OverdueCstmTelVo selectOverdueCstmTelVoByOverdueCstmTelId(@Param("overdueCstmTelId") String overdueCstmTelId);

    /**
     * @Description: 根据逾期客户信息ID获取电话催收登记信息List
     * @return: List<OverdueTelRegisterVo>
     * @Param overdueCstmId
     * @Author: lijunjun
     * @Date: 2018/5/10 19:42
     */
    List<OverdueTelRegisterVo> selectOverdueTelRegisterVoByOverdueCstmId(@Param("overdueCstmId") String overdueCstmId);

    /**
     * 根据overdueCstmId获取收车信息List
     *
     * @param overdueCstmId
     * @return
     */
    List<RetrieveCarsTaskVo> selectRetrieveCarsTaskVoList(@Param("overdueCstmId") String overdueCstmId);

    /**
     * 根据overdueCstmId获取诉讼信息List
     *
     * @param overdueCstmId
     * @return
     */
    List<LawsuitTaskVo> selectLawsuitTaskVoList(@Param("overdueCstmId") String overdueCstmId);

    /**
     * 获取上门催收信息List
     *
     * @param overdueCstmId
     * @return
     */
    List<CollectionTaskVo> selectCollectionTaskList(@Param("overdueCstmId") String overdueCstmId);

    /**
     * 获取催收函数据
     *
     * @param contNo
     * @return
     */
    CollectionLetterVo selectCollectionLetterInfo(@Param("contNo") String contNo);

    /**
     * 获取律师函数据
     *
     * @param contNo
     * @return
     */
    LawyerLetterVo selectLawyerLetterInfo(@Param("contNo") String contNo);

    /**
     * 获取分配人员信息
     * @param roleCodeList
     * @return
     */
    List<SysUser> selectAssignUsers(@Param("roleCodeList") List<String> roleCodeList);
}