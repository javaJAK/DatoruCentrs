-- Tabula: DARBA VEIDI
CREATE TABLE IF NOT EXISTS darba_veidi(
id SERIAL NOT NULL PRIMARY KEY, 
nosaukums VARCHAR(255));

-- Tabula: DATORTEHNIKA
CREATE TABLE IF NOT EXISTS datortehnika(
id SERIAL NOT NULL PRIMARY KEY,
nosaukums VARCHAR (255));

-- Tabula: AMATI
create table if not exists amati(
id serial not null primary key,
nosaukums varchar(255));

-- Tabula: PERSONAS
create table if not exists personas(
id serial not null primary key ,
vards varchar(100),
uzvards varchar(100),
talrunis char(8),
amats_id integer,
constraint amats_fk foreign key(amats_id) references amati(id));

-- Tabula: REMONTA AKTI
CREATE TABLE IF NOT EXISTS remonta_akti(
id SERIAL NOT NULL PRIMARY KEY, 
klients_id INTEGER,
tehnikis_id INTEGER,
darba_veids_id INTEGER,
problema VARCHAR(255),
datortehnika_id INTEGER,
serialais_numurs VARCHAR(255),
piezimes VARCHAR(255),
transports DOUBLE PRECISION,
darba_ilgums DOUBLE PRECISION,
darba_apraksts VARCHAR(255),
datums DATE,
CONSTRAINT klients_fk FOREIGN KEY(klients_id) REFERENCES personas(id),
CONSTRAINT tehnikis_id FOREIGN KEY(klients_id) REFERENCES personas(id),
CONSTRAINT darba_veids_fk FOREIGN KEY(darba_veids_id) REFERENCES darba_veidi(id),
CONSTRAINT datortehnika_fk FOREIGN KEY(datortehnika_id) REFERENCES datortehnika(id));

-- Tabula: REMONTI MATERIALI
CREATE TABLE IF NOT EXISTS remonti_materiali(
id SERIAL NOT NULL PRIMARY KEY,
materials_id integer,
remonta_akts_id integer,
daudzums integer,
CONSTRAINT materials_id_fk FOREIGN KEY(materials_id) REFERENCES materiali(id),
CONSTRAINT remonta_akts_fk FOREIGN KEY(persona_id) REFERENCES personas(id));