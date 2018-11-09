package cn.com.leadu.fms.business.common.util;

import cn.com.leadu.fms.common.annotation.ChildTreeId;
import cn.com.leadu.fms.common.annotation.ParentTreeId;
import cn.com.leadu.fms.common.annotation.TreeText;
import cn.com.leadu.fms.common.util.AnnotationUtils;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.vo.BootstrapTreeViewNodeVo;
import com.alibaba.fastjson.JSON;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author qiaomengnan
 * @ClassName: CommonTreeDataUtils
 * @Description: 树形共通
 * @date 2018/3/29
 */
@Slf4j
@Data
@Component
public class CommonTreeDataUtils {

    /**
     * @Title:
     * @Description:   根据id查找所有子节点
     * @param datas
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/29 02:20:34
     */
    public static <T> List<T> getChildResults(List<T> datas,Object id){
        List<T> results = new ArrayList<>();
        if(StringUtils.isTrimBlank(id)){
            return results;
        }
        try {
            if (ArrayUtils.isNotNullAndLengthNotZero(datas)) {
                Field fieldC = AnnotationUtils.findField(ChildTreeId.class, datas.get(0).getClass());
                Field fieldP = AnnotationUtils.findField(ParentTreeId.class, datas.get(0).getClass());
                findChild(results,datas,id,fieldC,fieldP);
                return results;
            }
        }catch (Exception ex){
            ex.printStackTrace();
            log.error(ex.getMessage());
            return null;
        }
        return results;
    }

    /**
     * @Title:
     * @Description: 递归查找子节点
     * @param results
     * @param datas
     * @param id
     * @param fieldC
     * @param fieldP
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/29 02:19:42
     */
    private static void findChild(List results,List datas,Object id,Field fieldC,Field fieldP) throws IllegalAccessException {
        for(Object object : datas){
            if (id.equals(fieldP.get(object))) {
                results.add(object);
                //递归查找
                findChild(results,datas,fieldC.get(object),fieldC,fieldP);
            }
        }
    }

