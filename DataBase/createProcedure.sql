

DELIMITER |
CREATE PROCEDURE boulderdash.addObjectType(IN OType VARCHAR(255))
BEGIN

  INSERT INTO boulderdash.ObjectType (Type) VALUE (OType);

END |
DELIMITER ;

DELIMITER |
CREATE PROCEDURE boulderdash.removeObjectType(IN OType VARCHAR(255))
BEGIN

  DELETE FROM boulderdash.ObjectType WHERE Type = OType;

END |
DELIMITER ;


DELIMITER |
CREATE PROCEDURE boulderdash.addMap(IN nameMap VARCHAR(255), IN width int, IN heigh int)
BEGIN
  INSERT INTO boulderdash.Map (Nom, Width, Heigth) VALUES (nameMap, width, heigh);
END |
DELIMITER ;

DELIMITER |
CREATE PROCEDURE boulderdash.removeMap(IN nameMap VARCHAR(255))
BEGIN
  DELETE FROM boulderdash.Map WHERE Nom = nameMap;
END |
DELIMITER ;