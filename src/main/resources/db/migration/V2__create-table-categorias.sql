create table categorias(
    id bigint not null auto_increment,
    titulo varchar(100) not null unique,
    cor varchar(100) not null unique,

    primary key(id)
)