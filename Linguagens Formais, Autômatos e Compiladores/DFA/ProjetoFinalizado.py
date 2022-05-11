

def simulardfa(dfa, entrada):
    print(dfa['initial_state'])
    estado = dfa(['initial_state'])
    aceitar = False

    while len(entrada) > 0:
        c = entrada.pop(0)

        if c not in dfa(['sigma']):
            print("ERRO! ERRO! ERRO!\nO símbolo ", c, "não pertence ao alfabeto do autômato!")
            entrada.insert(0,c)
            break
        if estado not in dfa(['states']):
            print('O estado', estado,
                'não pertence ao conjunto de estados do autômato!')
            break
        try:
            estado = dfa(['delta'])[estado, c]
        except:
            print('Não foi possível realizar a transição do estado', estado, 'com entrada', c)
            break
        if (estado in dfa(['final_states'])) and (len(entrada) == 0):
            aceitar = True
        if aceitar ==True:
            print('A cadeia', entrada, 'foi aceita pelo autômato!')
        else:
            print('A cadeia', entrada, 'foi rejeitada pelo autômato!')




if __name__ == '__main__':

    with open('m.dfa') as dfa_file:
        dfa_data = dfa_file.read()
        print(dfa_data)
        dfa = eval(dfa_data)
        # Para conferir o conteúdo
        #print(dfa['initial_state'])
        #print(dfa['states'])
        #print(dfa['delta'])
        #print(dfa['delta'][(1,'1')])

    entrada = input("Digite a cadeia ou digite 2 para encerrar o programa: ")
    while entrada != '2':
        simulardfa(dfa, entrada)
        #print(entrada != '2')
        
        entrada = input("Digite a cadeia ou digite 2 para encerrar o programa")


