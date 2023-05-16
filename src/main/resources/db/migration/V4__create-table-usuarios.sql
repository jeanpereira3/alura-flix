create table usuarios(
    id bigint not null auto_increment,
    login varchar(100) not null,
    senha varchar(250) not null,

    primary key(id)
);

insert into usuarios values(1,'jean', '$2a$10$Y50UaMFOxteibQEYLrwuHeehHYfcoafCopUazP12.rqB41bsolF5.');