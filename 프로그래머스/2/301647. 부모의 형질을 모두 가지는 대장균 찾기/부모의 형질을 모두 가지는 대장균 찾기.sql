-- 부모의 genotype과 &연산
select child.id, child.genotype, parent.genotype as parent_genotype
from ecoli_data child
join ecoli_data parent
    on parent.id = child.parent_id and (parent.genotype&child.genotype)=parent.genotype   
order by child.id asc;
