package test.drools.api;

import org.kie.api.cdi.KSession;
import org.kie.api.runtime.StatelessKieSession;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Service;

import test.drools.model.PointDomain;

@Service
public class PointKieTest {
    @KSession("ksession-rules")
    private StatelessKieSession pointKsession;

	public StatelessKieSession getPointKsession() {
		return pointKsession;
	}

	public void setPointKsession(StatelessKieSession pointKsession) {
		this.pointKsession = pointKsession;
	}
	
	public void excute(PointDomain pointDomain){
		pointKsession.execute(pointDomain) ;
	}

	/**
	 * spring注解方式配置 执行时需要把<drools.version>设置为6.2.0.Final版本，否则执行失败
	 * 	为啥此段代码放到test.drools.DroolsPointTest中执行结果就不对了呢,甚是奇怪
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		ApplicationContext app = new ClassPathXmlApplicationContext("META-INF/kmodule_annotation.xml") ;
		PointKieTest test = app.getBean(PointKieTest.class) ;
		   final PointDomain pointDomain = new PointDomain();  
	        pointDomain.setUserName("hello kity");  
	        pointDomain.setBackMondy(100d);  
	        pointDomain.setBuyMoney(500d);  
	        pointDomain.setBackNums(1);  
	        pointDomain.setBuyNums(5);  
	        pointDomain.setBillThisMonth(5);  
	        pointDomain.setBirthDay(true);  
	        pointDomain.setPoint(0l);  
	        test.excute(pointDomain);
	        
            System.out.println("执行完毕BillThisMonth："+pointDomain.getBillThisMonth());  
            System.out.println("执行完毕BuyMoney："+pointDomain.getBuyMoney());  
            System.out.println("执行完毕BuyNums："+pointDomain.getBuyNums());  
              
            System.out.println("执行完毕规则引擎决定发送积分："+pointDomain.getPoint());  
	}
    
    
}
