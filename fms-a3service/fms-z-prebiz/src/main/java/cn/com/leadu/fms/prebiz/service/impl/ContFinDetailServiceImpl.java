package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.common.constant.enums.prebiz.FinItemTypeEnums;
import cn.com.leadu.fms.common.constant.enums.product.FinItemEnums;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.ContFinDetailRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.ContFinDetail;
import cn.com.leadu.fms.pojo.prebiz.vo.contfindetail.ContFinDetailVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contfindetail.ContFinPayVo;
import cn.com.leadu.fms.prebiz.service.ContFinDetailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContFinDetailService
 * @Description: 合同融资费用明细信息业务实现层
 * @date 2018-03-23
 */
@Service
public class ContFinDetailServiceImpl implements ContFinDetailService {

    /**
     * @Fields  : 合同融资费用明细信息repository
     */
    @Autowired
    private ContFinDetailRepository contFinDetailRepository;

    /**
     * @Title:
     * @Description: 分页查询合同融资费用明细信息
     * @param contFinDetailVo
     * @return PageInfoExtend<ContFinDetail>
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:47:11
     */
    public PageInfoExtend<ContFinDetail> findContFinDetailsByPage(ContFinDetailVo contFinDetailVo){
        Example example = SqlUtil.newExample(ContFinDetail.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<ContFinDetail> pageInfo = contFinDetailRepository.selectListByExamplePage(example,contFinDetailVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description:  根据contFinDetailId获取合同融资费用明细信息
     * @param contFinDetailId
     * @return ContFinDetail
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:47:11
     */
    public ContFinDetail findContFinDetailByContFinDetailId(String contFinDetailId){
        return contFinDetailRepository.selectByPrimaryKey(contFinDetailId);
    }

    /**
     * @Title:
     * @Description:  批量插入合同融资费用明细信息
     * @param contFinDetailList
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:47:11
     */
    public int insertContFinDetails(List<ContFinDetail> contFinDetailList){
        return contFinDetailRepository.insertDataList(contFinDetailList);
    }

    @Override
    public List<ContFinDetailVo> findContFinDetailVosByContNo(String contNo) {
        List<ContFinDetailVo> contFinDetailVoList = contFinDetailRepository.selectContFinDetailVosByContNo(contNo);
        if (ArrayUtils.isNotNullAndLengthNotZero(contFinDetailVoList)) {
            for (ContFinDetailVo contFinDetailVo : contFinDetailVoList) {
                // 融资项目名
                if (contFinDetailVo.getFinItemYear() != null && contFinDetailVo.getFinItemYear() > 0) {
                    String finItemName = contFinDetailVo.getFinItemName() + "(第" + contFinDetailVo.getFinItemYear() + "年)";
                    contFinDetailVo.setFinItemName(finItemName);
                }
            }
            return contFinDetailVoList;
        }
        return new ArrayList<>();
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
    public List<ContFinPayVo> findContFinDetailsWithContPay(String contNo) {
        return contFinDetailRepository.selectContFinDetailsWithContPay(contNo);
    }

    /**
     * @Title:
     * @Description:   根据合同号查询合同融资费用明细
     * @param contNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018/06/01 10:20:05
     */
    @Override
    public List<ContFinDetail> findContFinDetailsByContNo(String contNo) {
        Example example = SqlUtil.newExample(ContFinDetail.class);
        example.createCriteria().andEqualTo("contNo",contNo).andEqualTo("finItem", FinItemEnums.INSURANCE.getCode());
        return contFinDetailRepository.selectListByExample(example);
    }

}
