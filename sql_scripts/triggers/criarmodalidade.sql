CREATE OR REPLACE TRIGGER CRIARMODALIDADE 
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
ALTER TRIGGER CRIARMODALIDADE ENABLE;
