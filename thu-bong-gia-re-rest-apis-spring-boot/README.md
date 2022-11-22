# Thu bong gia re REST API

## Before you start

### Create database

As we configured in the `application.properties` file, we use:

- SQLServer database: `jdbc:sqlserver://localhost:1433;databaseName=thu_bong_gia_re`
- SQL username: `sa`
- SQL password: `sapassword`

If you want to use another database or another username and password, you can change them in the `application.properties` file.

### Build project with Maven

To build this project, head over to the project folder by ```cd path/to/project/folder```

And then run ```mvn clean package```

After successfully built, type this command to run app (replace ```path/to/jar/file.jar``` by your jar file relative path)

```
java -jar target/path/to/jar/file.jar
```

The app will be running on port `8080`.

> If you receive an error like: `port 8080 is already in use`, let terminate the process which is running on port 8080 and run the app again.

## Import sample data

As a schema is created persistently, you can import sample data to your database by copy and pasting the following SQL into your database.

<details>
  <summary>Click to view script</summary>

```sql
USE [thu_bong_gia_re]
GO
INSERT [dbo].[carts] ([token], [created_at], [expired_at]) VALUES (N'0c8b2c73-d828-40c1-a300-a57a2dfb515e', CAST(N'2022-05-12T06:42:30.4920000' AS DateTime2), CAST(N'2023-05-12T06:42:30.4920000' AS DateTime2))
INSERT [dbo].[carts] ([token], [created_at], [expired_at]) VALUES (N'499982c2-1520-43f6-b31d-aae2a1e65d3a', CAST(N'2022-05-12T06:42:30.4920000' AS DateTime2), CAST(N'2023-05-12T06:42:30.4920000' AS DateTime2))
INSERT [dbo].[carts] ([token], [created_at], [expired_at]) VALUES (N'7b5eb73d-97f9-4e37-ab60-68ddaa67fddc', CAST(N'2022-05-12T06:42:30.4920000' AS DateTime2), CAST(N'2023-05-12T06:42:30.4920000' AS DateTime2))
GO
SET IDENTITY_INSERT [dbo].[products] ON

INSERT [dbo].[products] ([id], [brand], [category], [cost], [description], [height], [image], [material], [measured_unit], [name], [origin], [rate], [weight], [width]) VALUES (5, N'NTSHOP', N'thú bông dài', 68000, N'Gối hình thú được làm bằng chất liệu vải và bông gòn trắng an toàn, mềm mại, tạo cảm giác dễ chịu, thoải mái khi tiếp xúc, giúp mang lại cho bạn giấc ngủ sâu, lấy lại tinh thần sau những giờ làm việc mệt mỏi. Thiết kế thông minh tiện lợi, kiểu dáng xinh xắn. Gối được thiết kế xinh xắn với kiểu dáng ngộ nghĩnh dễ thương, có thể gối đầu hoặc dựa lưng êm ái. Sử dụng thoải mái với nhiều mục đích khác nhau.', 7.1, N'https://cf.shopee.vn/file/049183874fadfa4f9872ab6aea3741da', N'Bông', N'cm', N'Thú nhồi bông , gối ôm hình thú ngộ nghĩnh', N'Hà nội', 0, 8.2, 8.3)
INSERT [dbo].[products] ([id], [brand], [category], [cost], [description], [height], [image], [material], [measured_unit], [name], [origin], [rate], [weight], [width]) VALUES (6, N'NTSHOP', N'thú bông nhỏ', 64000, N'Sản phẩm “gấu bông chó shiba cosplay” là hàng cao cấp được sản xuất trên dây chuyền kĩ thuật cao với bộ lông nhung mềm mịn, mềm không kích ứng da, phù hợp cho mọi lứa tuổi  Sản phẩm được thiết kế mềm mại, các đường may liền mảnh, có thể làm quà tặng hoặc để sử dụng để ôm, trang trí.', 76, N'https://cf.shopee.vn/file/43e4905b044f469bdeed0b48dce04f89', N'Bông', N'cm', N'Gấu Bông Chó Shiba Cosplay mềm mịn', N'Thái Nguyên', 0, 8.2, 8.3)
INSERT [dbo].[products] ([id], [brand], [category], [cost], [description], [height], [image], [material], [measured_unit], [name], [origin], [rate], [weight], [width]) VALUES (7, N'NTSHOP', N'thú bông trung bình', 96000, N'Chiều dài là số đo thực trên con ngựa, có thể sai số cộng trừ 5 - 10 cm tùy vào độ bung của gòn bên trong. Màu hồng nude nhẹ nhàng, tinh tế, do ánh sáng và máy ảnh nên màu thực tế có thể sai lệch 5% so với ảnh shop đăng mong quý khách thông cảm. Lưu ý: do quá trình vận chuyển sản phẩm bị đè dẹp khi hút chân không, để sản phẩm được đẹp nhất quý khách nên phơi nắng 2h để ruột gòn bên trong bung toi căng đều.', 32, N'https://cf.shopee.vn/file/673d79c7106a08415dee47e9d76f077a', N'Bông', N'cm', N'Gấu bông unicorn thú bông ngựa Pony', N'Bình Định', 0, 8.2, 8.3)
INSERT [dbo].[products] ([id], [brand], [category], [cost], [description], [height], [image], [material], [measured_unit], [name], [origin], [rate], [weight], [width]) VALUES (8, N'DNS', N'thú bông cỡ lớn', 67000, N'Hươu b, ông về thêm cho các bé rồi nhaaaa. Vừa êm ái lại vừa xinh bé nào cũng cần 1 vài em gấu bông để làm bạn để ôm ấp hít hà nhé. Dùng làm quà tặng cũng đáng iêu vô cùng nhé', 7.1, N'https://cf.shopee.vn/file/e041d4f1e070c45a3750f938ba9852df', N'Vải', N'cm', N'Hươu bông cho bé hkm grow', N'Trung Quốc', 0, 8.2, 8.3)
INSERT [dbo].[products] ([id], [brand], [category], [cost], [description], [height], [image], [material], [measured_unit], [name], [origin], [rate], [weight], [width]) VALUES (9, N'NTSHOP', N'thú bông nhỏ', 85000, N'- Sản phẩm được đóng gói bằng túi chuyên dụng chắc chắn. - Đối với các sản phẩm cỡ lớn sẽ được hút chân không nhằm dễ dàng vận chuyển. - Khi nhận được sản phẩm, quý khách vỗ đều sản phẩm để sản phẩm trở lại hình dáng ban đầu. - Màu sắc và kích cỡ có thể sai lệch ~5% do thiết bị đo chụp. CHÍNH SÁCH BÁN HÀNG CỦA Vini.kids: - Cam kết đổi trả 100% nếu có lỗi từ nsx', 7.1, N'https://cf.shopee.vn/file/c1f86402e9044bd3fe56b32baf8b1418', N'Bông', N'cm', N'Gấu bông chuột Hamster dễ thương', N'Ba Vì', 0, 6.7, 8.3)
INSERT [dbo].[products] ([id], [brand], [category], [cost], [description], [height], [image], [material], [measured_unit], [name], [origin], [rate], [weight], [width]) VALUES (10, N'NTSHOP', N'thú bông cỡ vừa', 67000, N'Thú bông đáng yêu hàng  khuyến mãi unidry  Thú nhồi bông cho bé. 40cm  nhìn cưng xỉu un ah  Khuyến mãi bỉm.  Mềm mịn, ko sổ lông, ko xùa bai nhão. Giặt máy thỏa mái', 3.6, N'https://cf.shopee.vn/file/a3d3858754d449b92da0d0f1460b1809', N'Nỉ', N'cm', N'Thú bông Shiba đáng yêu khuyến mãi unidry', N'TPHCM', 0, 8.2, 7.9)
INSERT [dbo].[products] ([id], [brand], [category], [cost], [description], [height], [image], [material], [measured_unit], [name], [origin], [rate], [weight], [width]) VALUES (11, N'DTS', N'thú bông nhỏ', 58000, N'Vải cao cấp, mềm mịn, không xù lông, rất an toàn với sức khỏe của bé. Bên trong là chất liệu bông cao cấp tạo độ đàn hồi không bị xẹp nên tạo được sự êm ái khi sử dụng, đảm bảo sẽ đem lại cảm giác vô cùng thoải mái và dễ chịu cho bé. Giá cả cạnh tranh Là món quà ý nghĩa mà Diabrand mang lại cho quý khách hàng', 7.1, N'https://cf.shopee.vn/file/3ab6224fb4a7ea192b89d58422a2c321', N'Bông', N'cm', N'Thú Bông Mèo Pusheen Cao Cấp Dễ Thương', N'Thái Lan', 0, 7.9, 9.5)
INSERT [dbo].[products] ([id], [brand], [category], [cost], [description], [height], [image], [material], [measured_unit], [name], [origin], [rate], [weight], [width]) VALUES (12, N'NTSHOP', N'thú bông cỡ vừa', 75000, N'Màu sắc: màu đỏ, xanh Gấu thỏ cao cấp an toàn cho bé,không xù lông, không xẹp,mềm mại và dễ thương. ', 32, N'https://cf.shopee.vn/file/869d635ef1762ee8fbfd7be3f00625a9', N'Bông', N'cm', N'Gấu bông thỏ cao cấp an toàn cho bé', N'Bình Định', 0, 6.7, 8.3)
INSERT [dbo].[products] ([id], [brand], [category], [cost], [description], [height], [image], [material], [measured_unit], [name], [origin], [rate], [weight], [width]) VALUES (13, N'NTSHOP', N'thú bông cỡ lớn', 54000, N'- Gấu bông doraemon là dòng sản phẩm cao cấp, vỏ gấu chất liệu vải nhung mềm mịn, co giãn 4 chiều   - Bông nhồi bên trong là 100% bông PP 3D loại 1 với độ đàn hồi tốt, không bị vón cục theo thời gian   - Chất lượng doremon gấu bông đã được kiểm định, an toàn cho người sử dụng đặc biệt là trẻ em   - Tính năng: Dùng để cho bé ôm, trang trí hoặc làm quà tặng…', 32, N'https://cf.shopee.vn/file/9f98d5c9ccc042c5cf8fdfcb03192b36', N'Nỉ', N'cm', N'Gấu bông doraemon hình thú mềm mịn', N'Hà nội', 0, 6, 34)
INSERT [dbo].[products] ([id], [brand], [category], [cost], [description], [height], [image], [material], [measured_unit], [name], [origin], [rate], [weight], [width]) VALUES (14, N'DNS', N'thú bông nhỏ', 78000, N'Một chú gấu bông bạch tuột tuộccảm xúc 2 mặt đáng yêu sẽ là món quà tuyệt vời dành tặng cho bạn gái, chị gái, hoặc các bé nhỏ.  Vui, buồn, đó là những cảm xúc rất đỗi bình thường. Hãy để chú gấu bông bạch tuột cảm xúc 2 mặt đáng yêu này là người bạn, đồng hành cùng với người thân yêu của mình nhé.', 9, N'https://cf.shopee.vn/file/9852af5c5e29a8cc3c5340e2e5ba9337', N'Bông', N'cm', N'Bạch Tuột tuộc Cảm Xúc 2 Mặt Đáng Yêu', N'Trung Quốc', 0, 6, 10)
INSERT [dbo].[products] ([id], [brand], [category], [cost], [description], [height], [image], [material], [measured_unit], [name], [origin], [rate], [weight], [width]) VALUES (15, N'NTSHOP', N'thú bông dài', 53000, N'Vini.kids xin giới thiệu  Sản phẩm Cánh cụt nhồi bông cao cấp MÔ TẢ SẢN PHẨM: - Sản phẩm được may và nhồi bông bằng chất liệu cao cấp không gây hại sức khỏe - Sản phẩm được sử dụng dể trang trí, làm quà tặng, ôm,...', 7.1, N'https://cf.shopee.vn/file/bba83374e510c6d26a9d5c79b5d046b5', N'Bông', N'cm', N'Chim cánh cụt nhồi bông cao cấp', N'Hà nội', 0, 8.2, 6)
INSERT [dbo].[products] ([id], [brand], [category], [cost], [description], [height], [image], [material], [measured_unit], [name], [origin], [rate], [weight], [width]) VALUES (16, N'NTSHOP', N'thú bông trung bình', 96000, N'QUY CÁCH ĐÓNG GÓI: - Sản phẩm được đóng gói bằng túi chuyên dụng chắc chắn. - Đối với các sản phẩm cỡ lớn sẽ được hút chân không nhằm dễ dàng vận chuyển. - Khi nhận được sản phẩm, quý khách vỗ đều sản phẩm để sản phẩm trở lại hình dáng ban đầu. - Màu sắc và kích cỡ có thể sai lệch ~5% do thiết bị đo chụp.', 7.1, N'https://cf.shopee.vn/file/5111c08c6276dd42c8efdb4edced46ed', N'Bông', N'cm', N'Cá mập nhồi bông cute - Baby shark nhồi bông', N'Trung Quốc', 0, 7.9, 8.3)
SET IDENTITY_INSERT [dbo].[products] OFF
GO
INSERT [dbo].[cart_details] ([cart_id], [product_id], [cost], [quantity], [total_line]) VALUES (N'499982c2-1520-43f6-b31d-aae2a1e65d3a', 5, 68000, 2, 136000)
INSERT [dbo].[cart_details] ([cart_id], [product_id], [cost], [quantity], [total_line]) VALUES (N'499982c2-1520-43f6-b31d-aae2a1e65d3a', 9, 85000, 3, 255000)
GO
SET IDENTITY_INSERT [dbo].[customers] ON

INSERT [dbo].[customers] ([id], [email], [name], [phone_number]) VALUES (1, N'nhat@gmail.com', N'Phan Đình Nhật', N'0345826324')
INSERT [dbo].[customers] ([id], [email], [name], [phone_number]) VALUES (2, N'toan@gmail.com', N'Võ Đức Toàn', N'0378653975')
INSERT [dbo].[customers] ([id], [email], [name], [phone_number]) VALUES (3, N'ha@gmail.com', N'Phan Hồng Hà', N'0347698321')
INSERT [dbo].[customers] ([id], [email], [name], [phone_number]) VALUES (4, N'nguyenhoanhuu@gmail.com', N'Nguyễn Hoàn Hữu', N'0387986543')
INSERT [dbo].[customers] ([id], [email], [name], [phone_number]) VALUES (5, N'thaunhoang@gmail.com', N'Hoàng Hoa Thuấn', N'0347652834')
INSERT [dbo].[customers] ([id], [email], [name], [phone_number]) VALUES (6, N'huynguyen@gmail.com', N'Nguyễn Văn Huy', N'0345879675')
INSERT [dbo].[customers] ([id], [email], [name], [phone_number]) VALUES (7, N'trungkien@gmail.com', N'Nguyễn Trung Kiên', N'0345829836')
INSERT [dbo].[customers] ([id], [email], [name], [phone_number]) VALUES (8, N'trung@gmail.com', N'Nguyễn Tuấn Trung', N'0345898768')
SET IDENTITY_INSERT [dbo].[customers] OFF
GO
SET IDENTITY_INSERT [dbo].[users] ON

INSERT [dbo].[users] ([id], [email], [name], [password], [phone_number]) VALUES (1, N'phandinhnhat@gmail.com', N'Phan Đình Nhật', N'$2a$10$jVubshLgjEpmYBLJ3oEoY.G8OeqKvRLHu9YHT7pSkq9j35UI6qPFW', N'0345926324')
INSERT [dbo].[users] ([id], [email], [name], [password], [phone_number]) VALUES (2, N'voductoan@gmail.com', N'Võ Đức Toàn', N'$2a$10$gfbYCxGNlghnR64nPyoF/uUBA1XXm8nQKDrAS5ck4RBvKLomkfxkC', N'0356872943')
SET IDENTITY_INSERT [dbo].[users] OFF
GO
SET IDENTITY_INSERT [dbo].[promotions] ON

INSERT [dbo].[promotions] ([id], [deducted], [expired_date], [limit], [promotion_code], [user_id]) VALUES (1, 0.3, CAST(N'2022-05-21T16:21:00.0000000' AS DateTime2), 1, N'MAKHUYENMAINGAY215', 1)
INSERT [dbo].[promotions] ([id], [deducted], [expired_date], [limit], [promotion_code], [user_id]) VALUES (2, 0.06, CAST(N'2022-05-20T16:24:00.0000000' AS DateTime2), 5, N'MAMUNGSINHNHAT123', 1)
INSERT [dbo].[promotions] ([id], [deducted], [expired_date], [limit], [promotion_code], [user_id]) VALUES (3, 0.02, CAST(N'2022-05-20T16:25:00.0000000' AS DateTime2), 6, N'MAKHUYENMAI456', 1)
INSERT [dbo].[promotions] ([id], [deducted], [expired_date], [limit], [promotion_code], [user_id]) VALUES (4, 0.9, CAST(N'2022-05-22T16:26:00.0000000' AS DateTime2), 6, N'MAKHUYENMAIVIP', 1)
INSERT [dbo].[promotions] ([id], [deducted], [expired_date], [limit], [promotion_code], [user_id]) VALUES (5, 0.5, CAST(N'2022-05-21T16:27:00.0000000' AS DateTime2), 5, N'MAKHUYENMAI779', 1)
INSERT [dbo].[promotions] ([id], [deducted], [expired_date], [limit], [promotion_code], [user_id]) VALUES (6, 0.08, CAST(N'2022-05-25T16:30:00.0000000' AS DateTime2), 7, N'MAKHUYENMAI543', 2)
INSERT [dbo].[promotions] ([id], [deducted], [expired_date], [limit], [promotion_code], [user_id]) VALUES (7, 0.7, CAST(N'2022-05-21T16:30:00.0000000' AS DateTime2), 0, N'MAKHUYENMAI111', 2)
INSERT [dbo].[promotions] ([id], [deducted], [expired_date], [limit], [promotion_code], [user_id]) VALUES (8, 0.4, CAST(N'2022-05-20T16:30:00.0000000' AS DateTime2), 8, N'MAKHUYENMAI333', 2)
SET IDENTITY_INSERT [dbo].[promotions] OFF
GO
SET IDENTITY_INSERT [dbo].[orders] ON

INSERT [dbo].[orders] ([id], [discount], [order_date], [shipping_address], [shipping_cost], [shipping_note], [sub_total], [total], [customer_id], [promotion_code]) VALUES (1, 0, CAST(N'2022-05-19T16:19:38.5794714' AS DateTime2), N'Chugn cư Thới An Quận 12 TPHCM', 20000, N'thanh toán khi nhận hàng', 374000, 394000, 1, NULL)
INSERT [dbo].[orders] ([id], [discount], [order_date], [shipping_address], [shipping_cost], [shipping_note], [sub_total], [total], [customer_id], [promotion_code]) VALUES (2, 0.3, CAST(N'2022-05-20T16:23:27.2053958' AS DateTime2), N'45 Dương Quảng Hàm Gò Vấp TPHCM', 20000, NULL, 284000, 212800, 2, 1)
INSERT [dbo].[orders] ([id], [discount], [order_date], [shipping_address], [shipping_cost], [shipping_note], [sub_total], [total], [customer_id], [promotion_code]) VALUES (3, 0.7, CAST(N'2022-05-20T16:32:01.5239490' AS DateTime2), N'56 Nguyễn Kiệm Gò Vấp TPHCM', 20000, NULL, 224000, 73200.000000000015, 3, 7)
INSERT [dbo].[orders] ([id], [discount], [order_date], [shipping_address], [shipping_cost], [shipping_note], [sub_total], [total], [customer_id], [promotion_code]) VALUES (4, 0.08, CAST(N'2022-05-20T16:35:15.6337316' AS DateTime2), N'34 Đinh Bộ Lĩnh Thủ Đức TPHCM', 20000, N'thanh toán khi nhận hàng', 231000, 230920, 4, 6)
INSERT [dbo].[orders] ([id], [discount], [order_date], [shipping_address], [shipping_cost], [shipping_note], [sub_total], [total], [customer_id], [promotion_code]) VALUES (5, 0.9, CAST(N'2022-05-20T16:38:24.9245242' AS DateTime2), N'67 Tô Ngọc Vân Thủ Đức TPHCM', 20000, N'đóng gói hàng kĩ lưỡng', 134000, 15399.999999999996, 5, 4)
INSERT [dbo].[orders] ([id], [discount], [order_date], [shipping_address], [shipping_cost], [shipping_note], [sub_total], [total], [customer_id], [promotion_code]) VALUES (6, 0, CAST(N'2022-05-20T16:43:55.1281787' AS DateTime2), N'54 Đường số 1 Phường 5 quận 12 TPHCM', 20000, NULL, 361000, 381000, 6, NULL)
INSERT [dbo].[orders] ([id], [discount], [order_date], [shipping_address], [shipping_cost], [shipping_note], [sub_total], [total], [customer_id], [promotion_code]) VALUES (7, 0.08, CAST(N'2022-05-20T16:49:37.8302899' AS DateTime2), N'45 Lê Lợi phường 4 Gò Vấp TPHCM', 20000, NULL, 174000, 178480, 7, 6)
INSERT [dbo].[orders] ([id], [discount], [order_date], [shipping_address], [shipping_cost], [shipping_note], [sub_total], [total], [customer_id], [promotion_code]) VALUES (8, 0.3, CAST(N'2022-05-20T16:52:19.1942311' AS DateTime2), N'34 Phạm Ngũ Lão Phường 4 Gò Vấp', 20000, N'thanh toán khi nhận hàng', 136000, 109200, 8, 1)
SET IDENTITY_INSERT [dbo].[orders] OFF
GO
INSERT [dbo].[order_details] ([order_id], [product_id], [cost], [quantity], [total_line]) VALUES (1, 6, 64000, 2, 128000)
INSERT [dbo].[order_details] ([order_id], [product_id], [cost], [quantity], [total_line]) VALUES (1, 7, 96000, 2, 192000)
INSERT [dbo].[order_details] ([order_id], [product_id], [cost], [quantity], [total_line]) VALUES (1, 13, 54000, 1, 54000)
INSERT [dbo].[order_details] ([order_id], [product_id], [cost], [quantity], [total_line]) VALUES (2, 10, 67000, 2, 134000)
INSERT [dbo].[order_details] ([order_id], [product_id], [cost], [quantity], [total_line]) VALUES (2, 12, 75000, 2, 150000)
INSERT [dbo].[order_details] ([order_id], [product_id], [cost], [quantity], [total_line]) VALUES (3, 11, 58000, 2, 116000)
INSERT [dbo].[order_details] ([order_id], [product_id], [cost], [quantity], [total_line]) VALUES (3, 13, 54000, 2, 108000)
INSERT [dbo].[order_details] ([order_id], [product_id], [cost], [quantity], [total_line]) VALUES (4, 12, 75000, 1, 75000)
INSERT [dbo].[order_details] ([order_id], [product_id], [cost], [quantity], [total_line]) VALUES (4, 14, 78000, 2, 156000)
INSERT [dbo].[order_details] ([order_id], [product_id], [cost], [quantity], [total_line]) VALUES (5, 8, 67000, 2, 134000)
INSERT [dbo].[order_details] ([order_id], [product_id], [cost], [quantity], [total_line]) VALUES (6, 9, 85000, 3, 255000)
INSERT [dbo].[order_details] ([order_id], [product_id], [cost], [quantity], [total_line]) VALUES (6, 15, 53000, 2, 106000)
INSERT [dbo].[order_details] ([order_id], [product_id], [cost], [quantity], [total_line]) VALUES (7, 11, 58000, 3, 174000)
INSERT [dbo].[order_details] ([order_id], [product_id], [cost], [quantity], [total_line]) VALUES (8, 11, 58000, 1, 58000)
INSERT [dbo].[order_details] ([order_id], [product_id], [cost], [quantity], [total_line]) VALUES (8, 14, 78000, 1, 78000)
GO
INSERT [dbo].[product_inventory] ([product_id], [cost], [created_at], [quantity]) VALUES (5, 68000, CAST(N'2022-05-20T15:50:34.9133878' AS DateTime2), 13)
INSERT [dbo].[product_inventory] ([product_id], [cost], [created_at], [quantity]) VALUES (6, 64000, CAST(N'2022-05-20T15:53:25.3401110' AS DateTime2), 48)
INSERT [dbo].[product_inventory] ([product_id], [cost], [created_at], [quantity]) VALUES (7, 96000, CAST(N'2022-05-20T15:55:39.2480883' AS DateTime2), 13)
INSERT [dbo].[product_inventory] ([product_id], [cost], [created_at], [quantity]) VALUES (8, 67000, CAST(N'2022-05-20T15:57:56.9718840' AS DateTime2), 43)
INSERT [dbo].[product_inventory] ([product_id], [cost], [created_at], [quantity]) VALUES (9, 85000, CAST(N'2022-05-20T16:01:54.1798896' AS DateTime2), 27)
INSERT [dbo].[product_inventory] ([product_id], [cost], [created_at], [quantity]) VALUES (10, 67000, CAST(N'2022-05-20T16:04:20.6192830' AS DateTime2), 22)
INSERT [dbo].[product_inventory] ([product_id], [cost], [created_at], [quantity]) VALUES (11, 58000, CAST(N'2022-05-20T16:06:38.6449641' AS DateTime2), 9)
INSERT [dbo].[product_inventory] ([product_id], [cost], [created_at], [quantity]) VALUES (12, 75000, CAST(N'2022-05-20T16:09:06.3039613' AS DateTime2), 43)
INSERT [dbo].[product_inventory] ([product_id], [cost], [created_at], [quantity]) VALUES (13, 54000, CAST(N'2022-05-20T16:11:54.1448909' AS DateTime2), 26)
INSERT [dbo].[product_inventory] ([product_id], [cost], [created_at], [quantity]) VALUES (14, 78000, CAST(N'2022-05-20T16:13:46.9993773' AS DateTime2), 8)
INSERT [dbo].[product_inventory] ([product_id], [cost], [created_at], [quantity]) VALUES (15, 53000, CAST(N'2022-05-20T16:16:12.2184764' AS DateTime2), 23)
INSERT [dbo].[product_inventory] ([product_id], [cost], [created_at], [quantity]) VALUES (16, 96000, CAST(N'2022-05-20T17:01:55.0825320' AS DateTime2), 0)
GO
```
</details>