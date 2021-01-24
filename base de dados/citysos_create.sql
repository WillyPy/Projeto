create database citysos;

drop database citysos;


create table empresa (e_id int not null auto_increment,
						e_nome varchar(30) not null,
                        e_endereco varchar(10) default'Angola',
                        primary key (e_id));
                        
create table ong (ong_id int auto_increment not null,
					nome varchar(30) not null ,
					e_id_fk int,
					primary key (ong_id),
                    foreign key(e_id_fk) references empresa(e_id));
                    
create table empresa_pedido(ep_id int not null auto_increment,
								ep_data datetime not null,
                                ep_e_id_fk int,
                                ep_p_id_fk int,
                                ep_est_id int,
                                primary key(ep_id),
                                foreign key(ep_e_id) references empresa(e_id),
								foreign key(ep_p_id) references pedido(p_id),
								foreign key(ep_est_id) references estado_pedido(est_id));
                                
create table pedido(p_id int not null auto_increment,
						p_tipo varchar(30) not null,
                        p_cart_sol varchar(150) not null,
                        p_tipo_ped_id int,
                        p_ped_id int,
                        primary key(p_id),
                        foreign key (p_tipo_ped_id) references tipo_pedido(tipo_ped_id),
						foreign key (p_ong_id) references ong(ong_id));
                        
create table estado_pedido(est_id int not null,
							est_estado varchar(15) default 'Submetido',
                            primary key(est_tip_ped_id)
                            );
                            
create table tipo_pedido(tip_ped_id int not null auto_increment,
							tip_nome varchar(30) not null,
                            primary key(tip_ped_id));
                            primary key(tip_ped_id));
create table tipo_pedido(tip_ped_id int not null auto_increment,
						tip_nome varchar(30),
                        primary key (tip_ped_id));
create table estado_pedido(est_id int not null,
							est_estado varchar(30),
                            primary key(est_id));
create table ong(ong_id int not null auto_increment,
				ong_nome varchar(30) not null,
                ong_e_id int not null unique, #unique para criar uma ligação de um para um com a tabela Empresa.
                primary key (ong_id));
create table pedido (p_id int not null auto_increment,
						p_tipo varchar(30) not null,
						p_cart_sol varchar(150) not null,
						p_ong_id int not null,
                        p_tip_ped_id int not null,
						primary key (p_id));
create table empresa_pedido(ep_id int auto_increment not null,
							ep_data date not null,
                            ep_e_id int not null,
                            ep_p_id int not null,
                            ep_est_id int not null,
                            primary key(ep_id));
#Chaves estrangeiras
alter table ong add constraint ong_fk_empresa
			foreign key (ong_e_id) references empresa(e_id)
            on delete no action on update no action;
alter table pedido add constraint pedido_fk_ong
			foreign key (p_ong_id) references ong(ong_id)
            on delete no action on update no action;
alter table pedido add constraint pedido_fk_tipo_pedido
			foreign key (p_tip_ped_id) references tipo_pedido(tip_ped_id)
            on delete no action on update no action;
alter table empresa_pedido add constraint empresa_pedido_fk_empresa
			foreign key (ep_e_id) references empresa(e_id)
            on delete no action on update no action;
alter table empresa_pedido add constraint empresa_pedido_fk_pedido
			foreign key (ep_p_id) references pedido(p_id)
            on delete no action on update no action;
alter table empresa_pedido add constraint empresa_pedido_fk_estado_pedido
			foreign key (ep_est_id) references estado_pedido(est_id)
            on delete no action on update no action;
            on delete no action on update no action;
