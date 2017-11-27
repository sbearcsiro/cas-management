package org.apereo.cas.mgmt.web

import org.apereo.cas.configuration.CasConfigurationProperties
import org.springframework.boot.actuate.autoconfigure.MetricsDropwizardAutoConfiguration
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.autoconfigure.aop.AopAutoConfiguration
import org.springframework.boot.autoconfigure.groovy.template.GroovyTemplateAutoConfiguration
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration
import org.springframework.boot.autoconfigure.jersey.JerseyAutoConfiguration
import org.springframework.boot.autoconfigure.jmx.JmxAutoConfiguration
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration
import org.springframework.boot.builder.SpringApplicationBuilder
import org.springframework.boot.context.properties.EnableConfigurationProperties
import org.springframework.context.annotation.EnableAspectJAutoProxy
import org.springframework.context.annotation.Import

/**
 * This is [CasManagementWebApplication].
 *
 * @author Misagh Moayyed
 * @since 5.0.0
 */
@SpringBootApplication(exclude = arrayOf(HibernateJpaAutoConfiguration::class, JerseyAutoConfiguration::class, GroovyTemplateAutoConfiguration::class, DataSourceAutoConfiguration::class, JmxAutoConfiguration::class, MetricsDropwizardAutoConfiguration::class))
@Import(value = AopAutoConfiguration::class)
@EnableConfigurationProperties(CasConfigurationProperties::class)
@EnableAspectJAutoProxy(proxyTargetClass = true)
class CasManagementWebApplication
/**
 * Instantiates a new web application.
 */
constructor() {
    companion object {

        /**
         * Main entry point of the web application.
         *
         * @param args the args
         */
        @JvmStatic
        fun main(args: Array<String>) {
            SpringApplicationBuilder(CasManagementWebApplication::class.java).banner(CasManagementBanner()).run(*args)
        }
    }
}
