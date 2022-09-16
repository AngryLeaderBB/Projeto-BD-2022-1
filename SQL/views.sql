use academia;
drop view if exists view_tempo_treino;
drop view if exists view_contagem_empresa;
drop view if exists view_pessoas;


-- Obtendo todas as pessoas do banco, tanto físicas quanto jurídicas;
create view view_pessoas as
select cpf as 'CPF_CNPJ',nome, 'fisica' as tipo, telefone from gerente
union
select cpf as 'CPF_CNPJ',nome, 'fisica' as tipo, telefone  from professor
union
select cpf as 'CPF_CNPJ',nome, 'fisica' as tipo, telefone  from aluno
union
select cnpj as 'CPF_CNPJ',nome_empresa as 'nome','juridica' as tipo, telefone from fornecedor;

select * from view_pessoas;


-- Obter a soma das tempo de treino passados por cada professor para seus alunos,
--  apresentada em ordem ascendente.
create view view_tempo_treino as 
select Nome,Professor_cref,sum(Duracao) from 
	(select Nome,Treino.*
	from Professor,Treino
	where treino.Professor_cref = Professor.cref) as tab
group by nome
order by sum(Duracao) ASC;

select * from view_tempo_treino;


-- Obter nome da empresa e quantos equipamentos ela já forneceu, só devem aparecer empresas que já vendeu
-- mais de um produto e cujo tamanho do nome seja maior que 8. A tabela deve possuir os dados ordenados 
-- pelo nome da empresa, usando ordem lexicográfica decrescente;

create view view_contagem_empresa  as
select Nome_empresa,count(*) AS Contagem
from fornecedor,equipamento
where fornecedor.cnpj = fornecedor_cnpj AND LENGTH(Nome_empresa) > 8
group by Nome_empresa
having count(*) > 1
order by Nome_empresa DESC;

select * from view_contagem_empresa;








        