select * from empresa Join ong where e_id=ong_id
;
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
SELECT  p_id AS id, p_cart_sol AS carta, ong_nome AS ong, b.tip_ped_nome AS tipoPedido, est_estado AS estado
FROM   tipo_pedido b
JOIN pedido a 
ON b.tip_ped_id = a.p_tip_ped_id
JOIN ong c
ON a.p_ong_id = c.ong_id
JOIN empresa_pedido d
ON a.p_id = d.ep_p_id
JOIN estado_pedido e
ON e.est_id = d.ep_est_id
ORDER BY p_id;

#Mostrar todos pedidos com o seu tipo e o nome da ong
SELECT  p_id AS id, p_cart_sol AS carta, ong_nome AS ong, b.tip_ped_nome AS tipoPedido, est_estado AS estado
FROM   tipo_pedido b, pedido a, ong c, empresa_pedido d, estado_pedido e
WHERE b.tip_ped_id = a.p_tip_ped_id
AND a.p_ong_id = c.ong_id
AND a.p_id = d.ep_p_id
AND	e.est_id = d.ep_est_id
ORDER BY p_id;

# call Stored Procedures
call CountEmpresas();

call CountPedidos();

call CountSubmetidos();

call GetEmpresas();

call GeempresatOngs();

show procedure status where db = 'citysos';