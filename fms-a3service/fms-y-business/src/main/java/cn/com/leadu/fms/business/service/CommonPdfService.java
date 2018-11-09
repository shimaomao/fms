package cn.com.leadu.fms.business.service;

import cn.com.leadu.fms.common.vo.PdfCreateVo;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: CommonPdfService
 * @Description: pdf模板service
 * @date 2018/6/13
 */
public interface CommonPdfService {

    /**
     * @Title:
     * @Description: 生成pdf模板,无数据字典内容
     * @param pdfVariables
     * @param tplTypeKey
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/13 06:19:48
     */
    String create(Map<String,String> pdfVariables, String tplTypeKey);

    /**
     * @Title:
     * @Description: 生成pdf模板,有数据字典内容
     * @param pdfVariables
     * @param tplTypeKey
     * @param codeValues
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/13 06:20:41
     */
    String create(Map<String,String> pdfVariables,String tplTypeKey,Map<String,String> codeValues);

    /**
     * @param pdfCreateVo
     * @return
     * @throws
     * @Title:
     * @Description: 根据参数生成pdf(含有多条但无法在pdf中给出确切条数与页数的数据，如打印gps月结出租人信息)
     * @author
     */
    String createWithFj(PdfCreateVo pdfCreateVo) throws Exception;

    /**
     * @Title:
     * @Description: 生成pdf模板,无数据字典内容(含有多条但无法在pdf中给出确切条数与页数的数据，如打印gps月结出租人信息)
     * @param pdfVariables
     * @param
     * @return
     * @throws
     * @author
     */
    String createWithFj(Map<String,String> pdfVariables,String tplTypeKey1,String tplTypeKey2,PdfCreateVo pdfCreateVo);

}
