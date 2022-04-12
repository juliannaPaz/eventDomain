# Event Domain
Pequenho trecho de código, contendo testes para entendimento do Event Domain.

## Conceitos chave
<b>Event</b> - Um evento é algo que ocorreu no passado. Um evento de domínio é algo que ocorreu no domínio que você deseja que outras partes do mesmo domínio (em processo) tenham conhecimento. As partes notificadas geralmente reagem de alguma forma aos eventos.

<b>Event Handler</b> - São as ações que devem executadas por um determinado domínio.

<b>Event Dispatcher</b> - É a associação dos Events a seus respectivos Event Handler.

## Pontos de Atenção

Em resumo, eventos de domínio ajudam você a expressar, explicitamente, as regras de domínio, com base na linguagem ubíqua fornecida pelos especialistas do domínio. Os eventos de domínio também permitem uma melhor separação de interesses entre classes dentro do mesmo domínio, gerando assim um desacoplamento.


É importante garantir que, assim como uma transação de banco de dados, todas as operações relacionadas a um evento de domínio sejam concluídas com êxito ou nenhuma delas seja.
