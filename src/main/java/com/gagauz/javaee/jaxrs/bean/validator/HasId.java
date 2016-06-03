package com.gagauz.javaee.jaxrs.bean.validator;

import com.gagauz.javaee.jaxrs.bean.SomeBean;

import javax.validation.Constraint;
import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import javax.validation.Payload;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.util.List;

@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = { HasId.Validator.class, HasId.ListValidator.class })
public @interface HasId {

    String message() default "{org.glassfish.jersey.examples.beanvalidation.webapp.constraint.HasId.message}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

    public class Validator implements ConstraintValidator<HasId, SomeBean> {
        @Override
        public void initialize(final HasId hasId) {
        }

        @Override
        public boolean isValid(final SomeBean contact, final ConstraintValidatorContext constraintValidatorContext) {
            return contact == null || contact.getName() != null;
        }
    }

    public class ListValidator implements ConstraintValidator<HasId, List<SomeBean>> {
        private Validator validator = new Validator();

        @Override
        public void initialize(final HasId hasId) {
        }

        @Override
        public boolean isValid(final List<SomeBean> contacts, final ConstraintValidatorContext constraintValidatorContext) {
            boolean isValid = true;
            for (final SomeBean contactCard : contacts) {
                isValid &= validator.isValid(contactCard, constraintValidatorContext);
            }
            return isValid;
        }
    }
}
