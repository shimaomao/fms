package cn.com.leadu.fms.business.service;

import cn.com.leadu.fms.pojo.finance.vo.finbackfill.FinBackfillVo;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lijunjun
 * @ClassName: FinBackfillService
 * @Description: 融资回填业务层
 * @date 2018-05-11
 */
public interface CommonFinBackfillService {

	/**
	 * @Title:
	 * @Description:  财务回填
	 * @param finBackfillVo
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-11 16:12:19
	 */
	void finBackfill(FinBackfillVo finBackfillVo);


    void finBackfillByContNo(String contNo);
}
