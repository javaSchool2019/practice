package training.endava.app.Hibernate.serviceHibernate;

import training.endava.app.Hibernate.domainHibernate.Company;
import training.endava.app.Hibernate.repositoryHibernate.CompanyRepository;

import java.util.List;

public class CompanyService {
    private CompanyRepository repo = new CompanyRepository();

    public Company getById (int id){
        return repo.getById(id);
    }

    public List<Company> all (){
        return repo.all();
    }

    public Company add(Company entity){
        return repo.add(entity);
    }

    public boolean update (Company entity){
        return repo.update(entity);
    }

    public boolean deleteById (int id){
        return repo.deleteById(id);
    }
}
