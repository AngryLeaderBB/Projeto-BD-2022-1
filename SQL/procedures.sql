USE academia;
DROP PROCEDURE IF EXISTS InverteStatus;
DROP PROCEDURE IF EXISTS resumo_imc;

DELIMITER $$
CREATE PROCEDURE InverteStatus()
BEGIN
	
	DECLARE estado CHAR(1);
	Declare cpf_aux VARCHAR(11);
	DECLARE continua_iterando INT DEFAULT 1;
    
    DECLARE c CURSOR FOR SELECT cpf,Status from Aluno;
    DECLARE CONTINUE HANDLER FOR NOT FOUND SET continua_iterando := 0;
    
	OPEN c;
	WHILE(continua_iterando = 1)DO
		FETCH c INTO cpf_aux,estado;
        
        IF estado = 'A' THEN
			UPDATE Aluno SET Status = 'I' WHERE cpf = cpf_aux;
        
        ELSEIF estado = 'I' THEN
			UPDATE Aluno SET Status = 'A' WHERE cpf = cpf_aux;
		END IF;
    
    END WHILE;

END $$

DELIMITER $$
CREATE PROCEDURE resumo_imc()
BEGIN
	
    DECLARE data_aval DATE;
    DECLARE aluno_cpf VARCHAR(11);
    DECLARE prof_cref VARCHAR(10);
    DECLARE imc_aval DECIMAL(10,2);
    DECLARE done BOOLEAN DEFAULT FALSE;
    
    DECLARE continua_iterando INT DEFAULT 0;
    
	DECLARE cur CURSOR FOR SELECT Data,Professor_cref,Aluno_cpf,Imc from avaliacao_fisica;
	DECLARE CONTINUE HANDLER FOR NOT FOUND SET done := TRUE;
    
	CREATE TABLE tabela_imc(
		situacao VARCHAR(20) NOT NULL PRIMARY KEY,
        qtd_alunos INT NOT NULL
    );
    
    INSERT INTO tabela_imc VALUES("ABAIXO DO PESO",0);
    INSERT INTO tabela_imc VALUES("NORMAL",0);
    INSERT INTO tabela_imc VALUES("SOBREPESO",0);
    INSERT INTO tabela_imc VALUES("OBESIDADE I",0);
    INSERT INTO tabela_imc VALUES("OBESIDADE II",0);
    INSERT INTO tabela_imc VALUES("OBESIDADE III",0);
    
    
    OPEN CUR;
    testLoop: LOOP
		FETCH CUR INTO data_aval,prof_cref,aluno_cpf,imc_aval;

		IF done THEN
			LEAVE testLoop;
		END IF;

        IF imc_aval < 18.50 THEN
			UPDATE tabela_imc SET qtd_alunos = qtd_alunos + 1 WHERE situacao = "ABAIXO DO PESO";
		ELSEIF imc_aval >= 18.50 AND imc_aval < 25.0 THEN
			UPDATE tabela_imc SET qtd_alunos = qtd_alunos + 1 WHERE situacao = "NORMAL";
		ELSEIF (imc_aval >= 25.00 AND imc_aval < 30.00) THEN
			UPDATE tabela_imc SET qtd_alunos = qtd_alunos + 1 WHERE situacao = "SOBREPESO";
		ELSEIF imc_aval >= 30.00 AND imc_aval < 35.00 THEN
			UPDATE tabela_imc SET qtd_alunos = qtd_alunos + 1 WHERE situacao = "OBESIDADE I";
		ELSEIF imc_aval >= 35.0 AND imc_aval < 40.00 THEN
			UPDATE tabela_imc SET qtd_alunos = qtd_alunos + 1 WHERE situacao = "OBESIDADE II";
         ELSE 
			UPDATE tabela_imc SET qtd_alunos = qtd_alunos + 1 WHERE situacao = "OBESIDADE III";
		END IF;
	END LOOP testLoop;
    
	 select * from tabela_imc;

    DROP TABLE tabela_imc;
    
    
END $$

CALL resumo_imc();
call InverteStatus();
select * from Aluno;



