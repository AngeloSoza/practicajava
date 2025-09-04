# Ejercicio 5: Analizador de Texto
class AnalizadorTexto:
def __init__(self, texto: str):
self.texto = texto
self.palabras = self.texto.split()


def contar_palabras(self) -> int:
        return len(self.palabras)


def contar_palabra_especifica(self, palabra: str) -> int:
        return self.palabras.count(palabra)


def reemplazar(self, palabra_original: str, palabra_nueva: str) -> str:
        return self.texto.replace(palabra_original, palabra_nueva)

    
# Ejercicio 6: Matriz de Temperaturas
class Ciudad:
def __init__(self, temperaturas: list[list[float]]):
        if len(temperaturas) != 4 or any(len(semana) != 7 for semana in temperaturas):
raise ValueError("La matriz debe ser de 4 semanas con 7 días cada una.")
self.temperaturas = temperaturas


def promedio_semanal(self) -> list[float]:
        return [sum(semana) / len(semana) for semana in self.temperaturas]


def temperatura_maxima(self) -> float:
        return max(max(semana) for semana in self.temperaturas)


def dia_mas_frio(self) -> tuple[int, int, float]:
min_temp = float('inf')
semana_frio, dia_frio = -1, -1
        for i, semana in enumerate(self.temperaturas):
        for j, temp in enumerate(semana):
        if temp < min_temp:
min_temp = temp
semana_frio, dia_frio = i + 1, j + 1
        return semana_frio, dia_frio, min_temp