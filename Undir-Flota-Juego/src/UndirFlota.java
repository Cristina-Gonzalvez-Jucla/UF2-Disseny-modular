import java.util.Scanner;

public class UndirFlota {

    /**
     * Inicializamos el programa y mostramos el menu
     * @param args argumentos del programa
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seleccionMenu = menu();
        int[][] tableroJugador = new int[5][5];
        int[][] tableroEnemigo = new int[5][5];

        while (seleccionMenu != 6) {
            switch (seleccionMenu) {
                case 1:
                    tableroJugador = crearTableroJugador();
                    imprimirTablero(tableroJugador);
                    seleccionMenu = menu();
                    break;
                case 2:
                    tableroJugador = crearTableroAleatorio();
                    imprimirTablero(tableroJugador);
                    seleccionMenu = menu();
                    break;
                case 3:
                    tableroEnemigo = crearTableroAleatorio();
                    seleccionMenu = menu();
                    break;
                case 4:
                    imprimirTablero(tableroEnemigo);
                    seleccionMenu = menu();
                    break;
                case 5:
                    jugada(scanner, tableroJugador, tableroEnemigo);
                    seleccionMenu = menu();
                    break;
            }
        }
    }

    /**
     * Muestra el menu del juego por pantalla y pregunta al usuario la opción a escoger
     * @return devuelve la opcion escogida por el usuario
     */
    private static int menu() {
        Scanner scan = new Scanner(System.in);
        System.out.println("-- ¡BIENVENIDO A HUNDIR LA FLOTA! --");
        System.out.println("  1.- Crear tablero del jugador");
        System.out.println("  2.- Crear tablero del jugador aleatoriamente");
        System.out.println("  3.- Crear tablero del enemigo aleatoriamente");
        System.out.println("  4.- Ver el tablero del enemigo (trampas)");
        System.out.println("  5.- Empezar la partida");
        System.out.println("  6.- Salir del juego");
        System.out.println();

        return comprobarIntegroMinMax(scan, 1, 6);
    }

    /**
     * Pregunta al usuario donde colocar los barcos, teniendo en cuenta el tipo (P, M, G) y la direccion
     * hacia donde quiere colocarlo (H, V)
     * @return devuelve el tablero con los barcos posicionados por el usuario
     */
    private static int[][] crearTableroJugador() {
        int[][] tablero = new int[5][5];
        Scanner scan = new Scanner(System.in);
        int numBarcosPeque = 2;
        int numBarcosMedianos = 1;
        int numBarcosGrandes = 1;

        System.out.println("Para jugar vas a necesitar rellenar tu tablero!");
        System.out.println();

        //mientras que le sigan quedando barcos al usuario, le pedimos que los coloque
        while (numBarcosPeque > 0 || numBarcosMedianos > 0 || numBarcosGrandes > 0) {
            imprimirTablero(tablero);
            System.out.println("Necesitas poner: \n " +
                    "\t- " + numBarcosPeque + " barcos pequeños. \n" +
                    "\t- " + numBarcosMedianos + " barcos medianos. \n" +
                    "\t- " + numBarcosGrandes + " barcos grandes.");

            System.out.println("Elige el tipo de barco a introducir (P, M, G)");
            String seleccion = comprobarLetraBarco(scan, numBarcosPeque, numBarcosMedianos, numBarcosGrandes);

            System.out.println("¿En que dirección quieres colocar el barco? (H, V)");
            String direccion = comprobarLetraDireccion(scan);

            int fila = -1;
            int columna = -1;

            //mientras el barco no entre en la posicion y direccion dada por el usuario, lo volvemos a pedir
            while (!barcoEntra(fila, columna, tablero, seleccion, direccion)) {
                System.out.println("El barco debe de entrar en el tablero");
                System.out.println();

                System.out.println("Introduce la fila donde quieres colocar el barco (1 - 5)");
                fila = comprobarIntegroMinMax(scan, 1, 5);

                System.out.println("Introduce la columna donde quieres colocar el barco (1 - 5)");
                columna = comprobarIntegroMinMax(scan, 1, 5);
            }

            //colocamos el barco
            tablero = colocarBarco(seleccion, direccion, tablero, fila, columna);

            //restamos al numero de barcos la seleccion del usuario
            if (seleccion.equals("P")) numBarcosPeque--;
            if (seleccion.equals("M")) numBarcosMedianos--;
            if (seleccion.equals("G")) numBarcosGrandes--;
        }

        return tablero;
    }

