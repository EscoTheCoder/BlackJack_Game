import java.util.*;

public class Game {

    String player;
    Random random = new Random();
    ArrayList<Integer> trapoula;

    public Game(String player, ArrayList<Integer> trapoula) {
        this.player = player;
        this.trapoula = trapoula;
    }

    public String partida() {

        ArrayList<Integer> fulla_paikth = new ArrayList<>();
        ArrayList<Integer> fulla_manas = new ArrayList<>();
        Scanner sc = new Scanner(System.in);
        System.out.print("KALHSPERA KYRIE " + player + " EISTE ETOIMOS NA JEKINISOUME : ");
        String answer = sc.nextLine();
        if (answer.equals("yes")) {
            System.out.println("JEKINAEI TO PAIXNIDI KALH SAS EPITUXIA!!!");
            boolean flag = true;
            while (flag) {
                System.out.println("FULLO PAIKTH = " + moirasma(fulla_paikth));
                System.out.println("FULLO MANAS = " + moirasma(fulla_manas));
                String sunexeia;
                System.out.print("STAY OR HIT : ");
                sunexeia = sc.nextLine();
                if (sunexeia.equals("s")) { //s->STAY
                    flag = false;
                }
                int sum = 0;
                for (int card : fulla_paikth) {
                    sum += card;
                }
                boolean lose = false;
                if (sunexeia.equals("h")) { //h->HIT
                    while (sum < 21 && !lose) {
                        System.out.println("TA FULLA SOU = " + moirasma(fulla_paikth));
                        sum = 0;
                        for (int card : fulla_paikth) {
                            sum += card;
                        }
                        if (sum > 21) {
                            System.out.println("EXASES JEPERASES TO 21");
                            lose = true;
                            break;
                        } else {
                            System.out.print("STAY OR HIT : ");
                            sunexeia = sc.nextLine();
                            if (sunexeia.equals("s")) {
                                flag = false;
                                break;
                            }
                        }
                    }
                }
                if (lose) {
                    System.out.println("ISWS NIKISETE KAPIA ALLH FORA!!!");
                    flag = false;
                }

                int sum_manas = fulla_manas.get(0);
                if (sum_manas <= 16) {
                    while (sum_manas <= 16) {
                        moirasma(fulla_manas);
                        sum_manas += fulla_manas.get(fulla_manas.size() - 1);
                    }
                }

                System.out.println("TA FULLA THS MANAS= " + fulla_manas);
            }
            
            System.out.println(who_wins(fulla_paikth, fulla_manas));
        }
        else  {
            System.out.println("EUXARSTOUME POLY MPOREITE NA APOLAFSETE KAPOIO ALLO PAIXNIDI TOU CASINO MAS!");
        }
        return "OK";
    }

    public ArrayList<Integer> moirasma(ArrayList<Integer> fulla) {
        Random r = new Random();
        Collections.shuffle(trapoula);
        int tuxaio_fullo = trapoula.get(r.nextInt(trapoula.size()));
        fulla.add(tuxaio_fullo);
        return fulla;
    }

    public String who_wins(ArrayList<Integer> fulla_paikth, ArrayList<Integer> fulla_manas) {
        int sum_paixth = 0;
        int sum_manas = 0;
        for (int card : fulla_paikth) {
            sum_paixth += card;
        }

        for (int card : fulla_manas) {
            sum_manas += card;
        }

        if (sum_paixth > sum_manas && sum_paixth<=21) {
            return "O PAIXTHS NIKHSE";
        }
        else if (sum_paixth < sum_manas && sum_manas>21) {
            return "O PAIXTHS NIKHSE";
        }
        else if (sum_paixth < sum_manas && sum_manas<21) {
            return "H MANA NIKHSE";
        }
        else{
            return "ISOPALIA";
        }
    }
}
