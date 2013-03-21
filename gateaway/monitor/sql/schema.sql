
-- Table: status_table

-- DROP TABLE status_table;

CREATE TABLE status_table
(
  correlation_id character varying NOT NULL,
  parcel_name text,
  domain_id integer
)
WITH (
  OIDS=FALSE
);
ALTER TABLE status_table
  OWNER TO postgres;

-- Index: fki_dmain_id_fk

-- DROP INDEX fki_dmain_id_fk;

CREATE INDEX fki_dmain_id_fk
  ON status_table
  USING btree
  (domain_id);

-- Table: domain

-- DROP TABLE domain;

CREATE TABLE domain
(
  id integer NOT NULL,
  domain_name character varying,
  description character varying,
  CONSTRAINT domain_pk PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE domain
  OWNER TO postgres;