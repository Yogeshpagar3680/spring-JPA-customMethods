package in.ineuron.bo;

import org.hibernate.annotations.GeneratorType;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity
public class CoronaVaccine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long registerNo;
    private String name;
    private String country;
    private String company;
    private Double price;
    private Integer requiredDoseCount;

    public CoronaVaccine(Long registerNo, String name, String country, String company, Double price, Integer requiredDoseCount) {
        this.registerNo = registerNo;
        this.name = name;
        this.country = country;
        this.company = company;
        this.price = price;
        this.requiredDoseCount = requiredDoseCount;
    }

    public CoronaVaccine(String name, String company, String country, Double price, Integer requriedDoseCount) {
        super();
        this.name = name;
        this.company = company;
        this.country = country;
        this.price = price;
        this.requiredDoseCount = requriedDoseCount;
    }

    public CoronaVaccine() {
    }

    @Override
    public String toString() {
        return "CoronaVaccine{" +
                "registerNo=" + registerNo +
                ", name='" + name + '\'' +
                ", country='" + country + '\'' +
                ", company='" + company + '\'' +
                ", price=" + price +
                ", requiredDoseCount=" + requiredDoseCount +
                '}';
    }

    public Long getRegisterNo() {
        return registerNo;
    }

    public void setRegisterNo(Long registerNo) {
        this.registerNo = registerNo;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public Integer getRequiredDoseCount() {
        return requiredDoseCount;
    }

    public void setRequiredDoseCount(Integer requiredDoseCount) {
        this.requiredDoseCount = requiredDoseCount;
    }
}
