package cn.com.leadu.fms.riskmgmt.service.impl;

import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpBkcheck;
import cn.com.leadu.fms.riskmgmt.service.PycreditCorpDebtService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.riskmgmt.repository.PycreditCorpDebtRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpDebt;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditcorpdebt.PycreditCorpDebtVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcorpdebt.vo.PycreditCorpDebtSaveVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcorpdebt.vo.PycreditCorpDebtModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcorpdebt.vo.PycreditCorpDebtDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcorpdebt.vo.PycreditCorpDebtDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditCorpDebtService
 * @Description: 企业债务业务实现层
 * @date 2018-06-04
 */
@Service
public class PycreditCorpDebtServiceImpl implements PycreditCorpDebtService {

    /**
     * @Fields  : 企业债务repository
     */
    @Autowired
    private PycreditCorpDebtRepository pycreditCorpDebtRepository;

    /**
     * @Title:
     * @Description: 分页查询企业债务
     * @param pycreditCorpDebtVo
     * @return PageInfoExtend<PycreditCorpDebt>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    public PageInfoExtend<PycreditCorpDebt> findPycreditCorpDebtsByPage(PycreditCorpDebtVo pycreditCorpDebtVo){
        Example example = SqlUtil.newExample(PycreditCorpDebt.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<PycreditCorpDebt> pageInfo = pycreditCorpDebtRepository.selectListByExamplePage(example,pycreditCorpDebtVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存企业债务
     * @param pycreditCorpDebtSaveVo
     * @return java.lang.String
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    public void savePycreditCorpDebt(PycreditCorpDebtSaveVo pycreditCorpDebtSaveVo){
        pycreditCorpDebtRepository.insertData(pycreditCorpDebtSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改企业债务
     * @param pycreditCorpDebtModifyVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    public void modifyPycreditCorpDebt(PycreditCorpDebtModifyVo pycreditCorpDebtModifyVo){
        pycreditCorpDebtRepository.updateByPrimaryKeySelectiveData(pycreditCorpDebtModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过pycreditCorpDebtId删除企业债务
     * @param pycreditCorpDebtDeleteVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    public void deletePycreditCorpDebt(PycreditCorpDebtDeleteVo pycreditCorpDebtDeleteVo){
        pycreditCorpDebtRepository.deleteData(pycreditCorpDebtDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过pycreditCorpDebtId集合删除企业债务
     * @param pycreditCorpDebtDeleteListVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    public void deletePycreditCorpDebtsByPycreditCorpDebtIds(PycreditCorpDebtDeleteListVo pycreditCorpDebtDeleteListVo){
        pycreditCorpDebtRepository.deleteDataList(pycreditCorpDebtDeleteListVo.getPycreditCorpDebtIds(),pycreditCorpDebtDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据pycreditCorpDebtId获取企业债务
     * @param pycreditCorpDebtId
     * @return PycreditCorpDebt
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:11:32
     */
    public PycreditCorpDebt findPycreditCorpDebtByPycreditCorpDebtId(String pycreditCorpDebtId){
        return pycreditCorpDebtRepository.selectByPrimaryKey(pycreditCorpDebtId);
    }
    /**
     * @Title:
     * @Description: 根据条件动态修改企业债务,并进行排他
     * @param name
     * @return String
     * @throws
     * @author yanggang
     * @date 2018-6-22 15:08:52
     */
    public List<PycreditCorpDebt> selectPycreditCorpDebtList(String name, int ceilingNumber){
        return pycreditCorpDebtRepository.selectPycreditCorpDebtList(name,ceilingNumber);
    }
}
