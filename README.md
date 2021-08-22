# Projeto Gerenciamento de Ponto - Digital Innovation One

Api rest para gerenciamento de ponto e controle de acesso.

Java | Spring boot | Spring Data Jpa | Hibernate | Lombok | swagger

Alterações realizadas:

 - Projeto com todos os services e controllers implementados.

 - Quando for feita uma busca e o item procurado não existir, será retornado um novo objeto "vazio" (com os valores não atribuídos).

 - Nova classe "Resposta" criada. O objeto desta classe recebe como atributo uma mensagem a ser retornada caso o método em específico não precisar retornar mais nada.
