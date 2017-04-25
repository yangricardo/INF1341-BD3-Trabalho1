--------------------------------------------------------
--  Arquivo criado - Terça-feira-Abril-25-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Trigger CRIARTORNEIO
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BD32017_1212206"."CRIARTORNEIO" 
BEFORE INSERT ON TORNEIO
FOR EACH ROW
BEGIN
 IF :NEW.CODTORNEIO IS NULL 
    THEN
    SELECT CODTORNEIO.NEXTVAL INTO :NEW.CODTORNEIO
    FROM DUAL;
 END IF;
END;
/
ALTER TRIGGER "BD32017_1212206"."CRIARTORNEIO" ENABLE;
