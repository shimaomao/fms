package cn.com.leadu.fms.business.service.impl;

import cn.com.leadu.fms.business.rpc.system.SysTplTypesRpc;
import cn.com.leadu.fms.business.service.CommonConstantService;
import cn.com.leadu.fms.business.service.CommonPdfService;
import cn.com.leadu.fms.common.constant.enums.file.FileTypePathEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.vo.CommonCodeVo;
import cn.com.leadu.fms.common.vo.PdfCreateVo;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.itextpdf.text.Document;
import com.itextpdf.text.pdf.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.*;


/**
 * @author qiaomengnan
 * @ClassName: CommonPdfService
 * @Description: pdf模板service
 * @date 2018/6/13
 */
@Slf4j
@Service
public class CommonPdfServiceImpl implements CommonPdfService {

    @Autowired
    private CommonConstantService commonConstantService;

    @Autowired
    private SysTplTypesRpc sysTplTypeRpc;

    /**
     * @Title:
     * @Description:   根据参数生成pdf
     * @param map
     * @param PdfCreateVo
     * @return
     * @throws
     * @author yanggang
     * @date 2018/06/13 06:19:16
     */
    public String create(Map<String,String> map,PdfCreateVo PdfCreateVo) throws Exception {
        String fjmc = "";
        String uploadPath="";
        try {
            int page = PdfCreateVo.getPage();// 总共页数
            //读取文件模板的路径
            String templatePDF= CommonFileUtils.setRootPath(PdfCreateVo.getTemplatePath());
            //设置模板上传路径和文件名称
            uploadPath = CommonFileUtils.setRootPath(PdfCreateVo.getFilePath());
            fjmc = PdfCreateVo.getFileName();
            //判断文件夹是否存在，不存在创建一个
            File uploadFile = new File(uploadPath);
            if(!uploadFile.exists()) {
                uploadFile.mkdirs();
            }
            //写入流准备写入PDF,  uploadPath+fjmc (路径加文件名字形成全路径)
            FileOutputStream fos = new FileOutputStream(CommonFileUtils.joinFilePath(uploadPath,fjmc));//需要生成PDF
            //缓冲器
            ByteArrayOutputStream baos[] = new ByteArrayOutputStream[page];//用于存储每页生成PDF流
            /** 向PDF模板中插入数据 */
            for (int item = 0; item < page; item++) {
                baos[item] = new ByteArrayOutputStream();
                //读取模板
                PdfReader reader = new PdfReader(templatePDF);
                PdfStamper stamp = new PdfStamper(reader, baos[item]);
                AcroFields form = stamp.getAcroFields();
                //往模板的唯一键里塞值
                for(String key : map.keySet()){
                    form.setField(key,map.get(key)==null?"":map.get(key));
                }
                stamp.setFormFlattening(true); // 千万不漏了这句啊, 将值显示在模板上
                stamp.close();
                reader.close();
            }
            Document doc = new Document();
            PdfCopy pdfCopy = new PdfCopy(doc, fos);
            //打开文档
            doc.open();
            PdfImportedPage impPage = null;
            /**取出之前保存的每页内容*/
            for (int i = 0; i < page; i++) {
                impPage = pdfCopy.getImportedPage(new PdfReader(baos[i]
                        .toByteArray()), i+1);
                pdfCopy.addPage(impPage);
            }
            //关闭文档
            doc.close();//当文件拷贝  记得关闭doc
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw ex;
        }
        return CommonFileUtils.joinFilePath(PdfCreateVo.getFilePath(),fjmc);
    }

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
    public String create(Map<String,String> pdfVariables,String tplTypeKey){
        SysTplType sysTplType = null;
        //获取抵押模板
        try {
            sysTplType = ResponseEntityUtils.getRestResponseData(sysTplTypeRpc.findSysTplTypeByTplTypeKey(tplTypeKey));
        } catch (FmsRpcException e) {
            e.printStackTrace();
            throw new FmsServiceException("获取文件模板失败,生成合同文件失败");
        }
        //判断是否为空
        if(sysTplType == null)
            throw new FmsServiceException("获取文件模板失败,生成合同文件失败");
        PdfCreateVo pdfCreateVo=new PdfCreateVo();
        String filePath = CommonFileUtils.joinFilePath(CommonFileUtils.getFileRootPath(), FileTypePathEnums.DN_LOAD.getType(),DateUtils.dateToStr(new Date(),DateUtils.formatStr_yyyyMMd_NO),tplTypeKey);
        pdfCreateVo.setFilePath(filePath);
        pdfCreateVo.setFileName(UUIDUtils.getUUID() + ".pdf");
        pdfCreateVo.setPage(sysTplType.getTplPage());
        pdfCreateVo.setTemplatePath(sysTplType.getTplContent());
        try {
            return create(pdfVariables,pdfCreateVo);//PDF生成方法
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new FmsServiceException("pdf文件生成失败");
        }
    }

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
    public String create(Map<String,String> pdfVariables,String tplTypeKey,Map<String,String> codeValues){
        /**
         * codeValues   key_key -> codeValue
         * 第一个key是values中值字段
         * 第二个key在数据字典中的key
         * 第二个key如果不存在
         * 默认以第一个key去数据字典中查询
         * codeValue是结果是从数据字典中查询出来的值存放字段
         */

        if(codeValues != null && codeValues.size() > 0){
            for(String key : codeValues.keySet()){
                String codeValueKey = codeValues.get(key);
                String [] keys = key.split(StringUtils.LINE);
                if(ArrayUtils.isNotNullAndLengthNotZero(keys)){
                    if(keys.length < 1){
                        continue;
                    }
                    String codeType = null;
                    String codeValue = null;
                    if(keys.length > 1) {
                        codeType = keys[1];
                        codeValue = keys[0];
                    } else {
                        codeType = keys[0];
                        codeValue = keys[0];
                    }
                    String result = commonConstantService.findSysCodeValueName(codeType,pdfVariables.get(codeValue));
                    pdfVariables.put(codeValueKey,result);
                }
            }
        }
        return create(pdfVariables, tplTypeKey);
    }

//    public void printPdf(Map<String,String> values, String filePath, Integer page, HttpServletResponse response){
//        //输出pdf
//        String result = create(values,filePath,page);
//        try {
//            CommonFileUtils.writerFile(result,response);
//        } catch (IOException e) {
//            e.printStackTrace();
//            throw new FmsServiceException("打印合同文件失败");
//        }
//    }


//    public static void main(String[] args) {
//
//        Map<String,String> map=new HashMap<String, String>();
//        //pdf键和值
//        map.put("test1","WL20180602001");
//        map.put("test2","测试");
//        PdfCreateVo PdfCreateVo=new PdfCreateVo();
//        PdfCreateVo.setFilePath("c:/test1/");//pdf下载路径
//        PdfCreateVo.setFileName("test1.pdf");//pdf名称
//        PdfCreateVo.setPage(1);//pdf页数
//        PdfCreateVo.setTemplatePath("C:/test/wl_contract__hz_rzzlht_zytk.pdf");//pdf模板路径
//        try {
//            create(map,PdfCreateVo);//PDF生成方法
//        } catch (Exception e) {
//            // TODO Auto-generated catch block
//            e.printStackTrace();
//        }
//
//    }



