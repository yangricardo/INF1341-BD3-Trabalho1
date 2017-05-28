CREATE VIEW ATLETASCAMPEOES
AS SELECT 
    P.CODPROVA,A.CODATLETA,A.NOME,SC.COLOCACAO,SC.MARCA,M.NOME AS NOME_MODALIDADE
FROM PROVA P
INNER JOIN SERIE S
ON S.CODPROVA = P.CODPROVA
AND S.ETAPA = 'FINAL'
INNER JOIN SERIECLASSIFICACAO SC
ON SC.CODSERIE = S.CODSERIE
AND (SC.COLOCACAO = 1
OR SC.COLOCACAO = 2
OR SC.COLOCACAO = 3)
INNER JOIN ATLETA A
ON SC.CODATLETA = A.CODATLETA
INNER JOIN MODALIDADE M
ON P.CODMODALIDADE = M.CODMODALIDADE
ORDER BY P.CODPROVA ASC,SC.COLOCACAO DESC;
