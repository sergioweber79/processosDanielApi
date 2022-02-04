/*
Campos do html para salvar


n de pub:
n do pedido internacional:
Data de publicação:
Requerentes:
Título:
*/

drop table tb_processo if exists;

CREATE TABLE tb_processo
(
  idprocesso integer NOT NULL,
  nro_pub  character varying(100),
  nro_pedido_internacional character varying(100),
  dtpublicacao timestamp without time zone,
  requerentes character varying(1000),
  titulo character varying(1000),
  CONSTRAINT tb_processo_pkey PRIMARY KEY (idprocesso)
);


create sequence sqtb_processo START 1 MAXVALUE 999999999999;

COMMENT ON COLUMN tb_processo.idprocesso IS 'PK';
COMMENT ON COLUMN tb_processo.nro_pub IS 'Numero de publicacao do processo';
COMMENT ON COLUMN tb_processo.nro_pedido_internacional IS 'Numero do Pedido internacional do processo';
COMMENT ON COLUMN tb_processo.requerentes IS 'Requerente ou requerentes do processo';
COMMENT ON COLUMN tb_processo.titulo IS 'Titulo do Processo';