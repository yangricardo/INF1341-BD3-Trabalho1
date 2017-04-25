--------------------------------------------------------
--  Arquivo criado - Terça-feira-Abril-25-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Trigger CRIARPROVA
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BD32017_1212206"."CRIARPROVA" 
BEFORE INSERT ON PROVA
FOR EACH ROW
BEGIN
 IF :NEW.CODPROVA IS NULL 
    THEN
    SELECT CODPROVA.NEXTVAL INTO :NEW.CODPROVA
    FROM DUAL;
 END IF;
END;
/
ALTER TRIGGER "BD32017_1212206"."CRIARPROVA" ENABLE;
