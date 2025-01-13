drop table piezas cascade constraints; 
create table piezas (
        id int, 
        nombre varchar2(100), 
        id_fabricante int 
);

drop table fabricantes cascade constraints; 
create table fabricantes (
        id int, 
        marca varchar(50)
);

alter table piezas  add constraint id_piezas_pk primary key (id);
alter table piezas add constraint id_fabricante foreign key (id) references fabricantes(id); 
alter table fabricantes add primary key (id); 

alter table piezas add precio number(4, 2); 
alter table piezas add constraint checkprecio check (precio > 0);  

alter table piezas add codigo char(5);  
alter table piezas add constraint checkcodigo check (regexp_like (codigo, '[P], [0-9], [0-9],[0-9],[A-Z]')); 

alter table fabricantes add constraint checkmarca check( marca in ('FABRIC1','FABRIC2','FABRIC3')); 
alter table fabricantes drop constraint checkmarca; 



