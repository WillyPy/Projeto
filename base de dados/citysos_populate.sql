insert into empresa (e_nome, e_regiao) values ('Ajuda Lda','Zango');
insert into estado_pedido(est_id, est_estado) values(0,'SUBMETIDO');
insert into ong (ong_nome, ong_e_id) values ('Ajudante Lda',1);
insert into tipo_pedido (tip_nome) values ('Construção');
insert into pedido (p_tipo, p_cart_sol, p_ong_id, p_tip_ped_id) values ('example','example',1,1);
insert into empresa_pedido(ep_data, ep_e_id, ep_p_id, ep_est_id) values(str_to_date('2020.1.01','%Y.%m.%d'),1,1,0);
commit;