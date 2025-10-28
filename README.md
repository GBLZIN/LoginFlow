# LoginFlow - Front-end Pages
Esse é um projeto simples de **telas de autenticação** feito em **Kotlin** usando **Jetpack Compose**.  
Desenvolvi ele para praticar conceitos de **UI moderna**, **gerenciamento de estado** e **transição entre telas**.

- [Tecnologias](#tecnologias-utilizadas)
- [Como funciona?](#como-funciona)
- [Tomadas de Decisão](#tomadas-de-decisão)
- [Demonstração](#demonstração)
- [Observações](#observações)
- [Créditos](#créditos)

## Tecnologias utilizadas
- [Kotlin](https://kotlinlang.org/) — Obra de arte de linguagem.
- [Jetpack Compose](https://developer.android.com/jetpack/compose) — Criação de UI de forma declarativa e fluida.
- [Material 3](https://m3.material.io/) — Para um design limpo e consistente.
- [Coil](https://coil-kt.github.io/coil/compose/) — Para exibir imagens da web de forma assíncrona.
- [Compose Animation](https://developer.android.com/jetpack/compose/animation) — Para animações leves e intuitivas nas interações.

## Como funciona?
O **LoginFlow** possui quatro telas principais, sendo elas:

### Login
- Entrada de **email** e **senha** com validação.  
- Feedback de erros via **Toast**.  
- Acesso a **“Esqueci minha senha”** e **“Cadastrar-se”**.

### Cadastro (SignUp)
- Campos de **Email**, **Senha** e **Usuário**.
- Validação simples e feedback instantâneo.
- Redirecionamento para a tela de login após o cadastro.

### Recuperar Senha (ForgotPassword)
- Campo de **email** para envio de link de redefinição (função simulada).
- Mensagens de alerta personalizadas.
- Botão para voltar ao menu principal.

### Página Principal (Page)
- Exibe uma **Card View**, com imagem carregada via `AsyncImage`.
- Ícone de “Curtir” animado com rotação (`animateFloatAsState`).
- Botão de retorno ao menu de login.
- Ícone de **informação (i)** que, ao ser clicado, exibe um **Card com descrição da página** e link externo (`LinkAnnotation`)
para mais informações.

## Tomadas de Decisão

### Gerenciamento de estado
Utilizei o `rememberSaveable` para controlar as transições entre telas, preservando o estado mesmo em recomposições.
Isso deixou o fluxo mais leve e direto, sem precisar criar ViewModels.  
Para o Card de informação, usei `remember` para gerenciar sua visibilidade de forma dinâmica, permitindo que ele seja   
aberto e fechado pelo usuário sem afetar o restante da interface.

### Material 3
Escolhi o **Material 3** para dar um visual consistente e moderno às telas, mantendo o padrão   
visual dos apps Android atuais.

### Card
Implementei o uso do `Card` para testar composição de layouts com **bordas arredondadas**, **imagem de cabeçalho** e **conteúdo dinâmico**.
O resultado foi uma tela simples, mas visualmente interessante e organizada.  
O ícone de informação abre um Card interativo, que pode ser fechado pelo usuário e contém links externos.

### AsyncImage e Coil
Utilizei o **Coil Compose** com `AsyncImage` para exibir imagens hospedadas na web de forma leve e prática, sem  
precisar de bibliotecas pesadas.

### Animações
Adicionei uma pequena animação de rotação no ícone de “Like” para dar mais vida à interface, utilizando `animateFloatAsState`.
Além disso, o ícone de **informação** permite abrir e fechar um **Card com texto interativo**, melhorando a experiência do 
usuário e fornecendo contexto adicional da página. 

## Demonstração
Deixarei abaixo um `Vídeo` curto para demonstração do App em funcionamento: 
> https://github.com/user-attachments/assets/c0e40f03-c308-4b61-a1e9-c7ac683fc57d

## Observações
O **LoginFlow** foi criado apenas para fins de estudo e prática com **Jetpack Compose**.  
Ah, e ressaltando, o LoginFlow foi focado no Front-end, não há nada de integrações (banco, Room etc)  
Meu foco foi entender melhor:
* Como gerenciar múltiplas telas de forma declarativa;  
* Como aplicar componentes modernos como **Card**, **AsyncImage** e **animações**;  
* E como estruturar um app limpo, responsivo e didático.
> É um projeto pessoal, feito com foco em aprendizado e para o meu portfólio.

## Créditos
Feito por mim, **Gabriel Rodrigues**, entusiasta em Desenvolvimento Mobile (Android).  
- [LinkedIn](https://www.linkedin.com/in/gahrodrigues/)
