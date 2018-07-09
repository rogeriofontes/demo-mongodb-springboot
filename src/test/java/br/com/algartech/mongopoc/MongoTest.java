//http://zetcode.com/springboot/mongodb/

/*package br.com.algartech.mongopoc;

import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Example;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.uaijug.demomongo.model.domain.User;
import br.com.uaijug.demomongo.model.repository.UserRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class MongoTest {

    @Autowired
    UserRepository repository;

    User china, india, usa, indonesia, brazil, pakistan;

    static final int NUMBER_OF_COUNTRIES = 6;

    @Before
    public void init() {

        repository.deleteAll();

        this.china = repository.save(new User("China", 1382050000));
        this.india = repository.save(new User("India", 1313210000));
        this.usa = repository.save(new User("USA", 324666000));
        this.indonesia = repository.save(new User("Indonesia", 260581000));
        this.brazil = repository.save(new User("Brazil", 207221000));
        this.pakistan = repository.save(new User("Pakistan", 196626000));
    }

    @Test
    public void countAllCountries() {

        List<User> countries = repository.findAll();
        assertEquals(NUMBER_OF_COUNTRIES, countries.size());
    }

    @Test
    public void countOneUser() {

        Example<User> example = Example.of(new User("China", 1382050000));

        assertThat(repository.count(example)).isEqualTo(1L);
    }

    @Test
    public void setsIdOnSave() {

        User nigeria = repository.save(new User("Nigeria", 186988000));
        assertThat(nigeria.getId()).isNotNull();
    }

    @Test
    public void findOneUser() {

        Example<User> example = Example.of(new User("India", 1313210000));

        User country = repository.findOne(example);
        assertThat(country.getName()).isEqualTo("India");
    }
}*/