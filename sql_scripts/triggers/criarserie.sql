--------------------------------------------------------
--  Arquivo criado - Terça-feira-Abril-25-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Trigger CRIARSERIE
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BD32017_1212206"."CRIARSERIE" 
BEFORE INSERT ON SERIE
FOR EACH ROW
BEGIN
 IF :NEW.CODSERIE IS NULL 
    THEN
    SELECT CODSERIE.NEXTVAL INTO :NEW.CODSERIE
    FROM DUAL;
 END IF;
END;
/
ALTER TRIGGER "BD32017_1212206"."CRIARSERIE" ENABLE;
