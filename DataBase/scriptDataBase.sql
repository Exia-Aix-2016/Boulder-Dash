#------------------------------------------------------------
#                     SCRIPT CREATE DATABASE
#                              MYSQL
#------------------------------------------------------------

#------------------------------------------------------------
#                         CREATE BOULDERDASH
#                             DATABASE
#------------------------------------------------------------
CREATE DATABASE boulderdash;


#------------------------------------------------------------
#                    CREATE boulderdash.Map
#                             Table
#------------------------------------------------------------
create table boulderdash.Map
(
	MapName varchar(255) not null
		primary key,
	Width int null,
	Heigth int null,
	Diamond int null,
	RemainingTime int null
)
;


#------------------------------------------------------------
#                  CREATE boulderdash.ObjectMap
#                             Table
#------------------------------------------------------------
create table boulderdash.ObjectMap
(
	MapName varchar(255) not null,
	TypeObject varchar(255) not null,
	CoordX int not null,
	CoordY int not null,
	primary key (MapName, TypeObject, CoordY, CoordX),
	constraint ObjectMap_Map_MapName_fk
		foreign key (MapName) references boulderdash.Map (MapName)
			on update cascade on delete cascade
)
;

create index ObjectMap_ObjectType_TypeObject_fk
	on boulderdash.ObjectMap (TypeObject)
;
#------------------------------------------------------------
#                 CREATE boulderdash.ObjectType
#                             Table
#------------------------------------------------------------
create table boulderdash.ObjectType
(
	TypeObject varchar(255) not null
		primary key
)
;
#------------------------------------------------------------
#                         MIGRATION PRK
#                 Map, ObjectType -> ObjectMap
#------------------------------------------------------------
alter table boulderdash.ObjectMap
	add constraint ObjectMap_ObjectType_TypeObject_fk
		foreign key (TypeObject) references boulderdash.ObjectType (TypeObject)
			on update cascade
;
#------------------------------------------------------------
#                             INSERT
#                     DATA IN ObjectType Table
#------------------------------------------------------------
INSERT INTO boulderdash.ObjectType (TypeObject) VALUES ('CHARACTER');
INSERT INTO boulderdash.ObjectType (TypeObject) VALUES ('DIAMOND');
INSERT INTO boulderdash.ObjectType (TypeObject) VALUES ('DIRT');
INSERT INTO boulderdash.ObjectType (TypeObject) VALUES ('MONSTER');
INSERT INTO boulderdash.ObjectType (TypeObject) VALUES ('ROCK');
INSERT INTO boulderdash.ObjectType (TypeObject) VALUES ('WALL');
INSERT INTO boulderdash.ObjectType (TypeObject) VALUES ('EXIT');
#------------------------------------------------------------
#                          Stock routines
#------------------------------------------------------------

#------------------------------------------------------------
#addMap
#------------------------------------------------------------
DELIMITER |
create procedure boulderdash.addMap (IN nameMap varchar(255), IN width int, IN heigh int, IN nbrDiamond INT, IN timeremaining INT)
BEGIN
	IF NOT EXISTS(SELECT * FROM boulderdash.Map WHERE MapName = nameMap) THEN
  INSERT INTO boulderdash.Map (MapName, Width, Heigth, Diamond, RemainingTime) VALUES (nameMap, width, heigh, nbrDiamond, timeremaining);
		END IF ;
	END |
DELIMITER ;
#------------------------------------------------------------
#addMapElement
#------------------------------------------------------------
DELIMITER |
CREATE PROCEDURE boulderdash.addMapElement(IN nameMAP VARCHAR(255), IN nameElement VARCHAR(255), IN X INT, IN Y INT)
  BEGIN
		IF NOT EXISTS(SELECT * FROM boulderdash.ObjectMap WHERE MapName = nameMAP AND TypeObject = nameElement AND CoordX = X AND CoordY = Y) THEN
    INSERT INTO boulderdash.ObjectMap (CoordX, CoordY, MapName, TypeObject) VALUES (X, Y, nameMAP, nameElement);
			END IF ;
	END;
DELIMITER ;
#------------------------------------------------------------
#addObjectType
#------------------------------------------------------------
DELIMITER |
create procedure boulderdash.addObjectType (IN OType varchar(255))
BEGIN
	IF NOT EXISTS(SELECT * FROM boulderdash.ObjectType WHERE TypeObject = OType) THEN
  INSERT INTO boulderdash.ObjectType (TypeObject) VALUE (OType);
		END IF ;
	END |
DELIMITER ;
#------------------------------------------------------------
#removeMap
#------------------------------------------------------------
DELIMITER |
create procedure boulderdash.removeMap (IN nameMap varchar(255))
	BEGIN
			IF EXISTS(SELECT * FROM Map WHERE MapName = nameMap) THEN
  	DELETE FROM boulderdash.Map WHERE MapName = nameMap;
				END IF;
	END |

DELIMITER ;
#------------------------------------------------------------
#removeMapElement
#------------------------------------------------------------
DELIMITER |
create procedure boulderdash.removeMapElement (IN nameMAP varchar(255), IN nameElement varchar(255))
BEGIN
		IF EXISTS(SELECT * FROM boulderdash.ObjectMap WHERE MapName = nameMAP AND TypeObject = nameElement) THEN
    DELETE FROM boulderdash.ObjectMap WHERE MapName = nameMAP AND TypeObject = nameElement;
			END IF;
	END |
DELIMITER ;
#------------------------------------------------------------
#removeObjectType
#------------------------------------------------------------
DELIMITER |
create procedure boulderdash.removeObjectType (IN OType varchar(255))
BEGIN
	IF EXISTS(SELECT * FROM boulderdash.ObjectType WHERE TypeObject = OType) THEN
  DELETE FROM boulderdash.ObjectType WHERE TypeObject = OType;
		END IF ;
	END |
DELIMITER ;
#------------------------------------------------------------
#getSizeMap
#------------------------------------------------------------
DELIMITER |
CREATE PROCEDURE boulderdash.getSizeMap(IN nameMap VARCHAR(255), OUT outWidth INTEGER, OUT outHeight INTEGER)
	BEGIN
			SELECT Width INTO outWidth FROM boulderdash.Map WHERE MapName = nameMap;
			SELECT Heigth INTO outHeight FROM boulderdash.Map WHERE MapName = nameMap;
	END |
DELIMITER ;
#------------------------------------------------------------
#getMap
#------------------------------------------------------------
DELIMITER |

CREATE PROCEDURE boulderdash.getMap(IN NameMap VARCHAR(255))
  BEGIN
    DECLARE rowcount int;
		IF EXISTS(SELECT * FROM Map WHERE MapName = NameMap) THEN
    	SELECT * FROM Map WHERE MapName = NameMap;
			END IF ;
  END;
DELIMITER ;
#------------------------------------------------------------
#getMapObjects
#------------------------------------------------------------
DELIMITER |
CREATE PROCEDURE boulderdash.getMapObjects(IN NameMap VARCHAR(255))
  BEGIN
    DECLARE rowcount int;
		IF EXISTS(SELECT * FROM Map WHERE MapName = NameMap) THEN
    SELECT * FROM boulderdash.ObjectMap WHERE MapName = NameMap;
			END IF ;
  END;
DELIMITER ;

#------------------------------------------------------------
#getMapObjects
#------------------------------------------------------------
DELIMITER |
CREATE PROCEDURE boulderdash.getMapNames()
  BEGIN
    DECLARE rowcount int;

    SELECT MapName FROM boulderdash.Map;
  END;
DELIMITER ;

