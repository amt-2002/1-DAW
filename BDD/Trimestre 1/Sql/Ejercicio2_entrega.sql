drop table camisetas cascade constraints; 
create table  camisetas (
        referencia int, 
        talla int, 
        nombre_del_dis varchar2(50),
        marca varchar2(50),
        tipo_tejido varchar2(50),
        forma varchar2(50),
        color varchar2(50),
        precio int, 
        primary key (referencia) 
);

drop table clientes cascade constraints;
create table clientes(
        email varchar2(50),
        nombre varchar2(50),
        cp int, 
        num_compras int, 
        primary key (email)
);

drop table diseños cascade constraints; 
create table diseños (
        id  int, 
        primary key (id)
);

drop table proveedores cascade constraints; 
create table proveedores (
        nif int, 
        direccion varchar2(50),
        nombre_c varchar2(50),
        cp int, 
        localidad varchar2(50),
        tipo varchar2(50),
        primary key (nif)
);

drop table pedidos cascade constraints; 
create table pedidos (
        referencia int, 
        importe int,
        primary key (referencia)
);

drop table empleados cascade constraints;
create table empleados (
        dni char(9), 
        nombre varchar2(50),
        apellidos varchar2(50),
        edad int,
        esDiseñador int,
        esVendedor int,
        primary key (dni)
);

drop table compras cascade constraints;
create table compras (
        referencias_camisetas int, 
        email_cliente varchar2(50)
);

alter table compras add foreign key (referencias_camisetas) references pedidos(referencia);
alter table compras add foreign key (email_cliente) references clientes(email);
alter table compras add primary key (referencias_camisetas, email_cliente);

drop table creaciones cascade constraints; 
create table creaciones (
    id_diseño int, 
    dni_diseñador char(9), 
    primary key (id_diseño, dni_diseñador)
);

alter table creaciones add foreign key (id_diseño) references diseños(id);
alter table creaciones add foreign key (dni_diseñador) references empleados(dni); 


drop table tramitaciones cascade constraints; 
create table tramitaciones (
        dni_vendedor char(9), 
        nif_proveedor int, 
        referencia_pedido int, 
        fecha  date, 
        fecha_recep date,
        primary key(dni_vendedor, nif_proveedor, referencia_pedido)
);

alter table tramitaciones add foreign key (dni_vendedor) references empleados(dni);
alter table tramitaciones add foreign key (nif_proveedor) references proveedores(nif);
alter table tramitaciones add foreign key (referencia_pedido) references pedidos(referencia);