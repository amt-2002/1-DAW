drop table coches cascade constraints; 
create table coches (
        id int, 
        modelo varchar(100), 
        marca varchar(50),
        cv int, 
        consumo100 number,  
        primary key(id)
);

alter table coches drop primary key; 
alter table coches rename column modelo to vehiculo; 

drop table compras cascade constraints; 
create table compras (
        id int, 
        cliente varchar(100),
        fechacompra date, 
        idcoche int, 
        primary key (id)
);

alter table compras add foreign key (idcoche) references compras(id);  


drop table piezas cascade constraints; 
create table piezas (
    codigo int, 
    idalmacen int, 
    nombre varchar(50), 
    peso number, 
    primary key( codigo, idalmacen)
);







