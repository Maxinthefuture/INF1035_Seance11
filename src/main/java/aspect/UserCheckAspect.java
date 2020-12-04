package aspect;

import bean.UserInfo;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class UserCheckAspect implements MethodInterceptor {

        public Object invoke(MethodInvocation invocation) throws Throwable {
            UserInfo user = (UserInfo) invocation.getArguments()[0];
            if(user.getUserID()%2 == 0){
                System.out.println("->User ("+user+") successfully identified. Allowing transaction");

                Object a = invocation.proceed();
                return a;

            }
            System.out.println("->Failed to identify user ("+user+"). Stopping transaction");

            return null;

        }
    }

