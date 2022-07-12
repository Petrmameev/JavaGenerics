public class Ticket implements Comparable<Ticket> {
    protected int id;
    protected int price;
    protected String from;
    protected String to;
    protected int flyTime;

    public Ticket(int id, int price, String start, String finish, int flyTime) {
        this.id = id;
        this.price = price;
        this.from = start;
        this.to = finish;
        this.flyTime = flyTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String start) {
        this.from = start;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String finish) {
        this.to = finish;
    }

    public int getFlyTime() {
        return flyTime;
    }

    public void setFlyTime(int flyTime) {
        this.flyTime = flyTime;
    }

    @Override
    public int compareTo(Ticket p2) {

        return price - p2.getPrice();
    }
    public boolean matches(Ticket ticket, String search) {
        return ticket.getTo().contains(search);
    }

}
