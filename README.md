# Módulo de login em JSF 2.0 utilizando Session e Filters #

Este repositório tem um módulo de login com duas páginas: Index e Home. A página index contém um formulário onde deve ser preenchido com as credenciais de um usuário cadastrado para ter acesso à página Home. A página Home exibe o nome do usuário conectado e um botão para encerrar a sessão.

O Filter foi utilizado para escutar todas as requisições feitas na página Index e Home. Se o usuário tentar acessar a página Index, após ter se conectado, ele será automaticamente redirecionado para a página Home. Caso tente acessar a página home, sem ter se conectado, o usuário será redirecionado automaticamente para a página Index, solicitando as credenciais para permitir o acesso à página requisitada.

O módulo não esta integrado com banco de dados, dessa forma, foram adicionados alguns usuários em uma lista estática. Vale lembrar que as senhas dos usuários estão sendo criptografada em MD5.