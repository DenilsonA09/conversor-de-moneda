

import java.io.IOException;

import java.util.Scanner;

public class Principal {
    public static void main(String[] args) throws IOException, InterruptedException {
        Scanner lectura = new Scanner(System.in);
        Scanner eleccion = new Scanner(System.in);
        String convertido = "";
        String aConvertir = "";
        while (true) {
            System.out.println("""
                *******************
                ¡Sea bienvenido(a) al conversor de monedas! 
                1) Dólar -> Peso Argentino
                2) Peso Argentino -> Dólar
                3) Dólar -> Real brasileño
                4) Real brasileño -> Dólar
                5) Dólar -> Peso colombiano
                6) Peso colombiano -> Dólar
                7) Salir
                *******************
                """);
            int opcion = eleccion.nextInt();

            switch (opcion) {
                case 1:
                    convertido = "USD";
                    aConvertir = "ARS";
                    break;

                case 2:
                    convertido = "ARS";
                    aConvertir = "USD";
                    break;
                case 3:
                    convertido = "USD";
                    aConvertir = "BRL";
                    break;
                case 4:
                    convertido = "BRL";
                    aConvertir = "USD";
                    break;
                case 5:
                    convertido = "USD";
                    aConvertir = "COP";
                    break;
                case 6:
                    convertido = "COP";
                    aConvertir = "USD";
                    break;

                case 7:
                    System.out.println("¡Gracias por usar nuestro conversor de monedas!");
                    System.exit(0);
                default:
                    System.out.println("Digitó un número incorrecto, por favor, use uno válido");

            }
            ConsultaApi consultaApi = new ConsultaApi();
            System.out.println("Ingrese el valor a convertir");
            try {
                var valor = Double.valueOf(lectura.nextLine());
                Moneda moneda = consultaApi.consultaMoneda(valor, convertido, aConvertir);
                System.out.println(valor);
                System.out.println(moneda);
            } catch (Exception e) {
                System.out.println("Se produjo un error");
                System.out.println("Fin de la aplicación");
            }



        }



    }
}
