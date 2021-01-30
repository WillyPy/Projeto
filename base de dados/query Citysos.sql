select * from empresa;
select * from pedido;
select * from ong;
select * from estado_pedido;
select * from tipo_pedido;

# call Stored Procedures
call CountEmpresas();

call CountPedidos();

call CountSubmetidos();

call GetEmpresas();

call GetOngs();

show procedure status where db = 'citysos';