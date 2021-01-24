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