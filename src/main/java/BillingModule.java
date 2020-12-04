import aspect.CheckUser;
import aspect.Log;
import aspect.LogAspect;
import aspect.UserCheckAspect;
import ccprocessors.CreditCardProcessor;
import ccprocessors.PaypalCreditCardProcessor;
import com.google.inject.AbstractModule;
import com.google.inject.matcher.Matchers;
import logger.DatabaseTransactionLog;
import logger.TransactionLog;

/**
 * Created by tourfade on 17-11-29.
 */
public class BillingModule extends AbstractModule {
    @Override
    protected void configure() {
        // binding matcher to the annotated method invocation
        bindInterceptor(Matchers.any(),
                        Matchers.annotatedWith(CheckUser.class),
                        new UserCheckAspect());

        bindInterceptor(Matchers.any(),
                Matchers.annotatedWith(Log.class),
                new LogAspect());

        bind(TransactionLog.class).to(DatabaseTransactionLog.class);
        bind(CreditCardProcessor.class).to(PaypalCreditCardProcessor.class);


    }
}
