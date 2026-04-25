from abc import ABC, abstractmethod
#creo la interfaz operable
class Operable(ABC): 

    @abstractmethod
    def iniciarOperacion(self):
        #implementando las clases hijas
        pass

    @abstractmethod
    def finalizarOperacion(self):
        pass

#clase abstracta que es como mi base
class UnidadEntrega(ABC):
#constructor y las clases hijas hereden 
    def __init__(self, identificador, nombreOperador, capacidadCarga, zonaOperacion):
        self.identificador = identificador
        self.nombreOperador = nombreOperador
        self.capacidadCarga = capacidadCarga
        self.zonaOperacion = zonaOperacion

    def mostrarInformacion(self):
        print(f"ID: {self.identificador}")
        print(f"Operador: {self.nombreOperador}")
        print(f"Capacidad: {self.capacidadCarga}")
        print(f"Zona: {self.zonaOperacion}")

    @abstractmethod
    #las clases hijas definen
    def realizarEntrega(self):
        pass

#clase bicicleta con herencia e interfaz
class Bicicleta(UnidadEntrega, Operable):

    def __init__(self, identificador, nombreOperador, capacidadCarga, zonaOperacion, tieneCanasta):
        super().__init__(identificador, nombreOperador, capacidadCarga, zonaOperacion)
        self.tieneCanasta = tieneCanasta

    def realizarEntrega(self):
        print("Entrega ecológica en trayecto corto")

    def iniciarOperacion(self):
        print("Bicicleta iniciando operación")

    def finalizarOperacion(self):
        print("Bicicleta finalizando operación")


class Motocicleta(UnidadEntrega, Operable):

    def __init__(self, identificador, nombreOperador, capacidadCarga, zonaOperacion, cilindraje):
        super().__init__(identificador, nombreOperador, capacidadCarga, zonaOperacion)
        self.cilindraje = cilindraje

    def realizarEntrega(self):
        print("Entrega rápida en zona urbana")

    def iniciarOperacion(self):
        print("Motocicleta iniciando operación")

    def finalizarOperacion(self):
        print("Motocicleta finalizando operación")


class Drone(UnidadEntrega, Operable):

    def __init__(self, identificador, nombreOperador, capacidadCarga, zonaOperacion, alturaMaxima, nivelBateria):
        super().__init__(identificador, nombreOperador, capacidadCarga, zonaOperacion)
        self.alturaMaxima = alturaMaxima
        self.nivelBateria = nivelBateria

    def realizarEntrega(self):
        print("Entrega aérea con autonomía limitada")

    def iniciarOperacion(self):
        print("Drone iniciando operación")

    def finalizarOperacion(self):
        print("Drone finalizando operación")


# PRUEBA (POLIMORFISMO)
unidades = [
    Bicicleta("B1", "Ana", 10, "Centro", True),
    Motocicleta("M1", "Luis", 50, "Norte", 150),
    Drone("D1", "Sistema", 5, "Sur", 100, 80)
]

for unidad in unidades:
    print("\n---")
    unidad.mostrarInformacion()
    #esto es de la interfaz 
    unidad.iniciarOperacion()
    #aquí se nota el poliformismo
    unidad.realizarEntrega()
    unidad.finalizarOperacion()
