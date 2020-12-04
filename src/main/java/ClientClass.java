import bean.UserInfo;
import com.google.inject.Guice;
import com.google.inject.Inject;
import com.google.inject.Injector;

/**
 * Created by tourfade on 17-11-29.
 */
public class ClientClass {
    static BillingService billingService;
    static {
        Injector injector = Guice.createInjector(new BillingModule());
         billingService = injector.getInstance(BillingService.class);
    }

    public static void main(String[] args) {

        ClientClass cc = new ClientClass();
        cc.showServiceName(billingService);

        System.out.println("*****====Order1=====*******");
        UserInfo mathias = new UserInfo("Mathias bergeron",1);
        billingService.order(mathias, new Object());

        System.out.println("\n*****====Order2=====*******");
        UserInfo annie = new UserInfo("Annie Cloutier",2);

        billingService.order(annie, new Object());

    }
    public void showServiceName(BillingService billingService){
        System.out.println("The biling service "+billingService+"\n\n");


    }
}