    /**
     * Crea un tablero con barcos posicionados aleatoriamente.
     * @return devuelve el tablero generado.
     */
    private static int[][] crearTableroAleatorio() {
        int[][] tablero = new int[5][5];
        int numBarcosPeque = 2;
        int numBarcosMedianos = 1;
        int numBarcosGrandes = 1;
        //creamos una array con las direcciones para luego poder seleccionar aleatoriamente una o otra
        String[] direcciones = {"H", "V"};

        //colocamos todos los tipos de barcos
        while (numBarcosPeque > 0) {
            tablero = colocarBarcoAleatorio(tablero, direcciones, "P");
            numBarcosPeque--;
        }

        while (numBarcosMedianos > 0) {
            tablero = colocarBarcoAleatorio(tablero, direcciones, "M");
            numBarcosMedianos--;
        }

        while (numBarcosGrandes > 0) {
            tablero = colocarBarcoAleatorio(tablero, direcciones, "G");
            numBarcosGrandes--;
        }

        return tablero;
    }

    /**
     * Coloca un barco aleatoriamente en el tablero
     * @param tablero tablero donde colocar el barco aleatoriamente
     * @param direcciones array con las posibles direcciones que puede ir el barco (H, V)
     * @param tipo tipo de barco a introducir (P, M, G)
     * @return devuelve el tablero con el barco posicionado aleatoriamente
     */
    private static int[][] colocarBarcoAleatorio(int[][] tablero, String[] direcciones, String tipo) {
        //generamos una fila y columna aleatorias donde colocar el barco
        int filaRandom = (int) (Math.random() * (5 - 1)) + 1;
        int columnaRandom = (int) (Math.random() * (5 - 1)) + 1;

        //generamos una direccion aleatoria para colocar el barco
        String direccionAleatoria = direcciones[(int) Math.round(Math.random())];

        //mientras no se pueda colocar el barco, volvemos a generar y probamos de nuevo
        while (!barcoEntra(filaRandom, columnaRandom, tablero, tipo, direccionAleatoria)) {
            filaRandom = (int) (Math.random() * (5 - 1)) + 1;
            columnaRandom = (int) (Math.random() * (5 - 1)) + 1;
            direccionAleatoria = direcciones[(int) Math.round(Math.random())];
        }

        return colocarBarco(tipo, direccionAleatoria, tablero, filaRandom, columnaRandom);
    }

    /**
     * Coloca el barco en el tablero en las posiciones indicadas con su direccion
     * @param seleccion tipo de barco seleccionado (P, M, G)
     * @param direccion direccion del barco (H, V)
     * @param tablero tablero donde colocar el barco
     * @param fila fila donde colocar el barco
     * @param columna columna donde colocar el barco
     * @return devuelve el tablero con el barco posicionado
     */
    private static int[][] colocarBarco(String seleccion, String direccion, int[][] tablero, int fila, int columna) {
        //Restamos uno a la fila y columna para que empiece por 0
        fila--;
        columna--;

        //dependiendo de la direccion y tamaño asignamos en el tablero el barco
        if (direccion.equals("V")) {
            if (seleccion.equals("P")) {
                tablero[fila][columna] = 1;
                tablero[fila + 1][columna] = 1;
            }

            if (seleccion.equals("M")) {
                tablero[fila][columna] = 2;
                tablero[fila + 1][columna] = 2;
                tablero[fila + 2][columna] = 2;
            }

            if (seleccion.equals("G")) {
                tablero[fila][columna] = 3;
                tablero[fila + 1][columna] = 3;
                tablero[fila + 2][columna] = 3;
                tablero[fila + 3][columna] = 3;
            }
        }

        if (direccion.equals("H")) {
            if (seleccion.equals("P")) {
                tablero[fila][columna] = 1;
                tablero[fila][columna + 1] = 1;
            }

            if (seleccion.equals("M")) {
                tablero[fila][columna] = 2;
                tablero[fila][columna + 1] = 2;
                tablero[fila][columna + 2] = 2;
            }

            if (seleccion.equals("G")) {
                tablero[fila][columna] = 3;
                tablero[fila][columna + 1] = 3;
                tablero[fila][columna + 2] = 3;
                tablero[fila][columna + 3] = 3;
            }
        }

        return tablero;
    }

