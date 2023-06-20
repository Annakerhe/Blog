INSERT INTO role(id, name)
 VALUES (1, 'ROLE_USER'), (2, 'ROLE_ADMIN');

INSERT INTO author (id, age, "password", status, username)
  VALUES (1, 18, '$2a$10$PJ28TGRjT.a2MUTnLcylNenDioyLaf5tBN/pApDOVEsQw8.yRQhhq' ,'PHLEGMATIC','boss');

INSERT INTO author_roles (author_id, roles_id)
  VALUES (1, 2);


--author

INSERT INTO author (age, "password", status, username)
VALUES(79, '$2a$10$PJ28TGRjT.a2MUTnLcylNenDioyLaf5tBN/pApDOVEsQw8.yRQhhq', 'MELANCHOLIC', 'Maisie');
INSERT INTO author (age, "password", status, username)
VALUES(54, '$2a$10$PJ28TGRjT.a2MUTnLcylNenDioyLaf5tBN/pApDOVEsQw8.yRQhhq', 'MELANCHOLIC', 'Audrie');
INSERT INTO author (age, "password", status, username)
VALUES(57, '$2a$10$PJ28TGRjT.a2MUTnLcylNenDioyLaf5tBN/pApDOVEsQw8.yRQhhq', 'MELANCHOLIC', 'Delaine');
INSERT INTO author (age, "password", status, username)
VALUES(23, '$2a$10$PJ28TGRjT.a2MUTnLcylNenDioyLaf5tBN/pApDOVEsQw8.yRQhhq', 'MELANCHOLIC', 'Kazuko');
INSERT INTO author (age, "password", status, username)
VALUES(58, '$2a$10$PJ28TGRjT.a2MUTnLcylNenDioyLaf5tBN/pApDOVEsQw8.yRQhhq', 'MELANCHOLIC', 'Delta Knapp');
INSERT INTO author (age, "password", status, username)
VALUES(39, '$2a$10$PJ28TGRjT.a2MUTnLcylNenDioyLaf5tBN/pApDOVEsQw8.yRQhhq', 'MELANCHOLIC', 'Dulce');
INSERT INTO author (age, "password", status, username)
VALUES(61, '$2a$10$PJ28TGRjT.a2MUTnLcylNenDioyLaf5tBN/pApDOVEsQw8.yRQhhq', 'MELANCHOLIC', 'Larhonda');
INSERT INTO author (age, "password", status, username)
VALUES(66, '$2a$10$PJ28TGRjT.a2MUTnLcylNenDioyLaf5tBN/pApDOVEsQw8.yRQhhq', 'MELANCHOLIC', 'Youlanda');
INSERT INTO author (age, "password", status, username)
VALUES(60, '$2a$10$PJ28TGRjT.a2MUTnLcylNenDioyLaf5tBN/pApDOVEsQw8.yRQhhq', 'MELANCHOLIC', 'Jani');
INSERT INTO author (age, "password", status, username)
VALUES(51, '$2a$10$PJ28TGRjT.a2MUTnLcylNenDioyLaf5tBN/pApDOVEsQw8.yRQhhq', 'MELANCHOLIC', 'Wayne');
