/*empresas*/
insert into empresa (e_nome, e_regiao) values ('Ajuda Lda','cunene');
insert into empresa (e_nome, e_regiao) values ('Ajuda Lda2','luanda');
insert into empresa (e_nome, e_regiao) values ('Ajuda Lda3','namibe');
insert into empresa (e_nome, e_regiao) values ('Ajuda Lda4','zaire');
insert into empresa (e_nome, e_regiao) values ('Ajuda Lda5','lubango');
insert into empresa (e_nome, e_regiao) values ('Ajuda Lda6','luanda');
/*ongs*/
insert into ong (ong_nome, ong_e_id) values ('Ajudante Lda',1);
insert into ong (ong_nome, ong_e_id) values ('Ajudante Lda',2);
insert into ong (ong_nome, ong_e_id) values ('Ajudante Lda',3);
insert into ong (ong_nome, ong_e_id) values ('Ajudante Lda',4);
insert into ong (ong_nome, ong_e_id) values ('Ajudante Lda',5);
insert into ong (ong_nome, ong_e_id) values ('Ajudante Lda',6);

/*estado dos pedidos*/
insert into estado_pedido(est_id, est_estado) values(0,'SUBMETIDO');

/*tipo de pedido*/
insert into tipo_pedido (tip_ped_id, tip_ped_nome) values (0,'Creche');
insert into tipo_pedido (tip_ped_id, tip_ped_nome) values (1,'Escola Primaria');
insert into tipo_pedido (tip_ped_id, tip_ped_nome) values (2,'Escola Secundaria');
insert into tipo_pedido (tip_ped_id, tip_ped_nome) values (3,'Universiade');
insert into tipo_pedido (tip_ped_id, tip_ped_nome) values (4,'Biblioteca');


/*pedidos
insert into pedido (p_tipo, p_cart_sol, p_ong_id, p_tip_ped_nome) values ('example','example',1,);
*/

/*
insert into empresa_pedido(ep_data, ep_e_id, ep_p_id, ep_est_id) values(str_to_date('2020.1.01','%Y.%m.%d'),1,1,0);
*/
commit;
