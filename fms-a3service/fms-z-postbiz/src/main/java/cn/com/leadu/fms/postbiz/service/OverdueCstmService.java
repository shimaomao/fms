package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.common.vo.FileVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasBankInfo;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.pojo.finance.vo.finrepaysked.FinRepaySkedVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.*;
import cn.com.leadu.fms.pojo.system.entity.SysUser;

import java.util.List;
import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmService
 * @Description: 逾期客户信息业务层
 * @date 2018-05-16
 */
public interface OverdueCstmService {

	/**
	 * @Title:
	 * @Description: 分页查询逾期客户信息
	 * @param overdueCstmVo
	 * @param sysUser
	 * @return PageInfoExtend<OverdueCstm>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	PageInfoExtend<OverduePostVo> findOverdueCstmsByPage(OverdueCstmVo overdueCstmVo,SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 保存逾期客户信息
	 * @param overdueCstmPostVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
    void saveOverdueCstmInfo(OverdueCstmPostVo overdueCstmPostVo, SysUser sysUser);

	/**
	 * @Title:
	 * @Description: 催收函生成
	 * @param overdueCstmPostVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
    FileVo collectionLetterDownload(OverdueCstmPostVo overdueCstmPostVo);

	/**
	 * @Title:
	 * @Description: 律师函生成
	 * @param overdueCstmPostVo
	 * @return java.lang.String
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
    FileVo lawyerLetterDownload(OverdueCstmPostVo overdueCstmPostVo);

	/**
	 * @Title:
	 * @Description:  根据overdueCstmId获取逾期客户信息
	 * @param overdueCstmId
	 * @return OverdueCstm
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	OverdueCstmVo findOverdueCstmByOverdueCstmId(String overdueCstmId);

	/**
	 * @Title:
	 * @Description:  根据overdueCstmId获取逾期客户信息
	 * @param overdueCstmId
	 * @return OverdueCstmVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	OverdueCstmVo findOverdueCstmVoByOverdueCstmId(String overdueCstmId);

	/**
	 * @Title:
	 * @Description: 分页查询逾期客户信息
	 * @param overdueCstmVo
	 * @return PageInfoExtend<ContRepaySkedOverdueTotalVo>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	PageInfoExtend<ContRepaySkedOverdueTotalVo> findContRepaySkedAndOverduByoverdueCstmId(OverdueCstmVo overdueCstmVo);

	/**
	 * @Title:
	 * @Description: 当前销售未还剩余本金 -->打开 合同还款计划表
	 * @param overdueCstmVo
	 * @return PageInfoExtend<ContRepaySkedVo>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	PageInfoExtend<ContRepaySkedVo> findContRepaySkedVoByContNo(OverdueCstmVo overdueCstmVo);

	/**
	 * @Title:
	 * @Description: 当前财务未还剩余本金 -->打开【财务还款计划表】*关联合同还款计划表取得扣款状态
	 * @param overdueCstmVo
	 * @return PageInfoExtend<ContRepaySkedVo>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	PageInfoExtend<FinRepaySkedVo> findContOverdueVoByContNo(OverdueCstmVo overdueCstmVo);

	/**
	 * @Title:
	 * @Description: 获取登记电话、地址等基础信息
	 * @param overdueCstmPostVo
	 * @return OverdueCstm
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	OverdueCstmPostVo findOverdueRegisterInfo(OverdueCstmPostVo overdueCstmPostVo);

	/**
	 * 构造生成pdf的参数
	 * @param contRepaySkedVoList
	 * @param basBankInfoGroup
	 * @param pdfVariables
	 */
	void buildMapParams(List<ContRepaySkedVo> contRepaySkedVoList, BasBankInfo basBankInfoGroup, Map<String,String> pdfVariables);

	/**
	 * 获取银行机构信息
	 * @param belongGroup
	 * @return
	 */
	BasBankInfo getBasBankInfo(String belongGroup);

	/**
	 * 生成担保个人与担保企业pdf
	 * @param collectionLetterVo
	 * @param pdfVariables
	 * @param files
	 */
	void pdfCreateGuarantee(CollectionLetterVo collectionLetterVo, Map<String, String> pdfVariables, List<FileVo> files);

	/**
	 * @Title:
	 * @Description: 获取分配人员信息
	 * @return
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-16 10:23:04
	 */
	List<SysUser> findAssignUsers();
}
