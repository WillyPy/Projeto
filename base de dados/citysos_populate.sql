/*empresas*/
insert into empresa (e_nome) values ('Ajuda Lda');
insert into empresa (e_nome) values ('Ajuda Lda2');
insert into empresa (e_nome) values ('Ajuda Lda3');
insert into empresa (e_nome) values ('Ajuda Lda4');
insert into empresa (e_nome) values ('Ajuda Lda5');

/*ongs*/
insert into ong (ong_nome, ong_regiao, ong_e_id) values ('Ajuda Lda','cunene',1);
insert into ong (ong_nome, ong_regiao, ong_e_id) values ('Ajuda Lda2','luanda',2);
insert into ong (ong_nome, ong_regiao, ong_e_id) values ('Ajuda Lda3','namibe',3);
insert into ong (ong_nome, ong_regiao, ong_e_id) values ('Ajuda Lda4','zaire',4);
insert into ong (ong_nome, ong_regiao, ong_e_id) values ('Ajuda Lda5','lubango',5);

/*estado dos pedidos*/
insert into estado_pedido(est_id, est_estado) values(0,'SUBMETIDO');

/*tipo de pedido*/
insert into tipo_pedido (tip_ped_nome) values ('Creche');
insert into tipo_pedido (tip_ped_nome) values ('Escola Primaria');
insert into tipo_pedido (tip_ped_nome) values ('Escola Secundaria');
insert into tipo_pedido (tip_ped_nome) values ('Universiade');
insert into tipo_pedido (tip_ped_nome) values ('Biblioteca');


insert into pedido(p_cart_sol, p_ong_id, p_tip_ped_id) values ('example',1,1);
insert into pedido(p_cart_sol, p_ong_id, p_tip_ped_id) values ('example2',2,2);
insert into pedido(p_cart_sol, p_ong_id, p_tip_ped_id) values ('example3',3,3);
insert into pedido(p_cart_sol, p_ong_id, p_tip_ped_id) values ('example4',4,4);
insert into pedido(p_cart_sol, p_ong_id, p_tip_ped_id) values ('example5',5,5);



/*
insert into empresa_pedido(ep_data, ep_e_id, ep_p_id, ep_est_id) values(str_to_date('2020.1.01','%Y.%m.%d'),1,1,0);
*/
commit;
