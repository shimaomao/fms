package cn.com.leadu.fms.finance.service.impl;

import cn.com.leadu.fms.finance.service.ContReceiptExamService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.ContReceiptExamRepository;
import cn.com.leadu.fms.pojo.finance.entity.ContReceiptExam;
import cn.com.leadu.fms.pojo.finance.vo.contreceiptexam.ContReceiptExamVo;
import cn.com.leadu.fms.finance.validator.contreceiptexam.vo.ContReceiptExamSaveVo;
import cn.com.leadu.fms.finance.validator.contreceiptexam.vo.ContReceiptExamModifyVo;
import cn.com.leadu.fms.finance.validator.contreceiptexam.vo.ContReceiptExamDeleteVo;
import cn.com.leadu.fms.finance.validator.contreceiptexam.vo.ContReceiptExamDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author lijunjun
 * @ClassName: ContReceiptExamService
 * @Description: 财务勾稽业务实现层
 * @date 2018-05-09
 */
@Service
public class ContReceiptExamServiceImpl implements ContReceiptExamService {

    /**
     * @Fields  : 财务勾稽repository
     */
    @Autowired
    private ContReceiptExamRepository contReceiptExamRepository;

    /**
     * @Title:
     * @Description: 分页查询财务勾稽
     * @param contReceiptExamVo
     * @return PageInfoExtend<ContReceiptExam>
     * @throws
     * @author lijunjun
     * @date 2018-5-9 11:52:38
     */
    public PageInfoExtend<ContReceiptExam> findContReceiptExamsByPage(ContReceiptExamVo contReceiptExamVo){
        Example example = SqlUtil.newExample(ContReceiptExam.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<ContReceiptExam> pageInfo = contReceiptExamRepository.selectListByExamplePage(example,contReceiptExamVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存财务勾稽
     * @param contReceiptExamSaveVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-5-9 11:52:38
     */
    public void saveContReceiptExam(ContReceiptExamSaveVo contReceiptExamSaveVo){
        contReceiptExamRepository.insertData(contReceiptExamSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改财务勾稽
     * @param contReceiptExamModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-9 11:52:38
     */
    public void modifyContReceiptExam(ContReceiptExamModifyVo contReceiptExamModifyVo){
        contReceiptExamRepository.updateByPrimaryKeySelectiveData(contReceiptExamModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过contReceiptExamId删除财务勾稽
     * @param contReceiptExamDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-9 11:52:38
     */
    public void deleteContReceiptExam(ContReceiptExamDeleteVo contReceiptExamDeleteVo){
        contReceiptExamRepository.deleteData(contReceiptExamDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过contReceiptExamId集合删除财务勾稽
     * @param contReceiptExamDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-9 11:52:38
     */
    public void deleteContReceiptExamsByContReceiptExamIds(ContReceiptExamDeleteListVo contReceiptExamDeleteListVo){
        contReceiptExamRepository.deleteDataList(contReceiptExamDeleteListVo.getContReceiptExamIds(),contReceiptExamDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据contReceiptExamId获取财务勾稽
     * @param contReceiptExamId
     * @return ContReceiptExam
     * @throws
     * @author lijunjun
     * @date 2018-5-9 11:52:38
     */
    public ContReceiptExam findContReceiptExamByContReceiptExamId(String contReceiptExamId){
        return contReceiptExamRepository.selectByPrimaryKey(contReceiptExamId);
    }

}
