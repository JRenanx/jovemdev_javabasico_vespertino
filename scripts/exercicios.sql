--1. Selecionar todos os registros e atributos da entidade cargo.--
select *
from cargo;

--2. Selecionar e a quantidade de vereadores da entidade cidade, ordenado pelo nome da cidade.
select nome, qt_vereadores 
from cidade 
order by nome ;

--3. Selecionar e a quantidade de vereadores da entidade cidade, somente das cidades que possuem mais de 9 vereadores.
select nome, qt_vereadores 
from cidade 
where qt_vereadores >9 ;

--4. Selecionar quantas cidades possuem mais de 9 vereadores
select count(*) 
from cidade 
where qt_vereadores >9

--5. Selecionar a quantidade máxima de vereadores que uma cidade possui.
select max(qt_vereadores) 
from cidade;

--6. Selecionar o nome da cidade que possui mais vereadores.
select nome 
from cidade 
where qt_vereadores = (select max(qt_vereadores) from cidade);

--7. Selecionar o nome dos candidatos a prefeito ordenados pelo nome.
select c.nome,cargo.nome 
from candidato c 
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Prefeito' 
order by c.nome;

--8. Selecionar o nome dos candidatos a vereador que possuem "maria" no nome ordenados pelo nome.
select c.nome 
from candidato c 
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador'
where c.nome like '%MARIA%' 
order by c.nome ;

--9. Selecionar o nome dos candidatos a vereador que iniciam com 'Y' - ordenado pelo nome.
select c.nome 
from candidato c 
inner join cargo on cargo.id = c.cargo and cargo.nome = 'Vereador' 
where c.nome 
like 'Y%' 
order by c.nome;

--10. Selecionar o nome dos candidatos a prefeito de cada cidade, ordenado pelo nome da cidade e em seguida pelo nome do candidato.
select cidade.nome , candidato.nome candidato 
from cidade 
inner join candidato on candidato.cidade = cidade.id
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
order by cidade.nome, candidato.nome;

--11. Selecionar o nome dos candidatos a prefeito da cidade de 'TUBARÃO', ordenado pelo nome do candidato.
select c.nome 
from candidato c
inner join cidade ci on ci.id = c.cidade and ci.nome = 'TUBARÃO'
inner join cargo ca on ca.id = c. cargo and ca.nome = 'Prefeito' 
order by c.nome;

--12. Selecionar o nome dos candidatos a prefeito da cidade que tem o maior número de eleitores.
select cidade.nome, candidato.nome
from candidato 
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
inner join cidade on cidade.id = candidato.cidade and cidade.qt_eleitores = (select max( qt_eleitores) from cidade);

--13. Selecionar a quantidade de candidatos a vereador da cidade de 'TUBARÃO’.
select cidade.nome, candidato.nome
from candidato 
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Vereador'
inner join cidade on cidade.id = candidato.cidade and cidade.qt_eleitores = (select max( qt_eleitores) from cidade);


--14. Selecionar a quantidade de candidatos a vereador de cada cidade, ordenado pelo nome da cidade.
select cidade.nome, count(*) from  candidato
inner join cargo  on cargo.id = candidato.cargo and cargo.nome = 'Vereador'
inner join cidade on cidade.id = candidato.cidade
group by cidade.nome order by cidade.nome;

--15. Selecionar a quantidade de votos nulos e brancos para prefeito e para vereador da cidade de Tubarão.
select cargo.nome, vi.nulos, vi.brancos
from cargo
inner join voto_invalido vi on vi.cargo = cargo.id
inner join cidade on cidade.id = vi.cidade and cidade.nome = 'TUBARÃO';

--16. Selecionar a quantidade de votos INVÁLIDOS (BRANCOS + NULOS) para prefeito da cidade de Tubarão.
select vi.nulos + vi.brancos as total
from cargo
inner join voto_invalido vi on vi.cargo = cargo.id and cargo.nome = 'Prefeito'
inner join cidade on cidade.id = vi.cidade and cidade.nome = 'TUBARÃO';

--17. Selecionar a quantidade de votos válidos para cada candidato a prefeito da cidade de Tubarão, ordenados pela maior quantidade de votos.
select candidato.nome, voto.voto as votos
from candidato
inner join voto on voto.candidato = candidato.id
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
order by votos desc;

