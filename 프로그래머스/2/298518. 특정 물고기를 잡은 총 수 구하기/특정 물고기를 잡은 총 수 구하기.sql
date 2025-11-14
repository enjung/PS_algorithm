-- 코드를 작성해주세요
select count(*) as fish_count
from fish_info as i, fish_name_info as n
where i.fish_type = n.fish_type and ( n.fish_name in ('BASS','SNAPPER'))