package cn.com.leadu.fms.product.service.impl;

import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.product.repository.ProdFileRepository;
import cn.com.leadu.fms.pojo.product.entity.ProdFile;
import cn.com.leadu.fms.pojo.product.entity.ProdIntrst;
import cn.com.leadu.fms.pojo.product.entity.ProdVehicle;
import cn.com.leadu.fms.pojo.product.vo.prodfile.ProdFileVo;
import cn.com.leadu.fms.product.service.ProdFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.ArrayList;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ProdFileService
 * @Description: 产品附件管理业务实现层
 * @date 2018-04-05
 */
@Service
public class ProdFileServiceImpl implements ProdFileService {

    /**
     * @Fields  : 产品附件管理repository
     */
    @Autowired
    private ProdFileRepository prodFileRepository;

    /**
     * @Title:
     * @Description: 分页查询产品附件管理
     * @param prodFileVo
     * @return PageInfoExtend<ProdFile>
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:54:11
     */
    public PageInfoExtend<ProdFile> findProdFilesByPage(ProdFileVo prodFileVo){
        Example example = SqlUtil.newExample(ProdFile.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<ProdFile> pageInfo = prodFileRepository.selectListByExamplePage(example,prodFileVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description:  根据prodFileId获取产品附件管理
     * @param prodFileId
     * @return ProdFile
     * @throws
     * @author liujinge
     * @date 2018-4-5 21:54:11
     */
    public ProdFile findProdFileByProdFileId(String prodFileId){
        return prodFileRepository.selectByPrimaryKey(prodFileId);
    }
    /**
     * @Title:
     * @Description:  根据prodVehicleId获取产品方案车型权限
     * @param product
     * @return ProdVehicle
     * @throws
    @author liujinge
     * @date 2018-4-5 21:35:36
     */
    @Override
    public List<ProdFile> findProdFilesByProduct(String product){
        Example example = SqlUtil.newExample(ProdVehicle.class);
        example.createCriteria().andEqualTo("product",product);
        example.setOrderByClause("file_type asc");
        List<ProdFile> prodFileList = prodFileRepository.selectListByExample(example);
        if(ArrayUtils.isNullOrLengthZero(prodFileList)){
            prodFileList = new ArrayList<>();
        }
        return prodFileList;
    }
    @Override
    public void deleteProdFilesByProducts(List<String> products){
        Example example = SqlUtil.newExample(ProdIntrst.class);
        example.createCriteria().andIn("product",products);
        prodFileRepository.deleteExampleData(example, new ProdFile());
    }

    /**
     * @Title:
     * @Description:  根据产品方案获取附件类型
     * @param product
     * @return
     * @throws
     * @author wangxue
     * @date 2018-4-20 11:10:00
     */
    @Override
    public List<ProdFileVo> findProdFileVosByProduct(String product) {
        return prodFileRepository.selectProdFileVosByProduct(product);
    }
}
