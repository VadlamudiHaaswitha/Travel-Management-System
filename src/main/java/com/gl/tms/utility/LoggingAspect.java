package com.gl.tms.utility;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;


@Component
@Aspect
public class LoggingAspect {
    private static Log LOGGER = LogFactory.getLog(LoggingAspect.class.getName());

    //    @AfterThrowing(pointcut = "execution(public com.gl.lms.Service.LibraryManagementSystemServiceImpl" +
//            ".addUserAndIssueLibraryCard(UsersDTO usersDTO))", throwing = "ex")
    @AfterThrowing(pointcut = "execution(* com.gl.tms.Service.*Impl.*(..))",throwing = "ex")
    public void logException(Exception ex) {
        LOGGER.error(ex);
    }
}
