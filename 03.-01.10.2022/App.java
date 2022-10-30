import java.util.Date;

public class App {
    private SchoolCard schoolCard;
    private SocialCard socialCard;
    private StudentCard studentCard;

    private final int[] date = new int[3];

    public void initMoneyAdd(SchoolCard schoolCard, float money) {
        this.schoolCard = schoolCard;
        this.schoolCard.incCard(money);
    }

    public void initMoneyAdd(SocialCard socialCard, float money) {
        this.socialCard = socialCard;
        this.socialCard.incCard(money);
    }

    public void initMoneyAdd(StudentCard studentCard, float money) {
        this.studentCard = studentCard;
        this.studentCard.incCard(money);
    }

    public void initRideAdd(SchoolCard schoolCard, float money) {
        this.schoolCard = schoolCard;
        float tax = 20.0f;
        float roads = money/tax;
        float mon = money%tax;
        this.socialCard.incCard(mon);
        this.schoolCard.incCard((int)roads);
    }

    public void initRideAdd(SocialCard socialCard, float money) {
        this.socialCard = socialCard;
        float tax = 30.0f;
        float roads = money/tax;
        float mon = money%tax;
        this.socialCard.incCard(mon);
        this.socialCard.incCard((int)roads);
    }

    public void initRideAdd(StudentCard studentCard, float money) {
        this.studentCard = studentCard;
        float tax = 35.0f;
        float roads = money/tax;
        float mon = money%tax;
        this.socialCard.incCard(mon);
        this.studentCard.incCard((int)roads);
    }

    public void initSubOperation(StudentCard studentCard, float money) {
        this.studentCard = studentCard;
        float tax = 300.0f;
        if(money >= tax) {
            int[] localDate = calculateDate(1);
            this.date[0] = localDate[0];
            this.date[1] = localDate[1];
            this.date[2] = localDate[2];
            this.studentCard.initBuyingSubscription(this.date);
            System.out.println("Подписка успешно оформлена");
        } else
            System.out.println("Недостаточно средств для оформления подписки");
    }

    public void initSubOperation(SchoolCard schoolCard, float money) {
        this.schoolCard = schoolCard;
        float tax = 100.0f;
        if(money >= tax) {
            int[] localDate = calculateDate(1);
            this.date[0] = localDate[0];
            this.date[1] = localDate[1];
            this.date[2] = localDate[2];
            this.schoolCard.initBuyingSubscription(this.date);
            System.out.println("Подписка успешно оформлена");
        } else
            System.out.println("Недостаточно средств для оформления подписки");
    }

    public void initSubOperation(SocialCard socialCard, float money) {
        this.socialCard = socialCard;
        float tax = 400.0f;
        if(money >= tax) {
            int[] localDate = calculateDate(1);
            this.date[0] = localDate[0];
            this.date[1] = localDate[1];
            this.date[2] = localDate[2];
            this.socialCard.initBuyingSubscription(this.date);
            System.out.println("Подписка успешно оформлена");
        } else
            System.out.println("Недостаточно средств для оформления подписки");
    }

    public static int[] calculateDate(int m) {
        String[] months = new String[]
                {"Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"};
        int[] localDate = new int[3];
        int month = 0;
        Date date = new Date();
        String monthStr = date.toString().substring(4, 7);
        String dayStr = date.toString().substring(8, 10);
        String yearStr = date.toString().substring(26, 28);
        for(int i = 0; i<months.length; i++) {
            if(months[i].equals(monthStr)) {
                month = i + m;
            }
        }
        int day = Integer.parseInt(dayStr);
        int year = Integer.parseInt(yearStr);
        localDate[0] = day;
        localDate[1] = month;
        localDate[2] = year;
        return localDate;
    }

}
