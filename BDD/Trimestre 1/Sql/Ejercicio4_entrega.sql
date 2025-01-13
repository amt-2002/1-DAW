drop table agencias cascade constraints; 
create table agencias (
        zona_actuacion varchar2(50) primary key,
        fax  varchar2(50),
        direccion  varchar2(50)
);

drop table telefonos cascade constraints; 
create table telefonos (
        numero int primary key, 
        zona_actuacion_agencia  varchar2(50)
);

drop table empleados cascade constraints; 
create table empleados (
    codigo int primary key, 
    nombre  varchar2(50),
    fecha_nacimiento date, 
    telefono int,
    titulacion_titular  varchar2(50),
    comision_vendedor int, 
    es_titular  varchar2(50),
    es_vendedor  varchar2(50),
    zona_actuacion_agencia  varchar2(50)
);

drop table inmuebles cascade constraints; 
create table inmuebles (
    codigo int primary key, 
    propietario  varchar2(50),
    direccion  varchar2(50),
    superficie  varchar2(50),
    num_hab_piso int,
    num_banos_piso int,
    tipo_gas_piso  varchar2(50),
    lic_apertura_local  varchar2(50),
    tipo_inmueble  varchar2(50),
    precio_alquiler int,
    fianza_alquiler int,
    precio_venta int,
    hipoteca_venta int,
    es_alquilable  varchar2(50),
    es_vendible  varchar2(50)
);

drop table inmuebles_de_agencias cascade constraints; 
create table inmuebles_de_agencias (
        zona_actuacion_agencia  varchar2(50),
        codigo_inmueble  int,
        primary key(zona_actuacion_agencia, codigo_inmueble)
);

alter table telefonos add foreign key (zona_actuacion_agencia) references agencias(zona_actuacion);
alter table empleados add foreign key (zona_actuacion_agencia) references agencias(zona_actuacion);
alter table inmuebles_de_agencias add foreign key (zona_actuacion_agencia) references agencias(zona_actuacion);
alter table inmuebles_de_agencias add foreign key (codigo_inmueble) references inmuebles(codigo); 




