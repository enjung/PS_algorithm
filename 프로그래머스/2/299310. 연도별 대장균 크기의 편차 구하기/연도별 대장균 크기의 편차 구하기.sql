-- YEAR_DEV : 연도별 가장 크기 큰 대장균 - 개별 대장균 크기
Select
    year(differentiation_date) as YEAR, 
    (MAX(size_of_colony) over (partition by year(differentiation_date)) - size_of_colony) as YEAR_DEV,
    ID
from ecoli_data
order by YEAR asc, YEAR_DEV asc;