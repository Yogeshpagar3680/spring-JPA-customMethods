package in.ineuron.service;

import in.ineuron.bo.CoronaVaccine;

import java.util.List;

public interface ICoronaVaccineManagementService {
    public List<CoronaVaccine> fetchVaccineByCompany(String company);

    public List<CoronaVaccine> fetchVaccineByPricesLessThan(Double price);

    public List<CoronaVaccine> searchVaccineByCountriesAndPriceRange(List<String> countires, double startRange,
                                                                     double endRange);

    public List<CoronaVaccine> fetchVaccineNotByCountry(List<String> countries);
}
