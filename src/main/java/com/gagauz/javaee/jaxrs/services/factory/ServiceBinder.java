package com.gagauz.javaee.jaxrs.services.factory;

import com.gagauz.javaee.jaxrs.services.SomeBeanService;
import org.glassfish.hk2.api.Factory;
import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.process.internal.RequestScoped;

public class ServiceBinder extends AbstractBinder {

    public static class SomeBeanServiceFactory implements Factory<SomeBeanService> {

        @Override
        public SomeBeanService provide() {
            return new SomeBeanService();
        }

        @Override
        public void dispose(SomeBeanService instance) {
        }
    }

    @Override
    protected void configure() {
        bindFactory(SomeBeanServiceFactory.class).to(SomeBeanService.class)
                .proxy(true).proxyForSameScope(false).in(RequestScoped.class);
    }

}
