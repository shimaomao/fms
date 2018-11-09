package cn.com.leadu.fms.prebiz.service;
import cn.com.leadu.fms.pojo.prebiz.vo.contcreate.ContCreateVo;
/**
 * Created by 89354 on 2018/3/30.
 */
public interface ContCreateService {
    /**
     * @Title:
     * @Description:  根据contractNo获取合同信息
     * @param contNo
     * @return Contract
     * @throws
     * @author huchenghao
     * @date 2018-3-30 18:48:00
     */
    ContCreateVo findContCreateByContNo(String contNo);

    /**
     * @Title:
     * @Description:  根据contractNo获取详情
     * @param contNo
     * @return Contract
     * @throws
     * @author huchenghao
     * @date 2018-3-30 18:48:00
     */
    ContCreateVo findContCreateDetailByContNo(String contNo);

    /**
     * @Title:
     * @Description:  保存合同信息
     * @param contCreateVo
     * @return Contract
     * @throws
     * @author huchenghao
     * @date 2018-3-30 18:48:00
     */
    void saveContCreate(ContCreateVo contCreateVo);

    /**
    * @Description: 取消合同
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/10/10 18:28
    */
    void cancelContCreate(ContCreateVo contCreateVo);
}
