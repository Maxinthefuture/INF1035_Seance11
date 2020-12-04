import aspect.CheckUser;
import aspect.Log;
import bean.UserInfo;
import ccprocessors.CreditCardProcessor;
import com.google.inject.Inject;
import logger.TransactionLog;

import java.util.UUID;

/**
 * Created by tourfade on 17-11-29.
 */
class BillingService {
    @Inject private CreditCardProcessor processor;
    @Inject private TransactionLog transactionLog;

    @Inject
    BillingService(){}

    @CheckUser
    @Log
    public void order(UserInfo userInfo, Object order){
        // Simulating hard work by printing text.
        System.out.println("\tProcessisng the transaction of "+userInfo+" ...");

        //System.out.println("\tEnd of the transaction.. recipe: "+ UUID.randomUUID());
    }

    @Override
    public String toString(){
        return "Processing Card using "+processor.getClass() + " using logger "+transactionLog.getClass();
    }
}