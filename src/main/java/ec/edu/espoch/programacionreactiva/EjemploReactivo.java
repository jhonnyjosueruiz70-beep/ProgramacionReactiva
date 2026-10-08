package ec.edu.espoch.programacionreactiva;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

public class EjemploReactivo {

    public static void main(String[] args) {

        System.out.println("=== EJEMPLO DE FLUX ===");
        Flux<String> pedidos = Flux.just(
                "Pedido 1",
                "Pedido 2",
                "Pedido 3",
                "Pedido 4"
        );

        pedidos
            .filter(pedido -> !pedido.equals("Pedido 2"))
            .map(pedido -> pedido + " - Procesado")
            .subscribe(
                pedido -> System.out.println("Recibido: " + pedido),
                error -> System.out.println("Error: " + error),
                () -> System.out.println("Todos los pedidos fueron procesados")
            );

        System.out.println("\n=== EJEMPLOS DE MONO ===");
        ejemploMonoConDatos();
        ejemploMonoVacio();
    }

    // 1. Método para un Mono que emite un solo valor
    public static void ejemploMonoConDatos() {
        Mono<String> cliente = Mono.just("Cliente 1");

        cliente.subscribe(
            c -> System.out.println("Cliente recibido: " + c),
            error -> System.out.println("Error: " + error),
            () -> System.out.println("Procesamiento de cliente finalizado")
        );
    }

    // 2. Método para un Mono vacío
    public static void ejemploMonoVacio() {
        Mono<String> clienteVacio = Mono.empty();

        clienteVacio.subscribe(
            c -> System.out.println("Cliente recibido: " + c),
            error -> System.out.println("Error: " + error),
            () -> System.out.println("Mono vacío: No se recibió ningún cliente.")
        );
    }
}