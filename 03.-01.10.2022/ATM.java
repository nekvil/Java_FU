import java.util.Date;

public class ATM {
    private SchoolCard schoolCard;
    private SocialCard socialCard;
    private StudentCard studentCard;

    private final int[] date = new int[3];

    public void initMoneyAdd(StudentCard studentCard, float money) {
        this.studentCard = studentCard;
        this.studentCard.incCard(money);
    }

    public void initMoneyAdd(SchoolCard schoolCard, float money) {
        this.schoolCard = schoolCard;
        this.schoolCard.incCard(money);
    }

    public void initMoneyAdd(SocialCard socialCard, float money) {
        this.socialCard = socialCard;
        this.socialCard.incCard(money);
    }

    public void initRideAdd(SchoolCard schoolCard, float money) {
        this.schoolCard = schoolCard;
        float tax = 20.0f;
        float rides = money/tax;
        float mon = money%tax;
        this.socialCard.incCard(mon);
        this.schoolCard.incCard((int)rides);
    }

    public void initRideAdd(SocialCard socialCard, float money) {
        this.socialCard = socialCard;
        float tax = 30.0f;
        float rides = money/tax;
        float mon = money%tax;
        this.socialCard.incCard(mon);
        this.socialCard.incCard((int)rides);
    }

    public void initRideAdd(StudentCard studentCard, float money) {
        this.studentCard = studentCard;
        float tax = 35.0f;
        float rides = money/tax;
        float mon = money%tax;
        this.socialCard.incCard(mon);
        this.studentCard.incCard((int)rides);
    }

    public void initSubOperation(StudentCard studentCard, float money) {
        this.studentCard = studentCard;
        float tax = 300.0f;
        System.out.println();
        if(money >= tax) {
            calculateDate();
            this.studentCard.initBuyingSubscription(this.date);
            System.out.println("Подписка успешно оформлена");
        } else
            System.out.println("Недостаточно средств для оформления подписки");
    }

    public void initSubOperation(SchoolCard schoolCard, float money) {
        this.schoolCard = schoolCard;
        float tax = 100.0f;
        System.out.println();
        if(money >= tax) {
            calculateDate();
            this.schoolCard.initBuyingSubscription(this.date);
            System.out.println("Подписка успешно оформлена");
        } else
            System.out.println("Недостаточно средств для оформления подписки");
    }

    public void initSubOperation(SocialCard socialCard, float money) {
        this.socialCard = socialCard;
        float tax = 400.0f;
        System.out.println();
        if(money >= tax) {
            calculateDate();
            this.socialCard.initBuyingSubscription(this.date);
            System.out.println("Подписка успешно оформлена");
        } else
            System.out.println("Недостаточно средств для оформления подписки");
    }

    public void calculateDate() {
        String[] months = new String[]
                {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int month = 0;
        Date date = new Date();
        String monthStr = date.toString().substring(4, 7);
        String dayStr = date.toString().substring(8, 10);
        String yearStr = date.toString().substring(26, 28);
        for(int i = 0; i<months.length; i++) {
            if(months[i].equals(monthStr)) {
                month = i + 1;
            }
        }
        int day = Integer.parseInt(dayStr);
        int year = Integer.parseInt(yearStr);
        this.date[0] = day;
        this.date[1] = month;
        this.date[2] = year;
    }
}
