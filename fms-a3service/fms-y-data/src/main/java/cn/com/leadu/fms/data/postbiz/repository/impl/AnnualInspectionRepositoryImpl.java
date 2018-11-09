package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.AnnualInspectionDao;
import cn.com.leadu.fms.data.postbiz.repository.AnnualInspectionRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.AnnualInspection;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.vo.annualinspection.AnnualInspectionVo;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qinmuqiao
 * @ClassName: AnnualInspectionRepositoryImpl
 * @Description: 年检提醒Repository 实现层
 */
@Repository
public class AnnualInspectionRepositoryImpl extends AbstractBaseRepository<AnnualInspectionDao, AnnualInspection> implements AnnualInspectionRepository {

    /**
     * @Title:
     * @Description: 新增年检提醒
     * @param annualInspection
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @Override
    public int insertData(AnnualInspection annualInspection) {
        return super.insert(annualInspection);
    }

    /**
     * @Title:
     * @Description: 批量保存年检提醒
     * @param annualInspections
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @Override
    public int insertDataList(List<AnnualInspection> annualInspections){
        return super.insertListByJdbcTemplate(annualInspections);
    }

    /**
     * @Title:
     * @Description: 修改年检提醒
     * @param annualInspection
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @Override
    public int updateByPrimaryKeyData(AnnualInspection annualInspection) {
        return super.updateByPrimaryKey(annualInspection);
    }

    /**
     * @Title:
     * @Description: 批量修改年检提醒
     * @param annualInspections
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @Override
    public int updateByPrimaryKeyDataList(List<AnnualInspection> annualInspections){
        return super.updateListByPrimaryKey(annualInspections);
    }

    /**
     * @Title:
     * @Description: 动态修改年检提醒
     * @param annualInspection
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @Override
    public int updateByPrimaryKeySelectiveData(AnnualInspection annualInspection) {
        return super.updateByPrimaryKeySelective(annualInspection);
    }

    /**
     * @Title:
     * @Description: 批量动态修改年检提醒
     * @param annualInspections
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<AnnualInspection> annualInspections) {
        return super.updateListByPrimaryKeySelective(annualInspections);
    }

    /**
     * @Title:
     * @Description: 根据条件修改年检提醒
     * @param annualInspection
     * @param example
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @Override
    public int updateByExampleData(AnnualInspection annualInspection, Example example) {
        return super.updateByExample(annualInspection,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改年检提醒
     * @param annualInspection
     * @param example
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @Override
    public int updateByExampleSelectiveData(AnnualInspection annualInspection, Example example){
        return super.updateByExampleSelective(annualInspection,example);
    }
    
    /**
     * @Title:
     * @Description: 根据annualInspectionId删除年检提醒
     * @param annualInspection
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @Override
    public int deleteData(AnnualInspection annualInspection) {
        return super.delete(annualInspection);
    }

    /**
     * @Title:
     * @Description: 根据annualInspectionId集合批量删除年检提醒
     * @param annualInspection
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @Override
    public int deleteDataList(List annualInspectionIds,AnnualInspection annualInspection){
        return super.deleteByIds(annualInspectionIds,annualInspection);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除年检提醒
     * @param example
     * @param annualInspection
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @Override
    public int deleteExampleData(Example example,AnnualInspection annualInspection){
        return super.deleteByExample(example,annualInspection);
    }

    /**
     * @Title:
     * @Description: 查询全部年检提醒
     * @return List<AnnualInspection>
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @Override
    public List<AnnualInspection> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个年检提醒
     * @param example
     * @return AnnualInspection
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @Override
    public AnnualInspection selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询年检提醒
     * @param example
     * @return List<AnnualInspection>
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @Override
    public List<AnnualInspection> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过annualInspectionId查询年检提醒
     * @param annualInspectionId
     * @return AnnualInspection
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @Override
    public AnnualInspection selectByPrimaryKey(Object annualInspectionId) {
        return super.selectByPrimaryKey(annualInspectionId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询年检提醒
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<AnnualInspection>
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @Override
    public PageInfoExtend<AnnualInspection> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询年检提醒vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改年检提醒
     * @param annualInspection,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @Override
    public int updateByPrimaryKeyData(AnnualInspection annualInspection,boolean exclusive) {
        return super.updateByPrimaryKey(annualInspection,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改年检提醒,并进行排他
     * @param annualInspections
     * @param exclusive
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @Override
    public int updateByPrimaryKeyDataList(List<AnnualInspection> annualInspections,boolean exclusive){
        return super.updateListByPrimaryKey(annualInspections,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改年检提醒,并进行排他
     * @param annualInspection
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(AnnualInspection annualInspection,boolean exclusive) {
        return super.updateByPrimaryKeySelective(annualInspection,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改年检提醒,并进行排他
     * @param annualInspections
     * @param exclusive
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<AnnualInspection> annualInspections,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(annualInspections,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改年检提醒,并进行排他
     * @param annualInspection
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @Override
    public int updateByExampleData(AnnualInspection annualInspection, Example example,boolean exclusive) {
        return super.updateByExample(annualInspection,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改年检提醒,并进行排他
     * @param annualInspection
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @Override
    public int updateByExampleSelectiveData(AnnualInspection annualInspection, Example example,boolean exclusive){
        return super.updateByExampleSelective(annualInspection,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 获取合同信息表里面需要年检的车辆数据
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @Override
    public List<Contract> selectContractsByPaymentSts(Integer annualinspectionYear ,Integer annualinspectionDays){
        return baseDao.selectContractsByPaymentSts(annualinspectionYear,annualinspectionDays);
    }


    /**
     * @Title:
     * @Description: 根据ID获取年检Vo信息
     * @return List<Contract>
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @Override
    public AnnualInspectionVo selectAnnualInspectionVoByAnnualInespectionId(String annualinspectionId){
        return baseDao.selectAnnualInspectionVoByAnnualInspectionId(annualinspectionId);
    }

}
