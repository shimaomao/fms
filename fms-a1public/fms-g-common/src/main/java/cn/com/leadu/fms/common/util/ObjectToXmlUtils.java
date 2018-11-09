package cn.com.leadu.fms.common.util;


import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.DocumentHelper;
import org.dom4j.io.OutputFormat;
import org.dom4j.io.XMLWriter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.StringWriter;

/**
 * @description: 用于将对象转化成xml格式
 * @author:QianHuaSheng
 * @since:2017/12/15
 */
public class ObjectToXmlUtils {
    private static final Logger LOGGER = LoggerFactory.getLogger(ObjectToXmlUtils.class);
    /**
     * @Description:用于将对象转化成xml格式
     * @Author:QianHuaSheng
     * @Param:[value]
     * @Date: 2017/11/14 15:52
     * @Return:java.lang.String
     */
    public static String objectToXml(Object value) {
        String str = null;
        JAXBContext context = null;
        StringWriter writer = null;
        try {
            context = JAXBContext.newInstance(value.getClass());
            Marshaller mar = context.createMarshaller();
            writer = new StringWriter();
            mar.marshal(value, writer);
            str = writer.toString().replace("getProductRequest", "GetProductRequest");
        } catch (JAXBException e) {
            e.printStackTrace();
        } finally {
            if (context != null)
                context = null;
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
                writer = null;
            }
        }
        return str;
    }

    /**
     * 文件写入公共方法
     * @param document 写入的字符串
     * @param dirs 写入路径
     * @param outFile 写入名称
     */
    public static void writeDocument(String document,String dirs,String outFile) {
        try {
            String riqidir = outFile.substring(0, 8);
            Document doc = null;
            try {
                doc = DocumentHelper.parseText(document);
            } catch (DocumentException e) {
                LOGGER.error(e.getMessage(), e);
            }
            new File(dirs).mkdirs();
            FileOutputStream fileWriter = new FileOutputStream(dirs + outFile); //
            // 设置文件编码
            OutputFormat xmlFormat = OutputFormat.createPrettyPrint(); // 格式化输出
            xmlFormat.setEncoding("GB2312");
            // 创建写文件方法
            XMLWriter xmlWriter = new XMLWriter(fileWriter, xmlFormat);
            // 写入文件
            xmlWriter.write(doc);
            // 关闭
            xmlWriter.close();
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}
