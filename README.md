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

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/30817700-d665-42b3-9fcd-b80e0b19ad4c/Untitled.png)

- Agora vamos entrar no **POSTMAN** e **IMPORTAR** esta **COLEÇÃO**.

![foto2.png](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/a1af2dc5-57d0-46e1-b0f7-28a2c95ae5de/foto2.png)

- E depois selecionar a **COLEÇÃO** do projeto e então você já terá **ACESSO** a todos os **ENDPOINTS** disponíveis deste projeto.

# 1) PRIMEIROS PASSOS

- Este programa foi projetado para realizar uma venda completa, ou seja, para a realização de uma venda, devemos ter no **MÍNIMO**, as seguinte entidades criadas**:**
    - 1 vendedor
    - 1 produto
- Então vamos verifcar primeiro, como criar estas entidades...

## 1.1) CRIAR VENDEDOR

- Para fazer isso, basta abrir a **PASTA** da **COLEÇÃO** do **POSTMAN** chamada **“SELLER”**, e dentro dele terá uma **REQUISIÇÃO** do tipo **POST**.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/bbd4b670-9fb1-4e67-af08-5e47d25497b7/Untitled.png)

- Clicando nela, **AUTOMATICAMENTE** o **POSTMAN** irá nos **REDIRECIONAR** para o **ENDPOINT** específico para **CRIAR VENDEDORES**.
- Após isto, precisamos ir em **BODY → RAW,** e aqui já terá um **MOLDE** pronto para você **ADICIONAR** um **VENDEDOR**, podendo apenas alterar as **INFORMAÇÕES** dos **ATRIBUTOS** que estiverem aparecendo na tela do **RAW**.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/b9c2e690-01eb-4329-a7a6-792c12160fbf/Untitled.png)

## 1.2) CRIAR PRODUTO

- Para criar um **PRODUTO** vamos fazer da mesma forma que fizemos com o **VENDEDOR**, porém agora na pasta de **“PRODUCT”**. Nesta pasta temos também uma **REQUISIÇÃO** do tipo **POST** já com um **MOLDE** para a criação de um produto.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/f294fa64-8706-4f85-a3aa-4679544e0b05/Untitled.png)

- Porém, no cadastro de **PRODUTO**, precisaremos inserir o **TIPO** da **CATEGORIA** deste produto, e precisa se **ESCRITO** exatamente igual às **CATEGORIAS** cadastradas (até com as letras **MAIÚSCULAS**). Abaixo segue as **CATEGORIAS CADASTRADAS**:
    - SHIRT
    - PANTS
    - SHOE
    - CAP
    - GLASSES
- Ficará assim:

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/edf5763e-d8e0-4edf-88f5-bb3984d371f1/Untitled.png)

# 2) REALIZAR UMA VENDA

- Para a realização de uma venda, precisaremos **PRIMEIRAMENTE** iniciar a venda informando qual será o **VENDEDOR RESPONSÁVEL** por aquela **VENDA**.
- Então para isso, vamos primeiro na **COLEÇÃO** chamada **“ORDER”** e acessar a **REQUISIÇÃO** do tipo **POST**, que também já terá um **MOLDE** para a criação.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/1a223015-a117-49f8-a611-3999a9eabd8d/Untitled.png)

- Aqui precisaremos inserir um **ID** de algum **VENDEDOR** existente, pois caso o mesmo não esteja cadastrado previamente, não será possível a realização da venda.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/2ce45a39-40c8-4066-ad09-da7ac2c929f5/Untitled.png)

## 2.1) ADICIONAR ITENS À VENDA

- Perceba que quando iniciamos a **VENDA** informando o **VENDEDOR**, ela iniciou com o valor **ZERO**, agora precisaremos **INSERIR** os **PRODUTOS** nesta venda, para isso vamos **UTILIZAR** a pasta chamada **“ORDER ITEM”**, onde informaremos o **ID** do **PRODUTO** e a **QUANTIDADE** a ser adicionada deste mesmo produto.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/624016f2-0e9c-4069-8961-19ad81ffd844/Untitled.png)

- Porém perceba que agora na **URL** da **REQUISIÇÃO**, precisaremos informar qual é o **ID** do **“ORDER”** que queremos **ADICIONAR** o determinado **PRODUTO**, e também inserir **“orderitems”** no final.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/fb587892-d193-434f-baf1-7d982b02c5bf/Untitled.png)

