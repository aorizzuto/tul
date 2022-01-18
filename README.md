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