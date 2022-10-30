public class Validator {

    private boolean access;
    private int allMyRides;
    private int myOneRides;
    private float myBalance;
    private float balance;
    private int rides;
    private final int[] subDate = new int[3];
    private boolean subDateStatus;

    public void initCard(SocialCard socialCard) {
        this.balance = socialCard.getBalance();
        this.rides = socialCard.getRides();
        int[] localSubDate = socialCard.getSubDate();
        System.arraycopy(localSubDate, 0, this.subDate, 0, 3);

        getSubStatus(this.subDate);
        System.out.println();
        if(subDateStatus){
            System.out.println("Оплата произведена по подписке");
            this.access = true;
        } else if(this.rides >= 1){
            socialCard.decCard(1);
            System.out.println("Оплата произведена "+"-1 поездка");
            this.myOneRides += 1;
            this.access = true;
        } else if(this.balance >= 40.0f){
            socialCard.decCard(40.0f);
            System.out.println("Оплата произведена "+"-40 руб");
            this.access = true;
            this.myBalance += 40;
        } else
            System.out.println("Недостаточно средств на счету");

        getCardInfo(socialCard);
        if (this.access){
            this.access = false;
            this.allMyRides += 1;
        }
    }

    public void initCard(SchoolCard schoolCard) {
        this.balance = schoolCard.getBalance();
        this.rides = schoolCard.getRides();
        int[] localSubDate = schoolCard.getSubDate();
        System.arraycopy(localSubDate, 0, this.subDate, 0, 3);

        getSubStatus(this.subDate);
        System.out.println();
        if(subDateStatus){
            System.out.println("Оплата произведена по подписке");
            this.access = true;
        } else if(this.rides >= 1){
            schoolCard.decCard(1);
            System.out.println("Оплата произведена "+"-1 поездка");
            this.access = true;
            this.myOneRides += 1;
        } else if(this.balance >= 30.0f){
            schoolCard.decCard(30.0f);
            System.out.println("Оплата произведена "+"-30 руб");
            this.access = true;
            this.myBalance += 30;
        } else
            System.out.println("Недостаточно средств на счету");

        getCardInfo(schoolCard);
        if (this.access){
            this.access = false;
            this.allMyRides += 1;
        }
    }

    public void initCard(StudentCard studentCard) {
        this.balance = studentCard.getBalance();
        this.rides = studentCard.getRides();
        int[] localSubDate = studentCard.getSubDate();
        System.arraycopy(localSubDate, 0, this.subDate, 0, 3);

        getSubStatus(this.subDate);
        System.out.println();
        if(subDateStatus){
            System.out.println("Оплата произведена по подписке");
            this.access = true;
        } else if(this.rides >= 1){
            studentCard.decCard(1);
            System.out.println("Оплата произведена "+"-1 поездка");
            this.myOneRides += 1;
            this.access = true;
        } else if(this.balance >= 45.0f){
            studentCard.decCard(45.0f);
            System.out.println("Оплата произведена "+"-45 руб");
            this.access = true;
            this.myBalance += 45;
        } else
            System.out.println("Недостаточно средств на счету");

        getCardInfo(studentCard);
        if (this.access){
            this.access = false;
            this.allMyRides += 1;
        }
    }

    private void getCardInfo(TransportCard card){
        System.out.println();
        System.out.println("Баланс по карте: " + card.getBalance() + " руб");
        System.out.println("Поездок по карте: " + card.getRides());
        String result = getSubStatus(this.subDate);
        System.out.println(result);
    }

    private String getSubStatus(int[] subDate) {
        if(this.subDate[0] == 0) {
            this.subDateStatus = false;
            return "Подписка: нет";
        } else {
            int[] localDate = App.calculateDate(0);
            if(localDate[2] <= subDate[2]){
                if(localDate[1] <= subDate[1]){
                    if(localDate[0] <= subDate[0]){
                        subDateStatus = true;
                        return "Подписка: действует c " + subDate[0] + "." + subDate[1]  + "." + subDate[2] +
                                " до " + subDate[0] + "." + (subDate[1]+1)  + "." + subDate[2];
                    } else {
                        subDateStatus = false;
                        return "Подписка: нет";
                    }
                } else {
                    subDateStatus = false;
                    return "Подписка: нет";
                }
            } else {
                subDateStatus = false;
                return "Подписка: нет";
            }
        }
    }

    public void getGlobalStatistic(){
        System.out.println("\nСтатистика валидатора\n");
        System.out.println("Проходимость: " + this.allMyRides);
        System.out.println("Штучных поездок: " + this.myOneRides);
        System.out.println("Заработал: " + this.myBalance);
    }
}
