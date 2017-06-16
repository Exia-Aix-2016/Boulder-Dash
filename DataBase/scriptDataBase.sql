#------------------------------------------------------------
#        Script MySQL.
#------------------------------------------------------------


#------------------------------------------------------------
# Table: Map
#------------------------------------------------------------

CREATE TABLE Map(
        Id     int (11) Auto_increment  NOT NULL ,
        Nom    Varchar (25) NOT NULL ,
        Width  Int NOT NULL ,
        Heigth Int ,
        PRIMARY KEY (Id )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: ObjectType
#------------------------------------------------------------

CREATE TABLE ObjectType(
        Type Varchar (25) NOT NULL ,
        PRIMARY KEY (Type )
)ENGINE=InnoDB;


#------------------------------------------------------------
# Table: ObjectMap
#------------------------------------------------------------

CREATE TABLE ObjectMap(
        CoordX Int NOT NULL ,
        CoordY Date NOT NULL ,
        Id     Int NOT NULL ,
        Type   Varchar (25) NOT NULL ,
        PRIMARY KEY (Id ,Type )
)ENGINE=InnoDB;

ALTER TABLE ObjectMap ADD CONSTRAINT FK_ObjectMap_Id FOREIGN KEY (Id) REFERENCES Map(Id);
ALTER TABLE ObjectMap ADD CONSTRAINT FK_ObjectMap_Type FOREIGN KEY (Type) REFERENCES ObjectType(Type);
