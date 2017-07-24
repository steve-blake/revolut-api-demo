package com.revolut.api.demo;

import com.revolut.api.demo.model.Account;
import com.revolut.api.demo.model.AccountDAO;
import io.javalin.Javalin;

/**
 * Hello world!
 *
 */
public class App
{
    public static void main( String[] args )
    {

        //Javalin app = Javalin.create().port(7000);
        //app.get("/", ctx -> ctx.result("Hello World"));

        AccountDAO dao = new AccountDAO();

        dao.getAllAccounts();
        System.out.println( dao.getAllAccounts() );

        Account acc = new Account();

        System.out.println(acc.getBalance(01));

    }
}


/*public class App {
    public static void main(String[] args) {
        get("/hello", (req, res) -> "Hello World");
    }
}*/
