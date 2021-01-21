insert into empresa (e_id, e_nome, e_regiao) values (1,'Ajuda Lda','Zango');

insert into ong (ong_id, ong_nome, ong_e_id) values (1,'Ajudante Lda',1);

insert into tipo_pedido (tip_ped_id, tip_nome) values (1,'Construção');

insert into pedido (p_id, ped_tipo, ped_cart_sol, pedido_e_id, pedido_ong_id, pedido_tip_ped_id) values ('example','example',1,1,1);