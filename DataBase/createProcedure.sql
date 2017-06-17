

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
