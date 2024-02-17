package in.ineuron;

import in.ineuron.bo.CoronaVaccine;
import in.ineuron.service.ICoronaVaccineManagementService;
import org.springframework.boot.SpringApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.List;

@SpringBootApplication
public class SpringDataJpaApplication {
	public static void main(String[] args) {
		ApplicationContext factory = SpringApplication.run(SpringDataJpaApplication.class, args);
		ICoronaVaccineManagementService service = factory.getBean(ICoronaVaccineManagementService.class);

		service.fetchVaccineByCompany("serum").forEach(System.out::println);

		service.fetchVaccineByPricesLessThan(450.5).forEach(System.out::println);

		List<String> countries = new ArrayList<String>();
		//countries.add("IND");
		countries.add("Russia");
		service.searchVaccineByCountriesAndPriceRange(countries, 200.0,
		500.0).forEach(System.out::println);

		/**
		 * Hibernate:
		 *     select
		 *         coronavacc0_.register_no as register1_0_,
		 *         coronavacc0_.company as company2_0_,
		 *         coronavacc0_.country as country3_0_,
		 *         coronavacc0_.name as name4_0_,
		 *         coronavacc0_.price as price5_0_,
		 *         coronavacc0_.required_dose_count as required6_0_
		 *     from
		 *         corona_vaccine coronavacc0_
		 *     where
		 *         (
		 *             coronavacc0_.country in (
		 *                 ? , ?
		 *             )
		 *         )
		 *         and (
		 *             coronavacc0_.price between ? and ?
		 *         )
		 */

		service.fetchVaccineNotByCountry(countries).forEach(System.out::println);;
		((ConfigurableApplicationContext) factory).close();

		/**
		 * Hibernate:
		 *     select
		 *         coronavacc0_.register_no as register1_0_,
		 *         coronavacc0_.company as company2_0_,
		 *         coronavacc0_.country as country3_0_,
		 *         coronavacc0_.name as name4_0_,
		 *         coronavacc0_.price as price5_0_,
		 *         coronavacc0_.required_dose_count as required6_0_
		 *     from
		 *         corona_vaccine coronavacc0_
		 *     where
		 *         coronavacc0_.country not in  (
		 *             ?
		 *         )
		 * CoronaVaccine{registerNo=1, name='covieshield', country='INd', company='serum', price=450.0, requiredDoseCount=2}
		 * CoronaVaccine{registerNo=2, name='covieshield', country='IND', company='Fizer', price=450.0, requiredDoseCount=2}
		 */
	}
}

