package dao;

import me.myProjects.microservice.core.controller.RestfulController;
import me.myProjects.microservice.core.dao.UserDao;
import me.myProjects.microservice.core.entry.ApplicationConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

/**
 * Created by chendong on 2017/4/17.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration("classpath:application.xml")
@ContextConfiguration(classes = ApplicationConfig.class)
public class RestControlTest {

    @Mock
    private UserDao userDao;

    @InjectMocks
    private RestfulController controller;

    @Test
    public void test() throws InterruptedException {

        controller.restTest();
    }


}
