package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.ContFinDetailDao;
import cn.com.leadu.fms.data.prebiz.repository.ContFinDetailRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.ContFinDetail;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.vo.contfindetail.ContFinDetailVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contfindetail.ContFinPayVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContFinDetailRepositoryImpl
 * @Description: 合同融资费用明细Repository 实现层
 * @date 2018-03-23
 */
@Repository
public class ContFinDetailRepositoryImpl extends AbstractBaseRepository<ContFinDetailDao, ContFinDetail> implements ContFinDetailRepository {

    /**
     * @Title:
     * @Description: 新增合同融资费用明细
     * @param contFinDetail
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:47:11
     */
    @Override
    public int insertData(ContFinDetail contFinDetail) {
        return super.insert(contFinDetail);
    }

    /**
     * @Title:
     * @Description: 批量保存合同融资费用明细
     * @param contFinDetails
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:47:11
     */
    @Override
    public int insertDataList(List<ContFinDetail> contFinDetails){
        return super.insertListByJdbcTemplate(contFinDetails);
    }

    /**
     * @Title:
     * @Description: 修改合同融资费用明细
     * @param contFinDetail
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:47:11
     */
    @Override
    public int updateByPrimaryKeyData(ContFinDetail contFinDetail) {
        return super.updateByPrimaryKey(contFinDetail);
    }

    /**
     * @Title:
     * @Description: 批量修改合同融资费用明细
     * @param contFinDetails
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:47:11
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ContFinDetail> contFinDetails){
        return super.insertListByJdbcTemplate(contFinDetails);
    }

    /**
     * @Title:
     * @Description: 动态修改合同融资费用明细
     * @param contFinDetail
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:47:11
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ContFinDetail contFinDetail) {
        return super.updateByPrimaryKeySelective(contFinDetail);
    }

    /**
     * @Title:
     * @Description: 批量动态修改合同融资费用明细
     * @param contFinDetails
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:47:11
     */
    public int updateByPrimaryKeySelectiveDataList(List<ContFinDetail> contFinDetails) {
        return super.updateListByPrimaryKeySelective(contFinDetails);
    }

    /**
     * @Title:
     * @Description: 根据条件修改合同融资费用明细
     * @param contFinDetail
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:47:11
     */
    @Override
    public int updateByExampleData(ContFinDetail contFinDetail, Example example) {
        return super.updateByExample(contFinDetail,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改合同融资费用明细
     * @param contFinDetail
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:47:11
     */
    @Override
    public int updateByExampleSelectiveData(ContFinDetail contFinDetail, Example example){
        return super.updateByExampleSelective(contFinDetail,example);
    }
    
    /**
     * @Title:
     * @Description: 根据contFinDetailId删除合同融资费用明细
     * @param contFinDetail
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:47:11
     */
    @Override
    public int deleteData(ContFinDetail contFinDetail) {
        return super.delete(contFinDetail);
    }

    /**
     * @Title:
     * @Description: 根据contFinDetailId集合批量删除合同融资费用明细
     * @param contFinDetail
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:47:11
     */
    public int deleteDataList(List contFinDetailIds,ContFinDetail contFinDetail){
        return super.deleteByIds(contFinDetailIds,contFinDetail);
    }

    /**
     * @Title:
     * @Description: 查询全部合同融资费用明细
     * @return List<ContFinDetail>
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:47:11
     */
    @Override
    public List<ContFinDetail> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个合同融资费用明细
     * @param example
     * @return ContFinDetail
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:47:11
     */
    @Override
    public ContFinDetail selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询合同融资费用明细
     * @param example
     * @return List<ContFinDetail>
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:47:11
     */
    @Override
    public List<ContFinDetail> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过contFinDetailId查询合同融资费用明细
     * @param contFinDetailId
     * @return ContFinDetail
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:47:11
     */
    @Override
    public ContFinDetail selectByPrimaryKey(Object contFinDetailId) {
        return super.selectByPrimaryKey(contFinDetailId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询合同融资费用明细
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ContFinDetail>
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:47:11
     */
    @Override
    public PageInfoExtend<ContFinDetail> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询合同融资费用明细vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<ContFinDetail>
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:47:11
     */
    public PageInfoExtend<ContFinDetail> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    @Override
    public List<ContFinDetailVo> selectContFinDetailVosByContNo(String contNo) {
        return baseDao.selectContFinDetailVosByContNo(contNo);
    }

    /**
     * @param contNo
     * @Description: 根据合同编号查询融资费用明细（附带付款表）
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/25 14:24
     */
    @Override
    public List<ContFinPayVo> selectContFinDetailsWithContPay(String contNo) {
        return baseDao.selectContFinDetailsWithContPay(contNo);
    }

}
