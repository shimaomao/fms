package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.common.constant.enums.sql.DeleteFlags;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.prebiz.service.CstmPersAddrService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.CstmPersAddrRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmPersAddr;
import cn.com.leadu.fms.pojo.prebiz.vo.cstmpersaddr.CstmPersAddrVo;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.prebiz.validator.cstmpersaddr.vo.CstmPersAddrSaveVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersaddr.vo.CstmPersAddrModifyVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersaddr.vo.CstmPersAddrDeleteVo;
import cn.com.leadu.fms.prebiz.validator.cstmpersaddr.vo.CstmPersAddrDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author ningyangyang
 * @ClassName: CstmPersAddrService
 * @Description: 客户个人地址信息业务实现层
 * @date 2018-03-26
 */
@Service
public class CstmPersAddrServiceImpl implements CstmPersAddrService {

    /**
     * @Fields  : 客户个人地址信息repository
     */
    @Autowired
    private CstmPersAddrRepository cstmPersAddrRepository;
    /**
     * 枚举类
     */
    @Autowired
    private NumGenerateService numGenerateService;
    /**
     * @Title:
     * @Description: 分页查询客户个人地址信息
     * @param cstmPersAddrVo
     * @return PageInfoExtend<CstmPersAddr>
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    public PageInfoExtend<CstmPersAddr> findCstmPersAddrsByPage(CstmPersAddrVo cstmPersAddrVo){
        Example example = SqlUtil.newExample(CstmPersAddr.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<CstmPersAddr> pageInfo = cstmPersAddrRepository.selectListByExamplePage(example,cstmPersAddrVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存客户个人地址信息
     * @param cstmPersAddrSaveVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    public void saveCstmPersAddr(CstmPersAddrSaveVo cstmPersAddrSaveVo,String applyNo){
        //获取订单编号
       // String contractNo =  numGenerateService.getNumGenerateByNumType(CONTRACT_NUM_TYPE.getType());
        CstmPersAddr cstmPersAddr = cstmPersAddrSaveVo.getEntity();
        cstmPersAddr.setApplyNo(applyNo);
        cstmPersAddrRepository.insertData(cstmPersAddr);
    }

    /**
     * @Title:
     * @Description: 修改客户个人地址信息
     * @param cstmPersAddrModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    public void modifyCstmPersAddr(CstmPersAddrModifyVo cstmPersAddrModifyVo){
        cstmPersAddrRepository.updateByPrimaryKeySelectiveData(cstmPersAddrModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过persAddrId删除客户个人地址信息
     * @param cstmPersAddrDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    public void deleteCstmPersAddr(CstmPersAddrDeleteVo cstmPersAddrDeleteVo){
        cstmPersAddrRepository.deleteData(cstmPersAddrDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过persAddrId集合删除客户个人地址信息
     * @param cstmPersAddrDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    public void deleteCstmPersAddrsByPersAddrIds(CstmPersAddrDeleteListVo cstmPersAddrDeleteListVo){
        cstmPersAddrRepository.deleteDataList(cstmPersAddrDeleteListVo.getPersAddrIds(),cstmPersAddrDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据persAddrId获取客户个人地址信息
     * @param persAddrId
     * @return CstmPersAddr
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    public CstmPersAddr findCstmPersAddrByPersAddrId(String persAddrId){
        return cstmPersAddrRepository.selectByPrimaryKey(persAddrId);
    }

    /**
     * 根据订单号获取地址信息
     * @param applyNo
     * @return
     */
    public CstmPersAddr findCstmPersAddrByApplyNo(String applyNo){
        Example example = SqlUtil.newExample(CstmPersAddr.class);
        example.createCriteria().andEqualTo("applyNo",applyNo);
        return cstmPersAddrRepository.selectOneByExample(example);
    }
    /**
     * @Title:
     * @Description:  根据applyNo更新客户个人地址信息
     * @param cstmPersAddr
     * @return CstmPersAddr
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 21:06:53
     */
    @Override
    public void updateCstmPersAddrByApplyNo(CstmPersAddr cstmPersAddr,String applyNo) {
        if(StringUtils.isNotTrimBlank(applyNo)){
            Example example = SqlUtil.newExample(CstmPersAddr.class);
            example.createCriteria().andEqualTo("applyNo",applyNo);
            CstmPersAddr oldCstmPersAddr = cstmPersAddrRepository.selectOneByExample(example);
            cstmPersAddr.setApplyNo(applyNo);
            cstmPersAddr.setDelFlag(DeleteFlags.EXIST.getFlag());
            if(oldCstmPersAddr != null){
                cstmPersAddr.setCreateTime(oldCstmPersAddr.getCreateTime());
                cstmPersAddr.setCreator(oldCstmPersAddr.getCreator());
            }
            cstmPersAddrRepository.updateByExampleData(cstmPersAddr,example);
        }
    }
}
