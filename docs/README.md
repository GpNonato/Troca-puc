# TrocaPUC

- Felipe Luiz Parreiras Lima, 1412545@sga.pucminas.br

- Gabriella Fernanda Silva Pinto, 1405624@sga.pucminas.br

- Gabriel Pedrosa do Carmo Nonato, 1522389@sga.pucminas.br

- Kayler de Freitas Moura, 1247101@sga.pucminas.br

- Natália dos Reis Santos, 1507064@sga.pucminas.br

- Pedro Henrique Silva Vargas, 1525997@sga.pucminas.br

- Pedro Morato Kalil, 1386375@sga.pucminas.br

---

Professores:

- Aline Norberta de Brito
- Cleia Marcia Gomes Amaral
- Cristiano de Macêdo Neto

---

_Curso de Engenharia de Software_

_Instituto de Informática e Ciências Exatas – Pontifícia Universidade Católica de Minas Gerais (PUC MINAS), Belo Horizonte – MG – Brasil_

---

Este trabalho apresenta o desenvolvimento de um sistema digital voltado para a troca, venda e doação de livros, eletrônicos e materiais universitários entre alunos da PUC Minas, campus Belo Horizonte. No contexto acadêmico, essas práticas são fundamentais para reduzir custos e promover a sustentabilidade, mas atualmente são realizadas de forma desorganizada, com o uso de métodos informais como grupos em redes sociais. O objetivo do projeto é criar uma plataforma intuitiva e segura que centralize essas interações, permitindo o cadastro de itens, notificações personalizadas e troca de contatos entre os usuários. A solução proposta melhora a organização e a confiabilidade desses processos, atendendo às demandas da comunidade acadêmica. Como resultado, o sistema incentiva a economia colaborativa e promove o reuso de recursos, alinhando-se aos princípios de responsabilidade social e sustentabilidade.

---

## 1. Introdução

Este trabalho apresenta o desenvolvimento de um sistema digital voltado para a troca, venda e doações de livros, eletrônicos e materiais universitários entre os alunos da PUC Minas, dos campus de Belo Horizonte.

### 1.1 Contextualização

No contexto acadêmico, a troca de recursos educacionais, como livros, eletrônicos e materiais universitários, é uma prática comum entre estudantes, especialmente em universidades. Essa prática não apenas auxilia na redução de custos, mas também promove a sustentabilidade ao incentivar o reuso de materiais. De acordo com a Biblioteca Cyro dos Anjos, o projeto de troca de livros visa promover o acesso democrático ao livro e fomentar o gosto pela leitura, além de contribuir para a sustentabilidade por meio da reutilização de livros e da redução do desperdício​(Biblioteca TCDF). Além disso, conforme destacado pelo site Bibliotecas do Brasil, feiras de troca de livros são uma forma eficaz de fornecer acesso a materiais de leitura para aqueles que podem não ter condições financeiras para adquiri-los novos, promovendo a leitura como um hábito acessível e democrático​(Bibliotecas do Brasil). A Folha de S.Paulo também destaca que muitos estudantes universitários enfrentam dificuldades financeiras significativas, o que impacta diretamente sua permanência e desempenho acadêmico​(Folha Ruf). No ambiente da PUC Minas, observa-se uma crescente demanda por uma plataforma que centralize e organize essas trocas de maneira eficiente e segura, facilitando o encontro entre alunos que desejam trocar ou doar materiais.

### 1.2 Problema

Atualmente, na PUC Minas, campus Belo Horizonte, não existe uma plataforma específica que atenda às necessidades dos alunos para a troca, venda ou doação de livros, eletrônicos e materiais universitários. Os estudantes muitas vezes recorrem a métodos informais e pouco eficientes, como grupos em redes sociais ou anúncios em murais, o que pode resultar em problemas de comunicação, falta de segurança e dificuldades na organização das trocas. Essa carência de um sistema centralizado e seguro limita a capacidade dos alunos de maximizar o uso dos recursos disponíveis e de encontrar rapidamente os itens que necessitam.

### 1.3 Objetivo geral

O objetivo deste trabalho é desenvolver um sistema digital de troca, venda e doação de livros, eletrônicos e materiais universitários para os alunos da PUC Minas, campus Belo Horizonte, visando facilitar e organizar o processo de maneira eficiente e segura.

#### 1.3.1 Objetivos específicos

