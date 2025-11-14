-- 길이순 정렬 후 상위 10개만 출력
select id, length
from fish_info
order by length desc, id asc
limit 10;
