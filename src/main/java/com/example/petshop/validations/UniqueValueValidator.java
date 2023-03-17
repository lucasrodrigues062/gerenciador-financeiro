package com.example.petshop.validations;

import java.util.List;

import org.springframework.util.Assert;

import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.Query;
import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UniqueValueValidator implements ConstraintValidator<UniqueValue, Object> {

  private String atributo;

  private Class<?> klass;

  @PersistenceContext
  private EntityManager manager;

  @Override
  public void initialize(UniqueValue constraintAnnotation) {
    atributo = constraintAnnotation.fieldName();
    klass = constraintAnnotation.domainClass();
  }

  @Override
  public boolean isValid(Object value, ConstraintValidatorContext constraintValidatorContext) {
    Query query = manager.createQuery("select 1 from " + klass.getName() + " where " + atributo + " = :value");
    query.setParameter("value", value);
    List<?> list = query.getResultList();
    // Assert.state(list.size() <= 1, "Existe mais de um " + klass + " com o atributo " + atributo + " = " + value);
    return list.isEmpty();
  }

  
}
