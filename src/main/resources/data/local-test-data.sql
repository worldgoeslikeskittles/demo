INSERT INTO product (id, name, description, product_discount, price) VALUES (1, 'Салфетки влажные', 'Отличные влажные салфетки', null, 250) ON CONFLICT DO NOTHING;
INSERT INTO product (id, name, description, product_discount, price) VALUES (2, 'Салфетки Сухие', 'Обычные сухие салфетки', null, 139) ON CONFLICT DO NOTHING;
INSERT INTO product (id, name, description, product_discount, price) VALUES (3, 'Салфетки Тканевые', 'Кухонные тканевые салфетки', null, 469) ON CONFLICT DO NOTHING;

INSERT INTO user_ (id, department_id, name) VALUES (1, NULL, 'Paul') ON CONFLICT DO NOTHING;
INSERT INTO user_ (id ,department_id, name) VALUES (2, NULL, 'Julia') ON CONFLICT DO NOTHING;

INSERT INTO user_role (id, role, user_id) VALUES (1, 'CUSTOMER', 1) ON CONFLICT DO NOTHING;
INSERT INTO user_role (id, role, user_id) VALUES (2, 'CUSTOMER', 2) ON CONFLICT DO NOTHING;

INSERT INTO user_credentials (id, login, password, user_id) VALUES (1, 'login1', 'pass1', 1) ON CONFLICT DO NOTHING;
INSERT INTO user_credentials (id, login, password, user_id) VALUES (2, 'login2', 'pass2', 2) ON CONFLICT DO NOTHING;

INSERT INTO customer (id, user_id) VALUES (1, 1) ON CONFLICT DO NOTHING;
INSERT INTO customer (id, user_id) VALUES (2, 2) ON CONFLICT DO NOTHING;

INSERT INTO storage (id, storage_number) VALUES (1, 'Storage1') ON CONFLICT DO NOTHING;
INSERT INTO storage (id, storage_number) VALUES (2, 'Storage2') ON CONFLICT DO NOTHING;

INSERT INTO storage_item (id, storage_id, product_id, count, storage_item_discount) VALUES (1, 1, 1, 100, NULL) ON CONFLICT DO NOTHING;
INSERT INTO storage_item (id, storage_id, product_id, count, storage_item_discount) VALUES (2, 1, 2, 100, NULL) ON CONFLICT DO NOTHING;
INSERT INTO storage_item (id, storage_id, product_id, count, storage_item_discount) VALUES (3, 1, 2, 100, NULL) ON CONFLICT DO NOTHING;