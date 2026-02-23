package observer;

public class SMSNotifier implements OrderObserver{
	

	public void update(String orderId, String oldStatus, String newStatus) {
		
		System.out.println("SMS: Hola, este sms es para informarte que tu pedido con Id[" + orderId + "] cambio de estar en estado ["+ oldStatus + "] a estado["
		+ newStatus + "]\n");
		}
	}