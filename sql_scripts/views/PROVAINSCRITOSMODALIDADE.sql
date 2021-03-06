CREATE VIEW PROVAINSCRITOSMODALIDADE
AS SELECT 
    PI.CODPROVA,M.CODMODALIDADE,M.NOME AS NOME_MODALIDADE,A.CODATLETA,A.NOME AS NOME_ATLETA,A.SEXO,CALCULA_NOTA_GERAL(M.CODMODALIDADE,A.CODATLETA) AS NOTAGERAL
FROM PROVAINSCRITOS PI
INNER JOIN PROVA P
ON PI.CODPROVA = P.CODPROVA
INNER JOIN ATLETA A
ON PI.CODATLETA = A.CODATLETA
AND P.SEXO = A.SEXO
INNER JOIN MODALIDADE M
ON P.CODMODALIDADE = M.CODMODALIDADE;
