package in.ineuron.dao;

import in.ineuron.bo.CoronaVaccine;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;

@Repository
public interface ICoronaVaccineRepo extends JpaRepository<CoronaVaccine,Long> {
    public List<CoronaVaccine> findByCompany(String company);
    public List<CoronaVaccine> findByCompanyEquals(String company);
    public List<CoronaVaccine> findByCompanyIs(String company);
    public List<CoronaVaccine> findByPriceLessThan(Double price);
    public List<CoronaVaccine> findByCountryInAndPriceBetween(Collection<String> countries, double startRange,
                                                              double endRange);
    public List<CoronaVaccine> findByCountryNotIn(Collection<String> countries);
}
