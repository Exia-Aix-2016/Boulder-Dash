#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------
CREATE DATABASE boulderdash;

#------------------------------------------------------------
# Table: Map
#------------------------------------------------------------

CREATE TABLE boulderdash.Map(
        MapName Varchar (255) NOT NULL ,
        Width   Int NOT NULL ,
        Heigth  Int ,
        PRIMARY KEY (MapName )
);


#------------------------------------------------------------
# Table: ObjectType
#------------------------------------------------------------

CREATE TABLE boulderdash.ObjectType(
        TypeObject Varchar (255) NOT NULL ,
        PRIMARY KEY (TypeObject )
);


#------------------------------------------------------------
# Table: ObjectMap
#------------------------------------------------------------

CREATE TABLE boulderdash.ObjectMap(
        MapName    Varchar (255) NOT NULL ,
        TypeObject Varchar (255) NOT NULL ,
        CoordX     Int NOT NULL ,
        CoordY     Date NOT NULL ,
        PRIMARY KEY (MapName ,TypeObject )
);

ALTER TABLE boulderdash.ObjectMap ADD CONSTRAINT FK_ObjectMap_MapName FOREIGN KEY (MapName) REFERENCES boulderdash.Map(MapName);
ALTER TABLE boulderdash.ObjectMap ADD CONSTRAINT FK_ObjectMap_TypeObject FOREIGN KEY (TypeObject) REFERENCES boulderdash.ObjectType(TypeObject);
