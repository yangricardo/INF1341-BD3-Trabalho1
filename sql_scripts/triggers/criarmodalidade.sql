--------------------------------------------------------
--  Arquivo criado - Terça-feira-Abril-25-2017   
--------------------------------------------------------
--------------------------------------------------------
--  DDL for Trigger CRIARMODALIDADE
--------------------------------------------------------

  CREATE OR REPLACE TRIGGER "BD32017_1212206"."CRIARMODALIDADE" 
BEFORE INSERT ON MODALIDADE
FOR EACH ROW
BEGIN
 IF :NEW.CODMODALIDADE IS NULL 
    THEN
    SELECT CODMODALIDADE.NEXTVAL INTO :NEW.CODMODALIDADE
    FROM DUAL;
 END IF;
END;
/
ALTER TRIGGER "BD32017_1212206"."CRIARMODALIDADE" ENABLE;
