DELETE FROM T_USUARIOS;
INSERT INTO T_USUARIOS (TU_USER_ID,TU_APELLIDO,TU_NOMBRE,TU_MAIL,TU_CELULAR,TU_LOGIN,TU_PASSWORD,TU_LEGAJO) VALUES (1, 'sDavid','Schwarz','davidschwarz@gmail.com',11111111,'sDavid','$2y$10$FjoDm3ua0BXdj4sBRCYf4O6OWwaciDv07/8AAcCFBdKr8dC/StWaO',1);

CREATE TABLE IF NOT EXISTS grupo_participante(ID_GRUPO INT NOT NULL,
                                ID_PARTICIPANTE INT NOT NULL,
                            FOREIGN KEY (ID_GRUPO)  REFERENCES GRUPO(ID_GRUPO) ,
                            FOREIGN KEY (ID_PARTICIPANTE) REFERENCES PARTICIPANTE(ID_PARTICIPANTE)
);





