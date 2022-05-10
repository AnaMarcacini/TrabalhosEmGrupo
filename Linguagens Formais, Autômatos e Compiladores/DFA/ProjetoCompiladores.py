if __name__ == '__main__':

    with open('m.dfa') as dfa_file:
        dfa_data = dfa_file.read()
        print(dfa_data)
        dfa = eval(dfa_data)
        # Para conferir o conteúdo
        print(dfa['initial_state'])
        print(dfa['states'])
        print(dfa['delta'])
        print(dfa['delta'][(1,'1')])

    entrada = input("Digite a cadeia ou digite 2 para encerrar o programa: ")
    while entrada != 2:
        simular_dfa(dfa_data, entrada)


        
        entrada = input("Digite a cadeia ou digite 2 para encerrar o programa")

    