- O sistema irá verificar o **PREÇO** que foi **CADASTRADO** para o **PRODUTO** informado, e irá realizar o **CÁLCULO** do **SUBTOTAL** de cada **PRODUTO**, e depois irá **ADICIONAR** para o valor **TOTAL** da **VENDA**.

# 3) PAGAMENTO

- Após adicionado todos os **PRODUTOS** desejados com suas devidas **QUANTIDADES** na **VENDA**, vamos agora realizar o **PAGAMENTO** desta venda.
- Para isso, devemos ir na pasta chamada **“PAYMENT”** e acessar a **REQUISIÇÃO** do tipo **POST**.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/9403b3d0-d3a3-4e19-aac9-f82cf8e36958/Untitled.png)

- Aqui novamente precisaremos inserir o **ID** do **“ORDER”** específica na **URL** da **REQUISIÇÃO**, e também inserir a palavra **“payment”** no final, para que o sistema saiba qual é a **VENDA** que deseja realizar o **PAGAMENTO**.
- Após isto, já tem um **MOLDE** pronto para a criação de um **PAGAMENTO**, porém perceba que precisaremos informar o **TIPO** de **PAGAMENTO**, e da mesma forma que a **CATEGORIA** do **PRODUTO**, precisaremos também inserir **EXATAMENTE IGUAL** ao que está cadastrado. Segue abaixo os tipos:
    - DEBIT
    - CREDIT
    - MONEY
- Depois disso, precisaremos também informar o **VALOR** que está sendo **PAGO**, lembrando que este valor **NÃO PODE** ser **MENOR** que o valor **TOTAL** da venda, se não irá dar erro de pagamento, e caso seja um valor **MAIOR**, será informado no **ATRIBUTO** chamado **“moneyChange”** o valor a ser retornado de **TROCO**.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/1ef2b268-7813-40d7-b12b-0b6f7caad600/Untitled.png)

- Após ser realizar o **PAGAMENTO**, o **STATUS** da **VENDA** será alterada de **“WAITING_PAYMENT”** para **“PAID”**.

# 4) RELATÓRIO DE VENDAS

- Após realizado todo o **PROCESSO** de uma **VENDA**, podemos também retirar um **RELATÓRIO DE VENDAS** de **TODOS OS VENDEDORES**, porém será considerado apenas as **VENDAS** com o **STATUS** de **“PAID”**.
- Para isso, vamos ir na pasta **“SELLER”** e acessar a **REQUISIÇÃO** chamado **“GET SALES”**.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/7cbe6cd8-e51d-4de3-a029-104ad5d7a910/Untitled.png)

- Após isto, temos **2 FORMATOS** para a **CONSULTA**:

## 4.1) SEM PARÂMETROS

- Caso não seja informado nenhum **PERÍODO**, será **RETORNADO** o **TOTAL** de **VENDAS** dos **VENDEDORES**, porém sem o **CÁLCULO** de **MÉDIA** de **VENDAS** por **DIA**.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/8fd5c809-8c65-4a35-81db-86ac99abc59d/Untitled.png)

## 4.2) COM PARÂMETRO

- Porém caso seja informado algum **PARÂMETRO**, tanto de **DATA MÍNIMA** quanto de **DATA MÁXIMA**, será **FILTRADO** as **VENDAS** com o status de **PAID** neste **PERÍODO** informado e também o resultado da **MÉDIA** de **VENDAS POR DIA** de acordo com o período informado.
- Caso o **VENDEDOR** não possua **NENHUMA VENDA** neste período, ele não irá **CONSTAR** no **RELATÓRIO**.
- Perceba que ja deixei pronto os **PARÂMETROS** das **DATAS** para serem utilizadas, para não precisar escrever **MANUALMENTE** a **CONSULTA**, então basta clicar no **CHECK-BOX** do atributo e no **“VALUE”** inserir a **DATA** desejada, com o formato “aaaa-mm-dd”.

![Untitled](https://s3-us-west-2.amazonaws.com/secure.notion-static.com/d8a12053-2a01-46e7-8783-41b6700e6466/Untitled.png)

# CONCLUSÃO

- Então como vimos, para a realização de uma **VENDA**, precisaremos previamente criar os **VENDEDORES** e os **PRODUTO**, depois precisaremos **INICIAR** uma **VENDA** informando o **VENDEDOR** responsável por aquela venda, após vamos então inserir os **PRODUTOS** com suas **QUANTIDADES** na **VENDA** específicada na **URL** da requisição, depois realizar então o **PAGAMENTO** da venda, para que então no final, possamos retirar o **RELATÓRIO** de vendas de algum vendedor.