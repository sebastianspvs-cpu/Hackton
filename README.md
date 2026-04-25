Hola profe :) como le va 

aqui esta el uml.


@startuml
skinparam classAttributeIconSize 0

interface Operable <<interface>> {
    + iniciarOperacion(): void
    + finalizarOperacion(): void
}

abstract class UnidadEntrega {
    # identificador: String
    # nombreOperador: String
    # capacidadCarga: double
    # zonaOperacion: String
    + mostrarInformacion(): void
    + {abstract} realizarEntrega(): void
}

class Bicicleta {
    - tieneCanasta: boolean
    + realizarEntrega(): void
    + iniciarOperacion(): void
    + finalizarOperacion(): void
}

class Motocicleta {
    - cilindraje: int
    + realizarEntrega(): void
    + iniciarOperacion(): void
    + finalizarOperacion(): void
}

class Drone {
    - alturaMaxima: double
    - nivelBateria: int
    + realizarEntrega(): void
    + iniciarOperacion(): void
    + finalizarOperacion(): void
}

' Relaciones de Herencia
UnidadEntrega <|-- Bicicleta
UnidadEntrega <|-- Motocicleta
UnidadEntrega <|-- Drone

' Relaciones de Implementación
Operable <|.. Bicicleta
Operable <|.. Motocicleta
Operable <|.. Drone
@enduml