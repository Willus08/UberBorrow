package helpme_productions.com.uberborrow.model;



public class CarInformation {
    private String renter;
    private String borrower;//will be "available" when no one has it
    private String make;
    private String model;
    private String color;
    private String beginRentTime;
    private String endRentTime;
    private String year;
    private String location;

    public CarInformation(String renter, String borrower, String make, String model, String color, String beginRentTime, String endRentTime, String year, String location) {
        this.renter = renter;
        this.borrower = borrower;
        this.make = make;
        this.model = model;
        this.color = color;
        this.beginRentTime = beginRentTime;
        this.endRentTime = endRentTime;
        this.location = location;
        this.year = year;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRenter() {
        return renter;
    }

    public void setRenter(String renter) {
        this.renter = renter;
    }

    public String getBorrower() {
        return borrower;
    }

    public void setBorrower(String borrower) {
        this.borrower = borrower;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getBeginRentTime() {
        return beginRentTime;
    }

    public void setBeginRentTime(String beginRentTime) {
        this.beginRentTime = beginRentTime;
    }

    public String getEndRentTime() {
        return endRentTime;
    }

    public void setEndRentTime(String endRentTime) {
        this.endRentTime = endRentTime;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }
}