    /**
     * @param pdfCreateVo
     * @return
     * @throws
     * @Title:
     * @Description: 根据参数生成pdf(含有多条但无法在pdf中给出确切条数与页数的数据，如打印gps月结出租人信息)
     * @author
     */
    public String createWithFj(PdfCreateVo pdfCreateVo) throws Exception {
        String pdfName = "";
        String uploadPath = "";
        try {
            // 获取显示值
            Map<String, String> map = pdfCreateVo.getMap();
            // 页数
            int page = pdfCreateVo.getPage();
            // 附件页数
            int fjPage = pdfCreateVo.getFjPage();
            // 获取附件列表值
            JSONArray fjArray = pdfCreateVo.getFjDataArray();
            //读取文件模板的路径
            String templatePDF = CommonFileUtils.setRootPath(pdfCreateVo.getTemplatePath());
            //设置模板上传路径和文件名称
            uploadPath = CommonFileUtils.setRootPath(pdfCreateVo.getFilePath());
            pdfName = pdfCreateVo.getFileName();
            //判断文件夹是否存在，不存在创建一个
            File uploadFile = new File(uploadPath);
            if (!uploadFile.exists()) {
                uploadFile.mkdirs();
            }
            //写入流准备写入PDF,  uploadPath+fjmc (路径加文件名字形成全路径)
            FileOutputStream fos = new FileOutputStream(uploadPath + pdfName);//需要生成PDF
            //缓冲器
            ByteArrayOutputStream baos[] = new ByteArrayOutputStream[page + fjPage];//用于存储每页生成PDF流
            /** 向PDF模板中插入数据 */
            for (int item = 0; item < page; item++) {
                baos[item] = new ByteArrayOutputStream();
                //读取模板
                PdfReader reader = new PdfReader(templatePDF);
                PdfStamper stamp = new PdfStamper(reader, baos[item]);
                AcroFields form = stamp.getAcroFields();
                //往模板的唯一键里设值
                for (String key : map.keySet()) {
                    form.setField(key, map.get(key) == null ? "" : map.get(key));
                }
                stamp.setFormFlattening(true); // 千万不漏了这句啊, 将值显示在模板上
                stamp.close();
                reader.close();
            }

            /** 向PDF附件模板中插入数据 */
            // 获取附件模板
            String fjTemplatePDF = CommonFileUtils.setRootPath(pdfCreateVo.getFjTemplatePath());
            // 定义附件页码
            int currentPage = 1;
            for (int item = page; item < fjPage + page; item++) {
                baos[item] = new ByteArrayOutputStream();
                //读取模板
                PdfReader reader = new PdfReader(fjTemplatePDF);
                PdfStamper stamp = new PdfStamper(reader, baos[item]);
                AcroFields form = stamp.getAcroFields();
                // 设置当前页码
                form.setField("currentPage", String.valueOf(currentPage));
                // 总页码
                form.setField("totalPage", String.valueOf(fjPage));
                //往模板的唯一键里塞值
                int index = 1;
                List<Object> removeObj = new ArrayList<>();
                for (Object object : fjArray) {
                    if (index > pdfCreateVo.getPageSize()) {
                        break;
                    }
                    removeObj.add(object);
                    JSONObject jsonObject = (JSONObject ) object;
                    // 遍历json对象存储的键值对，设置到pdf
                    Set<Map.Entry<String, Object>> entrySet = jsonObject.entrySet();
                    Iterator<Map.Entry<String, Object>> iterator = entrySet.iterator();
                    while (iterator.hasNext()) {
                        Map.Entry<String, Object> stringMap = iterator.next();
                        form.setField(stringMap.getKey() + "_" + index, stringMap.getValue().toString());
                    }
                    index++;
                }
                fjArray.removeAll(removeObj);
                stamp.setFormFlattening(true); // 千万不漏了这句啊, 将值显示在模板上
                stamp.close();
                reader.close();
                currentPage++;
            }
            Document doc = new Document();
            PdfCopy pdfCopy = new PdfCopy(doc, fos);
            //打开文档
            doc.open();
            PdfImportedPage impPage = null;
            /**取出之前保存的每页内容*/
            for (int i = 0; i < page; i++) {
                impPage = pdfCopy.getImportedPage(new PdfReader(baos[i]
                        .toByteArray()), i + 1);
                pdfCopy.addPage(impPage);
            }
            /**取出之前保存的附件内容*/
            for (int i = 0; i < fjPage; i++) {
                impPage = pdfCopy.getImportedPage(new PdfReader(baos[page + i]
                        .toByteArray()), 1);
                pdfCopy.addPage(impPage);
            }
            //关闭文档
            doc.close();//当文件拷贝  记得关闭doc
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
            log.error("生产PDF附件ERROR: ", ex.getMessage());
            throw ex;
        }
        return uploadPath + pdfName;
    }

