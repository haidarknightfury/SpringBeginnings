INSERT INTO user (id, name, username, password) VALUES (1, 'haidar', 'haidar', 'haidar');
INSERT INTO user (id, name, username, password) VALUES (2, 'admin', 'admin', 'admin');
INSERT INTO user_authority (username, auth_group) VALUES ('haidar', 'USER');
INSERT INTO user_authority (username, auth_group) VALUES ('admin', 'ADMIN');