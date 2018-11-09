package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.business.rpc.system.SysTplTypeRpc;
import cn.com.leadu.fms.business.service.TestExportExcelService;
import cn.com.leadu.fms.common.constant.enums.prebiz.DepositRtnModeEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ExcelUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.ContractFinanceRepository;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.prebiz.entity.ContractFinance;
import cn.com.leadu.fms.pojo.prebiz.vo.contractfinance.ContractFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.testexcel.DataList;
import cn.com.leadu.fms.pojo.prebiz.vo.testexcel.TestData;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;
import cn.com.leadu.fms.prebiz.service.ContractFinanceService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import javax.servlet.http.HttpServletResponse;
import java.io.OutputStream;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContractFinanceService
 * @Description: 合同融资信息业务实现层
 * @date 2018-03-23
 */
@Service
@Slf4j
public class ContractFinanceServiceImpl implements ContractFinanceService {

    /**
     * @Fields  : 合同融资信息repository
     */
    @Autowired
    private ContractFinanceRepository contractFinanceRepository;

    @Autowired
    private SysTplTypeRpc sysTplTypeRpc;

    @Autowired
    private TestExportExcelService testExportExcelService;

    /**
     * @Title:
     * @Description: 分页查询合同融资信息
     * @param contractFinanceVo
     * @return PageInfoExtend<ContractFinance>
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:11
     */
    public PageInfoExtend<ContractFinance> findContractFinancesByPage(ContractFinanceVo contractFinanceVo){
        Example example = SqlUtil.newExample(ContractFinance.class);
        Example.Criteria criteria = example.createCriteria();
        if(StringUtils.isNotTrimBlank(contractFinanceVo.getContNo()))
            criteria.andEqualTo("contNo", contractFinanceVo.getContNo());
        if(StringUtils.isNotTrimBlank(contractFinanceVo.getApplyNo()))
            criteria.andEqualTo("applyNo", contractFinanceVo.getApplyNo());
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<ContractFinance> pageInfo = contractFinanceRepository.selectListByExamplePage(example,contractFinanceVo.getPageQuery());
        return pageInfo;
    }
    /**
     * @Title:
     * @Description:  根据contFinId获取合同融资信息
     * @param contFinId
     * @return ContractFinance
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:11
     */
    public ContractFinance findContractFinanceByContFinId(String contFinId){
        return contractFinanceRepository.selectByPrimaryKey(contFinId);
    }
    /**
     * @Title:
     * @Description:  根据contFinId获取合同融资信息
     * @param contractFinanceList
     * @return ContractFinance
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:11
     */
    public int insertContractFinances(List<ContractFinance> contractFinanceList){
        return contractFinanceRepository.insertDataList(contractFinanceList);
    }
    /**
     * @Title:
     * @Description:  根据合同号获取合同融资信息
     * @param contNo
     * @return ContractFinanceVo
     * @throws
     * @author huchengao
     * @date 2018-3-30 18:46:11
     */
    @Override
    public ContractFinanceVo findContractFinanceVoByContNo(String contNo) {
        ContractFinanceVo contractFinanceVo = contractFinanceRepository.selectContractFinanceVoByContNo(contNo);
        return contractFinanceVo;
    }

    /**
     * @param contNo
     * @Description: 根据合同号查找保证金，保证金返还方式 = 一次性的场合 ，不是一次性返回0
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/14 16:35
     */
    @Override
    public BigDecimal findContractFinancesDepositByContNo(String contNo) {
        ContractFinanceVo contractFinanceVo = contractFinanceRepository.selectContractFinanceVoByContNo(contNo);
        if(contractFinanceVo==null){
            throw new FmsServiceException("获取合同融资信息失败");
        }
        if(StringUtils.equals(contractFinanceVo.getDepositRtnMode(), DepositRtnModeEnums.ONETIME_DEPOSIT.getType())){
            return contractFinanceVo.getDeposit();
        }
        return new BigDecimal(0);
    }

    /**
     * @param contractFinance
     * @Description: 根据合同号更新合同融资信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/14 16:35
     */
    @Override
    public void updateContractFinanceByContNo(ContractFinance contractFinance){
        if(StringUtils.isTrimBlank(contractFinance.getContNo())){
            throw new FmsServiceException("合同号不能为空");
        }
        Example example = SqlUtil.newExample(ContractFinance.class);
        example.createCriteria().andEqualTo("contNo",contractFinance.getContNo());
        contractFinanceRepository.updateByExampleSelectiveData(contractFinance, example);
    }
    /**
     * @Title:
     * @Description:  有模板出excel测试
     * @param httpServletResponse
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/01/31 03:06:04
     */
    public void testExport(HttpServletResponse httpServletResponse){
        //构建模板需要映射的数据，由于是参考，这里造的是假数据,实际上需要通过db查询构造
        TestData sd = new TestData();
        sd.setName("小明");
        sd.setSex("男");
        sd.setAge("25");
        List<DataList> list = new ArrayList();
        for(int j = 0 ; j < 12 ; j++) {
            DataList td = new DataList(String.valueOf(j),new BigDecimal(100).add(new BigDecimal(j)),new Date());
            list.add(td);
        }
        sd.setList(list);

        //获取模板
        SysTplType sysTplType;
        try {
            sysTplType = ResponseEntityUtils.getRestResponseData(sysTplTypeRpc.
                    findSysTplTypeByTplTypeKey("testExport")); //模板key需要用枚举
        } catch (FmsRpcException e) {
            e.printStackTrace();
            throw new FmsServiceException("获取文件模板失败,生成合同文件失败");
        }
        if(sysTplType ==null){
            throw new FmsServiceException("文件模板不存在,生成合同文件失败");
        }

        //生成excel
        try{
            if(sd == null)
                throw new FmsServiceException("请传递生成excel的必要参数");
            String fileName = sysTplType.getTplTypeName();
            OutputStream outputStream = httpServletResponse.getOutputStream();
            httpServletResponse.setContentType("application/vnd.ms-excel;charset=utf-8");
            httpServletResponse.addHeader("Content-Disposition", "attachment; filename=" + ExcelUtils.getExcelName(new String(new String(fileName.getBytes("gb2312"), "iso8859-1"))));
            testExportExcelService.export(sysTplType,sd,outputStream);
        }catch (Exception ex){
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new FmsServiceException("生成excel失败");
        }
    }


}
