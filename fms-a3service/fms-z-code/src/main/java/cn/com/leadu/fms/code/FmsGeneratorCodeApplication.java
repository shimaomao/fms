package cn.com.leadu.fms.code;

import cn.com.leadu.fms.code.generator.GeneratorFacade;
import cn.com.leadu.fms.code.generator.GeneratorProperties;

import java.io.*;
import java.net.URLDecoder;

/**
 * @author qiaomengnan
 * @ClassName: CmsGeneratorCodeApplication
 * @Description:
 * @date 2018/1/12
 */
public class FmsGeneratorCodeApplication {

    public static void main(String[] args) throws Exception {

        String PROJ_NAME = "fms";
        String PROJ_DIR = URLDecoder.decode(FmsGeneratorCodeApplication.class.getResource("/").toString(), "utf-8").replace("file:/", "").replace("/target/classes/", "/src/main/resources");
        GeneratorProperties.PROPERTIES_FILE_NAMES = new String[]{"generator-" + PROJ_NAME + ".properties", "generator-" + PROJ_NAME + ".xml"};
        GeneratorProperties.reload();
        GeneratorFacade g = new GeneratorFacade();
        g.initOutRoot(PROJ_DIR + File.separator + "target/" + PROJ_NAME);
        g.initTemplateRoot(PROJ_DIR + File.separator + "template/" + PROJ_NAME);
        try {
            g.generateByTable("sys_user_msg");
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

        //copyFiles(PROJ_DIR);

    }


    private static void copyFiles(String PROJ_DIR){

        String basePackage = GeneratorProperties.getProperty("basepackage").replace(".","/");
        String serverName = GeneratorProperties.getProperty("servername");
        String rootPath = PROJ_DIR + "/target/fms/src/main/java/" + basePackage;

        String servicePath = rootPath.substring(0,rootPath.indexOf("fms-a3service") + 13) + "/" + "fms-z-" + serverName;
        String pojoPath = rootPath.substring(0,rootPath.indexOf("fms-a3service") + 13) +  "/fms-y-pojo" ;
        String dataPath = rootPath.substring(0,rootPath.indexOf("fms-a3service") + 13) +  "/fms-y-data" ;
        String webClientPath = rootPath.substring(0,rootPath.indexOf("fms-a3service") + 13) + "/fms-x-webclient" ;

        String codePath = String.format("%s/target/fms/src/main/java/%s",PROJ_DIR,basePackage);

        //entity   ---> pojo
        String entityPath = String.format("%s/src/main/java/%s/pojo/%s/entity",pojoPath,basePackage,serverName);
        copy(String.format("%s/entity",codePath),entityPath);
        System.out.println(entityPath);

        //vo    ---> pojo
        String voPath = String.format("%s/src/main/java/%s/pojo/%s/vo",pojoPath,basePackage,serverName);
        copy(String.format("%s/vo",codePath),voPath);
        System.out.println(voPath);


        //dao   ---> data
        String daoPath = String.format("%s/src/main/java/%s/data/%s/dao",dataPath,basePackage,serverName);
        copy(String.format("%s/dao",codePath),daoPath);
        System.out.println(daoPath);

        //repository    ---> data
        String repositoryPath = String.format("%s/src/main/java/%s/data/%s/repository",dataPath,basePackage,serverName);
        copy(String.format("%s/repository",codePath),repositoryPath);
        System.out.println(repositoryPath);

        //xml       ---> data
        String xmlPath = String.format("%s/src/main/resources/mapper/%s",dataPath,serverName);
        copy(String.format("%s/xml",codePath),xmlPath);
        System.out.println(xmlPath);

        //validator     ---> server
        String validatorPath = String.format("%s/src/main/java/%s/%s/validator",servicePath,basePackage,serverName);
        copy(String.format("%s/validator",codePath),validatorPath);
        System.out.println(validatorPath);


        //service       ---> server
        String serviceServerPath = String.format("%s/src/main/java/%s/%s/service",servicePath,basePackage,serverName);
        copy(String.format("%s/service",codePath),serviceServerPath);
        System.out.println(serviceServerPath);


        //controller    ---> server
        String controllerPath = String.format("%s/src/main/java/%s/%s/controller",servicePath,basePackage,serverName);
        copy(String.format("%s/controller",codePath),controllerPath);
        System.out.println(controllerPath);


        //rpc           ---> webClient
        String rpcPath = String.format("%s/src/main/java/%s/%s/%s/rpc",webClientPath,basePackage,"webclient",serverName);
        copy(String.format("%s/rpc",codePath),rpcPath);
        System.out.println(rpcPath);


        //rpccontroller         ---> webClient
        String rpcControllerPath = String.format("%s/src/main/java/%s/%s/%s/controller",webClientPath,basePackage,"webclient",serverName);
        copy(String.format("%s/rpccontroller",codePath),rpcControllerPath);
        System.out.println(rpcControllerPath);

        //tpl           ---> webClient
        String tplPath = String.format("%s/src/main/resources/static/tpl/%s",webClientPath,serverName);
        copy(String.format("%s/tpl",codePath),tplPath);
        System.out.println(tplPath);

    }



//    public static void main(String[] args) {
//        copy("E:/test/aaaa","E:/test/bbbb");
//        System.out.println("文件拷贝完成!");
//    }

    private static void copy(String src, String des) {
        File file1=new File(src);
        File[] fs=file1.listFiles();
        File file2=new File(des);
        if(!file2.exists()){
            file2.mkdirs();
        }
        for (File f : fs) {
            if(f.isFile()){
                fileCopy(f.getPath(),des+"\\"+f.getName()); //调用文件拷贝的方法
            }else if(f.isDirectory()){
                copy(f.getPath(),des+"\\"+f.getName());
            }
        }

    }

    /**
     * 文件拷贝的方法
     */
    private static void fileCopy(String src, String des) {

        BufferedReader br=null;
        PrintStream ps=null;

        try {
            br=new BufferedReader(new InputStreamReader(new FileInputStream(src)));
            ps=new PrintStream(new FileOutputStream(des));
            String s=null;
            while((s=br.readLine())!=null){
                ps.println(s);
                ps.flush();
            }

        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }finally{

            try {
                if(br!=null)  br.close();
                if(ps!=null)  ps.close();
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }


    }


}
