Avalia��o pratica de Algoritmos Geneticos para Otimiza��o de vendas de produtos.

Quest�o 1 - Qual forma de representa��o dos indiv�duos foi utilizada para representar cada solu��o
A representa��o foi feita via representa��o cont�nua, sendo o Indiv�duo com 4 GEN�s a produ��o final e cada GEN um produto representado como x. 
O Cromossomo do indiv�duo receber� n�meros aleat�rios de 1 a 400. Ex.: x x x x => 40 110 230 20. A soma dos GENs n�o ultrapassar� o estoque de material dispon�vel na primeira popula��o.
Quest�o 2 - Como foi feito o c�lculo do fitness de cada poss�vel solu��o
O c�lculo do fitness foi baseado no gasto multiplicado pelo n�mero definido no GEN menos o lucro multiplicado pelo n�mero definido no GEN. A penalidade se baseia na multiplica��o do 
n�mero definido em cada GEN com o custo e tamb�m com o tempo, somando os resultados de cada GEN no final e comparando com o que tem dispon�vel em estoque. Caso ultrapasse, a penalidade ao fitness ser� de 
R$50.000(Quanto maior o fitness pior fica, pois se trata da diferen�a entre gastos e lucros, quando menor a diferen�a, maior o lucro.)
Quest�o 3 - Qual percentual de muta��o gen�tica (caso tenha sido utilizada)
1%
Quest�o 4 - Como se deu o m�todo de sele��o dos indiv�duos para reprodu��o no momento de estabelecer as pr�ximas gera��es
Roleta
Quest�o 5 - Qual o crit�rio de parada.
Avaliada que ap�s alguma gera��es o fitness tende a aumentar muito, ent�o ficou fixada em apenas 4 gera��es.