package cn.com.leadu.fms.common.vo;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.annotation.JSONField;
import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;

import java.io.Serializable;
import java.util.Map;

/**
 * @author yanggang
 * @ClassName: PdfCreateVo
 * @Description: PDF生成参数
 * @date: 2018/6/1 15:55
 */
@Data
public class PdfCreateVo<T> extends BaseVo<T>  {

    private static final long serialVersionUID = 1L;
    public PdfCreateVo() {
    }
    private String templatePath;//pdf模板路径
    private String filePath;//pdf下载路径
    private String fileName;//pdf名称
    private Integer page;//pdf页数
    private Map<String,String> map;//pdf键和值

    /**
     * 以下为附件信息
     */
    private Integer pageSize;// 每页数量
    private JSONArray fjDataArray;//pdf键和值
    private String fjTemplatePath;//pdf附件模板路径

    /**
     * 返回总页码
     *
     * @return
     */
    public Integer getFjPage() {
        int page = getTotalFjSize() / this.pageSize;
        if (getTotalFjSize() % pageSize == 0)
            return page;
        else
            return page + 1;
    }

    /**
     * 获取附件总个数
     *
     * @return
     */
    public int getTotalFjSize() {
        return fjDataArray.size();
    }
}