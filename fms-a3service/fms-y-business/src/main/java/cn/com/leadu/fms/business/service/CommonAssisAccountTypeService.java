package cn.com.leadu.fms.business.service;

import cn.com.leadu.fms.pojo.finance.entity.AssisAccountType;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: CommonAssisAccountTypeService
 * @Description:
 * @date 2018/6/26
 */
public interface CommonAssisAccountTypeService {


    /**
     * @Title:
     * @Description:   根据types集合获取辅助核算类型管理
     * @param assisAccountTypes
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/26 10:49:32
     */
    List<AssisAccountType> findAssisAccountTypesByAccTypes(List<String> assisAccountTypes);

}