    /**
     * @Title:
     * @Description: 生成pdf模板,无数据字典内容(含有多条但无法在pdf中给出确切条数与页数的数据，如打印gps月结出租人信息)
     * @param pdfVariables
     * @param
     * @return
     * @throws
     * @author
     */
    public String createWithFj(Map<String,String> pdfVariables,String tplTypeKey1,String tplTypeKey2,PdfCreateVo pdfCreateVo){
        SysTplType sysTplType1 = null;
        SysTplType sysTplType2 = null;
        //获取模板
        try {
            sysTplType1 = ResponseEntityUtils.getRestResponseData(sysTplTypeRpc.findSysTplTypeByTplTypeKey(tplTypeKey1));
        } catch (FmsRpcException e) {
            e.printStackTrace();
            throw new FmsServiceException("获取文件模板失败,生成合同文件失败");
        }
        //判断是否为空
        if(sysTplType1 == null)
            throw new FmsServiceException("获取文件模板失败,生成合同文件失败");
        //获取附件模板
        try {
            sysTplType2 = ResponseEntityUtils.getRestResponseData(sysTplTypeRpc.findSysTplTypeByTplTypeKey(tplTypeKey2));
        } catch (FmsRpcException e) {
            e.printStackTrace();
            throw new FmsServiceException("获取文件模板失败,生成合同文件失败");
        }
        //判断附件模板是否为空
        if(sysTplType2 == null)
            throw new FmsServiceException("获取文件模板失败,生成合同文件失败");
        String filePath = CommonFileUtils.joinFilePath(CommonFileUtils.getFileRootPath(), FileTypePathEnums.DN_LOAD.getType(),DateUtils.dateToStr(new Date(),DateUtils.formatStr_yyyyMMd_NO),tplTypeKey1);
        pdfCreateVo.setFilePath(filePath);
        pdfCreateVo.setFileName(UUIDUtils.getUUID() + ".pdf");
        pdfCreateVo.setPage(sysTplType1.getTplPage());
        pdfCreateVo.setTemplatePath(sysTplType1.getTplContent());
        pdfCreateVo.setFjTemplatePath(sysTplType2.getTplContent());
        pdfCreateVo.setMap(pdfVariables);
        try {
            return createWithFj(pdfCreateVo);//PDF生成方法
        } catch (Exception ex) {
            ex.printStackTrace();
            log.error(ex.getMessage());
            throw new FmsServiceException("pdf文件生成失败");
        }
    }
}
