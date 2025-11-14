-- 성분별로 그룹, 성분별 총주문량
select b.ingredient_type, sum(a.total_order) as total_order
from first_half a, icecream_info b
where a.flavor = b.flavor
group by b.ingredient_type
order by total_order asc;