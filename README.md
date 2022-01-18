# TUL Challenge

#### By: Alejandro O. Rizzuto

## Shopping Cart

### Product
- UUID
- Name
- Sku
- Description
- Price
- has_discount


### Orders
- UUID
- product
- quantity

### Cart
- UUID
- orders
- status

#### Notas
En este caso, se valida que el carrito esta abierto por el estado PENDING. Lo que habria que hacer es 
matchear el carrito con el usuario logueado. De esta forma, se puede tener mas de un carrito en PENDING.

Al momento de hacer cashout, se validan los productos en el carrito y se actualiza como COMPLETED.

Si se quiere seguir poniendo productos en el carrito, se abrira un nuevo UUID de carrito con estado
PENDING.

## Endpoints

### Save new product

curl --location --request POST 'http://localhost:8080/product/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "name":"Remera",
    "description":"Remera manga corta",
    "price":100.23,
    "sku":"123412345",
    "has_discount":true
}'

### Get all products in store

curl --location --request GET 'http://localhost:8080/product/all'

### Remove product from store

curl --location --request DELETE 'http://localhost:8080/product/9b143ee9-74df-435e-92c2-bf075071f31b'

### Update product in store

curl --location --request PUT 'http://localhost:8080/product/15bbf4b2-2a84-4b2d-95e0-da47e767c8fc' \
--header 'Content-Type: application/json' \
--data-raw '{
    
}'

### Add product to cart

curl --location --request POST 'http://localhost:8080/cart/' \
--header 'Content-Type: application/json' \
--data-raw '{
    "product_id":"6d649cf4-d510-4e06-a32a-9d5900aa4abc",
    "quantity":3
}'

### Cashout

curl --location --request GET 'http://localhost:8080/cart/cashout'

### Get all products in cart

curl --location --request GET 'http://localhost:8080/cart/all'

### Remove product from cart

curl --location --request DELETE 'http://localhost:8080/cart/15bbf4b2-2a84-4b2d-95e0-da47e767c8fc'
