package cn.com.leadu.fms.prebiz.service.impl;

import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.prebiz.repository.ContractVehicleRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.ContractVehicle;
import cn.com.leadu.fms.pojo.prebiz.vo.contfindetail.ContFinDetailVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractvehicle.ContractVehicleFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractvehicle.ContractVehicleVo;
import cn.com.leadu.fms.prebiz.service.ContFinDetailService;
import cn.com.leadu.fms.prebiz.service.ContractVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContractVehicleService
 * @Description: 合同融资车辆信息业务实现层
 * @date 2018-03-23
 */
@Service
public class ContractVehicleServiceImpl implements ContractVehicleService {

    /**
     * @Fields  : 合同融资车辆信息repository
     */
    @Autowired
    private ContractVehicleRepository contractVehicleRepository;

    /**
     * @Fields  : 合同融资费用明细
     */
    @Autowired
    private ContFinDetailService contFinDetailService;

    /**
     * @Title:
     * @Description: 分页查询合同融资车辆信息
     * @param contractVehicleVo
     * @return PageInfoExtend<ContractVehicle>
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:35
     */
    public PageInfoExtend<ContractVehicle> findContractVehiclesByPage(ContractVehicleVo contractVehicleVo){
        Example example = SqlUtil.newExample(ContractVehicle.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<ContractVehicle> pageInfo = contractVehicleRepository.selectListByExamplePage(example,contractVehicleVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description:  根据contVehicleId获取合同融资车辆信息
     * @param contVehicleId
     * @return ContractVehicle
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:35
     */
    public ContractVehicle findContractVehicleByContVehicleId(String contVehicleId){
        return contractVehicleRepository.selectByPrimaryKey(contVehicleId);
    }
    /**
     * @Title:
     * @Description:  批量插入合同车辆信息
     * @param contractVehicleList
     * @return insert
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:35
     */
    public int insertContractvehicles(List<ContractVehicle> contractVehicleList){
        return contractVehicleRepository.insertDataList(contractVehicleList);
    }

    @Override
    public ContractVehicleVo findContractVehicleVoByContNo(String contNo) {
        ContractVehicleVo contractVehicleVo;
        contractVehicleVo =  contractVehicleRepository.selectContractVehicleVoByContNo(contNo);
        //融资费用明细取得
        if(!StringUtils.isTrimBlank(contractVehicleVo)){
            List<ContFinDetailVo> contFinDetailVoList = contFinDetailService.findContFinDetailVosByContNo(contNo);
            contractVehicleVo.setContFinDetailVoList(contFinDetailVoList);
        }
        return contractVehicleVo;
    }

    /**
     * @param contNo
     * @Description: 查询合同车辆信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/21 16:49
     */
    @Override
    public ContractVehicleFinanceVo findContractVehicleFinanceVoByContNo(String contNo) {
        ContractVehicleFinanceVo contractVehicleFinanceVo = new ContractVehicleFinanceVo();
        contractVehicleFinanceVo.setContNo(contNo);
        //设置个人标志
        contractVehicleFinanceVo.setPersonFlag(ApplyTypeEnums.PERSON.getType());
        //设置企业标志
        contractVehicleFinanceVo.setCompanyFlag(ApplyTypeEnums.COMPANY.getType());
        return contractVehicleRepository.selectContractVehicleFinanceVoByContNo(contractVehicleFinanceVo);
    }

    /**
     * @param contractVehicleVo
     * @Description: 修改合同融资车辆信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/11 16:36
     */
    @Override
    public void modifyContractVehicleVo(ContractVehicleVo contractVehicleVo) {
        contractVehicleRepository.updateByPrimaryKeySelectiveData(contractVehicleVo.getEntity());

    }


}
