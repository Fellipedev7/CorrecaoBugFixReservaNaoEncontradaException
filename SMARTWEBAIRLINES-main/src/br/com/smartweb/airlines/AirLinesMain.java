package br.com.smartweb.airlines;

public class AirLinesMain {

    public static void main(String[] args) {
        System.out.println("======================== SMARTWEB AIRLINES ========================");
        
        var servicoDeReserva = new ServicoDeReserva();
        var servicoDeBagagem = new ServicoDeBagagem(servicoDeReserva);
        Voo_old voo = new Voo_old("G31333", "UDI", "GRU");

        
        servicoDeReserva.adicionar(new Reserva("28A888", voo, "Yuri da costa"));
        servicoDeReserva.adicionar(new Reserva("28B111", voo, "Alvaro vasconcelos"));
        servicoDeReserva.adicionar(new Reserva("74F877", voo, "Rogério dos santos pereira"));

        
        try {
            servicoDeBagagem.contratar("28AXXX", 2);
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao contratar bagagem: " + e.getMessage());
        }

        
        try {
            servicoDeBagagem.contratar("28A888", 2);
        } catch (IllegalArgumentException e) {
            System.err.println("Erro ao contratar bagagem: " + e.getMessage());
        }

        
        System.out.println("\nReservas atuais no sistema:");
        servicoDeReserva.getReservas().forEach(System.out::println);

        System.out.println("=====================================================================");
    }
}