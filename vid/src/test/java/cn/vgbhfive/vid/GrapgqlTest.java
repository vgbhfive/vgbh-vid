package cn.vgbhfive.vid;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * @time:
 * @author: Vgbh
 */
@SpringBootTest
@RunWith(SpringRunner.class)
public class GrapgqlTest {

    @Test
    public void graphqlTest () {
        String schema = "type Query {hello: String}";

    }



}
