import observer.*;
import service.OrderService;
import strategy.*;

public class Main {

    public static void main(String[] args) {

        System.out.println("E-COMMERCE\n");

        EmailNotifier email = new EmailNotifier();
        SMSNotifier sms = new SMSNotifier();
        LogNotifier log = new LogNotifier();

        // PEDIDO 1: Con Descuento BlackFriday 
        System.out.println("------- CREANDO PEDIDO ORD-001 -------\n");

        OrderService order1 = new OrderService();
        order1.subscribe(email);
        order1.subscribe(sms);
        order1.subscribe(log);

        order1.createOrder("ORD-001", "Electronics", "Computador", 2500000, 1);

        PricingStrategy strategy = new BlackFridayPricing();
        double total1 = order1.calculateTotal(strategy);

        System.out.println("Producto: Computador");
        System.out.println("Cantidad: 1");
        System.out.println("Descuento aplicado: " + strategy.getDescription());
        System.out.printf("Total calculado: $%.2f\n", total1);

        System.out.println("\n-----  TU PEDIDO HA SIDO CREADO -----\n");

        System.out.println("----- ACTUALIZACIONES DEL PEDIDO -----\n");
        changeStatusWithPause(order1, "PROCESSING");
        changeStatusWithPause(order1, "SHIPPED");
        changeStatusWithPause(order1, "DELIVERED");

        printFinalSummary(order1, total1);

        // PEDIDO 2: Precio Regular
        System.out.println("------- CREANDO PEDIDO ORD-002 -------\n");

        OrderService order2 = new OrderService();
        order2.subscribe(email);
        order2.subscribe(sms);
        order2.subscribe(log);

        order2.createOrder("ORD-002", "Food", "Pizza Personal", 20000, 2); // ID único

        PricingStrategy strategy2 = new RegularPricing(); 
        double total2 = order2.calculateTotal(strategy2);

        System.out.println("Producto: Pizza Personal");
        System.out.println("Cantidad: 2");
        System.out.println("Descuento aplicado: " + strategy2.getDescription());
        System.out.printf("Total calculado: $%.2f\n", total2);

        System.out.println("\n-----  TU PEDIDO HA SIDO CREADO -----\n");

        System.out.println("----- ACTUALIZACIONES DEL PEDIDO -----\n");
        changeStatusWithPause(order2, "PROCESSING");
        changeStatusWithPause(order2, "SHIPPED");
        changeStatusWithPause(order2, "DELIVERED");

        printFinalSummary(order2, total2);
    }

    private static void changeStatusWithPause(OrderService order, String newStatus) {
        order.changeStatus(newStatus);
       
    }

    private static void printFinalSummary(OrderService order, double total) {
        System.out.println("\n=================================================");
        System.out.println("                RESUMEN FINAL");
        System.out.println("=================================================\n");
        order.printSummary(total);
        System.out.println("\n================ FIN DEL SISTEMA ================\n");
    }

   
    }