    /**
     * @Title:
     * @Description:   根据id查找所有父节点
     * @param datas
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/29 02:20:34
     */
    public static <T> List<T> getParentResults(List<T> datas,Object id){
        List<T> results = new ArrayList<>();
        if(StringUtils.isTrimBlank(id)){
            return results;
        }
        try {
            if (ArrayUtils.isNotNullAndLengthNotZero(datas)) {
                Field fieldC = AnnotationUtils.findField(ChildTreeId.class, datas.get(0).getClass());
                Field fieldP = AnnotationUtils.findField(ParentTreeId.class, datas.get(0).getClass());
                Map<Object, T> mapDatas = new HashMap<Object, T>();
                for(int i=0; i<datas.size(); i++){
                    mapDatas.put(fieldC.get(datas.get(i)), datas.get(i));
                }
                findParent(results,mapDatas,id,fieldC,fieldP);
                return results;
            }
        }catch (Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
        return results;
    }

    /**
     * @Title:
     * @Description:   根据datas查找所有父节点
     * @param allDatas
     * @param datas
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/29 02:20:34
     */
    public static <T> List<T> getParentsResults(List<T> allDatas,List<T> datas){
        List<T> results = new ArrayList();
        if(StringUtils.isTrimBlank(datas)){
            return results;
        }
        try {
            if (ArrayUtils.isNotNullAndLengthNotZero(allDatas)) {
                Field fieldC = AnnotationUtils.findField(ChildTreeId.class, allDatas.get(0).getClass());
                Field fieldP = AnnotationUtils.findField(ParentTreeId.class, allDatas.get(0).getClass());
                Map<Object, T> mapDatas = new HashMap<Object, T>();
                for(int i=0; i<allDatas.size(); i++){
                    mapDatas.put(fieldC.get(allDatas.get(i)), allDatas.get(i));
                }

                for(int i=0; i<datas.size(); i++){
                    List<T> result = new ArrayList<>();
                    findParent(result,mapDatas,fieldC.get(datas.get(i)),fieldC,fieldP);
                    if(StringUtils.isTrimBlank(result)){
                        continue;
                    }
                    for(int j=0; j<result.size(); j++){
                        if(!results.contains(result.get(j))){
                            results.add(result.get(j));
                        }
                    }
                }
                return results;
            }
        }catch (Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
        return results;
    }
    /**
     * @Title:
     * @Description: 递归查找父节点
     * @param results
     * @param mapDatas
     * @param id
     * @param fieldC
     * @param fieldP
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/29 02:19:42
     */
    private static void findParent(List results,Map mapDatas,Object id,Field fieldC, Field fieldP) throws IllegalAccessException {
        if(mapDatas.containsKey(id)){
            results.add(mapDatas.get(id));
            findParent(results,mapDatas,fieldP.get(mapDatas.get(id)),fieldC,fieldP);
        }
    }

    /**
     * 返回树结构并勾选已有菜单
     * @param datas
     * @param data
     * @param <T>
     * @return
     */
    public static <T> List<BootstrapTreeViewNodeVo> getTrees(List<T> datas,List<T> data){
        List<BootstrapTreeViewNodeVo> results = new ArrayList<BootstrapTreeViewNodeVo>();

        try {
            if (ArrayUtils.isNotNullAndLengthNotZero(datas) && ArrayUtils.isNotNullAndLengthNotZero(data)) {
                Field fieldC = AnnotationUtils.findField(ChildTreeId.class, datas.get(0).getClass());
                Field fieldP = AnnotationUtils.findField(ParentTreeId.class, datas.get(0).getClass());
                Field fieldText = AnnotationUtils.findField(TreeText.class, datas.get(0).getClass());
                for(int i=0; i < datas.size(); i++){
                        //树形结构的根节点
                        if(isRoot(fieldP.get(datas.get(i)), datas, fieldC)){
                            BootstrapTreeViewNodeVo node = new BootstrapTreeViewNodeVo();
                            node.setId((String) fieldC.get(datas.get(i)));
                            node.setText((String) fieldText.get(datas.get(i)));
                            if(data.contains(datas.get(i))){
                                node.getState().put("checked",true);
                            }

//                            for(int j = 0;j<data.size();j++){
//                                if(node.getId().equals((String) fieldC.get(data.get(j)))){
//                                    node.getState().put("checked",true);
//                                }
//                            }
                            getChildNodes(node, datas, data,fieldC, fieldP, fieldText);
                            results.add(node);
                        }

                }
                return results;
            }
        }catch (Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
        return results;
    }

    /**
     * @Title:
     * @Description:   返回所有树状List
     * @param datas
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/29 02:20:34
     */
    public static <T> List<BootstrapTreeViewNodeVo> getTrees(List<T> datas){
        List<BootstrapTreeViewNodeVo> results = new ArrayList<BootstrapTreeViewNodeVo>();
        try {
            if (ArrayUtils.isNotNullAndLengthNotZero(datas)) {
                Field fieldC = AnnotationUtils.findField(ChildTreeId.class, datas.get(0).getClass());
                Field fieldP = AnnotationUtils.findField(ParentTreeId.class, datas.get(0).getClass());
                Field fieldText = AnnotationUtils.findField(TreeText.class, datas.get(0).getClass());
                for(int i=0; i < datas.size(); i++){
                    //树形结构的根节点
                    if(isRoot(fieldP.get(datas.get(i)), datas, fieldC)){
                        BootstrapTreeViewNodeVo node = new BootstrapTreeViewNodeVo();
                        node.setId((String) fieldC.get(datas.get(i)));
                        node.setText((String) fieldText.get(datas.get(i)));
                        getChildNodes(node, datas, fieldC, fieldP, fieldText);
                        results.add(node);
                    }
                }
                return results;
            }
        }catch (Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
        return results;
    }

    /**
     * @Title:
     * @Description:   返回指定跟节点的树状List
     * @param datas
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/29 02:20:34
     */
    public static <T> BootstrapTreeViewNodeVo getTrees(List<T> datas, String rootNode){
        BootstrapTreeViewNodeVo rootNodeVo = new BootstrapTreeViewNodeVo();
        try {
            if (ArrayUtils.isNotNullAndLengthNotZero(datas)) {
                Field fieldC = AnnotationUtils.findField(ChildTreeId.class, datas.get(0).getClass());
                Field fieldP = AnnotationUtils.findField(ParentTreeId.class, datas.get(0).getClass());
                Field fieldText = AnnotationUtils.findField(TreeText.class, datas.get(0).getClass());
                for(int i=0; i < datas.size(); i++){
                    //树形结构的根节点
                    if(rootNode.equals((String) fieldC.get(datas.get(i)))){
                        rootNodeVo.setId((String) fieldC.get(datas.get(i)));
                        rootNodeVo.setText((String) fieldText.get(datas.get(i)));
                        setNodeAttributes(rootNodeVo, datas.get(i));
                        getChildNodes(rootNodeVo, datas, fieldC, fieldP, fieldText);
                        // 只可能有一个根节点
                        return rootNodeVo;
                    }
                }
            }
        }catch (Exception ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
            return null;
        }
        return rootNodeVo;
    }

    /**
     * @Title:  
     * @Description: 获取所有最后的子节点
     * @param:  rootNodeVo
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/7/13 0013 13:30
     */
    public static List<BootstrapTreeViewNodeVo> getLastNodes(BootstrapTreeViewNodeVo rootNodeVo){
        List<BootstrapTreeViewNodeVo> lastNodes = new ArrayList<>();
        if(rootNodeVo != null){
            getLastNodes(rootNodeVo.getNodes(),lastNodes,null,true);
        }
        return lastNodes;
    }

    /**
     * @Title:
     * @Description: 获取所有最后的子节点
     * @param:  nodes
     * @param:  lastNodes
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/13 0013 13:30
     */
    public static void getLastNodes(List<BootstrapTreeViewNodeVo> nodes,List<BootstrapTreeViewNodeVo> lastNodes,Map<String,String> parentNodes,boolean first){
        if(ArrayUtils.isNotNullAndLengthNotZero(nodes)){
            for(BootstrapTreeViewNodeVo nodeVo : nodes){
                if(first)
                    parentNodes = new HashMap<>();
                parentNodes.put(nodeVo.getParentId(),nodeVo.getParentText());
                if(nodeVo.getLastNode()) {
                    nodeVo.setParentNodes( new HashMap<>(parentNodes));
                    lastNodes.add(nodeVo);
                } else {
                    getLastNodes(nodeVo.getNodes(), lastNodes,parentNodes,false);
                }
            }
        }
    }

    private static <T> void setNodeAttributes(BootstrapTreeViewNodeVo node, T data) {
        if(data != null)
            node.setAttributes(JSON.parseObject(JSON.toJSONString(data)));
    }

    /**
     * @Title:
     * @Description: 递归返回树形结构
     * @param results
     * @param mapDatas
     * @param id
     * @param fieldC
     * @param fieldP
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/29 02:19:42
     */
    private static void findNodes(List results,Map mapDatas,Object id,Field fieldC, Field fieldP) throws IllegalAccessException {
        if(mapDatas.containsKey(id)){
            results.add(mapDatas.get(id));
            findParent(results,mapDatas,fieldP.get(mapDatas.get(id)),fieldC,fieldP);
        }
    }

    /**
     * @Title:
     * @Description: 递归返回树形结构
     * @param parentId
     * @param datas
     * @param fieldC
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/29 02:19:42
     */
    private static boolean isRoot(Object parentId ,List datas, Field fieldC) throws IllegalAccessException {
        if(StringUtils.isTrimBlank(parentId)){
            return true;
        }
        for(int i=0; i<datas.size(); i++){
            if(parentId.equals(fieldC.get(datas.get(i)))){
                return false;
            }
        }
        return true;
    }
    /**
     * @Title:
     * @Description: 递归返回树形结构
     * @param node
     * @param datas
     * @param fieldC
     * @param fieldP
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/29 02:19:42
     */
    private static void getChildNodes(BootstrapTreeViewNodeVo node ,List datas, Field fieldC, Field fieldP, Field fieldText) throws IllegalAccessException {
        boolean lastNode = true;
        for(int i=0; i<datas.size(); i++){
            if(node.getId().equals(fieldP.get(datas.get(i)))){
                lastNode = false;
                BootstrapTreeViewNodeVo nodeC = new BootstrapTreeViewNodeVo();
                nodeC.setId((String) fieldC.get(datas.get(i)));
                nodeC.setText((String) fieldText.get(datas.get(i)));
                nodeC.setParentId(node.getId());
                nodeC.setParentText(node.getText());
                setNodeAttributes(nodeC, datas.get(i));
                getChildNodes(nodeC, datas, fieldC,fieldP,fieldText);
                if(node.getNodes() == null){
                    List<BootstrapTreeViewNodeVo> nodes = new ArrayList();
                    nodes.add(nodeC);
                    node.setNodes(nodes);
                }else{
                    node.getNodes().add(nodeC);
                }
            }
        }
        node.setLastNode(lastNode);
    }

    /**
     * 重载子节点
     * @param node
     * @param datas
     * @param data
     * @param fieldC
     * @param fieldP
     * @param fieldText
     * @throws IllegalAccessException
     */
    private static void getChildNodes(BootstrapTreeViewNodeVo node ,List datas,List data,Field fieldC, Field fieldP, Field fieldText) throws IllegalAccessException {
        Map<String,Boolean> nodeState = new HashMap<>();
        nodeState.put("checked",true);
        for(int i=0; i<datas.size(); i++){
            if(node.getId().equals(fieldP.get(datas.get(i)))){
                BootstrapTreeViewNodeVo nodeC = new BootstrapTreeViewNodeVo();
                nodeC.setId((String) fieldC.get(datas.get(i)));
                nodeC.setText((String) fieldText.get(datas.get(i)));
                if(data.contains(datas.get(i))){
                    nodeC.getState().put("checked",true);
                }
                getChildNodes(nodeC, datas,data,fieldC,fieldP,fieldText);
                if(node.getNodes() == null){
                    List<BootstrapTreeViewNodeVo> nodes = new ArrayList();
                    nodes.add(nodeC);
                    node.setNodes(nodes);
                }else{
                    node.getNodes().add(nodeC);
                }
            }
        }
    }

}
