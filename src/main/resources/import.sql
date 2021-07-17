/* Populate table owners */
-- password Almendra_34
INSERT INTO owners (email, name, lastname, password, enabled) VALUES('davidmanti92@gmail.com', 'David', 'Mantiñán Montero','$2a$10$vLtsCADjYweSd0eo7n1As.8j/ceyBuDThqIk4Bcg58CJ4IX8Zs/7S',1);

/* Populate table roles */
INSERT INTO roles (name) VALUES ('ROLE_ADMIN')
INSERT INTO roles (name) VALUES ('ROLE_USER')

/* Roles and users */
INSERT INTO owners_roles (owner_id, role_id) VALUES(1,1);
INSERT INTO owners_roles (owner_id, role_id) VALUES(1,2);

/* Populate table ownership */
INSERT INTO ownerships (operation, population,zone, kind_ownership,bedrooms,price) VALUES ('A','B','C','D',2,1.23);
INSERT INTO ownerships (operation, population,zone, kind_ownership,bedrooms,price) VALUES ('E','B','C','D',2,1.23);
INSERT INTO ownerships (operation, population,zone, kind_ownership,bedrooms,price) VALUES ('I','B','C','D',2,1.23);
INSERT INTO ownerships (operation, population,zone, kind_ownership,bedrooms,price) VALUES ('O','B','C','D',2,1.23);
INSERT INTO ownerships (operation, population,zone, kind_ownership,bedrooms,price) VALUES ('U','B','C','D',2,1.23);