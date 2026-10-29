# 🛒 Mini Loja

Programa de console em Java que simula o carrinho de uma loja: lê os produtos digitados, mostra cada um e calcula o **subtotal**, o **desconto**, o **frete** e o **total** da compra.

Projeto de estudo do curso *Java COMPLETO: Programação Orientada a Objetos + Projetos* (Nélio Alves), para praticar sobrescrita de `toString`, constantes e membros estáticos.

---

## 📋 Regras de negócio

| Regra | Valor |
|---|---|
| Desconto | **10%** sobre o subtotal, só a partir de **R$ 1000,00** (inclusive) |
| Frete | **R$ 30,00**, cobrado quando o total com desconto fica **abaixo** de R$ 800,00 |
| Frete grátis | A partir de **R$ 800,00** (inclusive), já considerando o desconto |

O frete é calculado sobre o valor **depois** do desconto.

---

## 🧱 Estrutura do projeto

```
MiniLoja/
├── .gitignore
└── src/
    └── poo/
        └── MiniLoja/
            ├── Produto.java
            ├── CalculadoraPreco.java
            └── Programa.java
```

| Classe | Responsabilidade |
|---|---|
| `Produto` | Guarda `nome`, `preco` e `quantidade`. Calcula o `subtotal()` do item e sobrescreve o `toString()` para exibir o produto formatado. |
| `CalculadoraPreco` | Classe utilitária só com membros estáticos: as constantes das regras de negócio e os métodos `desconto` e `frete`. Não é instanciada. |
| `Programa` | Lê os dados com `Scanner`, cria os produtos, acumula o subtotal geral e imprime o resumo. |

---

## 🎯 Conceitos praticados

- **Sobrescrita de `toString`** com `@Override`, usando a classe `Object`
- **Formatação de números** com `String.format("%.2f", ...)` e `printf`
- **Constantes** com `public static final`
- **Métodos estáticos** chamados direto pelo nome da classe, sem `new`
- **Classe utilitária** (só membros estáticos)
- **Construtor** e uso de `this`
- **Leitura de dados** com `Scanner`, incluindo a limpeza da quebra de linha que sobra após `nextInt()` e `nextDouble()`
- **Laço `for`** com variável acumuladora

---

## ▶️ Como executar

Pré-requisito: **JDK 17 ou superior** instalado.

### Pelo terminal

Na raiz do projeto:

```bash
javac -d out src/poo/MiniLoja/*.java
java -cp out poo.MiniLoja.Programa
```

### Pelo IntelliJ

Abra a pasta do projeto e execute a classe `Programa`.

> Os preços são digitados com **ponto** como separador decimal (`50.00`), pois o programa usa `Locale.US`.

---

## 💻 Exemplo de uso

**Entrada:**

```
3
Mouse
50.00
2
Teclado
150.00
1
Monitor
900.00
1
```

**Saída (resumo):**

```
Mouse, R$ 50.00, 2 unidades
Teclado, R$ 150.00, 1 unidades
Monitor, R$ 900.00, 1 unidades
-----------------------------------
Subtotal: R$ 1150.00
-----------------------------------
Desconto (10%): R$ 115.00
-----------------------------------
Frete: R$ 0.00
-----------------------------------
Total: R$ 1035.00
```

---

## 🧪 Cenários de teste

Cada cenário usa um único produto.

| Preço × unidades | Subtotal | Desconto | Frete | Total |
|---|---|---|---|---|
| 100.00 × 2 | 200.00 | 0.00 | 30.00 | 230.00 |
| 850.00 × 1 | 850.00 | 0.00 | 0.00 | 850.00 |
| 1200.00 × 1 | 1200.00 | 120.00 | 0.00 | 1080.00 |
| 1000.00 × 1 *(limite do desconto)* | 1000.00 | 100.00 | 0.00 | 900.00 |
| 800.00 × 1 *(limite do frete grátis)* | 800.00 | 0.00 | 0.00 | 800.00 |

---

## 🚀 Ideias de evolução

- Frete por faixa: R$ 30,00 abaixo de R$ 300; R$ 15,00 entre R$ 300 e R$ 800; grátis acima disso
- Atributos do `Produto` como `private`, com getters
- Guardar os produtos em uma lista e exibir o resumo no final
- Validar entradas inválidas (preço negativo, quantidade zero)
- Calcular o percentual exibido do desconto a partir da constante `TAXA_DESCONTO`
