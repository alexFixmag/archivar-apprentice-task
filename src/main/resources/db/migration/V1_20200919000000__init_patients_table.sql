CREATE TABLE archivist.patients
(
    user_id character varying(100) COLLATE pg_catalog."default" NOT NULL,
    name character varying(100) COLLATE pg_catalog."default",
    surname character varying(100) COLLATE pg_catalog."default",
    patronymic character varying(100) COLLATE pg_catalog."default",
    date_of_birth date,
    snils_id character varying(100) COLLATE pg_catalog."default",
    polys_oms_id character varying(100) COLLATE pg_catalog."default",
    patient_card_id character varying(100) COLLATE pg_catalog."default",
    date_insert timestamp without time zone,
    date_update timestamp without time zone
)

TABLESPACE pg_default;

ALTER TABLE archivist.patients
    OWNER to postgres;

GRANT SELECT ON TABLE archivist.patients TO archi;

GRANT ALL ON TABLE archivist.patients TO postgres;