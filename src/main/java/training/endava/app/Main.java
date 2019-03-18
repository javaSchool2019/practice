package training.endava.app;

import training.endava.app.domain.entity.PhoneNumber;
import training.endava.app.repository.jparepository.PhoneNumberRepositoryImp;

public class Main {

    public static void main(String[] args) {
        PhoneNumberRepositoryImp phoneNumberRepository = new PhoneNumberRepositoryImp();

        phoneNumberRepository.add(new PhoneNumber("0746542634Test"));
    }
}
