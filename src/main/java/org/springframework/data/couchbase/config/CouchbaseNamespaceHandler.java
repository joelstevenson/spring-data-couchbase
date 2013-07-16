/*
 * Copyright 2013 the original author or authors.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.springframework.data.couchbase.config;

import org.springframework.beans.factory.xml.NamespaceHandlerSupport;
import org.springframework.data.couchbase.repository.config.CouchbaseRepositoryConfigurationExtension;
import org.springframework.data.repository.config.RepositoryBeanDefinitionParser;
import org.springframework.data.repository.config.RepositoryConfigurationExtension;

/**
 * {@link org.springframework.beans.factory.xml.NamespaceHandler} for Couchbase configuration.
 *
 * @author Michael Nitschinger
 */
public class CouchbaseNamespaceHandler extends NamespaceHandlerSupport {

  public void init() {
    RepositoryConfigurationExtension extension = new CouchbaseRepositoryConfigurationExtension();
    RepositoryBeanDefinitionParser repositoryBeanDefinitionParser = new RepositoryBeanDefinitionParser(extension);

    registerBeanDefinitionParser("repositories", repositoryBeanDefinitionParser);
    registerBeanDefinitionParser("mongo", new CouchbaseParser());
    registerBeanDefinitionParser("jmx", new CouchbaseJmxParser());
    registerBeanDefinitionParser("template", new CouchbaseTemplateParser());
  }

}