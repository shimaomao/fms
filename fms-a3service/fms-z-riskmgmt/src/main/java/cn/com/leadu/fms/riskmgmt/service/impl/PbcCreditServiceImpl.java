package cn.com.leadu.fms.riskmgmt.service.impl;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.riskmgmt.repository.PbcCreditRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PbcCredit;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pbccredit.PbcCreditVo;
import cn.com.leadu.fms.riskmgmt.service.PbcCreditService;
import cn.com.leadu.fms.riskmgmt.validator.pbccredit.vo.PbcCreditDeleteListVo;
import cn.com.leadu.fms.riskmgmt.validator.pbccredit.vo.PbcCreditDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.pbccredit.vo.PbcCreditModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.pbccredit.vo.PbcCreditSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PbcCreditService
 * @Description: 个人人行征信信息业务实现层
 * @date 2018-06-04
 */
@Service
public class PbcCreditServiceImpl implements PbcCreditService {

    /**
     * @Fields : 个人人行征信信息repository
     */
    @Autowired
    private PbcCreditRepository pbcCreditRepository;

    /**
     * @param pbcCreditVo
     * @return PageInfoExtend<PbcCredit>
     * @throws
     * @Title:
     * @Description: 分页查询个人人行征信信息
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    public PageInfoExtend<PbcCredit> findPbcCreditsByPage(PbcCreditVo pbcCreditVo) {
        Example example = SqlUtil.newExample(PbcCredit.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<PbcCredit> pageInfo = pbcCreditRepository.selectListByExamplePage(example, pbcCreditVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @param pbcCreditSaveVo
     * @return java.lang.String
     * @throws
     * @Title:
     * @Description: 保存个人人行征信信息
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    public void savePbcCredit(PbcCreditSaveVo pbcCreditSaveVo) {
        pbcCreditRepository.insertData(pbcCreditSaveVo.getEntity());
    }

    /**
     * @param pbcCreditModifyVo
     * @return
     * @throws
     * @Title:
     * @Description: 修改个人人行征信信息
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    public void modifyPbcCredit(PbcCreditModifyVo pbcCreditModifyVo) {
        pbcCreditRepository.updateByPrimaryKeySelectiveData(pbcCreditModifyVo.getEntity());
    }

    /**
     * @param pbcCreditDeleteVo
     * @return
     * @throws
     * @Title:
     * @Description: 通过pbcCreditId删除个人人行征信信息
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    public void deletePbcCredit(PbcCreditDeleteVo pbcCreditDeleteVo) {
        pbcCreditRepository.deleteData(pbcCreditDeleteVo.getEntity());
    }

    /**
     * @param pbcCreditDeleteListVo
     * @return
     * @throws
     * @Title:
     * @Description: 通过pbcCreditId集合删除个人人行征信信息
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    public void deletePbcCreditsByPbcCreditIds(PbcCreditDeleteListVo pbcCreditDeleteListVo) {
        pbcCreditRepository.deleteDataList(pbcCreditDeleteListVo.getPbcCreditIds(), pbcCreditDeleteListVo.getEntity());
    }

    /**
     * @param pbcCreditId
     * @return PbcCredit
     * @throws
     * @Title:
     * @Description: 根据pbcCreditId获取个人人行征信信息
     * @author liujinge
     * @date 2018-6-4 15:07:17
     */
    public PbcCredit findPbcCreditByPbcCreditId(String pbcCreditId) {
        return pbcCreditRepository.selectByPrimaryKey(pbcCreditId);
    }
    /**
     * @Title:
     * @Description:  根据applyNo获取个人风险信息
     * @param applyNo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:05:15
     */
    @Override
    public List<PbcCredit> findPbcCreditListByApplyNo(String applyNo) {
        Example example = SqlUtil.newExample(PbcCredit.class);
        example.createCriteria().andEqualTo("applyNo", applyNo);
        return pbcCreditRepository.selectListByExample(example);
    }
}


