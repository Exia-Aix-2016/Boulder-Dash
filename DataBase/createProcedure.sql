

DELIMITER |
CREATE PROCEDURE boulderdash.addObjectType(IN OType VARCHAR(255))
BEGIN

  INSERT INTO boulderdash.ObjectType (TypeObject) VALUE (OType);

END |
DELIMITER ;

DELIMITER |
CREATE PROCEDURE boulderdash.removeObjectType(IN OType VARCHAR(255))
BEGIN

  DELETE FROM boulderdash.ObjectType WHERE TypeObject = OType;

END |
DELIMITER ;

DELIMITER |
CREATE PROCEDURE boulderdash.addMap(IN nameMap VARCHAR(255), IN width int, IN heigh int)
BEGIN
  INSERT INTO boulderdash.Map (MapName, Width, Heigth) VALUES (nameMap, width, heigh);
END |
DELIMITER ;

DELIMITER |
CREATE PROCEDURE boulderdash.removeMap(IN nameMap VARCHAR(255))
BEGIN
  DELETE FROM boulderdash.Map WHERE MapName = nameMap;
END |
DELIMITER ;

DELIMITER |
CREATE PROCEDURE boulderdash.addMapElement(IN nameMAP VARCHAR(255), IN nameElement VARCHAR(255), IN X int, IN Y int)
  BEGIN
    INSERT INTO boulderdash.ObjectMap (CoordX, CoordY, MapName, TypeObject) VALUES (X, Y, nameMAP, nameElement);
  END |
DELIMITER ;

DELIMITER |
CREATE PROCEDURE boulderdash.removeMapElement(IN nameMAP VARCHAR(255), IN nameElement VARCHAR(255))
  BEGIN
    DELETE FROM boulderdash.ObjectMap WHERE MapName = nameMAP AND TypeObject = nameElement;
  END |
DELIMITER ;
