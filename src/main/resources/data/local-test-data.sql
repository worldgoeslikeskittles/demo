INSERT INTO role (id, role_type) VALUES (3, 'CUSTOMER') ON CONFLICT DO NOTHING;
INSERT INTO role (id, role_type) VALUES (2, 'SELLER') ON CONFLICT DO NOTHING;
INSERT INTO role (id, role_type) VALUES (1, 'ADMIN') ON CONFLICT DO NOTHING;

INSERT INTO user_ (id, name, login, password) VALUES (1, 'Paul', 'login', 'pass') ON CONFLICT DO NOTHING;
INSERT INTO user_ (id, name, login, password) VALUES (2, 'Julia', 'login', 'pass') ON CONFLICT DO NOTHING;

INSERT INTO user__roles (roles_id, user_id) VALUES (3, 1) ON CONFLICT DO NOTHING;
INSERT INTO user__roles (roles_id, user_id) VALUES (3, 2)ON CONFLICT DO NOTHING;

INSERT INTO storage (id, storage_number) VALUES (1, 'Storage1') ON CONFLICT DO NOTHING;

INSERT INTO product (id, name, price, description) VALUES (1, 'Салфетки влажные', 250, 'Дезинфицирующие влажные салфетки') ON CONFLICT DO NOTHING;
INSERT INTO product (id, name, price, description) VALUES (2, 'Салфетки Бумажные', 100, 'Сухие бумажные салфетки 20шт') ON CONFLICT DO NOTHING;
INSERT INTO product (id, name, price, description) VALUES (3, 'Полотенца Тканевые', 30, 'Полотенца тканевые. Рулон 50шт') ON CONFLICT DO NOTHING;

INSERT INTO storage_item (id, product_id, count, storage_id) VALUES (1, 1, 100, 1) ON CONFLICT DO NOTHING;
INSERT INTO storage_item (id, product_id, count, storage_id) VALUES (2, 2, 200, 1) ON CONFLICT DO NOTHING;
INSERT INTO storage_item (id, product_id, count, storage_id) VALUES (3, 3, 50, 1) ON CONFLICT DO NOTHING;