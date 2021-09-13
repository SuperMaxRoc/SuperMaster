package com.roc.SuperMaster.utility.lambda;

import com.roc.SuperMaster.utility.lambda.pojo.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Optional;

/**
 * @author WP
 * @version 1.0
 * @Date 2021/9/13 21:24
 * @ClassName OptionalUtil.class
 * @Description OptionalUtil
 * @UpdateUser Roc
 */
@Slf4j
public class OptionalUtil {


    /**
     * power From https://zhuanlan.zhihu.com/p/125758212
     */

    /**
     * @param
     * @Author: WP
     * @Date: 2021/9/13 21:46
     * @Version 1.0
     * @Description: Optional.of：判断目标值是否存在，否则抛出空指针异常
     * @UpdateUser WP
     */
    @Test
    public void optionalTest01() {
        User user01 = new User();
        User user02 = new User();
        User user03 = null;

        user01.setId("1");
        user01.setName("张三");

        Optional<User> user011 = Optional.of(user01);
        Optional<User> user021 = Optional.of(user02);
        System.out.println("user011:" + user011.toString());
        System.out.println("user021:" + user021.toString());
        Optional<User> user031 = Optional.of(user03);
    }

    /**
     * @param
     * @return void
     * @Author: WP
     * @Date: 2021/9/13 23:19
     * @Version 1.0
     * @Description: Optional.ofNullable：返回一个Optional描述的指定值，如果为空，则返回Optional。
     * @UpdateUser WP
     */
    @Test
    public void optionalTest02() {
        User user01 = new User();
        User user02 = new User();
        User user03 = null;

        user01.setId("1");
        user01.setName("张三");

        Optional<User> user011 = Optional.ofNullable(user01);
        Optional<User> user021 = Optional.ofNullable(user02);
        Optional<User> user031 = Optional.ofNullable(user03);
        System.out.println("user011:" + user011.toString());
        System.out.println("user021:" + user021.toString());
        System.out.println("user031:" + user031.toString());
        //可以抛出自定义异常
        Optional.ofNullable(user03).orElseThrow(() -> new NullPointerException());
    }

    /**
     * @param
     * @return void
     * @Author: WP
     * @Date: 2021/9/13 23:22
     * @Version 1.0
     * @Description: Optional.ofNullable.get：如果Optional存在一个值，则返回，不存在则抛出NoSuchElementException。
     * @UpdateUser WP
     */
    @Test
    public void optionalTest03() {
        User user01 = new User();
        User user02 = null;
        user01.setId("001");
        User user011 = Optional.ofNullable(user01).get();
        System.out.println(user011);
        User user022 = Optional.ofNullable(user02).get();
        //报错：java.util.NoSuchElementException: No value present
        System.out.println(user022);
    }

    /**
     * @param
     * @return void
     * @Author: WP
     * @Date: 2021/9/13 23:28
     * @Version 1.0
     * @Description: Optional.ofNullable.isPresent：如果有值返回true，如果为null返回false。
     * @UpdateUser WP
     */
    @Test
    public void optionalTest04() {
        User user01 = new User();
        User user02 = null;
        user01.setId("001");
        boolean present01 = Optional.ofNullable(user01).isPresent();
        System.out.println(present01);
        boolean present02 = Optional.ofNullable(user02).isPresent();
        //false
        System.out.println(present02);
    }

    /**
     * @Author: WP
     * @Date: 2021/9/13 23:36
     * @Version 1.0
     * @Description: Optional.ofNullable.ifPresent:可以检测是否为null，同时该方法还可以接受一个Consumer参数。
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void optionalTest05() {
        User user = new User();
        Optional.ofNullable(user).ifPresent(user01 -> user01.setId("001"));
        System.out.println(user.getId());
    }

    /**
     * @Author: WP
     * @Date: 2021/9/13 23:38
     * @Version 1.0
     * @Description: Optional.ofNullable.orElse:目标值为空，返回other
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void optionalTest06() {
        User user01 = new User();
        User user02 = null;

        user01.setId("我是user01");
        User user = Optional.ofNullable(user02).orElse(user01);
        System.out.println(user);
    }

    /**
     * @Author: WP
     * @Date: 2021/9/13 23:52
     * @Version 1.0
     * @Description: Optional.ofNullable.orElseGet:如果有值则返回，没有则调用Supplier函数，并返回。
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void optionalTest07() {
        User user01 = new User();
        user01.setId("我是user01");
        User user02 = null;
        User user = Optional.ofNullable(user02).orElseGet(User::new);
        System.out.println(user);

        User user1 = Optional.ofNullable(user02).orElseGet(() -> user01);
        System.out.println(user1);
    }

    /**
     * @Author: WP
     * @Date: 2021/9/13 23:59
     * @Version 1.0
     * @Description: ToDo
     * @UpdateUser WP
     * @param  
     * @return void
     */
    @Test
    public void optionalTest08() {
        User user01 = new User();
        user01.setId("这是user01");
        User user02 = new User();
        user02.setId("这是user02");
        user02.setName("这是user");

        Optional<String> s = Optional.ofNullable(user01).map(User::getName);
        String s1 = s.orElse("zhangsan@123.com");
        System.out.println(s1);

        String s2 = Optional.ofNullable(user02).map(user -> user.getName()).orElse("这不是User");
        System.out.println(s2);
    }

    /**
     * @Author: WP
     * @Date: 2021/9/14 0:07
     * @Version 1.0
     * @Description: Optional.ofNullable.flatMap
     * @UpdateUser WP
     * @param  
     * @return void
     */
    @Test
    public void optionalTest09() {
        User user = new User();
        user.setId("这是user");
//        Object o = Optional.ofNullable(user).flatMap(user01 -> user01.getId()).orElse("不存在");
    }


    /**
     * @Author: WP
     * @Date: 2021/9/14 0:14
     * @Version 1.0
     * @Description: Optional.ofNullable.filter
     * @UpdateUser WP
     * @param
     * @return void
     */
    @Test
    public void optionalTest10() {
        User user = new User();
        user.setId("id");
        user.setName("name");
        User aThrow = Optional.ofNullable(user).filter(user1 -> user1.getName().equals("name") || user1.getId().equals("id")).orElseThrow(() -> new NullPointerException());
        User bThrow = Optional.ofNullable(user).filter(user1 -> user1.getName().equals("name") && user1.getId().equals("d")).orElseThrow(() -> new NullPointerException());
        System.out.println(bThrow);
    }


}
