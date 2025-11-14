select f.id, n.fish_name, f.length
from fish_info f
-- name 테이블과 조인
join fish_name_info n
    on n.fish_type = f.fish_type
    -- info 테이블에서 해당 타입의 max 길이라면
where f.length = (
    select max(length)
    from fish_info
    where f.fish_type = fish_info.fish_type
)
order by f.id asc;