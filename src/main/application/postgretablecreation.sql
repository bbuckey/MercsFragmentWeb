CREATE ROLE root LOGIN
  ENCRYPTED PASSWORD 'md5b4b8daf4b8ea9d39568719e1e320076f'
  SUPERUSER INHERIT CREATEDB CREATEROLE REPLICATION CONNECTION LIMIT 1;

CREATE DATABASE "tempDB"
  WITH OWNER = root
       ENCODING = 'UTF8'
       TABLESPACE = pg_default
       LC_COLLATE = 'English_United States.1252'
       LC_CTYPE = 'English_United States.1252'
       CONNECTION LIMIT = 2;
GRANT ALL ON DATABASE "tempDB" TO root;
GRANT ALL ON DATABASE "tempDB" TO public;

CREATE SCHEMA base
  AUTHORIZATION root;

GRANT ALL ON SCHEMA base TO root;
GRANT ALL ON SCHEMA base TO public;
COMMENT ON SCHEMA base
  IS 'base schema';

ALTER DEFAULT PRIVILEGES 
    GRANT INSERT, SELECT, UPDATE, DELETE, TRUNCATE, REFERENCES, TRIGGER ON TABLES
    TO public;

ALTER DEFAULT PRIVILEGES 
    GRANT INSERT, SELECT, UPDATE, DELETE, TRUNCATE, REFERENCES, TRIGGER ON TABLES
    TO postgres;

ALTER DEFAULT PRIVILEGES 
    GRANT SELECT, UPDATE, USAGE ON SEQUENCES
    TO public;

ALTER DEFAULT PRIVILEGES 
    GRANT SELECT, UPDATE, USAGE ON SEQUENCES
    TO postgres;

CREATE SEQUENCE base.serial
  INCREMENT 1
  MINVALUE 0
  MAXVALUE 9223372036854775807
  START 50
  CACHE 10;
ALTER TABLE base.serial
  OWNER TO root;
GRANT ALL ON TABLE base.serial TO public;
GRANT ALL ON TABLE base.serial TO root;
    

