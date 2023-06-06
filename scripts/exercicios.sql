--1. Selecionar todos os registros e atributos da entidade cargo.--
select *from cargo;

--2. Selecionar e a quantidade de vereadores da entidade cidade, ordenado pelo nome da cidade.
select nome, qt_vereadores from cidade order by nome ;

--3. Selecionar e a quantidade de vereadores da entidade cidade, somente das cidades que possuem mais de 9 vereadores.
select nome, qt_vereadores from cidade where qt_vereadores >9 ;

--4. Selecionar quantas cidades possuem mais de 9 vereadores
select count(*) from cidade where qt_vereadores >9

--5. Selecionar a quantidade máxima de vereadores que uma cidade possui.
select max(qt_vereadores) from cidade;

--6. Selecionar o nome da cidade que possui mais vereadores.
select nome from cidade where qt_vereadores = 23;

--7. Selecionar o nome dos candidatos a prefeito ordenados pelo nome.
select * from candidato c order by c.nome;

--8. Selecionar o nome dos candidatos a vereador que possuem "maria" no nome ordenados pelo nome.
select * from candidato c where  nome like 'MARIA%' order by nome ;

--9. Selecionar o nome dos candidatos a vereador que iniciam com 'Y' - ordenado pelo nome.
select * from candidato c  where nome like 'Y%' order by nome;

--10. Selecionar o nome dos candidatos a prefeito de cada cidade, ordenado pelo nome da cidade e em seguida pelo nome do candidato.
select *from cidade , candidato  where ; 