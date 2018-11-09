package cn.com.leadu.fms.riskmgmt.service.impl;

import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditDriver;
import cn.com.leadu.fms.riskmgmt.service.PycreditPersonBkcheckService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.riskmgmt.repository.PycreditPersonBkcheckRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditPersonBkcheck;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditpersonbkcheck.PycreditPersonBkcheckVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditpersonbkcheck.vo.PycreditPersonBkcheckSaveVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditpersonbkcheck.vo.PycreditPersonBkcheckModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditpersonbkcheck.vo.PycreditPersonBkcheckDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditpersonbkcheck.vo.PycreditPersonBkcheckDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditPersonBkcheckService
 * @Description: 个人银行卡核查业务实现层
 * @date 2018-06-04
 */
@Service
public class PycreditPersonBkcheckServiceImpl implements PycreditPersonBkcheckService {

    /**
     * @Fields  : 个人银行卡核查repository
     */
    @Autowired
    private PycreditPersonBkcheckRepository pycreditPersonBkcheckRepository;

    /**
     * @Title:
     * @Description: 分页查询个人银行卡核查
     * @param pycreditPersonBkcheckVo
     * @return PageInfoExtend<PycreditPersonBkcheck>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    public PageInfoExtend<PycreditPersonBkcheck> findPycreditPersonBkchecksByPage(PycreditPersonBkcheckVo pycreditPersonBkcheckVo){
        Example example = SqlUtil.newExample(PycreditPersonBkcheck.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<PycreditPersonBkcheck> pageInfo = pycreditPersonBkcheckRepository.selectListByExamplePage(example,pycreditPersonBkcheckVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存个人银行卡核查
     * @param pycreditPersonBkcheckSaveVo
     * @return java.lang.String
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    public void savePycreditPersonBkcheck(PycreditPersonBkcheckSaveVo pycreditPersonBkcheckSaveVo){
        pycreditPersonBkcheckRepository.insertData(pycreditPersonBkcheckSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改个人银行卡核查
     * @param pycreditPersonBkcheckModifyVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    public void modifyPycreditPersonBkcheck(PycreditPersonBkcheckModifyVo pycreditPersonBkcheckModifyVo){
        pycreditPersonBkcheckRepository.updateByPrimaryKeySelectiveData(pycreditPersonBkcheckModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过pycreditPersonBkcheckId删除个人银行卡核查
     * @param pycreditPersonBkcheckDeleteVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    public void deletePycreditPersonBkcheck(PycreditPersonBkcheckDeleteVo pycreditPersonBkcheckDeleteVo){
        pycreditPersonBkcheckRepository.deleteData(pycreditPersonBkcheckDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过pycreditPersonBkcheckId集合删除个人银行卡核查
     * @param pycreditPersonBkcheckDeleteListVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    public void deletePycreditPersonBkchecksByPycreditPersonBkcheckIds(PycreditPersonBkcheckDeleteListVo pycreditPersonBkcheckDeleteListVo){
        pycreditPersonBkcheckRepository.deleteDataList(pycreditPersonBkcheckDeleteListVo.getPycreditPersonBkcheckIds(),pycreditPersonBkcheckDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据pycreditPersonBkcheckId获取个人银行卡核查
     * @param pycreditPersonBkcheckId
     * @return PycreditPersonBkcheck
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:53
     */
    public PycreditPersonBkcheck findPycreditPersonBkcheckByPycreditPersonBkcheckId(String pycreditPersonBkcheckId){
        return pycreditPersonBkcheckRepository.selectByPrimaryKey(pycreditPersonBkcheckId);
    }
    /**
     * @Title:
     * @Description: 根据条件动态修改驾驶证核查,并进行排他
     * @param documentNo
     * @return String
     * @throws
     * @author yanggang
     * @date 2018-6-22 15:08:52
     */
    public List<PycreditPersonBkcheck> selectPycreditPersonBkcheckList(String documentNo, int ceilingNumber){
        return pycreditPersonBkcheckRepository.selectPycreditPersonBkcheckList(documentNo,ceilingNumber);
    }
}
