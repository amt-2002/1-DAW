ALTER TABLE FUTBOLISTAS ADD (ALTURA INT);
ALTER TABLE FUTBOLISTAS ADD (PESO NUMBER(4,1));

ALTER TABLE FUTBOLISTAS DROP COLUMN ALTURA;
ALTER TABLE FUTBOLISTAS DROP COLUMN PESO;

SELECT * FROM FUTBOLISTAS;

UPDATE FUTBOLISTAS SET ALTURA = 179, PESO = 76 WHERE ID = 'F00220';
UPDATE FUTBOLISTAS SET ALTURA = 174, PESO = 71.5 WHERE NOMBRE = 'LUIS';
UPDATE FUTBOLISTAS SET ALTURA = 169, PESO = 66 WHERE NOMBRE = 'JESUS';
UPDATE FUTBOLISTAS SET ALTURA = 189, PESO = 82 WHERE NOMBRE = 'DIEGO';
UPDATE FUTBOLISTAS SET ALTURA = 183, PESO = 84 WHERE NOMBRE = 'PABLO';
UPDATE FUTBOLISTAS SET ALTURA = 180, PESO = 81.5 WHERE NOMBRE = 'ESTEBAN';
UPDATE FUTBOLISTAS SET ALTURA = 162, PESO = 60 WHERE NOMBRE = 'ENRIQUE';

COMMIT;

SELECT NOMBRE FROM FUTBOLISTAS WHERE ALTURA = (SELECT MAX(ALTURA) FROM FUTBOLISTAS); -- Mazima altura de los jugadores

SELECT NOMBRE FROM FUTBOLISTAS WHERE PESO = (SELECT MIN(PESO) FROM FUTBOLISTAS); 

SELECT COUNT(*) FROM FUTBOLISTAS WHERE ALTURA BETWEEN 175 AND 182;

SELECT ROUND(AVG(ALTURA), 2) FROM FUTBOLISTAS;

SELECT ROUND(AVG(PESO), 1) FROM FUTBOLISTAS;



