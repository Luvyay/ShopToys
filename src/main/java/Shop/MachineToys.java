package Shop;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class MachineToys {
    private List<Toys> storageToys = new ArrayList<>();
    private Deque<Toys> queToys = new ArrayDeque<>();

    private boolean isTurnedOn = false;

    public void addToys(Toys toys){
        if (this.isTurnedOn){
            System.out.println("Автомат игрушек запущен! Выключите и добавьте игрушки.");
        } else {
            this.storageToys.add(toys);
        }
    }

    private void raffleToys(){
        while(this.storageToys.size() > 0) {
            Random random = new Random();
            int rndElementArray = random.nextInt(this.storageToys.size());
            int rndChance = random.nextInt(100);

            if (this.storageToys.get(rndElementArray).getWeight() >= rndChance){
                this.queToys.add(this.storageToys.get(rndElementArray));

                int currentAmount = this.storageToys.get(rndElementArray).getAmount();
                this.storageToys.get(rndElementArray).setAmount(currentAmount - 1);

                if (this.storageToys.get(rndElementArray).getAmount() == 0){
                    deleteToys(rndElementArray);
                }
            }
        }
    }

    private void deleteToys(int id){
        this.storageToys.remove(id);
    }

    public void runMachine(){
        if (this.isTurnedOn){
            System.out.println("Автомат игрушек уже запущен.");
        } else {
            if (this.storageToys.size() != 0){
                this.isTurnedOn = true;
                System.out.println("Автомат игрушек запущен.");
                raffleToys();
            } else {
                System.out.println("В автомате игрушек нет игрушек. Добавьте игрушки и запустите повторно.");
                System.out.println("Либо проверьте наличие призов (действие: приз).");
            }
        }
    }

    public String getPrize(){
        if (this.queToys.size() > 0) {
            saveInFile(this.queToys.peek());
            return this.queToys.poll().getName();
        } else {
            return "Нет призов.";
        }
    }

    public void switchOffMachine(){
        if (this.isTurnedOn) {
            this.isTurnedOn = false;
            System.out.println("Автомат игрушек выключен.");
        } else {
            System.out.println("Автомат игрушек и так выключен.");
        }
    }

    private void saveInFile(Toys toys){
        String fileName = "prize.txt";

        try (FileWriter fileWriter = new FileWriter(fileName, true);
             BufferedWriter out = new BufferedWriter(fileWriter)) {
            out.write(String.format("%s %s %s\n", toys.getId(), toys.getName(), toys.getWeight()));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
