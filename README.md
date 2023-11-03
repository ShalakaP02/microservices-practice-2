# microservices-practice-2
Creating sample microservices for order placing and payment processing and implementing concepts such as centralized logging, security, api  gateway.

![image](https://github.com/ShalakaP02/microservices-practice-2/assets/89374228/50490b6e-a496-48a8-bc07-b27aabb871d8)

# API End Points

GET http://localhost:8765/order/getOrder  

POST http://localhost:9091/order/bookOrder  

{
    "order" : {
    "orderId" : 999,
    "orderName" : "teabag",
    "quantity" : 2,
    "price" : 3333
    },
    "payment" : {}
}  

GET http://localhost:8765/payment/999