--18. Selecionar a quantidade de votos válidos para CADA candidato a vereador da cidade de Tubarão ordenados pela maior quantidade de votos.
select candidato.nome, voto.voto as votos
from candidato
inner join voto on voto.candidato = candidato.id
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Vereador'
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
order by votos desc;

--19. Selecionar a maior quantidade de votos para prefeito de cada cidade.
select cidade.nome, max(voto.voto)
from cidade 
inner join candidato on candidato.cidade = cidade.id
inner join voto on voto.candidato = candidato.id
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
group by cidade.nome;

--20. Selecionar os partidos e a quantidade de votos de cada um na cidade de Tubarão ordenados pela maior quantidade de votos.
select partido.sigla, sum(voto.voto) as votos
from partido
inner join candidato on candidato.partido = partido.id
inner join cidade on cidade.id = candidato.cidade and cidade.nome = 'TUBARÃO'
inner join voto on voto.candidato = candidato.id
group by partido.sigla
order by votos desc;

--21. Selecionar a quantidade de votos registrados para prefeito na cidade de tubarão. Os votos registrados são considerados os votos para os candidatos, mais os votos brancos e nulos
select cidade.nome, sum(voto.voto) + (select vi.nulos + vi.brancos from voto_invalido vi where cargo.id = vi.cargo and vi.cidade = cidade.id) as votos
from cidade
inner join candidato on candidato.cidade = cidade.id and cidade.nome = 'TUBARÃO'
inner join voto on voto.candidato = candidato.id
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
group by cidade.nome, cargo.id, cidade.id;

--22. Selecionar a quantidade de eleitores que deixaram de votar na cidade de tubarão.
       
select (select c.qt_eleitores 
from cidade c 
where c.nome = 'TUBARÃO') -
        ((select sum (v.voto)
        from voto v
        inner join candidato cand on cand.id = v.candidato 
        inner join cidade c on c.id = cand.cidade  and c.nome = 'TUBARÃO'
        inner join cargo on cargo.id = cand.cargo and cargo.id = cand.cargo and cargo.nome ='Prefeito') +
                (select (vi.brancos + vi.nulos)
                FROM voto_invalido vi
                inner join cargo on cargo.id = vi.cargo and cargo.nome = 'Prefeito'
                inner join cidade c on c.id = vi.cidade and c.nome = 'TUBARÃO'))  as nao_votantes;

--23. Selecionar a quantidade de eleitores que deixaram de votar em cada cidade, ordenado pela maior quantidade de faltantes.
select c.nome, c.qt_eleitores - 
  (
    (SELECT COALESCE(SUM(v.voto), 0)
    FROM voto v
    INNER JOIN candidato cand ON cand.id = v.candidato 
    INNER JOIN cidade ci ON ci.id = cand.cidade
    INNER JOIN cargo ON cargo.id = cand.cargo AND cargo.nome = 'Prefeito'
    WHERE ci.id = c.id)
    +
    (SELECT COALESCE(SUM(vi.brancos + vi.nulos), 0)
    FROM voto_invalido vi
    INNER JOIN cargo ON cargo.id = vi.cargo AND cargo.nome = 'Prefeito'
    WHERE vi.cidade = c.id)
  ) AS abstencoes 
FROM cidade c;

--24. Selecionar o percentual de faltantes em cada cidade, ordenado pelo maior percentual.
select cidade.nome, (cidade.qt_eleitores - (sum(voto.voto) + (select vi.nulos + vi.brancos from voto_invalido vi where cargo.id = vi.cargo and vi.cidade = cidade.id))) * 100 / cidade.qt_eleitores as votos
from cidade
inner join candidato on candidato.cidade = cidade.id
inner join voto on voto.candidato = candidato.id
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
group by cidade.nome, cargo.id, cidade.id
order by votos desc;

--25. Selecionar o candidato a prefeito eleito de cada cidade, ordenado pelo nome da cidade.
select cidade.nome, candidato.nome
from cidade
inner join candidato on candidato.cidade = cidade.id
inner join voto on voto.candidato = candidato.id
inner join cargo on cargo.id = candidato.cargo and cargo.nome = 'Prefeito'
group by cidade.nome, candidato.nome, voto.voto,cidade.id 
having voto.voto = (
    select max(v.voto)
    from voto as v
    inner join candidato as c on v.candidato = c.id
    inner join cargo as cg on cg.id = c.cargo and cg.nome = 'Prefeito'
    where c.cidade = cidade.id
)
order by cidade.nome asc;