• Criar uma plataforma digital intuitiva e acessível que permita aos alunos cadastrarem os itens que desejam trocar, vender ou doar.
• Implementar um sistema de notificações que informe os alunos sobre novos itens disponíveis de acordo com suas preferências.
• Integrar a funcionalidade de proposta e as opções de aceitar, assim possibilitanto a troca de contatos entre os usuários, ou de recusar, finalizando o processo.

### 1.4 Justificativas

O desenvolvimento deste sistema é justificado pela necessidade crescente de uma plataforma que centralize as trocas, vendas e doações de materiais acadêmicos, promovendo a economia colaborativa e a sustentabilidade no ambiente universitário. Ao facilitar o acesso a materiais de estudo e eletrônicos, o sistema contribui para a redução de custos para os alunos e melhora a eficiência na utilização de recursos disponíveis na comunidade acadêmica. Além disso, ao fomentar o reuso de materiais, a plataforma promove práticas sustentáveis, alinhadas aos princípios de responsabilidade social da PUC Minas.


---

## 2. Participantes do Processo

Os principais participantes do sistema de troca de livros, eletrônicos e materiais universitários são:

### **2.1 Usuários**:

Os usuários são pessoas que tem ou tiveram relação com a PUC Minas. Eles utilizarão a plataforma para realizar trocas, vendas ou doações de materiais acadêmicos. Eles podem cadastrar itens que possuem e que estão dispostos a negociar, além de buscar e se interessar por materiais de outros estudantes. Os usuários são responsáveis por manter seus cadastros atualizados, interagir com outros participantes e dar feedback sobre as trocas realizadas.

Usuários qualificados para utilizar o sistema:

- **Estudantes de Graduação e Pós-Graduação**:  
  Com idades variando entre 18 e 30 anos, são os principais usuários do sistema. Eles utilizam a plataforma para encontrar e trocar materiais necessários para seus cursos. Os estudantes possuem diferentes perfis socioeconômicos e culturais, tornando o sistema inclusivo e diversificado.

- **Alunos de Programas de Extensão e Pesquisa**:  
  Normalmente com idades entre 22 e 35 anos, esses participantes estão envolvidos em projetos de pesquisa ou extensão e podem precisar de equipamentos específicos ou livros acadêmicos que não estão disponíveis em bibliotecas convencionais.

- **Funcionários Administrativos e Professores**:  
  Embora em menor escala, esses usuários podem utilizar a plataforma para doar materiais ou equipamentos antigos que não são mais utilizados, contribuindo para o acervo disponível para os alunos.

- **Ex-alunos da PUC Minas**:  
  Com idades variadas, ex-alunos podem continuar a utilizar a plataforma para doar materiais que não são mais úteis para eles, ajudando os atuais alunos a acessar recursos de maneira econômica e sustentável.

### **2.2 Administrador do Sistema**:

O administrador é responsável por gerenciar o sistema. Suas atividades incluem analisar o estoque, moderar o chat, verificar avaliações e reportar bugs.


## 3. Modelagem do processo de negócio

### 3.1. Análise da situação atual

Atualmente, os processos de troca, venda, doação e avaliação de itens em plataformas online são realizados através de sistemas que oferecem funcionalidades básicas para cadastro, busca e comunicação entre usuários. Em muitas plataformas, o cadastro de itens é feito por meio de formulários que permitem ao usuário inserir informações sobre o item que deseja disponibilizar. A busca e solicitação de itens geralmente dependem de filtros e palavras-chave, que ajudam os usuários a localizarem itens específicos.

Entretanto, em alguns casos, os processos de troca, venda e doação ainda podem ocorrer de forma não estruturada, sem o apoio de uma plataforma tecnológica. Isso pode incluir a comunicação direta entre as partes interessadas via e-mail, redes sociais ou até mesmo em interações presenciais. Nesses casos, não há um registro formal das trocas, vendas, doações, ou feedbacks, e a confiabilidade do processo depende inteiramente da boa-fé e comunicação das partes envolvidas.

### 3.2. Descrição geral da proposta de solução

A proposta deste sistema é criar uma plataforma centralizada e automatizada que integra as etapas de cadastro, busca, solicitação e avaliação de itens, além de gerenciar a comunicação entre os usuários. O sistema visa facilitar e organizar os processos de troca, venda e doação, garantindo que todas as interações sejam registradas, aumentando assim a confiabilidade e a segurança das transações.

