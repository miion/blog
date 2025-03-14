package org.mion.blog.starter.base.http.configuration

import org.springframework.beans.factory.config.BeanDefinition
import org.springframework.beans.factory.config.BeanFactoryPostProcessor
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory
import org.springframework.core.env.Environment
import org.springframework.objenesis.instantiator.util.ClassUtils
import org.springframework.stereotype.Component

@Component
class HttpInterfaceFactoryBeanFactoryPostProcessor : BeanFactoryPostProcessor {
    override fun postProcessBeanFactory(beanFactory: ConfigurableListableBeanFactory) {
        val beanDefinitions: Set<BeanDefinition> = HttpInterfaceClassFinder()
            .findBeanDefinitions(beanFactory.getBean(Environment::class.java))

        val httpInterfaceFactory = SimpleHttpInterfaceFactory()

        beanDefinitions.stream()
            .filter { !it.beanClassName.isNullOrEmpty() }
            .forEach { findClassAndRegisterAsSingletonBean(beanFactory, httpInterfaceFactory, it) }
    }

    private fun findClassAndRegisterAsSingletonBean(
        beanFactory: ConfigurableListableBeanFactory,
        factory: SimpleHttpInterfaceFactory,
        beanDefinition: BeanDefinition
    ) {
        beanDefinition.beanClassName?.let {
            beanFactory.registerSingleton(
                it,
                factory.create(findHttpInterfaceClass(beanDefinition))
            )
        }
    }

    private fun findHttpInterfaceClass(beanDefinition: BeanDefinition): Class<Any> {
        try {
            return ClassUtils.getExistingClass(this::class.java.getClassLoader(), beanDefinition.beanClassName)
        } catch (e: ClassNotFoundException) {
            throw IllegalStateException(e)
        }
    }
}