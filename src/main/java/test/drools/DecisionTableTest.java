package test.drools;

import org.junit.Test;
import org.kie.api.runtime.KieSession;

import test.drools.model.Message;

/**
 * This is a sample class to launch a rule.
 */
public class DecisionTableTest extends DroolsBaseTest {

	@Test
	public void test() {
		KieSession kSession = kieContainer.newKieSession("ksession-dtables");
		Message message = new Message();
		message.setMessage("Hello World");
		message.setStatus(Message.HELLO);
		kSession.insert(message);
		kSession.fireAllRules();
	}

}
