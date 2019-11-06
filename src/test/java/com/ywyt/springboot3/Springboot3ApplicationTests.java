package com.ywyt.springboot3;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class Springboot3ApplicationTests {

    @Value("${queue-name}")
    public String queueName;

	@Test
	public void contextLoads() {
        System.out.println("test");
    }

    /*@Test
    public void testBook() {
        Book book = new Book("01", "zhanagasn", "lisi", "2019-09-12");
        book.setTitle("test");
        System.out.println(book.toString());
        System.out.println(book.getAuthor());

    }*/

    @Test
    public void testMQConf() {
        System.out.println(queueName);
    }

}
