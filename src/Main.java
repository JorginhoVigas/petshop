import java.util.Scanner;
public class Main {

    private final static Scanner scanner = new Scanner(System.in);

    private final static PetMachine petMachine = new PetMachine();
    public static void main(String[] args) {
        // scanner.useDelimiter("\\n");       
        var option = -1;

        do{
            System.out.println("*** Escolha uma das opcoes ***");
            System.out.println("1 - Dar banho no pet");
            System.out.println("2 - Abastecer a máquina com água");
            System.out.println("3 - Abastecer a máquina com shampoo");
            System.out.println("4 - Verificar água da máquina");
            System.out.println("5 - Verificar shampoo da máquina");
            System.out.println("6 - Verificar se tem pet no banho");
            System.out.println("7 - Colocar pet na máquina");
            System.out.println("8 - Retirar pet da máquina");
            System.out.println("9 - Limpar a máquina");
            System.out.println("0 - Sair ");
            option = scanner.nextInt();

            switch (option) {
                case 1: 
                    petMachine.takeAShower();
                        break;
                case 2:  
                    setWater();
                        break;
                case 3:  
                    setShampoo();
                        break;
                case 4:  
                    verifyWater();
                        break;
                case 5:  
                    verifyShampoo();
                        break;
                case 6:  
                    checkIfHasPetInMachine();
                        break;  
                case 7:  
                    setPetInPetMachine();
                        break;
                case 8: 
                    petMachine.removePet();
                        break;
                case 9:  
                    petMachine.wash();
                        break;
                case 0: 
                    System.out.println("Encerrando o programa...");
                    scanner.close();
                    return;
                default:  System.out.println("Opcao inválida");
                        break;
            }
        }while (true);
    }

    private static void setWater(){
        System.out.println("Tentando colocar água na máquina");
        petMachine.addWater();
    }

    private static void setShampoo(){
        System.out.println("Tentando colocar shampoo na máquina");
        petMachine.addShampoo();
    }

    private static void verifyWater() {
        var amout = petMachine.getWater();
        System.out.println("A máquina está no momento com " + amout + "  litro(s) de água");
    }

    private static void verifyShampoo() {
        var amout = petMachine.getShampoo();
        System.out.println("A máquina está no momento com " + amout + "  litro(s) de shampoo");
    }

    private static void checkIfHasPetInMachine() {
        var hasPet = petMachine.hasPet();
        System.out.println(hasPet ? "Tem pet na máquina" : "Nao tem pet na máquina" );
    }

    public static void setPetInPetMachine(){
        var name = "";
        while (name == null || name.isEmpty()) {
            System.out.println("Informe o nome do pet");
            name = scanner.next();
        }
        var pet = new Pet(name);
        petMachine.setPet(pet);
    }

}

