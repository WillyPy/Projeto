select * from empresa Join ong where e_id=ong_id;
select * from pedido;
select * from ong;
select * from estado_pedido;
select * from tipo_pedido;
select * from empresa_pedido;
select sysdate();

Update tipo_pedido
set tip_ped_nome = 'Universidade'
where tip_ped_id = '4';

#Mostrar todos pedidos com o seu tipo e o nome da ong
SELECT  p_id AS id, p_cart_sol AS carta, ong_nome AS ong, b.tip_ped_nome AS tipoPedido
FROM   tipo_pedido b
JOIN pedido a 
ON b.tip_ped_id = a.p_tip_ped_id
JOIN ong c
ON a.p_ong_id = c.ong_id
ORDER BY p_id;

#Mostrar todos pedidos com o seu tipo, o estado e a ong
Select p_id AS pedidoid, p_cart_sol AS detalhes, ong_nome AS ong, tip_ped_nome AS tipo, est_estado AS estado
from empresa_pedido a, estado_pedido, pedido, ong, tipo_pedido 
where ep_data =(select Max(ep_data) from empresa_pedido where ep_p_id=a.ep_p_id)
And est_id= ep_est_id
And p_id=ep_p_id
AND ong_id=p_ong_id
ANd tip_ped_id=p_tip_ped_id
Order by p_id
;

#Mostrar todos pedidos feitos por uma determinada ong
SELECT p_id AS id, p_cart_sol AS carta, ong_nome AS ong, b.tip_ped_nome AS tipoPedido
FROM tipo_pedido b, pedido a, ong
WHERE b.tip_ped_id = a.p_tip_ped_id AND a.p_ong_id = ong_id
AND ong_id = 8
ORDER BY p_id;

# call Stored Procedures
call CountEmpresas();

call CountPedidos();

call CountSubmetidos();

call GetEmpresas();

call GeempresatOngs();

show procedure status where db = 'citysos';