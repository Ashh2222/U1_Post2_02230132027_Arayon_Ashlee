# Proyecto: Sistema de E-Commerce con Patrones de Diseño

## Diagrama UML

```
========================
        MODEL
========================

abstract class Product
--------------------------------
# name : String
# basePrice : double
# category : String
--------------------------------
+ Product(name : String,
          basePrice : double,
          category : String)
+ calculateShipping() : double
+ getDescription() : String
+ getName() : String
+ getBasePrice() : double
+ getCategory() : String


Electronics extends Product
--------------------------------
- warrantyMonths : int
--------------------------------
+ Electronics(name : String,
              basePrice : double,
              warrantyMonths : int)
+ calculateShipping() : double
+ getDescription() : String


Clothing extends Product
--------------------------------
- size : String
--------------------------------
+ Clothing(name : String,
           basePrice : double,
           size : String)
+ calculateShipping() : double
+ getDescription() : String


Food extends Product
--------------------------------
- foodType : String
--------------------------------
+ Food(name : String,
       basePrice : double,
       foodType : String)
+ calculateShipping() : double
+ getDescription() : String


========================
        FACTORY
========================

ProductFactory
--------------------------------
+ createProduct(type : String,
                name : String,
                price : double) : Product


========================
        STRATEGY
========================

interface PricingStrategy
--------------------------------
+ calculateFinalPrice(originalPrice : double) : double
+ getDescription() : String


RegularPricing implements PricingStrategy
--------------------------------
+ calculateFinalPrice(price : double) : double
+ getDescription() : String


MemberPricing implements PricingStrategy
--------------------------------
+ calculateFinalPrice(price : double) : double
+ getDescription() : String


BlackFridayPricing implements PricingStrategy
--------------------------------
+ calculateFinalPrice(price : double) : double
+ getDescription() : String


BulkPricing implements PricingStrategy
--------------------------------
- quantity : int
--------------------------------
+ BulkPricing(quantity : int)
+ calculateFinalPrice(price : double) : double
+ getDescription() : String


========================
        OBSERVER
========================

interface OrderObserver
--------------------------------
+ update(orderId : String,
         oldStatus : String,
         newStatus : String) : void


interface OrderSubject
--------------------------------
+ subscribe(observer : OrderObserver) : void
+ unsubscribe(observer : OrderObserver) : void
+ notifyObservers(orderId : String,
                  oldStatus : String,
                  newStatus : String) : void


EmailNotifier implements OrderObserver
--------------------------------
+ update(orderId : String,
         oldStatus : String,
         newStatus : String) : void


SMSNotifier implements OrderObserver
--------------------------------
+ update(orderId : String,
         oldStatus : String,
         newStatus : String) : void


LogNotifier implements OrderObserver
--------------------------------
+ update(orderId : String,
         oldStatus : String,
         newStatus : String) : void


========================
        SERVICE
========================

OrderService implements OrderSubject
--------------------------------
- observers : List<OrderObserver>
- orderId : String
- product : Product
- quantity : int
- status : String
--------------------------------
+ subscribe(observer : OrderObserver) : void
+ unsubscribe(observer : OrderObserver) : void
+ notifyObservers(orderId : String,
                  oldStatus : String,
                  newStatus : String) : void

+ createOrder(id : String,
              type : String,
              name : String,
              price : double,
              quantity : int) : void

+ calculateTotal(strategy : PricingStrategy) : double
+ changeStatus(newStatus : String) : void
+ printSummary(total : double) : void


========================
        MAIN
========================

Main
--------------------------------
+ main(args : String[]) : void
- changeStatusWithPause(order : OrderService,
                        newStatus : String) : void
- printFinalSummary(order : OrderService,
                    total : double) : void
```
## Justificacion de patrones

### 1️. Patrón Observer

Se implementa el patrón Observer para gestionar el sistema de notificaciones cuando un pedido cambia de estado, esto evita un posible acoplamiento directo entre la clase OrderService y los sistemas de notificación (Email, SMS, Log) cumpliendo asi el principio Open/Closed.


### 2️. Patrón Factory Method

Se utiliza Factory Method para centralizar la creación de productos (Electronics, Clothing, Food) y evitar que el código cliente dependa directamente de clases concretas. Este aplica el principio DIP.

### 3️.Patron Strategy

Se implementa Strategy para manejar diferentes estrategias de descuento como RegularPricing, MemberPricing (10% descuento), BlackFridayPricing (30% descuento) y BulkPricing (descuento por cantidad), evitando múltiples condicionales dentro del cálculo de precios cumpliendo asi el Open/Closed.


### 4.SOLID

Se aplicaron los principios SOLID gracias a los patrones cumpliendo con cada sigla.


## Instrucciones de Ejecución

1. Clonar el repositorio

2. Abrir el proyecto en un IDE compatible con Java 17.

3. Compilar el proyecto.

4. Ejecutar la clase Main.java.
