package cn.com.leadu.fms.data.cost.repository.impl;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.data.cost.dao.OverdueExemptDao;
import cn.com.leadu.fms.data.cost.repository.OverdueExemptRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.cost.entity.OverdueExempt;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.cost.vo.overdueexempt.ContOverdueOneVo;
import cn.com.leadu.fms.pojo.finance.vo.contoverdue.ContOverdueVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecont.OverdueContVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: OverdueExemptRepositoryImpl
 * @Description: 罚息免除任务表Repository 实现层
 * @date 2018-05-30
 */
@Repository
public class OverdueExemptRepositoryImpl extends AbstractBaseRepository<OverdueExemptDao, OverdueExempt> implements OverdueExemptRepository {

    /**
     * @Title:
     * @Description: 新增罚息免除任务表
     * @param overdueExempt
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:08:30
     */
    @Override
    public int insertData(OverdueExempt overdueExempt) {
        return super.insert(overdueExempt);
    }

    /**
     * @Title:
     * @Description: 批量保存罚息免除任务表
     * @param overdueExempts
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:08:30
     */
    @Override
    public int insertDataList(List<OverdueExempt> overdueExempts){
        return super.insertListByJdbcTemplate(overdueExempts);
    }

    /**
     * @Title:
     * @Description: 修改罚息免除任务表
     * @param overdueExempt
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:08:30
     */
    @Override
    public int updateByPrimaryKeyData(OverdueExempt overdueExempt) {
        return super.updateByPrimaryKey(overdueExempt);
    }

    /**
     * @Title:
     * @Description: 批量修改罚息免除任务表
     * @param overdueExempts
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:08:30
     */
    @Override
    public int updateByPrimaryKeyDataList(List<OverdueExempt> overdueExempts){
        return super.updateListByPrimaryKey(overdueExempts);
    }

    /**
     * @Title:
     * @Description: 动态修改罚息免除任务表
     * @param overdueExempt
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:08:30
     */
    @Override
    public int updateByPrimaryKeySelectiveData(OverdueExempt overdueExempt) {
        return super.updateByPrimaryKeySelective(overdueExempt);
    }

    /**
     * @Title:
     * @Description: 批量动态修改罚息免除任务表
     * @param overdueExempts
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:08:30
     */
    public int updateByPrimaryKeySelectiveDataList(List<OverdueExempt> overdueExempts) {
        return super.updateListByPrimaryKeySelective(overdueExempts);
    }

    /**
     * @Title:
     * @Description: 根据条件修改罚息免除任务表
     * @param overdueExempt
     * @param example
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:08:30
     */
    @Override
    public int updateByExampleData(OverdueExempt overdueExempt, Example example) {
        return super.updateByExample(overdueExempt,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改罚息免除任务表
     * @param overdueExempt
     * @param example
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:08:30
     */
    @Override
    public int updateByExampleSelectiveData(OverdueExempt overdueExempt, Example example){
        return super.updateByExampleSelective(overdueExempt,example);
    }
    
    /**
     * @Title:
     * @Description: 根据overdueExemptId删除罚息免除任务表
     * @param overdueExempt
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:08:30
     */
    @Override
    public int deleteData(OverdueExempt overdueExempt) {
        return super.delete(overdueExempt);
    }

    /**
     * @Title:
     * @Description: 根据overdueExemptId集合批量删除罚息免除任务表
     * @param overdueExempt
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:08:30
     */
    public int deleteDataList(List overdueExemptIds,OverdueExempt overdueExempt){
        return super.deleteByIds(overdueExemptIds,overdueExempt);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除罚息免除任务表
     * @param example
     * @param overdueExempt
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:08:30
     */
    public int deleteExampleData(Example example,OverdueExempt overdueExempt){
        return super.deleteByExample(example,overdueExempt);
    }

    /**
     * @Title:
     * @Description: 查询全部罚息免除任务表
     * @return List<OverdueExempt>
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:08:30
     */
    @Override
    public List<OverdueExempt> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个罚息免除任务表
     * @param example
     * @return OverdueExempt
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:08:30
     */
    @Override
    public OverdueExempt selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询罚息免除任务表
     * @param example
     * @return List<OverdueExempt>
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:08:30
     */
    @Override
    public List<OverdueExempt> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过overdueExemptId查询罚息免除任务表
     * @param overdueExemptId
     * @return OverdueExempt
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:08:30
     */
    @Override
    public OverdueExempt selectByPrimaryKey(Object overdueExemptId) {
        return super.selectByPrimaryKey(overdueExemptId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询罚息免除任务表
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<OverdueExempt>
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:08:30
     */
    @Override
    public PageInfoExtend<OverdueExempt> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询罚息免除任务表vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:08:30
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 通过合同号关联查询逾期罚息表和罚息免除任务明细表信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public List<ContOverdueVo> selectContOverdueAndOverdueExemptDetailByContNo(String contNo,String overdueExemptNo){
        return baseDao.selectContOverdueAndOverdueExemptDetailByContNo(contNo,overdueExemptNo);
    }

    /**
     * @Title:
     * @Description: 根据合同号关联查询合同信息等表并去重取得一条明细(页面上半部分)
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public ContOverdueOneVo selectOneContOverdueVo(String contNo){
        return baseDao.selectOneContOverdueVo(contNo);
    }

}
