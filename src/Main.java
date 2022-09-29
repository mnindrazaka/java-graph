import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        PeopleNetwork network = new PeopleNetwork();

        People aka = new People("Aka");
        People danny = new People("Danny");
        People agung = new People("Agung");
        People doni = new People("Doni");
        People andri = new People("Andri");
        People ilham = new People("Ilham");
        People indra = new People("Indra");
        People fanny = new People("Fanny");
        People natan = new People("Natan");

        network.addPeople(aka);
        network.addPeople(danny);
        network.addPeople(agung);
        network.addPeople(doni);
        network.addPeople(andri);
        network.addPeople(ilham);
        network.addPeople(indra);
        network.addPeople(fanny);
        network.addPeople(natan);

        network.addConnection(aka, danny);
        network.addConnection(aka, agung);
        network.addConnection(aka, doni);
        network.addConnection(aka, andri);
        network.addConnection(aka, ilham);
        network.addConnection(aka, indra);
        network.addConnection(aka, fanny);
        network.addConnection(aka, natan);

        network.addConnection(danny, agung);
        network.addConnection(danny, doni);
        network.addConnection(danny, andri);
        network.addConnection(danny, ilham);
        network.addConnection(danny, indra);
        network.addConnection(danny, natan);

        network.addConnection(agung, doni);
        network.addConnection(agung, andri);
        network.addConnection(agung, ilham);

        network.addConnection(doni, andri);
        network.addConnection(doni, ilham);

        network.addConnection(andri, ilham);
        network.addConnection(andri, indra);

        network.addConnection(ilham, indra);
        network.addConnection(ilham, fanny);
        network.addConnection(ilham, natan);

        Scanner scan = new Scanner(System.in);
        int option;


        do {
            System.out.println("People Network Management");
            System.out.println("What do you want to do ?");
            System.out.println("1. Show people list");
            System.out.println("2. Add new people");
            System.out.println("3. Add connection");
            System.out.println("4. Show connection");
            System.out.println("5. Show connection suggestion");
            System.out.println("6. Exit");

            System.out.print("Input your option : ");
            option = scan.nextInt();
            scan.nextLine();

            if (option == 1) {
                network.printPeopleList();
                scan.nextLine();
            } else if (option == 2) {
                System.out.print("Input name : ");
                String name = scan.nextLine();

                People people = new People(name);
                network.addPeople(people);
            } else if (option == 3) {
                System.out.print("Input source name : ");
                String sourceName = scan.nextLine();

                People source = network.getPeopleByName(sourceName);
                if (source == null) {
                    System.out.println("People not found");
                    continue;
                }

                System.out.print("Input destination name : ");
                String destinationName = scan.nextLine();

                People destination = network.getPeopleByName(destinationName);
                if (destination == null) {
                    System.out.println("People not found");
                    continue;
                }

                network.addConnection(source, destination);
            } else if (option == 4) {
                System.out.print("Input name : ");
                String sourceName = scan.nextLine();

                People source = network.getPeopleByName(sourceName);
                if (source == null) {
                    System.out.println("People not found");
                }
                network.printConnection(source);
                scan.nextLine();
            } else if (option == 5) {
                System.out.print("Input name : ");
                String sourceName = scan.nextLine();

                People source = network.getPeopleByName(sourceName);
                if (source == null) {
                    System.out.println("People not found");
                }
                network.printConnectionSuggestion(source);
                scan.nextLine();
            } else if (option == 6) {
                System.out.println("Thank you");
            } else {
                System.out.println("Invalid input");
            }
        } while (option != 5);
    }
}