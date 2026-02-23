package observer;

public class EmailNotifier implements OrderObserver {

	public void update(String orderId, String oldStatus, String newStatus) {
		
		System.out.println("EMAIL: Hola! Tu pedido con Id [" + orderId + "] cambio de estado ["+ oldStatus + "] a ["
		+ newStatus + "]\n");
		
		
	}
}
