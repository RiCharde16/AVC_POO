# AVC_POO

## Objetivo

Desenvolver um sistema de gerenciamento de um banco de dados, para uma empresa de comércio de qualquer produto ou serviços.

## Diagrama de Classe

No diagrama de classe a seguir temos as classes principais do programa, onde temos a classe Produto que será a classe que vai interagir com todas as outras classes, onde a classe Produto herdara os atributos da classe abstrata Calculo que contém o atributo do desconto além dos métodos de calcular a venda dos produtos e definir o seu desconto, e temos uma interface Estoque para que sejam exibidos todos os produtos cadastrados, assim como um método para calcular a média de preçoo dos produtos.

Assim como a classe Cadastrar possui uma relação de agregação com a classe produto para armazenar cada Produto instanciado em um arrray único do tipo Produto e assim possa ser adicionado, excluído ou modificado conforme cada um dos seus métodos, e a classe Cadastrar vai implementar a classe abstrata Salvar para que assim possar fazer as alterações no arquivo como salvar os dados alterados no array armazenado no programa ou recuperar esses dados em formato de String e transforma-los novamente em uma classe  objeto Produto para que a classe Cadastrar possa novamente manipula-los.


|![diagrama_loja](/diagrama_loja_virtual.png)|
| :--: |
| Diagrama de Classe Loja Virtual |

## Classes Para Implementar

- Salvar / Recuperar
- Cadastrar / Modificar e eliminar
- Calcular a venda e dar descontos percentuais
- Estoque (impressão, calcular media etc)

