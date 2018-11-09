package cn.com.leadu.fms.postbiz.service.impl;/**
 * Created by ningyangyang on 2018/9/10.
 */

import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.data.prebiz.repository.*;
import cn.com.leadu.fms.pojo.prebiz.entity.*;
import cn.com.leadu.fms.pojo.prebiz.vo.applyinput.ApplyInputVo;
import cn.com.leadu.fms.postbiz.service.ChangeInfoOperateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @Title: fms
 * @Description:  承租人变更信息操作
 * @author: ningyangyang
 * @date 2018/9/10 16:53
 */
@Service
public class ChangeInfoOperateServiceImpl implements ChangeInfoOperateService{
    /**
     * @Fields  : 个人基本信息repository
     */
    @Autowired
    private CstmPersonRepository cstmPersonRepository;
    /**
     * @Fields  : 个人配偶信息repository
     */
    @Autowired
    private CstmPersMateRepository  cstmPersMateRepository;
    /**
     * @Fields  : 个人职业信息repository
     */
    @Autowired
    private CstmPersJobRepository cstmPersJobRepository;
    /**
     * @Fields  : 个人地址信息repository
     */
    @Autowired
    private CstmPersAddrRepository  cstmPersAddrRepository;
    /**
     * @Fields  : 企业基本信息repository
     */
    @Autowired
    private CstmCompanyRepository cstmCompanyRepository;
    /**
     * @Fields  : 股东基本信息repository
     */
    @Autowired
    private StockAssetsRepository stockAssetsRepository;
    /**
     * @Title:
     * @Description: 保存个人的基本信息
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public void saveCstmPerson(ApplyInputVo applyInputVo, String taskNo) {
        CstmPerson cstmPerson = null;
        if(applyInputVo.getCstmPerson()!=null){
            cstmPerson = applyInputVo.getCstmPerson();//个人基本信息
        }else{
            cstmPerson = new CstmPerson();
        }
        cstmPerson.setApplyNo(taskNo);
        cstmPersonRepository.insertData(cstmPerson);
    }

    /**
     * @Title:
     * @Description: 保存个人的配偶信息
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public void saveCstmPersMate(ApplyInputVo applyInputVo, String taskNo) {
        CstmPersMate cstmPersMate = null;
        if(applyInputVo.getCstmPersMate() != null){
           cstmPersMate = applyInputVo.getCstmPersMate();//个人配偶信息
        }else{
            cstmPersMate= new CstmPersMate();
        }
        cstmPersMate.setApplyNo(taskNo);
        cstmPersMateRepository.insertData(cstmPersMate);
    }

    /**
     * @Title:
     * @Description: 保存个人的职业信息
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public void saveCstmPersJob(ApplyInputVo applyInputVo, String taskNo) {
        CstmPersJob cstmPersJob = null;
        if(applyInputVo.getCstmPersJob() != null){
             cstmPersJob = applyInputVo.getCstmPersJob();//个人职业信息
        }else{
            cstmPersJob = new CstmPersJob();
        }
        cstmPersJob.setApplyNo(taskNo);
        cstmPersJobRepository.insertData(cstmPersJob);
    }

    /**
     * @Title:
     * @Description: 保存个人的地址信息
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public void saveCstmPersAddr(ApplyInputVo applyInputVo, String taskNo) {
        CstmPersAddr cstmPersAddr = null;
        if(applyInputVo.getCstmPersAddr() != null){
            cstmPersAddr  = applyInputVo.getCstmPersAddr();//个人地址信息
        }else{
            cstmPersAddr = new CstmPersAddr();
        }
        cstmPersAddr.setApplyNo(taskNo);
        cstmPersAddrRepository.insertData(cstmPersAddr);
    }

    /**
     * @Title:
     * @Description: 保存企业的基本信息
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public void saveCstmCompany(ApplyInputVo applyInputVo, String taskNo) {
        CstmCompany cstmCompany = null;
        if(applyInputVo.getCstmCompany() != null){
            cstmCompany = applyInputVo.getCstmCompany();
        }else{
            cstmCompany = new  CstmCompany();
        }
        cstmCompany.setApplyNo(taskNo);
        cstmCompanyRepository.insertData(cstmCompany);
    }
    /**
     * @Title:
     * @Description: 保存企业的股东信息
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 15:14:54
     */
    @Override
    public void saveStockAssetsList(ApplyInputVo applyInputVo, String taskNo) {
        if(ArrayUtils.isNotNullAndLengthNotZero(applyInputVo.getStockAssetsList())){
            for(StockAssets stockAssets:applyInputVo.getStockAssetsList()){
                stockAssets.setApplyNo(taskNo);
                stockAssets.setStockAssetsId(null);
            }
            stockAssetsRepository.insertDataList(applyInputVo.getStockAssetsList());
        }
    }

    /**
     * @Title:
     * @Description:  根据订单编号更新担保人信息
     * @param taskNo
     * @param guaranteePersList
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 14:22:35
     */
    @Override
    public void updateGuaranteePersByTaskNo(List<GuaranteePers> guaranteePersList, String taskNo) {

    }
    /**
     * @Title:
     * @Description:  根据订单编号更新担保公司信息
     * @param taskNo
     * @param guaranteeCompList
     * @throws
     * @author ningyangyang
     * @date 2018-9-10 14:22:35
     */
    @Override
    public void updateGuaranteeCompsByApplyNo(List<GuaranteeComp> guaranteeCompList, String taskNo) {

    }


}
