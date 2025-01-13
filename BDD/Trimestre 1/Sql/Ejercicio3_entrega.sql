
drop table vendedores cascade constraints; 
create table vendedores (
        dni char(9), 
        nombre varchar2(50),
        apellidos varchar2(50),
        experiencia varchar2(50),
        dni_emp_practicas char(9), 
        primary key (dni)
);

drop table pescados cascade constraints; 
create table pescados (
        id int, 
        nombre varchar2(50),
        procedencia varchar2(50),
        especie varchar2(50),
        dni_emp_practicas char(9), 
        primary key (id)
);

drop table emp_practicas cascade constraints; 
create table emp_practicas (
        dni char(9), 
        primary key (dni)
);


drop table clientes cascade constraints; 
create table clientes (
        dni char(9),
        nombre varchar2(50),
        forma_pago varchar2(50),
        kg_comprado varchar2(50),
        primary key (dni)
);

drop table compras_lonjas cascade constraints;
create table compras_lonjas (
        dni_vendedor char(9), 
        id_pescado int, 
        unidades int, 
        vendedor varchar2(50),
        referencia int, 
        nombre varchar2(50),
        primary key (dni_vendedor, id_pescado)
);

drop table compras_pescaderia cascade constraints; 
create table compras_pescaderia (
        id_pescado int, 
        dni_cliente char(9), 
        dia date, 
        importe int, 
        primary key(id_pescado, dni_cliente)
);

drop table clientes_atendidos_vendedores cascade constraints; 
create table clientes_atendidos_vendedores (
        dni_vendedor char(9), 
        dni_cliente char(9), 
        primary key(dni_vendedor, dni_cliente) 
);

alter table vendedores add foreign key (dni_emp_practicas) references emp_practicas(dni);
alter table pescados add foreign key (dni_emp_practicas) references emp_practicas(dni);
alter table compras_lonjas add foreign key (dni_vendedor) references vendedores(dni);
alter table compras_lonjas add foreign key (id_pescado) references pescados(id);
alter table compras_pescaderia add foreign key (id_pescado) references pescados(id);
alter table compras_pescaderia add foreign key (dni_cliente) references clientes(dni); 
alter table clientes_atendidos_vendedores add foreign key (dni_vendedor) references vendedores(dni); 
alter table clientes_atendidos_vendedores add foreign key (dni_cliente) references clientes(dni);

