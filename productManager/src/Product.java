public class Product {
    private int id;
    private String name;
    private int price;
    private boolean status;
    private String description;
    public Product() {
    }
    public Product(int id,String name,int price,boolean status,String description) {
        this.id=id;
        this.name = name;
        this.price=price;
        this.status=status;
        this.description=description;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
