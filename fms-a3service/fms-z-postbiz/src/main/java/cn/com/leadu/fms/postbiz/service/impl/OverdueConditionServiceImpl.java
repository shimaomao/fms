package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.postbiz.service.OverdueConditionService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.OverdueConditionRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCondition;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecondition.OverdueConditionVo;
import cn.com.leadu.fms.postbiz.validator.overduecondition.vo.OverdueConditionSaveVo;
import cn.com.leadu.fms.postbiz.validator.overduecondition.vo.OverdueConditionModifyVo;
import cn.com.leadu.fms.postbiz.validator.overduecondition.vo.OverdueConditionDeleteVo;
import cn.com.leadu.fms.postbiz.validator.overduecondition.vo.OverdueConditionDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author yanfengbo
 * @ClassName: OverdueConditionService
 * @Description: 逾期状态维护业务实现层
 * @date 2018-05-11
 */
@Service
public class OverdueConditionServiceImpl implements OverdueConditionService {

    /**
     * @Fields  : 逾期状态维护repository
     */
    @Autowired
    private OverdueConditionRepository overdueConditionRepository;

    /**
     * @Title:
     * @Description: 分页查询逾期状态维护
     * @param overdueConditionVo
     * @return PageInfoExtend<OverdueCondition>
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    public PageInfoExtend<OverdueCondition> findOverdueConditionsByPage(OverdueConditionVo overdueConditionVo){
        Example example = SqlUtil.newExample(OverdueCondition.class);
        Example.Criteria criteria = example.createCriteria();

        if (StringUtils.isNotTrimBlank(overdueConditionVo.getOverdueCondCd()))
            criteria.andLike("overdueCondCd",SqlUtil.likePattern(overdueConditionVo.getOverdueCondCd()));

        if (StringUtils.isNotTrimBlank(overdueConditionVo.getOverdueCondName()))
            criteria.andLike("overdueCondName",SqlUtil.likePattern(overdueConditionVo.getOverdueCondName()));
        SqlUtil.setOrderByUpdateTimeDesc(example);
        PageInfoExtend<OverdueCondition> pageInfo = overdueConditionRepository.selectListByExamplePage(example,overdueConditionVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存逾期状态维护
     * @param overdueConditionSaveVo
     * @return java.lang.String
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    public void saveOverdueCondition(OverdueConditionSaveVo overdueConditionSaveVo){
        overdueConditionRepository.insertData(overdueConditionSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改逾期状态维护
     * @param overdueConditionModifyVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    public void modifyOverdueCondition(OverdueConditionModifyVo overdueConditionModifyVo){
        overdueConditionRepository.updateByPrimaryKeySelectiveData(overdueConditionModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过overdueConditionId删除逾期状态维护
     * @param overdueConditionDeleteVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    public void deleteOverdueCondition(OverdueConditionDeleteVo overdueConditionDeleteVo){
        overdueConditionRepository.deleteData(overdueConditionDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过overdueConditionId集合删除逾期状态维护
     * @param overdueConditionDeleteListVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    public void deleteOverdueConditionsByOverdueConditionIds(OverdueConditionDeleteListVo overdueConditionDeleteListVo){
        overdueConditionRepository.deleteDataList(overdueConditionDeleteListVo.getOverdueConditionIds(),overdueConditionDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据overdueConditionId获取逾期状态维护
     * @param overdueConditionId
     * @return OverdueCondition
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    public OverdueCondition findOverdueConditionByOverdueConditionId(String overdueConditionId){
        return overdueConditionRepository.selectByPrimaryKey(overdueConditionId);
    }

    /**
     * @Title:
     * @Description: 根据overdueCondCd获取逾期状态维护
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
   public OverdueCondition findOverdueConditionByOverdueCondCd(String overdueCondCd){
       Example example = SqlUtil.newExample(OverdueCondition.class);
       example.createCriteria().andEqualTo("overdueCondCd", overdueCondCd);
       return overdueConditionRepository.selectOneByExample(example);
   }

}
