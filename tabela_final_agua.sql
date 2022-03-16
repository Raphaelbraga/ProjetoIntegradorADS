create database leituraagua;
use leituraagua;
-- ----------------------------------------------------------------------------------------------------------------------

----- TABELA DE CADASTRO DE CLIENTES -----

CREATE TABLE cliente (
  id_cliente int(8) AUTO_INCREMENT NOT NULL primary KEY,
  nome varchar(45) NOT NULL,
  cpf varchar(12) NOT NULL,
  contato varchar(20) NOT NULL,
  data_de_nascimento date NOT NULL
  );
  
-- INSERÇÃO --  
 INSERT INTO cliente( nome, cpf, contato, data_de_nascimento) VALUES ("cleumar","07507022900","(45) 99929-8929", "880118") ;
 INSERT INTO cliente( nome, cpf, contato, data_de_nascimento) VALUES ("guilherme","2222222222","(45) 992222222", "880119") ; 
 INSERT INTO cliente( nome, cpf, contato, data_de_nascimento) VALUES ("maria","07507022900","(45) 9933333333", "880120") ; 
 
 -- ALTERAÇÃO --
 UPDATE cliente
 set nome = 'vinicius'
 where id_cliente = 4;

-- CONSULTA -- 
select id_cliente, nome
from cliente;

-- DELETE --
delete from cliente where id_cliente = 1;
delete from cliente where id_cliente = 2;
-- ----------------------------------------------------------------------------------------------------------------------

----- TABELA DE CADASTRO DE DISTRITOS -----

  CREATE TABLE distrito (
  id_distrito int NOT NULL primary key,
  nome varchar(45) NOT NULL
  );
  
-- INSERÇÃO --  
 INSERT INTO distrito(id_distrito, nome) values (01 , "novo sobradinho");
 INSERT INTO distrito(id_distrito, nome) values (02 , "vila nova");
 INSERT INTO distrito(id_distrito, nome) values (03 , "novo sarandi");
 INSERT INTO distrito(id_distrito, nome) values (04 , "concordia");
 INSERT INTO distrito(id_distrito, nome) values (05 , "xaxim");
 
-- ALTERAÇÃO --
UPDATE distrito
set nome = 'bom princípio'
where id_distrito = 3;

-- CONSULTA --
select id_distrito, nome
from distrito;

-- DELETE -- 
delete from distrito where id_distrito = 4;
delete from distrito where id_distrito = 5; 
-- ----------------------------------------------------------------------------------------------------------------------

----- TABELA DE CADASTRO DE ENDEREÇOS -----
  
  CREATE TABLE endereco (
  id_endereco int NOT NULL primary key,
  rua varchar(45) NOT NULL,
  numero int(4) NOT NULL,
  cep int (8) NOT NULL,
  complemento varchar(200) NOT NULL
  );

-- INSERÇÃO --    
INSERT INTO endereco(id_endereco, rua, numero, cep, complemento) values (01 , "Leonardo Francisco Nogueira", 536, 85903450, "casa");
INSERT INTO endereco(id_endereco, rua, numero, cep, complemento) values (02 , "Leonardo Francisco Nogueira", 538, 85903450, "apartamento");
INSERT INTO endereco(id_endereco, rua, numero, cep, complemento) values (03 , "Leonardo Francisco Nogueira", 540, 85903450, "sobrado"); 
 
-- ALTERAÇÃO --
UPDATE endereco
set rua = 'rua maringa'
where id_endereco = 2;

-- CONSULTA -- 
select id_endereco, rua
from endereco;  

-- DELETE --
delete from endereco where id_endereco = 1;
delete from endereco where id_endereco = 2;
 -- ----------------------------------------------------------------------------------------------------------------------
 
----- TABELA DE FATURA -----

  CREATE TABLE fatura (
  id_fatura int NOT NULL primary key,
  valor_m³ decimal(5,2) NOT NULL,
  consumo_total decimal(4,2) NOT NULL,
  taxa_administrativa decimal(5,2) NOT NULL,
  leitura_anterior decimal(4,2) NOT NULL,
  leitura_atual decimal(4,2) NOT NULL
  );
  
-- INSERÇÃO --  
INSERT INTO fatura(id_fatura, valor_m³, consumo_total, taxa_administrativa, leitura_anterior, leitura_atual) values (01 , '1.70',  12, '10.00', '12.00', '24.00'); 
INSERT INTO fatura(id_fatura, valor_m³, consumo_total, taxa_administrativa, leitura_anterior, leitura_atual) values (02 , '1.70',  15, '10.00', '10.00', '25.00'); 
INSERT INTO fatura(id_fatura, valor_m³, consumo_total, taxa_administrativa, leitura_anterior, leitura_atual) values (03 , '1.70',  20, '10.00', '20.00', '40.00'); 

-- ALTERAÇÃO -- 
UPDATE fatura
set consumo_total = 17
where id_fatura = 2;

-- CONSULTA --
select id_fatura, consumo_total
from fatura;

