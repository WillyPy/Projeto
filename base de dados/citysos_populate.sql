/*empresas*/
insert into empresa (e_nome) values ('Associação de Apoio Social');
insert into empresa (e_nome) values ('ArteTwanaTwangola');
insert into empresa (e_nome) values ('Obra da Divina Providência');
insert into empresa (e_nome) values ('Naminglite');
insert into empresa (e_nome) values ('Foliency');
insert into empresa (e_nome) values ('Visionline');

/*ongs que tambem são empresas*/
insert into ong (ong_nome, ong_regiao, ong_e_id) values ('AASEA','Benguela ',1);
insert into ong (ong_nome, ong_regiao, ong_e_id) values ('ACATT ','Luanda',2);
insert into ong (ong_nome, ong_regiao, ong_e_id) values ('ODP','Luanda',3);
insert into ong (ong_nome, ong_regiao, ong_e_id) values ('AASEA','Benguela ',1);
/*ongs que não são empresas*/
insert into ong (ong_nome, ong_regiao) values ('ACD ','Uíge');
insert into ong (ong_nome, ong_regiao) values ('ADSCA','L.Norte ');
insert into ong (ong_nome, ong_regiao) values ('USODEMA','L.Norte ');
insert into ong (ong_nome, ong_regiao) values ('OHPA','Benguela');
insert into ong (ong_nome, ong_regiao) values ('AAD','K. Sul');
insert into ong (ong_nome, ong_regiao) values ('AMJKN','K. Norte');

/*tipo de pedido*/
insert into tipo_pedido (tip_ped_nome) values ('Creche');
insert into tipo_pedido (tip_ped_nome) values ('Escola Primaria');
insert into tipo_pedido (tip_ped_nome) values ('Escola Secundaria');
insert into tipo_pedido (tip_ped_nome) values ('Universiade');
insert into tipo_pedido (tip_ped_nome) values ('Biblioteca');

/*estado dos pedidos*/
insert into estado_pedido(est_id, est_estado) values(0,'SUBMETIDO');
insert into estado_pedido(est_id,est_estado) values(1,'Rejeitado');
insert into estado_pedido(est_id,est_estado) values(2,'Rejeitado');

insert into pedido(p_cart_sol, p_ong_id, p_tip_ped_id) values ('
Texto Exemplo de detalhes fornecidos para efectuar um pedido na plataforma
com todos os detalhes necessarios.',5,5);
insert into pedido(p_cart_sol, p_ong_id, p_tip_ped_id) values ('
Texto Exemplo de detalhes fornecidos para efectuar um pedido na plataforma
com todos os detalhes necessarios.',6,3);
insert into pedido(p_cart_sol, p_ong_id, p_tip_ped_id) values ('
Texto Exemplo de detalhes fornecidos para efectuar um pedido na plataforma
com todos os detalhes necessarios.',8,5);
insert into pedido(p_cart_sol, p_ong_id, p_tip_ped_id) values ('
Texto Exemplo de detalhes fornecidos para efectuar um pedido na plataforma
com todos os detalhes necessarios.',2,3);
insert into pedido(p_cart_sol, p_ong_id, p_tip_ped_id) values ('
Texto Exemplo de detalhes fornecidos para efectuar um pedido na plataforma
com todos os detalhes necessarios.',1,4);

insert into empresa_pedido(ep_date,ep_p_id,ep_est_id) values(sysdate(),1,0);
insert into empresa_pedido(ep_date,ep_p_id,ep_est_id) values(sysdate(),2,0);
insert into empresa_pedido(ep_date,ep_p_id,ep_est_id) values(sysdate(),3,0);
insert into empresa_pedido(ep_date,ep_p_id,ep_est_id) values(sysdate(),4,0);
insert into empresa_pedido(ep_date,ep_p_id,ep_est_id) values(sysdate(),5,0);

/*
insert into empresa_pedido(ep_data, ep_e_id, ep_p_id, ep_est_id) values(str_to_date('2020.1.01','%Y.%m.%d'),1,1,0);
*/

/*estados possiveis com o submetido sendo o padrão*/
insert into estado_pedido(est_id,est_estado) values('1','Rejeitado');
insert into estado_pedido(est_id,est_estado) values('2','Rejeitado');
commit;
