📦 Sistema de Pedidos
📜 Descrição
Este projeto foi desenvolvido como parte da disciplina de Análise e Projeto de Sistemas, com o objetivo de aplicar conceitos de Programação Orientada a Objetos (POO) e padrões de projeto.

🎯 Objetivo
Construir um sistema de pedidos com as seguintes funcionalidades:

📦 Calcular o frete com base em diferentes estratégias (peso ou distância);

📄 Gerar relatórios em múltiplos formatos (texto e JSON);

📲 Notificar o cliente por diferentes meios (SMS, e-mail ou WhatsApp).

🧱 Estrutura do Projeto
bash
Copiar
Editar
src/
├── modelo/             # Entidades como Cliente, Produto e Pedido
├── relatorio/          # Geração de relatórios (Template Method)
├── servico/            # Estratégias de frete e notificadores
├── sistema/            # Classe Singleton do sistema
└── principal/          # Classe Main (ponto de entrada do sistema)
💡 Padrões de Projeto Utilizados
1. ✅ Strategy
Usado em: FreteStrategy, FretePorPeso, FretePorDistancia
Objetivo: Permitir trocar a lógica de cálculo de frete de forma flexível.

Vantagens:

Evita o uso de if ou switch no código do pedido.

Permite adicionar novas estratégias sem alterar código existente.

Desvantagens:

Pode aumentar o número de classes.

2. ✅ Factory Method
Usado em: NotificadorFactory
Objetivo: Criar instâncias de notificadores com base em uma string identificadora ("email", "sms", "whatsapp").

Vantagens:

Centraliza e simplifica a criação de objetos.

Facilita a manutenção e extensão.

Desvantagens:

Pode ser limitado para casos com validações mais complexas.

3. ✅ Observer (forma simplificada)
Usado em: Pedido -> notificador.notificar(cliente)
Objetivo: Desacoplar o processo de notificação do pedido.

Observação: Uso manual do padrão, sem addObserver() ou notifyObservers().

4. ✅ Template Method
Usado em: RelatorioTemplate, RelatorioTexto, RelatorioJson
Objetivo: Reutilizar a estrutura de geração de relatórios.

Vantagens:

Reaproveitamento de cabeçalho, corpo e rodapé.

Fácil extensão para novos formatos.

5. ✅ Singleton
Usado em: Sistema
Objetivo: Garantir que exista apenas uma instância do sistema.

Vantagens:

Centraliza o estado global (clientes, pedidos, produtos, etc).

Desvantagens:

Pode dificultar testes unitários.

🔌 Interfaces Criadas
✔️ FreteStrategy
Define as estratégias de cálculo de frete.
A classe Pedido usa essa interface ao chamar o método calcular().

✔️ Notificador
Define diferentes formas de notificação (SMS, E-mail, WhatsApp).
O Pedido chama notificador.notificar(cliente) sem saber o tipo.

🚫 Padrões Não Utilizados
Builder: Desnecessário, pois Pedido não possui atributos complexos.

Decorator / Adapter / Proxy: Fora do escopo simples do projeto.

Command: Não havia necessidade de encapsular ações como objetos.

▶️ Como Executar
Clone o repositório:

bash
Copiar
Editar
git clone https://github.com/PedroGuilhermeYS/ProjetoAPS2.git
cd ProjetoAPS2
Usando Maven:
bash
Copiar
Editar
mvn compile
mvn exec:java -Dexec.mainClass="principal.Main"
👥 Autores
Pedro Guilherme

Carolaine Silva

📝 Licença
Este projeto foi desenvolvido apenas para fins educacionais.
