package cn.com.leadu.fms.business.service;

import cn.com.leadu.fms.pojo.finance.entity.SubjectAssisAccount;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: CommonSubjectAssisAccountService
 * @Description:
 * @date 2018/6/25
 */
public interface CommonSubjectAssisAccountService {

    /**
     * @Title:
     * @Description:   根据科目代码查询科目核算管理
     * @param subjectCds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/25 08:21:23
     */
    List<SubjectAssisAccount> findSubjectAssisAccountsBySubjectCds(List<String> subjectCds);

}
