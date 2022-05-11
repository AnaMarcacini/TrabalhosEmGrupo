

def simulardfa(dfa, entrada):
    estado = dfa['initial_state']
    aceitar = False
    #trocar lista entrada por entrada
    entradaint = entrada
    entrada=list(entrada)
    while len(entrada) > 0:
        c = entrada.pop(0)

        if c not in dfa['sigma']:   #caso digite algo diferente de 0 e 1
            print("ERRO! ERRO! ERRO!\nO símbolo ", c, "não pertence ao alfabeto do autômato!")
            entrada.insert(0,c)
            break
        if estado not in dfa['states']: # caiu em um estado que não existe no autômato
            print('O estado', estado,
                'não pertence ao conjunto de estados do autômato!')
            break
        try:
            estadoanterior = estado
            estado = dfa['delta'][estado, c] #mudança de estado não pode ter break // DANDO ERRO NÂO MUDA O ESTADO]

            #Print
            print('(', estadoanterior, ', \'', c, '\') --> ',estado)



        except:
            print('Não foi possível realizar a transição do estado', estado, 'com entrada', c)
            break


        #não passando por qualquer break significa que chegamos no estado final
        #Avaliar se é aceito ou não
        if (estado in dfa['final_states']) and (len(entrada) == 0):
            aceitar = True
        if aceitar ==True:
            print('A cadeia', entradaint, 'foi aceita pelo autômato!')
        elif (len(entrada) == 0):                                   #(len(entrada) == 0) add para não repetir todas as vezes (NÂO ESTA NO COD DO PROF)
            print('A cadeia', entradaint, 'foi rejeitada pelo autômato!')




if __name__ == '__main__':

    with open('m.dfa') as dfa_file:
        dfa_data = dfa_file.read()
        #print(dfa_data)
        dfa = eval(dfa_data)
        # Para conferir o conteúdo
        #print(dfa['initial_state'])
        #print(dfa['states'])
        #print(dfa['delta'])
        #print(dfa['delta'][(1,'1')])

    entrada = input("Digite a cadeia ou digite 2 para encerrar o programa:  ")
    while entrada != '2':
        simulardfa(dfa, entrada)
        #print(entrada != '2')
        
        entrada = input("\nDigite a cadeia ou digite 2 para encerrar o programa:  ")