CREATE TABLE base.mercs
(
  id integer NOT NULL DEFAULT nextval('base.serial'::regclass),
  mercname character varying(30),
  atk  integer,
  def  integer,
  hp  integer,
  created timestamp without time zone DEFAULT now(),
  CONSTRAINT mercs_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE base.mercs
  OWNER TO root;
GRANT ALL ON TABLE base.mercs TO public;
GRANT ALL ON TABLE base.mercs TO root WITH GRANT OPTION;

CREATE TABLE base.Player
(
  id integer NOT NULL DEFAULT nextval('base.serial'::regclass),
  Playername character varying(30),
  plevel integer,
  exp integer,
  gold integer,
  cash integer,
  lastcashtime timestamp without time zone DEFAULT now(),
  CONSTRAINT Player_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE base.Player
  OWNER TO root;
GRANT ALL ON TABLE base.Player TO public;
GRANT ALL ON TABLE base.Player TO root WITH GRANT OPTION;

CREATE TABLE base.Weapons
(
  id integer NOT NULL DEFAULT nextval('base.serial'::regclass),
  Weaponname character varying(30),
  atk  integer,
  def  integer,
  hp  integer,
  created timestamp without time zone DEFAULT now(),
  CONSTRAINT Weapons_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE base.Weapons
  OWNER TO root;
GRANT ALL ON TABLE base.Weapons TO public;
GRANT ALL ON TABLE base.Weapons TO root WITH GRANT OPTION;

CREATE TABLE base.BattleField
(
  id integer NOT NULL DEFAULT nextval('base.serial'::regclass),
  level_number integer,
  created timestamp without time zone DEFAULT now(),
  CONSTRAINT BattleField_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE base.BattleField
  OWNER TO root;
GRANT ALL ON TABLE base.BattleField TO public;
GRANT ALL ON TABLE base.BattleField TO root WITH GRANT OPTION;


CREATE TABLE base.ComputerMercs
(
  id integer NOT NULL DEFAULT nextval('base.serial'::regclass),
  atk  integer,
  def  integer,
  hp  integer,
  battlefield_id integer references BASE.BattleField(id),
  exp integer,
  gold integer,
  holdAtk integer,
  Drop_ids character varying(500),
  created timestamp without time zone DEFAULT now(),
  CONSTRAINT ComputerMercs_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE base.ComputerMercs
  OWNER TO root;
GRANT ALL ON TABLE base.ComputerMercs TO public;
GRANT ALL ON TABLE base.ComputerMercs TO root WITH GRANT OPTION;

CREATE TABLE base.BossMercs
(
  id integer NOT NULL DEFAULT nextval('base.serial'::regclass),
  atk  integer,
  def  integer,
  hp  integer,
  battlefield_id integer references BASE.BattleField(id),
  exp integer,
  gold integer,
  holdAtk integer,
  Drop_ids character varying(500),
  created timestamp without time zone DEFAULT now(),
  CONSTRAINT BossMercs_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE base.BossMercs
  OWNER TO root;
GRANT ALL ON TABLE base.ComputerMercs TO public;
GRANT ALL ON TABLE base.ComputerMercs TO root WITH GRANT OPTION;



CREATE TABLE base.PlayerWeapons
(
  id integer NOT NULL DEFAULT nextval('base.serial'::regclass),
  player_id integer references BASE.Player(id),
  weapons_id integer REFERENCES BASE.Weapons(id),
  created timestamp without time zone DEFAULT now(),
  CONSTRAINT PlayerWeapons_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE base.PlayerWeapons
  OWNER TO root;
GRANT ALL ON TABLE base.PlayerWeapons TO public;
GRANT ALL ON TABLE base.PlayerWeapons TO root WITH GRANT OPTION;



CREATE TABLE base.BattleFieldDrops
(
  id integer NOT NULL DEFAULT nextval('base.serial'::regclass),
  mercs_id integer references BASE.Mercs(id),
  battlefield_id integer references BASE.BattleField(id),
  weapons_id integer REFERENCES BASE.Weapons(id),
  created timestamp without time zone DEFAULT now(),
  CONSTRAINT BattleFieldDrops_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE base.BattleFieldDrops
  OWNER TO root;
GRANT ALL ON TABLE base.BattleFieldDrops TO public;
GRANT ALL ON TABLE base.BattleFieldDrops TO root WITH GRANT OPTION;


CREATE TABLE base.PlayerMercs
(
  id integer NOT NULL DEFAULT nextval('base.serial'::regclass),
  mercs_id integer references BASE.Mercs(id),
  player_id integer references BASE.Player(id),
  weapons_id integer REFERENCES BASE.Weapons(id),
  PlayerWeapons_id integer REFERENCES BASE.PlayerWeapons(id),
  mercname character varying(30),
  atk  integer,
  def  integer,
  hp  integer,
  mlevel INTEGER,
  created timestamp without time zone DEFAULT now(),
  CONSTRAINT PlayerMercs_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE base.PlayerMercs
  OWNER TO root;
GRANT ALL ON TABLE base.PlayerMercs TO public;
GRANT ALL ON TABLE base.PlayerMercs TO root WITH GRANT OPTION;


CREATE TABLE base.MercType
(
  id integer NOT NULL DEFAULT nextval('base.serial'::regclass),
  mercs_id integer references BASE.Mercs(id),
  mercname character varying(30),
  created timestamp without time zone DEFAULT now(),
  CONSTRAINT MercType_pkey PRIMARY KEY (id)
)
WITH (
  OIDS=FALSE
);
ALTER TABLE base.MercType
  OWNER TO root;
GRANT ALL ON TABLE base.MercType TO public;
GRANT ALL ON TABLE base.MercType TO root WITH GRANT OPTION;


INSERT INTO base.BattleField VALUES(1,1);
INSERT INTO base.BattleField VALUES(2,2);
INSERT INTO base.BattleField VALUES(3,3);
INSERT INTO base.BattleField VALUES(4,4);
INSERT INTO base.BattleField VALUES(5,5);
INSERT INTO base.BattleField VALUES(6,6);
INSERT INTO base.Mercs VALUES(1,'G.I. Joe',150,10,0);
INSERT INTO base.Mercs VALUES(2,'Cobra Commander',150,10,0);
INSERT INTO base.Mercs VALUES(3,'Snake Eyes',120,10,0);
INSERT INTO base.Mercs VALUES(4,'Ace',180,10,0);
INSERT INTO base.Mercs VALUES(5,'Scarlett',80,10,0);
INSERT INTO base.Mercs VALUES(6,'Dreadnoks',190,10,0);
INSERT INTO base.Mercs VALUES(7,'Duke',150,10,0);
INSERT INTO base.Mercs VALUES(8,'Tunnel Rat',75,10,0);
INSERT INTO base.Mercs VALUES(9,'Flint',165,10,0);
INSERT INTO base.Mercs VALUES(10,'Rip Cord',250,10,0);
INSERT INTO base.Mercs VALUES(11,'Falcon',150,10,0);
INSERT INTO base.Mercs VALUES(12,'Stalker',85,10,0);
INSERT INTO base.Mercs VALUES(13,'Grid-Iron',190,10,0);
INSERT INTO base.Mercs VALUES(14,'SkyStriker',150,10,0);
INSERT INTO base.Mercs VALUES(15,'Shipwreck',150,10,0);
INSERT INTO base.Mercs VALUES(16,'RoadBlock',150,10,0);
INSERT INTO base.Mercs VALUES(17,'Heavy Duty',150,10,0);
INSERT INTO base.Mercs VALUES(18,'Spirt Iorn-Knife',150,10,0);
INSERT INTO base.Mercs VALUES(19,'Long Range',150,10,0);
INSERT INTO base.Mercs VALUES(20,'Hi-Tech',150,10,0);
INSERT INTO base.Mercs VALUES(21,'Firefly',150,10,0);
INSERT INTO base.Mercs VALUES(22,'Stone',150,10,0);
INSERT INTO base.Mercs VALUES(23,'Hawk',150,10,0);
INSERT INTO base.Mercs VALUES(24,'Mouse',150,10,0);
INSERT INTO base.Mercs VALUES(25,'Lady Jaye',150,10,0);
INSERT INTO base.Mercs VALUES(26,'Cover Girl',150,10,0);
INSERT INTO base.Mercs VALUES(27,'Savage',150,10,0);
INSERT INTO base.Mercs VALUES(28,'Slaughter',150,10,0);
INSERT INTO base.Mercs VALUES(29,'Baroness',150,10,0);
INSERT INTO base.Mercs VALUES(30,'Buzzered',150,10,0);
INSERT INTO base.Mercs VALUES(31,'Count Down',150,10,0);
INSERT INTO base.Mercs VALUES(32,'Double Vision',150,10,0);
INSERT INTO base.Mercs VALUES(33,'Fred',150,10,0);
INSERT INTO base.Mercs VALUES(34,'Five Alarm',150,10,0);
INSERT INTO base.Mercs VALUES(35,'Candy',150,10,0);
INSERT INTO base.Mercs VALUES(36,'Eagle',150,10,0);
INSERT INTO base.Mercs VALUES(37,'Ten',150,10,0);
INSERT INTO base.Mercs VALUES(38,'Night Vision',150,10,0);
INSERT INTO base.Mercs VALUES(39,'Blue',150,10,0);
INSERT INTO base.Mercs VALUES(40,'Debt',150,10,0);
INSERT INTO base.Mercs VALUES(41,'One Cent',150,10,0);
INSERT INTO base.Mercs VALUES(42,'Core',150,10,0);
INSERT INTO base.Mercs VALUES(43,'Packer',150,10,0);
INSERT INTO base.Mercs VALUES(44,'Tax',150,10,0);
INSERT INTO base.Mercs VALUES(45,'Juice',150,10,0);
INSERT INTO base.Mercs VALUES(46,'Robot',150,10,0);
INSERT INTO base.Mercs VALUES(47,'Slient Killer',150,10,0);
INSERT INTO base.Mercs VALUES(48,'Slow Burn',150,10,0);
INSERT INTO base.Mercs VALUES(49,'Acid Wash',150,10,0);
INSERT INTO base.Mercs VALUES(50,'Final Thought',150,10,0);
INSERT INTO base.Mercs VALUES(51,'Road Kill',160,10,0);
INSERT INTO base.Mercs VALUES(52,'Tight Spot',140,20,0);
insert into base.weapons(atk, def, hp, weaponname) values(10,5,15,'Hand Gun');
insert into base.weapons(atk, def, hp, weaponname) values(25,0,30,'Machine Gun');
insert into base.weapons(atk, def, hp, weaponname) values(25,10,30,'Tommy Gun');
insert into base.weapons(atk, def, hp, weaponname) values(100,0,0,'Canon');
