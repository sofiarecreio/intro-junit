# Comparação isolada — Calculadora e Carrinho

Cada execução foi separada para medir uma única classe e uma única suíte: as classes `CalculadoraTest` e `CarrinhoTest` existentes no repositório (testes próprios) ou as classes `CalculadoraTestGPT` e `CarrinhoTestGPT` (testes identificados como GPT). JaCoCo 0.8.13 e PIT 1.17.4 geraram os relatórios. Todas as suítes passaram sem falhas.

## Resultados

| Classe / suíte | Testes | Nós (linhas JaCoCo) | Arestas decisórias (branches JaCoCo) | Ciclomática | PIT mortos / válidos | Escore PIT |
|---|---:|---:|---:|---:|---:|---:|
| Calculadora — próprios | 11 | 18/18 (100%) | 8/8 (100%) | 12 | 16/19 | 84,21% (84% no PIT) |
| Calculadora — GPT | 31 | 18/18 (100%) | 8/8 (100%) | 12 | 17/19 | 89,47% (89% no PIT) |
| Carrinho — próprios | 7 | 17/17 (100%) | 4/4 (100%) | 8 | 6/6 | 100% |
| Carrinho — GPT | 6 | 17/17 (100%) | 4/4 (100%) | 8 | 6/6 | 100% |

Complexidade ciclomática é propriedade do código, não da suíte, então não muda entre as duas execuções da mesma classe. JaCoCo contabiliza cobertura de linhas e saídas dos desvios (branches); seu relatório não calcula diretamente cobertura de todas as arestas sequenciais de um CFG formal. Por isso, o critério de arestas aqui é reportado como cobertura dos desvios instrumentados.

## Arquivos para upload

Os oito PNGs são capturas dos relatórios gerados por JaCoCo/PIT. Cada um é um arquivo individual:

1. Cobertura estrutural — Calculadora, testes próprios: [01-estrutural-calculadora-testes-proprios.png](para-upload/01-estrutural-calculadora-testes-proprios.png)
2. Mutação — Calculadora, testes próprios: [02-mutacao-calculadora-testes-proprios.png](para-upload/02-mutacao-calculadora-testes-proprios.png)
3. Cobertura estrutural — Calculadora, testes GPT: [03-estrutural-calculadora-testes-chatgpt.png](para-upload/03-estrutural-calculadora-testes-chatgpt.png)
4. Mutação — Calculadora, testes GPT: [04-mutacao-calculadora-testes-chatgpt.png](para-upload/04-mutacao-calculadora-testes-chatgpt.png)
5. Cobertura estrutural — Carrinho, testes próprios: [05-estrutural-carrinho-testes-proprios.png](para-upload/05-estrutural-carrinho-testes-proprios.png)
6. Mutação — Carrinho, testes próprios: [06-mutacao-carrinho-testes-proprios.png](para-upload/06-mutacao-carrinho-testes-proprios.png)
7. Cobertura estrutural — Carrinho, testes GPT: [07-estrutural-carrinho-testes-chatgpt.png](para-upload/07-estrutural-carrinho-testes-chatgpt.png)
8. Mutação — Carrinho, testes GPT: [08-mutacao-carrinho-testes-chatgpt.png](para-upload/08-mutacao-carrinho-testes-chatgpt.png)

## Quais testes obtiveram melhores resultados?

Em cobertura estrutural, houve empate: ambas as suítes atingiram 100% das linhas e dos branches medidos em cada classe. Em Carrinho, também houve empate na mutação: 6/6 mutantes mortos para ambas.

Em Calculadora, os testes GPT tiveram o melhor escore de mutação: 17/19 (89,47%) contra 16/19 (84,21%) dos testes próprios. Eles detectaram um mutante adicional, apesar de a cobertura estrutural ser igual. Assim, considerando a capacidade de revelar erros semeados pelo PIT, os testes GPT foram ligeiramente melhores para Calculadora; não houve diferença em Carrinho. Os mutantes que sobreviveram podem ser inspecionados no relatório HTML completo do PIT arquivado em `ferramentas/mutacao-calculadora-proprios/pit/` e `ferramentas/mutacao-calculadora-chatgpt/pit/`.

## Relatórios completos da ferramenta

As capturas PNG são para envio unitário. Os relatórios HTML originais, incluindo navegação detalhada por método e mutante, foram guardados nas pastas em [ferramentas](ferramentas/). Para abrir um relatório estrutural, use `jacoco/calculadora/Calculadora.html` ou `jacoco/carrinho/Carrinho.html`; para mutação, abra `pit/index.html` ou o relatório da classe dentro da pasta da execução.
