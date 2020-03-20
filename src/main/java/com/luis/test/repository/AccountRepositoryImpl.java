package com.luis.test.repository;

import com.luis.test.domain.Account;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import javax.persistence.EntityManager;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.ParameterExpression;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.Optional;

@Repository
public class AccountRepositoryImpl {

    EntityManager entityManager;

    public AccountRepositoryImpl(EntityManager entityManager) {
        this.entityManager = entityManager;
    }

    public Object findByIdNumber(Class Account, Integer idNumber)
    {
        CriteriaBuilder criteriaBuilder = entityManager.getCriteriaBuilder();
        CriteriaQuery<Object> criteriaQuery = criteriaBuilder.createQuery(Account);
        Root<Object> root = criteriaQuery.from(Account);
        criteriaQuery.select(root);

        ParameterExpression<Integer> params = criteriaBuilder.parameter(Integer.class);
        criteriaQuery.where(criteriaBuilder.equal(root.get("idNumber"), params));

        TypedQuery<Object> query = entityManager.createQuery(criteriaQuery);
        query.setParameter(params, idNumber);

        List<Object> queryResult = query.getResultList();

        Object returnObject = null;

        if (queryResult != null && queryResult.size() > 0) {
            returnObject = queryResult.get(0);
        }

        return returnObject;
    }
}
