package cn.com.leadu.fms.product.service.impl;

import cn.com.leadu.fms.common.constant.enums.CommonStatusEnums;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.product.service.IntrstFactorService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.product.repository.IntrstFactorRepository;
import cn.com.leadu.fms.pojo.product.entity.IntrstFactor;
import cn.com.leadu.fms.pojo.product.vo.intrstfactor.IntrstFactorVo;
import cn.com.leadu.fms.product.validator.intrstfactor.vo.IntrstFactorSaveVo;
import cn.com.leadu.fms.product.validator.intrstfactor.vo.IntrstFactorModifyVo;
import cn.com.leadu.fms.product.validator.intrstfactor.vo.IntrstFactorDeleteVo;
import cn.com.leadu.fms.product.validator.intrstfactor.vo.IntrstFactorDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author niehaibing
 * @ClassName: IntrstFactorService
 * @Description: 利率因子业务实现层
 * @date 2018-03-27
 */
@Service
public class IntrstFactorServiceImpl implements IntrstFactorService {

    /**
     * @Fields  : 利率因子repository
     */
    @Autowired
    private IntrstFactorRepository intrstFactorRepository;

    /**
     * @Title:
     * @Description: 分页查询利率因子
     * @param intrstFactorVo
     * @return PageInfoExtend<IntrstFactor>
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    public PageInfoExtend<IntrstFactor> findIntrstFactorsByPage(IntrstFactorVo intrstFactorVo){
        Example example = SqlUtil.newExample(IntrstFactor.class);
        Example.Criteria criteria = example.createCriteria();
        //设置查询条件
        if (StringUtils.isNotTrimBlank(intrstFactorVo.getFactorCode())){
            criteria.andLike("factorCode",SqlUtil.likePattern(intrstFactorVo.getFactorCode()));
        }
        if (StringUtils.isNotTrimBlank(intrstFactorVo.getFactorName())){
            criteria.andLike("factorName",SqlUtil.likePattern(intrstFactorVo.getFactorName()));
        }
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<IntrstFactor> pageInfo = intrstFactorRepository.selectListByExamplePage(example,intrstFactorVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存利率因子
     * @param intrstFactorSaveVo
     * @return java.lang.String
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    public void saveIntrstFactor(IntrstFactorSaveVo intrstFactorSaveVo){
        intrstFactorRepository.insertData(intrstFactorSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改利率因子
     * @param intrstFactorModifyVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    public void modifyIntrstFactor(IntrstFactorModifyVo intrstFactorModifyVo){
        intrstFactorRepository.updateByPrimaryKeySelectiveData(intrstFactorModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过intrstFactorId删除利率因子
     * @param intrstFactorDeleteVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    public void deleteIntrstFactor(IntrstFactorDeleteVo intrstFactorDeleteVo){
        intrstFactorRepository.deleteData(intrstFactorDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过intrstFactorId集合删除利率因子
     * @param intrstFactorDeleteListVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    public void deleteIntrstFactorsByIntrstFactorIds(IntrstFactorDeleteListVo intrstFactorDeleteListVo){
        intrstFactorRepository.deleteDataList(intrstFactorDeleteListVo.getIntrstFactorIds(),intrstFactorDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据intrstFactorId获取利率因子
     * @param intrstFactorId
     * @return IntrstFactor
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    public IntrstFactor findIntrstFactorByIntrstFactorId(String intrstFactorId) {
        return intrstFactorRepository.selectByPrimaryKey(intrstFactorId);
    }

    /**
     * @Title:
     * @Description: 取得全部启用的利率因子
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-27 18:07:17
     */
    public List<IntrstFactor> findIntrstFactorAllList() {
        Example example = SqlUtil.newExample(IntrstFactor.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andEqualTo("enableFlag", CommonStatusEnums.ENABLE.getType());
        SqlUtil.setOrderByColumnAsc(example, "order_no");
        return intrstFactorRepository.selectListByExample(example);
    }

}
