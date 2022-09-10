USE academia;

INSERT INTO gerente  VALUES ("56193761330", "Oliver Bernardo Jose Silveira", 20000.00, 'M', "8426048482", "1999-06-24");
INSERT INTO plano VAlUES(0, 100.00, 25,  100.00);
INSERT INTO aluno  VALUES ("85331284523", "275707921", "1969-01-06", "Benjamin Kaue Ricardo Viana", "M", "6839191813", "A", null);
INSERT INTO contrato VAlUES(0, "2022-09-09", "85331284523", "56193761330", 0);
INSERT INTO professor VALUES("7291588812", "47291588812", "musculacao",  "496637836", "1979-09-05", "Benicio Miguel Fogaca", 30, 10000.00, "M", "4329475147");
INSERT INTO fornecedor VALUES("34035257000109", "BryanBreno LM", "6137620235");
INSERT INTO modelo_equipamento VALUES ("esteira");
INSERT INTO equipamento VALUES(0, "Rapidex", "esteira", "34035257000109");

UPDATE aluno
SET foto = load_file("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/giga.png")
WHERE cpf = "85331284523"; 

# Ver o local na memoria atual
# select @@GLOBAL.secure_file_priv;
# Ver se o arquivo eh lido
# select load_file("C:/ProgramData/MySQL/MySQL Server 8.0/Uploads/giga.png");

SELECT * FROM gerente;
SELECT * FROM plano;
SELECT * FROM aluno;
SELECT * FROM contrato;
SELECT * FROM professor;
SELECT * FROM fornecedor;
SELECT * FROM modelo_equipamento;
SELECT * FROM equipamento;