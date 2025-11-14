select distinct child.item_id, child.item_name, child.rarity
from item_info parent
join item_tree t
    on parent.item_id = t.parent_item_id
join item_info child
    on child.item_id = t.item_id
where parent.rarity = 'RARE'
order by child.item_id desc;