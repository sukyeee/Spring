package com.mycom.more.config;

import java.util.Collections;

import org.springframework.aop.Advisor;
import org.springframework.aop.aspectj.AspectJExpressionPointcut;
import org.springframework.aop.support.DefaultPointcutAdvisor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.transaction.TransactionManager;
import org.springframework.transaction.interceptor.MatchAlwaysTransactionAttributeSource;
import org.springframework.transaction.interceptor.RollbackRuleAttribute;
import org.springframework.transaction.interceptor.RuleBasedTransactionAttribute;
import org.springframework.transaction.interceptor.TransactionInterceptor;

@Configuration
public class TransactionAspect {

	 	private static final String txName="studentService";
	    private static final String txPointCut ="execution (* com.mycom.more..service.*Impl.*(..) )";

	    @Autowired
	    private TransactionManager transactionManager;

	    // transaction 관련설정
	    @Bean
	    public TransactionInterceptor txInterceptor(){
	        MatchAlwaysTransactionAttributeSource source = new MatchAlwaysTransactionAttributeSource();
	        RuleBasedTransactionAttribute transactionAttribute = new RuleBasedTransactionAttribute();
	        transactionAttribute.setName(txName);
	        transactionAttribute.setRollbackRules(Collections.singletonList(new RollbackRuleAttribute(Exception.class)));
	        source.setTransactionAttribute(transactionAttribute);

	        return new TransactionInterceptor(transactionManager, source);
	    }

	    // AOP 관련 설정
	    @Bean
	    public Advisor transactionAdviceAdvisor(){
	        AspectJExpressionPointcut pointcut = new AspectJExpressionPointcut();
	        pointcut.setExpression(txPointCut);
	        return new DefaultPointcutAdvisor(pointcut, txInterceptor());
	    }
}
