-- 2번 형질x and (1번 or 3번 형질o)
-- genotype&2=0 : 2번 형질을 안 가짐
-- genotype&5>0 : 1번 혹은 3번 형질을 가짐 
select count(*) as COUNT
from ecoli_data
where (genotype&2=0) and (genotype&5>0);