package com.gagauz.javaee.jaxrs.endpoint.provider;

import org.glassfish.jersey.server.validation.ValidationConfig;
import org.glassfish.jersey.server.validation.internal.InjectingConstraintValidatorFactory;

import javax.validation.ParameterNameProvider;
import javax.validation.Validation;
import javax.ws.rs.container.ResourceContext;
import javax.ws.rs.core.Context;
import javax.ws.rs.ext.ContextResolver;
import javax.ws.rs.ext.Provider;

import java.lang.reflect.Constructor;
import java.util.Arrays;

@Provider
public class ValidationConfigurationContextResolver implements ContextResolver<ValidationConfig> {

    @Context
    private ResourceContext resourceContext;

    @Override
    public ValidationConfig getContext(final Class<?> type) {
        final ValidationConfig config = new ValidationConfig();
        config.setConstraintValidatorFactory(resourceContext.getResource(InjectingConstraintValidatorFactory.class));
        config.setParameterNameProvider(new CustomParameterNameProvider());
        return config;
    }

    /**
     * See ContactCardTest#testAddInvalidContact.
     */
    private class CustomParameterNameProvider implements ParameterNameProvider {

        private final ParameterNameProvider nameProvider;

        public CustomParameterNameProvider() {
            nameProvider = Validation.byDefaultProvider().configure().getDefaultParameterNameProvider();
        }

        @Override
        public List<String> getParameterNames(final Constructor<?> constructor) {
            return nameProvider.getParameterNames(constructor);
        }

        @Override
        public List<String> getParameterNames(final Method method) {
            // See ContactCardTest#testAddInvalidContact.
            if ("addContact".equals(method.getName())) {
                return Arrays.asList("contact");
            }
            return nameProvider.getParameterNames(method);
        }
    }
}
