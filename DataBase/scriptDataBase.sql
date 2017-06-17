
CREATE DATABASE boulderdash;
create table boulderdash.Map
(
	MapName varchar(255) not null
		primary key,
	Width int null,
	Heigth int null
)
;

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

create table boulderdash.ObjectType
(
	TypeObject varchar(255) not null
		primary key
)
;

alter table boulderdash.ObjectMap
	add constraint ObjectMap_ObjectType_TypeObject_fk
		foreign key (TypeObject) references boulderdash.ObjectType (TypeObject)
			on update cascade
;

INSERT INTO boulderdash.ObjectType (TypeObject) VALUES ('CHARACTER');
INSERT INTO boulderdash.ObjectType (TypeObject) VALUES ('DIAMOND');
INSERT INTO boulderdash.ObjectType (TypeObject) VALUES ('DIRT');
INSERT INTO boulderdash.ObjectType (TypeObject) VALUES ('MONSTER');
INSERT INTO boulderdash.ObjectType (TypeObject) VALUES ('ROCK');
INSERT INTO boulderdash.ObjectType (TypeObject) VALUES ('WALL');

create procedure boulderdash.addMap (IN nameMap varchar(255), IN width int, IN heigh int)
BEGIN
  INSERT INTO boulderdash.Map (MapName, Width, Heigth) VALUES (nameMap, width, heigh);
END;

create procedure boulderdash.addMapElement (IN nameMAP varchar(255), IN nameElement varchar(255), IN X int, IN Y int)
BEGIN
    INSERT INTO boulderdash.ObjectMap (CoordX, CoordY, MapName, TypeObject) VALUES (X, Y, nameMAP, nameElement);
  END;

create procedure boulderdash.addObjectType (IN OType varchar(255))
BEGIN

  INSERT INTO boulderdash.ObjectType (TypeObject) VALUE (OType);

END;

create procedure boulderdash.removeMap (IN nameMap varchar(255))
BEGIN
  DELETE FROM boulderdash.Map WHERE MapName = nameMap;
END;

create procedure boulderdash.removeMapElement (IN nameMAP varchar(255), IN nameElement varchar(255))
BEGIN
    DELETE FROM boulderdash.ObjectMap WHERE MapName = nameMAP AND TypeObject = nameElement;
  END;

create procedure boulderdash.removeObjectType (IN OType varchar(255))
BEGIN

  DELETE FROM boulderdash.ObjectType WHERE TypeObject = OType;

END;
