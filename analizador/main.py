import pandas as pd


def analisar_media_valor_pago():
    grupo = df.groupby("tipo")

    print("Media de gasto agrupatado pelo tipo de despesa")
    print(grupo["valorPago"].mean().round(2))


def analisar_maior_valor_pago():
    grupo = df.groupby("tipo")

    print("Maiores gastos agrupatado pelo tipo de despesa")
    print(grupo["valorPago"].max().round(2))

def analisar_menor_valor_pago():
    grupo = df.groupby("tipo")

    print("Menores gastos agrupatado pelo tipo de despesa")
    print(grupo["valorPago"].min().round(2))


def analisar_desvio_padrao_valor_pago():
    grupo = df.groupby("tipo")

    print("Desvio padrão gastos agrupatado pelo tipo de despesa")
    print(grupo["valorPago"].std().round(2))


if __name__ == '__main__':
    df = pd.read_csv("../geradorCSV/dados/relatorio.csv", sep=';')

    analisar_maior_valor_pago()
    analisar_menor_valor_pago()
    analisar_media_valor_pago()
    analisar_desvio_padrao_valor_pago()
