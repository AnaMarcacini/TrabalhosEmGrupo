public class Main {
    public static void main(String[] args) {
        Account account = new Account(1000);
        Customer customers[] = {
        new Customer("Augustus", account),
        new Customer("Lucius", account),
        new Customer("Claudius", account),
        new Customer("Tiberius", account)};
        Signal.handle(new Signal("INT"), // CTRL+C
        (Signal signal) ‐> {
        System.out.println("Terminando a simulação...");
        for (Customer customer : customers) {
        customer.interrupt();
        }
        });
    for (Customer customer : customers) {
    customer.start();
    }
    }
    }