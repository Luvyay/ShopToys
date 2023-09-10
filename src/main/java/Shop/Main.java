package Shop;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        System.out.println("Доступные действия: выход, добавить, включить, выключить и приз.");
        System.out.print("Введите действие: ");
        Scanner scanner = new Scanner(System.in);
        String command = scanner.nextLine();
        MachineToys machineToys = new MachineToys();

        while(!(command.equals("выход") || command.equals("exit"))){

            if (command.equals("добавить") || command.equals("add")) {
                System.out.println("Для возвращения ввода команд введите \"выход\" или \"exit\"");
                System.out.println("Пример добавления игрушки: 1 кукла 5 90");
                System.out.print("Добавить игрушку (айди, название, количество и вес): ");
                command = scanner.nextLine();

                while (!(command.equals("выход") || command.equals("exit"))) {
                    String[] commandSplit = command.split(" ");
                    machineToys.addToys(new Toys(Integer.parseInt(commandSplit[0]), commandSplit[1],
                            Integer.parseInt(commandSplit[2]), Integer.parseInt(commandSplit[3])));
                    System.out.print("Добавить игрушку (айди, название, количество и вес): ");
                    command = scanner.nextLine();
                }
            }

            if (command.equals("включить") || command.equals("run")){
                machineToys.runMachine();
            }

            if (command.equals("приз") || command.equals("prize")){
                System.out.println(machineToys.getPrize());
            }

            if (command.equals("выключить") || command.equals("switchOff")){
                machineToys.switchOffMachine();
            }

            System.out.print("Введите действие: ");
            command = scanner.nextLine();
        }
    }
}
