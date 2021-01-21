create database citysos;
#drop database citysos;
use citysos;

create table empresa (e_id int not null auto_increment,
						e_nome varchar(30) not null,
                        e_regiao varchar(30) not null,
                        primary key (e_id));
create table pedido (p_id int not null auto_increment,
						ped_tipo varchar(30) not null,
						ped_cart_sol varchar(30) not null,
						pedido_e_id int not null,
						pedido_ong_id int not null,
                        pedido_tip_ped_id int not null,
						primary key (p_id));
create table ong(ong_id int not null auto_increment,
				ong_nome varchar(30) not null,
                ong_e_id int not null,
                primary key (ong_id));
create table tipo_pedido(tip_ped_id int not null auto_increment,
						tip_nome varchar(30),
                        primary key (tip_ped_id));
#Chaves estrangeiras
alter table pedido add constraint pedido_fk_empresa
			foreign key (pedido_e_id) references empresa(e_id)
            on delete no action on update no action;
alter table pedido add constraint pedido_fk_ong
			foreign key (pedido_ong_id) references ong(ong_id)
            on delete no action on update no action;
alter table pedido add constraint pedido_fk_tipo_pedido
			foreign key (pedido_tip_ped_id) references tipo_pedido(tip_ped_id)
            on delete no action on update no action;
alter table ong add constraint ong_fk_empresa
			foreign key (ong_e_id) references empresa(e_id)
            on delete no action on update no action;