-- DELETE -- 
delete from fatura where id_fatura = 1;
delete from fatura where id_fatura = 3;
-- ----------------------------------------------------------------------------------------------------------------------

----- TABELA DE CADASTRO DE GASTOS -----
  
  CREATE TABLE gastos (
  id_gastos int NOT NULL primary key,
  energia_eletrica decimal(5,2) NOT NULL
  );
 
-- INSERÇÃO --  
INSERT INTO gastos (id_gastos, energia_eletrica) values (01, '12.25');
INSERT INTO gastos (id_gastos, energia_eletrica) values (02, '10.68');
INSERT INTO gastos (id_gastos, energia_eletrica) values (03, '18.25');

-- ALTERAÇÃO --  
UPDATE gastos
set energia_eletrica = 15.50
where id_gastos = 2;

-- CONSULTA -- 
select id_gastos, energia_eletrica
from gastos;

-- DELETE --
delete from gastos where id_gastos = 1;
delete from gastos where id_gastos = 2;
-- ----------------------------------------------------------------------------------------------------------------------

----- TABELA DE CADASTRO DE HIDROMETRO -----
  
  CREATE TABLE hidrometro (
  id_hidrometro int(5) AUTO_INCREMENT NOT NULL primary KEY,
  numero_de_serie int NOT NULL,
  leitura_inicial decimal(4,2) NOT NULL,
  situacao binary(1) NOT NULL
  );
  
-- INSERÇÃO --  
INSERT INTO hidrometro(numero_de_serie, leitura_inicial, situacao) values(1425, '00.00', 1);
INSERT INTO hidrometro(numero_de_serie, leitura_inicial, situacao) values(1426, '00.00', 1);
INSERT INTO hidrometro(numero_de_serie, leitura_inicial, situacao) values(1427, '00.00', 1);

-- ALTERAÇÃO --  
UPDATE hidrometro
set situacao = 0
where id_hidrometro = 2;

-- CONSULTA -- 
select id_hidrometro, situacao
from hidrometro;

-- DELETE --
delete from hidrometro where id_hidrometro = 2;
delete from hidrometro where id_hidrometro = 3;
-- ----------------------------------------------------------------------------------------------------------------------
  
----- TABELA DE CADASTRO LEITURISTA-----
  
  CREATE TABLE leiturista (
  id_leiturista int(5) AUTO_INCREMENT NOT NULL primary KEY,
  nome varchar(45) NOT NULL,
  cpf varchar(11) NOT NULL,
  contato varchar(20) NOT NULL
  );
  
-- INSERÇÃO --  
INSERT INTO leiturista(nome, cpf, contato) values("leandro", "0589677895", "(45)99978-9678");
INSERT INTO leiturista(nome, cpf, contato) values("joão", "058985694", "(45)99985-8965");
INSERT INTO leiturista(nome, cpf, contato) values("josé", "078952149", "(45)99974-5874");
 
-- ALTERAÇÃO --
UPDATE leiturista
set contato = "(45) 99974-6325"
where id_leiturista = 3;

-- CONSULTA -- 
select id_leiturista, contato
from leiturista;

-- DELETE --
delete from leiturista where id_leiturista = 1;
delete from leiturista where id_leiturista = 4;
-- ----------------------------------------------------------------------------------------------------------------------
  
----- TABELA DE CADASTRO LOGIN -----
  
  CREATE TABLE login (
  id_login int(5) AUTO_INCREMENT NOT NULL primary KEY,
  usuario int(11) NOT NULL,
  senha int(6) NOT NULL
  );
  
-- INSERÇÃO --  
INSERT INTO login(usuario, senha) values(0587677895, 881210);
INSERT INTO login(usuario, senha) values(0585455552, 572254);
INSERT INTO login(usuario, senha) values(0455842542, 748524);
 
-- ALTERAÇÃO --
UPDATE login
set senha = 000000
where id_login = 1;

-- CONSULTA -- 
select id_login, senha, usuario
from login;

-- DELETE --
delete from login where id_login = 1;
delete from login where id_login = 4;
-- ----------------------------------------------------------------------------------------------------------------------
  
----- TABELA DE CADASTRO DE POÇOS -----

CREATE TABLE poco (
  id_poco int(5) AUTO_INCREMENT NOT NULL primary KEY,
  unidade_consumidora int(5) NOT NULL
  );
  
-- INSERÇÃO --  
INSERT INTO poco(unidade_consumidora) value (458968);
INSERT INTO poco(unidade_consumidora) value (458852);
INSERT INTO poco(unidade_consumidora) value (458544);
  
-- ALTERAÇÃO --
UPDATE poco
set unidade_consumidora = 888888
where id_poco = 5;

-- CONSULTA -- 
select id_poco, unidade_consumidora
from poco;

-- DELETE --
delete from poco where id_poco = 1;
delete from poco where id_poco = 2;
delete from poco where id_poco = 3;
delete from poco where id_poco = 4;

