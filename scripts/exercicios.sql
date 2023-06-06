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
select nome from cidade where qt_vereadores = (select max(qt_vereadores) from cidade);

--7. Selecionar o nome dos candidatos a prefeito ordenados pelo nome.
select c.nome,cargo.nome from candidato c inner join cargo on cargo.id = c.cargo and cargo.nome = 'Prefeito' order by c.nome;

--8. Selecionar o nome dos candidatos a vereador que possuem "maria" no nome ordenados pelo nome.
select c.nome from candidato c 
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereeador'
where c.nome like '%MARIA %' 
order by c.nome ;

--9. Selecionar o nome dos candidatos a vereador que iniciam com 'Y' - ordenado pelo nome.
select c.nome from candidato c 
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador' 
where c.nome like 'Y%' 
order by c.nome;

--10. Selecionar o nome dos candidatos a prefeito de cada cidade, ordenado pelo nome da cidade e em seguida pelo nome do candidato.
select cidade.nome , candidato.nome candidato from cidade inner join candidato on candidato.cidade = cidade.id
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
order by cidade.nome, candidato.nome;

--11. Selecionar o nome dos candidatos a prefeito da cidade de 'TUBARÃO', ordenado pelo nome do candidato.
select c.nome from candidato c
inner join cidade ci on ci.id = c.cidade
inner join cargo ca on ca.id = c. cargo and ca.nome = 'Prefeito' and ci.nome = 'TUBARÃO' order by c.nome;

--12. Selecionar o nome dos candidatos a prefeito da cidade que tem o maior número de eleitores.
select c.nome from candidato c inner join cidade ci on c.id = c.cargo and c.nome = 'Prefeito';

--13. Selecionar a quantidade de candidatos a vereador da cidade de 'TUBARÃO’.
select count(*)from candidato c inner join cidade ci on ci.id = c.cargo and c.nome = 'Vereador';

--14. Selecionar a quantidade de candidatos a vereador de cada cidade, ordenado pelo nome da cidade.

--15. Selecionar a quantidade de votos nulos e brancos para prefeito e para vereador da cidade de Tubarão.
select sum(vi.brancos) as brancos, sum(vi.nulos) as nulos from voto_invalido vi inner join cidade ci on ci.id = vi.cidade;

--16. Selecionar a quantidade de votos INVÁLIDOS (BRANCOS + NULOS) para prefeito da cidade de Tubarão.

--17. Selecionar a quantidade de votos válidos para cada candidato a prefeito da cidade de Tubarão, ordenados pela maior quantidade de votos.

--18. Selecionar a quantidade de votos válidos para CADA candidato a vereador da cidade de Tubarão ordenados pela maior quantidade de votos.

--19. Selecionar a maior quantidade de votos para prefeito de cada cidade.

--20. Selecionar os partidos e a quantidade de votos de cada um na cidade de Tubarão ordenados pela maior quantidade de votos.

--21. Selecionar a quantidade de votos registrados para prefeito na cidade de tubarão. Os votos registrados são considerados os votos para os candidatos, mais os votos brancos e nulos

--22. Selecionar a quantidade de eleitores que deixaram de votar na cidade de tubarão

--23. Selecionar a quantidade de eleitores que deixaram de votar em cada cidade, ordenado pela maior quantidade de faltantes.

--24. Selecionar o percentual de faltantes em cada cidade, ordenado pelo maior percentual.

--25. Selecionar o candidato a prefeito eleito de cada cidade, ordenado pelo nome da cidade.