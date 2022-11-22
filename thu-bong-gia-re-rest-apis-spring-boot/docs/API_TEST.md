# API test

## Product

```json
{
    "name": "Thú bông Doraemon",
    "description": "chi tiet thu bong Doraemon",
    "origin": "Hà nội",
    "brand": "NTSHOP",
    "rate": 4,
    "category": "thu bong nho",
    "material": "bông",
    "weight": 6.7,
    "height": 7,
    "width": 6,
    "image": "https://th.bing.com/th/id/R.260e1fce0739bb918ef8d605d63e45b5?rik=i8q7oFk9ewy4jw&pid=ImgRaw&r=0",
    "cost": 67000
}
```

## Customer

### Create a customer

```json
{
  "id": 1,
  "name": "Toan",
  "email": "toan@gmail.com",
  "phoneNumber": "0339097564"
}
```

## Promotion

### Create a promotion

```json
{
    "deducted": 0.5,
    "expiredDate": "2023-05-12T21:34:55",
    "limit": 7,
    "promotionCode": "GRABNOW",
    "createdBy": 3
}
```

## User

### Create a user

```json
{
  "name": "Phan Ha",
  "email": "ha.phan@gmail.com",
  "phoneNumber": "0345678904"
}
```

## Order

### Create an order

```json
{
  "shippingCost": 20000.0,
  "promotionCode": null,
  "shippingAddress": "12 Nguyễn Văn Bảo, phường 4, Quận Gò Vấp, TP.HCM",
  "customer": 1,
  "details": [
    {
      "product": 1,
      "quantity": 2
    }
  ]
}
```