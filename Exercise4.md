# Ejercicio 4: Diseño de la implementación para la Máquina de Turing

## Representación de los estados

Primero, comencé pensando como iba a representar los diferentes estados por los que va a ir pasando la máquina hasta
llegar a la solución.

Para eso, decidí usar una Clase, la cuál me permite instanciar tantos State como sean necesarios, además de tener
encapsulado en cada uno la información relevante necesaria para continuar con la ejecución.

La Clase State que definí es bastante sencilla, solamente posee un Booleano que almacena si el estado es de aceptación,
para poder evaluar cuando la máquina termine si la ejecución fue correcta o no (en el caso de que el estado en el que
quedo la máquina al terminar de ejecutar es de **aceptación**, podemos concluir que la salida fue correcta).

Dicha Clase también posee como atributo un **Mapa**, el cuál almacena todos los estados posibles a los que la máquina
puede "moverse". La **clave** del Mapa es el elemento que se lee en la **cinta**, y el valor de esta es una **Tupla**
de 3 elementos, siendo el primero el que representa **el valor que se va a escribir en la cinta**, el segundo el
**movimiento del cabezal** (derecha o izquierda) y el último es el **puntero al objeto** que representa el siguiente
estado para el valor leído de la cinta.

Esta estructura de datos nos permite, dado el caso en el que tengamos muchos estados posibles, realizar búsquedas mucho
más rápidas, basadas en el elemento leído de la cinta.

## Representación de la Cinta

Para la representación de la cinta, también utilicé una Clase, ya que además de permitir tener múltiples ejecuciones
de diferentes máquinas de turing a la vez (ya que podemos crear tantas cintas y estados como queramos) también nos 
permite encapsular en esta el **Array** que contiene los **elementos de la cinta** y además almacenar en una variable la
**posición actual del cabezal** en dicha cinta.

Esta clase tiene la responsabilidad de:
- Escribir un valor en la cinta
- Leer el valor de la cinta (es decir, devolver el elemento que se encuentra en la posición del cabezal)
- Clonar la cinta (para poder realizar validaciones posteriores sin que se modifique la cinta original)
- Almacenar la posición del cabezal y actualizar el valor de esta al momento de que el cabezal se mueva

## Representación de los movimientos

Para representar los movimientos, use una Enumeración la cuál solamente tiene dos valores posibles: **LEFT** y **RIGHT**.

Esto nos permite una mejor legibilidad del código, como también una mejor validación de los valores posibles.

## Ejecución de la máquina

Esta es la parte más importante del intérprete, la cuál, también es una clase para poder permitir la ejecución de 
múltiples máquinas en el programa.

Esta clase solamente tiene dos atributos: Un puntero a una instancia de la clase **Cinta** y otro puntero al estado
inicial de la máquina. Una vez que comenzamos a leer valores de la cinta, nos vamos movimiento entre los estados 
correspondientes y escribiendo los nuevos valores en la cinta, por lo que, al terminar, evaluamos si el estado en el que
quedó la máquina es de aceptación o no, y devolvemos una copia de la cinta para poder permitir su posterior chequeo y
corroborar que la salida de la máquina sea correcta o no.

El algoritmo es bastante sencillo:
- Lee el valor de la cinta
- Obtiene el siguiente estado en base al valor leido
- Escribe en la cinta el valor especificado y se mueve a la nueva posición
- Vuelve al paso 1
- Cuando ya no existan valores en la cinta, termina y evalúa si el estado en el que termino es correcto o no
- Devuelve una copia de la cinta para su posterior chequeo.