package cn.com.leadu.fms.business.service.impl;

import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.system.repository.NumGenerateRepository;
import cn.com.leadu.fms.pojo.system.entity.NumGenerate;
import cn.com.leadu.fms.pojo.system.vo.numgenerate.NumGenerateVo;
import cn.com.leadu.fms.business.service.NumGenerateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * @author liujinge
 * @ClassName: NumGenerateService
 * @Description: 业务编号管理业务实现层
 * @date 2018-03-26
 */
@Service
public class NumGenerateServiceImpl implements NumGenerateService {

    /**
     * @Fields  : 业务编号管理repository
     */
    @Autowired
    private NumGenerateRepository numGenerateRepository;

    /**
     * @Title:
     * @Description: 分页查询业务编号管理
     * @param numGenerateVo
     * @return PageInfoExtend<NumGenerate>
     * @throws
     * @author liujinge
     * @date 2018-3-26 14:53:41
     */
    public PageInfoExtend<NumGenerate> findNumGeneratesByPage(NumGenerateVo numGenerateVo){
        Example example = SqlUtil.newExample(NumGenerate.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<NumGenerate> pageInfo = numGenerateRepository.selectListByExamplePage(example,numGenerateVo.getPageQuery());
        return pageInfo;
    }
    /**
     * @Title:
     * @Description:  根据numGenerateId获取业务编号管理
     * @param numGenerateId
     * @return NumGenerate
     * @throws
     * @author liujinge
     * @date 2018-3-26 14:53:41
     */
    public NumGenerate findNumGenerateByNumGenerateId(String numGenerateId){
        return numGenerateRepository.selectByPrimaryKey(numGenerateId);
    }

    /**
     * @Title:
     * @Description:  根据numType获取业务编号
     * @param numType
     * @return String
     * @throws
     * @author liujinge
     * @date 2018-3-26 14:53:41
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String getNumGenerateByNumType(String numType){
        String date = null;
        /*if(NumTypeEnums.CONTRACT_NUM_TYPE.getType().equals(numType)){
            date = DateUtils.getNowDateStr("yyyyMMdd");
        }*/
        //取得当前业务编号数值
        NumGenerate numGenerate = numGenerateRepository.selectByNumTypeLock(numType, date);
        int numGenerateRtn ;
        if(numGenerate == null){
            numGenerateRtn = 1;
            numGenerate = new NumGenerate();
            numGenerate.setGenerateDate(date);
            numGenerate.setNumType(numType);
            numGenerate.setNumSeq(1);
            numGenerate.setNumLength(4);
            numGenerateRepository.insertData(numGenerate);
        } else {
            numGenerateRtn = numGenerate.getNumSeq() + 1;
            //更新业务编号+1
            NumGenerate numGenerateUpd = new NumGenerate();
            numGenerateUpd.setNumGenerateId(numGenerate.getNumGenerateId());
            numGenerateUpd.setNumSeq(numGenerateRtn);
            numGenerateRepository.updateByPrimaryKeySelectiveData(numGenerateUpd);
        }

        //返回格式化后的业务编号+1
        String prefixStr = "", suffixStr = "";
        int prefixLength = 0, suffixLength = 0;

        if(!StringUtils.isTrimBlank(numGenerate.getPrefix())){
            prefixStr = numGenerate.getPrefix();
            prefixLength = numGenerate.getPrefix().length();
        }

        if(!StringUtils.isTrimBlank(numGenerate.getSuffix())){
            suffixStr = numGenerate.getSuffix();
            suffixLength = numGenerate.getSuffix().length();
        }

        int strLength = numGenerate.getNumLength() - prefixLength - suffixLength;
        //返回格式化后的业务编号+1
        if(NumTypeEnums.ORIG_FILE_NUM.getType().equals(numType) ||
                NumTypeEnums.CONTRACT_NUM_TYPE.getType().equals(numType)){
            date = DateUtils.getNowDateStr("yyyyMMdd");
            return date + StringUtils.addZeroForNum(numGenerateRtn, strLength) + suffixStr;
        }
        return prefixStr + StringUtils.addZeroForNum(numGenerateRtn, strLength) + suffixStr;
    }
}
