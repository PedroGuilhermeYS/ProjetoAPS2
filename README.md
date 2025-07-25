# 📦 Sistemas de Pedidos

## 📜 Descrição
-Este projeto foi desenvolvido como parte da disciplina de Análise e Projeto de Sistemas com o objetivo de aplicar conceitos de POO e padrões de projeto.

---

🎯 Objetivo

Construir um sistema de pedidos que:
-Calcule o frete com base em diferentes estratégias (peso, distância);
-Gere relatórios em múltiplos formatos (texto e JSON);
-Notifique o cliente por diferentes meios (SMS, e-mail, WhatsApp).

---

🧱 Estrutura do Projeto

src/
├── modelo/             # Entidades como Cliente, Produto, Pedido
├── relatorio/          # Geração de relatórios (Template Method)
├── servico/            # Estratégias de Frete e Notificadores
├── sistema/            # Classe Singleton Sistema
└── principal/          # Classe Main (ponto de entrada)

---

💡 Padrões de Projeto Utilizados

1. ✅ Strategy
Usado em: frete.FreteStrategy, FretePorPeso, FretePorDistanciaObjetivo 

Objetivo: 
-Permitir trocar a lógica de cálculo do frete de forma flexível.

Vantagens:
-Evita if/switch no código de Pedido.
-Permite adicionar novas estratégias sem alterar código existente.

Desvantagens:
-Aumenta o número de classes.

---

2. ✅ Factory Method
Usado em: factory.NotificadorFactory

Objetivo: 
-Criar instâncias de notificadores com base em uma string ("email", "sms", "whatsapp").

Vantagens:
-Centraliza e simplifica a criação de objetos.
-Facilita manutenção e extensão.

Desvantagens:
-Não lida bem com validações complexas.

---

3. ✅ Observer (forma simplificada)
Usado em: Pedido -> notificador.notificar(cliente)

Objetivo: 
-Desacoplar a notificação do pedido.Nota: Uso manual do Observer (sem addObserver() ou notifyObservers()).

---

4. ✅ Template Method
Usado em: relatorio.RelatorioTemplate, RelatorioTexto, RelatorioJson

Objetivo:
-Reutilizar a estrutura de geração de relatórios.

Vantagens:
-Reutilização de cabeçalho, corpo e rodapé.
-Fácil extensão para novos formatos.

---

5. ✅ Singleton
Usado em: sistema.Sistema

Objetivo: 
-Garantir que só exista uma instância do sistema.

Vantagens:
-Centraliza estado global (clientes, pedidos etc.).

Desvantagens:
-Dificulta testes unitários.

---

**🔌 Interfaces Criadas**

-**✔️ FreteStrategy**
-Representa estratégias de cálculo de frete.
-A classe Pedido usa essa interface e chama o método calcular().

-**✔️ Notificador**
-Define diferentes formas de notificar um cliente (SMS, Email, WhatsApp).
-O Pedido chama notificador.notificar(cliente) sem saber o tipo.

##**🚫 Padrões não utilizados**
-Builder: Desnecessário, pois Pedido não tem atributos complexos.
-Decorator/Adapter/Proxy: Não se aplicam ao escopo simples.
-Command: Não havia necessidade de encapsular ações como objetos.

---

▶️ Como Executar

>Clone o repositório:
>```bash
>git clone https://github.com/PedroGuilhermeYS/ProjetoAPS2.git
>cd ProjetoAPS2
>```

Compile e execute:
-Se estiver usando Maven
mvn compile
mvn exec:java -Dexec.mainClass="principal.Main"

---

👥 Autores
-**Pedro Guilherme**
-**Carolaine Silva**

---

📝 Licença
Este projeto foi desenvolvido apenas para fins educacionais.

