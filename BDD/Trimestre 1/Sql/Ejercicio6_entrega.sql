drop table tiendas cascade constraints; 
create table tiendas (
    codigo int primary key, 
    ceo varchar2(50),
    telefono varchar2(50),
    facturacion int, 
    gastos_brutos int, 
    num_empleados int,
    localidad varchar2(50), 
    codigo_postal varchar2(50), 
    fecha_apertura date, 
    ingresos_brutos int, 
    direccion varchar2(50)
);

drop table productos cascade constraints; 
create table productos (
    codigo int primary key, 
    tipo varchar2(50),
    nombre varchar2(60),
    descripcion varchar2(100),
    precio int, 
    cantidad int 
);

drop table clientes cascade constraints; 
create table clientes (
    codigo_cliente int primary key, 
    dni char(9),
    forma_pago varchar2(50),
    codigo_postal varchar2(50)
);

drop table proveedores cascade constraints;
create table proveedores (
    cif char(9) primary key, 
    direccion varchar2(50),
    nombre_comercial varchar2(50),
    codigo_postal varchar2(50),
    localidad varchar2(50),
    cif_proveedor_dueno char(9) 
);

drop table empleados cascade constraints;   
create table empleados (
    dni char(9) primary key,
    nombre varchar2(50),
    apellidos varchar2(50),
    edad int, 
    numero_anos_responsable int,
    vehiculo_propio_transportista varchar2(50),
    tipo_empleado varchar2(50) 
);

drop table empleados_tiendas cascade constraints;   
create table empleados_tiendas (
    codigo_tienda int, 
    dni_empleado char(9),
    codigo_contrato int primary key 
);

drop table suministros cascade constraints;
create table suministros (
    codigo_tienda int,
    cif_proveedor CHAR(9),
    primary key (codigo_tienda, cif_proveedor)
);

drop table productos_tiendas cascade constraints;
create table productos_tiendas (
    codigo_tienda int,
    codigo_producto int,
    primary key (codigo_tienda, codigo_producto)
);

drop table compras cascade constraints;
create table compras (
    codigo_producto int, 
    codigo_cliente int,
    fecha date, 
    hora VARCHAR2(5),
    importe int,
    primary key (codigo_producto, codigo_cliente)
);

drop table contrataciones cascade constraints;
create table contrataciones (
    dni_empleado_responsable char(9),
    cif_proveedor char(9),
    primary key (dni_empleado_responsable, cif_proveedor)
);


alter table proveedores add foreign key (cif_proveedor_dueno) references proveedores(cif);
alter table empleados_tiendas add foreign key (codigo_tienda) references tiendas(codigo);
alter table empleados_tiendas add foreign key (dni_empleado) references empleados(dni);
alter table suministros add foreign key (codigo_tienda) references tiendas(codigo);
alter table suministros add foreign key (cif_proveedor) references proveedores(cif);
alter table productos_tiendas add foreign key (codigo_tienda) references tiendas(codigo);
alter table productos_tiendas add foreign key (codigo_producto) references productos(codigo);
alter table compras add foreign key (codigo_producto) references productos(codigo);
alter table compras add foreign key (codigo_cliente) references clientes(codigo_cliente);
alter table contrataciones add foreign key (dni_empleado_responsable) references empleados(dni);
alter table contrataciones add foreign key (cif_proveedor) references proveedores(cif);
