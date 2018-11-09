package cn.com.leadu.fms.finance.service.impl;

import cn.com.leadu.fms.business.service.CommonSubjectAssisAccountService;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.SubjectAssisAccountRepository;
import cn.com.leadu.fms.finance.service.SubjectAssisAccountService;
import cn.com.leadu.fms.pojo.finance.entity.SubjectAssisAccount;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SubjectAssisAccountService
 * @Description: 科目辅助核算管理ServiceImpl
 * @date 2018-06-25
 */
@Service
public class SubjectAssisAccountServiceImpl implements SubjectAssisAccountService , CommonSubjectAssisAccountService {

    /**
     * @Fields  : 财务凭证数据repository
     */
    @Autowired
    private SubjectAssisAccountRepository subjectAssisAccountRepository;

    /**
     * @Title:
     * @Description:   根据科目代码查询科目核算管理
     * @param subjectCds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/25 08:21:23
     */
    public List<SubjectAssisAccount> findSubjectAssisAccountsBySubjectCds(List<String> subjectCds){
        List<SubjectAssisAccount> subjectAssisAccounts = null;
        if(ArrayUtils.isNotNullAndLengthNotZero(subjectCds)) {
            Example example = SqlUtil.newExample(SubjectAssisAccount.class);
            example.createCriteria().andIn("subjectCd", subjectCds);
            subjectAssisAccounts = subjectAssisAccountRepository.selectListByExample(example);
        }
        return subjectAssisAccounts;
    }

}
