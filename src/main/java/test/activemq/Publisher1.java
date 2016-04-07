package test.activemq;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.Session;
import javax.jms.TextMessage;

import org.apache.activemq.command.ActiveMQQueue;
import org.apache.activemq.command.ActiveMQTopic;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.jms.core.MessageCreator;
/**
 * 
 * @author Administrator
 * 后台控制台地址http://localhost:8161/
 *
 */
public class Publisher1 {
	
	private JmsTemplate jmsTemplate ;
	private ActiveMQQueue destination ;
	private ActiveMQTopic topicDestination ;
	public void sendQueueTextMessage(){
		jmsTemplate.send((javax.jms.Destination) destination, new MessageCreator(){     
            public Message createMessage(Session session) throws JMSException {    
            	TextMessage message =  session.createTextMessage("hello 3332");
//            	message.setJMSDeliveryMode(DeliveryMode.NON_PERSISTENT);//为啥无效呢
                return  message ;    
            }     
                 
        }); 
	}
	
	public void sendTopicMessage(){
		jmsTemplate.send( topicDestination, new MessageCreator(){     
            public Message createMessage(Session session) throws JMSException {    
            	TextMessage message =  session.createTextMessage("hello topic2211");
                return  message ;    
            }     
            
      });    
	}
	
	Publisher1(){
		ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext-defaultJMS.xml") ;
		this.jmsTemplate = (JmsTemplate) applicationContext.getBean("jmsTemplate") ;
		this.destination = (ActiveMQQueue)applicationContext.getBean("queueDestination") ;
		this.topicDestination = (ActiveMQTopic) applicationContext.getBean("topicDestination") ;
		applicationContext.close();
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

	public static void main(String[] args) {
		Publisher1 publisher1 = new Publisher1() ;
//		publisher1.sendQueueTextMessage();
		publisher1.sendTopicMessage();
	}
}
