INSERT INTO category (id, description, name) VALUES
(1, 'Electronics gadgets and devices', 'Electronics'),
(2, 'Home and office furniture', 'Furniture'),
(3, 'Food and beverage items', 'Groceries'),
(4, 'Books of various genres', 'Books'),
(5, 'Clothing and apparel', 'Clothing');

INSERT INTO product (id, description, name, availableQuantity, price, category_id) VALUES
(1, 'Latest model smartphone with 128GB storage', 'Smartphone', 50, 699.99, 1),
(2, 'Wooden dining table set with 6 chairs', 'Dining Table Set', 10, 349.50, 2),
(3, 'Organic whole grain bread', 'Whole Grain Bread', 100, 2.99, 3),
(4, 'Bestselling science fiction novel', 'Sci-Fi Novel', 200, 12.50, 4),
(5, 'Comfortable cotton t-shirt', 'Cotton T-Shirt', 500, 15.00, 5),
(6, '4K Ultra HD Smart TV', 'Smart TV', 25, 999.99, 1),
(7, 'Ergonomic office chair', 'Office Chair', 40, 120.75, 2),
(8, 'Freshly squeezed orange juice', 'Orange Juice', 150, 3.50, 3),
(9, 'Romantic novel by popular author', 'Romance Novel', 80, 10.99, 4),
(10, 'Winter jacket for outdoor wear', 'Winter Jacket', 60, 89.99, 5);