A solução proposta limita-se ao gerenciamento de itens dentro da plataforma, com um foco claro em promover trocas e doações de forma eficiente e segura. A proposta se alinha com as estratégias e objetivos de negócios ao fornecer um ambiente confiável para os usuários, aumentando a satisfação e incentivando o uso contínuo da plataforma.

Além disso, a solução oferece oportunidades de melhoria em áreas como a automação de notificações, a personalização da experiência do usuário através de filtros de busca mais refinados, e o armazenamento seguro de dados e feedbacks, proporcionando um processo mais robusto e confiável para todos os usuários envolvidos.

### 3.3. Modelagem dos processos

#### Processo 1: Cadastro de Usuário

**Descrição:** Permite que um usuário se cadastre na plataforma.

**Tarefas de Usuário:**

- Preencher Formulário de Cadastro de Usuário
- Confirmar Cadastro

**Outras Tarefas:**

- Validar Dados
- Salvar Casdastro no Banco de Dados

#### Processo 2: Cadastro de Item

**Descrição:** Permite que um usuário cadastre um novo item na plataforma.

**Tarefas de Usuário:**

- Preencher Formulário de Cadastro do Item
- Confirmar Cadastro

**Outras Tarefas:**

- Validar Dados
- Salvar Item no Banco de Dados

#### Processo 3: Busca e Solicitação de Item

**Descrição:** Usuário busca por um item e envia uma solicitação de troca, venda ou doação.

**Tarefas de Usuário:**

- Pesquisar Item: O usuário utiliza filtros e palavras-chave para encontrar um item.
- Solicitar Troca/Venda/Doação: O usuário envia uma solicitação ao dono do item para iniciar a troca, venda ou doação.

**Outras Tarefas:**

- Notificar Proprietário: O sistema envia uma notificação ao proprietário do item sobre a solicitação recebida.
- Registrar Solicitação: A solicitação é registrada no banco de dados.

#### Processo 4: Proposta entre Usuários

**Descrição:** Processo que notifica o proprietário do produto disponível para troca, venda ou doação e permite o proprietário aceitar ou recusar a proposta do usuário interessado no produto.

**Tarefas de Usuário:**

- Notificação de proposta: Um usuário envia uma proposta demonstrando interesse no produto.
- Notificação de aceite ou recusa: O proprietário envia a resposta aceitando ou recusando a proposta.

**Outras Tarefas:**

- Notificar Usuário: O sistema envia notificações de novas mensagens.
- Compartilhar dados: Caso o usuário aceite a proposta o sistema envia o contato do proprietário para o usuário interessado. Caso contrário, a notificação de recusa é enviada e nenhum dado é compartilhado.

## 4. Projeto da solução

### Modelo Relaiconal e Tecnologias


[Projeto da solução](solution-design.md "Detalhamento do projeto da solução: modelo relacional e tecnologias.")


## 5. Indicadores de desempenho


[Indicadores de desempenho dos processos](performance-indicators.md)


## 6. Interface do sistema


[Documentação da interface do sistema](interface.md)


## 7. Conclusão

O desenvolvimento do sistema digital para troca, venda e doação de materiais acadêmicos entre os alunos da PUC Minas, campus Belo Horizonte, trouxe soluções práticas e centralizadas para problemas recorrentes enfrentados pela comunidade acadêmica. A plataforma proposta conseguiu organizar e facilitar processos anteriormente fragmentados, como o cadastro de itens, busca de materiais, solicitações de troca, venda ou doação e comunicação entre os usuários.

Um dos principais resultados foi a criação de um ambiente seguro e intuitivo que incentiva o reuso de materiais, promovendo a economia colaborativa e a sustentabilidade. A interface amigável e os sistemas de notificação personalizados aumentam a eficiência das interações, enquanto a possibilidade de troca de contatos oferece flexibilidade para negociação direta entre os estudantes.

Como observação final, o projeto demonstra o impacto positivo de soluções tecnológicas na otimização de práticas cotidianas, alinhando-se aos valores de responsabilidade social e inclusão acadêmica. Para estudos futuros, sugere-se explorar a integração do sistema com ferramentas de análise de dados para mapear padrões de uso e necessidades específicas dos usuários, bem como a expansão para outros campi da universidade ou redes acadêmicas maiores.

Discussão dos resultados obtidos no trabalho e observações pessoais de cada aluno:

- **Felipe Luiz:** Participar deste projeto foi uma experiência incrível e muito enriquecedora. Durante sua realização,tive a oportunidade de por em prática habilidades muito importantes como modelagem de processos de negócios, criação e gestão de banco de dados, e desenvolvimento de uma aplicação web. Além disso, trabalhar em equipe foi essencial para aprendermos a colaborar, alinhar ideias e superar desafios juntos. Foi uma oportunidade de grande crescimento pessoal e profissional.
  
- **Gabriella Fernanda:** Participar do desenvolvimento deste projeto foi uma experiência enriquecedora, tanto no aspecto técnico quanto no colaborativo. Trabalhar na criação de um sistema que atende a uma necessidade real da comunidade acadêmica me fez perceber o impacto que soluções digitais podem ter na vida das pessoas. Além disso, a oportunidade de aplicar metodologias aprendidas em sala de aula reforçou a importância da organização e do trabalho em equipe. Este projeto não apenas contribuiu para o meu aprendizado, mas também me inspirou a buscar soluções inovadoras para problemas cotidianos.

- **Gabriel Pedrosa:** Contribuir para este projeto foi uma experiência enriquecedora, permitindo-me aprimorar habilidades técnicas e aprender com o trabalho em equipe. Ver a plataforma tomando forma e atendendo às necessidades da comunidade acadêmica reforçou meu desejo de usar a tecnologia para resolver problemas reais e gerar impacto positivo.
  
- **Kayler de Freitas:** Fazer esse projeto foi uma experiência muito legal e com vários aprendizados. Trabalhar com Spring Boot e JavaScript me ajudou a melhorar minhas habilidades no desenvolvimento de sistemas web, e também me fez entender melhor como construir soluções para problemas reais. Foi minha primeira vez usando essas tecnologias. Trabalhar em equipe foi essencial, porque cada um trouxe uma ideia ou uma solução diferente, o que ajudou a gente a criar algo bem mais completo.
 Ver o sistema tomando forma e sabendo que ele pode realmente ajudar os estudantes é muito lega e me motivou ainda mais a seguir buscando maneiras de usar a tecnologia para resolver problemas do dia a dia. Esse projeto me fez perceber a importância de entender as necessidades das pessoas e adaptar as soluções para realmente fazer diferença na vida delas, especialmente considerando os processos de negócios.
 Foi tudo uma grande oportunidade de aprender e crescer, tanto profissionalmente quanto pessoalmente. Me fez de fato compreender mais de como tecnologias e a programação pode ser útil para negócios diversos com processos envolvendo vários participantes em camadas reais de acontecimento das coisas.
  
- **Natália do Reis:** Ter a oportunidade de participar do desenvolvimento do TrocaPuc foi uma experiência única e desafiadora. Única porque tive a chance de trabalhar com novas pessoas e conhecer diferentes pontos de vista, o que agregou positivamente tanto à minha experiência pessoal quanto à profissional. Por outro lado, foi desafiadora, pois exigiu o desenvolvimento e a adaptação de soft skills essenciais para o trabalho em equipe, como comunicação, escuta ativa e colaboração. Foi muito gratificante ver, mais uma vez, como a tecnologia pode ser utilizada para resolver problemas reais de forma prática. O TrocaPuc representa exatamente isso, facilitando o acesso a informações e promovendo soluções para as necessidades da comunidade acadêmica.
  
- **Pedro Henrique:** Este projeto foi uma ótima experiência, que me proporcionou aprendizados significativos tanto no desenvolvimento de habilidades práticas quanto na colaboração em equipe. Trabalhar em uma solução que atende a necessidades reais da comunidade acadêmica me motivou a buscar sempre formas inovadoras de aplicar tecnologia para resolver problemas e criar impactos positivos.
  
- **Pedro Morato:**

# REFERÊNCIAS

_Como um projeto de software não requer revisão bibliográfica, a inclusão das referências não é obrigatória. No entanto, caso você deseje incluir referências relacionadas às tecnologias, padrões, ou metodologias que serão usadas no seu trabalho, relacione-as de acordo com a ABNT._

_Verifique no link abaixo como devem ser as referências no padrão ABNT:_

http://portal.pucminas.br/imagedb/documento/DOC_DSC_NOME_ARQUI20160217102425.pdf

# APÊNDICES


## Apêndice A - Código fonte


[Código do front-end](../trocapuc/src/main/resources)


[Código do back-end](../trocapuc/src/main/java)


## Apêndice B - Apresentação final


[Slides da apresentação final](presentations/TrocaPUC%20-%20Apresentação%20Final.pdf)


[Vídeo da apresentação final](video/)

