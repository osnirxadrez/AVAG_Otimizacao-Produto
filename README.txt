Avalia��o pratica de Algoritmos Geneticos para Otimiza��o de vendas de produtos.

Quest�o 1 - Qual forma de representa��o dos indiv�duos foi utilizada para representar cada solu��o
A representa��o foi feita via representa��o cont�nua, sendo o Indiv�duo com 4 GEN�s a produ��o final e cada GEN um produto representado como x. O Cromossomo do indiv�duo receber� n�meros aleat�rios de 1 a 400. Ex.: x x x x => 40 150 230 20.
Quest�o 2 - Como foi feito o c�lculo do fitness de cada poss�vel solu��o
O c�lculo do fitness foi baseado no lucro multiplicado pelo n�mero definido no GEN. A penalidade se baseia na multiplica��o do n�mero definido em cada GEN com o custo, e tamb�m com o tempo, somando os resultados de cada GEN no final e comparando com o que tem dispon�vel em estoque. Caso ultrapasse, a penalidade ao fitness ser� de R$56.000(?)(Apr�x. metade do total de lucro poss�vel).
Quest�o 3 - Qual percentual de muta��o gen�tica (caso tenha sido utilizada)
1%(?)
Quest�o 4 - Como se deu o m�todo de sele��o dos indiv�duos para reprodu��o no momento de estabelecer as pr�ximas gera��es
Roleta(?)
Quest�o 5 - Qual o crit�rio de parada.
Se aproximar do lucro total poss�vel.(?)
