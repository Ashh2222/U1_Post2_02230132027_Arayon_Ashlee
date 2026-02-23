package observer;

import java.time.LocalDateTime;

public class LogNotifier implements OrderObserver {
	
	public void update(String orderId, String oldStatus, String newStatus) {
		
		System.out.println("LOG-["+ LocalDateTime.now()+ "], Nuevo cambio en tu pedido con Id ["+ orderId +
				"], Cambio su estado["+ oldStatus + "] a este nuevo estado ["+ newStatus + "]\n");
		}
	}
	
