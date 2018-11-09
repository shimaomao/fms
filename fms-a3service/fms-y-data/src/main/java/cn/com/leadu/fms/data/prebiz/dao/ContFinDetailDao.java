package cn.com.leadu.fms.data.prebiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.prebiz.entity.ContFinDetail;
import cn.com.leadu.fms.pojo.prebiz.vo.contfindetail.ContFinDetailVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contfindetail.ContFinPayVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContFinDetailDao
 * @Description: 合同融资费用明细信息dao层
 * @date 2018-03-23
 */
public interface ContFinDetailDao extends BaseDao<ContFinDetail> {

    List<ContFinDetailVo> selectContFinDetailVosByContNo(@Param("contNo") String contNo);

    /** 
    * @Description: 根据合同编号查询融资费用明细（附带付款表）
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/25 14:34
    */ 
    List<ContFinPayVo> selectContFinDetailsWithContPay(@Param("contNo")String contNo);
}