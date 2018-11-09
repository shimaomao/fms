package cn.com.leadu.fms.baseinfo.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasPartner;
import cn.com.leadu.fms.pojo.baseinfo.vo.baspartner.BasPartnerVo;
import cn.com.leadu.fms.baseinfo.validator.baspartner.vo.BasPartnerDeleteListVo;
import cn.com.leadu.fms.baseinfo.validator.baspartner.vo.BasPartnerDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.baspartner.vo.BasPartnerModifyVo;
import cn.com.leadu.fms.baseinfo.validator.baspartner.vo.BasPartnerSaveVo;

/**
 * @author huchenghao
 * @ClassName: BasPartnerService
 * @Description: 经销商信息维护业务层
 * @date 2018-03-17
 */
public interface BasPartnerService {

	/**
	 * @Title:
	 * @Description: 分页查询经销商信息维护
	 * @param basPartnerVo
	 * @return PageInfoExtend<BasPartner>
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-17 10:35:33
	 */
	PageInfoExtend<BasPartner> findBasPartnersByPage(BasPartnerVo basPartnerVo);

	/**
	 * @Title:
	 * @Description: 保存经销商信息维护 返回保存状态
	 * @param basPartnerSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-17 10:35:33
	 */
    String saveBasPartner(BasPartnerSaveVo basPartnerSaveVo);


	/**
	 * @Title:
	 * @Description: 修改经销商信息维护
	 * @param basPartnerModifyVo
	 * @return
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-17 10:35:33
	 */
	String modifyBasPartner(BasPartnerModifyVo basPartnerModifyVo);

	/**
	 * @Title:
	 * @Description:  通过partnerId删除经销商信息维护
	 * @param basPartnerDeleteVo
	 * @return
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-17 10:35:33
	 */
	void deleteBasPartner(BasPartnerDeleteVo basPartnerDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过partnerId集合删除经销商信息维护
	 * @param basPartnerDeleteListVo
	 * @return
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-17 10:35:33
	 */
	void deleteBasPartnersByPartnerIds(BasPartnerDeleteListVo basPartnerDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据partnerId获取经销商信息维护
	 * @param partnerId
	 * @return BasPartner
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-17 10:35:33
	 */
	BasPartnerVo findBasPartnerByPartnerId(String partnerId);

	/**
	 * @Title:
	 * @Description:  根据当经销商代码，获取经销商信息
	 * @param partnerCode
	 * @return
	 * @throws
	 * @author wangxue
	 * @date 2018-3-22 19:35:32
	 */
	BasPartner findBasPartnerByPartnerCode(String partnerCode);

}