    /**
     * Comprueba que un barco puede posicionarse en la posicion indicada con su dirección
     * @param fila fila indicada por el usuario
     * @param columna columna indicada por el usuario
     * @param tablero tablero donde introducir el barco
     * @param tipo tipo de barco a introducir (P, M, G)
     * @param direccion direccion del barco a introducir (H, V)
     * @return devuelve true o false segun entre o no el barco en la posicion indicada
     */
    private static boolean barcoEntra(int fila, int columna, int[][] tablero, String tipo, String direccion) {
        //Restamos uno a la fila y columna para que empiece por 0
        fila--;
        columna--;

        if (fila < 0 || columna < 0 || tablero[fila][columna] != 0) return false;

        //Añadimos un try catch para en caso de que el barco se salga del tablero devolvamos que no entra
        //(IndexOutOfBounds)
        try {
            if (direccion.equals("V")) {
                if (tipo.equals("P") && tablero[fila + 1][columna] == 0) return true;
                if (tipo.equals("M") && tablero[fila + 1][columna] == 0 && tablero[fila + 2][columna] == 0) return true;
                if (tipo.equals("G") && tablero[fila + 1][columna] == 0 && tablero[fila + 2][columna] == 0 && tablero[fila + 3][columna] == 0)
                    return true;
            }

            if (direccion.equals("H")) {
                if (tipo.equals("P") && tablero[fila][columna + 1] == 0) return true;
                if (tipo.equals("M") && tablero[fila][columna + 1] == 0 && tablero[fila][columna + 2] == 0) return true;
                if (tipo.equals("G") && tablero[fila][columna + 1] == 0 && tablero[fila][columna + 2] == 0 && tablero[fila][columna + 3] == 0)
                    return true;
            }
        } catch (Exception e) {
            return false;
        }

        return false;
    }

    /**
     * Comprueba que lo que el usuario introduce sea un integro y esté entre un rango
     * @param scan scanner de input
     * @param min minimo numero a introducir
     * @param max maximo numero a introducir
     * @return devuelve el numero introducido entre el rango
     */
    private static int comprobarIntegroMinMax(Scanner scan, int min, int max) {
        int numero = 0;
        while (numero < min || numero > max) {
            System.out.println("Debes introducir un numero entero entre " + min + " y " + max);
            while (!scan.hasNextInt()) {
                System.out.println("Debes introducir un numero entero entre " + min + " y " + max);
                scan.next();
            }

            numero = scan.nextInt();
        }

        return numero;
    }

    /**
     * Comprueba que la letra que introduzca el usuario sea una de estas:
     * P - barco pequeño
     * M - barco mediano
     * G - barco grande
     * También comprueba que queden barcos de la letra elegida.
     * @param scan scanner de input
     * @param peque numero de barcos restantes pequeños
     * @param medianos numero de barcos restantes medianos
     * @param grandes numero de barcos restantes grandes
     * @return devuelve la letra de barco elegida
     */
    private static String comprobarLetraBarco(Scanner scan, int peque, int medianos, int grandes) {
        String letra = scan.next();
        while (!letra.equals("P") && !letra.equals("M") && !letra.equals("G")) {
            System.out.println("La seleccion es incorrecta (P, M, G)");
            letra = scan.next();
        }

        if (letra.equals("P") && peque == 0 || letra.equals("M") && medianos == 0 || letra.equals("G") && grandes == 0) {
            System.out.println("No te quedan barcos de este tipo!");
            letra = comprobarLetraBarco(scan, peque, medianos, grandes);
        }

        return letra;
    }

    /**
     * Comprueba que la letra introducida sea una de estas:
     * H - Horizontal
     * V - Vertical
     * @param scan scanner de input
     * @return devuelve la letra H o V
     */
    private static String comprobarLetraDireccion(Scanner scan) {
        String letra = scan.next();
        while (!letra.equals("H") && !letra.equals("V")) {
            System.out.println("La seleccion es incorrecta (H, V)");
            letra = scan.next();
        }

        return letra;
    }

