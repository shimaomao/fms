package cn.com.leadu.fms.pojo.prebiz.vo.testexcel;

import lombok.Data;

import java.util.List;

/**
 * 模板参数载体类
 * Created by huzongcheng on 2018/9/27.
 */
@Data
public class TestData {
    private String name ;
    private String sex ;
    private String age ;
    private List<DataList> list;
}
