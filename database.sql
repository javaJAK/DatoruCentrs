-- Tabula: DARBA VEIDI
CREATE TABLE IF NOT EXISTS darba_veidi(
id SERIAL NOT NULL PRIMARY KEY, 
nosaukums VARCHAR(255));

-- Tabula: DATORTEHNIKA
CREATE TABLE IF NOT EXISTS datortehnika(
id SERIAL NOT NULL PRIMARY KEY,
nosaukums VARCHAR (255));

-- Tabula: AMATI
CREATE TABLE IF NOT EXISTS amati(
id SERIAL NOT NULL PRIMARY KEY,
nosaukums VARCHAR(255));

-- Tabula: PERSONAS
create table if not exists personas(
id SERIAL NOT NULL PRIMARY KEY,
vards VARCHAR(255),
uzvards VARCHAR(255),
talrunis CHAR(8),
amats_id INTEGER,
CONSTRAINT amats_fk FOREIGN KEY(amats_id) REFERENCES amati(id));

-- Tabula: MATERIALI
CREATE TABLE IF NOT EXISTS materiali(
id SERIAL NOT NULL PRIMARY KEY,
nosaukums varchar(255),
cena DOUBLE PRECISION,
daudzums INTEGER);

-- Tabula: PIEGADES
CREATE TABLE IF NOT EXISTS piegades(
id SERIAL NOT NULL PRIMARY KEY,
veids varchar(255));

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
CONSTRAINT tehnikis_fk FOREIGN KEY(tehnikis_id) REFERENCES personas(id),
CONSTRAINT darba_veids_fk FOREIGN KEY(darba_veids_id) REFERENCES darba_veidi(id),
CONSTRAINT datortehnika_fk FOREIGN KEY(datortehnika_id) REFERENCES datortehnika(id));

-- Tabula: REMONTI MATERIALI
CREATE TABLE IF NOT EXISTS remonti_materiali(
id SERIAL NOT NULL PRIMARY KEY,
materials_id INTEGER,
remonta_akts_id INTEGER,
daudzums INTEGER,
CONSTRAINT materials_id_fk FOREIGN KEY(materials_id) REFERENCES materiali(id),
CONSTRAINT remonta_akts_fk FOREIGN KEY(remonta_akts_id) REFERENCES remonta_akti(id));

--Tabula: AKTI MATERIALI
CREATE TABLE IF NOT EXISTS akti_materiali(
id SERIAL NOT NULL PRIMARY KEY,
materials_id INTEGER,
remonts_materials_id INTEGER,
izsniegsanas_akts_id INTEGER,
CONSTRAINT materials_id_fk FOREIGN KEY(materials_id) REFERENCES materiali(id),
CONSTRAINT remonta_materials_fk FOREIGN KEY(remonta_materials_id) REFERENCES remonta_materiali(id));
CONSTRAINT izsniegsanas_akts_fk FOREIGN KEY(izsniegsanas_akts_id) REFERENCES izsniegsanas_akti(id));

-- Tabula: IZSNIEGSANAS AKTI
CREATE TABLE IF NOT EXISTS izsniegsanas_akti(
id SERIAL NOT NULL PRIMARY KEY, 
izsniedzejs_id INTEGER,
remonts_akts_id INTEGER,
sanemsanas_adrese VARCHAR(255),
apmaksas_termins VARCHAR(255),
piegade_id INTEGER,
CONSTRAINT izsniedzejs_fk FOREIGN KEY(izsniedzejs_id) REFERENCES izsniedzejs(id),
CONSTRAINT remonts_akts_fk FOREIGN KEY(remonts_akts_id) REFERENCES remonts_akts(id),
CONSTRAINT piegade_fk FOREIGN KEY(piegade_id) REFERENCES piegade(id));
