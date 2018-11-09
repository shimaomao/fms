package cn.com.leadu.fms.riskmgmt.service.impl;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.riskmgmt.repository.PycreditCorpBkcheckRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditAddr;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpBkcheck;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditcorpbkcheck.PycreditCorpBkcheckVo;
import cn.com.leadu.fms.riskmgmt.service.PycreditCorpBkcheckService;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcorpbkcheck.vo.PycreditCorpBkcheckDeleteListVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcorpbkcheck.vo.PycreditCorpBkcheckDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcorpbkcheck.vo.PycreditCorpBkcheckModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditcorpbkcheck.vo.PycreditCorpBkcheckSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditCorpBkcheckService
 * @Description: 企业银行卡核查业务实现层
 * @date 2018-06-04
 */
@Service
public class PycreditCorpBkcheckServiceImpl implements PycreditCorpBkcheckService {

    /**
     * @Fields  : 企业银行卡核查repository
     */
    @Autowired
    private PycreditCorpBkcheckRepository pycreditCorpBkcheckRepository;

    /**
     * @Title:
     * @Description: 分页查询企业银行卡核查
     * @param pycreditCorpBkcheckVo
     * @return PageInfoExtend<PycreditCorpBkcheck>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    public PageInfoExtend<PycreditCorpBkcheck> findPycreditCorpBkchecksByPage(PycreditCorpBkcheckVo pycreditCorpBkcheckVo){
        Example example = SqlUtil.newExample(PycreditCorpBkcheck.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<PycreditCorpBkcheck> pageInfo = pycreditCorpBkcheckRepository.selectListByExamplePage(example,pycreditCorpBkcheckVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存企业银行卡核查
     * @param pycreditCorpBkcheckSaveVo
     * @return java.lang.String
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    public void savePycreditCorpBkcheck(PycreditCorpBkcheckSaveVo pycreditCorpBkcheckSaveVo){
        pycreditCorpBkcheckRepository.insertData(pycreditCorpBkcheckSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改企业银行卡核查
     * @param pycreditCorpBkcheckModifyVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    public void modifyPycreditCorpBkcheck(PycreditCorpBkcheckModifyVo pycreditCorpBkcheckModifyVo){
        pycreditCorpBkcheckRepository.updateByPrimaryKeySelectiveData(pycreditCorpBkcheckModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过pycreditCorpBkcheckId删除企业银行卡核查
     * @param pycreditCorpBkcheckDeleteVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    public void deletePycreditCorpBkcheck(PycreditCorpBkcheckDeleteVo pycreditCorpBkcheckDeleteVo){
        pycreditCorpBkcheckRepository.deleteData(pycreditCorpBkcheckDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过pycreditCorpBkcheckId集合删除企业银行卡核查
     * @param pycreditCorpBkcheckDeleteListVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    public void deletePycreditCorpBkchecksByPycreditCorpBkcheckIds(PycreditCorpBkcheckDeleteListVo pycreditCorpBkcheckDeleteListVo){
        pycreditCorpBkcheckRepository.deleteDataList(pycreditCorpBkcheckDeleteListVo.getPycreditCorpBkcheckIds(),pycreditCorpBkcheckDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据pycreditCorpBkcheckId获取企业银行卡核查
     * @param pycreditCorpBkcheckId
     * @return PycreditCorpBkcheck
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:10:18
     */
    public PycreditCorpBkcheck findPycreditCorpBkcheckByPycreditCorpBkcheckId(String pycreditCorpBkcheckId){
        return pycreditCorpBkcheckRepository.selectByPrimaryKey(pycreditCorpBkcheckId);
    }
    /**
     * @Title:
     * @Description: 根据条件动态修改企业银行卡核查,并进行排他
     * @param name
     * @return String
     * @throws
     * @author yanggang
     * @date 2018-6-22 15:08:52
     */
    public List<PycreditCorpBkcheck> selectPycreditCorpBkcheckList(String name, int ceilingNumber){
        return pycreditCorpBkcheckRepository.selectPycreditCorpBkcheckList(name,ceilingNumber);
    }
}
