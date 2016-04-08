package test.drools.api;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;
import java.util.ArrayList;
import java.util.List;

import org.drools.compiler.compiler.DroolsParserException;
import org.drools.compiler.compiler.PackageBuilder;
import org.drools.core.RuleBase;
import org.drools.core.StatefulSession;
import org.drools.core.spi.Activation;

import test.drools.model.PointDomain;

public class PointRuleEngineImpl implements PointRuleEngine{
	private RuleBase ruleBase;  
	  
    /* (non-Javadoc) 
     * @see com.drools.demo.point.PointRuleEngine#initEngine() 
     */  
    public void initEngine() {  
        // 设置时间格式  
        System.setProperty("drools.dateformat", "yyyy-MM-dd HH:mm:ss");  
        ruleBase = RuleBaseFacatory.getRuleBase();  
        try {  
            PackageBuilder backageBuilder = getPackageBuilderFromDrlFile();  
            ruleBase.addPackages(backageBuilder.getPackages());  
        } catch (DroolsParserException e) {  
            e.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } catch (Exception e) {  
            e.printStackTrace();  
        }  
    }  
      
    /* (non-Javadoc) 
     * @see com.drools.demo.point.PointRuleEngine#refreshEnginRule() 
     */  
    public void refreshEnginRule() {  
        ruleBase = RuleBaseFacatory.getRuleBase();  
        org.drools.core.rule.Package[] packages = ruleBase.getPackages();  
        for(org.drools.core.rule.Package pg : packages) {  
            ruleBase.removePackage(pg.getName());  
        }  
          
        initEngine();  
    }  
  
    /* (non-Javadoc) 
     * @see com.drools.demo.point.PointRuleEngine#executeRuleEngine(com.drools.demo.point.PointDomain) 
     */  
    public void executeRuleEngine(final PointDomain pointDomain) {  
        if(null == ruleBase.getPackages() || 0 == ruleBase.getPackages().length) {  
            return;  
        }  
          
        StatefulSession statefulSession = ruleBase.newStatefulSession();  
        statefulSession.insert(pointDomain);  
          
        // fire  
        statefulSession.fireAllRules(new org.drools.core.spi.AgendaFilter() {  
            public boolean accept(Activation activation) {  
                return !activation.getRule().getName().contains("_test");  
            }  
        });  
          
        statefulSession.dispose();  
    }  
  
    /** 
     * 从Drl规则文件中读取规则 
     * @return 
     * @throws Exception 
     */  
    private PackageBuilder getPackageBuilderFromDrlFile() throws Exception {  
        // 获取测试脚本文件  
        List<String> drlFilePath = getTestDrlFile();  
        // 装载测试脚本文件  
        List<Reader> readers = readRuleFromDrlFile(drlFilePath);  
  
        PackageBuilder backageBuilder = new PackageBuilder();  
        for (Reader r : readers) {  
            backageBuilder.addPackageFromDrl(r);  
        }  
          
        // 检查脚本是否有问题  
        if(backageBuilder.hasErrors()) {  
            throw new Exception(backageBuilder.getErrors().toString());  
        }  
          
        return backageBuilder;  
    }  
  
    /** 
     * @param drlFilePath 脚本文件路径 
     * @return 
     * @throws FileNotFoundException 
     */  
    private List<Reader> readRuleFromDrlFile(List<String> drlFilePath) throws FileNotFoundException {  
        if (null == drlFilePath || 0 == drlFilePath.size()) {  
            return null;  
        }  
  
        List<Reader> readers = new ArrayList<Reader>();  
  
        for (String ruleFilePath : drlFilePath) {  
            readers.add(new FileReader(new File(ruleFilePath)));  
        }  
  
        return readers;  
    }  
  
    /** 
     * 获取测试规则文件 
     *  
     * @return 
     */  
    private List<String> getTestDrlFile() {  
        List<String> drlFilePath = new ArrayList<String>();  
        drlFilePath  
                .add("F:/study/git/mytest/src/main/resource/rules/addPoints.drl");  
        drlFilePath  
                .add("F:/study/git/mytest/src/main/resource/rules/subPoint.drl");  
  
        return drlFilePath;  
    }  

}
