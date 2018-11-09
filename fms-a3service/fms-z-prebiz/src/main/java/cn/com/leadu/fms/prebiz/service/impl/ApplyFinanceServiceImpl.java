package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.ApplyFinanceRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyFinance;
import cn.com.leadu.fms.pojo.prebiz.vo.applyfinance.ApplyFinanceVo;
import cn.com.leadu.fms.prebiz.service.ApplyFinanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

/**
 * @author wangxue
 * @ClassName: ApplyFinanceService
 * @Description: 融资信息业务实现层
 * @date 2018-03-24
 */
@Service
public class ApplyFinanceServiceImpl implements ApplyFinanceService {

    /**
     * @Fields  : 融资信息repository
     */
    @Autowired
    private ApplyFinanceRepository applyFinanceRepository;

    /**
     * @Title:
     * @Description: 分页查询融资信息
     * @param applyFinanceVo
     * @return PageInfoExtend<ApplyFinance>
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:12:16
     */
    public PageInfoExtend<ApplyFinance> findApplyFinancesByPage(ApplyFinanceVo applyFinanceVo){
        Example example =SqlUtil.newExample(ApplyFinance.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<ApplyFinance> pageInfo = applyFinanceRepository.selectListByExamplePage(example,applyFinanceVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description:  根据applyFinId获取融资信息
     * @param applyFinId
     * @return ApplyFinance
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:12:16
     */
    public ApplyFinance findApplyFinanceByApplyFinId(String applyFinId){
        return applyFinanceRepository.selectByPrimaryKey(applyFinId);
    }

    /**
     * @Title:
     * @Description:  根据applyNo获取融资信息
     * @param applyNo
     * @return ApplyFinance
     * @throws
     * @author wangxue
     * @date 2018-3-24 14:12:16
     */
    public ApplyFinance findApplyFinanceByApplyNo(String applyNo){
        Example example = SqlUtil.newExample(ApplyFinance.class);
        example.createCriteria().andEqualTo("applyNo",applyNo);
        return applyFinanceRepository.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description:  保存融资方案信息
     * @param applyFinance
     * @throws
     * @author wangxue
     * @date 2018-3-25
     */
    @Override
    public void saveApplyFinance(ApplyFinance applyFinance) {
        applyFinanceRepository.insertData(applyFinance);
    }

    /**
     * @Title:
     * @Description:  更新融资方案信息
     * @param applyFinance
     * @throws
     * @author wangxue
     * @date 2018-4-15
     */
    @Override
    public void modifyApplyFinance(ApplyFinance applyFinance) {
        applyFinanceRepository.updateByPrimaryKeySelectiveData(applyFinance);
    }

    /**
     * @Title:
     * @Description:  根据订单编号，获取融资信息
     * @param applyNo 订单编号
     * @throws
     * @author wangxue
     * @date 2018-3-29
     */
    @Override
    public ApplyFinanceVo findApplyFinanceVoByApplyNo(String applyNo) {
        ApplyFinanceVo applyFinanceVo = applyFinanceRepository.selectApplyFinanceVoByApplyNo(applyNo);
        return applyFinanceVo;
    }
}