    /**
     * Recorre un tablero y imprime lo que hay en cada posición siguiendo la logica de:
     * 0 - agua (~)
     * 1 - barco pequeño (P)
     * 2 - barco mediano (M)
     * 3 - barco grande (G)
     * @param tablero la matriz de integros a imprimir
     */
    private static void imprimirTablero(int[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                //Si estamos en la primera columna, imprimimos el separador '|'
                if (j == 0) System.out.print("|");

                //Si el valor de la columna es agua (0), imprimimos '~'
                if (tablero[i][j] == 0) System.out.print("~|");

                //Si el valor de la columna es barco pequeño (1), imprimimos 'P'
                if (tablero[i][j] == 1) System.out.print("P|");

                //Si el valor de la columna es barco mediano (2), imprimimos 'M'
                if (tablero[i][j] == 2) System.out.print("M|");

                //Si el valor de la columna es barco grande (3), imprimimos 'G'
                if (tablero[i][j] == 3) System.out.print("G|");
            }
            System.out.println();
        }

        System.out.println();
    }

    /**
     * Pregunta al jugador la posicion que quiere atacar, esta es comorobada en caso de que sea barco(1, 2, 3)
     * se le volvera a preguntar por un anueva posicion a atacar y el valor de esta pasara a ser agua(0) hasta
     * que la pocicion escogida sea agua(0) en ese caso pasara turno al Eenemigo que este escojera la casilla a atacar
     * aleatoriamente y si toca un barco(1, 2, 3) esta posicon pasara a ser agua(0), en caso de que toque agua pasara
     * turno al Jugador.
     * @param scanner scanner de input
     * @param tableroJugador el tablero del jugador a jugar
     * @param tableroEnemigo el tablero de la maquina a jugar
     */
    public static void jugada(Scanner scanner, int[][] tableroJugador, int[][] tableroEnemigo) {
        int columna = 0;
        int fila = 0;
        int columnaJugador = 0;
        int filaJugador = 0;
        int valorPosicion = -1;

        //mientras que algun tablero contenga algun barco, sigue la partida
        do {

            //mientras el jugador no falle, sigue disparando
            do {
                imprimirTablero(tableroEnemigo);
                System.out.println("Indica que columa queries escoger");
                columna = comprobarIntegroMinMax(scanner, 1, 5);
                System.out.println("Inidca que fila quieres escoger");
                fila = comprobarIntegroMinMax(scanner, 1, 5);
                valorPosicion = tableroEnemigo[fila - 1][columna - 1];

                if (valorPosicion != 0) {
                    tableroEnemigo[fila - 1][columna - 1] = 0;
                    System.out.println("Has tocado un barco");
                }
            } while (valorPosicion != 0);

            System.out.println("Has tocado agua, turno del enemigo");

            //mientras el enemigo no falle, sigue disparando
            int valorPosicionEnemigo = -1;
            do {
                filaJugador = (int) (Math.random() * (4));
                columnaJugador = (int) (Math.random() * (4));
                valorPosicionEnemigo = tableroJugador[filaJugador][columnaJugador];

                if (tableroJugador[filaJugador][columnaJugador] != 0) {
                    tableroJugador[filaJugador][columnaJugador] = 0;
                }

                if (valorPosicionEnemigo != 0) {
                    tableroJugador[filaJugador][columnaJugador] = 0;
                    System.out.println("El enemigo te ha tocado un barco");
                    imprimirTablero(tableroJugador);
                }
                else {
                    System.out.println("El enemmigo a tocado agua, es tu tuno");
                }

            } while (valorPosicionEnemigo != 0);
        } while (!estaVacio(tableroEnemigo) && !estaVacio(tableroJugador));

        //en caso de que el tablero del jugador esté vacio, este pierde, sino gana
        if(estaVacio(tableroJugador)) {
            System.out.println("Has perdido :(");
        }else{
            System.out.println("Has ganado!");
        }
    }

    /**
     * Comprueba si todas las posiciones de la matriz son agua (0)
     * @param tablero el tablero a comprobar.
     * @return devuelve si el tablero esta vacio.
     */
    public static boolean estaVacio(int[][] tablero) {
        for (int i = 0; i < tablero.length; i++) {
            for (int j = 0; j < tablero[i].length; j++) {
                if (tablero[i][j] != 0) {
                    return false;
                }
            }
        }
        return true;
    }
}