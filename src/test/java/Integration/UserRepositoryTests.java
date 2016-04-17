package Integration;

import app.DimoApplication;
import app.entities.User;
import app.repositories.UserRepository;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;


@RunWith ( SpringJUnit4ClassRunner.class )
@SpringApplicationConfiguration ( classes = DimoApplication.class )
@Transactional
public class UserRepositoryTests
{

    @Autowired
    private UserRepository userRepository;
    private User user;

    @Before
    public void setUp ()
    {
        this.user = new User();
        user.setUsername( "pambos" );
        user.setPassword( "pambosrawpw" );
        user.setEmail( "pambos@pambos.gr" );
    }

    @Test
    public void saveUserAndFindById ()
    {
        this.userRepository.save( this.user );
        assertThat( this.userRepository.findOne( this.user.getId() ), is( this.user ) );
    }

    @Test
    public void saveUserAndFindByUsername ()
    {
        this.userRepository.save( this.user );
        assertThat( this.userRepository.findByUsername( this.user.getUsername() ), is( this.user ) );
    }

    @Test
    public void saveUserAndFindByEmail ()
    {
        this.userRepository.save( this.user );
        assertThat( this.userRepository.findByEmail( this.user.getEmail() ), is( this.user ) );
    }
}