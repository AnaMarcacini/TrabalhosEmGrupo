
    estado = obter o próximo estado a partir de estado e c
    if não for possível realizar a transição then
    begin
        erro('Não foi possível realizar a transição do estado',
        estado, 'com entrada', c)
        break
        end
    end
    if estado estiver no conjunto de estados finais e a entrada estiver vazia then
    begin
        aceitar = verdadeiro
    end
    if aceitar for verdadeiro then
    begin
        exibir('A cadeia', entrada, 'foi aceita pelo autômato!')
    end
    else
    begin
        exibir('A cadeia', entrada, 'foi rejeitada pelo autômato!')
    end
end