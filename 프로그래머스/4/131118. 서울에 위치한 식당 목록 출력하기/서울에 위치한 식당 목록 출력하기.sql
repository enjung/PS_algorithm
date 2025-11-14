-- 서울 식당 필터링 -> 식당별로 그룹화
SELECT ri.rest_id, ri.rest_name, ri.food_type, ri.favorites, ri.address, round(avg(rr.review_score),2) as score
from rest_info as ri
    join rest_review as rr
    on ri.rest_id = rr.rest_id
where ri.address LIKE('서울%')
group by ri.rest_id,
    ri.rest_name,
    ri.food_type,
    ri.favorites,
    ri.address
order by score desc, ri.favorites desc