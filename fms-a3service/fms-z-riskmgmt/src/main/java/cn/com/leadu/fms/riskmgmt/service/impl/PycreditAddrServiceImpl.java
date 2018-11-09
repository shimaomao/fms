package cn.com.leadu.fms.riskmgmt.service.impl;

import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditAnti;
import cn.com.leadu.fms.riskmgmt.service.PycreditAddrService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.riskmgmt.repository.PycreditAddrRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditAddr;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditaddr.PycreditAddrVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditaddr.vo.PycreditAddrSaveVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditaddr.vo.PycreditAddrModifyVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditaddr.vo.PycreditAddrDeleteVo;
import cn.com.leadu.fms.riskmgmt.validator.pycreditaddr.vo.PycreditAddrDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditAddrService
 * @Description: 地址核验业务实现层
 * @date 2018-06-04
 */
@Service
public class PycreditAddrServiceImpl implements PycreditAddrService {

    /**
     * @Fields  : 地址核验repository
     */
    @Autowired
    private PycreditAddrRepository pycreditAddrRepository;

    /**
     * @Title:
     * @Description: 分页查询地址核验
     * @param pycreditAddrVo
     * @return PageInfoExtend<PycreditAddr>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    public PageInfoExtend<PycreditAddr> findPycreditAddrsByPage(PycreditAddrVo pycreditAddrVo){
        Example example = SqlUtil.newExample(PycreditAddr.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<PycreditAddr> pageInfo = pycreditAddrRepository.selectListByExamplePage(example,pycreditAddrVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存地址核验
     * @param pycreditAddrSaveVo
     * @return java.lang.String
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    public void savePycreditAddr(PycreditAddrSaveVo pycreditAddrSaveVo){
        pycreditAddrRepository.insertData(pycreditAddrSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改地址核验
     * @param pycreditAddrModifyVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    public void modifyPycreditAddr(PycreditAddrModifyVo pycreditAddrModifyVo){
        pycreditAddrRepository.updateByPrimaryKeySelectiveData(pycreditAddrModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过pycreditAddrId删除地址核验
     * @param pycreditAddrDeleteVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    public void deletePycreditAddr(PycreditAddrDeleteVo pycreditAddrDeleteVo){
        pycreditAddrRepository.deleteData(pycreditAddrDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过pycreditAddrId集合删除地址核验
     * @param pycreditAddrDeleteListVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    public void deletePycreditAddrsByPycreditAddrIds(PycreditAddrDeleteListVo pycreditAddrDeleteListVo){
        pycreditAddrRepository.deleteDataList(pycreditAddrDeleteListVo.getPycreditAddrIds(),pycreditAddrDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据pycreditAddrId获取地址核验
     * @param pycreditAddrId
     * @return PycreditAddr
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:09:28
     */
    public PycreditAddr findPycreditAddrByPycreditAddrId(String pycreditAddrId){
        return pycreditAddrRepository.selectByPrimaryKey(pycreditAddrId);
    }
    /**
     * @Title:
     * @Description: 根据条件动态修改地址核验,并进行排他
     * @param documentNo
     * @return String
     * @throws
     * @author yanggang
     * @date 2018-6-22 15:08:52
     */
    public List<PycreditAddr> selectPycreditAddrList(String documentNo, int ceilingNumber){
        return pycreditAddrRepository.selectPycreditAddrList(documentNo,ceilingNumber);
    }
}
