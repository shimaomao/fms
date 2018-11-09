package cn.com.leadu.fms.baseinfo.service.impl;

import cn.com.leadu.fms.baseinfo.service.BasRepayRuleService;
import cn.com.leadu.fms.baseinfo.validator.basrepayrule.vo.BasRepayRuleDeleteListVo;
import cn.com.leadu.fms.baseinfo.validator.basrepayrule.vo.BasRepayRuleDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.basrepayrule.vo.BasRepayRuleModifyVo;
import cn.com.leadu.fms.baseinfo.validator.basrepayrule.vo.BasRepayRuleSaveVo;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.baseinfo.repository.BasRepayRuleRepository;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasRepayRule;
import cn.com.leadu.fms.pojo.baseinfo.vo.basrepayrule.BasRepayRuleVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author huchenghao
 * @ClassName: BasRepayRuleService
 * @Description: 还款日规则业务实现层
 * @date 2018-03-16
 */
@Service
public class BasRepayRuleServiceImpl implements BasRepayRuleService {

    /**
     * @Fields  : 还款日规则repository
     */
    @Autowired
    private BasRepayRuleRepository basRepayRuleRepository;

    /**
     * @Title:
     * @Description: 分页查询还款日规则
     * @param basRepayRuleVo
     * @return PageInfoExtend<BasRepayRule>
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    public PageInfoExtend<BasRepayRule> findBasRepayRulesByPage(BasRepayRuleVo basRepayRuleVo){
        Example example = SqlUtil.newExample(BasRepayRule.class);
        Example.Criteria criteria = example.createCriteria();
       //条件：还款日
        if(StringUtils.isNotTrimBlank(basRepayRuleVo.getRepayDay())){
            criteria.andEqualTo("repayDay",basRepayRuleVo.getRepayDay());
        }
        //条件：还款开始区间
        if(StringUtils.isNotTrimBlank(basRepayRuleVo.getBeginInterval())){
            criteria.andEqualTo("beginInterval",basRepayRuleVo.getBeginInterval());
        }

        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<BasRepayRule> pageInfo = basRepayRuleRepository.selectListByExamplePage(example,basRepayRuleVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存还款日规则
     * @param basRepayRuleSaveVo
     * @return java.lang.String
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    public void saveBasRepayRule(BasRepayRuleSaveVo basRepayRuleSaveVo){
        basRepayRuleRepository.insertData(basRepayRuleSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改还款日规则
     * @param basRepayRuleModifyVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    public void modifyBasRepayRule(BasRepayRuleModifyVo basRepayRuleModifyVo){
        basRepayRuleRepository.updateByPrimaryKeySelectiveData(basRepayRuleModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过ruleId删除还款日规则
     * @param basRepayRuleDeleteVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    public void deleteBasRepayRule(BasRepayRuleDeleteVo basRepayRuleDeleteVo){
        basRepayRuleRepository.deleteData(basRepayRuleDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过ruleId集合删除还款日规则
     * @param basRepayRuleDeleteListVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    public void deleteBasRepayRulesByRuleIds(BasRepayRuleDeleteListVo basRepayRuleDeleteListVo){
        basRepayRuleRepository.deleteDataList(basRepayRuleDeleteListVo.getRuleIds(),basRepayRuleDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据ruleId获取还款日规则
     * @param ruleId
     * @return BasRepayRule
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    public BasRepayRule findBasRepayRuleByRuleId(String ruleId){
        return basRepayRuleRepository.selectByPrimaryKey(ruleId);
    }


    /**
     * @Title:
     * @Description:  根据当前日期取得还款日
     * @param
     * @return rePayDay
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    @Override
    public String findRepayDay(Date repayDate){
        if(repayDate == null){
            repayDate = new Date();
        }
        Calendar calendar= Calendar.getInstance();
        calendar.setTime(repayDate);
        //默认为每月1号
        String repayDay = "1";
//        Integer day = Integer.valueOf(DateUtils.getNowDateStr(DateUtils.formatStr_dd));
        Integer day = calendar.get(Calendar.DAY_OF_MONTH);
        List<BasRepayRule> basRepayRules = basRepayRuleRepository.selectAll();

        for(int i=0; i<basRepayRules.size(); i++){
            Integer from = Integer.valueOf(basRepayRules.get(i).getBeginInterval());
            Integer to =  Integer.valueOf(basRepayRules.get(i).getEndInterval());
            if(day >= from && day < to){
                return basRepayRules.get(i).getRepayDay();
            }
        }
        return repayDay;
    }

}
