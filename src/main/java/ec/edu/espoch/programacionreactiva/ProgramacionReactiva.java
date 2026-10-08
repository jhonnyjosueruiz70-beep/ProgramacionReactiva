package ec.edu.espoch.programacionreactiva;

import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author User
 */
public class ProgramacionReactiva {

    public static void main(String[] args) {
        // 1. Ejecutar el código de Flux
        probandoFlux();

        // 2. Ejecutar el código de Mono con datos
        probandoMono();

        // 3. Ejecutar el código de Mono vacío
        probandoMonoVacio();
    }

    // --- MÉTODOS CREADOS DEBAJO DEL MAIN ---

    public static void probandoFlux() {
        System.out.println("=== PRUEBA DE FLUX ===");
        Flux<String> pedidos = Flux.just("Pedido 1", "Pedido 2", "Pedido 3", "Pedido 4");

        pedidos
            .filter(pedido -> !pedido.equals("Pedido 2"))
            .map(pedido -> pedido + " - Procesado")
            .subscribe(
                pedido -> System.out.println("Recibido: " + pedido),
                error -> System.out.println("Error: " + error),
                () -> System.out.println("Todos los pedidos fueron procesados")
            );
    }

    public static void probandoMono() {
        System.out.println("\n=== PRUEBA DE MONO ===");
        Mono<String> cliente = Mono.just("Cliente 1");

        cliente.subscribe(
            c -> System.out.println("Cliente recibido: " + c),
            error -> System.out.println("Error: " + error),
            () -> System.out.println("Procesamiento de cliente completado")
        );
    }

    public static void probandoMonoVacio() {
        System.out.println("\n=== PRUEBA DE MONO VACÍO ===");
        Mono<String> clienteVacio = Mono.empty();

        clienteVacio.subscribe(
            c -> System.out.println("Cliente recibido: " + c),
            error -> System.out.println("Error: " + error),
            () -> System.out.println("Mono vacío: No se recibió ningún cliente.")
        );
    }
}