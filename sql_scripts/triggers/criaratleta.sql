--------------------------------------------------------
--  Arquivo criado - Terça-feira-Abril-25-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Trigger CRIARATLETA
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BD32017_1212206"."CRIARATLETA" 
BEFORE INSERT ON ATLETA
FOR EACH ROW
BEGIN
 IF :NEW.CODATLETA IS NULL 
    THEN
    SELECT CODATLETA.NEXTVAL INTO :NEW.CODATLETA
    FROM DUAL;
 END IF;
END;
/
ALTER TRIGGER "BD32017_1212206"."CRIARATLETA" ENABLE;
