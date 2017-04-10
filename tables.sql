create table produtos (
	id serial,
	nome varchar(100),
	valor numeric(8,2),
	constraint pk_prod primary key(id)
);

create table compra (
	id serial,
	valor_total numeric(8,2),
	constraint pk_compra primary key(id)
);

create table part_compra (
	id serial,
	id_compra int,
	id_produto int,
	qtd int,
	constraint pk_part_compra primary key(id),
	constraint fk_comp foreign key (id_compra) references compra(id),
	constraint fk_prod foreign key (id_produto) references produtos(id)
);

INSERT into produtos (nome,valor) values ('Carne',10.99);
INSERT into produtos (nome,valor) values ('Frango',7.55);
INSERT into produtos (nome,valor) values ('Batata',5.36);
INSERT into produtos (nome,valor) values ('Tomate',3.04);