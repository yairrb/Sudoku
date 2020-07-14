# Sudoku
Mi objetivo es lograr resolver un sudoku. Para lograrlo utilice Backtracking de forma tal de realizar podas y optimizar un poco los tiempos. 
Por otro lado, modele el sudoku para facilitarme su resolucion, es una version sencilla y sin manejo de excepciones.
Tengo algunos casos de Test unitario para comprobar que el algoritmo funcione correctamente.

#Reglas basicas del sudoku:
*Regla 1: hay que completar las casillas vacías con un solo número del 1 al 9.
*Regla 2: en una misma fila no puede haber números repetidos.
*Regla 3: en una misma columna no puede haber números repetidos.
*Regla 4: en una misma región no puede haber números repetidos.

#Como funciona:
Basicamente consiste en evaluar las casillas que pueden escribirse y borrarse normalmente, tomando la que este disponible e incrementando su valor en 1. El valor resultante no debe ser mayor a 9 y, ademas, no debe repetirse en su fila y columna, ni en su region. Si dicho valor incumple las reglas se debera incrementar su valor en 1, o de ser mayor a 9 se regresa a 0 y se produce la poda(ver la casilla anterior). Si el valor cumple con las reglas, entonces podemos continuar a la siguiente casilla.

#Condicion de corte:
*el valor es mayor a 9.

#NOTA: si el sudoku no puede ser resulto, el valor de retorno es el mismo sudoku ingresado al comienzo(no se podra resolver si no cumple con las reglas)

I wanted to solve a Sudoku. To archive that I use Backtracking because it would be better than a brute force algorithm.
This sudoku is an easy representation in Java in order to archive the solve algorithm. It has no Exception handling.
I made some unit Test to check if it's working fine.

#Sudoku's Rules:
*Rule 1: all the boxes needs to be completed with only numbers from 1 to 9.
*Rule 2: repeated numbers in the same row are not allowed.
*Rule 3: repeated numbers in the same columns are not allowed.

#End Condition:
*the value is higher than 9.

#NOTE: if the sudoku doesn't respect the mentioned rules, then the output after calling solve() function should be the same Sudoku that we use as input.





This is just an algorith that will solve a regular sudoku
