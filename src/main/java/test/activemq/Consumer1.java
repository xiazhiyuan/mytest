package test.activemq;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.jms.JMSException;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;

/**
 * @author Administrator
 *
 */
public class Consumer1 {
	private JmsTemplate jmsTemplate ;
	private ActiveMQQueue destination ;
	private ActiveMQTopic topicDestination ;

	public Consumer1() {
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-defaultJMS.xml") ;
		this.jmsTemplate = (JmsTemplate) applicationContext.getBean("jmsTemplate") ;
		this.destination = (ActiveMQQueue)applicationContext.getBean("queueDestination") ;
		this.topicDestination = (ActiveMQTopic) applicationContext.getBean("topicDestination") ;
		applicationContext.close();
	}
	
	public String  receiveQueueMessage() throws JMSException {
		TextMessage message = (TextMessage) jmsTemplate.receive(destination) ;
	     System.out.println("消息编码：" + message.getJMSMessageID());   
         System.out.println("目标对象：" + message.getJMSDestination());   
         System.out.println("消息模式：" + message.getJMSDeliveryMode()); // 消息的模式 分为持久模式和非持久模式, 默认是 非持久的模式（2）    
              
         long sendTime = message.getJMSTimestamp();   
         Date date = new Date(sendTime);   
         DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
         String temp = f.format(date);   
              
         System.out.println("消息发送时间：" + temp);      
         System.out.println("消息失效时间：" + message.getJMSExpiration()); // 这里是一个 整型值 0 表示 该消息永远不会过期    
         System.out.println("消息优先级：" + message.getJMSPriority()); // 优先级 0~9, 0 表示最低    
         System.out.println("关联编码：" + message.getJMSCorrelationID());      
              
         System.out.println("回复消息的地址：" + message.getJMSReplyTo());    // 回复消息的地址(Destination类型),由发送者设定    
         System.out.println("消息类型：" + message.getJMSType()); // jms 不使用该字段， 一般类型是由 用户自己定义    
         System.out.println("是否签收过：" + message.getJMSRedelivered()); // 如果是 真 ,表示客户端收到过该消息,但是并没有签收    
              
         // 消息属性 (properties)       
         System.out.println("用户编码：" + message.getStringProperty("JMSXUserID"));   
         System.out.println("应用程序编码：" + message.getStringProperty("JMSXApp1ID"));   
         System.out.println("已经尝试发送消息的次数：" + message.getStringProperty("JMSXDeliveryCount"));                 
              
         // 消息体(body) 中传递的内容       
         System.out.println("消息内容：" + message.getText()); 

		return message.getText() ;
	}
	
	public  String  receiveTopicMessage() throws JMSException{
		TextMessage message = (TextMessage) jmsTemplate.receive(topicDestination) ;
	     System.out.println("消息编码：" + message.getJMSMessageID());   
        System.out.println("目标对象：" + message.getJMSDestination());   
        System.out.println("消息模式：" + message.getJMSDeliveryMode()); // 消息的模式 分为持久模式和非持久模式, 默认是 非持久的模式（2）    
             
        long sendTime = message.getJMSTimestamp();   
        Date date = new Date(sendTime);   
        DateFormat f = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");   
        String temp = f.format(date);   
             
        System.out.println("消息发送时间：" + temp);      
        System.out.println("消息失效时间：" + message.getJMSExpiration()); // 这里是一个 整型值 0 表示 该消息永远不会过期    
        System.out.println("消息优先级：" + message.getJMSPriority()); // 优先级 0~9, 0 表示最低    
        System.out.println("关联编码：" + message.getJMSCorrelationID());      
             
        System.out.println("回复消息的地址：" + message.getJMSReplyTo());    // 回复消息的地址(Destination类型),由发送者设定    
        System.out.println("消息类型：" + message.getJMSType()); // jms 不使用该字段， 一般类型是由 用户自己定义    
        System.out.println("是否签收过：" + message.getJMSRedelivered()); // 如果是 真 ,表示客户端收到过该消息,但是并没有签收    
             
        // 消息属性 (properties)       
        System.out.println("用户编码：" + message.getStringProperty("JMSXUserID"));   
        System.out.println("应用程序编码：" + message.getStringProperty("JMSXApp1ID"));   
        System.out.println("已经尝试发送消息的次数：" + message.getStringProperty("JMSXDeliveryCount"));                 
             
        // 消息体(body) 中传递的内容       
        System.out.println("消息内容：" + message.getText()); 

		return message.getText() ;
	}
	
	public JmsTemplate getJmsTemplate() {
		return jmsTemplate;
	}

	public void setJmsTemplate(JmsTemplate jmsTemplate) {
		this.jmsTemplate = jmsTemplate;
	}

	public ActiveMQQueue getDestination() {
		return destination;
	}

	public void setDestination(ActiveMQQueue destination) {
		this.destination = destination;
	}

	public ActiveMQTopic getTopicDestination() {
		return topicDestination;
	}

	public void setTopicDestination(ActiveMQTopic topicDestination) {
		this.topicDestination = topicDestination;
	}

	public static void main(String[] args) throws JMSException {
		Consumer1 consumer1=  new Consumer1() ;
//		String message = consumer1.receiveQueueMessage() ;
		String message = consumer1.receiveTopicMessage() ;
		System.out.println(message);
	}
}
