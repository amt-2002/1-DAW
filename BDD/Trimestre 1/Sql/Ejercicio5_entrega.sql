
drop table proveedores cascade constraints;
create table proveedores (
    cif varchar2(50) primary key,
    nombre_empresa varchar2(50),
    direccion varchar2(50),
    codigo_postal varchar2(50),
    email varchar2(50),
    telefono varchar2(50)
);

drop table productos cascade constraints;
create table productos (
    codigo int primary key, 
    nombre varchar2(50),
    descripcion varchar2(50),
    tipo varchar2(50),
    importe int 
);

drop table clientes cascade constraints; 
create table clientes (
    id int primary key, 
    localidad varchar(50),
    tipo VARCHAR(50) 
);

drop table trabajadores cascade constraints; 
create table trabajadores (
    dni char(9) primary key,
    nombre varchar2(50),
    apellidos varchar2(50),
    fecha_nacimiento date,
    localidad varchar2(50),
    codigo_postal varchar2(50),
    telefono varchar2(50),
    anos_experiencia_dependiente int, 
    tipo_trabajador varchar2(50),
    esDependienteCafeteria int, 
    esDependienteTienda int 
);

drop table pedidos_realizados cascade constraints;
create table pedidos_realizados (
    dni_encargado char(9),
    cif_proveedor varchar2(50), 
    num_albaran int,
    importe int,
    fecha date,
    hora timestamp 
);

drop table comandas_camarero_producto_cliente cascade constraints;
create table comandas_camarero_producto_cliente (
    dni_camarero char(9),
    codigo_producto int,
    id_cliente int,
    id_comanda int primary key 
);

drop table cobros cascade constraints;
create table cobros (
    dni_dependiente char(9),
    id_cliente int, 
    fecha date, 
    importe int, 
    forma_pago varchar2(50),
    id_ticket int primary key 
)
