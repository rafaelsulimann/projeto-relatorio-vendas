# PROJETO XBRAIN - RELATORIO DE VENDAS

## INTRODUÇÃO

Este projeto é uma API de vendas que também possibilita a consulta do número de vendas dos vendedores por período.

Realizo então o **BACKEND** para todo o funcionamento da mesma, realizando o **CRUD** completo para todas entidades com implementação de: 

- Validações
- Filtros
- Dtos
- E muito mais...

Foi feito o **DEPLOY** da API na nuvem do **HEROKU** para que possa ser acessado online.

Pois desta forma, caso queira testar a API, não será necessário baixar nem instalar nada.

## COMO ACESSAR A API?

A API pode ser acessada através dos **ENDPOINTS** disponíveis através da URL do **HEROKU**.

A URL da API é:

- [https://projeto-xbrain.herokuapp.com](https://projeto-xbrain.herokuapp.com/)

Porém só será possível acessar a API através dos ENDPOINTS, e para isso será necessário a utilização do aplicativo **POSTMAN** onde você pode fazer as **REQUISIÇÕES** da API:

- GET (acessar as entidades)
- POST (inserir entidades)
- PUT (atualizar entidades)
- DELETE (deletar entidades)

# ENDPOINTS DISPONÍVEIS

- Para facilitar, na **PASTA “POSTMAN COLLECTION”** do projeto contém uma **COLEÇÃO COMPLETA** dos **ENDPOINTS** disponíveis, e vem até com o **FILTRO** da data para filtras as vendas do usuário. Lembrando que os **FILTROS** podem ser **CONFIGURADOS** pelo **PROPRIO USUÁRIO** de acordo com o que ele deseja filtrar.

![1](https://user-images.githubusercontent.com/97992737/168383674-265179d6-9703-4122-9b1e-2a6f9925f70f.jpg)

- Agora vamos entrar no **POSTMAN** e **IMPORTAR** esta **COLEÇÃO**.

![2](https://user-images.githubusercontent.com/97992737/168383784-20ae3e56-e295-4866-ada3-b508b7e0b49e.jpg)

- E depois selecionar a **COLEÇÃO** do projeto e então você já terá **ACESSO** a todos os **ENDPOINTS** disponíveis deste projeto.

# 1) PRIMEIROS PASSOS

- Este programa foi projetado para realizar uma venda completa, ou seja, para a realização de uma venda, devemos ter no **MÍNIMO**, as seguinte entidades criadas**:**
    - 1 vendedor
    - 1 produto
- Então vamos verifcar primeiro, como criar estas entidades...

## 1.1) CRIAR VENDEDOR

- Para fazer isso, basta abrir a **PASTA** da **COLEÇÃO** do **POSTMAN** chamada **“SELLER”**, e dentro dele terá uma **REQUISIÇÃO** do tipo **POST**.

![3](https://user-images.githubusercontent.com/97992737/168383844-828e7e00-5073-4c48-871f-b71adc736f14.jpg)

- Clicando nela, **AUTOMATICAMENTE** o **POSTMAN** irá nos **REDIRECIONAR** para o **ENDPOINT** específico para **CRIAR VENDEDORES**.
- Após isto, precisamos ir em **BODY → RAW,** e aqui já terá um **MOLDE** pronto para você **ADICIONAR** um **VENDEDOR**, podendo apenas alterar as **INFORMAÇÕES** dos **ATRIBUTOS** que estiverem aparecendo na tela do **RAW**.

![4](https://user-images.githubusercontent.com/97992737/168383886-a05ce00f-b774-4660-8286-990ca39253d6.jpg)

## 1.2) CRIAR PRODUTO

- Para criar um **PRODUTO** vamos fazer da mesma forma que fizemos com o **VENDEDOR**, porém agora na pasta de **“PRODUCT”**. Nesta pasta temos também uma **REQUISIÇÃO** do tipo **POST** já com um **MOLDE** para a criação de um produto.

![5](https://user-images.githubusercontent.com/97992737/168383920-a5fcd809-e33b-445f-bb2b-1ec3dde474a4.jpg)

- Porém, no cadastro de **PRODUTO**, precisaremos inserir o **TIPO** da **CATEGORIA** deste produto, e precisa se **ESCRITO** exatamente igual às **CATEGORIAS** cadastradas (até com as letras **MAIÚSCULAS**). Abaixo segue as **CATEGORIAS CADASTRADAS**:
    - SHIRT
    - PANTS
    - SHOE
    - CAP
    - GLASSES
- Ficará assim:

![6](https://user-images.githubusercontent.com/97992737/168383955-68c64a83-e87b-49be-91c3-d584c9afd8f3.jpg)

# 2) REALIZAR UMA VENDA

- Para a realização de uma venda, precisaremos **PRIMEIRAMENTE** iniciar a venda informando qual será o **VENDEDOR RESPONSÁVEL** por aquela **VENDA**.
- Então para isso, vamos primeiro na **COLEÇÃO** chamada **“ORDER”** e acessar a **REQUISIÇÃO** do tipo **POST**, que também já terá um **MOLDE** para a criação.

![7](https://user-images.githubusercontent.com/97992737/168383994-97bc7001-8fae-41f3-b869-4d1c33f80c74.jpg)

- Aqui precisaremos inserir um **ID** de algum **VENDEDOR** existente, pois caso o mesmo não esteja cadastrado previamente, não será possível a realização da venda.

![8](https://user-images.githubusercontent.com/97992737/168384023-5f15adf1-8b3f-4618-a8d8-a365725a66bc.jpg)

## 2.1) ADICIONAR ITENS À VENDA

- Perceba que quando iniciamos a **VENDA** informando o **VENDEDOR**, ela iniciou com o valor **ZERO**, agora precisaremos **INSERIR** os **PRODUTOS** nesta venda, para isso vamos **UTILIZAR** a pasta chamada **“ORDER ITEM”**, onde informaremos o **ID** do **PRODUTO** e a **QUANTIDADE** a ser adicionada deste mesmo produto.

![9](https://user-images.githubusercontent.com/97992737/168384049-d1301cfd-dea2-46aa-ab90-2c1110ff15f5.jpg)

- Porém perceba que agora na **URL** da **REQUISIÇÃO**, precisaremos informar qual é o **ID** do **“ORDER”** que queremos **ADICIONAR** o determinado **PRODUTO**, e também inserir **“orderitems”** no final.

![10](https://user-images.githubusercontent.com/97992737/168384090-b404a0e5-d057-40dd-8eb1-ce6e3a4dd893.jpg)

- O sistema irá verificar o **PREÇO** que foi **CADASTRADO** para o **PRODUTO** informado, e irá realizar o **CÁLCULO** do **SUBTOTAL** de cada **PRODUTO**, e depois irá **ADICIONAR** para o valor **TOTAL** da **VENDA**.

# 3) PAGAMENTO

- Após adicionado todos os **PRODUTOS** desejados com suas devidas **QUANTIDADES** na **VENDA**, vamos agora realizar o **PAGAMENTO** desta venda.
- Para isso, devemos ir na pasta chamada **“PAYMENT”** e acessar a **REQUISIÇÃO** do tipo **POST**.

![11](https://user-images.githubusercontent.com/97992737/168384122-aeb82972-8ce0-40cf-a669-88a3a0dce1d3.jpg)

- Aqui novamente precisaremos inserir o **ID** do **“ORDER”** específica na **URL** da **REQUISIÇÃO**, e também inserir a palavra **“payment”** no final, para que o sistema saiba qual é a **VENDA** que deseja realizar o **PAGAMENTO**.
- Após isto, já tem um **MOLDE** pronto para a criação de um **PAGAMENTO**, porém perceba que precisaremos informar o **TIPO** de **PAGAMENTO**, e da mesma forma que a **CATEGORIA** do **PRODUTO**, precisaremos também inserir **EXATAMENTE IGUAL** ao que está cadastrado. Segue abaixo os tipos:
    - DEBIT
    - CREDIT
    - MONEY
- Depois disso, precisaremos também informar o **VALOR** que está sendo **PAGO**, lembrando que este valor **NÃO PODE** ser **MENOR** que o valor **TOTAL** da venda, se não irá dar erro de pagamento, e caso seja um valor **MAIOR**, será informado no **ATRIBUTO** chamado **“moneyChange”** o valor a ser retornado de **TROCO**.

![12](https://user-images.githubusercontent.com/97992737/168384141-134b86f3-f062-43d4-af2b-615a0dac01d4.jpg)

- Após ser realizar o **PAGAMENTO**, o **STATUS** da **VENDA** será alterada de **“WAITING_PAYMENT”** para **“PAID”**.

# 4) RELATÓRIO DE VENDAS

- Após realizado todo o **PROCESSO** de uma **VENDA**, podemos também retirar um **RELATÓRIO DE VENDAS** de **TODOS OS VENDEDORES**, porém será considerado apenas as **VENDAS** com o **STATUS** de **“PAID”**.
- Para isso, vamos ir na pasta **“SELLER”** e acessar a **REQUISIÇÃO** chamado **“GET SALES”**.

![13](https://user-images.githubusercontent.com/97992737/168384181-9004fcd9-a783-4e8d-8d25-8c86a79b1c93.jpg)

- Após isto, temos **2 FORMATOS** para a **CONSULTA**:

## 4.1) SEM PARÂMETROS

- Caso não seja informado nenhum **PERÍODO**, será **RETORNADO** o **TOTAL** de **VENDAS** dos **VENDEDORES**, porém sem o **CÁLCULO** de **MÉDIA** de **VENDAS** por **DIA**.

![14](https://user-images.githubusercontent.com/97992737/168384265-48df034a-7fde-4212-8830-410e8ea31071.jpg)

## 4.2) COM PARÂMETRO

- Porém caso seja informado algum **PARÂMETRO**, tanto de **DATA MÍNIMA** quanto de **DATA MÁXIMA**, será **FILTRADO** as **VENDAS** com o status de **PAID** neste **PERÍODO** informado e também o resultado da **MÉDIA** de **VENDAS POR DIA** de acordo com o período informado.
- Caso o **VENDEDOR** não possua **NENHUMA VENDA** neste período, ele não irá **CONSTAR** no **RELATÓRIO**.
- Perceba que ja deixei pronto os **PARÂMETROS** das **DATAS** para serem utilizadas, para não precisar escrever **MANUALMENTE** a **CONSULTA**, então basta clicar no **CHECK-BOX** do atributo e no **“VALUE”** inserir a **DATA** desejada, com o formato “aaaa-mm-dd”.

![15](https://user-images.githubusercontent.com/97992737/168384290-f94322fe-86e6-4db1-bb68-1b28f041dbaf.jpg)

# CONCLUSÃO

- Então como vimos, para a realização de uma **VENDA**, precisaremos previamente criar os **VENDEDORES** e os **PRODUTO**, depois precisaremos **INICIAR** uma **VENDA** informando o **VENDEDOR** responsável por aquela venda, após vamos então inserir os **PRODUTOS** com suas **QUANTIDADES** na **VENDA** específicada na **URL** da requisição, depois realizar então o **PAGAMENTO** da venda, para que então no final, possamos retirar o **RELATÓRIO** de vendas de algum vendedor.
