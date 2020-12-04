package aspect;

import bean.UserInfo;
import com.google.gson.Gson;
import org.aopalliance.intercept.MethodInterceptor;
import org.aopalliance.intercept.MethodInvocation;

public class LogAspect implements MethodInterceptor {

        public Object invoke(MethodInvocation invocation) throws Throwable {

            System.out.println("==================Logging====================");
            for (Object a:invocation.getArguments()){
                System.out.println(new Gson().toJson(a));
            }
            Object res = invocation.proceed();
            System.out.println("Retour de la méthode " + new Gson().toJson(res));
            System.out.println("==================End Logging====================");
            return res;

        }
    }

