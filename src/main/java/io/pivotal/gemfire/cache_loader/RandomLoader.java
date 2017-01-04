/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.pivotal.gemfire.cache_loader;

import org.apache.geode.LogWriter;
import org.apache.geode.cache.CacheLoader;
import org.apache.geode.cache.LoaderHelper;
import org.apache.geode.cache.Declarable;
import org.apache.geode.cache.CacheLoaderException;
import org.apache.geode.distributed.internal.InternalDistributedSystem;

import org.springframework.core.SpringVersion;
import java.util.Properties;

public class RandomLoader implements Declarable, CacheLoader<String, String> {
  public static void main(String a[]) {
  }

  @Override
  public void init(Properties arg0) {

  }

  @Override
  public void close() {
    // TODO Auto-generated method stub
  }

  @Override
  public String load(LoaderHelper<String, String> loadHelper) throws CacheLoaderException {
    String key = loadHelper.getKey();
    LogWriter log = InternalDistributedSystem.getAnyInstance().getLogWriter();

    String version = SpringVersion.getVersion();

    log.config("RandomLoader: key is -> " + key + ". value -> " + version);
    return version;
  }
}
